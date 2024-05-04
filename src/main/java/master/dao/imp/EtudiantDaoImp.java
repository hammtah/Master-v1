package master.dao.imp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import master.beans.Etudiant;
import master.dao.factory.OraFactory;
import master.dao.interfaces.EtudiantDao;

public class EtudiantDaoImp implements EtudiantDao{
	//addEtudiant est une methode responsable à l'ajout d'un etudiant passé en parametre
	//elle retourne true si le processus de l'ajout de l'étudiant est completé avec succes
	//et false si elle rencontre des problemes lors de l'insertion 
	//La démarche se fait en deux partie, la premiere est l'insertion des informations de l'étudiant dans la table 'etudiant_v'
	//et la deuxieme est l'insertion des info_accadémiques.
	public boolean addEtudiant(Etudiant e) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		//connect to DB
		try {
			conn = OraFactory.getConnection();
			conn.setAutoCommit(false);
		}catch(SQLException sqe) {}
		
		try {
			//Insertion dans tableau etudiant_v
			pst = conn.prepareStatement("INSERT INTO etudiant_v VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
			pst.setString(1, e.getNom());
			pst.setString(2, e.getPrenom());
			pst.setDate(3, java.sql.Date.valueOf(e.getDateNaissance()));
			pst.setString(4, e.getSexe());
			pst.setString(5, e.getTel());
			pst.setString(6, e.getEmail());
			pst.setString(7, e.getPassword());
			pst.setString(8, e.getNationalite());
			pst.setString(9, e.getCin());
			pst.setString(10, e.getMassar());
			
			int rowsAffected1 = pst.executeUpdate() ;
			if(rowsAffected1 < 1) {
				//annuler la transaction si aucune ligne n'est affectée
				conn.rollback();
				//fermer la connection
				try {
					if(conn != null ) conn.close();
					if(pst != null ) pst.close();
				}catch(SQLException sqe) {}
				//sortir de la methode avec un return false qui veut dire que l'etudiant n'est pas ajouté
				return false;
			}
				
			//recuperant la valeur courante de la sequence (etudiant_seq) qui contient l'id de l'etudiant 
			rs = conn.createStatement().executeQuery("SELECT etudiant_seq.CURRVAL FROM DUAL");
			rs.next();
			e.setId(rs.getInt(1));
				
			//donnant des valeurs temporaires à l'id de faculté et l'id filLisence et l'id de filBac(cette phase est temporaire)
			e.setIdFilLicense(1); e.setIdFaculte(1);
				
			//remplissage des info accademiques
			pst = null;
			pst = conn.prepareStatement("INSERT INTO info_accademique_v VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
			pst.setDate(1, java.sql.Date.valueOf(e.getDateGraduation()));
			pst.setDate(2, java.sql.Date.valueOf(e.getDateBac()));
			pst.setString(3, e.getFilBac());
			pst.setInt(4, e.getMoyLicense());
			pst.setInt(5, e.getMoyBac());
			pst.setInt(6, e.getNoteS1());
			pst.setInt(7, e.getNoteS2());
			pst.setInt(8, e.getNoteS3());
			pst.setInt(9, e.getNoteS4());
			pst.setInt(10, e.getNoteS5());
			pst.setInt(11, e.getNoteS6());
			//insertion des fichiers
			try {
				pst.setBinaryStream(12, e.getPhoto().getInputStream(), (int)  e.getPhoto().getSize());
		        pst.setBinaryStream(13, e.getDocs().getInputStream(), (int)  e.getDocs().getSize());
			}catch(IOException io) {
				io.printStackTrace();
			}
		    //suite
		    pst.setInt(14, e.getIdFilLicense());
			pst.setInt(15, e.getId());
			pst.setInt(16, e.getIdFaculte());

			int rowsAffected2 = pst.executeUpdate() ;
			//si aucune ligne n'est affecté alors faire un rollback puis fermer la connection et sortir de la methode
			if(rowsAffected2 < 1) {
				conn.rollback();
				try {
					if(conn != null ) conn.close();
					if(pst != null ) pst.close();
				}catch(SQLException sqe) {}
				return false;
			}	
				
			//si tout est passé correctement alors valider la transaction, fermer la connection et retourner 'true' i.e l'etudiant est ajouté avec succes
			conn.commit();
			
		}catch(SQLException sqe) {}
		
		try {
			if(conn != null ) conn.close();
			if(pst != null ) pst.close();
		}catch(SQLException sqe) {}
		
		return true;

	}

}

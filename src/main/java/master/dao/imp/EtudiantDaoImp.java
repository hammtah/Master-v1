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
	public boolean addEtudiant(Etudiant e) {
		Connection conn = null;
		PreparedStatement pst = null;
		Statement st = null;
		ResultSet rs = null;
		boolean isAdded = false;
		
		try {
			conn = OraFactory.getConnection();
			conn.setAutoCommit(false);
		}catch(SQLException sqe) {}
		
		try {
			//note: create etudiant_v, the view for the etudiant table (instead of insert make a sequence)
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
			if(rowsAffected1 < 0) {
				conn.rollback();
				return false;
			}
			//remplissage du tableau info académiques
				
			//recuperant la valeur courante de la sequence (etudiant_seq) qui contient l'id de l'etudiant à fin de remplir le foreign key de l'info-académique
				st = conn.createStatement();
				rs = st.executeQuery("SELECT etudiant_seq.CURRVAL FROM DUAL");
				rs.next();
				e.setId(rs.getInt(1));
				//donnant des valeurs temporaires à l'id de faculté et l'id filLisence et l'id de filBac(cette phase est temporaire)
				e.setFilBac("Sciences I."); e.setIdFilLicense(1); e.setIdFaculte(1);
				//remplissage des info acad.
				pst = null;
				pst = conn.prepareStatement("INSERT INTO info_accademique_v VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
				pst.setDate(1, java.sql.Date.valueOf(e.getDateGraduation()));
				pst.setString(2, e.getDateBac());
				pst.setString(3, e.getFilBac());
				pst.setInt(4, e.getMoyLicense());
				pst.setInt(5, e.getMoyBac());
				pst.setInt(6, e.getNoteS1());
				pst.setInt(7, e.getNoteS2());
				pst.setInt(8, e.getNoteS3());
				pst.setInt(9, e.getNoteS4());
				pst.setInt(10, e.getNoteS5());
				pst.setInt(11, e.getNoteS6());
				try {
		            pst.setBinaryStream(12, e.getPhoto().getInputStream(), (int)  e.getPhoto().getSize());
		            pst.setBinaryStream(13, e.getDocs().getInputStream(), (int)  e.getDocs().getSize());
				}catch(IOException io) {
					io.printStackTrace();
				}
		        
		        pst.setInt(14, e.getIdFilLicense());
				pst.setInt(15, e.getId());
				pst.setInt(16, e.getIdFaculte());

				int rowsAffected2 = pst.executeUpdate() ;
				if(rowsAffected2 < 0) {
					conn.rollback();
					return false;
				}	
				
			conn.commit();
			isAdded = true;
			
			//en cas d'échec d'insertion
						
		}catch(SQLException sqe) {}
		
		try {
			if(conn != null ) conn.close();
			if(pst != null ) pst.close();
		}catch(SQLException sqe) {}
		
		return isAdded;


	}

}

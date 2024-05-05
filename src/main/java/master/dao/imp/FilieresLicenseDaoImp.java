package master.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import master.beans.FilieresLicense;
import master.dao.factory.OraFactory;
import master.dao.interfaces.FilieresLicenseDao;

public class FilieresLicenseDaoImp implements FilieresLicenseDao{
	public List<FilieresLicense> getFilieresLicense(){
		Connection conn = null;
		ResultSet rs = null;
		Statement st = null;
		List<FilieresLicense> filieres = new ArrayList<FilieresLicense>();

		//connect to DB
		try {
			conn = OraFactory.getConnection();
			conn.setAutoCommit(false);
		}catch(SQLException sqe) {}
		
		//function core
		try {
			//Query things
			String getFilieresQuery = "SELECT * FROM filiere";
			st = conn.createStatement();
			rs = st.executeQuery(getFilieresQuery);
			//storing data
			while(rs.next()) {
				FilieresLicense fl = new FilieresLicense();
				fl.setId_filiere(rs.getInt(1));
				fl.setNom(rs.getString(2));
				fl.setSurnom(rs.getString(3));
				filieres.add(fl);
			}

		}catch(SQLException sqe) {}
		
		//close connections
		try {
			if(conn != null ) conn.close();
			if(st != null ) st.close();
		}catch(SQLException sqe) {}
		
		//return the list 
		return filieres;
	}
}
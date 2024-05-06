package master.dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import master.beans.Facultes;
import master.dao.exception.EtudiantDaoException;
import master.dao.factory.OraFactory;
import master.dao.interfaces.FacultesDao;

public class FacultesDaoImp implements FacultesDao{
	
	public List<Facultes> getAllFacultes() throws EtudiantDaoException{

		Connection conn = null;
		ResultSet rs = null;
		Statement st = null;
		List<Facultes> facultes = new ArrayList<Facultes>();

		//connect to DB
		try {
			conn = OraFactory.getConnection();
			conn.setAutoCommit(false);
		}catch(SQLException sqe) {
			throw new EtudiantDaoException("Un problème est survenu lors de la connection avec la Base de donné");
		}
		
		//function core
		try {
			//Query things
			String getFacultesQuery = "SELECT * FROM facultes";
			st = conn.createStatement();
			rs = st.executeQuery(getFacultesQuery);
			//storing data
			while(rs.next()) {
				Facultes fa = new Facultes();
				fa.setId(rs.getInt(1));
				fa.setNom(rs.getString(2));
				fa.setSurnom(rs.getString(3));
				fa.setLogo(rs.getString(4));
				//fa.setUni(UniDao.getUni(rs.getInt(5))
				facultes.add(fa);
			}

		}catch(SQLException sqe) {
			throw new EtudiantDaoException("Un problème est survenu lors de la connection avec la Base de donné");
		}
		
		//close connections
		finally {
			try {
				if(conn != null ) conn.close();
				if(st != null ) st.close();
			}catch(SQLException sqe) {
				throw new EtudiantDaoException("Un problème est survenu lors de la connection avec la Base de donné");
			}
		}
		
		//return the list 
		return facultes;
	}
	}



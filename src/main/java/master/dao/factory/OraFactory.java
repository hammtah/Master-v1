package master.dao.factory;
import master.dao.interfaces.EtudiantDao;
import master.dao.imp.EtudiantDaoImp;
import java.sql.DriverManager;
import java.sql.*;

public class OraFactory {
	public static final String driver="oracle.jdbc.driver.OracleDriver";
	public static final String dbUrl="jdbc:oracle:thin:testpractice/Test123@//localhost:1521/xepdb1";


public static Connection getConnection() throws SQLException{
	try {
		Class.forName(driver);
	}catch(ClassNotFoundException ec) {}
	
	return DriverManager.getConnection(dbUrl);

}

public static EtudiantDao getUserDao() {
	return new EtudiantDaoImp();
}

}
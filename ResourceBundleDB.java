package mysqljava.connections;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import com.mysql.jdbc.Connection;

public class ResourceBundleDB {
	private static String class_name=null;
	static Connection conn=null;
	private static String url=null;
	private static String dbname=null;
	private static String uid=null;
	private static String pwd=null;
	public static Connection connectToMysql() {
		ResourceBundle rbundle= ResourceBundle.getBundle("dbdata",Locale.US);
		class_name=rbundle.getString("class");
		url=rbundle.getString("url");
		dbname=rbundle.getString("dbname");
		uid=rbundle.getString("uid");
		pwd=rbundle.getString("pwd");
		url+=dbname;
		try {
			Class.forName(class_name);
			conn = (Connection) DriverManager.getConnection(url,uid,pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
	public static void main(String[] args) {
		connectToMysql();
		System.out.println("Connected to db");
	}
}

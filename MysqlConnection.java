package demo.jdbc.mysql.connect;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class MysqlConnection {
	static String mysqlcname="com.mysql.jdbc.Driver";
	static String url="jdbc:mysql://localhost:3306/db1";
	static String userid="root";
	static String password="root";
	static Connection conn=null;
	public static Connection MysqlConnection() {
		try{
			Class.forName(mysqlcname);
			conn = (Connection) DriverManager.getConnection(url,userid,password);
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch(SQLException s) {
			s.printStackTrace();
		}
		return conn;
	}

}

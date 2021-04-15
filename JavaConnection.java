package mysqljava.connections;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

public class JavaConnection {
	static String mysqlcname="com.mysql.jdbc.Driver";
	static String url="jdbc:mysql://localhost:3306/db1";
	static String userid="root";
	static String password="root";
	
	static void connectToMySql() {
		try {
			Class.forName(mysqlcname);
			Connection conn = (Connection) DriverManager.getConnection(url,userid,password);
			System.out.println("Successfully connected to database");
			Statement statement1= (Statement) conn.createStatement();
//			String sqlquery1=" select * from department where city like 'chennai'";
			String sqlquery2=" select * from employees where city like 'chennai'";
//			String sqlquery3=" select * from employees where deptID > 10";
//			ResultSet rs=statement1.executeQuery(sqlquery1);
			ResultSet rs1 = statement1.executeQuery(sqlquery2);
//			ResultSet rs2 = statement1.executeQuery(sqlquery3);
			
			
//			traversing the result set
//			while(rs.next()) {
//				ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
//				 int columnsNumber = rsmd.getColumnCount();
////				System.out.println("ID of department"+rs.getInt("deptID"));
////				System.out.println("Department Name:"+rs.getString("deptNAME"));
////				System.out.println("Row Number"+rs.getRow());
//				 for (int i = 1; i <= columnsNumber; i++) {
////			           if (i > 1) System.out.print(",  ");
//			           String columnValue = rs.getString(i);
//			           System.out.print(rsmd.getColumnName(i)+" : ");
//			           System.out.println(columnValue);
//			       }
//			       System.out.println("");
//			}
			while(rs1.next()) {
			ResultSetMetaData rsmd1 = (ResultSetMetaData) rs1.getMetaData();
			 int columnsNumber1 = rsmd1.getColumnCount();
//				System.out.println("ID of department"+rs1.getInt("empId"));
//				System.out.println("Department Name:"+rs1.getString("empName"));
//				System.out.println("Row Number"+rs1.getRow());
			 for (int i = 1; i <= columnsNumber1; i++) {
//		           if (i > 1) System.out.print(",  ");
		           String columnValue = rs1.getString(i);
		           System.out.print(rsmd1.getColumnName(i)+" : ");
		           System.out.println(columnValue);
		       }
		       System.out.println("");
			}
//			while(rs2.next()) {
//		       ResultSetMetaData rsmd2 = (ResultSetMetaData) rs2.getMetaData();
//				 int columnsNumber2 = rsmd2.getColumnCount();
//				System.out.println("ID of department"+rs2.getInt("empId"));
//				System.out.println("Department Name:"+rs2.getString("empName"));
//				System.out.println("Row Number"+rs2.getRow());
//					 for (int i = 1; i <= columnsNumber2; i++) {
////				           if (i > 1) System.out.print(",  ");
//				           String columnValue = rs.getString(i);
//				           System.out.print(rsmd2.getColumnName(i)+" : ");
//				           System.out.println(columnValue);
//				       }
//				       System.out.println("");
//			}
//			rs.close();
			rs1.close();
//			rs2.close();
			statement1.close();
			conn.close();
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch(SQLException s) {
			s.printStackTrace();
		}
	}
	public static void main(String[] args) {
		connectToMySql();
	}

}

package mysqljava.connections;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;

import demo.jdbc.mysql.connect.MysqlConnection;

public class PreparedStatementDemo {
//static MysqlConnection mysqlconn = null;
static Connection conn=null;
	static void callableDisplay() {
		conn=MysqlConnection.MysqlConnection();
		try {
			//without parameters
		//	CallableStatement stmt=(CallableStatement) conn.prepareCall("{call display_department()}");
			
			//with parameters
			CallableStatement stmt = (CallableStatement) conn.prepareCall("{? = call calc_count(?)}");
//			
			stmt.registerOutParameter(1, Types.INTEGER);
			
			//stmt.setString(1, "mumbai");
			stmt.setInt(2, 12);
			stmt.execute();
			 System.out.println(stmt.getInt(1));
			/*while(rs.next()) {
				ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
				 int columnsNumber = rsmd.getColumnCount();
				 for (int i = 1; i <= columnsNumber; i++) {
			           String columnValue = rs.getString(i);
			           System.out.print(rsmd.getColumnName(i)+" : ");
			           System.out.println(columnValue);
			       }*/
			       System.out.println("");
//			}
			System.out.println("Callable statement executed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	static void insertDepartments() {
		conn=MysqlConnection.MysqlConnection();
		 String query = " insert into department(deptID,deptNAME,strength,city,headquaters)"
		            + " values (?, ?, ?, ?, ?)";
		try {
	          // create the mysql insert preparedstatement
	          PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
	          preparedStmt.setString (1, "15");
	          preparedStmt.setString (2, "BPO");
	          preparedStmt.setInt   (3, 20);
	          preparedStmt.setString (4, "DELHI");
	          preparedStmt.setString (5, "DELHI");		          
		      
	          // execute the preparedstatement
		      preparedStmt.execute();
		      System.out.println("Value entered successfully");
			} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
 	static void selectDepartments() {
 		conn=MysqlConnection.MysqlConnection();
 		String sql= "select deptID,deptNAME from department where deptID>=10";
 		try {
			PreparedStatement pstm1=(PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs=pstm1.executeQuery();
			while(rs.next()) {
				ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
				 int columnsNumber = rsmd.getColumnCount();
				 for (int i = 1; i <= columnsNumber; i++) {
			           String columnValue = rs.getString(i);
			           System.out.print(rsmd.getColumnName(i)+" : ");
			           System.out.println(columnValue);
			       }
			       System.out.println("");
			}
			
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
 		
 	}
	static void insertEmployee() {
		conn=MysqlConnection.MysqlConnection();
		 String query = " insert into employees(empId,empName,deptID,dob,city)"
		            + " values (?, ?, ?, ?, ?)";
		try {
	          // create the mysql insert preparedstatement
	          PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
	          preparedStmt.setInt (1, 5);
	          preparedStmt.setString (2, "ragu");
	          preparedStmt.setInt   (3, 15);
	          preparedStmt.setString (4, "1999-09-05");
	          preparedStmt.setString (5, "DELHI");		          
		      
	          // execute the preparedstatement
		      preparedStmt.execute();
		      System.out.println(" employee value entered successfully");
			} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
 	static void updateEmployee() {
 		conn=MysqlConnection.MysqlConnection();
 		String query= "update employees set city=? where empId=?";
 		try {
 			PreparedStatement pstmt= (PreparedStatement)conn.prepareStatement(query);
 			pstmt.setString(1, "hyderabad");
 			pstmt.setInt(2, 5);
 			pstmt.execute();
 			System.out.println("City updated for the user");
 		}catch (SQLException e) {
			// TODO: handle exception
 			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
 	}
 	static void deleteEmployee() {
 		conn=MysqlConnection.MysqlConnection();
 		String query="delete from employees where empId=?";
 		try {
 			PreparedStatement pst= (PreparedStatement)conn.prepareStatement(query);
 			pst.setInt(1, 5);
 			pst.execute();
 			System.out.println("User deleted successfully");
 		}catch (SQLException se) {
			// TODO: handle exception
 			se.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
 		
 	}
 	public static void listEmployeesdept() {
 		conn=MysqlConnection.MysqlConnection();
 		String query="select department.deptID,count(*) from department right outer join employees  on department.deptID=employees.deptID where employees.deptID is not null group by department.deptID";
 		try {
 			PreparedStatement pstm1=(PreparedStatement) conn.prepareStatement(query);
 			System.out.println("Employees per department");
			ResultSet rs=pstm1.executeQuery();
			while(rs.next()) {
				ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
				 int columnsNumber = rsmd.getColumnCount();
				 for (int i = 1; i <= columnsNumber; i++) {
			           String columnValue = rs.getString(i);
			           System.out.print(rsmd.getColumnName(i)+" : ");
			           System.out.println(columnValue);
			       }
			       System.out.println("");
			}
 			
 		}catch (SQLException se) {
			// TODO: handle exception
 			se.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
 	}
 	public static void main(String[] args) {
		selectDepartments();
//		insertDepartments();
		insertEmployee();
		updateEmployee();
		deleteEmployee();
		listEmployeesdept();
		callableDisplay();
	}
}

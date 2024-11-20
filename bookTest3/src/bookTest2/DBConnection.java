package bookTest2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConnection {
	
	public static Connection dbCon() {
		// 오라클 접속할 수 있는 객체참조변수 선언
		Connection con = null;
		
		// 1. jdbc driver load 2. connection
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521/xe", "hr", "hr");
			//오라클 서버(데이터베이스 서버)에 접속요청 진행
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return con;
	}
	
	//sql 객체 close
	public static void dbClose(Connection con, Statement stmt, ResultSet rs) {
		if(con != null) {
            try {
                con.close();
            } catch (SQLException e) {
            	System.out.println(e.toString());
            }
        }
		if(stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
            	System.out.println(e.toString());
            }
        }
		if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
	}

	public static void dbClose(Connection con, Statement stmt) {
		if(con != null) {
            try {
                con.close();
            } catch (SQLException e) {
            	System.out.println(e.toString());
            }
        }
		if(stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
            	System.out.println(e.toString());
            }
        }
	}
	
	
}

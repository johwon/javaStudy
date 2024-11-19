package studentTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConnectDB {

	public static void main(String[] args) {
		//객체참조변수 선언
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Employees> eList = new ArrayList<Employees>();
		
		
		
		//1. jdbc driver load
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 드라이버 적재 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("1. 드라이버 적재 실패" + e.toString());
		}
		//2. connection
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521/xe","hr","hr");
			System.out.println("2. 오라클 접속 성공");
		} catch (SQLException e) {
			System.out.println("2. 오라클 접속 실패" + e.toString());
		}
		//3. statement(쿼리문:c, u, r, d)
		try {
			stmt = con.createStatement();
			System.out.println("3. Statement 객체생성성공");
		} catch (SQLException e) {
			System.out.println("3. Statement 객체생성실패");
		}
		
		//4. result set 
		try {
			rs = stmt.executeQuery("SELECT * FROM EMPLOYEES");
			System.out.println("4. ResultSet 객체생성성공");
		} catch (SQLException e) {
			System.out.println("4. ResultSet 객체생성실패");
		}
		//5. 데이터저장
		try {
			while(rs.next()) {
				int employeeId = rs.getInt("EMPLOYEE_ID");
				String firstName = rs.getString("FIRST_NAME");
				int salary = rs.getInt("SALARY");
				Employees employee = new Employees(employeeId, firstName, salary);
				eList.add(employee);
			}
		} catch (SQLException e) {
			System.out.println("4.result set 출력 진행 실패");
		}
		//데이터 출력
		employeesListPrint(eList);
		
		//6. close
		if(con != null) {
            try {
                con.close();
                System.out.println("6. con close 성공");
            } catch (SQLException e) {
                System.out.println("6. con close 실패"+e.toString());
            }
        }
		if(stmt != null) {
            try {
                stmt.close();
                System.out.println("6. stmt close 성공");
            } catch (SQLException e) {
                System.out.println("6. stmt close 실패"+e.toString());
            }
        }
		if(rs != null) {
            try {
                rs.close();
                System.out.println("6. rs close 성공");
            } catch (SQLException e) {
                System.out.println("6. rs close 실패"+e.toString());
            }
        }
	}

	private static void employeesListPrint(ArrayList<Employees> eList) {
		for(Employees e : eList) {
			System.out.println(e.toString());
		}
	}

}

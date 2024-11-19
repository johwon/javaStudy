package studentTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConnectDB {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Employees> eList = new ArrayList<Employees>();
		//1.jdbc driver load, 2.connection 가져온다
		con = DBConnection.dbCon();
		
		//3. statement(쿼리문:c, u, r, d)
		//4. result set 
		//5. 데이터저장
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM EMPLOYEES");
			System.out.println("3. Statement 객체생성성공");
			while(rs.next()) {
				int employeeId = rs.getInt("EMPLOYEE_ID");
				String firstName = rs.getString("FIRST_NAME");
				int salary = rs.getInt("SALARY");
				Employees employee = new Employees(employeeId, firstName, salary);
				eList.add(employee);
			}
		} catch (SQLException e) {
			System.out.println("데이터베이스 실행문 에러"+e.toString());
		}
		
		//6. 데이터 출력
		employeesListPrint(eList);
		
		//7. close
		DBConnection.dbClose(con, stmt, rs);
	}

	//6.테이블 내용 출력
	private static void employeesListPrint(ArrayList<Employees> eList) {
		for(Employees e : eList) {
			System.out.println(e.toString());
		}
	}

}

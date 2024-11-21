package customerTest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerMain {

	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws SQLException {
		boolean exitFlag = false;
		int menuNum;
		
		while(!exitFlag) {
			System.out.println();
			dispMenu();
			menuNum = Integer.parseInt(sc.nextLine());
			System.out.println();
			switch(menuNum) {
			case CustomerMenu.PRINT:
				customerPrint();
				break;
			case CustomerMenu.INSERT:
				customerInsert();
				break;
			case CustomerMenu.UPDATE:
				customerUpdate();
				break;
			case CustomerMenu.DELETE:
				customerDelete();
				break;
			case CustomerMenu.ADD_POINT:
				addPoint();
				break;
			case CustomerMenu.MEMBERSHIP_PRINT:
				membershipPrint();
				break;
			case CustomerMenu.EXIT:
				exitFlag = true;
				break;
			}
		}
		System.out.println("프로그램을 종료합니다");
	}

	
	
	private static void membershipPrint() throws SQLException {
		System.out.println("고객 등급을 조회합니다.");
		System.out.print("등급 조회할 고객의 아이디를 입력해주세요 : ");
		int id = Integer.parseInt(sc.nextLine());
		
		Connection con = DBConnection.dbCon();
		CallableStatement cstmt = con.prepareCall("{? =call CUS_MEMBERSHIP_PRINT_FUNC(?)}");
		cstmt.registerOutParameter(1, Types.VARCHAR);
		cstmt.setInt(2, id);
		
		cstmt.executeUpdate();
		
		String s = cstmt.getString(1);
		System.out.println(s);
		
		DBConnection.dbClose(con, cstmt);
	}

	private static void addPoint() throws SQLException {
		System.out.print("고객의 아이디를 입력해주세요 : ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.print("추가할 포인트 : ");
		int point = Integer.parseInt(sc.nextLine());
		
		Connection con = DBConnection.dbCon();
		CallableStatement cstmt = null;
		
		cstmt = con.prepareCall("{call CUS_ADD_POINT_PROC(?, ?)}");
		cstmt.setInt(1, id);
		cstmt.setInt(2, point);
		
		int result = cstmt.executeUpdate();
		
		System.out.println((result!=0)?"포인트 추가 성공":"포인트 추가 실패");
	
		DBConnection.dbClose(con, cstmt);
	}


	private static void customerDelete() throws SQLException {
		System.out.print("삭제할 고객의 아이디를 입력하세요 : ");
		int id = Integer.parseInt(sc.nextLine());
		
		Connection con = DBConnection.dbCon();
		PreparedStatement pstmt = con.prepareStatement("DELETE FROM CUSTOMER WHERE ID = ?");
		pstmt.setInt(1, id);
		int result = pstmt.executeUpdate();
		
		System.out.println((result!=0)?"삭제 성공":"삭제 실패");
		
		DBConnection.dbClose(con, pstmt);
	}



	private static void customerUpdate() throws SQLException {
		System.out.print("수정할 고객의 아이디를 입력하세요 : ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.print("고객 이름을 수정합니다 : ");
		String name = sc.nextLine();
		System.out.print("핸드폰 번호를 수정합니다 : ");
		String phone = sc.nextLine();
		System.out.print("주소를 수정합니다 : ");
		String address = sc.nextLine();
		System.out.print("회원등급을 수정합니다 : ");
		String membership = sc.nextLine();
		System.out.print("포인트를 수정합니다 : ");
		int point = Integer.parseInt(sc.nextLine());
		
		Connection con = DBConnection.dbCon();
		PreparedStatement pstmt = con.prepareStatement("UPDATE CUSTOMER SET NAME = ?, PHONE = ?, ADDRESS = ?, MEMBERSHIP = ?, POINT = ? WHERE ID = ?");
		pstmt.setString(1, name);
		pstmt.setString(2, phone);
		pstmt.setString(3, address);
		pstmt.setString(4, membership);
		pstmt.setInt(5, point);
		pstmt.setInt(6, id);
		int result = pstmt.executeUpdate();
		
		System.out.println((result!=0)?"수정 성공":"수정 실패");
		
		DBConnection.dbClose(con, pstmt);
	}



	private static void customerInsert() throws SQLException {
		System.out.println("신규 고객 입력을 시작합니다.");
		System.out.print("고객 이름 : ");
		String name = sc.nextLine();
		System.out.print("핸드폰 번호 : ");
		String phone = sc.nextLine();
		System.out.print("주소 : ");
		String address = sc.nextLine();
		
		Connection con = DBConnection.dbCon();
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO CUSTOMER(ID,NAME,PHONE,ADDRESS) VALUES((SELECT NVL(MAX(ID),0)+1 FROM CUSTOMER),?,?,?)");
		pstmt.setString(1, name);
		pstmt.setString(2, phone);
		pstmt.setString(3, address);
		int result = pstmt.executeUpdate();
		Customer customer = new Customer(name, phone, address);
		
		System.out.println((result!=0)?"입력 성공":"입력실패");
		
		DBConnection.dbClose(con, pstmt);
	}



	private static void customerPrint() throws SQLException {
		System.out.println("모든 고객의 정보를 조회합니다.");
		
		ArrayList<Customer> cList = new ArrayList<Customer>();
		Connection con = DBConnection.dbCon();
		Statement stmt = con.createStatement();
		ResultSet rs = null;
		
		rs = stmt.executeQuery("SELECT * FROM CUSTOMER ORDER BY ID");
		while(rs.next()) {
			int id = rs.getInt("ID");
			String name = rs.getString("NAME");
			String phone = rs.getString("PHONE");
			String address = rs.getString("ADDRESS");
			String membership = rs.getString("MEMBERSHIP");
			int point = rs.getInt("POINT");
			Customer customer = new Customer(id, name, phone, address, membership, point);
			cList.add(customer);
			
		}
		//출력
		for(Customer c : cList) {
			System.out.println(c.toString());
		}
		
		//객체반납
		DBConnection.dbClose(con, stmt, rs);
		
	}

	
	private static void dispMenu() {
		System.out.println("-----고객정보 메뉴-----");
		System.out.println("1. 고객 정보 조회");
		System.out.println("2. 신규 고객 입력");
		System.out.println("3. 고객 정보 수정");
		System.out.println("4. 고객 정보 삭제");
		System.out.println("5. 고객 포인트 추가");
		System.out.println("6. 고객 등급 조회");
		System.out.println("7. 종료");
		System.out.print("번호를 입력해주세요 : ");
	}
}

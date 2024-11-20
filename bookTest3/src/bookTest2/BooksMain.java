package bookTest2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class BooksMain {
	public static Scanner sc = new Scanner(System.in);
	

	public static void main(String[] args) throws SQLException {
		boolean exitFlag = false;
		// 사용자로부터 Books 출력,입력,수정,삭제 요청받는다.
		while (!exitFlag) {
			printMenu();
			int num = Integer.parseInt(sc.nextLine());
			switch (num) {
			case BookMenu.PRINT:
				booksPrint();
				break;
			case BookMenu.INSERT:
				booksInsert();
				break;
			case BookMenu.UPDATE:
				booksUpdate();
				break;
			case BookMenu.DELETE:
				booksDelete();
				break;
			case BookMenu.EXIT:
				exitFlag = true;
				break;
			}

			System.out.println("The end");
		}
	}

	// 삭제
	private static void booksDelete() throws SQLException {
		// Connection
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;

		// 1 Load, 2 connection
		con = DBConnection.dbCon();

		// 3. Statement
		System.out.print("삭제할 책의 id : ");
		int no = Integer.parseInt(sc.nextLine());
		pstmt = con.prepareStatement("DELETE FROM BOOKS WHERE ID = ? ");
		pstmt.setInt(1, no);
		int result=pstmt.executeUpdate();
		
		// result 값으로 실행한 문장의 카운트를 세서 줌
//		int result = stmt.executeUpdate("DELETE FROM BOOKS WHERE ID = " + no);

		// 4. 내용이 잘 입력이 되었는지 체크
		System.out.println((result != 0) ? "삭제성공" : "삭제실패");

		// 6. sql 객체 반납
		DBConnection.dbClose(con, pstmt);

	}

	// 수정
	private static void booksUpdate() throws SQLException {
		// Connection
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;

		// 1 Load, 2 connection
		con = DBConnection.dbCon();
		
		// 3. Statement
		//수정할 데이터를 입력
		Books books = new Books(7, "JAVA JAVA", "kdj", "2024", 44000);
//		stmt = con.createStatement();
		pstmt = con.prepareStatement("UPDATE BOOKS SET TITLE = ?, PUBLISHER = ?, YEAR = ? , PRICE = ? WHERE ID = ? ");
		pstmt.setString(1, books.getTitle());
		pstmt.setString(2, books.getPublisher());
		pstmt.setString(3, books.getYear());
		pstmt.setInt(4, books.getPrice());
		pstmt.setInt(5, books.getId());
		
		int result = pstmt.executeUpdate();
		
		
		// result 값으로 실행한 문장의 카운트를 세서 줌
//		int result = stmt.executeUpdate("UPDATE BOOKS SET TITLE = '"+
//		books.getTitle()+"', PUBLISHER = '"+books.getPublisher()+"', YEAR = '"+books.getYear()+"', PRICE = "+books.getPrice()+"WHERE ID = "+books.getId());

		// 4. 내용이 잘 입력이 되었는지 체크
		System.out.println((result != 0) ? "입력성공" : "입력실패");

		// 6. sql 객체 반납
		DBConnection.dbClose(con, pstmt);
	}

	// 삽입
	private static void booksInsert() throws SQLException {
		// Connection
		Connection con = null;
		Statement stmt = null;

		// 1 Load, 2 connection
		con = DBConnection.dbCon();

		// 3. Statement
		Books books = new Books(0, "Head First JAVA", "kdj", "2008", 23000);
		//==============================================2단계수정===================================================
//		stmt = con.createStatement();
		PreparedStatement pstmt = null;
		pstmt = con.prepareStatement("INSERT INTO books VALUES (books_id_seq.nextval, ?, ?, ?,?)");
		pstmt.setString(1, books.getTitle());
		pstmt.setString(2, books.getPublisher());
		pstmt.setString(3, books.getYear());
		pstmt.setInt(4, books.getPrice());
		int result = pstmt.executeUpdate();
		
		
		// result 값으로 실행한 문장의 카운트를 세서 줌
//		int result = stmt.executeUpdate("INSERT INTO books VALUES (books_id_seq.nextval,'" + books.getTitle() + "','"
//				+ books.getPublisher() + "','" + books.getYear() + "'," + books.getPrice() + ")");
		

		// 4. 내용이 잘 입력이 되었는지 체크
		System.out.println((result != 0) ? "입력성공" : "입력실패");

		// 6. sql 객체 반납
		DBConnection.dbClose(con, pstmt);
	}

	// 출력
	public static void booksPrint() throws SQLException {
		// Connection
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Books> booksList = new ArrayList<Books>();

		// 1 Load, 2 connection
		con = DBConnection.dbCon();

		// 3. Statement
		stmt = con.createStatement();
		rs = stmt.executeQuery("select * from books");

		// 4. 테이블 내용 가져오기
		while (rs.next()) {
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String publisher = rs.getString("PUBLISHER");
			String year = rs.getString("YEAR");
			int price = rs.getInt("PRICE");
			Books books = new Books(id, title, publisher, year, price);
			booksList.add(books);
		}

		// 5. 출력하기
		booksListPrint(booksList);

		// 6. sql 객체 반납
		DBConnection.dbClose(con, stmt, rs);
	}

	private static void printMenu() {
		System.out.println("Books Menu");
		System.out.println("1. 출력");
		System.out.println("2. 입력");
		System.out.println("3. 수정");
		System.out.println("4. 삭제");
		System.out.println("5. 종료");
		System.out.print("선택해주세요 : ");
	}

	private static void booksListPrint(ArrayList<Books> booksList) {
		for (Books books : booksList) {
			System.out.println(books.toString());
		}
	}

}

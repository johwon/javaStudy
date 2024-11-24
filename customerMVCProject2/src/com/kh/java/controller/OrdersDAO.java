package com.kh.java.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.java.model.OrdersVO;
import com.kh.java.model.ProductVO;

public class OrdersDAO {
	public static String printSQL = "SELECT * FROM ORDERS ORDER BY NO";
	public static String insertSQL = "INSERT INTO ORDERS VALUES(?, ?, ?, ?)";
	public static String updateSQL = "UPDATE ORDERS SET C_ID = ?, P_NO = ?, AMOUNT = ? WHERE NO =?";
	public static String deleteSQL = "DELETE FROM ORDERS WHERE NO = ?";

	public static ArrayList<OrdersVO> ordersPrint() throws SQLException {
		ArrayList<OrdersVO> ordersList = new ArrayList<OrdersVO>();
		Connection con = DBConnection.dbCon();
		Statement stmt = con.createStatement();
		ResultSet rs = null;

		rs = stmt.executeQuery(printSQL);
		while (rs.next()) {
			String no = rs.getString("NO");
			int c_id = rs.getInt("C_ID");
			String p_no = rs.getString("P_NO");
			int amount = rs.getInt("AMOUNT");
			OrdersVO ovo = new OrdersVO(no, c_id, p_no, amount);
			ordersList.add(ovo);
		}

		// 객체반납
		DBConnection.dbClose(con, stmt, rs);

		return ordersList;
	}

	public static void ordersInsert(OrdersVO ovo) throws SQLException {
		Connection con = DBConnection.dbCon();
		PreparedStatement pstmt = con.prepareStatement(insertSQL);

		pstmt.setString(1, ovo.getNo());
		pstmt.setInt(2, ovo.getC_id());
		pstmt.setString(3, ovo.getP_no());
		pstmt.setInt(4, ovo.getAmount());
		int result = pstmt.executeUpdate();

		System.out.println((result != 0) ? "입력 성공" : "입력실패");

		DBConnection.dbClose(con, pstmt);
	}

	public static void ordersUpdate(OrdersVO ovo) throws SQLException {
		Connection con = DBConnection.dbCon();
		PreparedStatement pstmt = con.prepareStatement(updateSQL);
		pstmt.setInt(1, ovo.getC_id());
		pstmt.setString(2, ovo.getP_no());
		pstmt.setInt(3, ovo.getAmount());
		pstmt.setString(4, ovo.getNo());
		int result = pstmt.executeUpdate();

		System.out.println((result != 0) ? "수정 성공" : "수정 실패");

		DBConnection.dbClose(con, pstmt);
	}

	public static void ordersDelete(OrdersVO ovo) throws SQLException {
		Connection con = DBConnection.dbCon();
		PreparedStatement pstmt = con.prepareStatement(deleteSQL);
		pstmt.setString(1, ovo.getNo());
		int result = pstmt.executeUpdate();

		System.out.println((result != 0) ? "삭제 성공" : "삭제 실패");

		DBConnection.dbClose(con, pstmt);
	}


}

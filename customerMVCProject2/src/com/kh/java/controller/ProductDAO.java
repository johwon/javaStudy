package com.kh.java.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.java.model.ProductVO;

public class ProductDAO {
	public static String printSQL = "SELECT * FROM PRODUCT ORDER BY NO";
	public static String insertSQL = "INSERT INTO PRODUCT VALUES(?, ?, ?)";
	public static String updateSQL = "UPDATE PRODUCT SET NAME = ?, PRICE = ? WHERE NO = ?";
	public static String deleteSQL = "DELETE FROM PRODUCT WHERE NO = ?";

	public static ArrayList<ProductVO> productPrint() throws SQLException {
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		Connection con = DBConnection.dbCon();
		Statement stmt = con.createStatement();
		ResultSet rs = null;

		rs = stmt.executeQuery(printSQL);
		while (rs.next()) {
			String no = rs.getString("NO");
			String name = rs.getString("NAME");
			int price = rs.getInt("PRICE");
			ProductVO product = new ProductVO(no, name, price);
			productList.add(product);
		}

		// 객체반납
		DBConnection.dbClose(con, stmt, rs);

		return productList;
	}

	public static void productInsert(ProductVO pvo) throws SQLException {
		Connection con = DBConnection.dbCon();
		PreparedStatement pstmt = con.prepareStatement(insertSQL);

		pstmt.setString(1, pvo.getNo());
		pstmt.setString(2, pvo.getName());
		pstmt.setInt(3, pvo.getPrice());
		int result = pstmt.executeUpdate();

		System.out.println((result != 0) ? "입력 성공" : "입력실패");

		DBConnection.dbClose(con, pstmt);
	}

	public static void productUpdate(ProductVO pvo) throws SQLException {
		Connection con = DBConnection.dbCon();
		PreparedStatement pstmt = con.prepareStatement(updateSQL);
		pstmt.setString(1, pvo.getName());
		pstmt.setInt(2, pvo.getPrice());
		pstmt.setString(3, pvo.getNo());
		int result = pstmt.executeUpdate();

		System.out.println((result != 0) ? "수정 성공" : "수정 실패");

		DBConnection.dbClose(con, pstmt);
	}

	public static void productDelete(ProductVO pvo) throws SQLException {
		Connection con = DBConnection.dbCon();
		PreparedStatement pstmt = con.prepareStatement(deleteSQL);
		pstmt.setString(1, pvo.getNo());
		int result = pstmt.executeUpdate();

		System.out.println((result != 0) ? "삭제 성공" : "삭제 실패");

		DBConnection.dbClose(con, pstmt);
	}


}

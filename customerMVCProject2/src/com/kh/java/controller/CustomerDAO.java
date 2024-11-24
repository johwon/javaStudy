package com.kh.java.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import com.kh.java.model.CustomerVO;

public class CustomerDAO {
	public static String printSQL = "SELECT * FROM CUSTOMER ORDER BY ID";
	public static String insertSQL = "INSERT INTO CUSTOMER(ID,NAME,PHONE,ADDRESS) VALUES((SELECT NVL(MAX(ID),0)+1 FROM CUSTOMER),?,?,?)";
	public static String updateSQL = "UPDATE CUSTOMER SET NAME = ?, PHONE = ?, ADDRESS = ?, MEMBERSHIP = ?, POINT = ? WHERE ID = ?";
	public static String deleteSQL = "DELETE FROM CUSTOMER WHERE ID = ?";
	public static String addPointSQL = "{call CUS_ADD_POINT_PROC(?, ?)}";
	public static String membershipSQL = "{? =call CUS_MEMBERSHIP_PRINT_FUNC(?)}";
	public static String membershipGroupSQL = "SELECT * FROM CUSTOMER WHERE MEMBERSHIP = ?";

	public static ArrayList<CustomerVO> customerPrint() throws SQLException {
		ArrayList<CustomerVO> cList = new ArrayList<CustomerVO>();
		Connection con = DBConnection.dbCon();
		Statement stmt = con.createStatement();
		ResultSet rs = null;

		rs = stmt.executeQuery(printSQL);
		while (rs.next()) {
			int id = rs.getInt("ID");
			String name = rs.getString("NAME");
			String phone = rs.getString("PHONE");
			String address = rs.getString("ADDRESS");
			String membership = rs.getString("MEMBERSHIP");
			int point = rs.getInt("POINT");
			CustomerVO customer = new CustomerVO(id, name, phone, address, membership, point);
			cList.add(customer);
		}

		// 객체반납
		DBConnection.dbClose(con, stmt, rs);

		return cList;
	}

	public static void customerInsert(CustomerVO cvo) throws SQLException {
		Connection con = DBConnection.dbCon();
		PreparedStatement pstmt = con.prepareStatement(insertSQL);

		pstmt.setString(1, cvo.getName());
		pstmt.setString(2, cvo.getPhone());
		pstmt.setString(3, cvo.getAddress());
		int result = pstmt.executeUpdate();

		System.out.println((result != 0) ? "입력 성공" : "입력실패");

		DBConnection.dbClose(con, pstmt);
	}

	public static void customerUpdate(CustomerVO cvo) throws SQLException {
		Connection con = DBConnection.dbCon();
		PreparedStatement pstmt = con.prepareStatement(updateSQL);
		pstmt.setString(1, cvo.getName());
		pstmt.setString(2, cvo.getPhone());
		pstmt.setString(3, cvo.getAddress());
		pstmt.setString(4, cvo.getMembership());
		pstmt.setInt(5, cvo.getPoint());
		pstmt.setInt(6, cvo.getId());
		int result = pstmt.executeUpdate();

		System.out.println((result != 0) ? "수정 성공" : "수정 실패");

		DBConnection.dbClose(con, pstmt);
	}

	public static void customerDelete(CustomerVO cvo) throws SQLException {
		Connection con = DBConnection.dbCon();
		PreparedStatement pstmt = con.prepareStatement(deleteSQL);
		pstmt.setInt(1, cvo.getId());
		int result = pstmt.executeUpdate();

		System.out.println((result != 0) ? "삭제 성공" : "삭제 실패");

		DBConnection.dbClose(con, pstmt);
	}

	public static void addPoint(int id, int addPoint) throws SQLException {
		Connection con = DBConnection.dbCon();
		CallableStatement cstmt = null;

		cstmt = con.prepareCall(addPointSQL);
		cstmt.setInt(1, id);
		cstmt.setInt(2, addPoint);

		int result = cstmt.executeUpdate();

		System.out.println((result != 0) ? "포인트 추가 성공" : "포인트 추가 실패");

		DBConnection.dbClose(con, cstmt);
	}

	public static void membershipPrint(CustomerVO cvo) throws SQLException {
		Connection con = DBConnection.dbCon();
		CallableStatement cstmt = con.prepareCall(membershipSQL);
		cstmt.registerOutParameter(1, Types.VARCHAR);
		cstmt.setInt(2, cvo.getId());

		cstmt.executeUpdate();

		String s = cstmt.getString(1);
		System.out.println(s);

		DBConnection.dbClose(con, cstmt);
	}

}

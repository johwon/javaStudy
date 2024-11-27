package com.kh.subjectMVCProject.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.kh.subjectMVCProject.model.TraineeVO;

public class TraineeDAO {
	// query
	public final String TRAINEE_SELECT = "SELECT * FROM TRAINEE";
	public final String TRAINEE_ALL_SELECT = "select T.NO, T.SECTION, T.REGDATE, S.NUM, S.NAME AS SNAME, L.ABBRE, L.NAME AS LNAME "
			+ "from trainee T inner join student S on T.s_num = S.num "
			+ "inner join lesson L on T.abbre = L.abbre order by T.NO";
	public final String TRAINEE_SELECT_SORT = "SELECT * FROM TRAINEE ORDER BY S_NUM";
	public final String TRAINEE_INSERT = "INSERT INTO TRAINEE VALUES(TRAINEE_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
	public final String TRAINEE_UPDATE = "UPDATE TRAINEE SET S_NUM = ?, ABBRE = ?, SECTION = ? WHERE NO = ?";
	public final String TRAINEE_DELETE = "DELETE FROM TRAINEE WHERE NO = ?";

	// traineeInsert
	public boolean traineeInsert(TraineeVO tvo) {
		Connection con = null; // 오라클접속관문
		PreparedStatement pstmt = null; // 오라클에서 작업할 쿼리문을 사용할 수 있게 하는 명령
		boolean successFlag = false;

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(TRAINEE_INSERT);
			pstmt.setString(1, tvo.getS_num());
			pstmt.setString(2, tvo.getAbbre());
			pstmt.setString(3, tvo.getSection());
			int count = pstmt.executeUpdate();
			successFlag = (count != 0) ? true : false;
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt);
		}
		return successFlag;
	}

	public ArrayList<TraineeVO> traineeSelect(TraineeVO tvo) {
		Connection con = null; // 오라클접속관문
		PreparedStatement pstmt = null; // 오라클에서 작업할 쿼리문을 사용할 수 있게 하는 명령
		ResultSet rs = null; // 오라클에서 작업한 결과물을 받는 객체
		ArrayList<TraineeVO> traineeList = new ArrayList<TraineeVO>(); // 다른 객체에 전달하기 위해 사용하는 객체

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(TRAINEE_SELECT);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("NO");
				String s_num = rs.getString("S_NUM");
				String abbr = rs.getString("ABBRE");
				String section = rs.getString("SECTION");
				Date regdate = rs.getDate("REGDATE");
				TraineeVO traineeVO = new TraineeVO(no, s_num, abbr, section, regdate);
				traineeList.add(traineeVO);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt, rs);
		}
		return traineeList;
	}

	// traineeAllSelect

	public ArrayList<TraineeVO> traineeAllSelect(TraineeVO tvo) {
		Connection con = null; // 오라클접속관문
		PreparedStatement pstmt = null; // 오라클에서 작업할 쿼리문을 사용할 수 있게 하는 명령
		ResultSet rs = null; // 오라클에서 작업한 결과물을 받는 객체
		ArrayList<TraineeVO> traineeList = new ArrayList<TraineeVO>(); // 다른 객체에 전달하기 위해 사용하는 객체

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(TRAINEE_ALL_SELECT);
			rs = pstmt.executeQuery();
//			T.NO, T.SECTION, T.REGDATE, S.NUM, S.NAME AS SNAME, L.ABBRE, L.NAME AS LNAME
			while (rs.next()) {
				int no = rs.getInt("NO");
				String section = rs.getString("SECTION");
				Date regdate = rs.getDate("REGDATE");
				String s_num = rs.getString("NUM");
				String s_name = rs.getString("SNAME");
				String abbr = rs.getString("ABREE");
				String l_name = rs.getString("LNAME");
				TraineeVO traineeVO = new TraineeVO(no, s_num, abbr, section, regdate, s_name, l_name);
				traineeList.add(traineeVO);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt, rs);
		}
		return traineeList;
	}

	// traineeSort
	public ArrayList<TraineeVO> traineeSelectSort(TraineeVO tvo) {
		Connection con = null; // 오라클접속관문
		PreparedStatement pstmt = null; // 오라클에서 작업할 쿼리문을 사용할 수 있게 하는 명령
		ResultSet rs = null; // 오라클에서 작업한 결과물을 받는 객체
		ArrayList<TraineeVO> traineeList = new ArrayList<TraineeVO>(); // 다른 객체에 전달하기 위해 사용하는 객체

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(TRAINEE_SELECT_SORT);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("NO");
				String s_num = rs.getString("S_NUM");
				String abbr = rs.getString("ABREE");
				String section = rs.getString("SECTION");
				Date regdate = rs.getDate("REGDATE");
				TraineeVO traineeVO = new TraineeVO(no, s_num, abbr, section, regdate);
				traineeList.add(traineeVO);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt, rs);
		}
		return traineeList;
	}

	// traineeDelete
	public boolean traineeDelete(TraineeVO tvo) {
		Connection con = null; // 오라클접속관문
		PreparedStatement pstmt = null; // 오라클에서 작업할 쿼리문을 사용할 수 있게 하는 명령
		boolean successFlag = false;

		try {
			// 커밋을 수동으로 바꾼다.
			con = DBUtility.dbCon();
			con.setAutoCommit(false);

			pstmt = con.prepareStatement(TRAINEE_DELETE);
			pstmt.setInt(1, tvo.getNo());
			int count = pstmt.executeUpdate();
			successFlag = (count != 0) ? true : false;
			if (count != 0) {
				successFlag = true;
				// 삭제 성공시 커밋기능을 부여한다.
				con.commit();
			} else {
				successFlag = false;
				// 삭제 실패시 롤백기능을 부여한다.
				con.rollback();
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt);
		}
		return successFlag;
	}

	// traineeUpdate
	public boolean traineeUpdate(TraineeVO tvo) {
		Connection con = null; // 오라클접속관문
		PreparedStatement pstmt = null; // 오라클에서 작업할 쿼리문을 사용할 수 있게 하는 명령
		boolean successFlag = false;

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(TRAINEE_UPDATE);
			pstmt.setString(1, tvo.getS_num());
			pstmt.setString(2, tvo.getAbbre());
			pstmt.setString(3, tvo.getSection());
			pstmt.setInt(4, tvo.getNo());
			int count = pstmt.executeUpdate();
			successFlag = (count != 0) ? true : false;

		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt);
		}
		return successFlag;
	}

}

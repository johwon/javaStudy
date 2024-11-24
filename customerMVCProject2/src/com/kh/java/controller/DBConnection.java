package com.kh.java.controller;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnection {
	
	public static Connection dbCon() {
		// 객체참조변수 선언
		Connection con = null;
		
		//1. db.properties file에서 id, pw, url 가져오기
		String filePath = "D:\\javaStudy\\customerMVCProject\\src\\db.properties";
		Properties pt = new Properties();
		try {
			pt.load(new FileReader(filePath));
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		String id = pt.getProperty("id");
		String pw = pt.getProperty("pw");
		String url = pt.getProperty("url");
		
		// 2. jdbc driver load 3. connection
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, id, pw);
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

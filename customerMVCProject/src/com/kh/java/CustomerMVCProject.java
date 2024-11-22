package com.kh.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import com.kh.java.controller.CustomerResigterManager;
import com.kh.java.controller.DBConnection;
import com.kh.java.model.CustomerVO;
import com.kh.java.view.CustomerCURDMenu;
import com.kh.java.view.CustomerMenu;

public class CustomerMVCProject {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		boolean exitFlag = false;
		int menuNum;
		
		CustomerResigterManager crm = new CustomerResigterManager();
		while (!exitFlag) {
			System.out.println();
			CustomerMenu.dispMenu();
			menuNum = Integer.parseInt(sc.nextLine());
			System.out.println();
			switch (menuNum) {
			case CustomerCURDMenu.PRINT:
				crm.printManager();
				break;
			case CustomerCURDMenu.INSERT:
				crm.insertManager();
				break;
			case CustomerCURDMenu.UPDATE:
				crm.updateManager();
				break;
			case CustomerCURDMenu.DELETE:
				crm.deleteManager();
				break;
			case CustomerCURDMenu.ADD_POINT:
				crm.addPointManager();
				break;
			case CustomerCURDMenu.MEMBERSHIP_PRINT:
				crm.membershipPrintManager();
				break;
			case CustomerCURDMenu.EXIT:
				exitFlag = true;
				break;
			}

		}
		System.out.println("프로그램을 종료합니다");
	}

}
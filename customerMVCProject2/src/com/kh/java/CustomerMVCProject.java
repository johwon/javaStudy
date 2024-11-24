package com.kh.java;

import java.sql.SQLException;
import java.util.Scanner;
import com.kh.java.controller.CustomerResigterManager;
import com.kh.java.controller.OrdersResigterManager;
import com.kh.java.controller.ProductResigterManager;
import com.kh.java.view.CUSTOMER_CHOICE;
import com.kh.java.view.MENU_CHOICE;
import com.kh.java.view.MenuViewer;
import com.kh.java.view.ORDERS_CHOICE;
import com.kh.java.view.PRODUCT_CHOICE;

public class CustomerMVCProject {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		boolean exitFlag = false;
		int menuNum;
		
		while (!exitFlag) {
			MenuViewer.mainMenuView();
			menuNum = Integer.parseInt(sc.nextLine());
			switch (menuNum) {
			case MENU_CHOICE.CUSTOMER:
				customerMenu();
				break;
			case MENU_CHOICE.PRODUCT:
				productMenu();
				break;
			case MENU_CHOICE.ORDERS:
				ordersMenu();
				break;
			case MENU_CHOICE.EXIT:
				exitFlag = true;
				break;
			default :
				System.out.println("올바른 번호를 선택해주세요");
			}
		}
		System.out.println("프로그램을 종료합니다");
	}

	
	private static void ordersMenu() throws SQLException {
		MenuViewer.ordersMenuView();
		int menuNum = Integer.parseInt(sc.nextLine());
		System.out.println();
		OrdersResigterManager orm = new OrdersResigterManager();
		switch (menuNum) {
		case ORDERS_CHOICE.PRINT:
			orm.printManager();
			break;
		case ORDERS_CHOICE.INSERT:
			orm.insertManager();
			break;
		case ORDERS_CHOICE.UPDATE:
			orm.updateManager();
			break;
		case ORDERS_CHOICE.DELETE:
			orm.deleteManager();
			break;
		case ORDERS_CHOICE.EXIT:
			break;
		}
		System.out.println();
	}


	private static void productMenu() throws SQLException {
		MenuViewer.productMenuView();
		int menuNum = Integer.parseInt(sc.nextLine());
		System.out.println();
		ProductResigterManager prm = new ProductResigterManager();
		switch (menuNum) {
		case PRODUCT_CHOICE.PRINT:
			prm.printManager();
			break;
		case PRODUCT_CHOICE.INSERT:
			prm.insertManager();
			break;
		case PRODUCT_CHOICE.UPDATE:
			prm.updateManager();
			break;
		case PRODUCT_CHOICE.DELETE:
			prm.deleteManager();
			break;
		case PRODUCT_CHOICE.EXIT:
			break;
		}
		System.out.println();
	}


	private static void customerMenu() throws SQLException {
		MenuViewer.customerMenuView();
		int menuNum = Integer.parseInt(sc.nextLine());
		System.out.println();
		CustomerResigterManager crm = new CustomerResigterManager();
		switch (menuNum) {
		case CUSTOMER_CHOICE.PRINT:
			crm.printManager();
			break;
		case CUSTOMER_CHOICE.INSERT:
			crm.insertManager();
			break;
		case CUSTOMER_CHOICE.UPDATE:
			crm.updateManager();
			break;
		case CUSTOMER_CHOICE.DELETE:
			crm.deleteManager();
			break;
		case CUSTOMER_CHOICE.ADD_POINT:
			crm.addPointManager();
			break;
		case CUSTOMER_CHOICE.MEMBERSHIP_PRINT:
			crm.membershipPrintManager();
			break;
		case CUSTOMER_CHOICE.EXIT:
			break;
		}
		System.out.println();
	}

}
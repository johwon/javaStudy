package com.kh.java.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.kh.java.model.CustomerVO;
import com.kh.java.model.OrdersVO;
import com.kh.java.model.ProductVO;

public class OrdersResigterManager {
	public static Scanner sc = new Scanner(System.in);

	public void printManager() throws SQLException {
		System.out.println("모든 주문 정보를 조회합니다.");

		ArrayList<OrdersVO> ordersList = OrdersDAO.ordersPrint();

		// 출력
		for (OrdersVO ovo : ordersList) {
			System.out.println(ovo.toString());
		}
	}

	public void insertManager() throws SQLException {
		System.out.println("새 주문 등록을 시작합니다.");
		System.out.print("주문 번호 : ");
		String no = sc.nextLine();
		System.out.print("주문 고객 번호 : ");
		int c_id = Integer.parseInt(sc.nextLine());
		System.out.print("주문 상품 번호 : ");
		String p_no = sc.nextLine();
		System.out.print("주문 수량 : ");
		int amount = Integer.parseInt(sc.nextLine());
		OrdersVO ovo = new OrdersVO(no, c_id, p_no, amount);

		OrdersDAO.ordersInsert(ovo);
	}

	public void updateManager() throws SQLException {
		System.out.print("수정할 주문번호를 입력하세요 : ");
		String no = sc.nextLine();
		System.out.print("주문 고객 번호 : ");
		int c_id = Integer.parseInt(sc.nextLine());
		System.out.print("주문 상품 번호 : ");
		String p_no = sc.nextLine();
		System.out.print("주문 수량 : ");
		int amount = Integer.parseInt(sc.nextLine());
		OrdersVO ovo = new OrdersVO(no, c_id, p_no, amount);

		OrdersDAO.ordersUpdate(ovo);
	}

	public void deleteManager() throws SQLException {
		System.out.print("삭제할 주문번호를 입력하세요 : ");
		String no = sc.nextLine();
		OrdersVO ovo = new OrdersVO();
		ovo.setNo(no);

		OrdersDAO.ordersDelete(ovo);
	}

}

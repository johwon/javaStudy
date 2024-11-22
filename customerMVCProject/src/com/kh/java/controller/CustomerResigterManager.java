package com.kh.java.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.kh.java.model.CustomerVO;

public class CustomerResigterManager {
	public static Scanner sc = new Scanner(System.in);

	public void printManager() throws SQLException {
		System.out.println("모든 고객의 정보를 조회합니다.");

		ArrayList<CustomerVO> cList = CustomerDAO.customerPrint();

		// 출력
		for (CustomerVO c : cList) {
			System.out.println(c.toString());
		}
	}

	public void insertManager() throws SQLException {
		System.out.println("신규 고객 입력을 시작합니다.");
		System.out.print("고객 이름 : ");
		String name = sc.nextLine();
		System.out.print("핸드폰 번호 : ");
		String phone = sc.nextLine();
		System.out.print("주소 : ");
		String address = sc.nextLine();
		CustomerVO customer = new CustomerVO(name, phone, address);

		CustomerDAO.customerInsert(customer);
	}

	public void updateManager() throws SQLException {
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
		CustomerVO customer = new CustomerVO(id, name, phone, address, membership, point);

		CustomerDAO.customerUpdate(customer);
	}

	public void deleteManager() throws SQLException {
		System.out.print("삭제할 고객의 아이디를 입력하세요 : ");
		int id = Integer.parseInt(sc.nextLine());
		CustomerVO cvo = new CustomerVO();
		cvo.setId(id);

		CustomerDAO.customerDelete(cvo);
	}

	public void addPointManager() throws SQLException {
		System.out.print("고객의 아이디를 입력해주세요 : ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.print("추가할 포인트 : ");
		int addPoint = Integer.parseInt(sc.nextLine());

		CustomerDAO.addPoint(id, addPoint);
	}

	public void membershipPrintManager() throws SQLException {
		System.out.println("고객 등급을 조회합니다.");
		System.out.print("등급 조회할 고객의 아이디를 입력해주세요 : ");
		int id = Integer.parseInt(sc.nextLine());

		CustomerVO cvo = new CustomerVO();
		cvo.setId(id);

		CustomerDAO.membershipPrint(cvo);
	}

}

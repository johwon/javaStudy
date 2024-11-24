package com.kh.java.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.kh.java.model.CustomerVO;
import com.kh.java.model.ProductVO;

public class ProductResigterManager {
	public static Scanner sc = new Scanner(System.in);

	public void printManager() throws SQLException {
		System.out.println("모든 상품의 정보를 조회합니다.");

		ArrayList<ProductVO> productList = ProductDAO.productPrint();

		// 출력
		for (ProductVO p : productList) {
			System.out.println(p.toString());
		}
	}

	public void insertManager() throws SQLException {
		System.out.println("새 상품 등록을 시작합니다.");
		System.out.print("상품 번호 : ");
		String no = sc.nextLine();
		System.out.print("상품 이름 : ");
		String name = sc.nextLine();
		System.out.print("가격 : ");
		int price = Integer.parseInt(sc.nextLine());
		ProductVO p = new ProductVO(no, name, price);

		ProductDAO.productInsert(p);
	}

	public void updateManager() throws SQLException {
		System.out.print("수정할 상품번호를 입력하세요 : ");
		String no = sc.nextLine();
		System.out.print("상품 이름을 수정합니다 : ");
		String name = sc.nextLine();
		System.out.print("가격을 수정합니다 : ");
		int price = Integer.parseInt(sc.nextLine());
		ProductVO p = new ProductVO(no, name, price);

		ProductDAO.productUpdate(p);
	}

	public void deleteManager() throws SQLException {
		System.out.print("삭제할 상품번호를 입력하세요 : ");
		String no = sc.nextLine();
		ProductVO p = new ProductVO();
		p.setNo(no);

		ProductDAO.productDelete(p);
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

package com.kh.java.view;

public class MenuViewer {
	public static void mainMenuView() {
		System.out.println("*****메인 메뉴*****");
		System.out.println("1. 고객 관리하기");
		System.out.println("2. 상품 관리하기");
		System.out.println("3. 주문 관리하기");
		System.out.println("4. 종료하기");
		System.out.print("번호를 입력해주세요 : ");
	}
	
	public static void customerMenuView() {
		System.out.println("-----고객 관리 메뉴-----");
		System.out.println("1. 고객 정보 조회");
		System.out.println("2. 신규 고객 입력");
		System.out.println("3. 고객 정보 수정");
		System.out.println("4. 고객 정보 삭제");
		System.out.println("5. 고객 포인트 추가");
		System.out.println("6. 고객 등급 조회");
		System.out.println("7. 메인으로 돌아가기");
		System.out.print("번호를 입력해주세요 : ");
	}
	
	public static void productMenuView() {
		System.out.println("-----상품 관리 메뉴-----");
		System.out.println("1. 상품 조회");
		System.out.println("2. 새 상품 등록");
		System.out.println("3. 상품 수정");
		System.out.println("4. 상품 삭제");
		System.out.println("5. 메인으로 돌아가기");
		System.out.print("번호를 입력해주세요 : ");
	}
	
	public static void ordersMenuView() {
		System.out.println("-----상품 관리 메뉴-----");
		System.out.println("1. 주문 조회");
		System.out.println("2. 새 주문 등록");
		System.out.println("3. 주문 수정");
		System.out.println("4. 주문 삭제");
		System.out.println("5. 메인으로 돌아가기");
		System.out.print("번호를 입력해주세요 : ");
	}
}

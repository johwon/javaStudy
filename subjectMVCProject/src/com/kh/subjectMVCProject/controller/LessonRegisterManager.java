package com.kh.subjectMVCProject.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.subjectMVCProject.model.LessonVO;

public class LessonRegisterManager {
	public Scanner sc = new Scanner(System.in);

	// 과목등록 insert
	public void insertManager() {
		LessonDAO ldao = new LessonDAO();
		// 화면으로부터 입력받는다.
		System.out.print("과목약어(O-운영체제 / A-어셈블러 / C-컴파일러 / J-자료구조 / P-프로그래밍 / D-데이터베이스 / S-소프트웨어공학)>>");
		String abbre = sc.nextLine().trim();
		System.out.print("과목이름>>");
		String name = sc.nextLine();

		LessonVO lvo = new LessonVO(abbre, name);
		boolean successFlag = ldao.lessonInsert(lvo);

		// 화면출력
		if (successFlag == true) {
			System.out.println("입력 성공하였습니다.");
		} else {
			System.out.println("입력 실패하였습니다");
		}
	}
	
	// 과목목록 select
	public void selectManager() {
		LessonDAO ldao = new LessonDAO();

		// 화면으로부터 입력받는다.
		// 데이터베이스 요청
		LessonVO lvo = new LessonVO();
		ArrayList<LessonVO> lessonList = ldao.lessonSelect(lvo);
		// 화면출력
		if (lessonList.size() != 0) {
			printLessonList(lessonList);
		} else {
			System.out.println("출력할 데이터가 없습니다.");
		}
	}

	// 과목삭제 delete
	public void deleteManager() {
		LessonDAO ldao = new LessonDAO();
		LessonVO lvo = new LessonVO();
		
		//전체 리스트 보여줌
		ArrayList<LessonVO> lessonList = ldao.lessonSelect(lvo);
		// 화면출력
		if (lessonList.size() != 0) {
			printLessonList(lessonList);
		} else {
			System.out.println("출력할 데이터가 없습니다.");
			return;
		}
		// 화면으로부터 입력받는다.
		System.out.print("삭제할 번호>>");
		int no = Integer.parseInt(sc.nextLine());

		lvo = new LessonVO();
		lvo.setNo(no);
		boolean successFlag = ldao.lessonDelete(lvo);

		// 화면출력
		if (successFlag == true) {
			System.out.println(no + "번호가 삭제되었습니다.");
		} else {
			System.out.println(no + "번호 삭제 실패하였습니다.");
		}
	}

	// 과목수정 update
	public void updateManager() {
		LessonDAO ldao = new LessonDAO();
		LessonVO lvo = new LessonVO();
		//수정하기위해 전체출력요청
		ArrayList<LessonVO> lessonList = ldao.lessonSelect(lvo);
		if (lessonList.size() != 0) {
			printLessonList(lessonList);
		} else {
			System.out.println("출력할 데이터가 없습니다.");
		}
		// 화면으로부터 입력받는다.
		System.out.print("수정할 번호선택>>");
		int no = Integer.parseInt(sc.nextLine());
		System.out.print("과목약어(O-운영체제 / A-어셈블러 / C-컴파일러 / J-자료구조 / P-프로그래밍 / D-데이터베이스 / S-소프트웨어공학)>>");
		String abbre = sc.nextLine().trim();
		System.out.print("과목이름>>");
		String name = sc.nextLine();

		lvo = new LessonVO(no, abbre, name);
		boolean successFlag = ldao.lessonUpdate(lvo);

		// 화면출력
		if (successFlag == true) {
			System.out.println("수정하였습니다.");
		} else {
			System.out.println("수정 실패하였습니다");
		}
	}

	// 과목정렬 select sort
	public void selectSortManager() {
		LessonDAO ldao = new LessonDAO();
		LessonVO lvo = new LessonVO();

		// 화면으로부터 입력받는다.
		// 데이터베이스 요청
		ArrayList<LessonVO> lessonList = ldao.lessonSelectSort(lvo);

		// 화면출력
		if (lessonList.size() != 0) {
			printLessonList(lessonList);
		} else {
			System.out.println("출력할 데이터가 없습니다.");
		}
	}
	
	// 화면출력
	public void printLessonList(ArrayList<LessonVO> lessonList) {
		for (LessonVO data : lessonList) {
			System.out.println(data.toString());
		}
	}

}

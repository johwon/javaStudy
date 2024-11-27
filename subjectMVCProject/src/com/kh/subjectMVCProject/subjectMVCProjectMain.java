package com.kh.subjectMVCProject;

import java.sql.SQLException;
import java.util.Scanner;

import com.kh.subjectMVCProject.controller.LessonRegisterManager;
import com.kh.subjectMVCProject.controller.StudentRegisterManager;
import com.kh.subjectMVCProject.controller.SubjectRegisterManager;
import com.kh.subjectMVCProject.controller.TraineeRegisterManager;
import com.kh.subjectMVCProject.view.LESSON_CHOICE;
import com.kh.subjectMVCProject.view.MENU_CHOICE;
import com.kh.subjectMVCProject.view.MenuViewer;
import com.kh.subjectMVCProject.view.STUDENT_CHOICE;
import com.kh.subjectMVCProject.view.SUBJECT_CHOICE;
import com.kh.subjectMVCProject.view.TRAINEE_CHOICE;

public class subjectMVCProjectMain {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int choiceNum;
		boolean exitFlag = false;
		while (!exitFlag) {
			try {
				MenuViewer.mainMenuView();
				choiceNum = Integer.parseInt(sc.nextLine());
				switch (choiceNum) {
				case MENU_CHOICE.SUBJECT:
					subjectMenu();
					break;
				case MENU_CHOICE.STUDENT:
					studentMenu();
					break;
				case MENU_CHOICE.LESSON:
					lessonMenu();
					break;
				case MENU_CHOICE.TRAINEE:
					traineeMenu();
					break;
				case MENU_CHOICE.EXIT:
					System.out.println("프로그램을 종료합니다.");
					exitFlag = true;
					return;
				default:
					System.out.println("해당 메뉴 번호만 입력하세요.");
				}
			} catch (Exception e) {
				System.out.println("\n입력에 오류가 있습니다.\n프로그램을 다시 시작하세요.");
			}
		}
	}

	// 수강신청정보
	private static void traineeMenu() {
		int choiceNum;
		MenuViewer.traineeMenuView();

		choiceNum = Integer.parseInt(sc.nextLine());
		TraineeRegisterManager trm = new TraineeRegisterManager();
		switch (choiceNum) {
		case TRAINEE_CHOICE.INSERT:
			System.out.println("");
			trm.insertManager();
			break;
		case TRAINEE_CHOICE.UPDATE:
			System.out.println("");
	        trm.updateManager();
			break;
		case TRAINEE_CHOICE.LIST:
			System.out.println("");
	        trm.SelectManager();
			break;
		case TRAINEE_CHOICE.DELETE:
			System.out.println("");
	        trm.deleteManager();
			break;
		case TRAINEE_CHOICE.JOIN_LIST:
			System.out.println("");
			trm.SelectAllManager();
			break;
		case TRAINEE_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}
	}

	// 과목정보
	private static void lessonMenu() {
		int choiceNum;
		MenuViewer.lessonMenuView();

		choiceNum = Integer.parseInt(sc.nextLine());
		LessonRegisterManager lrm = new LessonRegisterManager();
		switch (choiceNum) {
		case LESSON_CHOICE.LIST:
			System.out.println("");
			lrm.selectManager();
			break;
		case LESSON_CHOICE.INSERT:
			System.out.println("");
			 lrm.insertManager();
			break;
		case LESSON_CHOICE.UPDATE:
			System.out.println("");
			lrm.updateManager();
			break;
		case LESSON_CHOICE.DELETE:
			System.out.println("");
			lrm.deleteManager();
			break;
		case LESSON_CHOICE.SORT:
			System.out.println("");
			lrm.selectSortManager();
			break;
		case LESSON_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}

	}

	// 학과정보메뉴
	private static void subjectMenu() throws SQLException {
		int choiceNum;
		MenuViewer.subjectMenuView();

		choiceNum = Integer.parseInt(sc.nextLine());
		SubjectRegisterManager srm = new SubjectRegisterManager();
		switch (choiceNum) {
		case SUBJECT_CHOICE.INSERT:
			System.out.println("");
			 srm.insertManager();	
			break;
		case SUBJECT_CHOICE.UPDATE:
			System.out.println("");
            srm.updateManager();
			break;
		case SUBJECT_CHOICE.LIST:
			System.out.println("");
            srm.selectManager();
			break;
		case SUBJECT_CHOICE.DELETE:
			System.out.println("");
            srm.deleteManager();
			break;
		case SUBJECT_CHOICE.SORT:
			System.out.println("");
			srm.sortManager();
			break;
		case SUBJECT_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}

	}

	// 학생정보메뉴
	private static void studentMenu() throws SQLException {
		int choiceNum;
		// StudentRegisterManager studnetManager = new StudentRegisterManager();
		MenuViewer.studentMenuView();
		choiceNum = Integer.parseInt(sc.nextLine());
		StudentRegisterManager srm = new StudentRegisterManager();
		switch (choiceNum) {
		case STUDENT_CHOICE.INSERT:
			System.out.println("");
			 srm.insertManager();
			break;
		case STUDENT_CHOICE.UPDATE:
			System.out.println("");
//           studnetManager.studnetUpdate();
			break;
		case STUDENT_CHOICE.LIST:
			System.out.println("");
            srm.selectManager();
			break;
		case STUDENT_CHOICE.DELETE:
			System.out.println("");
//            studnetManager.studnetTotalList();
			break;
		case STUDENT_CHOICE.LIST_ALL:
			System.out.println("");
            srm.selectAllManager();
			break;
		case STUDENT_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}

	}
}

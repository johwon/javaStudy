package com.kh.subjectMVCProject.model;

import java.sql.Date;

public class TraineeVO {
    private int no;			//pk seq
	private String sd_num;	//FK(STUDENT) 학생번호
	private String abbre;	//FK(LESSON) 과목별칭
	private String section; //전공,부전공,교양
	private Date tdate;		//수강신청일
	
	public TraineeVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TraineeVO(int no, String sd_num, String abbre, String section, Date tdate) {
		super();
		this.no = no;
		this.sd_num = sd_num;
		this.abbre = abbre;
		this.section = section;
		this.tdate = tdate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getSd_num() {
		return sd_num;
	}

	public void setSd_num(String sd_num) {
		this.sd_num = sd_num;
	}

	public String getAbbre() {
		return abbre;
	}

	public void setAbbre(String abbre) {
		this.abbre = abbre;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public Date getTdate() {
		return tdate;
	}

	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}

	@Override
	public String toString() {
		return "TraineeVO [no=" + no + ", sd_num=" + sd_num + ", abbre=" + abbre + ", section=" + section + ", tdate="
				+ tdate + "]";
	}
	
}

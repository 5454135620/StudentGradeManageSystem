package model;

public class Grade {
	private int TC_id;//课程类型
	private String Tno;
	private String Cno;
	private String Sno;
	private float Grade;
	

	public Grade() {
		super();
	}
	
	public Grade( int tC_id,String tno, String cno) {
		super();
		TC_id = tC_id;
		Tno = tno;
		Cno = cno;
	}
	
//教师成绩查询
	public Grade(String sno, float grade) {
		super();
		Sno = sno;
		Grade = grade;
	}

	public Grade(String sno,int tC_id, float grade) {
		super();
		TC_id = tC_id;
		Sno = sno;
		Grade = grade;
	}

	public Grade(int tC_id, String tno, String cno, String sno, float grade) {
		super();
		TC_id = tC_id;
		Tno = tno;
		Cno = cno;
		Sno = sno;
		Grade = grade;
	}
	public int getTC_id() {
		return TC_id;
	}
	public void setTC_id(int tC_id) {
		TC_id = tC_id;
	}
	public String getTno() {
		return Tno;
	}
	public void setTno(String tno) {
		Tno = tno;
	}
	public String getCno() {
		return Cno;
	}
	public void setCno(String cno) {
		Cno = cno;
	}
	public String getSno() {
		return Sno;
	}
	public void setSno(String sno) {
		Sno = sno;
	}
	public float getGrade() {
		return Grade;
	}
	public void setGrade(float grade) {
		Grade = grade;
	}
	
	
	
	

}

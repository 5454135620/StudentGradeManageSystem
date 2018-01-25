package model;
//课程对象模型
public class Course {
	private String Cno;
	private String Cname;
	private int Ccredit;
	
//构造方法重载：
public Course() {
	super();
}

public Course(String cno) {
	Cno = cno;
}
public Course(String cno, String cname, int ccredit) {
	Cno = cno;
	Cname = cname;
	Ccredit = ccredit;
}

//外部接口方法：
	public String getCno() {
		return Cno;
	}
	public void setCno(String cno) {
		Cno = cno;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	public int getCcredit() {
		return Ccredit;
	}
	public void setCcredit(int ccredit) {
		Ccredit = ccredit;
	}
	
}

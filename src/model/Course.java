package model;
//�γ̶���ģ��
public class Course {
	private String Cno;
	private String Cname;
	private int Ccredit;
	
//���췽�����أ�
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

//�ⲿ�ӿڷ�����
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

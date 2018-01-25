package model;

import java.sql.ResultSet;

import dao.Student_Dao;

public class Student {
	private String Sno;
	private String Sname;
	private int Sage;
	private String Ssex;
	private String Sclass;
	private String Stel;
	private String Sdept;
	private String Spass;
	
	public Student(){
		
	}
	
	public Student(String Sno) {
		this.Sno = Sno;
	}

	public Student(String sno, String spass) {
		super();
		Sno = sno;
		Spass = spass;
	}

	public Student(String sno,String ssex, String stel) {
		super();
		Sno = sno;
		Ssex = ssex;
		Stel = stel;
	}
//sno, sname, ssex, sage, sdept, sclass, stel, null
	public Student(String Sno,String Sname,String Ssex,int Sage, String Sdept, String Sclass,String Stel,String Spass){
		this.Sno = Sno;
		this.Sname = Sname;
		this.Ssex = Ssex;
		this.Sage = Sage;
		this.Sdept = Sdept;
		this.Sclass = Sclass;
		
		this.Stel = Stel;
		this.Spass = Spass;
	}

	public String getSpass() {
		return Spass;
	}
	public void setSpass(String spass) {
		Spass = spass;
	}
	public String getSno() {
		return Sno;
	}
	public void setSno(String sno) {
		Sno = sno;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public int getSage() {
		return Sage;
	}
	public void setSage(int sage) {
		Sage = sage;
	}
	public String getSsex() {
		return Ssex;
	}
	public void setSsex(String ssex) {
		Ssex = ssex;
	}
	public String getSclass() {
		return Sclass;
	}
	public void setSclass(String sclass) {
		Sclass = sclass;
	}
	public String getStel() {
		return Stel;
	}
	public void setStel(String stel) {
		Stel = stel;
	}
	public String getSdept() {
		return Sdept;
	}
	public void setSdept(String sdept) {
		Sdept = sdept;
	}
	@Override
	public String toString() {
		return "Student [Sno=" + Sno + ", Sname=" + Sname + ", Sage=" + Sage + ", Ssex=" + Ssex + ", Sclass=" + Sclass
				+ ", Stel=" + Stel + ", Sdept=" + Sdept + "]";
	}

	
	//ºó¼Ó£º
//	public static void main(String args[]){
//		Student_Dao sDao = new Student_Dao();
//		ResultSet rSet = sDao.stuSelecte(new Student(sno, sname, ssex, sage, sdept, sclass, stel, null));
//		System.out.println();
//
//	}

}

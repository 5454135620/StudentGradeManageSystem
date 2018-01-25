package model;

public class Teacher {
	private String Tno;
	private String Tname;
	private String Tsex;
	private String Tsdept;
	private String Tdegree;
	private String Ttitle;
	private String Ttel;
	private String password;
	
	
	public Teacher() {
		
	}
	public Teacher(String tno) {
		Tno = tno;
	}
	
	
	public Teacher(String tno, String ttel) {
		super();
		Tno = tno;
		Ttel = ttel;
	}
	public Teacher(String tno, String tname, String tsex, String tsdept, String tdegree, String ttitle, String ttel,
			String password) {
		Tno = tno;
		Tname = tname;
		Tsex = tsex;
		Tsdept = tsdept;
		Tdegree = tdegree;
		Ttitle = ttitle;
		Ttel = ttel;
		this.password = password;
	}
	public String getTno() {
		return Tno;
	}
	public void setTno(String tno) {
		Tno = tno;
	}
	public String getTname() {
		return Tname;
	}
	public void setTname(String tname) {
		Tname = tname;
	}
	public String getTsex() {
		return Tsex;
	}
	public void setTsex(String tsex) {
		Tsex = tsex;
	}
	public String getTsdept() {
		return Tsdept;
	}
	public void setTsdept(String tsdept) {
		Tsdept = tsdept;
	}
	public String getTdegree() {
		return Tdegree;
	}
	public void setTdegree(String tdegree) {
		Tdegree = tdegree;
	}
	public String getTtitle() {
		return Ttitle;
	}
	public void setTtitle(String ttitle) {
		Ttitle = ttitle;
	}
	public String getTtel() {
		return Ttel;
	}
	public void setTtel(String ttel) {
		Ttel = ttel;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

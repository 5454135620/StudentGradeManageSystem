package model;
//管理员对象模型
public class Admini {
   String Uno;
   String Password;
   public Admini(){
		
	}
	
	public Admini(String uno,String password){
		super();
		this.Uno = uno;
		this.Password = password;
	}

public String getUno() {
	return Uno;
}
public void setUno(String uno) {
	Uno = uno;
}
public String getPassword() {
	return Password;
}
public void setPassword(String aPassword) {
	Password = aPassword;
}

}

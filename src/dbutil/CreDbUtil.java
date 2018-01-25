package dbutil;
//实现创建数据库以及建表功能

import java.util.*;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



public class CreDbUtil {
	private DBUtil dbutil;
	String flag = "Y";
	
	
	Scanner input=new Scanner(System.in);
	// 创建数据库
	public void createDateBase() throws Exception {
		
		if (dbutil == null) {
			dbutil = new DBUtil();
		}
		try {
			Class.forName(StringUtil.driver);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
        //连接数据库
		Connection conn = dbutil.open();
		
		
   
		if (conn != null) {
			
			     if(flag == input.next()){
			    	 dropDatabase();

			    	 
			     }
					//删除数据库操作：
				
			} else {
			// 一开始必须填一个已经存在的数据库
			String url = "jdbc:mysql://localhost:3306/python?characterEncoding=utf8&useSSL=false";
			conn = DriverManager.getConnection(url, StringUtil.username, StringUtil.password);
			Statement stat = conn.createStatement();
			
			// 创建数据库
			try {
				stat.executeUpdate("create database  SSMS");// Student
															// achievement
															// management system
				System.out.println("创建数据库成功！");
			} catch (SQLException e) {
				e.printStackTrace();
			}

			// 打开创建的数据库
			stat.close();
			conn.close();

			conn = dbutil.open();
			stat= (Statement)conn.createStatement();
			
			stuTable(stat);
			teaTable(stat);
			couTable(stat);
			TCTable(stat);
			SCTable(stat);
			AUTable(stat);
			stat.close();
			conn.close();
			
		}
	}

	// 判断表的建立
	@SuppressWarnings("finally")
	public ResultSet getRes(Statement stat, String tableName) {
		ResultSet rSet = null;
		try {
			rSet = stat.getConnection().getMetaData().getTables(null, null, tableName, null);
		} catch (SQLException e) {
			System.out.println(tableName + "数据库还未创建！");
		} finally {
			return rSet;
		}
	}
//AU表
	public void AUTable(Statement stat) throws SQLException{
		if(getRes(stat, "AU").next()){
			
		}else{
			try{
				stat.executeUpdate("create table AU("
						+ "Uno char(10) primary key,"
						+ "password varchar(10) not null default '111111')");
				System.out.println("AU表创建成功！");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("AU表创建失败！");
			}
		}
	}
	// 学生表
	public void stuTable(Statement stat) throws SQLException {
		if (getRes(stat, "Student").next()) {

		} else {
			try {
				stat.executeUpdate(
						"create table Student(" + "Sno char(10) primary key," +
				"Sname varchar(10) not null," + "Ssex enum('男','女')  not null default'女',"
				+ "Sage tinyint unsigned  not null," + "Sdept varchar(20) not null," 
				+ "Sclass varchar(11) not null," + "Stel varchar(11) unique,"+ "password varchar(10) not null default'123456')"
				);
				System.out.println("Student表创建成功！");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Student表创建失败！");
			}
		}
	}

	// 教师表
	public void teaTable(Statement stat) throws SQLException {
		if (getRes(stat, "Teacher").next()) {

		} else {
			try {
				/*stat.executeUpdate("create table Teacher(" + "Tno char(10) primary key," + "Tname char(10),"
						+ "Tsex enum('男','女') not null," + "Ttel char(11) unique,"
								+ "Password char(16) not null default '123456')");*/
				/*
				 * stat.executeUpdate(
						"create table Student1(" + "Sno char(10) primary key," +
				"Sname varchar(10) not null," + "Ssex enum('男','女')  not null default'女',"
				+ "Ssage tinyint unsigned  not null," + "Sdept varchar(20) not null," 
				+ "Sclass varchar(11) not null," + "Spassword varchar(10) not null default'123456',"
				+ "Stel varchar(11) unique)"
				);*/
				stat.executeUpdate(
						"create table Teacher("+"Tno Char(10) primary key,"+
						"Tname varchar(10) not null ,"+"Tsex enum('男','女') default'女' not null,"+
						"Tsdept varchar(20) not null,"+"Tdegree enum('本科','硕士','博士','博士后') default'博士',"+
						"Ttitle enum('教授','副教授','讲师','助教') default'教授',"+
						"Ttel varchar(11) unique ,"+"password varchar(10) default'123456' not null)"
				);
				System.out.println("Teacher表创建成功！");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Teacher表创建失败！");
			}
		}
	}

	// 课程表
	public void couTable(Statement stat) throws SQLException {
		if (getRes(stat, "Course").next()) {

		} else {
			try {
//				stat.executeUpdate("create table Course(" + "Cno int primary key," + "Cname char(40) unique,"
//						+ "Cpno int," + "Ccredit int," + "foreign key(Cpno) references Course(Cno))");
				stat.executeUpdate(
						"create table Course("+"Cno varchar(10) primary key,"+
						"Cname varchar(20) not null,"+"Ccredit tinyint unsigned default '4' not null)"//学分 Ssage tinyint unsigned  not null,
				);
				System.out.println("Course表创建成功！");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Course表创建失败！");
			}
		}
	}
	// TC表
		public void TCTable(Statement stat) throws SQLException {
			if (getRes(stat, "TC").next()) {

			} else {
				try {//课程编号、教师号、课程号
//					stat.executeUpdate("create table TC(" + "Tno char(10)," + "Cno int," + "primary key(Tno,Cno),"
//							+ "index (Tno)," + "index (Cno),"
//							+ "foreign key(Tno) references Teacher(Tno) on delete cascade on update cascade,"
//							+ "foreign key(Cno) references Course(Cno) on delete cascade on update cascade)engine=InnoDB");
					stat.executeUpdate(
							"create table TC("+"TC_id int(10) primary key auto_increment,"+
							"Tno char(10) not null ,"+
							"Cno varchar(10) not null,"+
							"foreign key(Cno) references Course(Cno) on delete cascade on update cascade,"+
							"foreign key(Tno) references Teacher(Tno) on delete cascade on update cascade)engine=InnoDB"
					);
					System.out.println("TC表创建成功！");
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("TC表创建失败！");
				}
			}
		}

	// SC表
	public void SCTable(Statement stat) throws SQLException {
		if (getRes(stat, "SC").next()) {

		} else {
			try {
//				stat.executeUpdate("create table SC(" + "Sno char(10)," + "Cno int," + "Tno char(10)," + "Grade float,"
//						+ "primary key(Sno,Cno,Tno)," + "index (Sno)," + "index (Cno),"
//						+ "foreign key(Sno) references Student(Sno) on delete cascade on update cascade,"
//						+ "foreign key(Tno) references Teacher(Tno),"
//						+ "foreign key(Cno) references Course(Cno) on delete cascade on update cascade)engine=InnoDB");
				stat.executeUpdate(
						//一个数据库中各个表之间的主属性字段不能同时定义
						"create table SC("+"Sno char(10),"+
						"TC_id int(10), "+
						"primary key (Sno,TC_id),"+
						"Grade float unsigned default null )"/*,)"+
						"foreign key(Sno) references Student(Sno) on delete cascade on update cascade,"+
						"foreign key(TC_id) references TC(TC_id) on delete cascade on update cascade)engine=InnoDB"*/
				);
				System.out.println("SC表创建成功！");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("SC表创建失败！");
			}
		}
	}


	public void dropDatabase(){
		   //数据库连接
		   Connection conn = dbutil.open();
		   //创建表SQL
		   String sql = "drop database ssms";
		   try {
			Statement stmt=conn.createStatement();
			stmt.execute(sql);
			System.out.println("数据库删除成功！");
		} catch (SQLException e) {
			System.out.println("数据库删除失败！");
			e.printStackTrace();
		}
	   }
	
	//主调方法：
		public static void main(String args[]){
			CreDbUtil db = new CreDbUtil();
			try {
				db.createDateBase();
			} catch (Exception e) {
				e.printStackTrace();
			}	 
			
		}

}
/** 
 *编写时遇到的问题报错以及解决：
 * ①java.lang.NullPointerException 空指针异常  
 *   可能调用了没有写的方法
 * ②数据库建表的问题：
		 * 1.unsigned 要加在类型的后面
		 * 2.default ' ' 不加括号  可以用在int上
		 * 3.分隔符一定记得加,
		 * 4.primary key 和 auto_increment 必须加在一起
		 * 5.mysql定义主键定义重复的提示，解决：mysql不能定义多个主键必须这样，primary key （a,b）;
		 * 6.定义默认为空 default null;
 * 
 * 4. Multiple primary key defined：//一个数据库中各个表之间的主属性字段不能同时定义·
 * ③MYSQL出现1045异常 ：
 * 解决办法：http://blog.csdn.net/ldl22847/article/details/7941962
 * my.min文件位置：http://blog.csdn.net/scfscf114/article/details/70993202?locationNum=1&fps=1
 * 文件修改权限解决办法：先将它剪切到另外一个地方，会提示需要管理员身份，选择继续。然后修改，保存。再将它拷贝进去，此时又会提示需要管理员身份，选择继续。
 * 重设密码错误：update user set password = PASSWORD("rootadmin")where user = 'root';
ERROR 1054 (42S22): Unknown column 'password' in 'field list'
http://blog.csdn.net/u010603691/article/details/50379282解决
④
FOREIGN KEY 约束用于预防破坏表之间连接的行为。
FOREIGN KEY 约束也能防止非法数据插入外键列，因为它必须是它指向的那个表中的值之一。


6.教师姓名唯一：！

7：判断表内是否有记录 
//		select isnull((select top(1) 1 from tableName where conditions), 0)
//
//		结果为 1，则说明记录存在；结果为 0，则说明记录不存在。 
//		
 * 
 */
 
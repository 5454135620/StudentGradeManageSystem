package dbutil;
//ʵ�ִ������ݿ��Լ�������

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
	// �������ݿ�
	public void createDateBase() throws Exception {
		
		if (dbutil == null) {
			dbutil = new DBUtil();
		}
		try {
			Class.forName(StringUtil.driver);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
        //�������ݿ�
		Connection conn = dbutil.open();
		
		
   
		if (conn != null) {
			
			     if(flag == input.next()){
			    	 dropDatabase();

			    	 
			     }
					//ɾ�����ݿ������
				
			} else {
			// һ��ʼ������һ���Ѿ����ڵ����ݿ�
			String url = "jdbc:mysql://localhost:3306/python?characterEncoding=utf8&useSSL=false";
			conn = DriverManager.getConnection(url, StringUtil.username, StringUtil.password);
			Statement stat = conn.createStatement();
			
			// �������ݿ�
			try {
				stat.executeUpdate("create database  SSMS");// Student
															// achievement
															// management system
				System.out.println("�������ݿ�ɹ���");
			} catch (SQLException e) {
				e.printStackTrace();
			}

			// �򿪴��������ݿ�
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

	// �жϱ�Ľ���
	@SuppressWarnings("finally")
	public ResultSet getRes(Statement stat, String tableName) {
		ResultSet rSet = null;
		try {
			rSet = stat.getConnection().getMetaData().getTables(null, null, tableName, null);
		} catch (SQLException e) {
			System.out.println(tableName + "���ݿ⻹δ������");
		} finally {
			return rSet;
		}
	}
//AU��
	public void AUTable(Statement stat) throws SQLException{
		if(getRes(stat, "AU").next()){
			
		}else{
			try{
				stat.executeUpdate("create table AU("
						+ "Uno char(10) primary key,"
						+ "password varchar(10) not null default '111111')");
				System.out.println("AU�����ɹ���");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("AU����ʧ�ܣ�");
			}
		}
	}
	// ѧ����
	public void stuTable(Statement stat) throws SQLException {
		if (getRes(stat, "Student").next()) {

		} else {
			try {
				stat.executeUpdate(
						"create table Student(" + "Sno char(10) primary key," +
				"Sname varchar(10) not null," + "Ssex enum('��','Ů')  not null default'Ů',"
				+ "Sage tinyint unsigned  not null," + "Sdept varchar(20) not null," 
				+ "Sclass varchar(11) not null," + "Stel varchar(11) unique,"+ "password varchar(10) not null default'123456')"
				);
				System.out.println("Student�����ɹ���");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Student����ʧ�ܣ�");
			}
		}
	}

	// ��ʦ��
	public void teaTable(Statement stat) throws SQLException {
		if (getRes(stat, "Teacher").next()) {

		} else {
			try {
				/*stat.executeUpdate("create table Teacher(" + "Tno char(10) primary key," + "Tname char(10),"
						+ "Tsex enum('��','Ů') not null," + "Ttel char(11) unique,"
								+ "Password char(16) not null default '123456')");*/
				/*
				 * stat.executeUpdate(
						"create table Student1(" + "Sno char(10) primary key," +
				"Sname varchar(10) not null," + "Ssex enum('��','Ů')  not null default'Ů',"
				+ "Ssage tinyint unsigned  not null," + "Sdept varchar(20) not null," 
				+ "Sclass varchar(11) not null," + "Spassword varchar(10) not null default'123456',"
				+ "Stel varchar(11) unique)"
				);*/
				stat.executeUpdate(
						"create table Teacher("+"Tno Char(10) primary key,"+
						"Tname varchar(10) not null ,"+"Tsex enum('��','Ů') default'Ů' not null,"+
						"Tsdept varchar(20) not null,"+"Tdegree enum('����','˶ʿ','��ʿ','��ʿ��') default'��ʿ',"+
						"Ttitle enum('����','������','��ʦ','����') default'����',"+
						"Ttel varchar(11) unique ,"+"password varchar(10) default'123456' not null)"
				);
				System.out.println("Teacher�����ɹ���");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Teacher����ʧ�ܣ�");
			}
		}
	}

	// �γ̱�
	public void couTable(Statement stat) throws SQLException {
		if (getRes(stat, "Course").next()) {

		} else {
			try {
//				stat.executeUpdate("create table Course(" + "Cno int primary key," + "Cname char(40) unique,"
//						+ "Cpno int," + "Ccredit int," + "foreign key(Cpno) references Course(Cno))");
				stat.executeUpdate(
						"create table Course("+"Cno varchar(10) primary key,"+
						"Cname varchar(20) not null,"+"Ccredit tinyint unsigned default '4' not null)"//ѧ�� Ssage tinyint unsigned  not null,
				);
				System.out.println("Course�����ɹ���");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Course����ʧ�ܣ�");
			}
		}
	}
	// TC��
		public void TCTable(Statement stat) throws SQLException {
			if (getRes(stat, "TC").next()) {

			} else {
				try {//�γ̱�š���ʦ�š��γ̺�
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
					System.out.println("TC�����ɹ���");
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("TC����ʧ�ܣ�");
				}
			}
		}

	// SC��
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
						//һ�����ݿ��и�����֮����������ֶβ���ͬʱ����
						"create table SC("+"Sno char(10),"+
						"TC_id int(10), "+
						"primary key (Sno,TC_id),"+
						"Grade float unsigned default null )"/*,)"+
						"foreign key(Sno) references Student(Sno) on delete cascade on update cascade,"+
						"foreign key(TC_id) references TC(TC_id) on delete cascade on update cascade)engine=InnoDB"*/
				);
				System.out.println("SC�����ɹ���");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("SC����ʧ�ܣ�");
			}
		}
	}


	public void dropDatabase(){
		   //���ݿ�����
		   Connection conn = dbutil.open();
		   //������SQL
		   String sql = "drop database ssms";
		   try {
			Statement stmt=conn.createStatement();
			stmt.execute(sql);
			System.out.println("���ݿ�ɾ���ɹ���");
		} catch (SQLException e) {
			System.out.println("���ݿ�ɾ��ʧ�ܣ�");
			e.printStackTrace();
		}
	   }
	
	//����������
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
 *��дʱ���������ⱨ���Լ������
 * ��java.lang.NullPointerException ��ָ���쳣  
 *   ���ܵ�����û��д�ķ���
 * �����ݿ⽨������⣺
		 * 1.unsigned Ҫ�������͵ĺ���
		 * 2.default ' ' ��������  ��������int��
		 * 3.�ָ���һ���ǵü�,
		 * 4.primary key �� auto_increment �������һ��
		 * 5.mysql�������������ظ�����ʾ�������mysql���ܶ�������������������primary key ��a,b��;
		 * 6.����Ĭ��Ϊ�� default null;
 * 
 * 4. Multiple primary key defined��//һ�����ݿ��и�����֮����������ֶβ���ͬʱ���塤
 * ��MYSQL����1045�쳣 ��
 * ����취��http://blog.csdn.net/ldl22847/article/details/7941962
 * my.min�ļ�λ�ã�http://blog.csdn.net/scfscf114/article/details/70993202?locationNum=1&fps=1
 * �ļ��޸�Ȩ�޽���취���Ƚ������е�����һ���ط�������ʾ��Ҫ����Ա��ݣ�ѡ�������Ȼ���޸ģ����档�ٽ���������ȥ����ʱ�ֻ���ʾ��Ҫ����Ա��ݣ�ѡ�������
 * �����������update user set password = PASSWORD("rootadmin")where user = 'root';
ERROR 1054 (42S22): Unknown column 'password' in 'field list'
http://blog.csdn.net/u010603691/article/details/50379282���
��
FOREIGN KEY Լ������Ԥ���ƻ���֮�����ӵ���Ϊ��
FOREIGN KEY Լ��Ҳ�ܷ�ֹ�Ƿ����ݲ�������У���Ϊ����������ָ����Ǹ����е�ֵ֮һ��


6.��ʦ����Ψһ����

7���жϱ����Ƿ��м�¼ 
//		select isnull((select top(1) 1 from tableName where conditions), 0)
//
//		���Ϊ 1����˵����¼���ڣ����Ϊ 0����˵����¼�����ڡ� 
//		
 * 
 */
 
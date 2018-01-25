package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import model.Student;
import dbutil.*;

public class Student_Dao extends BaseDao{
	
	// ѧ�����ѯ����
		public ResultSet stuSelecte(Student stu) {
			StringBuffer SELECT = new StringBuffer("select * from Student");
			if (!StringUtil.isEmpty(stu.getSno())) {
				SELECT.append(" and Sno like '%" + stu.getSno() + "%'");
			}
			if (!StringUtil.isEmpty(stu.getSname())) {
				SELECT.append(" and Sname like '%" + stu.getSname() + "%'");
			}
			if (!StringUtil.isEmpty(stu.getSsex())) {
				SELECT.append(" and Ssex like '%" + stu.getSsex() + "%'");
			}
			if (stu.getSage() > 0) {
				SELECT.append(" and Sage = " + stu.getSage());
			}
			if (!StringUtil.isEmpty(stu.getSdept())) {
				SELECT.append(" and Sdept like '%" + stu.getSdept() + "%'");
			}
			if (!StringUtil.isEmpty(stu.getSclass())) {
				SELECT.append(" and Sclass like '%" + stu.getSclass() + "%'");
			}
			if (!StringUtil.isEmpty(stu.getStel())) {
				SELECT.append(" and Stel like '%" + stu.getStel() + "%'");
			}
			if (!StringUtil.isEmpty(stu.getSpass())) {
				SELECT.append(" and password like '" + stu.getSpass() + "'");
			}
			connection = dbUtil.open();
			try {
				ps = connection.prepareStatement(SELECT.toString().replaceFirst("and", "where"));
				rs = ps.executeQuery();
			} catch (SQLException e) {
				rs = null;
				e.printStackTrace();
			}

			return rs;
		}

	// ѧ�����޸���Ϣ
		public int stuModify(String sno, Student stu) {//sno,sname, ssex,sage,sdept, sclass, stel, null  
			String STUDENT_MODIFY = "update student set Sno = ?,Sname = ?,Ssex = ?,Sage = ?,Sdept = ?,Sclass = ?, Stel = ?,Password = ?"
					+ "where Sno = " + sno;
			int result = excuting(stu, STUDENT_MODIFY);
			//System.out.println("lllllllllllllll"+sno);
			//System.out.println("wwwwwwwwwwwww"+result);
			close();
			return result;
		}

	// ѧ���������Ϣ
		public int stuInsert(Student stu) {
			String STUDENT_INSET = "insert into student(sno,sname,ssex,sage,sdept, sclass, stel,Password) values(?,?,?,?,?,?,?,?);";
			//System.out.println("ccc");
			int result = excuting(stu, STUDENT_INSET);
			return result;
		}

	// ѧ����ɾ����Ϣ
		public int stuDelete(Student stu) {
			//ʵ��������ɾ����Ϊ����
			StringBuffer DELETE = new StringBuffer("delete from Student");
			if (!StringUtil.isEmpty(stu.getSno())) {
				DELETE.append(" and Sno = '" + stu.getSno() + "'");
			}
			connection = dbUtil.open();
			try {
				System.out.println(DELETE.toString().replaceFirst("and", "where"));
				ps = connection.prepareStatement(DELETE.toString().replaceFirst("and", "where"));
				return ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				return 0;
			}	
			
		}

	// ���������
		public int excuting(Student stu, String str) {
			connection = dbUtil.open();
			try {
				/*
				 * ������ԣ�Data truncated for column 'Ssex' at row 1
				 * �˴��Ǻ����ݿ��ֶ�˳�򲻶�Ӧ��ע��*/
				ps = connection.prepareStatement(str);
				ps.setString(1, stu.getSno());
				ps.setString(2, stu.getSname());
				ps.setString(3, stu.getSsex());
				ps.setInt(4, stu.getSage());
				ps.setString(5, stu.getSdept());
				ps.setString(6, stu.getSclass());
				ps.setString(7, stu.getStel());
				if (stu.getSpass() != null) {
					ps.setString(8, stu.getSpass());
				}else{
					ps.setString(8, "123456");//Ĭ������
				}
				return ps.executeUpdate();
			}catch (MySQLIntegrityConstraintViolationException e) {
				return -1;
			} catch (SQLException e) {
				e.printStackTrace();
				return 0;
			}
		}
		
		// ѧ���޸ĵ绰 +++++
	     public int telModiy(String tel,String sno) {
			String MODIFY = "update Student set Stel = " + tel + " where Sno = '" + sno+"'";
			connection = dbUtil.open();
			try {
				stat = connection.createStatement();
				return stat.executeUpdate(MODIFY);
			} catch (SQLException e) {
				e.printStackTrace();
				return 0;
			} finally {
				close();
			}
		
	     }

		
//		public static void main(String args[]){
//			// StudentDAO studentdao = new  StudentDAO();
//			 Student stu = new Student("15070641","˹����","Ů",20,"78945612310","�������ѧ�뼼��","123456"," ");
//			 Student_Dao sDao = new Student_Dao();
//				ResultSet rSet = sDao.stuSelecte(stu);
//				System.out.println("+++"+rSet);
//				//Student_Dao sDao = new Student_Dao();
//				//ResultSet rSet = sDao.stuSelecte(new Student(sno, sname, ssex, sage, sdept, sclass, stel, null));
//
//		}

}

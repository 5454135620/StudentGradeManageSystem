package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import model.*;
import dbutil.*;

public class TC_Dao extends BaseDao{
	//管理员查询学生成绩情况
		public ResultSet TCQuery(){
			
			String QUERY = "select TC.TC_id,TC.Cno,Cname,Ccredit,TC.Tno,Tname from TC,Teacher,Course where TC.Tno = Teacher.Tno and TC.Cno = Course.Cno order by TC.TC_id;";
			connection = dbUtil.open();
			System.out.println(QUERY);
			try {
				ps = connection.prepareStatement(QUERY);
				rs = ps.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rs;
		}
		
		//教师查询授课表
         public ResultSet T_TCQuery(String a){
			String QUERY = "select * from TC where Tno='"+a+"'";
			connection = dbUtil.open();
			System.out.println(QUERY);
			try {
				ps = connection.prepareStatement(QUERY);
				rs = ps.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rs;
		}
		
		//选择该老师所教某课程的学生成绩
		public ResultSet TCGrade(String Tno,String Cno){
//			String GRADE = "select SC.Sno,Sname,Ssex,Stel,grade from SC,Student,Course where SC.Tno = '" + Tno + "' and SC.Cno = Course.Cno"
//					+ " and Cname = '" + Cname + "' and SC.Sno = Student.Sno";
			String GRADE = "select SC.Sno,Sname,TC.TC_id,Cname,Grade from SC,Student,Course,TC where TC.Cno = '" + Cno + "'and TC.Tno ='"+Tno+"'"+
					" and TC.TC_id = SC.TC_id and TC.Cno = Course.Cno and SC.Sno = Student.Sno";
					
			System.out.println(Cno+"uuuuuuuuuuuuuuuuu"+Tno);
			connection = dbUtil.open();
			System.out.println(GRADE);
			try {
				ps = connection.prepareStatement(GRADE);
				return ps.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
   /*      
         public ResultSet TCGrade(String Tno,String Sno){
 			String GRADE = "select SC.Sno,Sname,Ssex,Stel,grade from SC,Student,Course where SC.Tno = '" + Tno + "' and SC.Cno = Course.Cno"
 					+ " and Cname = '" + Cname + "' and SC.Sno = Student.Sno";
 			
 			connection = dbUtil.open();
 			System.out.println(GRADE);
 			try {
 				ps = connection.prepareStatement(GRADE);
 				return ps.executeQuery();
 			} catch (SQLException e) {
 				e.printStackTrace();
 				return null;
 			}
 		}
	*/	
		//教师所教课程查询
		public ResultSet TCSelecte(Grade grade){
			StringBuffer sql = new StringBuffer("select * from tc ");
			if (!StringUtil.isEmpty(grade.getTC_id())) {
				sql.append(" where TC_id = " + grade.getTC_id());
			}
			connection = dbUtil.open();
			System.out.println(sql);
			try {
				ps = connection.prepareStatement(sql.toString());
				rs = ps.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rs;
			
		}
			
		
//修改授课表
		public int tcModify(int tc_id,Grade grade) {//sno,sname, ssex,sage,sdept, sclass, stel, null  
			
			String TC_MODIFY = "update tc set TC_id = ?,Tno = ?,Cno = ?"
					+"where TC_id = "+ grade.getTC_id();
    		connection = dbUtil.open();
			try {
				ps = connection.prepareStatement(TC_MODIFY );
				ps.setInt(1, grade.getTC_id());
				ps.setString(2, grade.getTno() );
				ps.setString(3, grade.getCno());
				//System.out.println(grade.getTC_id()+grade.getTno()+grade.getCno());
				return ps.executeUpdate();
			} catch (MySQLIntegrityConstraintViolationException e) {
				return 0;
			}catch (SQLException e) {
				e.printStackTrace();
				return 0;
			}
		}
			
		
		//添加教师教课记录
		public int TCInsert(Grade grade){
			String INSERT = "insert into tc(TC_id,Tno,Cno) values(?,?,?);";
			connection = dbUtil.open();
			try {
				ps = connection.prepareStatement(INSERT);
				ps.setInt(1, grade.getTC_id());
				ps.setString(2, grade.getTno() );
				ps.setString(3, grade.getCno());
				//System.out.println(grade.getTC_id()+grade.getTno()+grade.getCno());
				return ps.executeUpdate();
			} catch (MySQLIntegrityConstraintViolationException e) {
				return 0;
			}catch (SQLException e) {
				e.printStackTrace();
				return 0;
			}
		}
		
		//删除教师教课记录
		public int TCDelete(Grade grade){
			System.out.println();
			StringBuffer DELETE = new StringBuffer("delete from TC");
			//System.out.println("****8*******8"+grade.getTC_id());
			if (!StringUtil.isEmpty(grade.getTC_id())) {
				DELETE.append(" and TC_id = " + grade.getTC_id() );
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
		
		//学生根据课程号查询所有课程+++++++++++++++++++++++++++++++++++++++++++++
				public ResultSet TCQuery_Cno(String Cno) {
					
					String QUERY = "select TC.TC_id,TC.Cno,Cname,Ccredit,TC.Tno,Tname from TC,Teacher,Course where TC.Cno="+Cno+" and TC.Tno = Teacher.Tno and TC.Cno = Course.Cno order by TC.TC_id;";
					connection = dbUtil.open();
					System.out.println(QUERY);
					try {
						ps = connection.prepareStatement(QUERY);
						rs = ps.executeQuery();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					return rs;
				}
				

		
}

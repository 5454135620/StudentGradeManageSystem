package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;


import model.*;
import dbutil.*;
import dao.*;

public class Teacher_Dao extends BaseDao{
	// 教师表查询方法
		public ResultSet teaSelecte(Teacher tea){
			
			StringBuffer SELECT = new StringBuffer("select * from teacher");
			if(!StringUtil.isEmpty(tea.getTno())){
				SELECT.append(" and Tno like '%" + tea.getTno() + "%'");
			}
			connection = dbUtil.open();
			try {
				ps = connection.prepareStatement(SELECT.toString().replaceFirst("and", "where"));
				rs = ps.executeQuery();
				} catch (SQLException e) {
				e.printStackTrace();
				rs = null;
			}
			return rs;

		}


		//教师表信息的插入
		public int teaInsert(Teacher teacher){
			String TEACHER_INSERT = "insert into teacher(Tno,Tname,Tsex,Tdept,Tdegree,Ttitle,Ttel,Password) values(?,?,?,?,?,?,?,?);";
			int result = excuting(teacher, TEACHER_INSERT);
			close();
			return result; 
			
		}
		
		//教师表信息的删除
		public int teaDelete(Teacher tea){
			String TEACHER_DELETE = "delete from teacher where Tno = " + tea.getTno() + ";";
			connection = dbUtil.open();
			try {
				stat = connection.createStatement();
				return stat.executeUpdate(TEACHER_DELETE);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			return 0;
		}
		// 教师表信息的修改
		public int teaModify(String tno,Teacher teacher) {
			String TEACHER_MODIFY = "update teacher set Tno = ?,Tname = ?,Tsex = ?,Tdept = ?, Tdegree = ? ,Ttitle = ? , Ttel = ?,password = ?"
					+ "where Tno = "
					+ "'" + teacher.getTno() + "'";
			return excuting(teacher, TEACHER_MODIFY);
			
		}
		//更新与插入
		public int excuting(Teacher tea, String str){
			connection = dbUtil.open();
			//System.out.println(tea.getTno()+" "+tea.getTname()+" "+tea.getTsex());
			try {
				ps =connection.prepareStatement(str);
				ps.setString(1, tea.getTno());
				ps.setString(2, tea.getTname());
				ps.setString(3, tea.getTsex());
				ps.setString(4, tea.getTsdept());
				ps.setString(5, tea.getTdegree());
				ps.setString(6, tea.getTtitle());
				ps.setString(7, tea.getTtel());
				if (tea.getPassword() != null) {
					ps.setString(8, tea.getPassword());
				}else {
					ps.setString(8, "123456");
				}
				return ps.executeUpdate();
			}catch (MySQLIntegrityConstraintViolationException e) {
				return 0;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		}

		

}

package dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

//课程的数据库控制类
import dao.*;
import model.*;
import dbutil.*;

public class Course_Dao extends BaseDao {
	//课程查询方法：
	public ResultSet  CSelect(Course course){
			StringBuffer sql = new StringBuffer("select * from course");
			if (!StringUtil.isEmpty(course.getCno())) {
				//sql.append(" and Cno ='" + course.getCno() + "'");
				sql.append(" where Cno ='" + course.getCno() + "'");
			}
			connection = dbUtil.open();
			try {
				//System.out.println(sql.toString().replaceFirst("and", "where"));
				System.out.println(sql);
				//ps = connection.prepareStatement(sql.toString().replaceFirst("and", "where"));
				ps=connection.prepareStatement(sql.toString());
				rs = ps.executeQuery();
			} catch (SQLException e) {
				rs = null;
				e.printStackTrace();
			}

			return rs;
		}
	
	//课程修改方法：
	public int CModify(Course course, String Cno) {
		String MODIFY = "update course set cno = ?,cname = ?,ccredit = ? where cno = " +"'"+ Cno+"'";
		System.out.println(MODIFY);
		int result = excuting(course, MODIFY);
		return result;
	}

	//课程删除方法：
	public int CInsert(Course course){
		String sql = "insert into Course(Cno,Cname,Ccredit) values(?,?,?)";
		return excuting(course, sql);
	}
	
	public int Cdelete(Course course){
		String sql = "delete from Course where Cno = " + "'"+course.getCno()+"'";
		connection = dbUtil.open();
		try {
			stat = connection.createStatement();
			return stat.executeUpdate(sql);
		} catch (MySQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			return 0;
		}catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	// 更新与插入
	public int excuting(Course course, String str) {
		connection = dbUtil.open();
		try {
			ps = connection.prepareStatement(str);
			ps.setString(1, course.getCno());
			ps.setString(2, course.getCname());
			ps.setInt(3, course.getCcredit());
			return ps.executeUpdate();
		} catch (MySQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	

}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dbutil.DBUtil;

public class BaseDao {
	protected final static DBUtil dbUtil = DBUtil.getDBUtil();
	protected static ResultSet rs;
	protected static Statement stat;
	protected static PreparedStatement ps;
	protected static Connection connection;

	//关闭相关数据库连接
	public static void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stat != null) {
				stat.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (!connection.isClosed()) {
				dbUtil.close(connection);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//登录校验
	public static boolean login(String uNo, String uPassword,String category,String no){
	
		String SELECT = "select * from " + category + " where " + no + " = '" + uNo + "' and Password = '" + uPassword + "';";
		connection = dbUtil.open();
		try {
			stat = connection.createStatement();
			rs = stat.executeQuery(SELECT);
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			close();
		}
		
		return false;
	}
}

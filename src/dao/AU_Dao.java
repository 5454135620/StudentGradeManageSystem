package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.*;
import dbutil.*;

public class AU_Dao extends BaseDao {

	//密码匹配
	public ResultSet AUSelect(Admini au){
		String SELECT = "select * from au where Uno = '" + au.getUno() + "' and Password = '" + au.getPassword() + "'";
		connection = dbUtil.open();
		try {
			ps = connection.prepareStatement(SELECT);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			rs = null;
			e.printStackTrace();
		}
		return rs;
	}
	
	//修改管理员密码
	public int AUmodify(Admini au) {
		String MODIFY = "update au set password = '" +au.getPassword() + "' where uno = '" + au.getUno() + "'";
		connection = dbUtil.open();
		try {
			stat = connection.createStatement();
			return stat.executeUpdate(MODIFY);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

}

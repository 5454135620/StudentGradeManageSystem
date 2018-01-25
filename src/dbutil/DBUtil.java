package dbutil;
//数据库连接工具类
//配置文件必须在源码目录下
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBUtil {
	private Connection conn;


	//打开数据库方法
	public  Connection open(){
		try {
			if(conn ==null||conn.isClosed()){
				Class.forName(StringUtil.driver);//加载驱动
				conn = (Connection) DriverManager.getConnection(StringUtil.url, StringUtil.username, StringUtil.password);//获取数据库连接  【注意括号位置！！】()
				System.out.println("数据库连接成功！");
			}         
		} catch (SQLException e) {
			System.out.println("数据库连接失败！数据库还未创建");
		} catch (ClassNotFoundException e) {
			System.out.println("数据库驱动错误！");
		}
		return conn;
	}
	
	// 关闭数据库连接
			@SuppressWarnings("null")
			public void close(Connection con) throws SQLException {
				if (con != null || !con.isClosed()) {
					con.close();
					System.out.println("数据库连接已关闭");
				}
			}
	

	public static DBUtil getDBUtil() {
		return new DBUtil();
	}

	
	

	public static void main(String args[]){
		 DBUtil dbutil=new  DBUtil();
		 dbutil.open() ;
	}

	
	
	
	}

	

package dbutil;
//���ݿ����ӹ�����
//�����ļ�������Դ��Ŀ¼��
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBUtil {
	private Connection conn;


	//�����ݿⷽ��
	public  Connection open(){
		try {
			if(conn ==null||conn.isClosed()){
				Class.forName(StringUtil.driver);//��������
				conn = (Connection) DriverManager.getConnection(StringUtil.url, StringUtil.username, StringUtil.password);//��ȡ���ݿ�����  ��ע������λ�ã�����()
				System.out.println("���ݿ����ӳɹ���");
			}         
		} catch (SQLException e) {
			System.out.println("���ݿ�����ʧ�ܣ����ݿ⻹δ����");
		} catch (ClassNotFoundException e) {
			System.out.println("���ݿ���������");
		}
		return conn;
	}
	
	// �ر����ݿ�����
			@SuppressWarnings("null")
			public void close(Connection con) throws SQLException {
				if (con != null || !con.isClosed()) {
					con.close();
					System.out.println("���ݿ������ѹر�");
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

	

package dbutil;

import java.io.FileReader;
import java.io.Reader;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	public static String driver;//���ݿ�����
	public static String url;//���ݿ���
	public static String username;//����
	public static String password;//����
	//public static String url;
	
	static {//�����������ļ�����任������д
		Properties prop = new Properties();
		Reader in;
		try {
			in = new FileReader("src\\configer.properties");
			prop.load(in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver = prop.getProperty("driver");
		url = prop.getProperty("url");
		username = prop.getProperty("username");
		password = prop.getProperty("password");
	}
	

	
//	public static final int Done = 1;
//	public static final int Dall = 2;
	//�пշ���
	public static boolean isEmpty(String str){
		if("".equals(str)|| str==null){
			return true;
		}else{
			return false;
		}
	}
	
	//�в��շ���
	public static boolean isNotEmpty(String str){
		if(!"".equals(str)&&str!=null){
			return true;
		}else{
			return false;
		}
	}
	
	//�����п�
	public static boolean isEmpty(int num){
		if("".equals(num)||num==0){
			return true;
		}else{
			return false;
		}
	}
	
	//�ж��ַ����Ƿ�ȫΪ����  ��
		public static boolean isNumeric(String str){ 
			
			   Pattern pattern = Pattern.compile("[0-9]*"); 
			   Matcher isNum = pattern.matcher(str);
			   if( !isNum.matches() ){
			       return false; 
			   } 
			   return true; 
			}
		

}

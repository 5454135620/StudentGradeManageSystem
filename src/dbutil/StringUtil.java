package dbutil;

import java.io.FileReader;
import java.io.Reader;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	public static String driver;//数据库驱动
	public static String url;//数据库名
	public static String username;//姓名
	public static String password;//密码
	//public static String url;
	
	static {//可以用配置文件代替变换量的书写
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
	//判空方法
	public static boolean isEmpty(String str){
		if("".equals(str)|| str==null){
			return true;
		}else{
			return false;
		}
	}
	
	//判不空方法
	public static boolean isNotEmpty(String str){
		if(!"".equals(str)&&str!=null){
			return true;
		}else{
			return false;
		}
	}
	
	//数字判空
	public static boolean isEmpty(int num){
		if("".equals(num)||num==0){
			return true;
		}else{
			return false;
		}
	}
	
	//判断字符串是否全为数字  加
		public static boolean isNumeric(String str){ 
			
			   Pattern pattern = Pattern.compile("[0-9]*"); 
			   Matcher isNum = pattern.matcher(str);
			   if( !isNum.matches() ){
			       return false; 
			   } 
			   return true; 
			}
		

}

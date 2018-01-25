package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import model.*;
import dbutil.*;

public class SC_Dao extends BaseDao{
	
	
	// ���񴦲�ѯ���
		public ResultSet SCSelect(int TC_id, String Tno) {
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
		
		
//ѧ����ν����
		public ResultSet SCSelectS( String sno) {
			String QUERY = "select TC.TC_id,TC.Cno,Cname,Ccredit,TC.Tno,Tname from TC,Teacher,Course,SC where SC.Sno="+sno+" and TC.Tno = Teacher.Tno and TC.Cno = Course.Cno and SC.TC_id=TC.TC_id order by TC.TC_id;";
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

// ѧ���ɼ���ز�ѯ����  ++++
				public ResultSet S_SCSelectGrade(String sno) {
					StringBuffer SELECT = new StringBuffer( "select TC.Cno,Cname,Grade,Teacher.Tno,Tname,Ccredit from Course,SC,TC,teacher");
					if (!StringUtil.isEmpty(sno)) {
						SELECT.append(" and Sno = '" + sno + "'");
					}
					SELECT.append("and SC.TC_id = TC.TC_id and TC.Cno = Course.Cno and  TC.Tno = Teacher.Tno");
					//SELECT.append(" and SC.Cno = Course.Cno and grade is not null");// ��ѯѧ�������пγ̳ɼ�
					System.out.println(SELECT.toString().replaceFirst("and", "where"));
					return select(SELECT.toString().replaceFirst("and", "where"));
				}
//ѧ���ɼ���ѯ
				public ResultSet S_SCSelectGrade(String sno,String cno) {
					StringBuffer SELECT = new StringBuffer( "select TC.Cno,Cname,Grade,Teacher.Tno,Tname,Ccredit from Course,SC,TC,teacher");
					if (!StringUtil.isEmpty(sno)) {
						SELECT.append(" and Sno = '" + sno + "'");
					}
					if (!StringUtil.isEmpty(cno)) {
						SELECT.append(" and TC.Cno = '" + cno + "'");
					}
					SELECT.append("and SC.TC_id = TC.TC_id and TC.Cno = Course.Cno and TC.Tno = Teacher.Tno");
					//SELECT.append(" and SC.Cno = Course.Cno and grade is not null");// ��ѯѧ�������пγ̳ɼ�
					System.out.println(SELECT.toString().replaceFirst("and", "where"));
					return select(SELECT.toString().replaceFirst("and", "where"));
				}
				
				
//����--�ɼ���ѯ				
		public ResultSet SCSelectGrade(String sno,int tc_id) {
			
			StringBuffer SELECT = new StringBuffer( "select SC.Sno,SC.TC_id,Grade,TC.Cno,Cname,Ccredit,TC.Tno,Tname from Course,SC,TC,teacher");
			//System.out.println(sno+"ooooooooooo"+tc_id);
			System.out.println(!StringUtil.isEmpty(sno)+"ggg"+!StringUtil.isEmpty(tc_id));
			if(!StringUtil.isEmpty(sno)&&!StringUtil.isEmpty(tc_id)){
				SELECT.append(" and SC.Sno = '" + sno + "'"+" and SC.TC_id = " +tc_id+" ");
			}else{
				if (!StringUtil.isEmpty(sno)) {
					SELECT.append(" and SC.Sno = '" + sno + "' ");
				}
				else if (!StringUtil.isEmpty(tc_id)) {
					SELECT.append(" and SC.TC_id = " +tc_id+" ");
				}else{
					return null;
				}
			}
			SELECT.append("and SC.TC_id = TC.TC_id and TC.Cno = Course.Cno and TC.Tno = Teacher.Tno");
			System.out.println(SELECT.toString().replaceFirst("and", "where"));
			return select(SELECT.toString().replaceFirst("and", "where"));
}
//com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: You have an error in your SQL syntax; che �ո�
//
		//����ѧ�ֲ�ѯ-----���񴦿γ̲�ѯ
		public ResultSet SCSelectCredit(String sno) {
			String SC_SELECT = "select sum(Ccredit) from SC,Course where sno = '" + sno + "' and grade >= 0 and SC.cno = Course.Cno";
			System.out.println(SC_SELECT);
			return select(SC_SELECT);
		}


		// �޸ĳɼ�-------�����޸ĳɼ�
	     public int SCModiy(Grade sc) {
	    	//System.out.println("ppppppppppppppppppp"+sc.getSno());
			String MODIFY = "update SC set Grade = " + sc.getGrade() + " where Sno = '"+ sc.getSno()+"'"+" and TC_id = "+sc.getTC_id();
			System.out.println(MODIFY.toString());
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

		// ɾ��ѡ�μ�¼(sc.SCdelete(new Grade(uName,Cno,null,Tno,-1)) != 1){
	    public int SCdelete(Grade sc) {
	    	System.out.println(sc.getSno()+"iiiiiiiiiiiiiiii"+sc.getTC_id());
			String DELETE = "delete from SC where Sno = '" + sc.getSno() + "' and TC_id = " + sc.getTC_id() ;
			connection = dbUtil.open();
			try {
				stat = connection.createStatement();
				return stat.executeUpdate(DELETE);
			} catch (SQLException e) {
				e.printStackTrace();
				return 0;
			} finally {
				close();
			}
		}
	    
		// ���ѡ��
		public int SCInsert(Grade s) {
			String INSERT = "insert into SC(Sno,TC_id,Grade) values(?,?,?);";//Duplicate entry '1-2' for key 'PRIMARY'����  ���ݿ������Ѿ���д  �ظ�
			connection = dbUtil.open();
			try {
				ps = connection.prepareStatement(INSERT);
				ps.setString(1, s.getSno());
				ps.setInt(2, s.getTC_id());
				ps.setFloat(3, s.getGrade());
				return ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				return 0;
			} finally {
				close();
			}
		}

		// ��ѯִ��
		public ResultSet select(String SC_SELECT) {
			connection = dbUtil.open();
			try {
				stat = connection.createStatement();
				rs = stat.executeQuery(SC_SELECT);
			} catch (SQLException e) {
				e.printStackTrace();
				rs = null;
			}
			return rs;
		}

}

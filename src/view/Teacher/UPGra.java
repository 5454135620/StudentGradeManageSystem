/*
 * UPGra.java
 *
 * Created on __DATE__, __TIME__
 */

package view.Teacher;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import dao.*;
import dbutil.*;
import model.*;

/**
 *
 * @author  __USER__
 */
public class UPGra extends javax.swing.JFrame {

	private static String me;
	private static String cno;
	private static int count;
	private static String sno;

	public void setDefaultCloseOperation(int operation){
		operation=HIDE_ON_CLOSE; //设置隐藏当前窗口
	}

	/** Creates new form UPGra */
	public UPGra(String me) {
		this.me = me;
		//改变系统默认字体
		Font font = new Font("Dialog", Font.PLAIN, 12);
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, font);
			}
		}
		initComponents();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		CNO = new javax.swing.JLabel();
		CnoText = new javax.swing.JTextField();
		Find = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		Table = new javax.swing.JTable();
		SnoText = new javax.swing.JTextField();
		GradeInput = new javax.swing.JTextField();
		OKB = new javax.swing.JButton();
		SNO = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("\u6559\u5e08\u6210\u7ee9\u5f55\u5165");

		CNO.setText("\u8bfe\u7a0b\u53f7 \uff1a");

		Find.setText("\u67e5  \u8be2");
		Find.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				FindActionPerformed(evt);
			}
		});

		Table.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null } },
				new String[] { "学号", "学生名", "课程类型", "课程名", "成绩" }));
		Table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				TableMousePressed(evt);
			}
		});
		jScrollPane1.setViewportView(Table);

		GradeInput.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				GradeInputActionPerformed(evt);
			}

			private void GradeInputActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				
			}
		});

		OKB.setText("\u5f55  \u5165");
		OKB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				OKBActionPerformed(evt);
			}
		});

		SNO.setText("\u5b66 \u53f7 \uff1a");

		jLabel1.setText("\u6210 \u7ee9 \uff1a");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(88, 88, 88).addComponent(CNO).addGap(18, 18, 18)
								.addComponent(CnoText, javax.swing.GroupLayout.PREFERRED_SIZE, 104,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18).addComponent(Find, javax.swing.GroupLayout.PREFERRED_SIZE, 83,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup().addGap(23, 23, 23).addComponent(SNO).addGap(18, 18, 18)
								.addComponent(SnoText, javax.swing.GroupLayout.PREFERRED_SIZE, 90,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78,
										Short.MAX_VALUE)
								.addComponent(jLabel1)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(GradeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 93,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(51, 51, 51))
						.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1,
								javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup().addGap(182, 182, 182).addComponent(OKB,
								javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(27, 27, 27)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(CNO)
						.addComponent(Find).addComponent(CnoText, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18)
				.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(37, 37, 37)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(SNO)
						.addComponent(SnoText, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel1).addComponent(GradeInput, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(31, 31, 31).addComponent(OKB).addContainerGap(51, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
		//GEN-END:initComponents

	private void TableMousePressed(java.awt.event.MouseEvent evt) {
		int row = Table.getSelectedRow();
		count = 10;
		if(row<count){
			SnoText.setText((String) Table.getValueAt(row, 0));
			GradeInput.setText(String.valueOf(Table.getValueAt(row, 4)));
		}
		
	}

	//确认:
	private void OKBActionPerformed(java.awt.event.ActionEvent evt) {
		float grade = Float.parseFloat(GradeInput.getText());
		if( grade>0){
			Course_Dao cDao = new Course_Dao();
			SC_Dao sc_DAO = new SC_Dao();
     		ResultSet rSet = cDao.CSelect(new Course(CnoText.getText()));
			sno =SnoText.getText();
			if (sc_DAO.SCModiy(new Grade(sno,grade)) == 1) {
				fillTable();
				JOptionPane.showConfirmDialog(null, "成绩录入成功！", "提示", JOptionPane.CLOSED_OPTION);
			}

   }
	else{
	   JOptionPane.showConfirmDialog(null, "成绩不能为负数！", "提示", JOptionPane.CLOSED_OPTION);
   }	
     		
	}

	//查询
	private void FindActionPerformed(java.awt.event.ActionEvent evt) {
		fillTable();
	}

	private void GradeActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void fillTable() {
		cno = CnoText.getText();
		if (cno.equals("")) {
			JOptionPane.showConfirmDialog(null, "课程名不能为空！！", "提示", JOptionPane.CLOSED_OPTION);
		}
		DefaultTableModel dModel = (DefaultTableModel) Table.getModel();
		dModel.setRowCount(0);
		TC_Dao tDao = new TC_Dao();
		ResultSet rSet = tDao.TCGrade(me, cno);
		try {
			count = 0;
			while (rSet.next()) {
				Vector vector = new Vector();
				vector.add(rSet.getString(1));
				vector.add(rSet.getString(2));
				vector.add(rSet.getString(3));
				vector.add(rSet.getString(4));
				if (rSet.getFloat(5) < 0) {
					vector.add(0.0f);
				} else {
					vector.add(rSet.getFloat(5));
				}
				dModel.addRow(vector);
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseDao.close();
		}
	}

	/**
	* @param args the command line arguments
	*/
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new UPGra(me).setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JLabel CNO;
	private javax.swing.JTextField CnoText;
	private javax.swing.JButton Find;
	private javax.swing.JTextField GradeInput;
	private javax.swing.JButton OKB;
	private javax.swing.JLabel SNO;
	private javax.swing.JTextField SnoText;
	private javax.swing.JTable Table;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	// End of variables declaration//GEN-END:variables

}
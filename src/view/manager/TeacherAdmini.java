/*
 * TeacherAdmini.java
 *
 * Created on __DATE__, __TIME__
 */

package view.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.*;
import model.*;
import dbutil.*;

/**
 *
 * @author  __USER__
 */
public class TeacherAdmini extends javax.swing.JFrame {
	//私有变量
	private static int count = 0;

	private static String tno;
	private static String tname;
	private static String tsex;
	private static String tdept;
	private static String tdegree;
	private static String title;
	private static String ttel;

	private static String me;

	public void setDefaultCloseOperation(int operation) {
		operation = HIDE_ON_CLOSE;
	}

	/** Creates new form TeacherAdmini */
	public TeacherAdmini(String me) {
		this.me = me;
		ViewBase.setFront();
		initComponents();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		TeacherInfo = new javax.swing.JTabbedPane();
		jPanel1 = new javax.swing.JPanel();
		Tno = new javax.swing.JLabel();
		Find = new javax.swing.JButton();
		TnoText = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		Table = new javax.swing.JTable();
		jPanel = new javax.swing.JPanel();
		NewTnameText = new javax.swing.JTextField();
		NewTsexText = new javax.swing.JTextField();
		NewTsdeptText = new javax.swing.JTextField();
		NewDegreeText = new javax.swing.JTextField();
		NewTitleText = new javax.swing.JTextField();
		NewTtelText = new javax.swing.JTextField();
		NewTnoText = new javax.swing.JTextField();
		AddButton = new javax.swing.JButton();
		DeleteButton = new javax.swing.JButton();
		ModifyButton = new javax.swing.JButton();
		ResetButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("\u6559\u5e08\u7ba1\u7406");

		TeacherInfo.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				TeacherInfoStateChanged(evt);
			}
		});

		Tno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/用户3圆.png"))); // NOI18N
		Tno.setText("  \u6559 \u5e08 \u53f7 \uff1a");

		Find.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/查询.png"))); // NOI18N
		Find.setText("\u67e5  \u8be2");
		Find.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				FindActionPerformed(evt);
			}
		});

		Table.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null } },
				new String[] { "教师号", "姓名", "性别", "系别", "学历", "职称", "电话" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		Table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				TableMousePressed(evt);
			}
		});
		jScrollPane1.setViewportView(Table);

		jPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("\u8868\u5355\u64cd\u4f5c"));

		NewTnoText.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				NewTnoTextActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
		jPanel.setLayout(jPanelLayout);
		jPanelLayout.setHorizontalGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
						.addComponent(NewTnoText, javax.swing.GroupLayout.PREFERRED_SIZE, 93,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(28, 28, 28)
						.addComponent(NewTnameText, javax.swing.GroupLayout.PREFERRED_SIZE, 84,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(26, 26, 26)
						.addComponent(NewTsexText, javax.swing.GroupLayout.PREFERRED_SIZE, 89,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(NewTsdeptText, javax.swing.GroupLayout.PREFERRED_SIZE, 86,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(NewDegreeText, javax.swing.GroupLayout.PREFERRED_SIZE, 84,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
						.addComponent(NewTitleText, javax.swing.GroupLayout.PREFERRED_SIZE, 88,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18).addComponent(NewTtelText, javax.swing.GroupLayout.PREFERRED_SIZE, 96,
								javax.swing.GroupLayout.PREFERRED_SIZE)));
		jPanelLayout.setVerticalGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanelLayout.createSequentialGroup().addContainerGap()
						.addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(NewTnameText, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(NewTsexText, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(NewTsdeptText, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(NewDegreeText, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(NewTitleText, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(NewTnoText, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(NewTtelText, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(24, Short.MAX_VALUE)));

		AddButton.setText("\u6dfb  \u52a0");
		AddButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				AddButtonActionPerformed(evt);
			}
		});

		DeleteButton.setText("\u5220  \u9664");
		DeleteButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				DeleteButtonActionPerformed(evt);
			}
		});

		ModifyButton.setText("\u4fee  \u6539");
		ModifyButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ModifyButtonActionPerformed(evt);
			}
		});

		ResetButton.setText("\u91cd  \u7f6e");
		ResetButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ResetButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel1Layout.createSequentialGroup().addContainerGap(213, Short.MAX_VALUE).addComponent(Tno)
								.addGap(30, 30, 30)
								.addComponent(TnoText, javax.swing.GroupLayout.PREFERRED_SIZE, 131,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(36, 36, 36)
								.addComponent(Find,
										javax.swing.GroupLayout.PREFERRED_SIZE, 124,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(150, 150, 150))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addGap(57, 57, 57)
						.addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(68, 68, 68)
						.addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(89, 89, 89)
						.addComponent(ModifyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
						.addComponent(ResetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(50, 50, 50))
				.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE).addGroup(
						jPanel1Layout.createSequentialGroup().addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(39, 39, 39)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(Tno).addComponent(Find).addComponent(TnoText,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(20, 20, 20)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(ResetButton).addComponent(DeleteButton).addComponent(AddButton)
								.addComponent(ModifyButton))
						.addContainerGap(49, Short.MAX_VALUE)));

		TeacherInfo.addTab("\u6559\u5e08\u67e5\u8be2", jPanel1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(TeacherInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(TeacherInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
						.addContainerGap()));
		fillTable();
		pack();
	}// </editor-fold>
		//GEN-END:initComponents

	private void TableMousePressed(java.awt.event.MouseEvent evt) {
		//表单操作：实时显示到输入栏 方便修改
		int row = Table.getSelectedRow();
		count = 20;
		if (row < count) {
			NewTnoText.setText((String) Table.getValueAt(row, 0));
			NewTnameText.setText((String) Table.getValueAt(row, 1));
			NewTsexText.setText((String) Table.getValueAt(row, 2));
			NewTsdeptText.setText((String) Table.getValueAt(row, 3));
			NewDegreeText.setText((String) Table.getValueAt(row, 4));
			NewTitleText.setText((String) Table.getValueAt(row, 5));
			NewTtelText.setText((String) Table.getValueAt(row, 6));
		}
		fillTable();
	}

	private void ModifyButtonActionPerformed(java.awt.event.ActionEvent evt) {
		//修改
		messageGet();
   		Teacher_Dao tDao = new Teacher_Dao();
   		if (tDao.teaModify(tno,new Teacher(tno, tname, tsex, tdept, tdegree, title, ttel, null)) == 1) {
   			JOptionPane.showConfirmDialog(null, "修改成功！", "提示", JOptionPane.CLOSED_OPTION);
   			ResetButtonActionPerformed(evt); 
			fillTable();
		}else {
			JOptionPane.showConfirmDialog(null, "修改失败！请检查相关输入信息(学历/职称/非法修改主键)", "提示", JOptionPane.CLOSED_OPTION);
			ResetButtonActionPerformed(evt); 
			fillTable();
		}
	}

	private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
		messageGet();
		System.out.println("pppppppppppppppppppppppp" + tno);
		if (StringUtil.isEmpty(tno)) {
			JOptionPane.showConfirmDialog(null, "教师号不能为空！", "提示", JOptionPane.CLOSED_OPTION);
			return;
		}
		Teacher_Dao tDao = new Teacher_Dao();
		if (tDao.teaDelete(new Teacher(tno)) == 1) {
			JOptionPane.showConfirmDialog(null, "删除成功！", "提示", JOptionPane.CLOSED_OPTION);
			ResetButtonActionPerformed(evt);
			fillTable();
		} else {
			JOptionPane.showConfirmDialog(null, "删除失败！", "提示", JOptionPane.CLOSED_OPTION);
			ResetButtonActionPerformed(evt);
			fillTable();
		}
	}

	private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {
		//添加
		messageGet();
		if (StringUtil.isEmpty(tno)) {
			JOptionPane.showConfirmDialog(null, "教师号不能为空!", "提示", JOptionPane.CLOSED_OPTION);
			return;
		}
		if (StringUtil.isEmpty(tname)) {
			JOptionPane.showConfirmDialog(null, "教师名不能为空!", "提示", JOptionPane.CLOSED_OPTION);
			return;
		}
		if (StringUtil.isEmpty(tsex)) {
			JOptionPane.showConfirmDialog(null, "教师性别不能为空!", "提示", JOptionPane.CLOSED_OPTION);
			return;
		}
		if (!tsex.equals("男") && !tsex.equals("女")) {
			JOptionPane.showConfirmDialog(null, "性别输入非法!只能键入（男|女）", "提示", JOptionPane.CLOSED_OPTION);
			return;
		}
		if (StringUtil.isEmpty(tdept)) {
			JOptionPane.showConfirmDialog(null, "教师系别不能为空!", "提示", JOptionPane.CLOSED_OPTION);
			return;
		}
		if (StringUtil.isEmpty(tdegree)) {
			JOptionPane.showConfirmDialog(null, "教师学历不能为空!", "提示", JOptionPane.CLOSED_OPTION);
			return;
		}
		if (!tdegree.equals("本科") && !tdegree.equals("硕士") && !tdegree.equals("博士") && !tdegree.equals("博士后")) {
			JOptionPane.showConfirmDialog(null, "教师学历输入非法!只能键入（本科|硕士|博士|博士后）", "提示", JOptionPane.CLOSED_OPTION);
			return;
		}
		if (StringUtil.isEmpty(title)) {
			JOptionPane.showConfirmDialog(null, "教师职称不能为空!", "提示", JOptionPane.CLOSED_OPTION);
			return;
		}
		if (!title.equals("教授") && !title.equals("副教授") && !title.equals("讲师") && !title.equals("助教")) {
			JOptionPane.showConfirmDialog(null, "教师职称输入非法!只能键入（教授|副教授|讲师|助教）", "提示", JOptionPane.CLOSED_OPTION);
			return;
		}
		if (StringUtil.isEmpty(ttel)) {
			JOptionPane.showConfirmDialog(null, "教师电话不能为空!", "提示", JOptionPane.CLOSED_OPTION);
			return;
		}
		Teacher_Dao tDao = new Teacher_Dao();
		if (tDao.teaInsert(new Teacher(tno, tname, tsex, tdept, tdegree, title, ttel, null)) == 1) {
			JOptionPane.showConfirmDialog(null, "添加成功!", "提示", JOptionPane.CLOSED_OPTION);
			ResetButtonActionPerformed(evt);
			fillTable();
		} else {
			JOptionPane.showConfirmDialog(null, "添加失败!教师号或电话已被使用！", "提示", JOptionPane.CLOSED_OPTION);
		}

	}

	private void FindActionPerformed(java.awt.event.ActionEvent evt) {
		tno = null;
		fillTable();
	}

	private void TeacherInfoStateChanged(javax.swing.event.ChangeEvent evt) {
		// TODO add your handling code here:
	}

	private void NewTnoTextActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {
		//重置：
		this.TnoText.setText("");
		this.NewTnoText.setText("");
		this.NewTnameText.setText("");
		this.NewTsexText.setText("");
		this.NewTsdeptText.setText("");
		this.NewDegreeText.setText("");
		this.NewTitleText.setText("");
		this.NewTtelText.setText("");
	}

	private void messageGet() {
		tno = NewTnoText.getText().toString().trim();//去除空格trim()
		tname = NewTnameText.getText().toString().trim();
		tsex = NewTsexText.getText().toString().trim();
		tdept = NewTsdeptText.getText().toString().trim();
		tdegree = NewDegreeText.getText().toString().trim();
		title = NewTitleText.getText().toString().trim();
		ttel = NewTtelText.getText().toString().trim();
	}

	private void fillTable() {
		messageGet();
		if(tno.equals("")){
			tno = TnoText.getText();
		}
		DefaultTableModel dModel = (DefaultTableModel) Table.getModel();
		dModel.setRowCount(0);
		count = 0;

		Teacher_Dao tDao = new Teacher_Dao();
		ResultSet rSet = tDao.teaSelecte(new Teacher(tno, tname, tsex, tdept, tdegree, title, ttel, null));

		try {
			while (rSet.next()) {
				Vector vector = new Vector();
				vector.add(rSet.getString(1));
				vector.add(rSet.getString(2));
				vector.add(rSet.getString(3));
				vector.add(rSet.getString(4));
				vector.add(rSet.getString(5));
				vector.add(rSet.getString(6));
				vector.add(rSet.getString(7));
				vector.add(rSet.getString(8));
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
				new TeacherAdmini(me).setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton AddButton;
	private javax.swing.JButton DeleteButton;
	private javax.swing.JButton Find;
	private javax.swing.JButton ModifyButton;
	private javax.swing.JTextField NewDegreeText;
	private javax.swing.JTextField NewTitleText;
	private javax.swing.JTextField NewTnameText;
	private javax.swing.JTextField NewTnoText;
	private javax.swing.JTextField NewTsdeptText;
	private javax.swing.JTextField NewTsexText;
	private javax.swing.JTextField NewTtelText;
	private javax.swing.JButton ResetButton;
	private javax.swing.JTable Table;
	private javax.swing.JTabbedPane TeacherInfo;
	private javax.swing.JLabel Tno;
	private javax.swing.JTextField TnoText;
	private javax.swing.JPanel jPanel;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	// End of variables declaration//GEN-END:variables

}
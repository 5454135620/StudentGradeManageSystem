/*
 * CourseAdmini.java
 *
 * Created on __DATE__, __TIME__
 */

package view.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import dao.*;
import dbutil.*;
import model.*;
import view.manager.*;

/**
 *
 * @author  __USER__
 */
public class CourseAdmini extends javax.swing.JFrame {

	private Course cou;
	private static int select = 0;
	private static int count = 0;
	private static int countQ = 0;
	private static String cno;
	private static String cname;
	private static int ccredit;

	private static String tno;
	private static int tc_id;
	private static int tc_idText;

	private static String sno;
	private static String me;

	public void setDefaultCloseOperation(int operation) {
		operation = HIDE_ON_CLOSE;
	}

	/** Creates new form CourseAdmini */
	public CourseAdmini(String me) {
		this.me = me;
		sno = me;
		ViewBase.setFront();
		initComponents();
	}

	
	private void initComponents() {

		jTextField2 = new javax.swing.JTextField();
		jPanel2 = new javax.swing.JPanel();
		TabbedPane = new javax.swing.JTabbedPane();
		TC_SC = new javax.swing.JPanel();
		TC_id = new javax.swing.JLabel();
		FindQ = new javax.swing.JButton();
		TC_idText = new javax.swing.JTextField();
		jScrollPane2 = new javax.swing.JScrollPane();
		TableQ = new javax.swing.JTable();
		jPanel1 = new javax.swing.JPanel();
		TC_idQ = new javax.swing.JTextField();
		TnoQ = new javax.swing.JTextField();
		CnoQ = new javax.swing.JTextField();
		ResetQ = new javax.swing.JButton();
		DeleteQ = new javax.swing.JButton();
		AddQ = new javax.swing.JButton();
		ReInputQ = new javax.swing.JButton();
		Course = new javax.swing.JPanel();
		Cno = new javax.swing.JLabel();
		CnoText = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		Table = new javax.swing.JTable();
		jPanel3 = new javax.swing.JPanel();
		RenewCnoText = new javax.swing.JTextField();
		RenewCnameText = new javax.swing.JTextField();
		RenewCcreditText = new javax.swing.JTextField();
		Renew = new javax.swing.JButton();
		Add = new javax.swing.JButton();
		Delete = new javax.swing.JButton();
		Reset = new javax.swing.JButton();
		Find = new javax.swing.JButton();

		jTextField2.setText("jTextField2");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE));

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("\u8bfe\u7a0b\u7ba1\u7406");

		TC_id.setText("\u8bfe \u7a0b \u7c7b \u578b \uff1a");

		FindQ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/查询.png"))); // NOI18N
		FindQ.setText("\u67e5  \u8be2");
		FindQ.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				FindQActionPerformed(evt);
			}
		});

		TableQ.setModel(
				new javax.swing.table.DefaultTableModel(new Object[][] { { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null } }, new String[] { "课程类型", "教师号", "课程号" }) {
					boolean[] canEdit = new boolean[] { false, false, false };

					public boolean isCellEditable(int rowIndex, int columnIndex) {
						return canEdit[columnIndex];
					}
				});
		TableQ.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				TableQMousePressed(evt);
			}
		});
		jScrollPane2.setViewportView(TableQ);

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("\u5355\u8868\u64cd\u4f5c"));

		TnoQ.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				TnoQActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(26, 26, 26)
						.addComponent(TC_idQ, javax.swing.GroupLayout.PREFERRED_SIZE, 115,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(60, 60, 60)
						.addComponent(TnoQ, javax.swing.GroupLayout.PREFERRED_SIZE, 123,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
						.addComponent(CnoQ, javax.swing.GroupLayout.PREFERRED_SIZE, 124,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(34, 34, 34)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(TC_idQ, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(TnoQ, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(CnoQ, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		ResetQ.setText("\u4fee  \u6539");
		ResetQ.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ResetQActionPerformed(evt);
			}
		});

		DeleteQ.setText("\u5220  \u9664");
		DeleteQ.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				DeleteQActionPerformed(evt);
			}
		});

		AddQ.setText("\u6dfb  \u52a0");
		AddQ.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				AddQActionPerformed(evt);
			}
		});

		ReInputQ.setText("\u91cd  \u7f6e");
		ReInputQ.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ReInputQActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout TC_SCLayout = new javax.swing.GroupLayout(TC_SC);
		TC_SC.setLayout(TC_SCLayout);
		TC_SCLayout
				.setHorizontalGroup(TC_SCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(TC_SCLayout.createSequentialGroup().addGap(112, 112, 112).addComponent(TC_id)
								.addGap(18, 18, 18)
								.addComponent(TC_idText, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
								.addGap(18, 18, 18)
								.addComponent(FindQ, javax.swing.GroupLayout.PREFERRED_SIZE, 85,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(168, 168, 168))
						.addGroup(
								TC_SCLayout.createSequentialGroup().addContainerGap()
										.addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 559,
												Short.MAX_VALUE)
										.addContainerGap())
						.addGroup(TC_SCLayout.createSequentialGroup().addContainerGap()
								.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(20, Short.MAX_VALUE))
						.addGroup(TC_SCLayout.createSequentialGroup().addGap(42, 42, 42)
								.addComponent(ResetQ, javax.swing.GroupLayout.PREFERRED_SIZE, 85,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(44, 44, 44)
								.addComponent(DeleteQ, javax.swing.GroupLayout.PREFERRED_SIZE, 81,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(39, 39, 39)
								.addComponent(AddQ, javax.swing.GroupLayout.PREFERRED_SIZE, 92,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50,
										Short.MAX_VALUE)
								.addComponent(ReInputQ, javax.swing.GroupLayout.PREFERRED_SIZE, 90,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(60, 60, 60)));
		TC_SCLayout.setVerticalGroup(TC_SCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(TC_SCLayout.createSequentialGroup().addGap(42, 42, 42)
						.addGroup(TC_SCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(TC_id)
								.addComponent(TC_idText, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(FindQ))
						.addGap(18, 18, 18)
						.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(TC_SCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(ResetQ).addComponent(ReInputQ).addComponent(AddQ).addComponent(DeleteQ))
						.addContainerGap(37, Short.MAX_VALUE)));

		TabbedPane.addTab("\u6388\u8bfe\u64cd\u4f5c", TC_SC);

		Cno.setText(" \u8bfe \u7a0b \u53f7 \uff1a");

		Table.setModel(
				new javax.swing.table.DefaultTableModel(new Object[][] { { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null } }, new String[] { "课程号", "课程名", "学分" }) {
					boolean[] canEdit = new boolean[] { false, false, false };

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

		jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("\u8868\u5355\u64cd\u4f5c"));

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addGap(31, 31, 31)
						.addComponent(RenewCnoText, javax.swing.GroupLayout.PREFERRED_SIZE, 142,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(37, 37, 37)
						.addComponent(RenewCnameText, javax.swing.GroupLayout.PREFERRED_SIZE, 145,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(32, 32, 32)
						.addComponent(RenewCcreditText, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
						.addGap(31, 31, 31)));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(RenewCcreditText, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(RenewCnoText, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(RenewCnameText, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		Renew.setText("\u4fee  \u6539");
		Renew.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				RenewActionPerformed(evt);
			}
		});

		Add.setText("\u6dfb  \u52a0");
		Add.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				AddActionPerformed(evt);
			}
		});

		Delete.setText("\u5220  \u9664");
		Delete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				DeleteActionPerformed(evt);
			}
		});

		Reset.setText("\u91cd  \u7f6e");
		Reset.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ResetActionPerformed(evt);
			}
		});

		Find.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/查询.png"))); // NOI18N
		Find.setText("\u67e5  \u8be2");
		Find.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				FindActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout CourseLayout = new javax.swing.GroupLayout(Course);
		Course.setLayout(CourseLayout);
		CourseLayout.setHorizontalGroup(CourseLayout
				.createParallelGroup(
						javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(CourseLayout.createSequentialGroup().addGroup(CourseLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(javax.swing.GroupLayout.Alignment.LEADING, CourseLayout.createSequentialGroup()
								.addGap(127, 127, 127).addComponent(Cno).addGap(18, 18, 18)
								.addComponent(CnoText, javax.swing.GroupLayout.PREFERRED_SIZE, 117,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(58, 58, 58).addComponent(Find))
						.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
								CourseLayout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1,
										javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)))
						.addContainerGap())
				.addGroup(CourseLayout.createSequentialGroup().addGap(36, 36, 36)
						.addComponent(Renew, javax.swing.GroupLayout.PREFERRED_SIZE, 89,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
						.addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 87,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(47, 47, 47)
						.addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 85,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(49, 49, 49).addComponent(Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 86,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(55, 55, 55)));
		CourseLayout
				.setVerticalGroup(CourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(CourseLayout.createSequentialGroup().addGap(31, 31, 31).addGroup(CourseLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(Cno)
								.addComponent(CnoText, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(Find))
								.addGap(22, 22, 22)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(33, 33, 33)
								.addGroup(CourseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(Renew).addComponent(Delete).addComponent(Add).addComponent(Reset))
								.addContainerGap(46, Short.MAX_VALUE)));

		TabbedPane.addTab("\u8bfe\u7a0b\u64cd\u4f5c", Course);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				TabbedPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 588,
				Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				TabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE));

		fillTable();
		fillTable(Table, new Course());
		pack();
	}// </editor-fold>
		//GEN-END:initComponents

	private void TableQMousePressed(java.awt.event.MouseEvent evt) {
		
		int row = TableQ.getSelectedRow();
	    countQ = 10;//-------------------------------------------------------------
		if (row < countQ) {//初始化定义为0
			//TC_idQ.setText((int) TableQ.getValueAt(row, 0));
			if ((int) TableQ.getValueAt(row, 0) > 0) {
				TC_idQ.setText(String.valueOf(TableQ.getValueAt(row, 0)));
			} else {
				TC_idQ.setText(null);
			}
			TnoQ.setText((String) TableQ.getValueAt(row, 1));
			CnoQ.setText((String) TableQ.getValueAt(row, 2));
		}
	}

	private void FindQActionPerformed(java.awt.event.ActionEvent evt) {
		fillTable();
		tc_id = 0;//注意！
	}

	private void ReInputQActionPerformed(java.awt.event.ActionEvent evt) {
		TnoQ.setText("");
		TC_idQ.setText("");
		CnoQ.setText("");
		TC_idText.setText("");
	}

	private void AddQActionPerformed(java.awt.event.ActionEvent evt) {
		//添加授课表
		messageGetQ();
		if (StringUtil.isEmpty(cno)) {
			JOptionPane.showConfirmDialog(null, "课程号不能为空！", "提示", JOptionPane.CLOSED_OPTION);
			return;
		}
		if (StringUtil.isEmpty(tc_id)) {
			JOptionPane.showConfirmDialog(null, "课程类型不能为空！", "提示", JOptionPane.CLOSED_OPTION);
			return;
		}
		if (StringUtil.isEmpty(tno)) {
			JOptionPane.showConfirmDialog(null, "教师号不能为空！", "提示", JOptionPane.CLOSED_OPTION);
			return;
		}
		TC_Dao tDao = new TC_Dao();
		if (tDao.TCInsert(new Grade(tc_id, tno, cno)) != 0) {
			fillTable();
			JOptionPane.showConfirmDialog(null, "添加成功！", "恭喜", JOptionPane.CLOSED_OPTION);
		} else {
			JOptionPane.showConfirmDialog(null, "添加失败，请检查教师号和课程号是否正确!", "提示", JOptionPane.CLOSED_OPTION);
		}
	}

	private void ResetQActionPerformed(java.awt.event.ActionEvent evt) {
		//修改授课表
		messageGetQ();
		if (StringUtil.isEmpty(tc_id)) {
			JOptionPane.showConfirmDialog(null, "课程类型不能为空！", "提示", JOptionPane.CLOSED_OPTION);
			return;
		}
		if (StringUtil.isEmpty(cno)) {
			JOptionPane.showConfirmDialog(null, "课程号不能为空！", "提示", JOptionPane.CLOSED_OPTION);
			return;
		}
		if (StringUtil.isEmpty(tno)) {
			JOptionPane.showConfirmDialog(null, "教师号不能为空！", "提示", JOptionPane.CLOSED_OPTION);
			return;
		}
		TC_Dao tDao = new TC_Dao();
		if (tDao.tcModify(tc_id, new Grade(tc_id, tno, cno)) == 1) {
			fillTable();
			JOptionPane.showConfirmDialog(null, "修改成功！", "恭喜", JOptionPane.CLOSED_OPTION);
		} else {
			JOptionPane.showConfirmDialog(null, "修改失败，请检查教师号和课程号是否正确!", "提示", JOptionPane.CLOSED_OPTION);
		}

	}

	private void DeleteQActionPerformed(java.awt.event.ActionEvent evt) {
		//删除授课表
		messageGetQ();
		if (StringUtil.isEmpty(tc_id)) {
			JOptionPane.showConfirmDialog(null, "课程类型不能为空！", "提示", JOptionPane.CLOSED_OPTION);
			return;
		}
		TC_Dao tDao = new TC_Dao();
		if (tDao.TCDelete(new Grade(tc_id, tno, cno)) == 0) {
			ReInputQActionPerformed(evt);
			JOptionPane.showConfirmDialog(null, "删除成功！", "提示", JOptionPane.CLOSED_OPTION);
			fillTable();
		} else {
			JOptionPane.showConfirmDialog(null, "删除失败，请检查教师号和课程号是否正确!", "提示", JOptionPane.CLOSED_OPTION);
		}
	}

	private void TnoQActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void RenewActionPerformed(java.awt.event.ActionEvent evt) {
		//课程管理修改  不能改主键
		messageGet();
		Course_Dao cDao = new Course_Dao();
		System.out.println(cno);
		if (cDao.CModify(new Course(RenewCnoText.getText(), RenewCnameText.getText(),
				Integer.parseInt(RenewCcreditText.getText())), cno) != 1) {
			JOptionPane.showConfirmDialog(null, "填入内容不存在或已有！", "提示", JOptionPane.CLOSED_OPTION);
		} else {
			fillTable(Table, new Course());
			JOptionPane.showConfirmDialog(null, "修改成功！", "恭喜", JOptionPane.CLOSED_OPTION);
		}
	}

	//表格显示已有课程  课程修改版面
	private void TableMousePressed(java.awt.event.MouseEvent evt) {
		int row = Table.getSelectedRow();
		//count = 5; //报错修改：注意变量初始化  两个界面都用到了count 会互相影响  
		//Exception in thread "AWT-EventQueue-0" java.lang.ArrayIndexOutOfBoundsExcept  报错
		if (row < count) {
			//System.out.println(count);
			RenewCnoText.setText((String) Table.getValueAt(row, 0));
			RenewCnameText.setText((String) Table.getValueAt(row, 1));
			if ((int) Table.getValueAt(row, 2) >0) {
				//RenewCcreditText.setText((String) Table.getValueAt(row, 2));报错注意： java.lang.Integer cannot be cast to java.lang.String
				RenewCcreditText.setText(String.valueOf(Table.getValueAt(row, 2)));
			} else {
				RenewCcreditText.setText(null);
			}
		}

	}

	private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {
		messageGet();
		cno = RenewCnoText.getText();
		Course_Dao cDao = new Course_Dao();
		if (cDao.Cdelete(new Course(cno)) == 1) {

			fillTable(Table, new Course());
			ResetActionPerformed(evt);
			JOptionPane.showConfirmDialog(null, "删除成功！", "提示", JOptionPane.CLOSED_OPTION);
		} else {
			JOptionPane.showConfirmDialog(null, "删除失败，请检查输入内容！", "提示", JOptionPane.CLOSED_OPTION);
		}

	}

	private void FindActionPerformed(java.awt.event.ActionEvent evt) {
		cno = CnoText.getText();
		Course course = new Course(cno);
		Course_Dao s = new Course_Dao();
		s.CSelect(course);
		fillTable(Table, course);

	}

	private void AddActionPerformed(java.awt.event.ActionEvent evt) {
		messageGet();
		if (StringUtil.isEmpty(cno)) {
			JOptionPane.showConfirmDialog(null, "课程号不能为空！", "提示", JOptionPane.CLOSED_OPTION);
			return;
		}
		if (StringUtil.isEmpty(cname)) {
			JOptionPane.showConfirmDialog(null, "课程名不能为空！", "提示", JOptionPane.CLOSED_OPTION);
			return;
		}
		if (StringUtil.isEmpty(ccredit)) {
			JOptionPane.showConfirmDialog(null, "学分不能为空！", "提示", JOptionPane.CLOSED_OPTION);
			return;
		}
		Course_Dao cDao = new Course_Dao();
		if (cDao.CInsert(new Course(cno, cname, ccredit)) == 1) {
			fillTable(Table, new Course());
			JOptionPane.showConfirmDialog(null, "添加成功！", "恭喜", JOptionPane.CLOSED_OPTION);
		} else {
			JOptionPane.showConfirmDialog(null, "添加失败请检查输入内容！", "提示", JOptionPane.CLOSED_OPTION);
		}
	}

	//重置文本内容：
	private void ResetActionPerformed(java.awt.event.ActionEvent evt) {
		CnoText.setText("");
		RenewCnoText.setText("");
		RenewCcreditText.setText("");
		RenewCnameText.setText("");
	}

	private void fillTable(JTable jt, Course course) {

		DefaultTableModel dModel = (DefaultTableModel) jt.getModel();
		dModel.setRowCount(0);
		Course_Dao cDao = new Course_Dao();
		ResultSet rs = cDao.CSelect(course);
		try {
			count = 0;
			while (rs.next()) {
				Vector vector = new Vector();
				vector.add(rs.getString(1));
				vector.add(rs.getString(2));
				vector.add(rs.getInt(3));
				dModel.addRow(vector);
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseDao.close();
		}
	}

	private void fillTable() {
		System.out.println("ddddd");
		messageGetQ();
		String tc = TC_idText.getText();
		if (!tc.equals("")) {
			tc_id = Integer.parseInt(tc);
			//注意报错修改：数字转化为字符  For input string: "" 存在文本内容不输入的情况 
		}
		DefaultTableModel dModel = (DefaultTableModel) TableQ.getModel();
		dModel.setRowCount(0);
		TC_Dao tDao = new TC_Dao();
		System.out.println("检测文本输入内容是否为空？" + tc_id + "m" + tno + "P" + cno);
		ResultSet rSet = tDao.TCSelecte(new Grade(tc_id, tno, cno));// 可以为空 但是不能不写值 否则报错：com.mysql.jdbc.JDBC42PreparedStatement cannot be cast to dao.TC_Dao
		try {
			countQ = 0;
			while (rSet.next()) {
				Vector vector = new Vector();
				vector.add(rSet.getInt(1));
				vector.add(rSet.getString(2));
				vector.add(rSet.getString(3));
				dModel.addRow(vector);
				countQ++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BaseDao.close();
		}
	}

	private void messageGet() {
		cno = RenewCnoText.getText();
		cname = RenewCnameText.getText();
		String credit = RenewCcreditText.getText();
		if(!credit.equals("")){
		ccredit = Integer.parseInt(credit);
		}
		//RenewCnoText

	}

	private void messageGetQ() {
		//授课版面
		tno = TnoQ.getText();
		String tc = TC_idQ.getText();
		if (!tc.equals("")) {
			tc_id = Integer.parseInt(tc);
		}
		cno = CnoQ.getText();
		/*
		 * 报错：
		 * ① For input string: ""
		 * 字符串转换形式不对：有空格, 一般如果是空格的原因在这里For input String:"numbers  "这个引号里面就会有体现.在转换的后面来一个.trim()
		 * */
	}

	/**
	* @param args the command line arguments
	*/
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new CourseAdmini(me).setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton Add;
	private javax.swing.JButton AddQ;
	private javax.swing.JLabel Cno;
	private javax.swing.JTextField CnoQ;
	private javax.swing.JTextField CnoText;
	private javax.swing.JPanel Course;
	private javax.swing.JButton Delete;
	private javax.swing.JButton DeleteQ;
	private javax.swing.JButton Find;
	private javax.swing.JButton FindQ;
	private javax.swing.JButton ReInputQ;
	private javax.swing.JButton Renew;
	private javax.swing.JTextField RenewCcreditText;
	private javax.swing.JTextField RenewCnameText;
	private javax.swing.JTextField RenewCnoText;
	private javax.swing.JButton Reset;
	private javax.swing.JButton ResetQ;
	private javax.swing.JPanel TC_SC;
	private javax.swing.JLabel TC_id;
	private javax.swing.JTextField TC_idQ;
	private javax.swing.JTextField TC_idText;
	private javax.swing.JTabbedPane TabbedPane;
	private javax.swing.JTable Table;
	private javax.swing.JTable TableQ;
	private javax.swing.JTextField TnoQ;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTextField jTextField2;
	// End of variables declaration//GEN-END:variables

}
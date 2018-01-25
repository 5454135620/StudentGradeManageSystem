/*
 * AdminiLonFrm.java
 *
 * Created on __DATE__, __TIME__
 */

package view.manager;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import view.mainlogin.*;

/**
 *
 * @author  __USER__
 */
public class AdminiLonFrm extends javax.swing.JFrame {

	/** Creates new form AdminiLonFrm */
	private static String me;

	public AdminiLonFrm(String userName) {
		//改变系统默认字体
		me = userName;
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
		this.setSize(546, 405);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		AdminViewLabel = new javax.swing.JLabel();
		TButton = new javax.swing.JButton();
		SButton = new javax.swing.JButton();
		CButton = new javax.swing.JButton();
		RButton = new javax.swing.JButton();
		jMenuBar1 = new javax.swing.JMenuBar();
		SSMSMenu = new javax.swing.JMenu();
		PasswordMenu = new javax.swing.JMenu();
		SPasswordMenuItem = new javax.swing.JMenuItem();
		TPasswordMenuItem = new javax.swing.JMenuItem();
		APasswordMenuItem = new javax.swing.JMenuItem();
		ExitMenuItem = new javax.swing.JMenuItem();
		AboutUsMenu = new javax.swing.JMenu();
		HelpMenuItem = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("\u6559\u52a1\u5904\u7ba1\u7406\u7cfb\u7edf");
		setResizable(false);

		AdminViewLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/教务处主界面 (2).jpg"))); // NOI18N

		TButton.setText("\u6559\u5e08\u7ba1\u7406");
		TButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				TButtonActionPerformed(evt);
			}
		});

		SButton.setText("\u5b66\u751f\u7ba1\u7406");
		SButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				SButtonActionPerformed(evt);
			}
		});

		CButton.setText("\u8bfe\u7a0b\u7ba1\u7406");
		CButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CButtonActionPerformed(evt);
			}
		});

		RButton.setText("\u6210\u7ee9\u7ba1\u7406");
		RButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				RButtonActionPerformed(evt);
			}
		});

		SSMSMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/学生成绩管理系统主UI.png"))); // NOI18N
		SSMSMenu.setText("\u7cfb\u7edf\u7ba1\u7406");
		SSMSMenu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				SSMSMenuActionPerformed(evt);
			}
		});

		PasswordMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/密码修改方.png"))); // NOI18N
		PasswordMenu.setText("\u5bc6\u7801\u4fee\u6539");
		PasswordMenu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				PasswordMenuActionPerformed(evt);
			}
		});

		SPasswordMenuItem.setText("\u5b66\u751f\u5bc6\u7801\u4fee\u6539");
		SPasswordMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				SPasswordMenuItemActionPerformed(evt);
			}
		});
		PasswordMenu.add(SPasswordMenuItem);

		TPasswordMenuItem.setText("\u6559\u5e08\u5bc6\u7801\u4fee\u6539");
		TPasswordMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				TPasswordMenuItemActionPerformed(evt);
			}
		});
		PasswordMenu.add(TPasswordMenuItem);

		APasswordMenuItem.setText("\u6211\u7684\u5bc6\u7801\u4fee\u6539");
		APasswordMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				APasswordMenuItemActionPerformed(evt);
			}
		});
		PasswordMenu.add(APasswordMenuItem);

		SSMSMenu.add(PasswordMenu);

		ExitMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/退出系统红.png"))); // NOI18N
		ExitMenuItem.setText("\u9000\u51fa\u7cfb\u7edf");
		ExitMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ExitMenuItemActionPerformed(evt);
			}
		});
		SSMSMenu.add(ExitMenuItem);

		jMenuBar1.add(SSMSMenu);

		AboutUsMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/关于我们.png"))); // NOI18N
		AboutUsMenu.setText("\u5173\u4e8e\u6211\u4eec");

		HelpMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/项目帮助.png"))); // NOI18N
		HelpMenuItem.setText("\u9879\u76ee\u5e2e\u52a9");
		HelpMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				HelpMenuItemActionPerformed(evt);
			}
		});
		AboutUsMenu.add(HelpMenuItem);

		jMenuBar1.add(AboutUsMenu);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(41, 41, 41).addComponent(TButton).addGap(37, 37, 37)
						.addComponent(SButton).addGap(33, 33, 33).addComponent(CButton).addGap(40, 40, 40)
						.addComponent(RButton))
				.addComponent(AdminViewLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 529,
						javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addComponent(AdminViewLabel).addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(SButton)
						.addComponent(TButton).addComponent(CButton).addComponent(RButton))
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
		//GEN-END:initComponents
		//关于我们：

	private void HelpMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		new AboutUs().setVisible(true);//******************把主界面创建出来
	}

	//密码修改*********************************************************************************
	private void PasswordMenuActionPerformed(java.awt.event.ActionEvent evt) {
	

	}

	//教师密码修改
	private void TPasswordMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		new TeacherPassword(me).setVisible(true);
	}
	//管理员密码修改
	private void APasswordMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		new AdminiPassword(me).setVisible(true);
	}
	//学生密码修改
	private void SPasswordMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		new StudentPassword(me).setVisible(true);
	}
	//退出系统程序
	private void ExitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		int result = JOptionPane.showConfirmDialog(null, "是否退出系统");
		if (result == 0) {//获得点击值  0是1否2取消
			this.dispose();
			new MainLogin().setVisible(true);
		}
	}

	//

	private void SSMSMenuActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	//成绩管理跳转
	void RButtonActionPerformed(java.awt.event.ActionEvent evt) {
		new GradeAdmini(me).setVisible(true);
	}
	//课程管理跳转
	void CButtonActionPerformed(java.awt.event.ActionEvent evt) {
		new CourseAdmini(me).setVisible(true);
	}
	//学生管理跳转
	void SButtonActionPerformed(java.awt.event.ActionEvent evt) {
		new StudentAdmini().setVisible(true);
	}
	//教师管理跳转
	private void TButtonActionPerformed(java.awt.event.ActionEvent evt) {
		new TeacherAdmini(me).setVisible(true);
	}

	/**
	* @param args the command line arguments
	*/
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new AdminiLonFrm(me).setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JMenuItem APasswordMenuItem;
	private javax.swing.JMenu AboutUsMenu;
	private javax.swing.JLabel AdminViewLabel;
	private javax.swing.JButton CButton;
	private javax.swing.JMenuItem ExitMenuItem;
	private javax.swing.JMenuItem HelpMenuItem;
	private javax.swing.JMenu PasswordMenu;
	private javax.swing.JButton RButton;
	private javax.swing.JButton SButton;
	private javax.swing.JMenuItem SPasswordMenuItem;
	private javax.swing.JMenu SSMSMenu;
	private javax.swing.JButton TButton;
	private javax.swing.JMenuItem TPasswordMenuItem;
	private javax.swing.JMenuBar jMenuBar1;
	// End of variables declaration//GEN-END:variables

}
/*
 * 1.问题：
 * 跳转界面如何实现返回：zzz
 * 2.Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
注释问题*/

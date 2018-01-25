/*
 * MainLogin.java
 *
 * Created on __DATE__, __TIME__
 */

package view.mainlogin;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import dao.*;
import model.*;
import dbutil.*;
import dbutil.StringUtil;
import view.Teacher.TeacherLonFrm;
import view.manager.*;
import view.student.StudentALonFrm;

/**
 *
 * @author  __USER__
 */
public class MainLogin extends javax.swing.JFrame {
	//private static final String UseName = null;
	//获取数据库连接：
	DBUtil dbutil = new DBUtil();
	AU_Dao user_Dao = new AU_Dao();
	
//	//定义登录界面需要的文本内容
//	private String uName;
//	private String uPass;
//	private String uIdentity;

	/** Creates new form MainLogin */
	public MainLogin() {
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
		this.setSize(526, 405);
		// 设置Frame居中显示
		this.setLocationRelativeTo(null);
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		MainViewOnjLabel = new javax.swing.JLabel();
		UserNameLabel = new javax.swing.JLabel();
		PassWordLabel = new javax.swing.JLabel();
		UseTypeLabel = new javax.swing.JLabel();
		UseTypeComboBox = new javax.swing.JComboBox();//用户类型
		UseNameTextField = new javax.swing.JTextField();
		PasswordTextField = new javax.swing.JTextField();
		OkButton = new javax.swing.JButton();
		ReplaceButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("\u6559\u52a1\u5904\u6210\u7ee9\u7ba1\u7406\u7cfb\u7edf\u767b\u5f55");
		setResizable(false);
		getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		MainViewOnjLabel.setForeground(new java.awt.Color(255, 255, 255));
		MainViewOnjLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/中北大学教务处.png"))); // NOI18N
		getContentPane().add(MainViewOnjLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 140));

		UserNameLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/用户3.png"))); // NOI18N
		UserNameLabel.setText("   \u7528 \u6237 \u540d \uff1a");
		getContentPane().add(UserNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, -1, -1));

		PassWordLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/钥匙主界面圆.png"))); // NOI18N
		PassWordLabel.setText("   \u5bc6    \u7801  \uff1a");
		getContentPane().add(PassWordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, -1));

		UseTypeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/问号2全蓝.png"))); // NOI18N
		UseTypeLabel.setText("   \u7528\u6237\u7c7b\u578b\uff1a");
		getContentPane().add(UseTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, -1, -1));

		UseTypeComboBox.setModel(
				new javax.swing.DefaultComboBoxModel(new String[] { "学生", "老师", "管理员" }));
		UseTypeComboBox.setToolTipText("");

		
		getContentPane().add(UseTypeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 120, -1));


		getContentPane().add(UseNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 120, -1));


		getContentPane().add(PasswordTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 120, -1));

		OkButton.setText("\u786e  \u5b9a");
		OkButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				OkButtonActionPerformed(evt);
			}
		});
		getContentPane().add(OkButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, -1, -1));

		ReplaceButton.setText("\u91cd  \u7f6e");
		ReplaceButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ReplaceButtonActionPerformed(evt);
			}
		});
		getContentPane().add(ReplaceButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, -1, -1));

		pack();
	}// </editor-fold>
		//GEN-END:initComponents

	//事件编写

	//确认按钮功能实现----------------进入对应的界面
	private void OkButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		String userName = UseNameTextField.getText();
		String password = new String(PasswordTextField.getText());
		//加密码判定
		String typeId = (String) UseTypeComboBox.getSelectedItem();//getSelectedItem();//uIdentity
		System.out.println(typeId);
		if (StringUtil.isEmpty(userName)) {
			//判定用户名不能为空
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if (StringUtil.isEmpty(password)) {
			//密码不能为空
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		if("学生".equals(typeId) && BaseDao.login(userName, password, "Student", "Sno")){
			new StudentALonFrm(userName).setVisible(true);
			dispose();
		}else if ("老师".equals(typeId) && BaseDao.login(userName, password, "Teacher", "Tno")) {
			new TeacherLonFrm(userName).setVisible(true);
			dispose();
		}else if("管理员".equals(typeId) && BaseDao.login(userName, password, "AU", "Uno")){
			new AdminiLonFrm(userName).setVisible(true);
			dispose();
		}else {
			JOptionPane.showConfirmDialog(null, "用户名、密码或用户身份不匹配！","提示",JOptionPane.CLOSED_OPTION);
		}//加上
	}
	
	//重置按钮功能实现----------------------清空内容
	private void ReplaceButtonActionPerformed(java.awt.event.ActionEvent evt) {
		this.UseNameTextField.setText("");
		this.PasswordTextField.setText("");
	}

	
	/**
	* @param args the command line arguments
	*/
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainLogin().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JLabel MainViewOnjLabel;
	private javax.swing.JButton OkButton;
	private javax.swing.JLabel PassWordLabel;
	private javax.swing.JTextField PasswordTextField;
	private javax.swing.JButton ReplaceButton;
	private javax.swing.JTextField UseNameTextField;
	private javax.swing.JComboBox UseTypeComboBox;
	private javax.swing.JLabel UseTypeLabel;
	private javax.swing.JLabel UserNameLabel;
	// End of variables declaration//GEN-END:variables

	
	
}
/**报错：Duplicate entry '1' for key 'PRIMARY'
 * 主键输入重复报错！
 * 获取类型的方法注意一下
 * 密码隐身输入未实现！
 */
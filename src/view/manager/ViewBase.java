package view.manager;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.UIManager;

public  class ViewBase extends JFrame {
	public static void setFront(){
		//�ı�ϵͳĬ������
				Font font = new Font("Dialog", Font.PLAIN, 12);
				java.util.Enumeration keys = UIManager.getDefaults().keys();
				while (keys.hasMoreElements()) {
					Object key = keys.nextElement();
					Object value = UIManager.get(key);
					if (value instanceof javax.swing.plaf.FontUIResource) {
						UIManager.put(key, font);
					}
				}
	}
	
}

package MainFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Home extends JFrame{
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu1 = new JMenu("��Ʒά��(F)");
	private JMenu menu2 = new JMenu("ǰ̨����(S)");
	private JMenu menu3 = new JMenu("��Ʒ����(N)");
	private JMenuItem menuItem1 = new JMenuItem("��");
	private JMenuItem menuItem2 = new JMenuItem("��");
	private JMenuItem menuItem3 = new JMenuItem("��");
	InternalFrame productinfo;
	InternalFrame counter;
	InternalFrame productmanager;
	private MyActionListener actionListener1 = new MyActionListener(productinfo, "��Ʒά��");
	private MyActionListener actionListener2 = new MyActionListener(counter, "ǰ̨����");
	private MyActionListener actionListener3 = new MyActionListener(productmanager, "��Ʒ����");
	JDesktopPane desktopPane = new JDesktopPane();    //�������
	public Home() {
		super("�̳��������ϵͳ");
		setVisible(true);
		setSize(800, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setJMenuBar(menuBar);
		desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);  //�����ڲ������϶�ģʽ
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		menu1.setMnemonic('F');
		menu2.setMnemonic('S');
		menu3.setMnemonic('N');
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);
		menu1.add(menuItem1);
		menu2.add(menuItem2);
		menu3.add(menuItem3);
		menuItem1.addActionListener(actionListener1);
		menuItem2.addActionListener(actionListener2);
		menuItem3.addActionListener(actionListener3);
	}
	
	public static void main(String[] args) {
		new Home();
	}
	
	class MyActionListener implements ActionListener {
		InternalFrame internalFrame;
		String title;
		public MyActionListener(InternalFrame internalFrame, String title) {
			// TODO Auto-generated constructor stub
			this.internalFrame = internalFrame;
			this.title = title;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			//��ʼ���Ӵ���
			if(internalFrame ==null || internalFrame.isClosed()){
                JInternalFrame[] allFrames = desktopPane.getAllFrames();
                int titleBarHight = 30 * allFrames.length;
                int x= 10 + titleBarHight, y = x;
                internalFrame = new InternalFrame(title);
                internalFrame.setBounds(x, y, 480, 300);//����λ�����С 
                internalFrame.setVisible(true);   //�ɼ�
                desktopPane.add(internalFrame);   //��ӵ��������
            }
            try
            {
            	internalFrame.setSelected(true);
            }catch(PropertyVetoException propertyVetoE){
                propertyVetoE.printStackTrace();
            }
		}
		
	}
}
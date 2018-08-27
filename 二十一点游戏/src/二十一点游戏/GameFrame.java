package ��ʮһ����Ϸ;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

public class GameFrame  extends JFrame implements ActionListener{
	JButton clear_btn = new JButton("ϴ��");
	JButton compute_btn = new JButton("��ʼ��Ϸ");
	JButton game_btn = new JButton("���ץ��");
	JButton gameover_btn = new JButton("���ֽ���");
	CardManager cm = new CardManager();
	JLabel game[] = new JLabel[52];  //����52���˿��Ƶı�ǩ
	int i = 0;  //����ץ����
	int computer_dot = 0;  //������Ե���
	int game_dot = 0;  //������ҵ���
	Vector v = new Vector();  //�洢����ץ��ֽ��
	JLabel jLabel1 = new JLabel("������ʾ����");
	JLabel jLabel2 = new JLabel("�����ʾ����");
	public GameFrame() {
		getContentPane().setLayout(null);
		this.setTitle("��ʮһ����Ϸ");
		this.setSize(800, 500);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();  //�����Ļ�Ŀ�͸�
		Dimension frameSize = this.getSize();  //��õ�ǰ����Ŀ�͸�
		//���ô������
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		this.setLocation((screenSize.width-frameSize.width)/2, (screenSize.height-frameSize.height)/2);
		clear_btn.setBounds(new Rectangle(78, 388, 73, 31));
		clear_btn.addActionListener(this);
		compute_btn.setBounds(new Rectangle(233, 388, 86, 31));
		compute_btn.setEnabled(false);
		compute_btn.addActionListener(this);
		game_btn.setBounds(new Rectangle(413, 389, 91, 32));
		game_btn.setEnabled(false);
		game_btn.addActionListener(this);
		gameover_btn.setBounds(new Rectangle(625, 390, 91, 32));
		gameover_btn.setEnabled(false);
		gameover_btn.addActionListener(this);
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("�ļ�");
		JMenu help = new JMenu("����");
		JMenuItem fileExit = new JMenuItem("�˳�");
		JMenuItem helpAbout = new JMenuItem("����");
		this.setJMenuBar(menuBar);
		menuBar.add(file);
		menuBar.add(help);
		file.add(fileExit);
		fileExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		help.add(helpAbout);
		helpAbout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new AboutFrame();
			}
		});
		jLabel1.setBounds(new Rectangle(104, 343, 95, 38));
		jLabel2.setBounds(new Rectangle(499, 343, 92, 33));
		this.getContentPane().add(jLabel1);
		this.getContentPane().add(jLabel2);
		this.getContentPane().add(clear_btn);
		this.getContentPane().add(compute_btn);
		this.getContentPane().add(game_btn);
		this.getContentPane().add(gameover_btn);
		this.setVisible(true);
		this.setResizable(false);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//ϴ�ư�ť
		if (arg0.getSource() == clear_btn) {
			//�رպͿ�����Ӧ�İ�ť
			compute_btn.setEnabled(true);
			clear_btn.setEnabled(false);
			//�Լ����������Ե�������ҵ������г�ʼ��
			i = 0;
			computer_dot = 0;
			game_dot = 0;
			//�ѱ�ǩ��ؼ�������봰�崰����
			cm.gameStart(game, this.getContentPane());
			//��ʼ��ֽ��
			cm.initCards();
			//�������ֽ��
			cm.randomCards();
		}
		
		//��ʼ��Ϸ��ť
		if (arg0.getSource() == compute_btn) {
			//�رպͿ�����Ӧ�İ�ť
			compute_btn.setEnabled(false);
			game_btn.setEnabled(true);
			//����ץ��
			for (int k = 0; k < 20; k++) {
				game[i].setIcon(new ImageIcon("images/rear.jpg"));
				game[i].setBounds(new Rectangle(50 + i*20, 200, 101, 150));
				getContentPane().setComponentZOrder(game[i], 1);
				if (cm.cards[i].getValue() == 10) {
					computer_dot = computer_dot + 1;
				}else {
					computer_dot = computer_dot + cm.cards[i].getValue();
				}
				v.add(cm.cards[i]);
				getContentPane().repaint();
				i = i + 1;
				//�����ֵ��������15ֹͣץ��
				if (computer_dot >= 15) {
					return;
				}
			}
		}
		
		//���ץ�ư�ť
		if (arg0.getSource() == game_btn) {
			//��ʾ
			if (game_dot >= 10) {
				int a = JOptionPane.showConfirmDialog(null, "���ڵ���Ϊ:"+game_dot+"�Ƿ���ץ��", "��ʾ", JOptionPane.YES_NO_OPTION);
				if (a == JOptionPane.NO_OPTION) {
					game_btn.setEnabled(false);
					gameover_btn.setEnabled(true);
					return;
				}
			}
			//���ñ�ǩ��������ʾץ����ֽ��
			game[i].setIcon(new ImageIcon("images/"+cm.cards[i].getType()+"-"+cm.cards[i].getValue()+".jpg"));
			game[i].setBounds(new Rectangle(350 + i*20, 200, 101, 150));
			this.getContentPane().setComponentZOrder(game[i], 1);
			//����ץ����ֽ����ֵ
			if (cm.cards[i].getValue() > 10) {
				game_dot = game_dot + 1;
			}else {
				game_dot = game_dot + cm.cards[i].getValue();
			}
			i = i + 1;
			//��ֵ����21ֹͣץ�ƣ��رպͿ�����Ӧ��ť
			if (game_dot > 21) {
				game_btn.setEnabled(false);
				gameover_btn.setEnabled(true);
				return;
			}
		}
		
		//������Ϸ������ť
		if (arg0.getSource() == gameover_btn) {
			for (int i = 0; i < v.size(); i++) {
				Card card = (Card)v.get(i);
				game[i].setIcon(new ImageIcon("images/"+card.getType()+"-"+card.getValue()+".jpg"));
				game[i].setBounds(new Rectangle(50 + i*20, 200, 101, 150));
				this.getContentPane().setComponentZOrder(game[i], 1);
			}
			//����ʤ��
			String game_over = "";
			if (game_dot > 21 && computer_dot <= 21) {
				game_over = "���Ի�ʤ";
			} else if (game_dot <= 21 && computer_dot > 21) {
				game_over = "��һ�ʤ";
			}else if (game_dot >= 21 & computer_dot >= 21) {
				game_over = "ƽ��";
			}else if (game_dot > computer_dot) {
				game_over = "��һ�ʤ";
			}else if (game_dot < computer_dot) {
				game_over = "���Ի�ʤ";
			}else if (game_dot == computer_dot) {
				game_over = "ƽ��";
			}
			//�ԶԻ���ķ�ʽ��ʾʤ��
			String message = "��Ϸ���\n";
			message = message + "���Ե���:" + String.valueOf(computer_dot) + "\n";
			message = message + "��ҵ���:" + String.valueOf(game_dot) + "\n";
			message = message + "��Ϸ���:" + game_over;
			JOptionPane.showMessageDialog(null, message, "������Ϸ���", JOptionPane.INFORMATION_MESSAGE);
			//�������ť�ɲ���
			clear_btn.setEnabled(true);
			compute_btn.setEnabled(true);
			game_btn.setEnabled(true);
			gameover_btn.setEnabled(true);
		}
	}
	
	public static void main(String[] args) {
		GameFrame gameFrame = new GameFrame();
	}
}

package calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CalFrame extends JFrame implements ActionListener{
	JLabel label1 = new JLabel("��һλ������");
	JLabel label2 = new JLabel("�ڶ�λ������");
	JLabel label3 = new JLabel("������");
	JTextField textField1 = new JTextField();
	JTextField textField2 = new JTextField();
	JTextField textField = new JTextField();
	JRadioButton radioButton1 = new JRadioButton("+");
	JRadioButton radioButton2 = new JRadioButton("-");
	JRadioButton radioButton3 = new JRadioButton("*");
	JRadioButton radioButton4 = new JRadioButton("/");
	ButtonGroup buttonGroup1 = new ButtonGroup();
	ButtonGroup buttonGroup2 = new ButtonGroup();
	JButton button = new JButton("����");
	public CalFrame() {
		try {
			Init();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void Init() throws Exception{
		// TODO Auto-generated method stub
		getContentPane().setLayout(null);
		label1.setBounds(new Rectangle(78, 60, 105, 31));
		label2.setBounds(new Rectangle(80, 146, 87, 32));
		textField1.setBounds(new Rectangle(185, 59, 152, 28));
		textField2.setBounds(new Rectangle(187, 143, 151, 30));
		button.addActionListener(this);
		textField.setEnabled(false);
		textField.setBounds(new Rectangle(189, 196, 150, 30));
		label3.setBounds(new Rectangle(81, 196, 10745, 26));
		radioButton1.setBounds(new Rectangle(113, 111, 44, 23));
		radioButton2.setBounds(new Rectangle(176, 112, 48, 23));
		radioButton3.setBounds(new Rectangle(235, 112, 43, 23));
		radioButton4.setBounds(new Rectangle(295, 110, 38, 24));
		button.setBounds(new Rectangle(154, 248, 129, 34));
		this.getContentPane().add(label1);
		this.getContentPane().add(label3);
		this.getContentPane().add(textField);
		this.getContentPane().add(label2);
		this.getContentPane().add(textField2);
		this.getContentPane().add(textField1);
		this.getContentPane().add(radioButton3);
		this.getContentPane().add(radioButton2);
		this.getContentPane().add(radioButton1);
		this.getContentPane().add(radioButton4);
		this.getContentPane().add(button);
		radioButton1.setSelected(true);
		buttonGroup1.add(radioButton1);
		buttonGroup1.add(radioButton2);
		buttonGroup1.add(radioButton3);
		buttonGroup1.add(radioButton4);
		this.setTitle("���׼�����");
		this.setVisible(true);
		this.setSize(450, 350);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//��ȡ����
		String d1 = textField1.getText();  //��һλ��
		String d2 = textField2.getText();  //�ڶ�λ��
		String op = "";  //�������
		if (radioButton1.isSelected()) {
			op = radioButton1.getActionCommand();
		} else if (radioButton2.isSelected()) {
			op = radioButton2.getActionCommand();
		} else if (radioButton3.isSelected()) {
			op = radioButton3.getActionCommand();
		} else if (radioButton4.isSelected()) {
			op = radioButton4.getActionCommand();
		}
		//��֤����
		CheckData cd = new CheckData();
		boolean flag;
		flag = cd.check(d1);
		//��һλ������������
		if (!flag) {
			textField1.setText("");
			textField1.requestFocus();
			return;
		}
		flag = cd.check(d2);
		//�ڶ�λ������������
		if (!flag) {
			textField2.setText("");
			textField2.requestFocus();
			return;
		}
		//��֤����Ϊ0������
		if (d2.equals("0") && op.equals("/")) {
			JOptionPane.showMessageDialog(null, "��������Ϊ0", "��ʾ", JOptionPane.ERROR_MESSAGE);
			return;
		}
		//������ת��Ϊdouble���ͽ��м���
		double data1 = Double.parseDouble(d1);
		double data2 = Double.parseDouble(d2);
		Calculate calculate = new Calculate();
		double result = calculate.cal(data1, data2, op);
		textField.setText(String.valueOf(result));
	}
	
	public static void main(String[] args) {
		CalFrame calFrame = new CalFrame();
	}
}

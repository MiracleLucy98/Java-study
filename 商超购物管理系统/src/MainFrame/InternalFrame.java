package MainFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.tree.DefaultMutableTreeNode;

import GoodsConnection.Goods;
import GoodsConnection.GoodsDao;
import SalesmanConnection.SalesmanDao;



public class InternalFrame extends JInternalFrame{
	public JLabel label1 = new JLabel("�����Ʒ����:");
	public JLabel label2 = new JLabel("�����Ʒ�۸�:");
	public JLabel label3 = new JLabel("�����Ʒ����:");
	public JLabel label4 = new JLabel("������Ʒ����:");
	public JLabel label5 = new JLabel("������Ʒ�۸�:");
	public JLabel label6 = new JLabel("������Ʒ����:");
	public JLabel label7 = new JLabel("ɾ����Ʒ����:");
	public JLabel label8 = new JLabel("��ѯ��Ʒ����:");
	public JLabel label9 = new JLabel("������Ʒ����:");
	public JLabel label10 = new JLabel("������Ʒ�۸�:");
	public JLabel label11 = new JLabel("�������û���:");
	public JLabel label12 = new JLabel("����������:");
	public JLabel label13 = new JLabel("��������Ʒ����:");
	public JLabel label15 = new JLabel("�ܼ�:");
	public JLabel label16 = new JLabel("������ʵ�ʽ��ѽ��:");
	public JLabel label17 = new JLabel("����:");
	public JLabel label18 = new JLabel("����ۻ�Ա����:");
	public JLabel label19 = new JLabel("����ۻ�Ա����:");
	public JLabel label20 = new JLabel("����������ۻ�Ա������:");
	public JLabel label21 = new JLabel("ȷ�ϸ�������:");
	public JLabel label22 = new JLabel("ɾ���ۻ�Ա����:");
	public JLabel label23 = new JLabel("ȷ������:");
	public JLabel label24 = new JLabel("��ѯ�ۻ�Ա����:");
	public JLabel label25 = new JLabel("����:");
	public JLabel label26 = new JLabel("��Ʒ¼��");
	public JLabel label27 = new JLabel("������Ʒ����:");
	public JTextField textField1 = new JTextField();  //�����Ʒ����
	public JTextField textField2 = new JTextField();  //�����Ʒ�۸�
	public JTextField textField3 = new JTextField();  //������Ʒ����
	public JTextField textField4 = new JTextField();  //������Ʒ�۸�
	public DigitOnlyField textField5 = new DigitOnlyField(1);  //������Ʒ����
	public JTextField textField6 = new JTextField();  //ɾ����Ʒ����
	public JTextField textField7 = new JTextField();  //��ѯ��Ʒ����
	public JTextField textField8 = new JTextField();  //������Ʒ����
	public JTextField textField9 = new JTextField();  //������Ʒ�۸�
	public JTextField textField10 = new JTextField();  //�����û���
	public JPasswordField textField11 = new JPasswordField();  //��������
	public JTextField textField12 = new JTextField();  //����ۻ�Ա����
	public JTextField textField13 = new JTextField();  //����ۻ�Ա����
	public JTextField textField14 = new JTextField();  //�����ۻ�Ա������
	public JTextField textField15 = new JTextField();  //ȷ�ϸ�������
	public JTextField textField16 = new JTextField();  //ɾ���ۻ�Ա������
	public JTextField textField17 = new JTextField();  //ȷ��ɾ������
	public JTextField textField18 = new JTextField();  //��ѯ�ۻ�Ա������
	public JTextField textField19 = new JTextField();  //��ʾ����
	public DigitOnlyField textField20 = new DigitOnlyField(1);  //�����Ʒ����
	public JTextField textField21 = new JTextField();  //��Ʒ�ܼ���ʾ
	private JToolBar toolBar = new JToolBar();
	private JTable table;  //֧�ֲ�ѯ����
	private Object head[] = null;  //��Ʒ�б��ͷ
	private DefaultTableModel defaultTableModel = null;
	private JTextArea textArea = new JTextArea(3, 2);
	public JPanel panel = new JPanel();
	private JButton button1 = new JButton("��Ʒ���");
	private JButton button2 = new JButton("��Ʒ����");
	private JButton button3 = new JButton("��Ʒɾ��");
	private JButton button4 = new JButton("��Ʒ�б�");
	private JButton button5 = new JButton("��Ʒ��ѯ");
	private JButton button6 = new JButton("ǰ̨��½");
	private JButton button8 = new JButton("�����б�");
	private JButton button9 = new JButton("�ۻ�Ա����");
	private JButton button10 = new JButton("�˳�");
	private JButton button11 = new JButton("���");
	private JButton button12 = new JButton("����");
	private JButton button13 = new JButton("ɾ��");
	private JButton button14 = new JButton("��ѯ");
	private JButton button15 = new JButton("��¼");
	private JButton button16 = new JButton("���������Ʒ");
	private JButton button17 = new JButton("����");
	private JButton button18 = new JButton("����ۻ�Ա");
	private JButton button19 = new JButton("������Ϣ");
	private JButton button20 = new JButton("ȷ��ɾ��");
	private JButton button21 = new JButton("��ѯ�ۻ�Ա��Ϣ");
	public JButton label14 = new JButton("��Ʒ�ܼ�:");
	public Box box = Box.createVerticalBox();
	private JTextArea searchcomboBox = new JTextArea();    //������Ʒ�ؼ���
	public DigitOnlyField digitOnlyField = new DigitOnlyField(1);  //ÿ����Ʒ������
	public double i = 0;  //������Ʒ�ܼ�
	public double all = 0;  //����ʱ��Ʒ�ܼ�
	public double pay = 0;  //����
	private JTable selltable = new JTable(1, 5);  //���������б�
	private JTable infotable = new JTable(1, 2);  //�ۻ�Ա�б�
	private DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("�ۻ�Ա����");
	private DefaultMutableTreeNode add = new DefaultMutableTreeNode("����ۻ�Ա");
	private DefaultMutableTreeNode edit = new DefaultMutableTreeNode("�����ۻ�Ա");
	private DefaultMutableTreeNode del = new DefaultMutableTreeNode("ɾ���ۻ�Ա");
	private DefaultMutableTreeNode show = new DefaultMutableTreeNode("��ʾ�����ۻ�Ա");
	private DefaultMutableTreeNode find = new DefaultMutableTreeNode("��ѯ�ۻ�Ա");
	private JTree tree = new JTree(rootNode);
	private Object [][] data=null;
	private GoodsDao goodsDao = new GoodsDao();  //��Ʒ������ʵ����
	private SalesmanDao salesnamDao = new SalesmanDao();  //�ۻ�Ա������ʵ����
	public InternalFrame(String title) {
		super();
		setTitle(title);
		setResizable(true);
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		this.add(toolBar, BorderLayout.PAGE_START);
		this.add(panel);
		button10.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		//�жϵ���Ĳ˵�����
		if (title == "��Ʒά��") {
			product();
		}
		if (title == "ǰ̨����") {
			counter();
		}
		if (title == "��Ʒ����") {
			productmanager();
		}
		//���ͼ��
		/*URL resource = this.getClass().getResource("caption.png");
        ImageIcon icon = new ImageIcon(resource);
        setFrameIcon(icon);*/
	}
	
	public void product() {
		toolBar.add(button1);
		toolBar.add(button2);
		toolBar.add(button3);
		toolBar.add(button4);
		toolBar.add(button5);
		toolBar.add(button10);
		
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.removeAll();
				box.removeAll();
				panel.add(box);
				box.add(label1);
				box.add(textField1);
				box.add(label2);
				box.add(textField2);
				box.add(label3);
				box.add(textField20);
				box.add(button11);
				button11.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						try {
							goodsDao.addGoods(textField1.getText(), Double.parseDouble(textField2.getText()), Integer.valueOf(textField20.getText()).intValue());
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						textField1.setText("");
						textField2.setText("");
						textField20.setText("");
					}
				});
				//��������ťû�з�Ӧ��Ҫ��С����ˢ�µ�����
				panel.validate();
				panel.repaint();
			}
		});
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				panel.removeAll();
				box.removeAll();
				panel.add(box);
				box.add(label4);
				box.add(textField3);
				box.add(label5);
				box.add(textField4);
				box.add(label6);
				box.add(textField5);
				box.add(button12);
				button12.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						try {
							goodsDao.updateGoods(textField3.getText(), Double.parseDouble(textField4.getText()), Integer.valueOf(textField5.getText()).intValue());
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						textField3.setText("");
						textField4.setText("");
						textField5.setText("");
					}
				});
				panel.validate();
				panel.repaint();
			}
		});
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				panel.removeAll();
				box.removeAll();
				panel.add(box);	
				box.add(label7);
				box.add(textField6);
				box.add(button13);
				button13.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						try {
							goodsDao.delGoods(textField6.getText());
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						textField6.setText("");
					}
				});
				panel.validate();
				panel.repaint();
			}
		});
		button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				panel.removeAll();
				box.removeAll();
				head = new Object[] {"��Ʒ���", "��Ʒ����", "��Ʒ�۸�", "��Ʒ����"};
				defaultTableModel = new DefaultTableModel(queryData(),head){
		            public boolean isCellEditable(int row, int column)
		            {
		                return false;
		            }
		        };
		        table = new JTable(defaultTableModel);
				JScrollPane s = new JScrollPane(table);
				panel.add(s);
				panel.validate();
				panel.repaint();
			}
			private Object[][] queryData() {
				// TODO Auto-generated method stub
				List<Goods> list = goodsDao.allGoods();
				data = new Object[list.size()][head.length];
				for(int i=0;i<list.size();i++){
		            for(int j=0;j<head.length;j++){
		                data[i][0]=list.get(i).getGID();
		                data[i][1]=list.get(i).getGNAME();
		                data[i][2]=list.get(i).getGPRICE();
		                data[i][3]=list.get(i).getGNUM();
		            }
		        }
				return data;
			}
		});
		button5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				textField8.setEditable(false);
				textField9.setEditable(false);
				panel.removeAll();
				box.removeAll();
				panel.add(box);
				box.add(label8);
				box.add(textField7);
				box.add(button14);
				box.add(label9);
				box.add(textField8);
				box.add(label10);
				box.add(textField9);
				button14.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						textField8.setText(goodsDao.searchGoods(textField7.getText())[1]);
						textField9.setText(goodsDao.searchGoods(textField7.getText())[0]);
					}
				});
				panel.validate();
				panel.repaint();
			}
		});
	}
	
	public void counter() {
		toolBar.add(button6);
		toolBar.add(button10);
		button6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				panel.removeAll();
				box.removeAll();
				box.add(label11);
				box.add(textField10);
				box.add(label12);
				box.add(textField11);
				box.add(button15);
				button15.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						String pw = salesnamDao.Login(textField10.getText());
						String inputpw = textField11.getText();
						if (pw.equals(inputpw)) {
							JOptionPane.showMessageDialog(null,"��¼�ɹ���");
							toolBar.remove(button6);
							toolBar.remove(button10);
							toolBar.add(label26);
							panel.removeAll();
							box.removeAll();
							box.add(label27);
							box.add(searchcomboBox);							
							box.add(label13);
							box.add(digitOnlyField);
							box.add(label14);
							label14.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent arg0) {
									// TODO Auto-generated method stub
									i = getData() * Integer.valueOf(digitOnlyField.getText()).intValue();
									textField21.setText(String.valueOf(i));
								}

								private Double getData() {
									// TODO Auto-generated method stub
									double productdata = salesnamDao.searchGoods(searchcomboBox.getText());
									return productdata;
								}
							});
							box.add(textField21);
							textField21.setEditable(false);
							box.add(button16);
							//textArea.setEditable(false);
							box.add(button17);
							button16.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent arg0) {
									// TODO Auto-generated method stub
									if (false) {
										//��ѡ��Ʒ������ʱ
										JOptionPane.showMessageDialog(null,"����Ʒ�����ڣ�");
									} else {
										all += getData() * Integer.valueOf(digitOnlyField.getText()).intValue();
										searchcomboBox.setText("");
										digitOnlyField.setText("");
										textField21.setText("");
									}
								}
								
								//������ת��Ϊdouble��
								private Double getData() {
									// TODO Auto-generated method stub
									double productdata = salesnamDao.searchGoods(searchcomboBox.getText());
									return productdata;
								}
							});
							button17.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent arg0) {
									// TODO Auto-generated method stub
									String input = JOptionPane.showInputDialog("������ʵ�ʽ��ѽ��:");
									all += getData() * Integer.valueOf(digitOnlyField.getText()).intValue();
									pay = Double.parseDouble(input) - all;
									JOptionPane.showMessageDialog(InternalFrame.this, "����"+pay+"Ԫ");
								}

								//������ת��Ϊdouble��
								private Double getData() {
									// TODO Auto-generated method stub
									double productdata = salesnamDao.searchGoods(searchcomboBox.getText());
									return productdata;
								}
								
							});
							panel.add(box);
							panel.validate();
							panel.repaint();
							toolBar.validate();
							toolBar.repaint();
						}else {
							JOptionPane.showMessageDialog(null,"��¼ʧ�ܣ�����������");
						}
						textField10.setText("");
						textField11.setText("");
					}
				});
				panel.add(box);
				panel.validate();
				panel.repaint();
			}
		});
	}
	
	public void productmanager() {
		toolBar.add(button8);
		toolBar.add(button9);
		toolBar.add(button10);
		button8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				panel.removeAll();
				box.removeAll();
				box.add(selltable);
				panel.add(box);
				panel.validate();
				panel.repaint();
			}
		});
		button9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				panel.removeAll();
				rootNode.add(add);
				rootNode.add(del);
				rootNode.add(edit);
				rootNode.add(find);
				rootNode.add(show);
				panel.add(tree);
				tree.addTreeSelectionListener(new TreeSelectionListener() {
					
					@Override
					public void valueChanged(TreeSelectionEvent e) {
						// TODO Auto-generated method stub
						// ��ȡ��ǰѡ��ĵ�һ������е����һ��·�����
			            DefaultMutableTreeNode dmt = (DefaultMutableTreeNode) ((JTree) e.getSource()).getLastSelectedPathComponent();
			            // �����Ҷ�ӽ��
			            if (dmt.isLeaf()) {
			                String str = dmt.toString();// Ҷ�ӽ����ַ���
			                // �ж�
			                if (str.equals("����ۻ�Ա")) {
			                	//����ۻ�Ա����
			                	panel.removeAll();
			                	box.removeAll();
			                	box.add(label18);
			                	box.add(textField12);
			                	box.add(label19);
			                	box.add(textField13);
			                	box.add(button18);
			                	panel.add(box);
			                	panel.validate();
			    				panel.repaint();
			                } else if (str.equals("�����ۻ�Ա")) {
			                	//�����ۻ�Ա����
			                	panel.removeAll();
			                	box.removeAll();
			                	box.add(label20);
			                	box.add(textField14);
			                	box.add(label21);
			                	box.add(textField15);
			                	box.add(button19);
			                	panel.add(box);
			                	panel.validate();
			    				panel.repaint();
			                } else if (str.equals("ɾ���ۻ�Ա")) {
			                	//ɾ���ۻ�Ա����
			                	panel.removeAll();
			                	box.removeAll();
			                	box.add(label22);
			                	box.add(textField16);
			                	box.add(label23);
			                	box.add(textField17);
			                	box.add(button20);
			                	panel.add(box);
			                	panel.validate();
			    				panel.repaint();
			                } else if (str.equals("��ʾ�����ۻ�Ա")) {
								//��ʾ�����ۻ�Ա����
			                	panel.removeAll();
			                	panel.add(infotable);
			                	panel.validate();
			    				panel.repaint();
							} else if (str.equals("��ѯ�ۻ�Ա")) {
								//��ѯ�ۻ�Ա����
								panel.removeAll();
			                	box.removeAll();
			                	box.add(label24);
			                	box.add(textField18);
			                	box.add(button21);
			                	box.add(label25);
			                	textField19.setEditable(false);
			                	box.add(textField19);
			                	panel.add(box);
			                	panel.validate();
			    				panel.repaint();
							}
			            }
					}
				});
				panel.validate();
				panel.repaint();
			}
		});
	}
}

package ��ʮһ����Ϸ;

import java.awt.Container;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CardManager {
	public Card[] cards = new Card[52];
	//��ʼ��һ��52��ֽ��
	public void initCards() {
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 13; j++) {
				cards[(i - 1)*13 + j - 1] = new Card(i, j);
			}
		}
	}
	
	//���������52��ֽ��
	public void randomCards() {
		Card temp = null;
		//��������ƺ�
		for (int i = 0; i < 52; i++) {
			int a = (int)(Math.random()*52);
			int b = (int)(Math.random()*52);
			temp = cards[a];
			cards[a] = cards[b];
			cards[b] = temp;
		}
	}

	
	//��ʾֽ��ͼƬ
	public void gameStart(JLabel game[], Container c) {
		//��������ɾ����ǩ���
		if (game[0] != null) {
			for (int i = 0; i < 52; i++) {
				c.remove(game[i]);
			}
			c.repaint();
		}
		//�������з���52����ǩ������ڷ���ͼƬ
		for (int i = 0; i < 52; i++) {
			game[i] = new JLabel();
			game[i].setBorder(javax.swing.BorderFactory.createEtchedBorder());
			game[i].setBounds(new Rectangle(100 + i*10, 10, 101, 150));
			c.add(game[i]);
		}
		//���ñ�ǩ�����ͼƬΪrear.jpg�����Ƶı���
		for (int i = 0; i < 52; i++) {
			game[i].setIcon(new ImageIcon("images/rear.jpg"));
		}
	}
}

package ������;

public class DieTest {
	public static void main(String[] args) {
		DieGame dieGame = new DieGame();
		if (dieGame.play()) {
			System.out.println("��Ӯ�ˣ�");
		} else {
			System.out.println("�����ˣ��ٽ�������");
		}
	}
}

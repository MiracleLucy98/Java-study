package calculator;

public class CheckData {
	public CheckData() {
	}
	
	public boolean check(String s) {
		//�ж������Ƿ�Ϸ�
		Double a;
		try {
			a = Double.parseDouble(s);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}
}

package MainFrame;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

//�����ı���ֻ������������
public class DigitOnlyField extends JTextField {
	private static final long serialVersionUID = 8384787369612949227L;

	public DigitOnlyField(int cols) {
		// super() ���Ա��Զ����ã������вι��췽�������ܱ��Զ����ã�ֻ������
		// super�ؼ�����ʾ�ص��ø���Ĺ��췽��
       super(cols);
   }

   protected Document createDefaultModel() {
       return new UpperCaseDocument();
   }

   static class UpperCaseDocument extends PlainDocument {

       /**
		 * 
		 */
		private static final long serialVersionUID = -4170536906715361215L;

		public void insertString(int offs, String str, AttributeSet a)
           throws BadLocationException {

           if (str == null) {
               return;
           }
           char[] upper = str.toCharArray();
           String filtered = "";
           for (int i = 0; i < upper.length; i++) {
           	if (Character.isDigit(Character.codePointAt(upper, i))){
           		filtered += upper[i];
           	}
           }
           super.insertString(offs, filtered, a);
       }
   }
}

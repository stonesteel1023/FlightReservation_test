package flight2.exception;

public class NumberFormatException extends Exception {

	public NumberFormatException(String msg){
		super(msg);
	}
	
	public NumberFormatException(){
		this("�¼� ���� �ּ��� 1�� �̻� ����Ǿ�� �մϴ�");
	}
}

package flight2.exception;

public class RecordNotFoundException extends Exception {
	public RecordNotFoundException(String msg){
		super(msg);
	}
	public RecordNotFoundException(){
		this("�������� �ʴ� �ڷ��Դϴ�");
	}
}

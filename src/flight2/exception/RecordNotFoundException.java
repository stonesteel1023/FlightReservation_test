package flight2.exception;

public class RecordNotFoundException extends Exception {
	public RecordNotFoundException(String msg){
		super(msg);
	}
	public RecordNotFoundException(){
		this("존재하지 않는 자료입니다");
	}
}

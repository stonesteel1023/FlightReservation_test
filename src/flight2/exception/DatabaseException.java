package flight2.exception;

public class DatabaseException extends Exception {
	public DatabaseException (String msg){
		super(msg);
	}
	
	public DatabaseException(){
		this("�־��� ������ �����ϴ�");
	}

}

package flight2.exception;

public class DatabaseException extends Exception {
	public DatabaseException (String msg){
		super(msg);
	}
	
	public DatabaseException(){
		this("주어진 정보가 없습니다");
	}

}

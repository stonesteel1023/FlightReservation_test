package flight2.exception;

public class NumberFormatException extends Exception {

	public NumberFormatException(String msg){
		super(msg);
	}
	
	public NumberFormatException(){
		this("좌석 수는 최소한 1개 이상 예약되어야 합니다");
	}
}

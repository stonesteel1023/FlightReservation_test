package flight2.protocol;

import java.io.Serializable;
import java.util.ArrayList;

import flight2.db.model.FlightReservationVO;

public class Command implements Serializable{
	private int commandValue;	// 명령어 상수값
	private ArrayList<FlightReservationVO> result = new ArrayList<FlightReservationVO>();		//VO 객체 컬렉션 
	private int status;			// 결과 상수
	Object args[] = {};
	
	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}
	
	
	public static final int	GET_ALL_RESERVATION_INFO = 10;	//getAllReservationInfo()
	public static final int SEARCH_RESERVATION_INFO = 20;	//searchReservatoinInfo()
	public static final int BOKING = 30;					//booking()
	
	public static final int RECORD_NOT_FOUND = -10;			//정보 없음
	public static final int NUMBER_FORMAT_EXCEPTION = -20;		//좌석 수 부족 
	
	
	
	public Command(int commandValue) {
		// TODO Auto-generated constructor stub
		this.commandValue = commandValue;
	}
	
	
	public int getCommandValue() {
		return commandValue;
	}
	public void setCommandValue(int commandValue) {
		this.commandValue = commandValue;
	}
	public ArrayList<FlightReservationVO> getResult() {
		return result;
	}
	public void setResult(ArrayList<FlightReservationVO> result) {
		this.result = result;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}

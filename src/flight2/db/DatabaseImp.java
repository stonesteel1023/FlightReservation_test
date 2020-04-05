package flight2.db;

import java.util.ArrayList;

import flight2.db.model.FlightReservationVO;
import flight2.exception.DatabaseException;
import flight2.exception.RecordNotFoundException;

public interface DatabaseImp {
	
	// 모든 예약정보를 가져온다.
	public ArrayList<FlightReservationVO> getAllReservationInfo() throws DatabaseException;	//DatabaseException : 사용자 정의 예외
	
	// 조건에 따라 예약정보를 검색한다.
	public ArrayList<FlightReservationVO> searchReservatoinInfo(String str) throws DatabaseException, RecordNotFoundException;
	
	// 잔여좌석 수를 업데이트 한다.
	// 모든 좌석이 예약되면 해당 레코드를 삭제한다.
	public boolean booking(String flightNo, int quantity) throws DatabaseException, NumberFormatException;

	
	
}

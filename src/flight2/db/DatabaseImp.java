package flight2.db;

import java.util.ArrayList;

import flight2.db.model.FlightReservationVO;
import flight2.exception.DatabaseException;
import flight2.exception.RecordNotFoundException;

public interface DatabaseImp {
	
	// ��� ���������� �����´�.
	public ArrayList<FlightReservationVO> getAllReservationInfo() throws DatabaseException;	//DatabaseException : ����� ���� ����
	
	// ���ǿ� ���� ���������� �˻��Ѵ�.
	public ArrayList<FlightReservationVO> searchReservatoinInfo(String str) throws DatabaseException, RecordNotFoundException;
	
	// �ܿ��¼� ���� ������Ʈ �Ѵ�.
	// ��� �¼��� ����Ǹ� �ش� ���ڵ带 �����Ѵ�.
	public boolean booking(String flightNo, int quantity) throws DatabaseException, NumberFormatException;

	
	
}

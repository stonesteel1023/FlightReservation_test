package flight2.test;

import flight2.db.FlightReservationDAO;
import flight2.db.model.FlightReservationVO;
import flight2.exception.DatabaseException;

public class getAllReservationInfo_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlightReservationDAO dao = new FlightReservationDAO();
		
		try {
			System.out.println("��ȣ\t�����\t������\t�װ���\t\t����\t��¥\t��߽ð�\t���׽ð�\t�ܿ��¼���\n--------------------------------------------------------------------------------");
			dao.getAllReservationInfo();
			
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}

package flight2.test;

import flight2.db.FlightReservationDAO;
import flight2.db.model.FlightReservationVO;

import flight2.exception.DatabaseException;

public class booking_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FlightReservationDAO dao = new FlightReservationDAO();
		try {
			System.out.println("��ȣ\t�����\t������\t�װ���\t\t����\t��¥\t��߽ð�\t���׽ð�\t�ܿ��¼���\n------------------------------------------------------------------------------");
			String flight_number = "SAOO1";
			int quantity =5;
			
			dao.booking(flight_number, quantity);
			System.out.println("�Ϸ�?");
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

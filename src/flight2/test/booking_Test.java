package flight2.test;

import flight2.db.FlightReservationDAO;
import flight2.db.model.FlightReservationVO;

import flight2.exception.DatabaseException;

public class booking_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FlightReservationDAO dao = new FlightReservationDAO();
		try {
			System.out.println("번호\t출발지\t도착지\t항공사\t\t운임\t날짜\t출발시간\t운항시간\t잔여좌석수\n------------------------------------------------------------------------------");
			String flight_number = "SAOO1";
			int quantity =5;
			
			dao.booking(flight_number, quantity);
			System.out.println("완료?");
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

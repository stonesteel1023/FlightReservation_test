package flight2.test;

import flight2.db.FlightReservationDAO;
import flight2.db.model.FlightReservationVO;
import flight2.exception.DatabaseException;

public class searchReservationInfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				FlightReservationDAO dao = new FlightReservationDAO();
				FlightReservationVO dto = new FlightReservationVO();
				try {
					System.out.println("번호\t출발지\t도착지\t항공사\t\t운임\t날짜\t출발시간\t운항시간\t잔여좌석수\n--------------------------------------------------------------------------------");
					//dao.getAllReservationInfo();
					String str = "SFO";
					dao.searchReservatoinInfo(str);
					System.out.println("");
				} catch (DatabaseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

}

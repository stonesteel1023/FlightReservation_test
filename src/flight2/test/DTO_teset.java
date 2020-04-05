package flight2.test;

import flight2.db.model.FlightReservationVO;

public class DTO_teset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FlightReservationVO dto = new FlightReservationVO("SA001", "SFO","DEN", "SpeedyAir",400, "Sun","13:40", "20m", 50);
		System.out.println(dto);
		
	}

}

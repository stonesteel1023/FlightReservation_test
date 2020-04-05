package flight2.db.model;

import java.io.Serializable;

public class FlightReservationVO implements Serializable{

	private String flight_number;
	private String origin_airport;
	private String destination_airport ;
	private String carrier ;
	private int price ;
	private String day ;
	private String time ;
	private String duration ;
	private int available_seat ;
	
	//»ý¼ºÀÚ
	
	public FlightReservationVO(String flight_number, String origin_airport,String destination_airport, String carrier, int price, String day,String time, String duration, int available_seat) {
		this.flight_number = flight_number;
		this.origin_airport = origin_airport;
		this.destination_airport = destination_airport;
		this.carrier = carrier;
		this.price = price;
		this.day = day;
		this.time = time;
		this.duration = duration;
		this.available_seat = available_seat;
	}

	public FlightReservationVO() {
		super();
	}
	
	
	// getter-setter

	public String getFlight_number() {
		return flight_number;
	}

	public void setFlight_number(String flight_number) {
		this.flight_number = flight_number;
	}

	public String getOrigin_airport() {
		return origin_airport;
	}

	public void setOrigin_airport(String origin_airport) {
		this.origin_airport = origin_airport;
	}

	public String getDestination_airport() {
		return destination_airport;
	}

	public void setDestination_airport(String destination_airport) {
		this.destination_airport = destination_airport;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getAvailable_seat() {
		return available_seat;
	}

	public void setAvailable_seat(int available_seat) {
		this.available_seat = available_seat;
	}

	
	//toString
	@Override
	public String toString() {
		return flight_number+"\t"+origin_airport+"\t"+destination_airport+"\t"+carrier+"\t"+price+"\t"+day+"\t"+time+"\t"+duration+"\t"+available_seat;

	}
	
	
	
	
	

}


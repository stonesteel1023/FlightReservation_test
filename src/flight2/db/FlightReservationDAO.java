package flight2.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import flight2.db.model.FlightReservationVO;
import flight2.exception.DatabaseException;

import java.sql.*;

import javax.swing.JOptionPane;
public class FlightReservationDAO implements DatabaseImp {

	
	FlightReservationVO condition =null;
	
	
	@Override
	public ArrayList<FlightReservationVO> getAllReservationInfo() throws DatabaseException {
		ArrayList<FlightReservationVO> list = new ArrayList<FlightReservationVO>();
		
		Connection con = DatabaseConnection.getConnection();
		String sql = "SELECT * FROM RESERVATION";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				condition = new FlightReservationVO();
				condition.setFlight_number(rs.getString(1));
				condition.setOrigin_airport(rs.getString(2));
				condition.setDestination_airport(rs.getString(3));
				condition.setCarrier(rs.getString(4));
				condition.setPrice(rs.getInt(5));
				condition.setDay(rs.getString(6));
				condition.setTime(rs.getString(7));
				condition.setDuration(rs.getString(8));
				condition.setAvailable_seat(rs.getInt(9));
				list.add(condition);
			}
			for(FlightReservationVO dto : list){
				System.out.println(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{DatabaseConnection.close(con);}
		
		
		return list;
	}

	@Override
	public ArrayList<FlightReservationVO> searchReservatoinInfo(String str) throws DatabaseException {
		ArrayList<FlightReservationVO> list = new ArrayList<FlightReservationVO>();
		//검색 - 주어진 조건에 해당하는 항공운항정보 반환
		Connection con = DatabaseConnection.getConnection();
	
		String o1 = "WHERE origin_airport=?";
		String o2 = "WHERE destination_airport=?"; 
		String o3 = "WHERE carrier=?"; 
		String o4 = "WHERE day=?";
		//골라서 들어갈 수 있게
		String sql="SELECT * FROM RESERVATION ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				FlightReservationVO dto = new FlightReservationVO();
				dto.setFlight_number(rs.getString(1));
				dto.setOrigin_airport(rs.getString(2));
				dto.setDestination_airport(rs.getString(3));
				dto.setCarrier(rs.getString(4));
				dto.setPrice(rs.getInt(5));
				dto.setDay(rs.getString(6));
				dto.setTime(rs.getString(7));
				dto.setDuration(rs.getString(8));
				dto.setAvailable_seat(rs.getInt(9));
				list.add(dto);
			
			}
			
			//선택 시작
			/*for(int i=0;i<list.size();i++)
			{*/
			
			
			/*System.out.println(list.get(0).getOrigin_airport());
			System.out.println(list.get(1).getOrigin_airport());
			System.out.println(list.get(3).getOrigin_airport());*/
			
			
			
			
			/*String oa=list.get(i).getOrigin_airport();
			String da=list.get(i).getDestination_airport();
			String ca=list.get(i).getCarrier();
			String day =list.get(i).getDay();*/
			
			System.out.println(sql+o1);
			switch(sql){
			case "SELECT * FROM RESERVATION WHERE origin_airport=?":
				System.out.println(sql);
				PreparedStatement ps2 = con.prepareStatement(sql);
				ps2.setString(1, str);
				//String 안에 SFO / LAX / DAL / FRA / BOM / DEN / ABQ / ATL
				ResultSet rs2 = ps2.executeQuery();
				while(rs2.next()){
					FlightReservationVO dto = new FlightReservationVO();
					
					dto.setFlight_number(rs2.getString(1));
					dto.setOrigin_airport(rs2.getString(2));
					dto.setDestination_airport(rs2.getString(3));
					dto.setCarrier(rs2.getString(4));
					dto.setPrice(rs2.getInt(5));
					dto.setDay(rs2.getString(6));
					dto.setTime(rs2.getString(7));
					dto.setDuration(rs2.getString(8));
					dto.setAvailable_seat(rs2.getInt(9));
					list.add(dto);
				}
				for(FlightReservationVO dto : list){
					System.out.println(dto);
				}
				rs2.close();
				ps2.close();
				break;
			case "SELECT * FROM RESERVATION WHERE Destination_airport= ?":
				PreparedStatement ps3 = con.prepareStatement(sql);
				ps3.setString(1, str);
				//String 안에 SFO / LAX / DAL / FRA / BOM / DEN / ABQ / ATL
				ResultSet rs3 = ps3.executeQuery();
				while(rs3.next()){
					FlightReservationVO dto = new FlightReservationVO();
					
					dto.setFlight_number(rs3.getString(1));
					dto.setOrigin_airport(rs3.getString(2));
					dto.setDestination_airport(rs3.getString(3));
					dto.setCarrier(rs3.getString(4));
					dto.setPrice(rs3.getInt(5));
					dto.setDay(rs3.getString(6));
					dto.setTime(rs3.getString(7));
					dto.setDuration(rs3.getString(8));
					dto.setAvailable_seat(rs3.getInt(9));
					list.add(dto);
				}
				/*for(FlightReservationVO dto : list){
					System.out.println(dto);
				}*/
				rs3.close();
				ps3.close();
				break;
			case "SELECT * FROM RESERVATION WHERE Carrier= ?":
				PreparedStatement ps4 = con.prepareStatement(sql);
				ps4.setString(1, str);
				//String 안에 SpeedyAir / PromptAir / RainvilleAir / BeethAir
				ResultSet rs4 = ps4.executeQuery();
				while(rs4.next()){
					FlightReservationVO dto = new FlightReservationVO();
					
					dto.setFlight_number(rs4.getString(1));
					dto.setOrigin_airport(rs4.getString(2));
					dto.setDestination_airport(rs4.getString(3));
					dto.setCarrier(rs4.getString(4));
					dto.setPrice(rs4.getInt(5));
					dto.setDay(rs4.getString(6));
					dto.setTime(rs4.getString(7));
					dto.setDuration(rs4.getString(8));
					dto.setAvailable_seat(rs4.getInt(9));
					list.add(dto);
				}
				/*for(FlightReservationVO dto : list){
					System.out.println(dto);
				}*/
				rs4.close();
				ps4.close();
				break;
			case "SELECT * FROM RESERVATION WHERE Day= ?":
				PreparedStatement ps5 = con.prepareStatement(sql);
				
				ps5.setString(1, str);
				//Sun / Mon / Tue / Wed / Thu / Fri / Sat
				
				
				ResultSet rs5 = ps5.executeQuery();
				while(rs5.next()){
					FlightReservationVO dto = new FlightReservationVO();
					
					dto.setFlight_number(rs5.getString(1));
					dto.setOrigin_airport(rs5.getString(2));
					dto.setDestination_airport(rs5.getString(3));
					dto.setCarrier(rs5.getString(4));
					dto.setPrice(rs5.getInt(5));
					dto.setDay(rs5.getString(6));
					dto.setTime(rs5.getString(7));
					dto.setDuration(rs5.getString(8));
					dto.setAvailable_seat(rs5.getInt(9));
					list.add(dto);
				}
				/*for(FlightReservationVO dto : list){
					System.out.println(dto);
				}*/
				rs5.close();
				ps5.close();
				break;
				
			default : 
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()){
					FlightReservationVO dto = new FlightReservationVO();
					dto.setFlight_number(rs.getString(1));
					dto.setOrigin_airport(rs.getString(2));
					dto.setDestination_airport(rs.getString(3));
					dto.setCarrier(rs.getString(4));
					dto.setPrice(rs.getInt(5));
					dto.setDay(rs.getString(6));
					dto.setTime(rs.getString(7));
					dto.setDuration(rs.getString(8));
					dto.setAvailable_seat(rs.getInt(9));
					list.add(dto);
					
				}
				rs.close();
				System.out.println("출력시작");
				for(FlightReservationVO dto : list){
					System.out.println(dto);
				}
				System.out.println("출력완료");
				break;
			}//sql switch문 닫기
			//}// 선택 for문 닫기
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{DatabaseConnection.close(con);}
		
		return list;
	}

	@Override
	public boolean booking(String flight_number, int quantity) throws DatabaseException,NumberFormatException {
		boolean booking = false;
		
		if(String.valueOf(quantity)==null) throw new NumberFormatException();	
		Connection conn = DatabaseConnection.getConnection();
		String sql1 = "UPDATE RESERVATION SET available_seat=available_seat-? WHERE flight_number=? ";
		String sql2="SELECT * FROM RESERVATION WHERE flight_number=? ";
		String sql="";
			sql = sql1;
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, quantity);
				ps.setString(2, flight_number);
				//String 안에 SFO / LAX / DAL / FRA / BOM / DEN / ABQ / ATL
				ps.executeUpdate();
				
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		
			sql=sql2;
		try {
			ArrayList<FlightReservationVO> list2 = new ArrayList<FlightReservationVO>();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, flight_number);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				FlightReservationVO dto = new FlightReservationVO();
				dto.setFlight_number(flight_number);
				dto.setOrigin_airport(rs.getString(2));
				dto.setDestination_airport(rs.getString(3));
				dto.setCarrier(rs.getString(4));
				dto.setPrice(rs.getInt(5));
				dto.setDay(rs.getString(6));
				dto.setTime(rs.getString(7));
				dto.setDuration(rs.getString(8));
				dto.setAvailable_seat(rs.getInt(9));
				list2.add(dto);
			}
			for(FlightReservationVO dto : list2){
				System.out.println(dto);
			}
			
			//if(quantity!=0)booking=true;
			
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{DatabaseConnection.close(conn);}
		
		
		
		return booking;
	}

	

}

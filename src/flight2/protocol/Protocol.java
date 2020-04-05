package flight2.protocol;

import java.util.ArrayList;

import flight2.db.DatabaseImp;
import flight2.db.FlightReservationDAO;
import flight2.db.model.FlightReservationVO;
import flight2.exception.DatabaseException;
import flight2.exception.RecordNotFoundException;

import java.io.*;
import java.net.*;

public class Protocol implements DatabaseImp {
	private Socket soc;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	Command command;
	private final int PORT = 5555;
	
	public Protocol(){
		try {
			soc = new Socket("localhost", PORT);
			oos = new ObjectOutputStream(soc.getOutputStream());
			ois = new ObjectInputStream(soc.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	public void sendData(Command cmd){
		try {
			oos.writeObject(cmd);
			oos.reset();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int readData(){
		int status=0;
		try {
			command = (Command)ois.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	
	
	
	
	
	
	
	

	@Override
	public ArrayList<FlightReservationVO> getAllReservationInfo() throws DatabaseException {
		// TODO Auto-generated method stub
		Command cmd = new Command(Command.GET_ALL_RESERVATION_INFO);
		
		sendData(cmd);  readData(); 
		return command.getResult();
	}

	@Override
	public ArrayList<FlightReservationVO> searchReservatoinInfo(String str) throws DatabaseException {
		// TODO Auto-generated method stub
		
		Command cmd = new Command(Command.SEARCH_RESERVATION_INFO);
		Object args[] ={str}; cmd.setArgs(args);
		sendData(cmd); int status=readData(); if(status==command.RECORD_NOT_FOUND) throw new DatabaseException();
		return command.getResult();
	}

	@Override
	public boolean booking(String flightNo, int quantity) throws DatabaseException, NumberFormatException {
		// TODO Auto-generated method stub
		boolean booking = false;
		flightNo=""; quantity=0;
		Command cmd = new Command(Command.BOKING);
		Object args[] ={flightNo,quantity}; cmd.setArgs(args);
		sendData(cmd); int status=readData(); if(status==command.NUMBER_FORMAT_EXCEPTION) throw new NumberFormatException();
		return booking;
	}
	
	

}

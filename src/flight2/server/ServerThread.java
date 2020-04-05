package flight2.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import flight2.db.FlightReservationDAO;
import flight2.db.model.FlightReservationVO;
import flight2.exception.DatabaseException;
import flight2.protocol.Command;

public class ServerThread implements Runnable{
	
	ObjectInputStream ois;
	ObjectOutputStream oos;
	FlightReservationDAO dao;
	boolean exit = false;
	Command command;
	
	public ServerThread(ObjectInputStream ois, ObjectOutputStream oos) {
		// TODO Auto-generated constructor stub
		this.ois = ois;
		this.oos = oos;
		dao = new FlightReservationDAO();
		
	}
	public ServerThread(){}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!exit){
			try {
				command = (Command)ois.readObject();
				
				int commandValue = command.getCommandValue();
				Object args[] = command.getArgs();
				
				switch(commandValue){
				case 10:
					try {
						ArrayList<FlightReservationVO> list = dao.getAllReservationInfo(); command.getResult().addAll(list);
					} catch (DatabaseException e) {}
					break;
				case 20: 
					try {
						ArrayList<FlightReservationVO> list = dao.searchReservatoinInfo(String.valueOf(args[0]));command.getResult().addAll(list);
					} catch (DatabaseException e) {} 
					break;
				case 30: dao.booking((String)args[0], (Integer)args[1]);
					break;
					
				}
				oos.writeObject(command);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				exit=true;
				System.out.println("클라이언트 접속 끊어짐");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				exit=true;
				System.out.println("클라이언트 접속 끊어짐");
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} // while 끝
		
	}// run 끝

}

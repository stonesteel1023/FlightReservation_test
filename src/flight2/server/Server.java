package flight2.server;
import java.net.*;
import java.io.*;
public class Server {
	
	private ServerSocket svsoc;
	private final int PORT = 5555;
	
	public Server(){
		
		try {
			svsoc = new ServerSocket(PORT);
			System.out.println(" : 이상없음");
			
			while(true){
			Socket soc = svsoc.accept();
			System.out.println("접속되었음");
			ObjectInputStream ois = new ObjectInputStream(soc.getInputStream());
			ObjectOutputStream oos = new ObjectOutputStream(soc.getOutputStream());
			
			//쓰레드 시작
			ServerThread thread = new ServerThread(ois,oos);
			Thread t = new Thread(thread);
			t.start();
			
			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("서버 시작");
		new Server();
		
	}

}

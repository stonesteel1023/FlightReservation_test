package flight2.server;
import java.net.*;
import java.io.*;
public class Server {
	
	private ServerSocket svsoc;
	private final int PORT = 5555;
	
	public Server(){
		
		try {
			svsoc = new ServerSocket(PORT);
			System.out.println(" : �̻����");
			
			while(true){
			Socket soc = svsoc.accept();
			System.out.println("���ӵǾ���");
			ObjectInputStream ois = new ObjectInputStream(soc.getInputStream());
			ObjectOutputStream oos = new ObjectOutputStream(soc.getOutputStream());
			
			//������ ����
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
		System.out.print("���� ����");
		new Server();
		
	}

}

import java.io.IOException;
import java.io.*;
import java.net.*;

public class Server extends Thread {
	ServerSocket ss;
	static int totalthreads =5;

	public void run(){
		for(;;){
		try {
			Socket s = ss.accept();
			System.out.println("A client connected at"+s.getInetAddress());
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			String st = (String)ois.readObject();
			System.out.println(st);
			s.close();
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	
	}
	}
	public Server(ServerSocket ss){
		this.ss = ss;
	}

	public static void main(String args[]){
		try{
			ServerSocket ss = new ServerSocket(8880);
			System.out.println("server stared" );
			for(int i=0; i<=totalthreads;i++){
				Server s = new Server(ss);
				s.start();
				System.out.println(Thread.currentThread().getName());
		}
	}
	catch(Exception e){}
	}
}

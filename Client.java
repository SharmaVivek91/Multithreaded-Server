import java.io.*;
import java.net.*;
public class Client {

public static void main(String[] args) {
 try{
	Socket s = new Socket("localhost",8880);
	// client writes object stream to server socket
	ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
	oos.writeObject("Testfile");
	s.close();
 }
 catch(Exception e){
	 System.out.println(e);
 }
}

}

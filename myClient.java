//Libraries
import java.net.*;
import java.io.*;


public class myClient {

// arguments supply message and hostname of destination
public static void main (String args[]) {

//specification of sockets
Socket s = null;

//Connection to server-side
try{

//maximum port size
int serverPort = 50000;

//uses specified port as agreed port (up to 50000)
s = new Socket(args[1], serverPort);

//Data input specified here
DataInputStream in = new DataInputStream( s.getInputStream());

//Data output specified here
DataOutputStream out =
new DataOutputStream( s.getOutputStream());

//writes to ip (string encoding)
out.writeUTF(args[0]); 
String data = in.readUTF();

//prints confirmation
System.out.println("Received: "+ data) ;
}

//error handling
catch (UnknownHostException e){
System.out.println("Sock:"+e.getMessage());
}catch (EOFException e){System.out.println("EOF:"+e.getMessage());
}catch (IOException e){System.out.println("IO:"+e.getMessage());}
}
}

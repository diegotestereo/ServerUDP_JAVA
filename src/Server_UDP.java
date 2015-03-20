import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Server_UDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	DatagramSocket miSocket = new DatagramSocket(9000);
	
	  System.out.println("*************************************");
      System.out.println("*********   Servidor UDP  ***********");
  
      System.out.println("*******  IP: "+InetAddress.getLocalHost().getHostAddress()+":9000 *******");
      System.out.println("*************************************");
          
      System.out.println();
	while(true){
		byte[] miBuffer= new byte[1024];
		DatagramPacket peticion=new DatagramPacket(miBuffer, miBuffer.length);
		System.out.println("Esperando Mensaje");
		miSocket.receive(peticion);
		  System.out.println("Mensaje recibido...");
		System.out.println("IP: "+peticion.getAddress());
		System.out.println("Puerto: "+peticion.getPort());
		System.out.println("Mensaje: "+new String(peticion.getData(),0,peticion.getLength()));
		System.out.println();
		
		String saludo="ok Server !!! : " + new String(peticion.getData(),0,peticion.getLength());
		byte[] miBuffer2= new byte[1024];
		miBuffer2 =saludo.getBytes();
		peticion=new DatagramPacket(miBuffer2, miBuffer2.length,peticion.getAddress(),peticion.getPort());
	
		miSocket.send(peticion);
		
		
	}
	
} catch (SocketException e) {
	// TODO Auto-generated catch block
	  System.out.println(e);
}catch (IOException e) {
	// TODO Auto-generated catch block
	 System.out.println(e);
}
	}


	
}	



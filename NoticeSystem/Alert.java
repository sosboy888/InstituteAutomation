import java.net.*;
import java.awt.*;
import javax.swing.*;

public class AlertPrincipal{
	public static void main(String[] args){
		DatagramSocket ds=new DatagramSocket();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter your message:");
		String messageString=s.nextInt();
		InetAddress ip=InetAddress.getLocalHost();
		DatagramPacket dp=new DatagramPacket(messageString.getBytes(),messageString.length());
		ds.send(dp);
		ds.close();
	}
}
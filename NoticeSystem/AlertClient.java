import java.net.*;
import java.awt.*;
import javax.swing.*;

class AlertClient{
	public static void main(String[] args){
		try{
			DatagramSocket ds=new DatagramSocket(8888);
			byte[] messageSubject=new byte[2048];
			byte[] message=new byte[2048];
			DatagramPacket dp=new DatagramPacket(messageSubject,2048);
			ds.receive(dp);
			String messageString=new String(dp.getData(),0,dp.getLength());
			System.out.println(messageString);
			DatagramPacket dp2=new DatagramPacket(messageSubject,2048);
			ds.receive(dp2);
			String messageString2=new String(dp.getData(),0,dp.getLength());
			System.out.println(messageString2);
			ds.close();
			Window.messageSubject=messageString;
			Window.message=messageString2;
			Window w=new Window();
		}catch(Exception e){}
		
	}
}

class Window extends Frame{
	public static String messageSubject=new String();
	public static String message=new String();
	Label l1,l2,l3;
	Window(){
		l1=new Label("You have a new message:");
		l2=new Label("Subject:"+messageSubject+"                                                                                      ");
		l3=new Label("          Message:"+message+"                                                                                             ");
		l1.setBounds(50,100,500,100);
		l2.setBounds(50,200,500,100);
		l3.setBounds(50,300,500,100);
		this.add(l1);
		this.add(l2);
		this.add(l3);
		setLayout(new FlowLayout());
		setSize(400,400);
		setVisible(true);
	}
}
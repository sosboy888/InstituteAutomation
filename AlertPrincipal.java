import java.net.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class AlertPrincipal{
	public static void main(String[] args){
		Window w=new Window();
		
	}
}

class Window extends Frame implements ActionListener{
	public String messageSubject;
	public String message;
	TextField t1,t2;
	Label l1,l2;
	Button b1;
	Window(){
		t1=new TextField("");
		l1=new Label("Subject of the message:");
		l1.setBounds(50,100,200,30);
		b1=new Button("SEND MESSAGE");
		b1.setBounds(200,250,150,30);		
		l2=new Label("Message:");
		l2.setBounds(50,150,200,30);
		
		t1.setBounds(300,100,300,30);
		t2=new TextField("");
		this.add(l1);
		this.add(t1);
		this.add(l2);
		this.add(t2);
		this.add(b1);
		b1.addActionListener(this);
		t2.setBounds(300,150,300,30);
		setSize(1280,720);
		setLayout(null);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==b1){
			messageSubject=t1.getText();
			message=t2.getText();
			System.out.println(messageSubject);
			try{
				DatagramSocket ds=new DatagramSocket();
				Scanner s=new Scanner(System.in);
				InetAddress ip=InetAddress.getLocalHost();
				DatagramPacket dp=new DatagramPacket(messageSubject.getBytes(),messageSubject.length(),ip,8888);
				ds.send(dp);
				DatagramPacket dp2=new DatagramPacket(message.getBytes(),message.length(),ip,8888);
				ds.send(dp);
				ds.close();

			}catch(Exception e){System.out.println("EXCEPTION!");}
		}
	}
}
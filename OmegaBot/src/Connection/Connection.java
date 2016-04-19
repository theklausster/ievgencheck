package Connection;

import java.util.ArrayList;
import java.util.Scanner;

public class Connection implements ISubject {

	ArrayList<ISub> listOfSubscribers;
	private static String lastMessage;
	public static Connection Instance;
	

	private Connection()
	{
		System.out.println("Connection() exicuted");
		try
		{
			 listOfSubscribers = new ArrayList<>();
		  //  LCD.clear();
		  //  LCD.drawString("Waiting for client connection...", 0, 0);
		  //  BTConnection btc = Bluetooth.waitForConnection();	    
		   // LCD.drawString("Client connected", 0, 0);
		   // DataInputStream dis = new DataInputStream(btc.openDataInputStream());
		   // DataOutputStream dos = new DataOutputStream(btc.openDataOutputStream());
			 lastMessage = "back";
			//LCD.clear();
			//LCD.drawString(message, 0, 2);
			
			//dos.writeUTF(message.toUpperCase());
			//dos.flush();
			
			//if (message.equalsIgnoreCase("quit"))
			//{
			//    done = true;
			//}
		   // }
		 //   LCD.clear();
		 //   LCD.drawString("NXT terminating", 0, 2);
		} 
		catch (Exception e)
		{
		    // TODO Auto-generated catch block
		    System.out.println(e.getMessage());
		}
	}
	
	public static Connection getInstance(){
		System.out.println("singleton connection getInstance() exicuted");
		if(Instance == null){
			Instance = new Connection();
		}
		return Instance;
	}
	
	public ArrayList<ISub> getSubscribers(){
		return listOfSubscribers;
	}


	@Override
	public void notifySubscriber(String msg) {
		for(ISub sub : listOfSubscribers){
			sub.getLastMessage(msg);
			System.out.println("notifiySubsribers() with the msg: " + msg);
		}
		
	}

	@Override
	public void addSubscriber(ISub sub) {
		listOfSubscribers.add(sub);
		System.out.println("I Sub added to addSubscriber()");
	}

	@Override
	public void removeSubscriber(ISub sub) {
		listOfSubscribers.remove(sub);
		
	}

}



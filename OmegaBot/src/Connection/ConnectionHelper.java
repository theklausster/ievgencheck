package Connection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import lejos.nxt.LCD;
import lejos.nxt.comm.BTConnection;
import lejos.nxt.comm.Bluetooth;


public class ConnectionHelper implements Runnable, INotifier{
	
	private ArrayList<ISub> listWithSub;
	private BTConnection btc;
	private DataInputStream dis;
	private DataOutputStream dos;
	private String input = "forward";
	
	
	public ConnectionHelper(){
		setupConnection();
	}
	
	private void setupConnection() {
		listWithSub = new ArrayList<>();
	    LCD.clear();
	    LCD.drawString("Waiting for client connection...", 0, 0);
	    btc = Bluetooth.waitForConnection();	 
	    dis = new DataInputStream(btc.openDataInputStream());
		dos = new DataOutputStream(btc.openDataOutputStream());
	    LCD.drawString("Client connected", 0, 0);
	
}
	
	public String getLastInput(){
		
		return input;
	}
	
	public void sendInput(String input){
		try {
			dos.writeUTF(input);
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
		while (true){
			try {
			
					notifySub(dis.readUTF());
					
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void addSub(ISub sub) {
		System.out.println("Sub added");
		listWithSub.add(sub);
		
	}

	@Override
	public void removeSub(ISub sub) {
		listWithSub.remove(sub);
		
	}

	@Override
	public void notifySub(String msg) {
		for(ISub sub : listWithSub){
			sub.getInput(msg);
		}
		
	}
	
	public DataOutputStream getDOS(){
		return dos;
	}
	
	
	
}



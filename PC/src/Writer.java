import java.io.DataOutputStream;

import Connection.IConnector;


public class Writer {
	private DataOutputStream dos;
	public Writer(IConnector connector){
		this.dos = connector.getOutputStream();
	}
	
	public void sendMessage(String message){
		try{
			System.out.println(message + " on PC");
			dos.writeUTF(message);
			dos.flush();
	
		}
		catch(Exception e){
			
		}
	}

}

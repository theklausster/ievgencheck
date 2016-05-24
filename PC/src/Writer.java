import java.io.DataOutputStream;

import Connection.IConnector;


public class Writer {
	private DataOutputStream dos;
	public static Writer Instance;

	public static Writer getInstance() {
		if (Instance == null) {
			Instance = new Writer();
		}
		return Instance;
	}

	public void setupIConnector(IConnector connector) {
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

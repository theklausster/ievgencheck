package Connection;

import NXTConnector;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Connector implements IConnector{

	private boolean isConnected;
	NXTConnector conn;
	DataInputStream dis;
	DataOutputStream dos;
    
	public Connector(){
		conn = new NXTConnector();
		tryConnect("Omega");
		
	}
    private void tryConnect(String resource) {
    	isConnected = conn.connectTo("btspp://"+resource);
    	if	(isConnected){
    		dis = new DataInputStream(conn.getInputStream());
    	    dos = new DataOutputStream(conn.getOutputStream());
    	}
    	
	}

	public DataInputStream getInputStream() {
		return dis;
	}

	public DataOutputStream getOutputStream() {
		return dos;
	}
	public boolean isConnected() {
		return isConnected;
	}

}

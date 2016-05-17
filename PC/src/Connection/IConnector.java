package Connection;
import java.io.DataInputStream;
import java.io.DataOutputStream;


public interface IConnector {
	public boolean isConnected();
	public DataInputStream getInputStream();
	public DataOutputStream getOutputStream();
	
}

import java.awt.EventQueue;

import Connection.Connector;
import Connection.IConnector;

public class Main  {



	
	public static void main(String[] args) {
		IConnector connector = new Connector();
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				UI a = new UI();
				
			}
		});
		
		
		
	}

	
}



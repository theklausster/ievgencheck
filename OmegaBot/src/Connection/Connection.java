package Connection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Plan.TheArbitrator;
import lejos.nxt.LCD;
import lejos.nxt.comm.BTConnection;
import lejos.nxt.comm.Bluetooth;

public class Connection  {

	
	private BTConnection btc;
	
	public Connection()
	{
		setupConnection();
	}
		


		private void setupConnection() {
		
			    LCD.clear();
			    LCD.drawString("Waiting for client connection...", 0, 0);
			    btc = Bluetooth.waitForConnection();	    
			    LCD.drawString("Client connected", 0, 0);

	}
		
		public BTConnection getConnection(){
				return btc;
				
		}
		    
		
	}
	




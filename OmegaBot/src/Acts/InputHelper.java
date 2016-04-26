package Acts;

import java.io.DataInputStream;


public class InputHelper implements Runnable {

	private DataInputStream dis;
	
	 public InputHelper(DataInputStream dis) {
		 this.dis = dis;
		
	}
	
	@Override
	public void run() {

		try{
		while(true){
			System.out.println("In InputHelper " + dis.readUTF());
		}
		}
		catch(Exception e){
			System.out.println("In InputHelper " + e.getMessage());
		}
		
	}

}

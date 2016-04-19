package Main;

import Connection.Connection;
import Plan.TheArbitrator;

public class main {

	public static void main(String[] args) {
		TheArbitrator arb = new TheArbitrator();
		
		try {
			Thread.sleep(5000);
			Connection.getInstance().notifySubscriber("back");
			Thread.sleep(5000);
			Connection.getInstance().notifySubscriber("forward");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

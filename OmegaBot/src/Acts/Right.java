package Acts;

import java.io.DataOutputStream;
import java.io.IOException;

import lejos.robotics.navigation.DifferentialPilot;

public class Right implements IMovement {

	DifferentialPilot pilot;
	DataOutputStream dos;
	
	public Right(DifferentialPilot pilot, DataOutputStream dos) {
		this.pilot = pilot;
		this.dos = dos;
	}
	
	@Override
	public void move() {
		    pilot.steer(-40);
	
	}

	
	@Override
	public void giveResponse() throws IOException {
		dos.writeUTF("right x y");
		dos.flush();
	}
	

}

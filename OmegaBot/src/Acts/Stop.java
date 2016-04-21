package Acts;

import java.io.DataOutputStream;
import java.io.IOException;

import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

public class Stop implements IMovement{

	DifferentialPilot pilot;
	DataOutputStream dos;
	
	public Stop(DifferentialPilot pilot, DataOutputStream dos) {
		this.pilot = pilot;
		this.dos = dos;
	}
	
	@Override
	public void move() {
	    pilot.stop();
	
	}

	
	@Override
	public void giveResponse() throws IOException {
		dos.writeUTF("stop x y");
		dos.flush();
	}
	
	






}

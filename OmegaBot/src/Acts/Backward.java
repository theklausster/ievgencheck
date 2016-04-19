package Acts;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

public class Backward implements IMovement{
	
	
	DifferentialPilot pilot;
	DataOutputStream dos;
	public Backward(DifferentialPilot pilot, DataOutputStream dos) {
		this.pilot = pilot;
		this.dos = dos;
	}

	@Override
	public void move() {
		//pilot.backward();
		System.out.println("MOVEVING BACKWARD");
	}

	@Override
	public void giveResponse() throws IOException {
		dos.writeUTF("backward x y");
		dos.flush();
	}
	
}

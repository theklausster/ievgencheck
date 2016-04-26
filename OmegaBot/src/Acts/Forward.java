package Acts;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

public class Forward implements IMovement  {

	DifferentialPilot pilot;
	DataOutputStream dos;
	OdometryPoseProvider odom;
	
	public Forward(DifferentialPilot pilot, DataOutputStream dos, OdometryPoseProvider odom) {
		this.odom = odom;
		this.pilot = pilot;
		this.dos = dos;
	}

	@Override
	public void move() {
		pilot.forward();
	}

	@Override
	public void giveResponse() throws IOException {
		dos.writeUTF("forward "+ odom.getPose().getX() + " " + odom.getPose().getY());
		dos.flush();
	}
	


}

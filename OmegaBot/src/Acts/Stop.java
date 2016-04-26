package Acts;

import java.io.DataOutputStream;
import java.io.IOException;

import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

public class Stop implements IMovement{

	DifferentialPilot pilot;
	DataOutputStream dos;
	OdometryPoseProvider odom;
	public Stop(DifferentialPilot pilot, DataOutputStream dos, OdometryPoseProvider odom) {
		this.odom = odom;
		this.pilot = pilot;
		this.dos = dos;
	}
	
	@Override
	public void move() {
	    pilot.stop();
	
	}

	
	@Override
	public void giveResponse() throws IOException {
		dos.writeUTF("stop "+ odom.getPose().getX() + " " + odom.getPose().getY());
		dos.flush();
	}
	
	






}

package Acts;

import java.io.DataOutputStream;
import java.io.IOException;

import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.navigation.DifferentialPilot;

public class Right implements IMovement {

	DifferentialPilot pilot;
	DataOutputStream dos;
	OdometryPoseProvider odom;
	public Right(DifferentialPilot pilot, DataOutputStream dos, OdometryPoseProvider odom) {
		this.odom = odom;
		this.pilot = pilot;
		this.dos = dos;
	}
	
	@Override
	public void move() {
		    pilot.steer(-40);
	
	}

	
	@Override
	public void giveResponse() throws IOException {
		dos.writeUTF("right "+ odom.getPose().getX() + " " + odom.getPose().getY());
		dos.flush();
	}
	

}

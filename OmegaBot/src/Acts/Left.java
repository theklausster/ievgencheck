package Acts;

import Connection.ConnectionHelper;
import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.navigation.DifferentialPilot;

public class Left extends AbstractMovement {

	public Left(ConnectionHelper connectionHelper, DifferentialPilot pilot, OdometryPoseProvider odom) {
		super(connectionHelper, pilot, odom);
	}

	@Override
	public void move() {
		pilot.steer(40);  
	}

	@Override
	protected String getCodeWorld() {
		return "left";
	}
	
	
}

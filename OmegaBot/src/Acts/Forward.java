package Acts;

import Connection.ConnectionHelper;
import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.navigation.DifferentialPilot;

public class Forward extends AbstractMovement {

	public Forward(ConnectionHelper connectionHelper, DifferentialPilot pilot, OdometryPoseProvider odom) {
		super(connectionHelper, pilot, odom);
	}

	@Override
	public void move() {
		pilot.forward();
	}

	@Override
	protected String getCodeWorld() {
		return "forward";
	}
	


}

package Acts;

import Connection.ConnectionHelper;
import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.navigation.DifferentialPilot;

public class Backward extends AbstractMovement {
	

	public Backward(ConnectionHelper connectionHelper, DifferentialPilot pilot, OdometryPoseProvider odom) {
		super(connectionHelper, pilot, odom);
	}

	@Override
	public void move() {
		pilot.backward();
	}

	@Override
	protected String getCodeWorld() {
		return "backward";
	}
	
}

package Acts;

import Connection.ConnectionHelper;
import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.navigation.DifferentialPilot;

public class Stop extends AbstractMovement {

	public Stop(ConnectionHelper connectionHelper, DifferentialPilot pilot, OdometryPoseProvider odom) {
		super(connectionHelper, pilot, odom);
	}

	@Override
	public void move() {
	    pilot.stop();
	}

	@Override
	protected String getCodeWorld() {
		return "stop";
	}
	
	






}

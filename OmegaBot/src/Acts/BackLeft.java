package Acts;

import Connection.ConnectionHelper;
import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.navigation.DifferentialPilot;

public class BackLeft extends AbstractMovement {

	public BackLeft(ConnectionHelper connectionHelper, DifferentialPilot pilot, OdometryPoseProvider odom) {
		super(connectionHelper, pilot, odom);
	}

	@Override
	protected String getCodeWorld() {
		return "backleft";
		}

		@Override
		public void move() {
		pilot.steerBackward(40);
		}
		

	}



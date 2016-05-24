package Acts;

import Connection.ConnectionHelper;
import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.navigation.DifferentialPilot;

public class BackRight extends AbstractMovement {

	public BackRight(ConnectionHelper connectionHelper, DifferentialPilot pilot, OdometryPoseProvider odom) {
		super(connectionHelper, pilot, odom);
	}

		@Override
		public void move() {
			    pilot.steerBackward(-40);
	}
		

		@Override
	protected String getCodeWorld() {
		return "backright";
		}
		

	}



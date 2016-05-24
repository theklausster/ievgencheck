package Acts;

import java.io.IOException;

import Connection.ConnectionHelper;
import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.navigation.DifferentialPilot;

public abstract class AbstractMovement implements IMovement {

	private ConnectionHelper connectionHelper;
	protected DifferentialPilot pilot;
	private OdometryPoseProvider odom;


	public AbstractMovement(ConnectionHelper connectionHelper, DifferentialPilot pilot, OdometryPoseProvider odom) {
		this.connectionHelper = connectionHelper;
		this.pilot = pilot;
		this.odom = odom;
	}

	@Override
	public void giveResponse() throws IOException {

		connectionHelper.sendInput(getCodeWorld() + " " + +odom.getPose().getX() + " " + odom.getPose().getY());
	}

	protected abstract String getCodeWorld();




}

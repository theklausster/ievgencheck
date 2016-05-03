package Acts;

import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

public class Bumper implements Behavior {

	private DifferentialPilot pilot;
	private OdometryPoseProvider odom;
	private TouchSensor touch;
	private boolean isSuppressed = false;

	public Bumper(DifferentialPilot pilot, OdometryPoseProvider odom) {
		this.pilot = pilot;
		this.odom = odom;
		touch = new TouchSensor(SensorPort.S1);
	}

	@Override
	public boolean takeControl() {

		return touch.isPressed() && !isSuppressed;
	}

	@Override
	public void action() {
		pilot.stop();
		pilot.rotate(180);
		while (!isSuppressed && pilot.isMoving())
			Thread.yield();
	}

	@Override
	public void suppress() {
		isSuppressed = true;
	}

}

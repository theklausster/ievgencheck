package Acts;

import java.io.DataOutputStream;

import Connection.ConnectionHelper;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Pose;
import lejos.robotics.subsumption.Behavior;

public class Sensor implements Behavior, IGiveResponse {
	
	private DifferentialPilot pilot;
	private UltrasonicSensor sonic;
	private OdometryPoseProvider odom;
	private boolean isSupressed = false;
	private ConnectionHelper con;
	private final int obsticalDistance = 30;

	
	public Sensor(DifferentialPilot pilot, ConnectionHelper con, OdometryPoseProvider odom) {
		this.odom = odom;
		this.pilot = pilot;
		this.sonic = new UltrasonicSensor(SensorPort.S4);
		this.con = con;
	}

	@Override
	public boolean takeControl() {
		
		return !isSupressed && sonic.getDistance() < obsticalDistance;
	}

	@Override
	public void action() {
		giveResponse();
			Sound.beep();
		pilot.rotate(180);
			while(!isSupressed && pilot.isMoving())
				Thread.yield();
			if(sonic.getDistance() > 30){
			Sound.buzz(); // playing buzz if path is clear	  
			}
			Thread.yield();
	}
		

	@Override
	public void suppress() {
		isSupressed = true;

	}

	@Override
	public void giveResponse() {
		try {
			DataOutputStream dos = con.getDOS();
			Pose pose = odom.getPose();
			dos.writeUTF("obstical " + getObsticalX(pose) + " " + getObsticaY(pose));
			dos.flush();


		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	private double convertHeadingToDegrees(Pose pose) {
		return pose.getHeading();
	}

	private double getObsticalX(Pose pose) {
		double heading = convertHeadingToDegrees(pose);

		return (Math.cos(Math.toRadians(heading)) * obsticalDistance) + pose.getX();
	}

	private double getObsticaY(Pose pose) {
		double heading = convertHeadingToDegrees(pose);
		return (Math.sin(Math.toRadians(heading)) * obsticalDistance) + pose.getY();
	}
}

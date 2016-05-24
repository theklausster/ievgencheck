package Plan;


import java.io.DataInputStream;
import java.io.DataOutputStream;

import Acts.Bumper;
import Acts.Exit;
import Acts.Movement;
import Acts.Sensor;
import Connection.ConnectionHelper;
import lejos.nxt.Motor;
import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class TheArbitrator {
	
	private DifferentialPilot pilot;
	private Arbitrator arbitrator;
	private Movement movement;
	private Sensor sensor;
	private Bumper bumper;
	private Exit exit;
	DataInputStream dis;
	DataOutputStream dos;
	ConnectionHelper ch;
	OdometryPoseProvider odom;

	
	public TheArbitrator() {
		ch = new ConnectionHelper();
		Thread thread = new Thread(ch);
		thread.start();
	
	
	pilot = new DifferentialPilot(DifferentialPilot.WHEEL_SIZE_NXT2, 12.5, Motor.B, Motor.C);
	odom = new OdometryPoseProvider(pilot);
	exit = new Exit();
		sensor = new Sensor(pilot, ch, odom);
	movement = new Movement(pilot, ch, odom);
		bumper = new Bumper(pilot, odom);
		Behavior[] behaviorList = { movement, sensor, bumper, exit };

	arbitrator = new Arbitrator(behaviorList);
	arbitrator.start();
	

	}
	

	
	





	
	
}

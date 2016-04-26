package Plan;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import Acts.Backward;
import Acts.Exit;
import Acts.Forward;
import Acts.InputHelper;
import Acts.Movement;
import Acts.Sensor;
import Acts.Stop;
import Connection.ConnectionHelper;
import lejos.nxt.ColorSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class TheArbitrator {
	
	private DifferentialPilot pilot;
	private Arbitrator arbitrator;
	private Movement movement;
	private Sensor sensor;
	private Exit exit;
	DataInputStream dis;
	DataOutputStream dos;
	ConnectionHelper ch;
	
	
	public TheArbitrator() {
		ch = new ConnectionHelper();
		Thread thread = new Thread(ch);
		thread.start();
		
	pilot = new DifferentialPilot(DifferentialPilot.WHEEL_SIZE_NXT2, 12.5, Motor.B, Motor.C);
	exit = new Exit();
	sensor = new Sensor(pilot);
	movement = new Movement(pilot, ch);
	Behavior[] behaviorList = {movement, sensor, exit};
	//Thread thread = new Thread(new InputHelper(dis));
	//thread.start();
	arbitrator = new Arbitrator(behaviorList);
	arbitrator.start();
	

	}
	

	
	





	
	
}

package Plan;


import java.io.DataInputStream;
import java.io.IOException;
import Acts.Backward;
import Acts.Exit;
import Acts.Forward;
import Acts.Movement;
import Acts.Stop;
import Connection.Connection;
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
	private Exit exit;
	
	public TheArbitrator() {
	Connection con = new Connection();
	//sensor = new ColorSensor(SensorPort.S1);
	pilot = new DifferentialPilot(DifferentialPilot.WHEEL_SIZE_NXT2, 12.5, Motor.B, Motor.C);
	exit = new Exit();
	movement = new Movement(pilot, con);
	Behavior[] behaviorList = {movement, exit};
	arbitrator = new Arbitrator(behaviorList);
	arbitrator.start();
	}
	

	
	





	
	
}

package Plan;


import java.io.DataInputStream;
import java.io.IOException;

import Acts.Backward;
import Acts.Forward;
import Connection.Connection;
import Connection.ISub;
import lejos.nxt.ColorSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class TheArbitrator implements ISub{
	
	private DifferentialPilot pilot;
	private Forward forward;
	private Backward backward;
	private Arbitrator arbitrator;
	private Boolean whiteDetected;
	//private ColorSensor sensor;
	private DataInputStream dis;
	private boolean done = false;
	
	public TheArbitrator() {
		Connection.getInstance().addSubscriber(this);
		System.out.println("TheArbitrator() Exicuted");
	//sensor = new ColorSensor(SensorPort.S1);
	pilot = new DifferentialPilot(DifferentialPilot.WHEEL_SIZE_NXT2, 12.5, Motor.B, Motor.C);
	forward = new Forward(pilot);
	backward = new Backward(pilot);
	Behavior[] behaviorList = {forward, backward};
	arbitrator = new Arbitrator(behaviorList);
	arbitrator.start();
	System.out.println(Connection.getInstance().getSubscribers().size());
	}
	

	@Override
	public void getLastMessage(String msg) {
		
		System.out.println("Got message from Subject " + msg);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(msg == "back"){
		backward.iWantToControl();
	
		}
		
	}
	
	
}

package Acts;

import java.io.DataOutputStream;
import java.io.IOException;

import lejos.nxt.SensorPort;
import lejos.nxt.Sound;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

public class Sensor implements Behavior{
	
	private DifferentialPilot pilot;
	private UltrasonicSensor sonic;
	private boolean isSupressed = false;
	
	public Sensor(DifferentialPilot pilot){
		
		this.pilot = pilot;
		this.sonic = new UltrasonicSensor(SensorPort.S4);
	}

	@Override
	public boolean takeControl() {
		
		return !isSupressed && sonic.getDistance() < 30;
	}

	@Override
	public void action() {
			Sound.beep();
			pilot.stop();
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
	


}

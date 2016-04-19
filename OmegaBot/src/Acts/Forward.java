package Acts;

import java.io.DataInputStream;

import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

public class Forward implements Behavior {
	private boolean isSuppresed;
	private DifferentialPilot pilot;
	private boolean inControl = false;
	
	public Forward(DifferentialPilot pilot) {
		this.pilot = pilot;
	}
	
	@Override
	public boolean takeControl() {
		return true;
	}

	@Override
	public void action() {
		isSuppresed = false;
		pilot.forward();
		while(!isSuppresed)
			Thread.yield();
	}

	@Override
	public void suppress() {
		isSuppresed = true;
		
	}




}

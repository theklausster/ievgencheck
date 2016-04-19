package Acts;

import java.io.DataInputStream;
import java.io.IOException;

import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

public class Backward implements Behavior{
	
	
	private boolean isSuppresed;
	private DifferentialPilot pilot;
	private boolean inControl = false;
	
	public Backward(DifferentialPilot pilot) {
		this.pilot = pilot;

	}

	public void iWantToControl(){
		System.out.print("in backward");
		inControl = true;
	}
	
	
	@Override
	public boolean takeControl() {
		return inControl;
	}

	@Override
	public void action() {
		isSuppresed = false;
		pilot.backward();
		while(!isSuppresed)
			Thread.yield();
	}

	@Override
	public void suppress() {
		 inControl = false;
		 isSuppresed = true;
		
	}

	
}

package Acts;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.robotics.subsumption.Behavior;

public class Exit implements Behavior, ButtonListener{
	
	private boolean isPressed;
	
	public Exit() {
		Button.ESCAPE.addButtonListener(this);
	}

	@Override
	public boolean takeControl() {
		return isPressed;
	
	}

	@Override
	public void action() {
		System.exit(0);
		
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buttonPressed(Button b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buttonReleased(Button b) {
		isPressed = true;		
	}


}

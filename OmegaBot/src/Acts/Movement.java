package Acts;

import Connection.ConnectionHelper;
import Connection.ISub;
import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

public class Movement implements Behavior, ISub{

	private DifferentialPilot pilot;
	IMovement movement;
	IMovement forward;
	IMovement back;
	IMovement stop;
	IMovement left;
	IMovement right;
	IMovement backleft;
	IMovement backright;
	Direction direction = Direction.Stop;
	boolean isSupressed = false;
	String input = "stop";
	boolean newInput;

	
	 public Movement(DifferentialPilot pilot, ConnectionHelper ch, OdometryPoseProvider odom) {
		this.pilot = pilot;
		ch.addSub(this);
		forward = new Forward(ch, pilot, odom);
		back = new Backward(ch, pilot, odom);
		stop = new Stop(ch, pilot, odom);
		left = new Left(ch, pilot, odom);
		right = new Right(ch, pilot, odom);
		backright = new BackRight(ch, pilot, odom);
		backleft = new BackLeft(ch, pilot, odom);
	}
	

	@Override
	public boolean takeControl() {
		return true;
	}

	@Override
	public void action() {
		try{
			isSupressed = false;
			newInput = false;
			
			switch (input) {
				case "forward":
					direction = Direction.Forward;
					movement = forward;
					
				break;
				case "backward":
					direction = Direction.Backward;
					movement = back;
					
				break;
				case "stop":
					direction = Direction.Stop;
					movement = stop;
				break;
				case "left":
					if(direction == Direction.Forward ) {movement = left;}
					if(direction == Direction.Backward ) { movement = backleft;}
					break;
				case "right":
					if(direction == Direction.Forward ) {movement = right;}
					if(direction == Direction.Backward) { movement = backright;}
				break;

			default:
				break;
			}

			movement.move();
			    movement.giveResponse();

				while(!isSupressed && !newInput)
					Thread.yield();
				
		}
			catch(Exception e) {}
	
	}

	@Override
	public void suppress() {
		input = "stop";
		isSupressed = true;
		
	}
	
	private enum Direction{
		Forward,Backward,Stop;
	}

	@Override
	public void getInput(String input) {
	
		newInput = true;
		this.input = input;
		
	}
	
	




}

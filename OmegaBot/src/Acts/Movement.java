package Acts;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import Connection.ConnectionHelper;
import Connection.ISub;
import lejos.nxt.LCD;
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
	
	 public Movement(DifferentialPilot pilot, ConnectionHelper ch ) {
		this.pilot = pilot;
		ch.addSub(this);
		forward = new Forward(pilot, ch.getDOS());
		back = new Backward(pilot, ch.getDOS());
		stop = new Stop(pilot, ch.getDOS());
		left = new Left(pilot, ch.getDOS());
		right = new Right(pilot, ch.getDOS());
		backright = new BackRight(pilot, ch.getDOS());
		backleft = new BackLeft(pilot, ch.getDOS());
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
		isSupressed = true;
		
	}
	
	private enum Direction{
		Forward,Backward,Stop;
	}

	@Override
	public void getInput(String input) {
	
		newInput = true;
		this.input = input;
		
		System.out.println(this.input + " in sub");
		
	}
	
	




}

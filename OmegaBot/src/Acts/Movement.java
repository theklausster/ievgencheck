package Acts;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import Connection.Connection;
import lejos.nxt.LCD;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;

public class Movement implements Behavior{

	private Connection con;
	private DifferentialPilot pilot;
	DataInputStream dis;
	DataOutputStream dos;
	IMovement movement;
	IMovement forward;
	IMovement back;
	IMovement stop;
	IMovement left;
	IMovement right;
	IMovement backleft;
	IMovement backright;
	Direction direction = Direction.Stop;
	boolean isSupressed;
	
	
	 public Movement(DifferentialPilot pilot, Connection con) {
		this.con = con;
		this.pilot = pilot;
		dis = new DataInputStream(con.getConnection().openDataInputStream());
		dos = new DataOutputStream(con.getConnection().openDataOutputStream());
		forward = new Forward(pilot, dos);
		back = new Backward(pilot,dos);
		stop = new Stop(pilot,dos);
		left = new Left(pilot,dos);
		right = new Right(pilot,dos);
		backright = new BackRight(pilot,dos);
		backleft = new BackLeft(pilot,dos);
	}
	

	@Override
	public boolean takeControl() {
		return true;
	}

	@Override
	public void action() {
		try{
			
		while(!isSupressed)
		{
			String input = dis.readUTF();
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
		}
		}
		catch(IOException i){
			
		}
	}

	@Override
	public void suppress() {
		isSupressed = true;
		
	}
	
	private enum Direction{
		Forward,Backward,Stop;
	}
	
	




}

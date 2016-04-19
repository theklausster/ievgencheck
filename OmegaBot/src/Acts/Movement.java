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
	boolean isSupressed;
	
	
	 public Movement(DifferentialPilot pilot, Connection con) {
		this.con = con;
		this.pilot = pilot;
		dis = new DataInputStream(con.getConnection().openDataInputStream());
		dos = new DataOutputStream(con.getConnection().openDataOutputStream());
		forward = new Forward(pilot, dos);
		back = new Backward(pilot,dos);
		stop = new Stop(pilot,dos);
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
			
		switch (dis.readUTF()) {
			case "forward":
				movement = forward;
			break;
			case "backward":
				movement = back;
			break;
			case "stop":
				movement = stop;
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
	
	




}

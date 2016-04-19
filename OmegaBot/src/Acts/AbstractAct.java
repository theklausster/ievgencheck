package Acts;

import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;


public abstract class AbstractAct implements Behavior {
	
	private String name;
	protected DifferentialPilot pilot;
	protected boolean isSuppresed;
	
	public AbstractAct(DifferentialPilot pilot, String name){
		this.pilot = pilot;
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	

}

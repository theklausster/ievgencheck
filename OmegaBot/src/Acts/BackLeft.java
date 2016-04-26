package Acts;

import java.io.DataOutputStream;
import java.io.IOException;

import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.navigation.DifferentialPilot;

public class BackLeft implements IMovement {

		DifferentialPilot pilot;
		DataOutputStream dos;
		OdometryPoseProvider odom;
		public BackLeft(DifferentialPilot pilot, DataOutputStream dos, OdometryPoseProvider odom) {
			this.odom = odom;
			this.pilot = pilot;
			this.dos = dos;
		}
		
		@Override
		public void move() {
			    pilot.steerBackward(40);
		
		}
		
		@Override
		public void giveResponse() throws IOException {
			dos.writeUTF("backleft "+ odom.getPose().getX() + " " + odom.getPose().getY());
			dos.flush();
		}
		

	}



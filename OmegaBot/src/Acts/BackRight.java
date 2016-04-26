package Acts;

import java.io.DataOutputStream;
import java.io.IOException;

import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.navigation.DifferentialPilot;

public class BackRight implements IMovement {

		DifferentialPilot pilot;
		DataOutputStream dos;
		OdometryPoseProvider odom;
		public BackRight(DifferentialPilot pilot, DataOutputStream dos, OdometryPoseProvider odom) {
			this.odom = odom;
			this.pilot = pilot;
			this.dos = dos;
		}
		
		@Override
		public void move() {
			    pilot.steerBackward(-40);
		
		}

		
		@Override
		public void giveResponse() throws IOException {
			dos.writeUTF("backright "+ odom.getPose().getX() + " " + odom.getPose().getY());
			dos.flush();
		}
		

	}




import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;

import lejos.pc.comm.NXTConnector;

public class UI extends JFrame implements KeyListener {
	
	 DataOutputStream dos;
	 DataInputStream dis;
	 
	 
	 public UI(){
			setupConnection();
			setupUi();
	 }
	 
	 private void setupConnection() {
			
			NXTConnector conn = new NXTConnector();
		    boolean connected = conn.connectTo("btspp://Omega");
		    
		    if (! connected)
		    {
			System.out.println("ERROR - Unable to connect to NXT");
			System.exit(2);
		    }
		    
		    dis = new DataInputStream(conn.getInputStream());
		    dos = new DataOutputStream(conn.getOutputStream());
			
		}

		private  void setupUi() {
			JPanel panel = new JPanel();
			panel.setPreferredSize(new Dimension(640, 480));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			addKeyListener(this);
			setContentPane(panel);
			setLocation(150, 100);
	        setResizable(false);
	        pack();
	        setVisible(true);
		
			
		
		}

		
		public void sendMsg(String input){
			try{
				System.out.println(input + " on PC");
				dos.writeUTF(input);
				dos.flush();
		
			}
			catch(Exception e){
				
			}
		}
		
		public void getMsg(){
			String input;
			try{
				input = dis.readUTF();
				System.out.println(input);
			}
			catch(Exception e){
				
			}
		}

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			switch(e.getKeyCode()){
			case 37:
				sendMsg("left");
				break;
			case 38:
				sendMsg("forward");
				break;
			case 39:
				sendMsg("right");
				break;
			case 40:
				sendMsg("backward");
				break;
			case 32:
				sendMsg("stop");
				break;
		    default:
				break;
				
			}
			getMsg();
			
			
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

}

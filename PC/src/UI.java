
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import javax.swing.JFrame;

import Connection.IConnector;
import lejos.pc.comm.NXTConnector;

public class UI extends JFrame implements KeyListener, ISub {
	
	Writer writer;
	Reader reader;
	
	DataOutputStream dos;
	 DataInputStream dis;
	 MainPanel panel;
	Dimension screenSize;
	DISListener disListener;
	 
	 public UI(){
			setupConnection();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			setupUi();
		setupDisListener();
	}
	 public UI(IConnector connector){
			//setupConnection();
		 writer = new Writer(connector);
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			setupUi();
		setupReaderListener(connector);
	}

	 private void setupReaderListener(IConnector connector){
		 reader = new Reader(connector);
		 reader.addSub(this);
		 new Thread(reader).start();
	 }
	 
	private void setupDisListener() {
		disListener = new DISListener(dis);
		disListener.addSub(this);
		new Thread(disListener).start();

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
		panel = new MainPanel((int) screenSize.getWidth() - 100, (int) screenSize.getHeight() - 100);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			addKeyListener(this);
			setContentPane(panel);
		    setLocation(0, 0);
		    setResizable(true);
	        pack();
	        setVisible(true);
		}

		
		public void sendMsg(String input){
			writer.sendMessage(input);
			/*
			try{
				System.out.println(input + " on PC");
				dos.writeUTF(input);
				dos.flush();
		
			}
			catch(Exception e){
				
			}*/
		}
		

		private double getY(String input) {
			String[] parts = input.split(" ");
			return Double.parseDouble(parts[2]);
		}

		private double getX(String input) {
			String[] parts = input.split(" ");
			return Double.parseDouble(parts[1]);
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

			
			
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

	@Override
	public void getInput(String input) {
		double x = getX(input);
		double y = getY(input);
		String key = getKey(input);
		if (key.equals("obstical")) {
			panel.addObstacles(x, y);
		} else {
			panel.addPoint(x, y);

		}
		panel.repaint();
		// System.out.println(input + " from robot");

	}

	private String getKey(String input) {
		String[] parts = input.split(" ");
		return parts[0];
	}

}

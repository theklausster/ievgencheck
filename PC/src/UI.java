
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import javax.swing.JFrame;

import Connection.IConnector;

public class UI extends JFrame implements KeyListener, ISub {
	
	Writer writer;
	Reader reader;
	
	DataOutputStream dos;
	DataInputStream dis;
	MainPanel panel;
	Dimension screenSize;
	 
	 public UI(IConnector connector){
		writer = Writer.getInstance();
		writer.setupIConnector(connector);
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setupUi();
		setupReaderListener(connector);
	}

	 private void setupReaderListener(IConnector connector){
		 reader = new Reader(connector);
		 reader.addSub(this);
		 new Thread(reader).start();
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

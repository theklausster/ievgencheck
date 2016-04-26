import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import lejos.pc.comm.NXTConnector;
import sun.awt.EventQueueDelegate;

public class Main  {



	
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				UI a = new UI();
				
			}
		});
		
		
		
	}

	
}



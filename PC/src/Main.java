import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;


public class Main  {
	static JButton forward;
	static JButton down;
	static JButton left;
	static JButton right;
	static JButton stop;

	
	public static void main(String[] args) {
		JFrame frame = new JFrame("lol");
	
		 forward = new JButton("Forward");
		 down = new JButton("Down");
		 left = new JButton("Left");
		 right = new JButton("Right");
		 stop = new JButton("Stop");
		 setUpListeners();
		 
		 forward.setPreferredSize(new Dimension(40, 40));
		 down.setPreferredSize(new Dimension(40, 40));
		 left.setPreferredSize(new Dimension(40, 40));
		 right.setPreferredSize(new Dimension(40, 40));
		 stop.setPreferredSize(new Dimension(40, 40));

		 
		 frame.add(forward);
		 frame.add(down);
		 frame.add(left);
		 frame.add(right);
		 frame.add(stop);
		 frame.setSize(500, 500);
		 frame.pack();
		 frame.setVisible(true);
		 
		
	}

	private static void setUpListeners() {
	forward.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	right.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
	left.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
	down.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
	stop.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
	
		
	}

}

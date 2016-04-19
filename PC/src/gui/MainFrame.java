package gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame {
	
	public void createGUI() {
        
		JFrame frame = new JFrame("I am a robot");

        JPanel foregroundPanel = new Panel();
        frame.setPreferredSize(new Dimension(1000,600));
        frame.setContentPane(foregroundPanel);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);  
   }

}

package gui;

import lejos.pc.comm.NXTConnector;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import javax.swing.JPanel;

public class Panel extends javax.swing.JPanel implements KeyListener{


    DataInputStream dis;
    DataOutputStream dos;
    NXTConnector conn = new NXTConnector();
    /**
     * Creates new form Panel
     */
    public Panel() {
        initComponents();
    }
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        mapPanel = new javax.swing.JPanel();
        lblMap = new javax.swing.JLabel();
        infoPanel = new javax.swing.JPanel();
        lblConnect = new javax.swing.JLabel();
        btnConnect = new javax.swing.JButton();
        txtRobot = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaInfo = new javax.swing.JTextArea();

        lblMap.setText("Map");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(mapPanel);
        mapPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(lblMap)
                .addContainerGap(133, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblMap)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        lblConnect.setText("Connect to:");

        btnConnect.setText("Connect");
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConnectClicked(evt);
            }
        });

        txtRobot.setText("Omega");

        txtAreaInfo.setColumns(20);
        txtAreaInfo.setRows(5);
        jScrollPane1.setViewportView(txtAreaInfo);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblConnect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtRobot))
                    .addComponent(btnConnect))
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblConnect)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRobot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConnect)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mapPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>                        

    private void buttonConnectClicked(java.awt.event.ActionEvent evt) {
    	System.out.println("Connecting to NXT...");
		String robotName = txtRobot.getText();
		txtAreaInfo.append("Connecting to " + robotName);
		 
		 System.out.println("NXT con oprettet");
		 boolean connected = conn.connectTo("btspp://Omega");
		 System.out.println(connected);
		 if (! connected)
		    {
			 txtAreaInfo.append("ERROR - Unable to connect to NXT");
			System.exit(2);
		    }
		 else{
			 txtAreaInfo.append("Connection created");
		 }
		// DataInputStream dis = new DataInputStream(conn.getInputStream());
		// DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
    }                                        


    // Variables declaration - do not modify                     
    private javax.swing.JButton btnConnect;
    private javax.swing.JLabel lblConnect;
    private javax.swing.JLabel lblMap;
    private javax.swing.JPanel mapPanel;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAreaInfo;
    private javax.swing.JTextField txtRobot;
    // End of variables declaration  
    
    private void sendMessage(String msg){
    	try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
    }
	
    public void keyPressed(KeyEvent e) {
    	if(e.getKeyCode()== KeyEvent.VK_RIGHT)
            sendMessage("right");
        else if(e.getKeyCode()== KeyEvent.VK_LEFT)
        	sendMessage("left");
        else if(e.getKeyCode()== KeyEvent.VK_DOWN)
        	sendMessage("forward");
        else if(e.getKeyCode()== KeyEvent.VK_UP)
        	sendMessage("back");
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

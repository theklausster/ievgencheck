/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 *
 * @author Stepanenko
 */
public class MainPanel extends JPanel{
    private final int ELLIPSE_RADIUS = 3;
    ArrayList<Point> pointList;
    ArrayList<Point> obstaclesList;
    Color pointColor;
    Color obstaclesColor;
    int width;
    int height;
    double scale;

	public MainPanel(int x, int y) {
        pointList = new ArrayList<>();
        obstaclesList = new ArrayList<>();
        pointColor = Color.BLUE;
        obstaclesColor = Color.RED;
        setBackground(Color.white);
        width = getWidth();
        height = getHeight();
        scale = 1.0;
		height = y;
		width = x;
		setPreferredSize(new Dimension(x, y));
		
    }

   
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        Graphics2D g2 = (Graphics2D)g;
        Point point;
        Point nextPoint;
        Ellipse2D ellipse;
        Ellipse2D nextEllipse;
        g2.setPaint(Color.black);
        //coordinate
        g2.drawLine(0, height/2, width, height/2);
        g2.drawLine(width/2, 0, width/2, height);
        
        for(int j = 0; j < pointList.size(); j++)
        {
            point = (Point) pointList.get(j);
            ellipse = new Ellipse2D.Double(point.x - ELLIPSE_RADIUS, point.y - ELLIPSE_RADIUS, 2*ELLIPSE_RADIUS, 2*ELLIPSE_RADIUS);
            g2.setPaint(pointColor);
            g2.fill(ellipse);
            
			if (j != 0) {
				nextPoint = (Point) pointList.get(j - 1);
				g2.drawLine(point.x, point.y, nextPoint.x, nextPoint.y);
			}
            
        }
        
        for(int j = 0; j < obstaclesList.size(); j++)
        {
            point = (Point) obstaclesList.get(j);
            ellipse = new Ellipse2D.Double(point.x - ELLIPSE_RADIUS, point.y - ELLIPSE_RADIUS, 2*ELLIPSE_RADIUS, 2*ELLIPSE_RADIUS);
            g2.setPaint(obstaclesColor);
            g2.fill(ellipse);
         
        }
    }
    
    public void addPoint(double x, double y)
    {

        Point p = convertToPoint(x,y);
        pointList.add(p);
		// repaint();
        
    }    
    
    public void addObstacles(double x, double y){
        Point p = convertToPoint(x,y);
        obstaclesList.add(p);
        repaint();
    }

    private Point convertToPoint(double x, double y) {
        int roundedX = (int) Math.round(x);
        int roundedY = (int) Math.round(y);
        //turn coordinate 90 degrees
        int normalX = -roundedY;
        int normalY = roundedX;
        //convert x,y to JPanel coordinate
        Point p = new Point(normalX + width/2, height/2 - normalY);
        return p;
    }
}

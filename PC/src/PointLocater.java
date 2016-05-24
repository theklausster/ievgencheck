import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PointLocater extends MouseAdapter {

	private MainPanel mainPanel;

	public PointLocater(MainPanel mp) {
		mainPanel = mp;
	}

	@Override
	public void mousePressed(MouseEvent e) {
	
		Point p = e.getPoint();
		mainPanel.addDestinationPoint(p.getX(), p.getY());
		String convertedCoordinate = mainPanel.convertToRobotCoordinates(p);
		Writer.getInstance().sendMessage(convertedCoordinate);
	}

}

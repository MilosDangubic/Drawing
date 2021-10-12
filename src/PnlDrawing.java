import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class PnlDrawing extends JPanel 
{
	
	public PnlDrawing() 
	{	
		super();
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) 
			{
				Point p= new Point(e.getX(),e.getY());
				if(StartWindow.getInstance().getMouseClicks()[1]==null) 
				{
					StartWindow.getInstance().getMouseClicks()[1]=p;
				}
				
				else 
				{
					StartWindow.getInstance().getMouseClicks()[0]=StartWindow.getInstance().getMouseClicks()[1];
					StartWindow.getInstance().getMouseClicks()[1]=p;
					
				}
				
				for(Shape shape : StartWindow.getInstance().shapes) 
				{
					if(shape.contains(e.getX(), e.getY())) 
					{
						shape.setSelected(true);	
					}
					else 
					{
						shape.setSelected(false);
					}
					
				}
				StartWindow.getInstance().startDrawing();
				
			}
		});
		
		
	}
	
	
	public void paint(Graphics g) 
	{
		g.clearRect(1, 1, 1000, 1000);
		for(Shape shape : StartWindow.getInstance().getShapes()) {
			shape.draw(g);
		}
		
	
	}
	
	

}
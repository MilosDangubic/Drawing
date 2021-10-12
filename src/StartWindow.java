import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.Dimension;


import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class StartWindow   extends JFrame
{
	
	public void startDrawing() 
	{
		pnlDrawing.paint(pnlDrawing.getGraphics());
	}
	public static StartWindow getInstance() 
	{
		if(instance==null) 
		{
			instance= new StartWindow();
		}
		return instance;
		
		
	}
	
	public StartWindow()
	{
		
		buttonEdit= new JButton("Edit");
		mouseClicks=new Point[2];
		shapes = new ArrayList<Shape>();
		setLocationRelativeTo(null);
		pnlDrawing=new PnlDrawing();
		setLayout(new BorderLayout ());
		getContentPane().add(pnlDrawing,BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 550);
		setTitle("MAIN WINDOW");
		setResizable(false);
		JPanel pnlButtons= new JPanel();
		pnlButtons.setLayout(new FlowLayout(FlowLayout.LEFT));
		getContentPane().add(pnlButtons,BorderLayout.NORTH);
		
		deleteButton= new JButton("Delete");
	
		
		rbtnPoint= new JRadioButton("Point");
		rbtnPoint.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Color c=JColorChooser.showDialog(null, "Choose color: ", Color.GREEN);
				Point p= new Point(mouseClicks[1].getX(),mouseClicks[1].getY(),false,c);
				shapes.add(p);
				startDrawing();
			}
		});
		rbtnLine= new JRadioButton("Line");
		rbtnLine.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Point p1=new Point(mouseClicks[0].getX(),mouseClicks[0].getY());
				Point p2=new Point(mouseClicks[1].getX(),mouseClicks[1].getY());
				Color c=JColorChooser.showDialog(null, "Choose color: ", Color.GREEN);
				Line l= new Line(p1, p2,false,c);
				shapes.add(l);
				startDrawing();
				
			}
		});
		rbtnCircle= new JRadioButton("Circle");
		rbtnCircle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DlgCircleAdd d= new DlgCircleAdd();
				d.setVisible(true);
				
			}
		});
		rbtnRectangle= new JRadioButton("Rectangle");
		rbtnRectangle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DlgRectAdd d= new DlgRectAdd();
				d.setVisible(true);
			}
		});
		rbtnDonut= new JRadioButton("Donut");
		rbtnDonut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DlgDonutAdd d= new DlgDonutAdd();
				d.setVisible(true);
				
			}
		});
		
		
				
		
		
		
		
		
		deleteButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
		
				for(Shape s : shapes) 
				{
					if(s.isSelected()) 
					{
						
						DlgDelete d= new DlgDelete();
						d.setVisible(true);
						return;
						
					}
				}
				DlgMessage d= new DlgMessage();
				d.setVisible(true);
				
			}
		});
		
		buttonEdit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
					Shape selectovani=null;
					for(Shape s: shapes) 
					{
						if(s.contains(mouseClicks[1].getX(), mouseClicks[1].getY())) 
						{
							selectovani=s;
							break;
							
						}
						
					}
					
					if(selectovani==null) 
					{
						
						return;
					}
					
					if(selectovani instanceof Rectangle) 
					{
						
						DlgRectEdit d= new DlgRectEdit((Rectangle)selectovani);
						d.setVisible(true);
						
					}
					else if(selectovani instanceof Point) 
					{
						DlgPointEdit d= new DlgPointEdit((Point)selectovani);
						d.setVisible(true);
						
					}
					else if(selectovani instanceof Donut)
					{
						DlgDonutEdit d= new DlgDonutEdit((Donut)selectovani);
						d.setVisible(true);
						
					}
					else if(selectovani instanceof Circle) 
					{
						DlgCircleEdit d= new DlgCircleEdit((Circle)selectovani);
						d.setVisible(true);
						
					}
					else if(selectovani instanceof Line) 
					{
						DlgLineEdit d= new DlgLineEdit((Line)selectovani);
						d.setVisible(true);
						
					}
				
				
				
			}
		});
		
		
		
		pnlButtons.add(buttonEdit);
		pnlButtons.add(deleteButton);
		
		buttonGroup= new ButtonGroup();
		buttonGroup.add(rbtnPoint);
		buttonGroup.add(rbtnLine);
		buttonGroup.add(rbtnRectangle);
		buttonGroup.add(rbtnCircle);
		buttonGroup.add(rbtnDonut);
		JPanel pnlSouth= new JPanel();
		pnlSouth.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnlSouth.add(rbtnLine);
		pnlSouth.add(rbtnRectangle);
		pnlSouth.add(rbtnCircle);
		pnlSouth.add(rbtnPoint);
		pnlSouth.add(rbtnDonut);
		getContentPane().add(pnlSouth,BorderLayout.SOUTH);
		
		
		

	}
	
	public JButton getbtnDelete() {
		return deleteButton;
	}
	public void setbtnDelete(JButton deleteButton) {
		this.deleteButton = deleteButton;
	}
	
	public PnlDrawing getPnlDrawing() {
		return pnlDrawing;
	}
	public void setPnlDrawing(PnlDrawing pnlDrawing) {
		this.pnlDrawing = pnlDrawing;
	}
	public ArrayList<Shape> getShapes() {
		return shapes;
	}
	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}

	public JRadioButton getRbtnLine() {
		return rbtnLine;
	}

	public void setRbtnLine(JRadioButton rbtnLine) {
		this.rbtnLine = rbtnLine;
	}

	public JRadioButton getRbtnPoint() {
		return rbtnPoint;
	}

	public void setRbtnPoint(JRadioButton rbtnPoint) {
		this.rbtnPoint = rbtnPoint;
	}

	public JRadioButton getRbtnCircle() {
		return rbtnCircle;
	}

	public void setRbtnCircle(JRadioButton rbtnCircle) {
		this.rbtnCircle = rbtnCircle;
	}

	public JRadioButton getRbtnRectangle() {
		return rbtnRectangle;
	}

	public void setRbtnRectangle(JRadioButton rbtnRectangle) {
		this.rbtnRectangle = rbtnRectangle;
	}

	public JRadioButton getRbtnDonut() {
		return rbtnDonut;
	}

	public void setRbtnDonut(JRadioButton rbtnDonut) {
		this.rbtnDonut = rbtnDonut;
	}

	public ButtonGroup getRadioButtons() {
		return buttonGroup;
	}

	public void setRadioButtons(ButtonGroup buttonGroup) {
		this.buttonGroup = buttonGroup;
	}

	public Point[] getMouseClicks() {
		return mouseClicks;
	}

	public void setMouseclicsk(Point[] mouseClicks) {
		this.mouseClicks = mouseClicks;
	}
	
	private JRadioButton rbtnLine;
	private JRadioButton rbtnPoint;
	private JRadioButton rbtnRectangle;
	private JRadioButton rbtnDonut;
	private JRadioButton rbtnCircle;
	private PnlDrawing pnlDrawing;
	public ArrayList<Shape> shapes;
	private static StartWindow instance;
	private JButton deleteButton;
	private ButtonGroup buttonGroup;
	public Point[] mouseClicks;
	private JButton buttonEdit;
	

}

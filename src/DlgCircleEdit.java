import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DlgCircleEdit extends JDialog
{

	private Color color;
	private Color color2;
	private Circle circle;
	
	public DlgCircleEdit(Circle circle) 
	{
		JLabel labelX= new JLabel("X: ");
		JLabel labelY= new JLabel("Y: ");
		color=circle.getColor();
		JButton btnColor= new JButton("Color");
		 this.circle=circle;
		setBounds(200, 200, 300, 250);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		Dimension dim= new Dimension(100,30);
		JTextField txtX= new JTextField();
		txtX.setPreferredSize(dim);
		JPanel pnlX= new JPanel();
		JPanel pnlY= new JPanel();
		JTextField  txtY= new JTextField();
		txtY.setPreferredSize(dim);
		setLayout(new BorderLayout());
		pnlX.setLayout(new FlowLayout());
		pnlY.setLayout(new FlowLayout());
		JPanel mainPanel= new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		pnlX.add(labelX);
		pnlX.add(txtX);
		pnlY.add(labelY);
		pnlY.add(txtY);
		JPanel pnlRadius= new JPanel();
		JPanel pnlVisina= new JPanel();
		pnlRadius.setLayout(new FlowLayout());
		pnlVisina.setLayout(new FlowLayout());
		JLabel lblRadius= new JLabel("Insert radius: ");
		JTextField txtRadius= new JTextField();
		txtRadius.setPreferredSize(dim);
		txtX.setText(String.valueOf(circle.getCenter().getX()));
		txtY.setText(String.valueOf(circle.getCenter().getY()));
		txtRadius.setText(String.valueOf(circle.getRadius()));
		
		pnlRadius.add(lblRadius);
		pnlRadius.add(txtRadius);
		mainPanel.add(pnlX);
		mainPanel.add(pnlY);
		mainPanel.add(pnlRadius);
		add(mainPanel,BorderLayout.CENTER);
	
		
		JButton btnCancel= new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		JButton btnConfirm=new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				color=JColorChooser.showDialog(null, "Outer color: ", circle.getColor());
				color2=JColorChooser.showDialog(null, "Outer color: ", circle.getColor());

				circle.setColor(color);
				circle.setInnerColor(color2);
				int x,y;
				int radius;
				x=Integer.parseInt(txtX.getText());
				y=Integer.parseInt(txtY.getText());
				radius=Integer.parseInt(txtRadius.getText());
				Point p= new Point(x,y);
		
				circle.setColor(color);
				circle.setCenter(p);
				try {
					circle.setRadius(radius);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				StartWindow.getInstance().startDrawing();
				dispose();
			}
		});
		
		JPanel pnlButtons= new JPanel();
		pnlButtons.setLayout(new FlowLayout());
		pnlButtons.add(btnConfirm);
		pnlButtons.add(btnColor);
		pnlButtons.add(btnCancel);
		mainPanel.add(pnlButtons);
	}
}

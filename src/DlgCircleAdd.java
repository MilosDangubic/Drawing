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

public class DlgCircleAdd extends JDialog
{

	Color outerColor=Color.BLACK;
	Color innerColor =Color.BLACK;
	public DlgCircleAdd() 
	{
		
		setModal(true);
		setLayout(new BorderLayout());
		setBounds(150, 150, 350, 250);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		JLabel labelRadius= new JLabel("Insert radius: ");
		JTextField textRadius= new JTextField();
		JPanel mainPanel= new JPanel();
		JPanel panelButtons= new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		JPanel radiusPanel= new JPanel();
		radiusPanel.setLayout(new FlowLayout());
		textRadius.setPreferredSize(new Dimension(90,25));
		radiusPanel.add(labelRadius);
		radiusPanel.add(textRadius);
		mainPanel.add(radiusPanel);
		add(mainPanel,BorderLayout.CENTER);
		JButton buttonConfirm=new JButton("Confirm");
		buttonConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int radius;
				radius=Integer.parseInt(textRadius.getText());
				outerColor=JColorChooser.showDialog(null, "Outer color:" , Color.BLACK);
				innerColor=JColorChooser.showDialog(null, "Inner olor : ", Color.BLACK);
				Point p= new Point(StartWindow.getInstance().getMouseClicks()[1].getX(),StartWindow.getInstance().getMouseClicks()[1].getY());
				Circle r= new Circle(p, radius,true,outerColor);
				r.setInnerColor(innerColor);
				StartWindow.getInstance().getShapes().add(r);
				StartWindow.getInstance().startDrawing();
				dispose();
			}
		});
		JButton cancelButton= new JButton("Back");
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		panelButtons.setLayout(new FlowLayout());
		panelButtons.add(buttonConfirm);
		panelButtons.add(cancelButton);
		mainPanel.add(panelButtons);
		
		
}


	

	
}

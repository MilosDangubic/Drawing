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

public class DlgRectEdit extends JDialog
{
	public DlgRectEdit(Rectangle rec) 
	{
		setBounds(200, 200, 350, 250);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setLayout(new BorderLayout());
		rectangle=rec;
		Dimension dim= new Dimension(100,30);
		lblX= new JLabel("X: ");
		lblY= new JLabel("Y: ");
		txtX= new JTextField();
		txtX.setPreferredSize(dim);
		txtY= new JTextField();
		txtY.setPreferredSize(dim);
		
		lblWidth= new JLabel("Width: ");
		lblHight= new JLabel("Hight: ");



		txtWidth= new JTextField();
		txtWidth.setPreferredSize(dim);

		txtHight= new JTextField();
		txtHight.setPreferredSize(dim);
	
		JPanel mainPanel= new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		
		JPanel pnlX= new JPanel();
		JPanel pnlY= new JPanel();
		pnlX.setLayout(new FlowLayout());
		pnlY.setLayout(new FlowLayout());
		
		pnlX.add(lblX);
		pnlX.add(txtX);
		
		pnlY.add(lblY);
		pnlY.add(txtY);
		
		
		JPanel pnlWidth= new JPanel();
		JPanel pnlHight= new JPanel();
		
		pnlWidth.setLayout(new FlowLayout());
		pnlHight.setLayout(new FlowLayout());

		

		
		txtX.setText(String.valueOf(rec.getUpperLeftPoint().getX()));
		txtY.setText(String.valueOf(rec.getUpperLeftPoint().getY()));
		txtWidth.setText(String.valueOf(rec.getWidth()));
		txtHight.setText(String.valueOf(rec.getHeight()));

	
		pnlWidth.add(lblWidth);
		pnlWidth.add(txtWidth);
		pnlHight.add(lblHight);
		pnlHight.add(txtHight);
		
		mainPanel.add(pnlX);
		mainPanel.add(pnlY);
		mainPanel.add(pnlWidth);
		mainPanel.add(pnlHight);
		add(mainPanel,BorderLayout.CENTER);
		
	
		btnCancel= new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		btnConfirm=new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// TODO Auto-generated method stub
				color=JColorChooser.showDialog(null, "Choose color: ", rectangle.getColor());
				innerColor=JColorChooser.showDialog(null, "Choose color: ", rectangle.getColor());

				rectangle.setColor(color);
				rectangle.setInnerColor(innerColor);
				
				int x,y;
				int sirina,visina;
				x=Integer.parseInt(txtX.getText());
				y=Integer.parseInt(txtY.getText());
				sirina=Integer.parseInt(txtWidth.getText());
				visina=Integer.parseInt(txtHight.getText());
				Point p= new Point(x,y);
				rectangle.setWidth(sirina);
				rectangle.setHeight(visina);
				rectangle.setUpperLeftPoint(p);
				StartWindow.getInstance().startDrawing();
				dispose();
			}
		});
		
		JPanel pnlButtons= new JPanel();
		pnlButtons.setLayout(new FlowLayout());
		pnlButtons.add(btnConfirm);
		pnlButtons.add(btnCancel);
		mainPanel.add(pnlButtons);
}


	
	private JLabel lblX;
	private JLabel lblY;
	private JTextField txtX;
	private JTextField txtY;
	private JLabel lblWidth;
	private JLabel lblHight;
	private JTextField txtWidth;
	private JTextField txtHight;
	private JButton btnConfirm;
	private JButton btnCancel;
	private Rectangle rectangle;
	private Color innerColor;
	private Color color;
}

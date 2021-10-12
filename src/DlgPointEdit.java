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

public class DlgPointEdit extends JDialog
{

	
	public DlgPointEdit(Point point) 
	{
		setBounds(200, 200, 350, 250);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		this.point=point;
		Dimension txtDim= new Dimension(100,30);
		lblX= new JLabel("X: ");
		lblY= new JLabel("Y: ");
		txtX= new JTextField();
		txtX.setPreferredSize(txtDim);
		txtY= new JTextField();
		txtY.setPreferredSize(txtDim);
		
		
		
		setLayout(new BorderLayout());
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
		
		txtX.setText(String.valueOf(point.getX()));
		txtY.setText(String.valueOf(point.getY()));
		
	
		mainPanel.add(pnlX);
		mainPanel.add(pnlY);
	
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
				color=JColorChooser.showDialog(null, "Choose color: ", point.getColor());
				point.setColor(color);
				int x,y;
				x=Integer.parseInt(txtX.getText());
				y=Integer.parseInt(txtY.getText());
			
				point.setX(x);
				point.setY(y);
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




	public JButton getbtnConfirm() {
		return btnConfirm;
	}

	public void setbtnConfirm(JButton btnConfirm) {
		this.btnConfirm = btnConfirm;
	}

	public JButton getbtnCancel() {
		return btnCancel;
	}

	public void setbtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}
	private JTextField txtX;
	private JTextField txtY;	
	private JButton btnConfirm;
	private JButton btnCancel;
	private JLabel lblX;
	private JLabel lblY;
	private Point point;
	private Color color;

}

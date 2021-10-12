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

public class DlgLineEdit extends JDialog
{

	
	public DlgLineEdit(Line line) 
	{
		Dimension dim= new Dimension(100,30);
		setBounds(200, 200, 300, 250);
		this.line=line;
		lblYE= new JLabel("Y 1: ");
		lblXE=new JLabel("X 1: ");
		lblXS= new JLabel("X 0: ");
		lblYS= new JLabel("Y 0 ");
		txtXS= new JTextField();
		txtXS.setPreferredSize(dim);
		txtYS= new JTextField();
		txtYS.setPreferredSize(dim);
		txtXE= new JTextField();
		txtXE.setPreferredSize(dim);
		txtYE= new JTextField();
		txtYE.setPreferredSize(dim);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setLayout(new BorderLayout());
		JPanel mainPanel= new JPanel();
		JPanel pnlX= new JPanel();
		JPanel pnlY= new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		
		pnlX.setLayout(new FlowLayout());
		pnlY.setLayout(new FlowLayout());
		
		pnlX.add(lblXS);
		pnlX.add(txtXS);
		
		pnlY.add(lblYS);
		pnlY.add(txtYS);
		
		
		JPanel pnl1= new JPanel();
		JPanel pnl2= new JPanel();
		
		pnl1.setLayout(new FlowLayout());
		pnl2.setLayout(new FlowLayout());

		

	
		pnl1.add(lblXE);
		pnl1.add(txtXE);
		pnl2.add(lblYE);
		pnl2.add(txtYE);
		
		mainPanel.add(pnlX);
		mainPanel.add(pnlY);
		mainPanel.add(pnl1);
		mainPanel.add(pnl2);
		add(mainPanel,BorderLayout.CENTER);
		
		txtXS.setText(String.valueOf(line.getStartPoint().getX()));
		txtYS.setText(String.valueOf(line.getStartPoint().getY()));
		
		txtXE.setText(String.valueOf(line.getEndPoint().getX()));
		txtYE.setText(String.valueOf(line.getEndPoint().getY()));


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

				color=JColorChooser.showDialog(null, "Choose color: ", line.getColor());
				line.setColor(color);
				int xs,ys,xe,ye;
				xs=Integer.parseInt(txtXS.getText());
				ys=Integer.parseInt(txtYS.getText());
				xe=Integer.parseInt(txtXE.getText());
				ye=Integer.parseInt(txtYE.getText());
				
				Point ps= new Point(xs,ys);
				Point pe= new Point(xe,ye);
				line.setStartPoint(ps);
				line.setEndPoint(pe);
				line.setColor(color);
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


	

	private JLabel lblXS;
	private JLabel lblYS;
	private JLabel lblXE;
	private JLabel lblYE;
	private JTextField txtXS;
	private JTextField txtYS;
	private JTextField txtXE;
	private JTextField txtYE;
	private JButton btnConfirm;
	private JButton btnCancel;
	private Line line;
	private Color color;

}

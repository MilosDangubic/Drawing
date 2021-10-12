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

public class DlgDonutEdit extends JDialog
{

	private Donut donut;
	public DlgDonutEdit(Donut donut) 
	{
		setBounds(200,200, 350, 250);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		btnColor= new JButton("Color");
		this.donut=donut;
		Dimension dim= new Dimension(90,25);
		lblX= new JLabel("X: ");
		lblY= new JLabel("Y: ");
		txtX= new JTextField();
		txtX.setPreferredSize(dim);
		txtY= new JTextField();
		txtY.setPreferredSize(dim);
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
		JPanel pnlInner= new JPanel();
		JPanel pnlOuter= new JPanel();
		pnlInner.setLayout(new FlowLayout());
		pnlOuter.setLayout(new FlowLayout());
		
		txtInnerRadius= new JTextField();
		txtInnerRadius.setPreferredSize(dim);		
		txtOuterRadius= new JTextField();
		txtOuterRadius.setPreferredSize(dim);
		lblInnerRadius= new JLabel("Inner radius: ");
		lblOuterRadius= new JLabel("Outer radius: : ");
		txtX.setText(String.valueOf(donut.getCenter().getX()));
		txtY.setText(String.valueOf(donut.getCenter().getY()));
		txtInnerRadius.setText(String.valueOf(donut.getInnerRadius()));
		txtOuterRadius.setText(String.valueOf(donut.getRadius()));

	
		pnlInner.add(lblInnerRadius);
		pnlInner.add(txtInnerRadius);
		pnlOuter.add(lblOuterRadius);
		pnlOuter.add(txtOuterRadius);
		
		mainPanel.add(pnlX);
		mainPanel.add(pnlY);
		mainPanel.add(pnlInner);
		mainPanel.add(pnlOuter);
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
				innerC=JColorChooser.showDialog(null, "Choose inner color: ", donut.getColor());
				donut.setInnerColor(innerC);
				
				outerC=JColorChooser.showDialog(null, "Choose outer color: ", donut.getColor());
				donut.setColor(outerC);
				int x,y;
				int inner,outer;
				x=Integer.parseInt(txtX.getText());
				y=Integer.parseInt(txtY.getText());
				inner=Integer.parseInt(txtInnerRadius.getText());
				outer=Integer.parseInt(txtOuterRadius.getText());
				Point p= new Point(x,y);
				donut.setCenter(p);
				
				donut.setInnerRadius(inner);
				try {
					donut.setRadius(outer);
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
		pnlButtons.add(btnCancel);
		mainPanel.add(pnlButtons);
}

	private JLabel lblX;
	private JLabel lblY;
	private JTextField txtX;
	private JTextField txtY;
	private JLabel lblInnerRadius;
	private JLabel lblOuterRadius;
	private JTextField txtInnerRadius;
	private JTextField txtOuterRadius;
	private JButton btnConfirm;
	private JButton btnCancel;
	private JButton btnColor;
	private Color innerC;
	private Color outerC;

}

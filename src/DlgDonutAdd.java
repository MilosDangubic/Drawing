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

public class DlgDonutAdd extends JDialog
{


	Color innerCollor=Color.BLACK;
	Color outerCollor=Color.BLACK;
	
	
	public DlgDonutAdd() 
	{
		setModal(true);
		setLayout(new BorderLayout());
		Dimension dim= new Dimension(100,30);
		setBounds(200, 200, 350, 250);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		JPanel mainPanel= new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		JPanel pnlInner= new JPanel();
		JPanel pnl2= new JPanel();
		pnlInner.setLayout(new FlowLayout());
		pnl2.setLayout(new FlowLayout());
		JLabel lblOuterRadius= new JLabel("Outer radius: ");
		JLabel lblInnerRadius= new JLabel("Inner radius: ");


		JTextField txtInnerRadius= new JTextField();
		 txtInnerRadius.setPreferredSize(dim);
		JTextField txtOuterRadius= new JTextField();
		txtOuterRadius.setPreferredSize(dim);
		pnlInner.add(lblOuterRadius);
		pnlInner.add(txtOuterRadius);
		
		pnl2.add(lblInnerRadius);
		pnl2.add(txtInnerRadius);
		
		mainPanel.add(pnl2);
		mainPanel.add(pnlInner);
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
				innerCollor=JColorChooser.showDialog(null, "Choose inner color: ", Color.GREEN);
				outerCollor=JColorChooser.showDialog(null, "Choose outer color: ", Color.GREEN);
				int inner;
				int outer;
				outer=Integer.parseInt(txtOuterRadius.getText());
				inner=Integer.parseInt(txtInnerRadius.getText());
				Point p= new Point(StartWindow.getInstance().getMouseClicks()[1].getX(),StartWindow.getInstance().getMouseClicks()[1].getY());
				Donut d= new Donut(p, outer, inner,false,outerCollor,innerCollor);
				StartWindow.getInstance().getShapes().add(d);
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



}

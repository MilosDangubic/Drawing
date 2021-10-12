import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DlgDelete extends JDialog
{



	public DlgDelete() 
	{
		Dimension dim= new Dimension(100,30);
		setBounds(200, 200, 350, 250);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setLayout(new BorderLayout());
		JPanel mainPanel= new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		JPanel pnlMessage= new JPanel();
		pnlMessage.setLayout(new FlowLayout());	
		JLabel lblMessage= new JLabel("Do you want to delete Shape?");
		pnlMessage.add(lblMessage);		
		mainPanel.add(pnlMessage);
		add(mainPanel,BorderLayout.CENTER);
		
		JButton btnConfirm=new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<StartWindow.getInstance().getShapes().size(); i++)
				{
					Shape s= StartWindow.getInstance().getShapes().get(i);
					if (s.contains(StartWindow.getInstance().getMouseClicks()[1].getX(), StartWindow.getInstance().getMouseClicks()[1].getY())) 
					{	
						StartWindow.getInstance().getShapes().remove(i);
						break;
					}
				}
				StartWindow.getInstance().startDrawing();
				dispose();
			
			}
		});
		
		JButton btnCancel= new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
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

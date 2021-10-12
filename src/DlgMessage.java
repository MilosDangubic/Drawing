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

public class DlgMessage extends JDialog
{
	public DlgMessage() 
	{
		setModal(true);
		setLocationRelativeTo(null);

		setBounds(500, 500, 100, 100);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		JLabel labelMessage= new JLabel("Please select shape first");
		JPanel pnlMain= new JPanel();
		pnlMain.setLayout(new BoxLayout(pnlMain,BoxLayout.Y_AXIS));
		pnlMain.add(labelMessage);
		
		add(pnlMain,BorderLayout.CENTER);
		
		JButton buttonOk=new JButton("Ok");
		buttonOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			
			}
		});
		
		pnlMain.add(buttonOk);
}


	




}

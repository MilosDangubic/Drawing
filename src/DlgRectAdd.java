import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DlgRectAdd extends JDialog
{


	
	
	public DlgRectAdd() 
	{
		
		color=Color.BLACK;
		Dimension txtDim= new Dimension(100,30);
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setLayout(new BorderLayout());
		JPanel mainPanel= new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		
		JPanel pnlWidth= new JPanel();
		JPanel pnlHight= new JPanel();
		
		pnlWidth.setLayout(new FlowLayout());
		pnlHight.setLayout(new FlowLayout());

		lblWidth= new JLabel("Width: ");
		lblHight= new JLabel("Hight: ");



		txtWidth= new JTextField();
		txtWidth.setPreferredSize(txtDim);

		txtHight= new JTextField();
		txtHight.setPreferredSize(txtDim);

	
		pnlWidth.add(lblWidth);
		pnlWidth.add(txtWidth);
		pnlHight.add(lblHight);
		pnlHight.add(txtHight);
		
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
				// TODO Auto-generated method stub\
				color=JColorChooser.showDialog(null, "Choose outer color: ", Color.GREEN);
				innerCollor=JColorChooser.showDialog(null, "Choose inner color: ", Color.GREEN);
				
				int width,hight;
				
				width=Integer.parseInt(txtWidth.getText());
				hight=Integer.parseInt(txtHight.getText());
				Point p= new Point(StartWindow.getInstance().getMouseClicks()[1].getX(),StartWindow.getInstance().getMouseClicks()[1].getY());
				Rectangle r= new Rectangle(p, width, hight,false,color);
				r.setInnerColor(innerCollor);
				StartWindow.getInstance().getShapes().add(r);
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


	public JLabel getlblWidth() {
		return lblWidth;
	}

	public void setlblWidth(JLabel lblWidth) {
		this.lblWidth = lblWidth;
	}

	public JLabel getlblHight() {
		return lblHight;
	}

	public void setlblHight(JLabel lblHight) {
		this.lblHight = lblHight;
	}


	public JTextField gettxtWidth() {
		return txtWidth;
	}

	public void settxtWidth(JTextField txtWidth) {
		this.txtWidth = txtWidth;
	}

	public JTextField gettxtHight() {
		return txtHight;
	}

	public void settxtHight(JTextField txtHight) {
		this.txtHight = txtHight;
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

	private JLabel lblWidth;
	private JLabel lblHight;
	private JTextField txtWidth;
	private JTextField txtHight;
	private JButton btnConfirm;
	private JButton btnCancel;
	private Color color;
	private Color innerCollor;
}

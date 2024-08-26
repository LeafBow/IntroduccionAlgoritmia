package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class FrmClientes extends JInternalFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmClientes frame = new FrmClientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmClientes() {
		setBounds(100, 100, 378, 260);
		getContentPane().setLayout(null);
		{
			lblNewLabel = new JLabel("New label");
			lblNewLabel.setBounds(137, 47, 46, 14);
			getContentPane().add(lblNewLabel);
		}
		{
			btnNewButton = new JButton("New button");
			btnNewButton.setBounds(121, 103, 89, 23);
			btnNewButton.addActionListener(this);
			getContentPane().add(btnNewButton);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnNewButton)
		{
			dispose();
		}
		
	}
}

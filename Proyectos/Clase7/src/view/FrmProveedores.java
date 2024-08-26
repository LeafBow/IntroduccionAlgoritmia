package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class FrmProveedores extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmProveedores frame = new FrmProveedores();
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
	public FrmProveedores() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		{
			lblNewLabel = new JLabel("New label");
			lblNewLabel.setBounds(196, 45, 46, 14);
			getContentPane().add(lblNewLabel);
		}

	}

}

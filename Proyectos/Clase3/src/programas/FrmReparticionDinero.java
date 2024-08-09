package programas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class FrmReparticionDinero extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtDinero;
	private JButton btnNewButton;
	private JTextArea txtSalida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReparticionDinero frame = new FrmReparticionDinero();
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
	public FrmReparticionDinero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Dinero a repartir");
			lblNewLabel.setBounds(10, 29, 102, 14);
			contentPane.add(lblNewLabel);
		}
		{
			txtDinero = new JTextField();
			txtDinero.setBounds(122, 26, 86, 20);
			contentPane.add(txtDinero);
			txtDinero.setColumns(10);
		}
		{
			btnNewButton = new JButton("Repartir");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnNewButtonActionPerformed(e);
				}
			});
			btnNewButton.setBounds(296, 25, 89, 23);
			contentPane.add(btnNewButton);
		}
		{
			txtSalida = new JTextArea();
			txtSalida.setBounds(10, 98, 375, 128);
			contentPane.add(txtSalida);
		}
	}

	protected void btnNewButtonActionPerformed(ActionEvent e) {
		double dineroTotal, dTamar,dJosue,dCaleb,dDaniel,dDavid;
		dineroTotal = Double.parseDouble(txtDinero.getText());
		dJosue =dineroTotal*0.27;
		dTamar = dJosue*0.85;
		dDaniel = dineroTotal*0.25;
		dCaleb = (dJosue+dDaniel)*0.23;
		dDavid = dineroTotal-(dJosue+dTamar+dDaniel+dCaleb);
		
		DecimalFormat fm = new DecimalFormat("#,##0.00");
		txtSalida.setText("Dinero Tamar: 	"+fm.format(dTamar));
		txtSalida.append("\nDinero Josue: 	"+fm.format(dJosue));
		txtSalida.append("\nDinero Caleb: 	"+fm.format(dCaleb));
		txtSalida.append("\nDinero Daniel: 	"+fm.format(dDaniel));
		txtSalida.append("\nDinero David: 	"+fm.format(dDavid));
		
		

	}
}

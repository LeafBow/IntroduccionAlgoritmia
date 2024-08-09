package programas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class FrmRepartoInversion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnCalcular;
	private JLabel lblNewLabel;
	private JTextField txtDinero;
	private JTextArea txtSalida;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRepartoInversion frame = new FrmRepartoInversion();
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
	public FrmRepartoInversion() {
		setTitle("Reparto de Inversion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			btnCalcular = new JButton("Calcular");
			btnCalcular.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnNewButtonActionPerformed(e);
				}
			});
			btnCalcular.setBounds(48, 87, 89, 23);
			contentPane.add(btnCalcular);
		}
		{
			lblNewLabel = new JLabel("Dinero a repartir");
			lblNewLabel.setBounds(48, 35, 89, 14);
			contentPane.add(lblNewLabel);
		}
		{
			txtDinero = new JTextField();
			txtDinero.setBounds(187, 32, 86, 20);
			contentPane.add(txtDinero);
			txtDinero.setColumns(10);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(48, 150, 225, 101);
			contentPane.add(scrollPane);
			{
				txtSalida = new JTextArea();
				txtSalida.setTabSize(4);
				scrollPane.setViewportView(txtSalida);
			}
		}
	}
	protected void btnNewButtonActionPerformed(ActionEvent e) {
		double totalAmount, alquiler,publicidad,transporte,servicios,decoracion,gastosV;
		
		totalAmount = Double.parseDouble(txtDinero.getText());
		alquiler =totalAmount*0.23;
		publicidad =totalAmount*0.07;
		transporte =totalAmount*0.26;
		servicios =totalAmount*0.12;
		decoracion =totalAmount*0.21;
		gastosV =totalAmount*0.11;
		
		txtSalida.setText("Alquiler de espacio en la feria	: "+alquiler);
		txtSalida.append ("\nPublicidad		: "+publicidad);
		txtSalida.append ("\nTransporte		: "+transporte);
		txtSalida.append ("\nServicios feriales	: "+servicios);
		txtSalida.append ("\nDecoracion		: "+decoracion);
		txtSalida.append ("\nGastos varios		: "+gastosV);
	}
}

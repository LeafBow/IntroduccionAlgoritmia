package lab2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reparto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtDinero;
	private JLabel lblNewLabel_1;
	private JTextField txtEdad1;
	private JLabel lblNewLabel_2;
	private JTextField txtEdad2;
	private JLabel lblNewLabel_3;
	private JTextField txtEdad3;
	private JTextArea txtRespuesta;
	private JButton btnProcesar;
	private JButton btnBorrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reparto frame = new Reparto();
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
	public Reparto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Dinero");
			lblNewLabel.setBounds(41, 32, 46, 14);
			contentPane.add(lblNewLabel);
		}
		{
			txtDinero = new JTextField();
			txtDinero.setBounds(97, 29, 86, 20);
			contentPane.add(txtDinero);
			txtDinero.setColumns(10);
		}
		{
			lblNewLabel_1 = new JLabel("Edad 1");
			lblNewLabel_1.setBounds(41, 71, 46, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			txtEdad1 = new JTextField();
			txtEdad1.setBounds(97, 68, 86, 20);
			contentPane.add(txtEdad1);
			txtEdad1.setColumns(10);
		}
		{
			lblNewLabel_2 = new JLabel("Edad 2");
			lblNewLabel_2.setBounds(41, 111, 46, 14);
			contentPane.add(lblNewLabel_2);
		}
		{
			txtEdad2 = new JTextField();
			txtEdad2.setBounds(97, 108, 86, 20);
			contentPane.add(txtEdad2);
			txtEdad2.setColumns(10);
		}
		{
			lblNewLabel_3 = new JLabel("Edad 3");
			lblNewLabel_3.setBounds(41, 150, 46, 14);
			contentPane.add(lblNewLabel_3);
		}
		{
			txtEdad3 = new JTextField();
			txtEdad3.setBounds(97, 147, 86, 20);
			contentPane.add(txtEdad3);
			txtEdad3.setColumns(10);
		}
		{
			txtRespuesta = new JTextArea();
			txtRespuesta.setBounds(41, 193, 356, 57);
			contentPane.add(txtRespuesta);
		}
		{
			btnProcesar = new JButton("Procesar");
			btnProcesar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnProcesarActionPerformed(e);
				}
			});
			btnProcesar.setBounds(308, 28, 89, 23);
			contentPane.add(btnProcesar);
		}
		{
			btnBorrar = new JButton("Borrar");
			btnBorrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnBorrarActionPerformed(e);
				}
			});
			btnBorrar.setBounds(308, 67, 89, 23);
			contentPane.add(btnBorrar);
		}
	}

	protected void btnProcesarActionPerformed(ActionEvent e) {
		int dinero,edad1,edad2,edad3,sumEdades;
		double monto1, monto2, monto3;
		dinero = Integer.parseInt(txtDinero.getText());
		edad1 = Integer.parseInt(txtEdad1.getText());
		edad2 = Integer.parseInt(txtEdad2.getText());
		edad3 = Integer.parseInt(txtEdad3.getText());
		sumEdades = edad1+edad2+edad3;
		monto1 = ((double)edad1*dinero)/sumEdades;
		monto2 = ((double)edad2*dinero)/sumEdades;
		monto3 = ((double)edad3*dinero)/sumEdades;


		txtRespuesta.setText("El monto 1 es: "+monto1+"\n");
		txtRespuesta.append("El monto 2 es: "+monto2+"\n");
		txtRespuesta.append("El monto 3 es: "+monto3);

	}
	
	protected void btnBorrarActionPerformed(ActionEvent e) {
		txtDinero.setText("");
		txtEdad1.setText("");
		txtEdad2.setText("");
		txtEdad3.setText("");
		txtRespuesta.setText("");
		
		txtDinero.requestFocus();
	}
}

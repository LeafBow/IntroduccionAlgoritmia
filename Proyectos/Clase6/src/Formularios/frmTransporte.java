package Formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmTransporte extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JComboBox cmbDestino;
	private JLabel lblCalidad;
	private JLabel lblCantidad;
	private JComboBox cmbCalidad;
	private JSpinner spnCantidad;
	private JTextArea txtSalida;
	private JButton btnRun;
	private JButton btnClear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmTransporte frame = new frmTransporte();
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
	public frmTransporte() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Destino");
			lblNewLabel.setBounds(63, 43, 46, 14);
			contentPane.add(lblNewLabel);
		}
		{
			cmbDestino = new JComboBox();
			cmbDestino.setModel(new DefaultComboBoxModel(new String[] {"Lima-Huanuco", "Lima-Huancayo"}));
			cmbDestino.setBounds(119, 39, 99, 22);
			contentPane.add(cmbDestino);
		}
		{
			lblCalidad = new JLabel("Calidad");
			lblCalidad.setBounds(63, 68, 46, 14);
			contentPane.add(lblCalidad);
		}
		{
			lblCantidad = new JLabel("Cantidad");
			lblCantidad.setBounds(63, 93, 46, 14);
			contentPane.add(lblCantidad);
		}
		{
			cmbCalidad = new JComboBox();
			Character[] opciones = {'A', 'B', 'C'};
			cmbCalidad.setModel(new DefaultComboBoxModel(opciones));
			cmbCalidad.setBounds(119, 64, 47, 22);
			contentPane.add(cmbCalidad);
		}
		{
			spnCantidad = new JSpinner();
			spnCantidad.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
			spnCantidad.setBounds(119, 90, 30, 20);
			contentPane.add(spnCantidad);
		}
		{
			txtSalida = new JTextArea();
			txtSalida.setBounds(63, 134, 318, 95);
			contentPane.add(txtSalida);
		}
		{
			btnRun = new JButton("");
			btnRun.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnRun(e);
				}
			});
			btnRun.setIcon(new ImageIcon(frmTransporte.class.getResource("/Imgs/botonCalc.png")));
			btnRun.setBounds(335, 23, 46, 42);
			contentPane.add(btnRun);
		}
		{
			btnClear = new JButton("");
			btnClear.setIcon(new ImageIcon(frmTransporte.class.getResource("/Imgs/botonLimpiar.png")));
			btnClear.setBounds(335, 76, 46, 34);
			contentPane.add(btnClear);
		}
	}
	protected void actionPerformedBtnRun(ActionEvent e) {
		
		int vDestino,vNroBoletos,vPrecio,vImporteCompra;
		char vCalidad;
		double vDescuento,vImportePagar;
		
		vCalidad = (char) cmbCalidad.getSelectedItem();
		vDestino = cmbDestino.getSelectedIndex();
		vNroBoletos = (int)spnCantidad.getValue();
		
		switch (vCalidad) {
		case 'A':
			switch (vDestino) {
			case 0:
				vPrecio = 45;
				break;

			default:
				vPrecio =38;
				break;
			}
			
			break;
		case 'B':
			switch (vDestino) {
			case 0:
				vPrecio = 35;
				break;

			default:
				vPrecio =38;
				break;
			}
			break;
		case 'C':
			switch (vDestino) {
			case 0:
				vPrecio = 30;
				break;

			default:
				vPrecio =28;
				break;
			}
			break;
		default:
			vPrecio = 0;
			break;
		}
		vImporteCompra = vPrecio*vNroBoletos;
		
		if(vCalidad == 'A'&&vNroBoletos>4)
		{
			vDescuento = vImporteCompra *0.05;
		}
		else
		{
			vDescuento = 0;
		}
		
		vImportePagar = vImporteCompra-vDescuento;
		
		txtSalida.setText("Importe compra: "+vImporteCompra);
		txtSalida.append("\nDescuento: "+vDescuento);
		txtSalida.append("\nImporte pagar: "+vImportePagar);
		
	}
}

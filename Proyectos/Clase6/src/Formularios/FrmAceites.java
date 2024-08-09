package Formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class FrmAceites extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JComboBox cmbAceite;
	private JSpinner spnCantidad;
	private JButton btnCalcular;
	private JButton btnLimpiar;
	private JTextArea txtSalida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAceites frame = new FrmAceites();
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
	public FrmAceites() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Aceite: ");
			lblNewLabel.setBounds(47, 48, 46, 14);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Cantidad");
			lblNewLabel_1.setBounds(47, 84, 46, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			cmbAceite = new JComboBox();
			cmbAceite.setModel(new DefaultComboBoxModel(new String[] {"Aceite 1", "Aceite 2", "Aceite 3", "Aceite 4"}));
			cmbAceite.setBounds(123, 44, 72, 22);
			contentPane.add(cmbAceite);
		}
		{
			spnCantidad = new JSpinner();
			spnCantidad.setBounds(123, 81, 72, 20);
			contentPane.add(spnCantidad);
		}
		{
			btnCalcular = new JButton("Calcular");
			btnCalcular.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnCalcular(e);
				}
			});
			btnCalcular.setBounds(296, 44, 89, 23);
			contentPane.add(btnCalcular);
		}
		{
			btnLimpiar = new JButton("Limpiar");
			btnLimpiar.setBounds(296, 80, 89, 23);
			contentPane.add(btnLimpiar);
		}
		{
			txtSalida = new JTextArea();
			txtSalida.setBounds(79, 131, 214, 91);
			contentPane.add(txtSalida);
		}
	}

	protected void actionPerformedBtnCalcular(ActionEvent e) {
		int vTipoAceite, vCantidad;
		double vPrecio,vValorDescuento,vDescuento,vImporteCompra,vImportePagar;
		
		vTipoAceite = cmbAceite.getSelectedIndex();
		vCantidad = (int)spnCantidad.getValue();
		
		switch (vTipoAceite) {
		case 0:
			vPrecio = 6;
			break;
		case 1:
			vPrecio = 5.5;
			break;
		case 2:
			vPrecio = 4.5;
			break;

		default:
			vPrecio = 4.7;
			break;
		}
		vImporteCompra = vPrecio*vCantidad;
		
		if(vCantidad<4)
		{
			vDescuento = 0.05;
		}
		else if(vCantidad<7)
		{
			vDescuento =0.075;
		}
		else if(vCantidad<10)
		{
			vDescuento =0.10;
		}
		else
		{
			vDescuento =0.125;		
		}
		
		vValorDescuento = vImporteCompra*vDescuento;
		vImportePagar = vImporteCompra -vValorDescuento;
		
		txtSalida.setText("Importe compra: "+vImporteCompra);
		txtSalida.append("\nImporte descuento: "+vValorDescuento);
		txtSalida.append("\nImporte pagar: "+vImportePagar);
		
	}
}

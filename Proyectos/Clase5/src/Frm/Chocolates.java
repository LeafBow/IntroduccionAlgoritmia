package Frm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Chocolates extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblCantidad;
	private JComboBox cmbChocolate;
	private JTextArea txtSalida;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JSpinner spnCantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chocolates frame = new Chocolates();
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
	public Chocolates() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Chocolate: ");
			lblNewLabel.setBounds(44, 92, 81, 14);
			contentPane.add(lblNewLabel);
		}
		{
			lblCantidad = new JLabel("Cantidad: ");
			lblCantidad.setBounds(44, 48, 81, 14);
			contentPane.add(lblCantidad);
		}
		{
			cmbChocolate = new JComboBox();
			cmbChocolate.setModel(new DefaultComboBoxModel(new String[] {"", "Primor", "Dulzura", "Tentación", "Exlposión"}));
			cmbChocolate.setBounds(114, 88, 86, 22);
			contentPane.add(cmbChocolate);
		}
		{
			txtSalida = new JTextArea();
			txtSalida.setBounds(44, 155, 343, 78);
			contentPane.add(txtSalida);
		}
		{
			btnNewButton = new JButton("Calcular");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnNewButton(e);
				}
			});
			btnNewButton.setBounds(285, 44, 89, 23);
			contentPane.add(btnNewButton);
		}
		{
			btnNewButton_1 = new JButton("Limpiar");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnNewButton_1(e);
				}
			});
			btnNewButton_1.setBounds(285, 88, 89, 23);
			contentPane.add(btnNewButton_1);
		}
		{
			spnCantidad = new JSpinner();
			spnCantidad.setBounds(114, 45, 86, 20);
			contentPane.add(spnCantidad);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		int vTipoChocolate,vCantidad,vCaramelos;
		double vPrecio,vImporteCompra,vPorcentajeDscto,vImportePagar;
		
		vTipoChocolate = cmbChocolate.getSelectedIndex();
		vCantidad = (int) spnCantidad.getValue();
		
		if(vTipoChocolate == 0)
		{
			vPrecio =0;
		}
		else if(vTipoChocolate==1)
		{
			vPrecio =8.5;
		}
		else if(vTipoChocolate==2)
		{
			vPrecio =10;
		}
		else if(vTipoChocolate==3)
		{
			vPrecio =7;
		}
		else if(vTipoChocolate==4)
		{
			vPrecio =12.5;
		}
		else
		{
			vPrecio =0;
		}
		
		vImporteCompra = vCantidad*vPrecio;
		
		if(vCantidad<5)
		{
			vPorcentajeDscto = 0.04;
		}
		else if(vCantidad<10)
		{
			vPorcentajeDscto = 0.065;
		}
		else if(vCantidad<15)
		{
			vPorcentajeDscto = 0.09;
		}
		else 
		{
			vPorcentajeDscto = 0.115;
		}
		
		vImportePagar = vImporteCompra -vImporteCompra*vPorcentajeDscto;
		
		if(vImportePagar>=250)
		{
			 vCaramelos = vCantidad*3;
			
		}
		else
		{

			vCaramelos = vCantidad*2;
		}
		
		txtSalida.setText("Importe compra: "+vImporteCompra);
		txtSalida.append("\nDescuento: "+vImporteCompra*vPorcentajeDscto);
		txtSalida.append("\nImporte pagar: "+vImportePagar);
		txtSalida.append("\nCaramelos de regalo: "+vCaramelos);
		
		
		
	}
	protected void actionPerformedBtnNewButton_1(ActionEvent e) {
		txtSalida.setText("");
		cmbChocolate.setSelectedIndex(0);
		spnCantidad.setValue(0);
		spnCantidad.requestFocus();
	}
}

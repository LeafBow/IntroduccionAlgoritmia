package Formularios;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;

public class FrmTienda extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblCantidad;
	private JComboBox cmbProducto;
	private JTextField txtCantidad;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JTextArea txtSalida;
	
	double vPrecio;
	int vCantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTienda frame = new FrmTienda();
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
	public FrmTienda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Producto");
			lblNewLabel.setBounds(34, 39, 46, 14);
			contentPane.add(lblNewLabel);
		}
		{
			lblCantidad = new JLabel("Cantidad");
			lblCantidad.setBounds(34, 71, 46, 14);
			contentPane.add(lblCantidad);
		}
		{
			cmbProducto = new JComboBox();
			cmbProducto.setModel(new DefaultComboBoxModel(new String[] {"P0", "P1", "P2"}));
			cmbProducto.setBounds(110, 35, 86, 22);
			contentPane.add(cmbProducto);
		}
		{
			txtCantidad = new JTextField();
			txtCantidad.setBounds(110, 68, 86, 20);
			contentPane.add(txtCantidad);
			txtCantidad.setColumns(10);
		}
		{
			btnProcesar = new JButton("Procesar");
			btnProcesar.setBounds(316, 35, 89, 23);
			btnProcesar.addActionListener(this);
			contentPane.add(btnProcesar);
		}
		{
			btnBorrar = new JButton("Borrar");
			btnBorrar.setBounds(316, 67, 89, 23);
			btnBorrar.addActionListener(this);
			contentPane.add(btnBorrar);
		}
		{
			txtSalida = new JTextArea();
			txtSalida.setBounds(34, 124, 371, 109);
			contentPane.add(txtSalida);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==btnProcesar)
		{
			leerVariables();
			
			
			
			txtSalida.setText("Importe inicial: "+calcularImporte());
			txtSalida.append("\nDescuento: "+calcularImporteDescuento());
			txtSalida.append("\nImporte de pago: "+calcularImportePago());
			
		}
		if(e.getSource() == btnBorrar)
		{
			borrar();
		}
		
	}
	
	public void leerVariables()
	{
		int vProducto = cmbProducto.getSelectedIndex();
		vCantidad = Integer.parseInt(txtCantidad.getText());
		
		
		
		
		switch (vProducto) {
		case 0:
			vPrecio = 15;
			break;
		case 1:
			vPrecio = 17.5;
			break;
		case 2:
			vPrecio = 20;
			break;

		}
	}
	public double calcularImporte()
	{
		
		return vCantidad*vPrecio;
	}
	public double calcularImporteDescuento()
	{
		double vDescuento;
		if(vCantidad>10)
			vDescuento = 0.15;
		else
			vDescuento = 0.07;
		return calcularImporte()*vDescuento;
	}
	public double calcularImportePago()
	{
		return calcularImporte()-calcularImporteDescuento();
	}
	
	
	public void borrar()
	{
		txtSalida.setText("");
		txtCantidad.setText("");
		txtCantidad.requestFocus();
	}
	
}

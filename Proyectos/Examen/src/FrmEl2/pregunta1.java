package FrmEl2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;
import java.awt.Color;

public class pregunta1 extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JComboBox cmbProducto;
	private JLabel lblCantidad;
	private JSpinner spnCantidad;
	private JButton btnCalcular;
	private JButton btnLimpiar;
	private JTextArea txtSalida;
	
	
	//Variables
	
	int gvCantidad,gvProducto;
	String gvRegalo, gvObsequio;
	String gvNombreProducto;
	double gvImporte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pregunta1 frame = new pregunta1();
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
	public pregunta1() {
		setTitle("INTCOMEX Store");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Producto");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(22, 34, 71, 14);
			contentPane.add(lblNewLabel);
		}
		{
			cmbProducto = new JComboBox();
			cmbProducto.setModel(new DefaultComboBoxModel(new String[] {"", "Iphone 11", "Iphone 14", "Iphone 15", "Iphone 15 Prox Max"}));
			cmbProducto.setBounds(120, 30, 98, 22);
			contentPane.add(cmbProducto);
		}
		{
			lblCantidad = new JLabel("Cantidad");
			lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCantidad.setBounds(22, 73, 71, 14);
			contentPane.add(lblCantidad);
		}
		{
			spnCantidad = new JSpinner();
			spnCantidad.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(0), null, Integer.valueOf(1)));
			spnCantidad.setBounds(164, 63, 54, 20);
			contentPane.add(spnCantidad);
		}
		{
			btnCalcular = new JButton("Calcular");
			btnCalcular.setBounds(321, 30, 89, 23);
			btnCalcular.addActionListener(this);
			contentPane.add(btnCalcular);
		}
		{
			btnLimpiar = new JButton("Limpiar");
			btnLimpiar.setBounds(321, 71, 89, 23);
			btnLimpiar.addActionListener(this);
			contentPane.add(btnLimpiar);
		}
		{
			txtSalida = new JTextArea();
			txtSalida.setBackground(new Color(191, 213, 172));
			txtSalida.setBounds(46, 117, 354, 133);
			contentPane.add(txtSalida);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnCalcular)
		{
			obtenerDatos();
			if(gvProducto>=1&&gvCantidad>0) {
			gvImporte = calcularDatos();
			definirRegalos();
			imprimirSalida();
			}
			else {
				txtSalida.setText("Error! Ingrese un producto valido o una cantidad mayor a 0");
			}
			
			
		}
		if(e.getSource()==btnLimpiar)
		{
			limpiarfrm();
		}
		
	}
	
	private void obtenerDatos()
	{
		gvProducto = cmbProducto.getSelectedIndex();
		gvNombreProducto = cmbProducto.getSelectedItem().toString();
		gvCantidad=(int) spnCantidad.getValue() ;
	
		
	}
	private double calcularDatos()
	{
		double importe;
		
		switch (gvProducto) {
		case 1:
			importe = gvCantidad*1500.00;
			break;
		case 2:
			importe = gvCantidad*2299.00;
			break;
		case 3:
			importe = gvCantidad*3490.00;
			break;
		case 4:
			importe = gvCantidad*4500.00;
			break;

		default:
			importe = 0;
			break;
		}
		return importe;
	}
	
	private void definirRegalos()
	{
		if(gvCantidad<5)
		{
			gvRegalo= (int)gvCantidad+(((int)gvCantidad>1)?" mouses":" mouse");
		}
		else if(gvCantidad<=10)
		{
			gvRegalo= (int)gvCantidad/5+(((int)gvCantidad/5>1)?" impresoras":" impresora");
		}
		else if(gvCantidad<20)
		{
			gvRegalo = "1 vale de 500 soles";
		}
		else
		{
			gvRegalo = "1 viaje	Lima-Colombia-Lima";
		}
		
		
		if(gvImporte<=15000)
		{
			gvObsequio=(int)gvCantidad/2+(((int)gvCantidad/2>1)?" mochilas":" mochila");
		}
		else
		{
			gvObsequio=(int)gvCantidad+" mochilas";
		}
		
	}
	private void espacio()
	{
		txtSalida.append("\n--------------------------------------------");
	}
	private void imprimirSalida()
	{
		DecimalFormat fm = new DecimalFormat("#,##0.00");
		txtSalida.setText("Detalles de la compra:\n");
		txtSalida.append("\nProducto: "+gvNombreProducto);
		txtSalida.append("\nCantidad elegida: "+gvCantidad);
		espacio();
		txtSalida.append("\nImporte de compra: "+fm.format(gvImporte));
		txtSalida.append("\nRegalo: "+gvRegalo);
		txtSalida.append("\nMochilas de regalo: "+gvObsequio);

	}
	private void limpiarfrm() {
		txtSalida.setText("");
		cmbProducto.setSelectedIndex(0);
		spnCantidad.setValue(0);
		
	}
}

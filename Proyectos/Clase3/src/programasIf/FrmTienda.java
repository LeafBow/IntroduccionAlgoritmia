package programasIf;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class FrmTienda extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JButton btnResultado;
	private JButton btnLimpiar;
	private JTextArea txtSalida;

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
			lblNewLabel = new JLabel("Precio");
			lblNewLabel.setBounds(60, 39, 80, 14);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Cantidad");
			lblNewLabel_1.setBounds(60, 64, 80, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			txtPrecio = new JTextField();
			txtPrecio.setBounds(169, 36, 86, 20);
			contentPane.add(txtPrecio);
			txtPrecio.setColumns(10);
		}
		{
			txtCantidad = new JTextField();
			txtCantidad.setColumns(10);
			txtCantidad.setBounds(169, 61, 86, 20);
			contentPane.add(txtCantidad);
		}
		{
			btnResultado = new JButton("Procesar");
			btnResultado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnResultadoActionPerformed(e);
				}
			});
			btnResultado.setBounds(301, 35, 89, 23);
			contentPane.add(btnResultado);
		}
		{
			btnLimpiar = new JButton("Borrar");
			btnLimpiar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnLimpiarActionPerformed(e);
				}
			});
			btnLimpiar.setBounds(301, 60, 89, 23);
			contentPane.add(btnLimpiar);
		}
		{
			txtSalida = new JTextArea();
			txtSalida.setBounds(60, 106, 329, 107);
			contentPane.add(txtSalida);
		}
	}

	protected void btnResultadoActionPerformed(ActionEvent e) {
		int vCantidad,vCaramelos;
		double vPrecio,vDescuento=0,vPago,vVentaTotal;
		vPrecio = Double.parseDouble(txtPrecio.getText());
		vCantidad = Integer.parseInt(txtCantidad.getText());
		vVentaTotal = vPrecio*vCantidad;
		if(vCantidad>0&&vCantidad<=5)
		{
			vDescuento = 0.10*vVentaTotal;
			
		}
		if(vCantidad>6&&vCantidad<=10)
		{
			vDescuento = 0.11*vVentaTotal;
			
		}
		if(vCantidad>10)
		{
			vDescuento = 0.20*vVentaTotal;
			
		}
	vCaramelos = vCantidad*2;
	vPago = vVentaTotal-vDescuento;
	
	txtSalida.setText("Importe de compra	:"+vVentaTotal);
	txtSalida.append("\nImporte de descuento	:"+vDescuento);
	txtSalida.append("\nImporte pagar	:"+vPago);
	txtSalida.append("\nCaramelos	:"+vCaramelos);
	
	
		
	}
	protected void btnLimpiarActionPerformed(ActionEvent e) {
		txtPrecio.setText("");
		txtCantidad.setText("");
		
		
		txtPrecio.requestFocus();
	}
}

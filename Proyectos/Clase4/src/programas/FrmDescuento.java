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
import java.awt.event.ActionEvent;
import java.awt.Font;

public class FrmDescuento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtPrecio;
	private JLabel lblNewLabel_1;
	private JTextField txtCantidad;
	private JButton btnCalcular;
	private JButton btnBorrar;
	private JTextArea txtSalida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDescuento frame = new FrmDescuento();
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
	public FrmDescuento() {
		setTitle("Mi Tiendita");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Precio:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(10, 29, 46, 14);
			contentPane.add(lblNewLabel);
		}
		{
			txtPrecio = new JTextField();
			txtPrecio.setBounds(86, 28, 86, 20);
			contentPane.add(txtPrecio);
			txtPrecio.setColumns(10);
		}
		{
			lblNewLabel_1 = new JLabel("Cantidad:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(10, 64, 66, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			txtCantidad = new JTextField();
			txtCantidad.setBounds(86, 57, 86, 20);
			contentPane.add(txtCantidad);
			txtCantidad.setColumns(10);
		}
		{
			btnCalcular = new JButton("Calcular");
			btnCalcular.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnCalcularActionPerformed(e);
				}
			});
			btnCalcular.setBounds(302, 25, 89, 23);
			contentPane.add(btnCalcular);
		}
		{
			btnBorrar = new JButton("Borrar");
			btnBorrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnBorrar(e);
				}
			});
			btnBorrar.setBounds(302, 60, 89, 23);
			contentPane.add(btnBorrar);
		}
		{
			txtSalida = new JTextArea();
			txtSalida.setBounds(67, 129, 324, 104);
			contentPane.add(txtSalida);
		}
	}
	protected void btnCalcularActionPerformed(ActionEvent e) {
		double vPrecio= Double.parseDouble(txtPrecio.getText()), vCompra,vDescuento=0.05,vPagar;
		int vCantidad = Integer.parseInt(txtCantidad.getText());
		String vObsequio = "Cuaderno";
		vCompra = vPrecio*vCantidad;
		if(vCantidad>10)
		{
			vDescuento = 0.15;
		}
		vPagar = vCompra - vCompra*vDescuento;
		if(vCompra>200)
		{
			vObsequio = "Agenda";
		}
		
		txtSalida.setText("Importe de compra: "+vCompra);
		txtSalida.append("\nImporte de descuento: "+vDescuento*vCompra);
		txtSalida.append("\nImporte de pago: "+vPagar);
		txtSalida.append("\nObsequio: "+vObsequio);
		
		
		
		
	}
	protected void actionPerformedBtnBorrar(ActionEvent e) {
		txtSalida.setText("");
		txtPrecio.setText("");
		txtCantidad.setText("");
		txtPrecio.requestFocus();
		
	}
}

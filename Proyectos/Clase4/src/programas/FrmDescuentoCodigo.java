package programas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmDescuentoCodigo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblCantidad;
	private JComboBox txtCodigoAceite;
	private JTextField txtCantidad;
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
					FrmDescuentoCodigo frame = new FrmDescuentoCodigo();
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
	public FrmDescuentoCodigo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Codigo de Aceite:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(10, 27, 117, 14);
			contentPane.add(lblNewLabel);
		}
		{
			lblCantidad = new JLabel("Cantidad:");
			lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCantidad.setBounds(10, 63, 67, 14);
			contentPane.add(lblCantidad);
		}
		{
			txtCodigoAceite = new JComboBox();
			txtCodigoAceite.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtCodigoAceite.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3"}));
			txtCodigoAceite.setBounds(132, 25, 86, 22);
			contentPane.add(txtCodigoAceite);
		}
		{
			txtCantidad = new JTextField();
			txtCantidad.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					keyTypedTxtCantidad(e);
				}
			});
			txtCantidad.setBounds(132, 62, 86, 20);
			contentPane.add(txtCantidad);
			txtCantidad.setColumns(10);
		}
		{
			btnCalcular = new JButton("Calcular");
			btnCalcular.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnCalcular(e);
				}
			});
			btnCalcular.setBounds(254, 25, 89, 23);
			contentPane.add(btnCalcular);
		}
		{
			btnLimpiar = new JButton("Limpiar");
			btnLimpiar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnLimpiar(e);
				}
			});
			btnLimpiar.setBounds(254, 61, 89, 23);
			contentPane.add(btnLimpiar);
		}
		{
			txtSalida = new JTextArea();
			txtSalida.setBounds(88, 131, 255, 94);
			contentPane.add(txtSalida);
		}
	}
	protected void actionPerformedBtnCalcular(ActionEvent e) {
		int vCodigoAceite,vCantidad;
		double vCompra=0,vDescuento=0,vPago,vPrecio=0;
		vCodigoAceite = txtCodigoAceite.getItemCount();
		vCantidad = Integer.parseInt(txtCantidad.getText());
		

		if(vCodigoAceite==0)
			vPrecio = 6;
		else if(vCodigoAceite==1)
			vPrecio = 5.5;
		else if(vCodigoAceite==2)
			vPrecio = 4.5;
		else
			vPrecio = 4.7;
			
		if(vCantidad>0)
		{
			vCompra = vPrecio*vCantidad;
			
			if(vCantidad<4)
				vDescuento = 0.05;
			else
				if(vCantidad<7)
					vDescuento = 0.075;
				else
					if(vCantidad<10)
						vDescuento = 0.1;
					else
						vDescuento = 0.125;
			
			vPago = vPrecio - vPrecio*vDescuento;
			
			DecimalFormat fm = new DecimalFormat("#,##0.00");
			txtSalida.setText("Importe compra: S/."+vCompra+"\n");
			txtSalida.append("Descuento: S/."+fm.format(vPrecio*vDescuento)+" ("+fm.format(vDescuento*100)+"%)\n");
			txtSalida.append("Importe pagar: S/."+fm.format(vPago));
			
		}
		else
		{
			txtSalida.setText("Error!");
		 	JOptionPane.showMessageDialog(contentPane, "La cantida ingresada debe ser mayor a 0!", "ErrorDeCantidad", JOptionPane.ERROR_MESSAGE);	
		}
		
			
		
		}
	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		txtCantidad.setText("");
		txtCodigoAceite.setSelectedIndex(0);
		txtSalida.setText("");
		txtCodigoAceite.requestFocus();
		
	}
	protected void keyTypedTxtCantidad(KeyEvent e) {
		char caracter = e.getKeyChar();
		if(caracter<'0'||caracter>'9')
		{
			//Ignorar el evento del teclado
			e.consume();
		}
		
	}
}

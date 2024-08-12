package frm;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class FrmVentasVinos extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtCantidad;
	private JComboBox cmbTipoVino;
	private JButton btnVender;
	private JButton btnCancelar;
	private JTextArea txtSalida;
	
	
	private String vgNombre;
	private int vgProducto;
	private double vgPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmVentasVinos frame = new FrmVentasVinos();
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
	public FrmVentasVinos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Modelo de vino");
			lblNewLabel.setBounds(26, 37, 76, 14);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Cantidad");
			lblNewLabel_1.setBounds(26, 61, 46, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			txtCantidad = new JTextField();
			txtCantidad.setBounds(146, 58, 86, 20);
			contentPane.add(txtCantidad);
			txtCantidad.setColumns(10);
		}
		{
			cmbTipoVino = new JComboBox();
			cmbTipoVino.setModel(new DefaultComboBoxModel(new String[] {"Tabernero Rose", "Tabernero Tinto", "Tabernero Borgoña"}));
			cmbTipoVino.setBounds(122, 33, 110, 22);
			contentPane.add(cmbTipoVino);
		}
		{
			btnVender = new JButton("Comprar");
			btnVender.setBounds(321, 33, 89, 23);
			btnVender.addActionListener(this);
			contentPane.add(btnVender);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(321, 67, 89, 23);
			btnCancelar.addActionListener(this);
			contentPane.add(btnCancelar);
		}
		{
			txtSalida = new JTextArea();
			txtSalida.setBounds(26, 89, 282, 161);
			contentPane.add(txtSalida);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnVender)
		{
			leerProducto();
			//leerCantidad();
			//calcularImportePagar();
			//efectuarIncremento();
			//mostrarResultados();
		}
		if(e.getSource()==btnCancelar)
		{
			//Limpiar();
		}
		
	}
	
	
	public void leerProducto()
	{
		vgNombre = (String) cmbTipoVino.getItemAt(cmbTipoVino.getSelectedIndex());
		vgProducto = cmbTipoVino.getSelectedIndex();
		switch (vgProducto) {
		case 0:
			vgPrecio = 15.0;
			break;
		case 1:
			vgPrecio = 17.5;
			break;
		case 2:
			vgPrecio = 20.0;
		default:
			vgPrecio = 0;
			break;
		}
	}


}

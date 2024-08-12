package Formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class OperacionesMatematicas extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNmero;
	private JTextField txtNumero1;
	private JTextField txtNumero2;
	private JButton btnSumar;
	private JButton btnRestar;
	private JButton btnMultiplicar;
	private JButton btnDividir;
	private JButton btnClear;
	private JTextArea txtSalida;
	
	int vNumero1,vNumero2;
	double vResultado;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperacionesMatematicas frame = new OperacionesMatematicas();
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
	public OperacionesMatematicas() {
		setTitle("Operaciones Aritméticas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Número 1");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(33, 34, 69, 14);
			contentPane.add(lblNewLabel);
		}
		{
			lblNmero = new JLabel("Número 2");
			lblNmero.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNmero.setBounds(212, 34, 69, 14);
			contentPane.add(lblNmero);
		}
		{
			txtNumero1 = new JTextField();
			txtNumero1.setBounds(112, 33, 86, 20);
			contentPane.add(txtNumero1);
			txtNumero1.setColumns(10);
		}
		{
			txtNumero2 = new JTextField();
			txtNumero2.setColumns(10);
			txtNumero2.setBounds(304, 33, 86, 20);
			contentPane.add(txtNumero2);
		}
		{
			btnSumar = new JButton("Sumar");
			btnSumar.setBounds(10, 86, 89, 23);
			btnSumar.addActionListener(this);
			contentPane.add(btnSumar);
		}
		{
			btnRestar = new JButton("Restar");
			btnRestar.setBounds(109, 86, 89, 23);
			btnRestar.addActionListener(this);
			contentPane.add(btnRestar);
		}
		{
			btnMultiplicar = new JButton("Multiplicar");
			btnMultiplicar.setBounds(225, 86, 89, 23);
			btnMultiplicar.addActionListener(this);
			contentPane.add(btnMultiplicar);
		}
		{
			btnDividir = new JButton("Dividir");
			btnDividir.setBounds(324, 86, 89, 23);
			btnDividir.addActionListener(this);
			contentPane.add(btnDividir);
		}
		{
			btnClear = new JButton("");
			btnClear.setIcon(new ImageIcon(OperacionesMatematicas.class.getResource("/Imgs/botonLimpiar.png")));
			btnClear.addActionListener(this);
			btnClear.setBounds(400, 16, 69, 55);
			contentPane.add(btnClear);
		}
		{
			txtSalida = new JTextArea();
			txtSalida.setBounds(33, 149, 358, 101);
			contentPane.add(txtSalida);
		}
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		leerVariables();
		if(e.getSource()==btnSumar)
		{
			
			operacion(e);
			imprimir(e);
		}
		if(e.getSource()==btnRestar)
		{
			
			operacion(e);
			imprimir(e);
		}
		if(e.getSource()==btnMultiplicar)
		{
			
			operacion(e);
			imprimir(e);
		}
		if(e.getSource()==btnDividir)
		{
		
			operacion(e);
			imprimir(e);
		}
		if(e.getSource()==btnClear)
		{
			limpiar();
		}
	}
	
	private void leerVariables()
	{
		vNumero1= Integer.parseInt(txtNumero1.getText());
		vNumero2= Integer.parseInt(txtNumero2.getText());
	}
	private void operacion(ActionEvent e)
	{
		
		
		if(e.getSource()==btnSumar)
		{
			vResultado = vNumero1+vNumero2;
		}
		else if(e.getSource()==btnRestar)
		{
			vResultado = vNumero1-vNumero2;
		}
		else if(e.getSource()==btnMultiplicar)
		{
			vResultado = vNumero1*vNumero2;
		}
		else if(e.getSource()==btnDividir)
		{
			try {
				vResultado =  ((double)vNumero1)/vNumero2;
				
			} 
			catch (Exception e2) {	
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error: "+e2.getMessage());
			}
		
		}
		
	}
	private void imprimir(ActionEvent e)
	{
		if(e.getSource()==btnSumar)
		{
			txtSalida.setText("La suma es: "+(int) vResultado);
		}
		else if(e.getSource()==btnRestar)
		{
			txtSalida.setText("La resta es: "+(int) vResultado);
		}
		else if(e.getSource()==btnMultiplicar)
		{
			txtSalida.setText("La multiplicacion es: "+(int) vResultado);
		}
		else if(e.getSource()==btnDividir)
		{
			txtSalida.setText("La division es: "+ vResultado);
		}
		
	}
	private void limpiar()
	{
		txtSalida.setText("");
	}
}

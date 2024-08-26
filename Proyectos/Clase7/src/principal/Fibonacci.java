package principal;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Fibonacci extends JFrame  implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnFibonacci;
	private JTextArea txtResultado;
	private JTextField txtCantidad;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fibonacci frame = new Fibonacci();
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
	public Fibonacci() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			btnFibonacci = new JButton("Fibonacci");
			btnFibonacci.setBounds(161, 45, 89, 23);
			btnFibonacci.addActionListener(this);
			contentPane.add(btnFibonacci);
		}
		{
			txtResultado = new JTextArea();
			txtResultado.setBounds(161, 90, 89, 277);
			contentPane.add(txtResultado);
		}
		{
			txtCantidad = new JTextField();
			txtCantidad.setBounds(164, 14, 86, 20);
			contentPane.add(txtCantidad);
			txtCantidad.setColumns(10);
		}
		{
			lblNewLabel = new JLabel("Cantidad Terminos");
			lblNewLabel.setBounds(39, 17, 101, 14);
			contentPane.add(lblNewLabel);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnFibonacci)
		{
			int cantidad = Integer.parseInt(txtCantidad.getText());
			imprimirFb(cantidad);
		}
	}
	private void imprimirFb(int x)
		{
			int number1 = 0;
			int number2 = 1;
			int acumulador = 0;
			
			for (int i = 0; i < x; i++) {
				
				txtResultado.append("\n"+"f("+i+") ="+acumulador);
				acumulador=number1+number2;
				number2=number1;
				number1= acumulador;
				
			}
		}
	}

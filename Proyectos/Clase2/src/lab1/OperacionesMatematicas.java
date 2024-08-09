package lab1;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class OperacionesMatematicas extends JFrame {

	private JPanel contentPane;

	//Variables
	

	private JTextField txtNumber1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtNumber2;
	private JButton btnCalc;
	private JTextArea txtRespuesta;

	
	
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
		setTitle("Operaciones Matematicas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Número 1");
			lblNewLabel.setBounds(135, 26, 46, 14);
			contentPane.add(lblNewLabel);
		}
		{
			txtNumber1 = new JTextField();
			txtNumber1.setBounds(191, 23, 86, 20);
			contentPane.add(txtNumber1);
			txtNumber1.setColumns(10);
		}
		{
			lblNewLabel_1 = new JLabel("Número 2");
			lblNewLabel_1.setBounds(135, 62, 46, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			txtNumber2 = new JTextField();
			txtNumber2.setBounds(191, 59, 86, 20);
			contentPane.add(txtNumber2);
			txtNumber2.setColumns(10);
		}
		{
			btnCalc = new JButton("Calcular");
			btnCalc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnCalcActionPerformed(e);
				}
			});
			btnCalc.setBounds(174, 104, 89, 23);
			contentPane.add(btnCalc);
		}
		{
			txtRespuesta = new JTextArea();
			txtRespuesta.setBounds(84, 138, 284, 82);
			contentPane.add(txtRespuesta);
		}
		
		
	}
	protected void btnCalcActionPerformed(ActionEvent e) {
		int num1= 0, num2 = 0,suma = 0,resta = 0, multiplicacion = 0;
		double division = 0 ;
		num1 = Integer.parseInt(txtNumber1.getText());
		num2 = Integer.parseInt(txtNumber2.getText());
		suma = num1+num2;
		resta = num1-num2;
		multiplicacion = num1*num2;
		division = (double)num1/num2;
		DecimalFormat dF = new DecimalFormat("#.###");
		txtRespuesta.setText("La suma es " + (suma));
		txtRespuesta.append("\nLa resta es: "+(resta));
		txtRespuesta.append("\nLa multiplicacion es: "+(multiplicacion));
		txtRespuesta.append("\nLa division es: "+dF.format(division));
	}
}

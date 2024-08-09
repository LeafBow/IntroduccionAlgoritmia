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
import java.awt.Color;

public class FrmNotas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JButton btnResultado;
	private JButton btnLimpiar;
	private JLabel lblResultado;
	private JLabel lblNewLabel_2;
	private JTextField txtNota3;

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
	public FrmNotas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Evaluación 1");
			lblNewLabel.setBounds(60, 39, 80, 14);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Evaluación 2");
			lblNewLabel_1.setBounds(60, 64, 80, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			txtNota1 = new JTextField();
			txtNota1.setBounds(169, 36, 86, 20);
			contentPane.add(txtNota1);
			txtNota1.setColumns(10);
		}
		{
			txtNota2 = new JTextField();
			txtNota2.setColumns(10);
			txtNota2.setBounds(169, 61, 86, 20);
			contentPane.add(txtNota2);
		}
		{
			btnResultado = new JButton("Resultado");
			btnResultado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnResultadoActionPerformed(e);
				}
			});
			btnResultado.setBounds(301, 35, 89, 23);
			contentPane.add(btnResultado);
		}
		{
			btnLimpiar = new JButton("Limpiar");
			btnLimpiar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnLimpiarActionPerformed(e);
				}
			});
			btnLimpiar.setBounds(301, 60, 89, 23);
			contentPane.add(btnLimpiar);
		}
		{
			lblResultado = new JLabel("");
			lblResultado.setForeground(new Color(0, 0, 255));
			lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
			lblResultado.setBounds(94, 151, 161, 14);
			contentPane.add(lblResultado);
		}
		{
			lblNewLabel_2 = new JLabel("Evaluación 3");
			lblNewLabel_2.setBounds(60, 89, 80, 14);
			contentPane.add(lblNewLabel_2);
		}
		{
			txtNota3 = new JTextField();
			txtNota3.setColumns(10);
			txtNota3.setBounds(169, 86, 86, 20);
			contentPane.add(txtNota3);
		}
	}

	protected void btnResultadoActionPerformed(ActionEvent e) {
		Double vNota1,vNota2,vNota3,vPromedio;
		String mensaje="";
		vNota1 = Double.parseDouble(txtNota1.getText());
		vNota2 = Double.parseDouble(txtNota2.getText());
		vNota3 = Double.parseDouble(txtNota3.getText());
	
		if((vNota1>=0&&vNota1<=20)&&(vNota2>=0&&vNota2<=20)&&(vNota3>=0&&vNota3<=20))
		{
			vPromedio = vNota1*0.10+vNota2*0.25+vNota3*0.65;
			
				if(vPromedio>=17)
					{
						mensaje = "Categoría A";
					}
				if(vPromedio>=14 && vPromedio<17)
					{
						mensaje= "Categoría B";
					}
				if(vPromedio>=12&&vPromedio<14);
				{
					mensaje= "Categoría C";
				}
				if(vPromedio<12)
				{
					mensaje= "Categoría D";
				}
			
			lblResultado.setText(mensaje);
		}
		
		
		
		
	}
	
	protected void btnLimpiarActionPerformed(ActionEvent e) {
		txtNota1.setText("");
		txtNota2.setText("");
		txtNota3.setText("");
		lblResultado.setText("");
		
		txtNota1.requestFocus();
	}
}

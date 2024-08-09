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

public class FrmResultado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtGolesA;
	private JTextField txtGolesB;
	private JButton btnResultado;
	private JButton btnLimpiar;
	private JLabel lblResultado;

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
	public FrmResultado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Goles Equipo A");
			lblNewLabel.setBounds(60, 39, 80, 14);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Goles Equipo B");
			lblNewLabel_1.setBounds(60, 64, 80, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			txtGolesA = new JTextField();
			txtGolesA.setBounds(169, 36, 86, 20);
			contentPane.add(txtGolesA);
			txtGolesA.setColumns(10);
		}
		{
			txtGolesB = new JTextField();
			txtGolesB.setColumns(10);
			txtGolesB.setBounds(169, 61, 86, 20);
			contentPane.add(txtGolesB);
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
			lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
			lblResultado.setBounds(94, 151, 161, 14);
			contentPane.add(lblResultado);
		}
	}

	protected void btnResultadoActionPerformed(ActionEvent e) {
		int vGolesA,vGolesB;
		String mensaje="Ingrese Goles";
		vGolesA = Integer.parseInt(txtGolesA.getText());
		vGolesB = Integer.parseInt(txtGolesB.getText());
		
		if(vGolesA>vGolesB)
		{
			mensaje = "El equipo ganador es el A";
		}
		if(vGolesA==vGolesB)
		{
			mensaje= "Empate";
		}
		if(vGolesA<vGolesB)
		{
			mensaje ="El equipo ganador es el B";
		}
		lblResultado.setText(mensaje);
	}
	protected void btnLimpiarActionPerformed(ActionEvent e) {
		txtGolesA.setText("");
		txtGolesB.setText("");
		lblResultado.setText("");
		
		txtGolesA.requestFocus();
	}
}

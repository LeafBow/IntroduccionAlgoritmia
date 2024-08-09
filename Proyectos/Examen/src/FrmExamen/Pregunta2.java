package FrmExamen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Pregunta2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtMonto;
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
					Pregunta2 frame = new Pregunta2();
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
	public Pregunta2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Monto a repartir:");
			lblNewLabel.setBounds(93, 39, 111, 14);
			contentPane.add(lblNewLabel);
		}
		{
			txtMonto = new JTextField();
			txtMonto.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					keyTypedTxtMonto(e);
				}
			});
			txtMonto.setBounds(228, 36, 86, 20);
			contentPane.add(txtMonto);
			txtMonto.setColumns(10);
		}
		{
			btnCalcular = new JButton("Calcular");
			btnCalcular.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnCalcular(e);
				}
			});
			btnCalcular.setBounds(424, 35, 89, 23);
			contentPane.add(btnCalcular);
		}
		{
			btnLimpiar = new JButton("Limpiar");
			btnLimpiar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnLimpiar(e);
				}
			});
			btnLimpiar.setBounds(424, 126, 89, 23);
			contentPane.add(btnLimpiar);
		}
		{
			txtSalida = new JTextArea();
			txtSalida.setEditable(false);
			txtSalida.setBounds(51, 91, 355, 212);
			contentPane.add(txtSalida);
		}
	}

	protected void actionPerformedBtnCalcular(ActionEvent e) {
		//Variables
		double vUtilidad = Double.parseDouble(txtMonto.getText());
		double vGerencia = vUtilidad*0.3;
		double vAdministracion = vGerencia*0.12;
		double vContabilidad = vUtilidad*0.15;
		double vSistemas = (vGerencia+vContabilidad)*0.3;
		double vAlmacen = vUtilidad -(vGerencia+vAdministracion+vContabilidad+vSistemas);
	
		DecimalFormat fm = new DecimalFormat("#,##0.00");
		//Output
		txtSalida.setText("Monto por Area:	");
		txtSalida.append("\nGerencia: "+fm.format(vGerencia));			
		txtSalida.append("\n-Monto por trabajador Gerencia (1): "+fm.format(vGerencia));
		txtSalida.append("\nAdministracion: "+fm.format(vAdministracion));
		txtSalida.append("\n-Monto por trabajador Administracion (3): "+fm.format(vAdministracion/3));
		txtSalida.append("\nContabilidad: "+fm.format(vContabilidad));
		txtSalida.append("\n-Monto por trabajador Contabilidad (3): "+fm.format(vContabilidad/3));
		txtSalida.append("\nSistemas: "+fm.format(vSistemas));
		txtSalida.append("\n-Monto por trabajador Sistemas (2): "+fm.format(vSistemas/2));
		txtSalida.append("\nAlmacen: "+fm.format(vAlmacen));
		txtSalida.append("\n-Monto por trabajador Almacen (2): "+fm.format(vAlmacen/2));

		
		
	}
	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		txtMonto.setText("");
		txtSalida.setText("");
		txtMonto.requestFocus();
	}
	protected void keyTypedTxtMonto(KeyEvent e) {
		char caracter = e.getKeyChar();
		if(caracter<'0'||caracter>'9')
		{
			e.consume();
		}
			
	}
}

package FrmExamen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Pregunta1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblSocio;
	private JLabel lblSocio_1;
	private JTextField txtInversionS1;
	private JTextField txtInversionS2;
	private JTextField txtInversionS3;
	private JTextArea txtSalida;
	private JButton btnCalcular;
	private JButton btnClear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pregunta1 frame = new Pregunta1();
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
	public Pregunta1() {
		setTitle("ARALSOFT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Socio 1");
			lblNewLabel.setBounds(89, 29, 61, 14);
			contentPane.add(lblNewLabel);
		}
		{
			lblSocio = new JLabel("Socio 2");
			lblSocio.setBounds(89, 54, 61, 14);
			contentPane.add(lblSocio);
		}
		{
			lblSocio_1 = new JLabel("Socio 3");
			lblSocio_1.setBounds(89, 79, 61, 14);
			contentPane.add(lblSocio_1);
		}
		{
			txtInversionS1 = new JTextField();
			txtInversionS1.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					keyTypedTxtInversionS1(e);
				}
			});
			txtInversionS1.setBounds(160, 26, 86, 20);
			contentPane.add(txtInversionS1);
			txtInversionS1.setColumns(10);
		}
		{
			txtInversionS2 = new JTextField();
			txtInversionS2.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					keyTypedTxtInversionS2(e);
				}
			});
			txtInversionS2.setColumns(10);
			txtInversionS2.setBounds(160, 51, 86, 20);
			contentPane.add(txtInversionS2);
		}
		{
			txtInversionS3 = new JTextField();
			txtInversionS3.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					keyTypedTxtInversionS3(e);
				}
			});
			txtInversionS3.setColumns(10);
			txtInversionS3.setBounds(160, 79, 86, 20);
			contentPane.add(txtInversionS3);
		}
		{
			btnCalcular = new JButton("Calcular");
			btnCalcular.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnCalcular(e);
				}
			});
			btnCalcular.setBounds(472, 25, 89, 23);
			contentPane.add(btnCalcular);
		}
		{
			txtSalida = new JTextArea();
			txtSalida.setEditable(false);
			txtSalida.setBounds(89, 141, 394, 194);
			contentPane.add(txtSalida);
		}
		{
			btnClear = new JButton("Limpiar");
			btnClear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnClear(e);
				}
			});
			btnClear.setBounds(472, 75, 89, 23);
			contentPane.add(btnClear);
		}
	}
	protected void actionPerformedBtnCalcular(ActionEvent e) {
		
		//Declare variables
		double vInversion1,vInversion2,vInversion3,vInversionTotal,vGanancia,vImpuesto;
		
		//Assign
		vInversion1 = Double.parseDouble(txtInversionS1.getText());
		vInversion2 = Double.parseDouble(txtInversionS2.getText());
		vInversion3 = Double.parseDouble(txtInversionS3.getText());
		
		vInversionTotal = vInversion1+vInversion2+vInversion3;
		
		vGanancia = vInversionTotal*0.25;
		vImpuesto = vGanancia - (vGanancia*0.05);
		
		//Output
		
		DecimalFormat fm = new DecimalFormat("#,##0.00");
		
		txtSalida.setText("La inversion Total es: "+fm.format(vInversionTotal));
		txtSalida.append("\nLa Utilidad sin impuestos: "+fm.format(vGanancia));
		txtSalida.append("\nLa Utilidad con impuestos: "+fm.format(vImpuesto));
		txtSalida.append("\n-----------------------------------------");
		txtSalida.append("\nLa particion de socio 1 es: "+fm.format((vInversion1/vInversionTotal)*100)+"%");
		txtSalida.append("\nLa particion de socio 2 es: "+fm.format((vInversion2/vInversionTotal)*100)+"%");
		txtSalida.append("\nLa particion de socio 3 es: "+fm.format((vInversion3/vInversionTotal)*100)+"%");
		txtSalida.append("\n-----------------------------------------");
		txtSalida.append("\nLa utilidad de socio 1 es: S/."+fm.format(vImpuesto*(vInversion1/vInversionTotal)));
		txtSalida.append("\nLa utilidad de socio 2 es: S/."+fm.format(vImpuesto*(vInversion2/vInversionTotal)));
		txtSalida.append("\nLa utilidad de socio 3 es: S/."+fm.format(vImpuesto*(vInversion3/vInversionTotal)));
		
	}
	protected void actionPerformedBtnClear(ActionEvent e) {
		txtSalida.setText("");
		txtInversionS1.setText("");
		txtInversionS2.setText("");
		txtInversionS3.setText("");

		txtInversionS1.requestFocus();
	}
	protected void keyTypedTxtInversionS1(KeyEvent e) {
		
		char caracter = e.getKeyChar();
		if(caracter<'0'||caracter>'9')
		{
			e.consume();
		}
		
	}
	protected void keyTypedTxtInversionS2(KeyEvent e) {
		char caracter = e.getKeyChar();
		if(caracter<'0'||caracter>'9')
		{
			e.consume();
		}
	}
	protected void keyTypedTxtInversionS3(KeyEvent e) {
		char caracter = e.getKeyChar();
		if(caracter<'0'||caracter>'9')
		{
			e.consume();
		}
	}
}

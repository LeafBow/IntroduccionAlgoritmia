package programas;

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

public class FrmPorcentaje extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblRaquel;
	private JLabel lblSfora;
	private JTextField txtDebora;
	private JTextField txtRaquel;
	private JTextField txtSefora;
	private JTextArea txtSalida;
	private JButton btnProcesar;
	private JButton btnBorrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPorcentaje frame = new FrmPorcentaje();
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
	public FrmPorcentaje() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Débora");
			lblNewLabel.setBounds(10, 29, 46, 14);
			contentPane.add(lblNewLabel);
		}
		{
			lblRaquel = new JLabel("Raquel");
			lblRaquel.setBounds(10, 54, 46, 14);
			contentPane.add(lblRaquel);
		}
		{
			lblSfora = new JLabel("Séfora");
			lblSfora.setBounds(10, 79, 46, 14);
			contentPane.add(lblSfora);
		}
		{
			txtDebora = new JTextField();
			txtDebora.setBounds(62, 26, 86, 20);
			contentPane.add(txtDebora);
			txtDebora.setColumns(10);
		}
		{
			txtRaquel = new JTextField();
			txtRaquel.setBounds(62, 51, 86, 20);
			contentPane.add(txtRaquel);
			txtRaquel.setColumns(10);
		}
		{
			txtSefora = new JTextField();
			txtSefora.setColumns(10);
			txtSefora.setBounds(62, 76, 86, 20);
			contentPane.add(txtSefora);
		}
		{
			txtSalida = new JTextArea();
			txtSalida.setBounds(10, 139, 386, 94);
			contentPane.add(txtSalida);
		}
		{
			btnProcesar = new JButton("Procesar");
			btnProcesar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnProcesarActionPerformed(e);
				}
			});
			btnProcesar.setBounds(307, 25, 89, 23);
			contentPane.add(btnProcesar);
		}
		{
			btnBorrar = new JButton("Borrar");
			btnBorrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnBorrarActionPerformed(e);
				}
			});
			btnBorrar.setBounds(307, 50, 89, 23);
			contentPane.add(btnBorrar);
		}
	}

	protected void btnProcesarActionPerformed(ActionEvent e) {
		Double vDebora,vRaquel,vSefora,vTotal;
		vDebora = Double.parseDouble(txtDebora.getText());
		vRaquel = Double.parseDouble(txtRaquel.getText());
		vSefora = Double.parseDouble(txtSefora.getText());
		vTotal = vDebora+vRaquel+vSefora;
		
		DecimalFormat fm = new DecimalFormat("#,##0.00");
		txtSalida.setText("Capital:		"+vTotal);
		txtSalida.append("\nPorcentaje de Debora:	"+fm.format((vDebora/vTotal)*100)+"%");
		txtSalida.append("\nPorcentaje de Raquel:	"+fm.format((vRaquel/vTotal)*100)+"%");
		txtSalida.append("\nPorcentaje de Sefora:	"+fm.format((vSefora/vTotal)*100)+"%");
		
	}
	protected void btnBorrarActionPerformed(ActionEvent e) {
		
		txtDebora.setText("");
		txtRaquel.setText("");
		txtSefora.setText("");
		txtSalida.setText("");
		txtDebora.requestFocus();
	}
}

package lab2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AreaTriangulo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtBase;
	private JLabel lblNewLabel_1;
	private JTextField txtAltura;
	private JButton btnCacular;
	private JTextArea txtRespuesta;
	private JButton btnLimpiar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AreaTriangulo frame = new AreaTriangulo();
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
	public AreaTriangulo() {
		setTitle("Area del Triangulo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Base");
			lblNewLabel.setBounds(55, 50, 46, 14);
			contentPane.add(lblNewLabel);
		}
		{
			txtBase = new JTextField();
			txtBase.setBounds(136, 47, 86, 20);
			contentPane.add(txtBase);
			txtBase.setColumns(10);
		}
		{
			lblNewLabel_1 = new JLabel("Altura");
			lblNewLabel_1.setBounds(55, 90, 46, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			txtAltura = new JTextField();
			txtAltura.setBounds(136, 87, 86, 20);
			contentPane.add(txtAltura);
			txtAltura.setColumns(10);
		}
		{
			btnCacular = new JButton("Calcular");
			btnCacular.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnCacularActionPerformed(e);
				}
			});
			btnCacular.setBounds(279, 63, 89, 23);
			contentPane.add(btnCacular);
		}
		{
			txtRespuesta = new JTextArea();
			txtRespuesta.setBounds(55, 146, 313, 76);
			contentPane.add(txtRespuesta);
		}
		{
			btnLimpiar = new JButton("Limpiar");
			btnLimpiar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnLimpiarActionPerformed(e);
				}
			});
			btnLimpiar.setBounds(279, 233, 89, 23);
			contentPane.add(btnLimpiar);
		}
	}

	protected void btnCacularActionPerformed(ActionEvent e) {
		double vArea;
		int vBase, vAltura;
		
		vBase = Integer.parseInt(txtBase.getText());
		vAltura = Integer.parseInt(txtAltura.getText());
		
		vArea = ((double) vBase *vAltura)/2;
	txtRespuesta.setText("El area es: "+vArea);	
	}
	protected void btnLimpiarActionPerformed(ActionEvent e) {
		txtBase.setText("");
		txtAltura.setText("");
		txtRespuesta.setText("");
		txtBase.requestFocus();
	}
}

package lab2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AreasFiguras extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblAreaDelTriangulo;
	private JLabel lblNewLabel_1;
	private JTextField txtLado;
	private JButton btnArea;
	private JLabel lblAreaCuadrado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AreasFiguras frame = new AreasFiguras();
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
	public AreasFiguras() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Area del Cuadrado");
			lblNewLabel.setForeground(new Color(0, 128, 255));
			lblNewLabel.setBounds(53, 41, 104, 14);
			contentPane.add(lblNewLabel);
		}
		{
			lblAreaDelTriangulo = new JLabel("Area del Triangulo");
			lblAreaDelTriangulo.setForeground(new Color(0, 128, 255));
			lblAreaDelTriangulo.setBounds(276, 41, 104, 14);
			contentPane.add(lblAreaDelTriangulo);
		}
		{
			lblNewLabel_1 = new JLabel("Lado");
			lblNewLabel_1.setBounds(53, 87, 46, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			txtLado = new JTextField();
			txtLado.setBounds(109, 84, 86, 20);
			contentPane.add(txtLado);
			txtLado.setColumns(10);
		}
		{
			btnArea = new JButton("Area");
			btnArea.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnAreaActionPerformed(e);
				}
			});
			btnArea.setBounds(70, 125, 89, 23);
			contentPane.add(btnArea);
		}
		{
			lblAreaCuadrado = new JLabel("");
			lblAreaCuadrado.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblAreaCuadrado.setBounds(53, 170, 142, 14);
			contentPane.add(lblAreaCuadrado);
		}
	}
	protected void btnAreaActionPerformed(ActionEvent e) {
		int vLado,vArea;
		vLado = Integer.parseInt(txtLado.getText());
		vArea = vLado*vLado;
		//lblAreaCuadrado.setText("El area es: "+vArea);
		JOptionPane.showMessageDialog(null, "El area es: "+vArea);
		
	}
}

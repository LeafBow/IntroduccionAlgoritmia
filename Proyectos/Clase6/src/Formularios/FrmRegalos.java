package Formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class FrmRegalos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtNumero;
	private JButton btnPlay;
	private JLabel lblRegalo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegalos frame = new FrmRegalos();
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
	public FrmRegalos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Número: ");
			lblNewLabel.setBounds(116, 58, 62, 14);
			contentPane.add(lblNewLabel);
		}
		{
			txtNumero = new JTextField();
			txtNumero.setBounds(220, 55, 86, 20);
			contentPane.add(txtNumero);
			txtNumero.setColumns(10);
		}
		{
			btnPlay = new JButton("Jugar");
			btnPlay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnPlay(e);
				}
			});
			btnPlay.setBounds(174, 103, 89, 23);
			contentPane.add(btnPlay);
		}
		{
			lblRegalo = new JLabel("");
			lblRegalo.setHorizontalAlignment(SwingConstants.CENTER);
			lblRegalo.setFont(new Font("Verdana", Font.PLAIN, 15));
			lblRegalo.setBounds(10, 158, 414, 29);
			contentPane.add(lblRegalo);
		}
	}

	protected void actionPerformedBtnPlay(ActionEvent e) {
		
		int vBolita;
		String vRegalo;
		vBolita = Integer.parseInt(txtNumero.getText());
		
		switch (vBolita) {
		case 5:
			vRegalo ="Lapicero";
			break;
			//Case doble
		case 10: case 48:
			vRegalo ="Reloj";
			break;
		case 27:
			vRegalo ="USB";
			break;
		case 36:
			vRegalo ="Pelota";
			break;

		default:
			vRegalo ="Siga intentando!";
			break;
		}
		
		lblRegalo.setText(vRegalo);
	}
}

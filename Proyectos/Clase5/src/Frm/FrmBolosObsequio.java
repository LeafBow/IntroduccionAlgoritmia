package Frm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmBolosObsequio extends JFrame {
	
	int contador= 0;
	int contadorPremioGrande=0;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnPlay;
	private JButton btnReset;
	private JTextArea txtSalida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmBolosObsequio frame = new FrmBolosObsequio();
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
	public FrmBolosObsequio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			btnPlay = new JButton("Jugar");
			btnPlay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnPlay(e);
				}
			});
			btnPlay.setBounds(100, 11, 89, 89);
			contentPane.add(btnPlay);
		}
		{
			btnReset = new JButton("Reiniciar");
			btnReset.setBounds(232, 11, 89, 89);
			contentPane.add(btnReset);
		}
		{
			txtSalida = new JTextArea();
			txtSalida.setBounds(56, 140, 314, 89);
			contentPane.add(txtSalida);
		}
	}

	protected void actionPerformedBtnPlay(ActionEvent e) {
		int vMaximo = 5;
		int vBolo, vTope=100;
		String obsequio= "";
		vBolo = (int)(Math.random()*vTope)+1;
		
		if(vBolo>60&&contador<vMaximo)
		{
			vTope=60;
			vBolo = (int)(Math.random()*vTope)+1;
			contador++;
			contadorPremioGrande++;
		}
		else
		{
			contador++;
			contadorPremioGrande++;
		}
		if(contadorPremioGrande==50)
		{
			vBolo=100;
		}
			
		if(vBolo <20)
		{
			obsequio="Lapicero";
		}
		else if(vBolo<40)
		{
			obsequio="Cuaderno de 100 Hojas";
			
		}
		else if(vBolo<60)
		{
			obsequio="Caja de Plumones";
			contador =0;
		}
		else if(vBolo<88)
		{
			obsequio="Cuaderno Espiral";
			contador =0;
		}
		else if(vBolo<99)
		{
			obsequio="Agenda";
			contador =0;
		}
		else if(vBolo==100||contadorPremioGrande==50)
		{
			obsequio="Mochila";
			contador = 0;
			contadorPremioGrande=0;
		}
		
		
		txtSalida.setText("Numero bolo: "+vBolo);
		txtSalida.append("\nPremio: "+obsequio);
		//txtSalida.append("\n"+contador);
		//txtSalida.append("\n"+contadorPremioGrande);
		
		
		
	}
}

package Formularios;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;

public class FrmPension extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblPromedio;
	private JTextField txtPromedio;
	private JComboBox cmbCategoria;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JTextArea txtSalida;

	int vgCategoria;
	double vgPromedio, vgPension,vgDescuento;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPension frame = new FrmPension();
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
	public FrmPension() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Categoria");
			lblNewLabel.setBounds(38, 36, 60, 14);
			contentPane.add(lblNewLabel);
		}
		{
			lblPromedio = new JLabel("Promedio");
			lblPromedio.setBounds(38, 61, 60, 14);
			contentPane.add(lblPromedio);
		}
		{
			txtPromedio = new JTextField();
			txtPromedio.setBounds(103, 58, 86, 20);
			contentPane.add(txtPromedio);
			txtPromedio.setColumns(10);
		}
		{
			cmbCategoria = new JComboBox();
			cmbCategoria.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D"}));
			cmbCategoria.setBounds(103, 32, 86, 22);
			contentPane.add(cmbCategoria);
		}
		{
			btnProcesar = new JButton("Procesar");
			btnProcesar.setBounds(317, 32, 89, 23);
			btnProcesar.addActionListener(this);
			contentPane.add(btnProcesar);
		}
		{
			btnBorrar = new JButton("Borrar");
			btnBorrar.setBounds(317, 57, 89, 23);
			btnBorrar.addActionListener(this);
			contentPane.add(btnBorrar);
		}
		{
			txtSalida = new JTextArea();
			txtSalida.setBounds(38, 112, 370, 88);
			contentPane.add(txtSalida);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnProcesar)
		{
			leerVariables();
			vgDescuento = descuentoPension(vgPromedio, vgPension);
			imprimir(vgPension,vgDescuento,(vgPension-vgDescuento));
		}
		if(e.getSource()==btnBorrar)
		{
			borrar();
		}
		
	}
	
	public void leerVariables()
	{
		vgCategoria = cmbCategoria.getSelectedIndex();
		vgPromedio = Double.parseDouble(txtPromedio.getText());
		switch (vgCategoria) {
		case 0:
			vgPension=550;
			break;
		case 1:
			vgPension=500;
			break;
		case 2:
			vgPension=460;
			break;
		case 3:
			vgPension=400;
			break;
		}
	}
	public double descuentoPension(double promedio, double pension)
	{
		double vDescuento=0;
		if(promedio<13.99)
		{
			vDescuento = 0;
		}
		else if(promedio<15.99)
		{
			vDescuento = 0.10;
		}
		else if(promedio<17.99)
		{
			vDescuento = 0.12;
		}
		else
		{
			vDescuento = 0.15;
		}
		
		return vDescuento*pension;
	}
	
	public void imprimir(double pension,double descuento, double nuevaPension)
	
	{
		txtSalida.setText("Pension actual:	S/. "+pension);
		txtSalida.append("\nDescuento:	S/."+descuento);
		txtSalida.append("\nNueva pension:	S/."+nuevaPension);
	}

	public void borrar()
	{
		txtSalida.setText("");
		cmbCategoria.setSelectedIndex(0);
		txtPromedio.setText("");
		txtPromedio.requestFocus();
	}
}

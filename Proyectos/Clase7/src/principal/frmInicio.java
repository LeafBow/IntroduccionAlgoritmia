package principal;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import view.*;

public class frmInicio extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenuItem mnitemClientes;
	private JMenuItem mnitemProovedores;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JDesktopPane escritorio;
	
	private FrmClientes frmCliente = new FrmClientes();
	private FrmProveedores frmProveedores = new FrmProveedores();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmInicio frame = new frmInicio();
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
	public frmInicio() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 448);
		{
			menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			{
				mnNewMenu = new JMenu("Mantenimiento");
				menuBar.add(mnNewMenu);
				{
					mnitemClientes = new JMenuItem("Clientes");
					mnitemClientes.addActionListener(this);
					mnNewMenu.add(mnitemClientes);
				}
				{
					mnitemProovedores = new JMenuItem("Proveedores");
					mnitemProovedores.addActionListener(this);
					mnNewMenu.add(mnitemProovedores);
				}
				{
					mntmNewMenuItem_2 = new JMenuItem("Productos");
					mnNewMenu.add(mntmNewMenuItem_2);
				}
			}
			{
				mnNewMenu_1 = new JMenu("Procesos");
				menuBar.add(mnNewMenu_1);
				{
					mntmNewMenuItem_3 = new JMenuItem("Generar Pedido");
					mnNewMenu_1.add(mntmNewMenuItem_3);
				}
				{
					mntmNewMenuItem_4 = new JMenuItem("Informes");
					mnNewMenu_1.add(mntmNewMenuItem_4);
				}
			}
			{
				mnNewMenu_2 = new JMenu("Ayuda");
				menuBar.add(mnNewMenu_2);
				{
					mntmNewMenuItem_5 = new JMenuItem("Acerca de");
					mnNewMenu_2.add(mntmNewMenuItem_5);
				}
			}
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		{
			escritorio = new JDesktopPane();
			contentPane.add(escritorio, BorderLayout.CENTER);
			frmCliente.setLocation(73,55);
			escritorio.add(frmCliente);
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==mnitemClientes)
		{
			frmCliente.setVisible(true);
		}
		if(e.getSource()==mnitemProovedores)
		{
			frmProveedores.setVisible(true);
		}
	
		
	}
}

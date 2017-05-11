package eam.desarollo.hospital.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextPane;

import eam.desarrollo.hospital.DAO.DAOConsultorio;
import eam.desarrollo.hospital.controladores.controladorConsultorio;
import eam.desarrollo.hospital.controladores.controladorPaciente;
import eam.desarrollo.hospital.entidades.Consultorio;
import eam.desarrollo.hospital.entidades.EstadoConsultorio;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaConsultorio {

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaConsultorio window = new VentanaConsultorio();
					window.frmConsultorios.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public VentanaConsultorio() throws Exception {
		initialize();
		/*String estado = "Ocupado";
		

		String consultorio = "004";
		String descripcion = "Hola";
		estado_consultorio = new EstadoConsultorio("0",estado);
		nuevo_consultorio = new Consultorio(consultorio,descripcion,estado_consultorio);
		Midaoconsultorio.crear(nuevo_consultorio);*/
		micontroladorconsultorio =  new controladorConsultorio(this);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsultorios = new JFrame();
		frmConsultorios.setTitle("Consultorios");
		frmConsultorios.setBounds(100, 100, 298, 247);
		frmConsultorios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConsultorios.getContentPane().setLayout(null);
		
		
		lblConsultorio.setBounds(10, 11, 61, 14);
		frmConsultorios.getContentPane().add(lblConsultorio);
		
		
		lblNewLabel.setBounds(10, 81, 61, 14);
		frmConsultorios.getContentPane().add(lblNewLabel);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(10, 36, 46, 14);
		frmConsultorios.getContentPane().add(lblEstado);
		
		
		comboBox.setBounds(66, 33, 61, 20);
		frmConsultorios.getContentPane().add(comboBox);
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		btnRegistrar.setBounds(38, 174, 89, 23);
		frmConsultorios.getContentPane().add(btnRegistrar);
		
		
		btnBuscar.setBounds(38, 140, 89, 23);
		frmConsultorios.getContentPane().add(btnBuscar);
		
		
		btnActualizar.setBounds(146, 140, 89, 23);
		frmConsultorios.getContentPane().add(btnActualizar);
		
		
		btnEliminar.setBounds(146, 174, 89, 23);
		frmConsultorios.getContentPane().add(btnEliminar);
		
		
		textPane.setBounds(81, 67, 177, 48);
		frmConsultorios.getContentPane().add(textPane);
		
		
		JTFConsultorio.setBounds(66, 8, 86, 20);
		frmConsultorios.getContentPane().add(JTFConsultorio);
		JTFConsultorio.setColumns(10);
	}
	
	private JFrame frmConsultorios;
	public JTextField JTFConsultorio = new JTextField();
	public JLabel lblConsultorio = new JLabel("Consultorio");
	public JLabel lblNewLabel = new JLabel("Descripcion");
	public JLabel lblEstado = new JLabel("Estado");
	public JComboBox comboBox = new JComboBox();
	public JButton btnRegistrar = new JButton("Registrar");
	public JButton btnBuscar = new JButton("Buscar");
	public JButton btnActualizar = new JButton("Actualizar");
	public JButton btnEliminar = new JButton("Eliminar");
	public JTextPane textPane = new JTextPane();
	public controladorConsultorio micontroladorconsultorio;
	public DAOConsultorio Midaoconsultorio = new DAOConsultorio();
	public Consultorio nuevo_consultorio = null;
	public EstadoConsultorio estado_consultorio = null;
}

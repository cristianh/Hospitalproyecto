package eam.desarollo.hospital.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

import eam.desarrollo.hospital.controladores.controladorCita;
import eam.desarrollo.hospital.controladores.controladorPaciente;

import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class VentanaCita {

	private JFrame frmVentanaCitas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCita window = new VentanaCita();
					window.frmVentanaCitas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaCita() {
		initialize();
		micontroladorCita = new controladorCita(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JTFIdcita.setBounds(358, 48, 129, 20);
		JTFIdcita.setColumns(10);
		frmVentanaCitas = new JFrame();
		frmVentanaCitas.setIconImage(Toolkit.getDefaultToolkit().getImage("../Imagenes\\bloc.png"));
		frmVentanaCitas.setTitle("Ventana CItas");
		frmVentanaCitas.setBounds(100, 100, 638, 401);
		frmVentanaCitas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVentanaCitas.getContentPane().setLayout(null);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecha.setBounds(350, 183, 46, 14);
		frmVentanaCitas.getContentPane().add(lblFecha);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEstado.setBounds(196, 125, 46, 14);
		frmVentanaCitas.getContentPane().add(lblEstado);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipo.setBounds(21, 125, 46, 14);
		frmVentanaCitas.getContentPane().add(lblTipo);

		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumero.setBounds(300, 49, 63, 14);
		frmVentanaCitas.getContentPane().add(lblNumero);

		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPaciente.setBounds(21, 77, 63, 14);
		frmVentanaCitas.getContentPane().add(lblPaciente);

		JLabel lblMedico = new JLabel("Medico");
		lblMedico.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMedico.setBounds(385, 125, 46, 14);
		frmVentanaCitas.getContentPane().add(lblMedico);

		JTFPaciente.setBounds(83, 76, 232, 20);
		frmVentanaCitas.getContentPane().add(JTFPaciente);
		JTFPaciente.setColumns(10);

		JTFMedico.setBounds(441, 124, 134, 20);
		frmVentanaCitas.getContentPane().add(JTFMedico);
		JTFMedico.setColumns(10);

		JLabel lblConsultorio = new JLabel("Consultorio");
		lblConsultorio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConsultorio.setBounds(21, 184, 72, 14);
		frmVentanaCitas.getContentPane().add(lblConsultorio);

		JCBEstado.setBounds(252, 124, 98, 20);
		frmVentanaCitas.getContentPane().add(JCBEstado);

		JCBConsultorio.setBounds(99, 183, 63, 20);
		frmVentanaCitas.getContentPane().add(JCBConsultorio);

		JCBTipo.setBounds(63, 124, 123, 20);
		frmVentanaCitas.getContentPane().add(JCBTipo);

		btnRegistrar.setIcon(
				new ImageIcon("C:\\Users\\Casa1\\Documents\\GitHub\\Hospitalproyecto\\Imagenes\\usuario (3).png"));
		btnRegistrar.setBounds(33, 297, 123, 38);
		frmVentanaCitas.getContentPane().add(btnRegistrar);

		btnActualizar.setIcon(
				new ImageIcon("C:\\Users\\Casa1\\Documents\\GitHub\\Hospitalproyecto\\Imagenes\\usuario (1).png"));
		btnActualizar.setBounds(340, 297, 123, 38);
		frmVentanaCitas.getContentPane().add(btnActualizar);

		btnBuscar.setIcon(
				new ImageIcon("C:\\Users\\Casa1\\Documents\\GitHub\\Hospitalproyecto\\Imagenes\\usuario (2).png"));
		btnBuscar.setBounds(190, 297, 116, 38);
		frmVentanaCitas.getContentPane().add(btnBuscar);

		JLabel lblCita = new JLabel("Citas");
		lblCita.setFont(new Font("Arial", Font.BOLD, 30));
		lblCita.setHorizontalAlignment(SwingConstants.CENTER);
		lblCita.setBounds(52, 11, 145, 32);
		frmVentanaCitas.getContentPane().add(lblCita);

		Fecha.setBounds(406, 183, 81, 20);
		frmVentanaCitas.getContentPane().add(Fecha);

		btnBuscarPaciente.setBounds(355, 75, 134, 23);
		frmVentanaCitas.getContentPane().add(btnBuscarPaciente);
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\Casa1\\Documents\\GitHub\\Hospitalproyecto\\Imagenes\\usuario.png"));
		btnEliminar.setBounds(480, 297, 112, 39);
		
		frmVentanaCitas.getContentPane().add(btnEliminar);
		
		frmVentanaCitas.getContentPane().add(JTFIdcita);
	}

	public static controladorCita micontroladorCita;
	public JTextField JTFPaciente = new JTextField();
	public JTextField JTFMedico = new JTextField();
	public JButton btnBuscar = new JButton("Buscar");
	public JButton btnActualizar = new JButton("Actualizar");
	public JButton btnRegistrar = new JButton("Registrar");
	public JComboBox JCBTipo = new JComboBox();
	public JDateChooser Fecha = new JDateChooser();
	public JButton btnBuscarPaciente = new JButton("Buscar paciente");
	public JComboBox JCBConsultorio = new JComboBox();
	public JComboBox JCBEstado = new JComboBox();
	public JButton btnEliminar = new JButton("Eliminar");
	public JTextField JTFIdcita = new JTextField();
}

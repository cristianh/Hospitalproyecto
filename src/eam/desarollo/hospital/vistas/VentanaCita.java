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
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class VentanaCita {

	private JFrame frmVentanaCitas;
	private JTextField JTFPaciente;
	private JTextField JTFMedico;

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVentanaCitas = new JFrame();
		frmVentanaCitas.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Casa1\\Documents\\GitHub\\Hospitalproyecto\\Imagenes\\bloc.png"));
		frmVentanaCitas.setTitle("Ventana CItas");
		frmVentanaCitas.setBounds(100, 100, 515, 309);
		frmVentanaCitas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVentanaCitas.getContentPane().setLayout(null);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecha.setBounds(21, 180, 46, 14);
		frmVentanaCitas.getContentPane().add(lblFecha);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEstado.setBounds(21, 144, 46, 14);
		frmVentanaCitas.getContentPane().add(lblEstado);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipo.setBounds(315, 144, 46, 14);
		frmVentanaCitas.getContentPane().add(lblTipo);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumero.setBounds(284, 52, 63, 14);
		frmVentanaCitas.getContentPane().add(lblNumero);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPaciente.setBounds(21, 77, 63, 14);
		frmVentanaCitas.getContentPane().add(lblPaciente);
		
		JLabel lblMedico = new JLabel("Medico");
		lblMedico.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMedico.setBounds(21, 102, 46, 14);
		frmVentanaCitas.getContentPane().add(lblMedico);
		
		JLabel LBNumero = new JLabel("------");
		LBNumero.setBounds(357, 54, 116, 14);
		frmVentanaCitas.getContentPane().add(LBNumero);
		
		JTFPaciente = new JTextField();
		JTFPaciente.setBounds(83, 76, 232, 20);
		frmVentanaCitas.getContentPane().add(JTFPaciente);
		JTFPaciente.setColumns(10);
		
		JTFMedico = new JTextField();
		JTFMedico.setBounds(81, 106, 232, 20);
		frmVentanaCitas.getContentPane().add(JTFMedico);
		JTFMedico.setColumns(10);
		
		JLabel lblConsultorio = new JLabel("Consultorio");
		lblConsultorio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConsultorio.setBounds(154, 144, 72, 14);
		frmVentanaCitas.getContentPane().add(lblConsultorio);
		
		JComboBox JCBEstado = new JComboBox();
		JCBEstado.setBounds(81, 143, 63, 20);
		frmVentanaCitas.getContentPane().add(JCBEstado);
		
		JComboBox JCBConsultorio = new JComboBox();
		JCBConsultorio.setBounds(232, 143, 63, 20);
		frmVentanaCitas.getContentPane().add(JCBConsultorio);
		
		JComboBox JCBTipo = new JComboBox();
		JCBTipo.setBounds(357, 143, 63, 20);
		frmVentanaCitas.getContentPane().add(JCBTipo);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setIcon(new ImageIcon("C:\\Users\\Casa1\\Documents\\GitHub\\Hospitalproyecto\\Imagenes\\usuario (3).png"));
		btnRegistrar.setBounds(34, 222, 123, 38);
		frmVentanaCitas.getContentPane().add(btnRegistrar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setIcon(new ImageIcon("C:\\Users\\Casa1\\Documents\\GitHub\\Hospitalproyecto\\Imagenes\\usuario (1).png"));
		btnActualizar.setBounds(341, 222, 123, 38);
		frmVentanaCitas.getContentPane().add(btnActualizar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon("C:\\Users\\Casa1\\Documents\\GitHub\\Hospitalproyecto\\Imagenes\\usuario (2).png"));
		btnBuscar.setBounds(191, 222, 116, 38);
		frmVentanaCitas.getContentPane().add(btnBuscar);
		
		JLabel lblCita = new JLabel("Citas");
		lblCita.setFont(new Font("Arial", Font.BOLD, 30));
		lblCita.setHorizontalAlignment(SwingConstants.CENTER);
		lblCita.setBounds(52, 11, 145, 32);
		frmVentanaCitas.getContentPane().add(lblCita);
		
		JDateChooser Fecha = new JDateChooser();
		Fecha.setBounds(77, 180, 81, 20);
		frmVentanaCitas.getContentPane().add(Fecha);
	}
}

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

public class VentanaCita {

	private JFrame frame;
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
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 515, 298);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecha.setBounds(21, 180, 46, 14);
		frame.getContentPane().add(lblFecha);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEstado.setBounds(21, 144, 46, 14);
		frame.getContentPane().add(lblEstado);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipo.setBounds(315, 144, 46, 14);
		frame.getContentPane().add(lblTipo);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumero.setBounds(284, 52, 63, 14);
		frame.getContentPane().add(lblNumero);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPaciente.setBounds(21, 77, 63, 14);
		frame.getContentPane().add(lblPaciente);
		
		JLabel lblMedico = new JLabel("Medico");
		lblMedico.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMedico.setBounds(21, 102, 46, 14);
		frame.getContentPane().add(lblMedico);
		
		JLabel LBNumero = new JLabel("------");
		LBNumero.setBounds(357, 54, 116, 14);
		frame.getContentPane().add(LBNumero);
		
		JTFPaciente = new JTextField();
		JTFPaciente.setBounds(83, 76, 232, 20);
		frame.getContentPane().add(JTFPaciente);
		JTFPaciente.setColumns(10);
		
		JTFMedico = new JTextField();
		JTFMedico.setBounds(81, 106, 232, 20);
		frame.getContentPane().add(JTFMedico);
		JTFMedico.setColumns(10);
		
		JLabel lblConsultorio = new JLabel("Consultorio");
		lblConsultorio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConsultorio.setBounds(154, 144, 72, 14);
		frame.getContentPane().add(lblConsultorio);
		
		JComboBox JCBEstado = new JComboBox();
		JCBEstado.setBounds(81, 143, 63, 20);
		frame.getContentPane().add(JCBEstado);
		
		JComboBox JCBConsultorio = new JComboBox();
		JCBConsultorio.setBounds(232, 143, 63, 20);
		frame.getContentPane().add(JCBConsultorio);
		
		JComboBox JCBTipo = new JComboBox();
		JCBTipo.setBounds(357, 143, 63, 20);
		frame.getContentPane().add(JCBTipo);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(21, 222, 89, 23);
		frame.getContentPane().add(btnRegistrar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(290, 222, 89, 23);
		frame.getContentPane().add(btnActualizar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(154, 222, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		JLabel lblCita = new JLabel("Citas");
		lblCita.setFont(new Font("Arial", Font.BOLD, 30));
		lblCita.setHorizontalAlignment(SwingConstants.CENTER);
		lblCita.setBounds(52, 11, 145, 32);
		frame.getContentPane().add(lblCita);
		
		JDateChooser Fecha = new JDateChooser();
		Fecha.setBounds(77, 180, 81, 20);
		frame.getContentPane().add(Fecha);
	}
}

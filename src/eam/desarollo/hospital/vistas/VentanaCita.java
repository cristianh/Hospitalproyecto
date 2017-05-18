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
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Component;

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
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JTFApellidoMedico.setEnabled(false);
		JTFApellidoMedico.setColumns(10);
		JTFNombreMedico.setEnabled(false);
		JTFNombreMedico.setColumns(10);
		frmVentanaCitas = new JFrame();
		frmVentanaCitas.setIconImage(Toolkit.getDefaultToolkit().getImage("../Imagenes\\bloc.png"));
		frmVentanaCitas.setTitle("Ventana CItas");
		frmVentanaCitas.setBounds(100, 100, 791, 451);
		frmVentanaCitas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVentanaCitas.getContentPane().setLayout(null);
		
		JPanel JpanelPaciente = new JPanel();
		JpanelPaciente.setBorder(new TitledBorder(null, "Datos Paciente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		JpanelPaciente.setBounds(21, 49, 361, 223);
		frmVentanaCitas.getContentPane().add(JpanelPaciente);
		
				JLabel lblPaciente = new JLabel("Id paciente");
				lblPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JTFPaciente.setEditable(false);
		JTFPaciente.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JTFNombre = new JTextField();
		JTFNombre.setEditable(false);
		JTFNombre.setColumns(10);
		
		JTFApellido = new JTextField();
		JTFApellido.setEditable(false);
		JTFApellido.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Documento");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GroupLayout gl_JpanelPaciente = new GroupLayout(JpanelPaciente);
		gl_JpanelPaciente.setHorizontalGroup(
			gl_JpanelPaciente.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_JpanelPaciente.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_JpanelPaciente.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_JpanelPaciente.createSequentialGroup()
							.addGroup(gl_JpanelPaciente.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPaciente)
								.addComponent(lblNewLabel)
								.addComponent(lblApellido))
							.addGap(5)
							.addGroup(gl_JpanelPaciente.createParallelGroup(Alignment.LEADING)
								.addComponent(JTFApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(JTFNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(JTFPaciente, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_JpanelPaciente.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnBuscarPaciente, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
					.addGap(128))
		);
		gl_JpanelPaciente.setVerticalGroup(
			gl_JpanelPaciente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_JpanelPaciente.createSequentialGroup()
					.addGroup(gl_JpanelPaciente.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_JpanelPaciente.createSequentialGroup()
							.addGap(12)
							.addComponent(lblPaciente))
						.addGroup(gl_JpanelPaciente.createSequentialGroup()
							.addContainerGap()
							.addComponent(JTFPaciente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_JpanelPaciente.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(JTFNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_JpanelPaciente.createParallelGroup(Alignment.BASELINE)
						.addComponent(JTFApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblApellido))
					.addGap(27)
					.addGroup(gl_JpanelPaciente.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addComponent(btnBuscarPaciente))
		);
		gl_JpanelPaciente.linkSize(SwingConstants.HORIZONTAL, new Component[] {JTFPaciente, JTFNombre, JTFApellido, textField_2});
		JpanelPaciente.setLayout(gl_JpanelPaciente);
		JpanelMedico.setBorder(new TitledBorder(null, "Medico", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		JpanelMedico.setBounds(422, 49, 310, 223);
		
		frmVentanaCitas.getContentPane().add(JpanelMedico);
						JTFIdMedico.setEnabled(false);
						JTFIdMedico.setColumns(10);
						
								JLabel lblMedico = new JLabel("Id medico");
								lblMedico.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_JpanelMedico = new GroupLayout(JpanelMedico);
		gl_JpanelMedico.setHorizontalGroup(
			gl_JpanelMedico.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_JpanelMedico.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_JpanelMedico.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMedico)
						.addComponent(lblNombre)
						.addComponent(lblApellido_1))
					.addGap(18)
					.addGroup(gl_JpanelMedico.createParallelGroup(Alignment.LEADING, false)
						.addComponent(JTFApellidoMedico, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
						.addComponent(JTFNombreMedico)
						.addComponent(JTFIdMedico))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		gl_JpanelMedico.setVerticalGroup(
			gl_JpanelMedico.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_JpanelMedico.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_JpanelMedico.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMedico)
						.addComponent(JTFIdMedico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_JpanelMedico.createParallelGroup(Alignment.BASELINE)
						.addComponent(JTFNombreMedico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombre))
					.addGap(18)
					.addGroup(gl_JpanelMedico.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellido_1)
						.addComponent(JTFApellidoMedico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(99, Short.MAX_VALUE))
		);
		JpanelMedico.setLayout(gl_JpanelMedico);

		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumero.setBounds(21, 19, 63, 14);
		frmVentanaCitas.getContentPane().add(lblNumero);
		JTFIdcita.setBounds(79, 18, 69, 20);
		JTFIdcita.setColumns(10);
		
		frmVentanaCitas.getContentPane().add(JTFIdcita);

		btnRegistrar.setIcon(
				new ImageIcon("C:\\Users\\Casa1\\Documents\\GitHub\\Hospitalproyecto\\Imagenes\\usuario (3).png"));
		btnRegistrar.setBounds(63, 341, 123, 38);
		frmVentanaCitas.getContentPane().add(btnRegistrar);

		btnActualizar.setIcon(
				new ImageIcon("C:\\Users\\Casa1\\Documents\\GitHub\\Hospitalproyecto\\Imagenes\\usuario (1).png"));
		btnActualizar.setBounds(422, 341, 123, 38);
		frmVentanaCitas.getContentPane().add(btnActualizar);

		btnBuscar.setIcon(
				new ImageIcon("C:\\Users\\Casa1\\Documents\\GitHub\\Hospitalproyecto\\Imagenes\\usuario (2).png"));
		btnBuscar.setBounds(246, 341, 116, 38);
		frmVentanaCitas.getContentPane().add(btnBuscar);
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\Casa1\\Documents\\GitHub\\Hospitalproyecto\\Imagenes\\usuario.png"));
		btnEliminar.setBounds(605, 341, 112, 39);
		
		frmVentanaCitas.getContentPane().add(btnEliminar);
		Fecha.setBounds(199, 18, 81, 20);
		frmVentanaCitas.getContentPane().add(Fecha);
		
				JLabel lblFecha = new JLabel("Fecha");
				lblFecha.setBounds(158, 19, 36, 17);
				frmVentanaCitas.getContentPane().add(lblFecha);
				lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
				JCBEstado.setBounds(355, 18, 86, 20);
				frmVentanaCitas.getContentPane().add(JCBEstado);
				
						JLabel lblEstado = new JLabel("Estado");
						lblEstado.setBounds(303, 18, 42, 17);
						frmVentanaCitas.getContentPane().add(lblEstado);
						lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));
						JCBConsultorio.setBounds(545, 19, 78, 20);
						frmVentanaCitas.getContentPane().add(JCBConsultorio);
						
								JLabel lblConsultorio = new JLabel("Consultorio");
								lblConsultorio.setBounds(466, 19, 69, 17);
								frmVentanaCitas.getContentPane().add(lblConsultorio);
								lblConsultorio.setFont(new Font("Tahoma", Font.PLAIN, 14));
								JCBTipo.setBounds(687, 19, 78, 20);
								frmVentanaCitas.getContentPane().add(JCBTipo);
								
										JLabel lblTipo = new JLabel("Tipo");
										lblTipo.setBounds(651, 19, 26, 17);
										frmVentanaCitas.getContentPane().add(lblTipo);
										lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
	}

	public static controladorCita micontroladorCita;
	public JTextField JTFPaciente = new JTextField();
	public JTextField JTFIdMedico = new JTextField();
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
	private JTextField JTFNombre;
	private JTextField JTFApellido;
	private JTextField textField_2;
	private final JPanel JpanelMedico = new JPanel();
	private final JTextField JTFNombreMedico = new JTextField();
	private final JLabel lblNombre = new JLabel("Nombre");
	private final JLabel lblApellido_1 = new JLabel("Apellido");
	private final JTextField JTFApellidoMedico = new JTextField();
}

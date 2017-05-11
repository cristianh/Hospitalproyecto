package eam.desarollo.hospital.vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Label;
import java.awt.TextField;

import com.mysql.jdbc.DatabaseMetaData;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;


import eam.desarrollo.hospital.DAO.*;
import eam.desarrollo.hospital.controladores.controladorPaciente;
import eam.desarrollo.hospital.entidades.Departamento;
import eam.desarrollo.hospital.entidades.Genero;
import eam.desarrollo.hospital.entidades.Municipio;
import eam.desarrollo.hospital.entidades.Paciente;
import eam.desarrollo.hospital.entidades.Tipodocumento;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaPacientes  {
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPacientes ventanapaciente = new VentanaPacientes();
					ventanapaciente.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPacientes() {
		initialize();
		//Revisiando que el brach funciona.
		micontroladorpaciente =  new controladorPaciente(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 592, 391);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPacientes = new JLabel("Ventana Pacientes");
		lblPacientes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPacientes.setBounds(216, 11, 148, 22);
		frame.getContentPane().add(lblPacientes);
		
		JLabel LbPaciente = new JLabel("Paciente No.");
		LbPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LbPaciente.setBounds(25, 67, 97, 17);
		frame.getContentPane().add(LbPaciente);
		
		JTFIdPaciente = new JTextField();
		JTFIdPaciente.setBounds(116, 67, 97, 22);
		frame.getContentPane().add(JTFIdPaciente);
		JTFIdPaciente.setColumns(10);
		
		JTFNombrePaciente = new JTextField();
		JTFNombrePaciente.setBounds(94, 106, 148, 22);
		frame.getContentPane().add(JTFNombrePaciente);
		JTFNombrePaciente.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(25, 107, 59, 16);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido.setBounds(252, 104, 59, 22);
		frame.getContentPane().add(lblApellido);
		
		JTFApellidoPaciente = new JTextField();
		JTFApellidoPaciente.setBounds(307, 107, 178, 20);
		frame.getContentPane().add(JTFApellidoPaciente);
		JTFApellidoPaciente.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDireccion.setBounds(25, 140, 59, 17);
		frame.getContentPane().add(lblDireccion);
		
		JTFDireccionPaciente = new JTextField();
		JTFDireccionPaciente.setBounds(94, 139, 148, 22);
		frame.getContentPane().add(JTFDireccionPaciente);
		JTFDireccionPaciente.setColumns(10);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaNacimiento.setBounds(250, 141, 114, 14);
		frame.getContentPane().add(lblFechaNacimiento);
		
		Label LbTelefono = new Label("Telefono");
		LbTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LbTelefono.setBounds(25, 173, 62, 22);
		frame.getContentPane().add(LbTelefono);
		
		JTFTelefonoPaciente = new JTextField();
		JTFTelefonoPaciente.setBounds(94, 172, 148, 20);
		frame.getContentPane().add(JTFTelefonoPaciente);
		JTFTelefonoPaciente.setColumns(10);
		
		//JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(363, 141, 122, 20);
		frame.getContentPane().add(dateChooser);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPeso.setBounds(252, 171, 46, 17);
		frame.getContentPane().add(lblPeso);
		
		JTFPesoPaciente = new JTextField();
		JTFPesoPaciente.setBounds(307, 171, 178, 20);
		frame.getContentPane().add(JTFPesoPaciente);
		JTFPesoPaciente.setColumns(10);
		
		JLabel lblTipoDocumento = new JLabel("Tipo documento");
		lblTipoDocumento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipoDocumento.setBounds(25, 201, 114, 17);
		frame.getContentPane().add(lblTipoDocumento);
		
		//JComboBox JCBTipoDocumentoPaciente = new JComboBox();
		JCBTipoDocumentoPaciente.setBounds(132, 201, 110, 20);
		frame.getContentPane().add(JCBTipoDocumentoPaciente);
		JCBTipoDocumentoPaciente.addItem("SELECCIONE");

		JLabel lblNumeroDocumento = new JLabel("Numero Documento");
		lblNumeroDocumento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumeroDocumento.setBounds(252, 204, 132, 14);
		frame.getContentPane().add(lblNumeroDocumento);
		
		JTFNumeroDocumentoPaciente = new JTextField();
		JTFNumeroDocumentoPaciente.setBounds(380, 201, 105, 20);
		frame.getContentPane().add(JTFNumeroDocumentoPaciente);
		JTFNumeroDocumentoPaciente.setColumns(10);
		
		JLabel lblMunicipio = new JLabel("Municipio");
		lblMunicipio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMunicipio.setBounds(25, 229, 59, 14);
		frame.getContentPane().add(lblMunicipio);
		
		//JComboBox JCBMunicipioPaciente = new JComboBox();
		JCBMunicipioPaciente.setBounds(94, 228, 148, 20);
		frame.getContentPane().add(JCBMunicipioPaciente);
		JCBMunicipioPaciente.addItem("SELECCIONE");		
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGenero.setBounds(252, 231, 46, 14);
		frame.getContentPane().add(lblGenero);
		
		//JComboBox JCBGeneroPaciente = new JComboBox();
		JCBGeneroPaciente.setBounds(307, 228, 130, 29);
		frame.getContentPane().add(JCBGeneroPaciente);
		JCBGeneroPaciente.addItem("SELECCIONE");
		
		
		//JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setBounds(10, 281, 130, 29);
		frame.getContentPane().add(btnRegistrar);
		
		//JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(160, 281, 130, 29);
		frame.getContentPane().add(btnBuscar);
		
		//JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(300, 281, 130, 29);
		frame.getContentPane().add(btnEliminar);
		
		//JButton btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setBounds(440, 281, 130, 29);
		frame.getContentPane().add(btnActualizar);
		
	}	

	private JFrame frame;
	public JTextField JTFIdPaciente;
	public JTextField JTFNombrePaciente;
	public JTextField JTFApellidoPaciente;
	public JTextField JTFDireccionPaciente;
	public JTextField JTFTelefonoPaciente;
	public JTextField JTFPesoPaciente;
	public JTextField JTFNumeroDocumentoPaciente;
	public JComboBox<String> JCBTipoDocumentoPaciente = new JComboBox<String>();
	public JComboBox<String> JCBGeneroPaciente =  new JComboBox<String>();
	public JComboBox<String> JCBMunicipioPaciente= new JComboBox<String>();
	public JDateChooser dateChooser= new JDateChooser();
	public JButton btnRegistrar= new JButton("REGISTRAR");
	public JButton btnBuscar= new JButton("BUSCAR");
	public JButton btnEliminar = new JButton("ELIMINAR");
	public JButton btnActualizar = new JButton("ACTUALIZAR");
	public static controladorPaciente micontroladorpaciente;
}

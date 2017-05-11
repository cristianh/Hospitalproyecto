package eam.desarrollo.hospital.controladores;

import java.awt.Color;
import java.awt.KeyEventDispatcher;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.peer.KeyboardFocusManagerPeer;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

import eam.desarollo.hospital.vistas.VentanaPacientes;
import eam.desarrollo.hospital.DAO.DAOPaciente;
import eam.desarrollo.hospital.entidades.Genero;
import eam.desarrollo.hospital.entidades.Municipio;
import eam.desarrollo.hospital.entidades.Paciente;
import eam.desarrollo.hospital.entidades.Tipodocumento;

public class controladorPaciente implements ActionListener {
	public VentanaPacientes ventanapaciente;
	public Paciente nuevo_paciente = null;
	public DAOPaciente Midao = new DAOPaciente();
	public ArrayList<Tipodocumento> listaDoc;
	public ArrayList<Genero> listaGene;
	public ArrayList<Municipio> listaMunici;

	public static void main(String[] args) {

	}

	public controladorPaciente(VentanaPacientes venpaciente) {
		// TODO Auto-generated constructor stub
		this.ventanapaciente = venpaciente;
		listarTipoDocumento();
		listarGenero();
		listarMunicipio();
		listenerbotones();

		// this.ventanapaciente.dolares.addActionListener(this);
	}

	private void listenerbotones() {
		// TODO Auto-generated method stub
		try {
			this.ventanapaciente.btnRegistrar.addActionListener(this);
			this.ventanapaciente.btnBuscar.addActionListener(this);
			this.ventanapaciente.btnEliminar.addActionListener(this);
			this.ventanapaciente.btnActualizar.addActionListener(this);
			Solo_letras(this.ventanapaciente.JTFApellidoPaciente);
			Solo_letras(this.ventanapaciente.JTFNombrePaciente);
			Solo_letras(this.ventanapaciente.JTFDireccionPaciente);
			Solo_numeros(this.ventanapaciente.JTFNumeroDocumentoPaciente);
			Solo_numeros(this.ventanapaciente.JTFIdPaciente);
			Solo_numeros(this.ventanapaciente.JTFPesoPaciente);
			Solo_numeros(this.ventanapaciente.JTFTelefonoPaciente);

			validarVacio(this.ventanapaciente.JTFApellidoPaciente);
			validarVacio(this.ventanapaciente.JTFNombrePaciente);
			validarVacio(this.ventanapaciente.JTFDireccionPaciente);
			validarVacio(this.ventanapaciente.JTFNumeroDocumentoPaciente);
			validarVacio(this.ventanapaciente.JTFIdPaciente);
			validarVacio(this.ventanapaciente.JTFPesoPaciente);
			validarVacio(this.ventanapaciente.JTFTelefonoPaciente);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void CargarformularioPaciente(Paciente miPaciente) {
		try {
			this.ventanapaciente.JTFIdPaciente.setText(miPaciente.getIdPaciente());
			this.ventanapaciente.JTFNombrePaciente.setText(miPaciente.getNombrePaciente());
			this.ventanapaciente.JTFApellidoPaciente.setText(miPaciente.getApellidoPaciente());
			this.ventanapaciente.JTFDireccionPaciente.setText(miPaciente.getDireccionPaciente());
			this.ventanapaciente.JTFPesoPaciente.setText(Float.toString(miPaciente.getPesoPaciente()));
			this.ventanapaciente.JTFNumeroDocumentoPaciente.setText(miPaciente.getNumeroDocumentoPaciente());
			this.ventanapaciente.JTFTelefonoPaciente.setText(miPaciente.getTelefonoPaciente());
			System.out.println(Integer.parseInt(miPaciente.getTipodocumento().getIdTipoDocumento()));
		} catch (Exception e) {
			System.out.println("Mensaje" + e.getLocalizedMessage());
		}
	}

	public void Limpiarformulario() {
		this.ventanapaciente.JTFIdPaciente.setText("");
		this.ventanapaciente.JTFNombrePaciente.setText("");
		this.ventanapaciente.JTFApellidoPaciente.setText("");
		this.ventanapaciente.JTFDireccionPaciente.setText("");
		this.ventanapaciente.JTFPesoPaciente.setText("");
		this.ventanapaciente.JTFNumeroDocumentoPaciente.setText("");
		this.ventanapaciente.JTFTelefonoPaciente.setText("");
	}

	public boolean verificarformulario() {
		 if(this.ventanapaciente.JTFNumeroDocumentoPaciente.getText().toString().length()<10){
			 JOptionPane.showMessageDialog(null, "El numero de documento es muy corto por favor verifiquelo", "Info",
						JOptionPane.INFORMATION_MESSAGE);
			 return false;
		 }
		 else if(this.ventanapaciente.JTFTelefonoPaciente.getText().toString().length()<7){
			 JOptionPane.showMessageDialog(null, "El numero de telefono es muy corto por favor verifiquelo", "Info",
						JOptionPane.INFORMATION_MESSAGE);
			 return false;
		 }else
		 {
			 return true; 
		 }
	}

	public boolean verificarCombo() {
		String selectedValue1 = this.ventanapaciente.JCBGeneroPaciente.getSelectedItem().toString();
		String selectedValue2 = this.ventanapaciente.JCBMunicipioPaciente.getSelectedItem().toString();
		String selectedValue3 = this.ventanapaciente.JCBTipoDocumentoPaciente.getSelectedItem().toString();

		try {

			if (selectedValue1 != "SELECCIONE" && selectedValue2 != "SELECCIONE" && selectedValue3 != "SELECCIONE") {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Mensaje" + e.getMessage());
		}

		return false;
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub
		// micontroladorpaciente.crearPaciente();
		System.out.println(evento.getActionCommand());
		switch (evento.getActionCommand()) {
		case "REGISTRAR":
			if (verificarformulario() && verificarCombo()) {
				String index = ventanapaciente.JCBTipoDocumentoPaciente.getSelectedItem().toString();

				// Tipo Documento
				String tipo_documento = Integer.toString(ventanapaciente.JCBTipoDocumentoPaciente.getSelectedIndex());

				// Municipio variables

				String nombreMunicipio = Integer.toString(ventanapaciente.JCBMunicipioPaciente.getSelectedIndex());

				// Genero Variables

				String tipo = Integer.toString(ventanapaciente.JCBTipoDocumentoPaciente.getSelectedIndex());

				// Departamento departamento = new
				// Departamento(idDepartamento,nombreDepartamento);

				String idPaciente = ventanapaciente.JTFIdPaciente.getText();
				String nombrePaciente = ventanapaciente.JTFNombrePaciente.getText();
				String apellidoPaciente = ventanapaciente.JTFApellidoPaciente.getText();
				String direccionPaciente = ventanapaciente.JTFDireccionPaciente.getText();
				Date fechaNacimientoPaciente = ventanapaciente.dateChooser.getDate();
				String telefonoPaciente = ventanapaciente.JTFTelefonoPaciente.getText();
				Float pesoPaciente = Float.parseFloat(ventanapaciente.JTFPesoPaciente.getText());
				String numeroDocumentoPaciente = ventanapaciente.JTFNumeroDocumentoPaciente.getText();
				Tipodocumento tipodocumento = new Tipodocumento(
						Integer.toString(ventanapaciente.JCBTipoDocumentoPaciente.getSelectedIndex()),
						ventanapaciente.JCBTipoDocumentoPaciente.getSelectedItem().toString());
				Municipio municipio = new Municipio(
						Integer.toString(ventanapaciente.JCBMunicipioPaciente.getSelectedIndex()),
						ventanapaciente.JCBMunicipioPaciente.getSelectedItem().toString());
				Genero genero = new Genero(Integer.toString(ventanapaciente.JCBGeneroPaciente.getSelectedIndex()),
						ventanapaciente.JCBGeneroPaciente.getSelectedItem().toString());
				nuevo_paciente = new Paciente(idPaciente, nombrePaciente, apellidoPaciente, direccionPaciente,
						fechaNacimientoPaciente, telefonoPaciente, pesoPaciente, numeroDocumentoPaciente, tipodocumento,
						municipio, genero);
				System.out.println(nuevo_paciente.getNombrePaciente());
				try {
					Midao.crear(nuevo_paciente);
				} catch (Exception e1) {

				}
				ventanapaciente.JCBGeneroPaciente.setSelectedIndex(0);
				ventanapaciente.JCBMunicipioPaciente.setSelectedIndex(0);
				ventanapaciente.JCBTipoDocumentoPaciente.setSelectedIndex(0);
				((JTextField) ventanapaciente.dateChooser.getDateEditor().getUiComponent()).setText("");
				// ventanapaciente.dateChooser.setDate(null);
				Limpiarformulario();
			} 

			break;
		case "BUSCAR":
			try {
				nuevo_paciente = Midao.buscar(ventanapaciente.JTFNumeroDocumentoPaciente.getText());
				if (nuevo_paciente != null) {
					ventanapaciente.JCBGeneroPaciente
							.setSelectedIndex(Integer.parseInt(nuevo_paciente.getTipodocumento().getIdTipoDocumento()));
					ventanapaciente.JCBMunicipioPaciente
							.setSelectedIndex(Integer.parseInt(nuevo_paciente.getMunicipio().getIdMunicipio()));
					ventanapaciente.JCBTipoDocumentoPaciente
							.setSelectedIndex(Integer.parseInt(nuevo_paciente.getTipodocumento().getIdTipoDocumento()));
					ventanapaciente.dateChooser.setDate(nuevo_paciente.getFechaNacimientoPaciente());
					CargarformularioPaciente(nuevo_paciente);
					JOptionPane.showMessageDialog(null, "Usuario encontrado", "Info", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			break;
		case "ELIMINAR":
			try {
				Midao.eliminar(ventanapaciente.JTFNumeroDocumentoPaciente.getText());
				ventanapaciente.JCBGeneroPaciente.setSelectedIndex(0);
				ventanapaciente.JCBMunicipioPaciente.setSelectedIndex(0);
				ventanapaciente.JCBTipoDocumentoPaciente.setSelectedIndex(0);
				((JTextField) ventanapaciente.dateChooser.getDateEditor().getUiComponent()).setText("");

				Limpiarformulario();
				JOptionPane.showMessageDialog(null, "Usuario eliminado", "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		case "ACTUALIZAR":
			String idPaciente = ventanapaciente.JTFIdPaciente.getText();
			String nombrePaciente = ventanapaciente.JTFNombrePaciente.getText();
			String apellidoPaciente = ventanapaciente.JTFApellidoPaciente.getText();
			String direccionPaciente = ventanapaciente.JTFDireccionPaciente.getText();
			Date fechaNacimientoPaciente = ventanapaciente.dateChooser.getDate();
			String telefonoPaciente = ventanapaciente.JTFTelefonoPaciente.getText();
			Float pesoPaciente = Float.parseFloat(ventanapaciente.JTFPesoPaciente.getText());
			String numeroDocumentoPaciente = ventanapaciente.JTFNumeroDocumentoPaciente.getText();
			Tipodocumento tipodocumento = new Tipodocumento(
					Integer.toString(ventanapaciente.JCBTipoDocumentoPaciente.getSelectedIndex()),
					ventanapaciente.JCBTipoDocumentoPaciente.getSelectedItem().toString());
			Municipio municipio = new Municipio(
					Integer.toString(ventanapaciente.JCBMunicipioPaciente.getSelectedIndex()),
					ventanapaciente.JCBMunicipioPaciente.getSelectedItem().toString());
			Genero genero = new Genero(Integer.toString(ventanapaciente.JCBGeneroPaciente.getSelectedIndex()),
					ventanapaciente.JCBGeneroPaciente.getSelectedItem().toString());
			nuevo_paciente = new Paciente(idPaciente, nombrePaciente, apellidoPaciente, direccionPaciente,
					fechaNacimientoPaciente, telefonoPaciente, pesoPaciente, numeroDocumentoPaciente, tipodocumento,
					municipio, genero);
			try {
				Midao.actualizar(nuevo_paciente);
				ventanapaciente.JCBGeneroPaciente.setSelectedIndex(0);
				ventanapaciente.JCBMunicipioPaciente.setSelectedIndex(0);
				ventanapaciente.JCBTipoDocumentoPaciente.setSelectedIndex(0);
				((JTextField) ventanapaciente.dateChooser.getDateEditor().getUiComponent()).setText("");
				Limpiarformulario();
				JOptionPane.showMessageDialog(null, "Usuario actualizado", "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

		}
	}

	public void listarTipoDocumento() {
		listaDoc = Midao.listarDocumento();
		System.out.println(listaDoc);
		for (int i = 0; i < listaDoc.size(); i++) {
			String item = listaDoc.get(i).getTipoDocumento();
			ventanapaciente.JCBTipoDocumentoPaciente.addItem(item);
		}
	}

	public void listarGenero() {
		listaGene = Midao.listarGenero();
		for (int i = 0; i < listaGene.size(); i++) {
			String item = listaGene.get(i).getTipo();
			ventanapaciente.JCBGeneroPaciente.addItem(item);
		}
	}

	public void listarMunicipio() {
		listaMunici = Midao.listarMunicipio();
		for (int i = 0; i < listaMunici.size(); i++) {
			String item = listaMunici.get(i).getNombreMunicipio();
			ventanapaciente.JCBMunicipioPaciente.addItem(item);
		}
	}

	public Boolean validaremail(String email) {
		String pattheremail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		// Compiles the given regular expression into a pattern.
		Pattern pattern = Pattern.compile(pattheremail);

		// Match the given input against this pattern
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public void Solo_letras(JTextField input) {
		input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println(input.getName());
				char c = e.getKeyChar();
				if (Character.isDigit(c)) {
					e.consume();
				}
			}
		});
	}

	public void Solo_numeros(JTextField input) {
		input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
				
				/*if(e.getComponent()){
					
				}*/
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
	}

	public void validarVacio(JTextField inputpresholder) {
		inputpresholder.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				
				if (inputpresholder.getText().equals("Falta este campo")) {
					inputpresholder.setText("");
				}
				else
				{
					Border border = BorderFactory.createLineBorder(Color.GRAY);
					inputpresholder.setBorder(border);
					inputpresholder.setForeground(Color.BLACK);
					
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (inputpresholder.getText().isEmpty() || inputpresholder.getText().equals("")) {
					Border border = BorderFactory.createLineBorder(Color.RED);
					inputpresholder.setForeground(Color.RED);
					inputpresholder.setBorder(border);
					inputpresholder.setForeground(Color.RED);
					inputpresholder.setText("Falta este campo");
				} else {
					Border border = BorderFactory.createLineBorder(Color.GRAY);
					inputpresholder.setBorder(border);
					inputpresholder.setForeground(Color.BLACK);
				}
			}
		});

	}

}

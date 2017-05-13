package eam.desarrollo.hospital.controladores;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

import eam.desarollo.hospital.vistas.VentanaMedico;
import eam.desarrollo.hospital.DAO.DAOMedico;
import eam.desarrollo.hospital.entidades.Genero;
import eam.desarrollo.hospital.entidades.Medico;
import eam.desarrollo.hospital.entidades.Municipio;
import eam.desarrollo.hospital.entidades.Medico;
import eam.desarrollo.hospital.entidades.Tipodocumento;

public class controladorMedico  implements ActionListener{

	public VentanaMedico ventanamedico;
	public Medico nuevo_medico = null;
	public DAOMedico Midao = new DAOMedico();
	public ArrayList<Tipodocumento> listaDoc;
	public ArrayList<Medico> listaMedico;
	
	
	public controladorMedico(VentanaMedico ventanamedico) {
		super();
		this.ventanamedico = ventanamedico;
		listenerbotones();
		listarTipoDocumento();
	}



	private void listenerbotones() {
		// TODO Auto-generated method stub
		this.ventanamedico.btnRegistrar.addActionListener(this);
		this.ventanamedico.btnBuscar.addActionListener(this);
		this.ventanamedico.btnEliminar.addActionListener(this);
		this.ventanamedico.btnActualizar.addActionListener(this);
		Solo_letras(this.ventanamedico.JTFNombremedico);
		Solo_letras(this.ventanamedico.JTFApellidomedico);
		
		
		Solo_numeros(this.ventanamedico.JTFIdmedico);
		Solo_numeros(this.ventanamedico.JTFNumerodocumento);
		Solo_numeros(this.ventanamedico.JTFTelefonoemergencia);
		Solo_numeros(this.ventanamedico.JTFTelefonomedico);
		
		validarVacio(ventanamedico.JTFIdmedico);
		validarVacio(ventanamedico.JTFNombremedico);
		validarVacio(ventanamedico.JTFApellidomedico);
		validarVacio(ventanamedico.JTFDireccionmedico);
		validarVacio(ventanamedico.JTFNumerodocumento);
		validarVacio(ventanamedico.JTFTelefonoemergencia);
		validarVacio(ventanamedico.JTFTelefonomedico);
		validarVacio(ventanamedico.JTFEmailmedico);
		
		validaremail(ventanamedico.JTFEmailmedico.getText());
	}
	
	public void CargarformularioMedico(Medico medico) {
		try {
			this.ventanamedico.JTFIdmedico.setText(medico.getIdMedico());
			this.ventanamedico.JTFNombremedico.setText(medico.getNombreMedico());
			this.ventanamedico.JTFApellidomedico.setText(medico.getApellidoMedico());
			this.ventanamedico.JTFDireccionmedico.setText(medico.getDireccionMedico());
			this.ventanamedico.JTFNumerodocumento.setText(medico.getNumeroDocumentoMedico());
			this.ventanamedico.JTFTelefonoemergencia.setText(medico.getTelefonoEmergenciaMedico());
			this.ventanamedico.JTFTelefonomedico.setText(medico.getTelefonoMedico());
			this.ventanamedico.JTFEmailmedico.setText(medico.getEmailMedico());
		} catch (Exception e) {
			System.out.println("Mensaje" + e.getLocalizedMessage());
		}
	}
	
	public void Limpiarformulario() {
		this.ventanamedico.JTFIdmedico.setText("");
		this.ventanamedico.JTFNombremedico.setText("");
		this.ventanamedico.JTFApellidomedico.setText("");
		this.ventanamedico.JTFDireccionmedico.setText("");
		this.ventanamedico.JTFNumerodocumento.setText("");
		this.ventanamedico.JTFTelefonoemergencia.setText("");
		this.ventanamedico.JTFTelefonomedico.setText("");
		this.ventanamedico.JTFEmailmedico.setText("");
		this.ventanamedico.JCBTipodocumentomedico.setSelectedIndex(0);
		((JTextField) this.ventanamedico.dateChooser.getDateEditor().getUiComponent()).setText("");
	}
	
	public boolean verificarformulario() {
		 if(this.ventanamedico.JTFNumerodocumento.getText().toString().length()<10){
			 JOptionPane.showMessageDialog(null, "El numero de documento es muy corto por favor verifiquelo", "Info",
						JOptionPane.INFORMATION_MESSAGE);
			 return false;
		 }
		 else if(this.ventanamedico.JTFTelefonomedico.getText().toString().length()<7){
			 JOptionPane.showMessageDialog(null, "El numero de telefono es muy corto por favor verifiquelo", "Info",
						JOptionPane.INFORMATION_MESSAGE);
			 return false;
		 }else
		 {
			 return true; 
		 }
	}
	
	public boolean verificarCombo() {
		String selectedValue1 = this.ventanamedico.JCBTipodocumentomedico.getSelectedItem().toString();
		

		try {

			if (selectedValue1 != "SELECCIONE") {
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
		switch (evento.getActionCommand()) {
		case "REGISTRAR":
			if (verificarformulario() && verificarCombo()) {
				String idmedico = ventanamedico.JTFIdmedico.getText();
				String nombreMedico = ventanamedico.JTFNombremedico.getText();
				String apellidoMedico = ventanamedico.JTFApellidomedico.getText();
				String direccionMedico = ventanamedico.JTFDireccionmedico.getText();
				Date fechaNacimientoMedico = ventanamedico.dateChooser.getDate();
				String telefonoMedico = ventanamedico.JTFTelefonomedico.getText();
				String telefonoEmergenciaMedico = ventanamedico.JTFTelefonoemergencia.getText();
				String emailMedico = ventanamedico.JTFEmailmedico.getText();
				String numeroDocumentoMedico = ventanamedico.JTFNumerodocumento.getText();
				Tipodocumento tipodocumento = new Tipodocumento(
						Integer.toString(ventanamedico.JCBTipodocumentomedico.getSelectedIndex()),
						ventanamedico.JCBTipodocumentomedico.getSelectedItem().toString());
				nuevo_medico = new Medico(idmedico, nombreMedico, apellidoMedico, telefonoMedico, direccionMedico, emailMedico, telefonoEmergenciaMedico, fechaNacimientoMedico, numeroDocumentoMedico, tipodocumento);
				
				try {
					Midao.crear(nuevo_medico);
				} catch (Exception e1) {

				}
				Limpiarformulario();
			} 

			break;
		case "BUSCAR":
			try {
				nuevo_medico = Midao.buscar(ventanamedico.JTFNumerodocumento.getText());
				if (nuevo_medico != null) {
					ventanamedico.JCBTipodocumentomedico
							.setSelectedIndex(Integer.parseInt(nuevo_medico.getTipodocumento().getIdTipoDocumento()));
					ventanamedico.dateChooser.setDate(nuevo_medico.getFechaNacimientoMedico());
					CargarformularioMedico(nuevo_medico);
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
				Midao.eliminar(ventanamedico.JTFIdmedico.getText());
				Limpiarformulario();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		case "ACTUALIZAR":
			String idmedico = ventanamedico.JTFIdmedico.getText();
			String nombreMedico = ventanamedico.JTFNombremedico.getText();
			String apellidoMedico = ventanamedico.JTFApellidomedico.getText();
			String direccionMedico = ventanamedico.JTFDireccionmedico.getText();
			Date fechaNacimientoMedico = ventanamedico.dateChooser.getDate();
			String telefonoMedico = ventanamedico.JTFTelefonomedico.getText();
			String telefonoEmergenciaMedico = ventanamedico.JTFTelefonoemergencia.getText();
			String emailMedico = ventanamedico.JTFEmailmedico.getText();
			String numeroDocumentoMedico = ventanamedico.JTFNumerodocumento.getText();
			Tipodocumento tipodocumento = new Tipodocumento(
					Integer.toString(ventanamedico.JCBTipodocumentomedico.getSelectedIndex()),
					ventanamedico.JCBTipodocumentomedico.getSelectedItem().toString());
			nuevo_medico = new Medico(idmedico, nombreMedico, apellidoMedico, telefonoMedico, direccionMedico, emailMedico, telefonoEmergenciaMedico, fechaNacimientoMedico, numeroDocumentoMedico, tipodocumento);
			try {
				Midao.actualizar(nuevo_medico);
				Limpiarformulario();
				JOptionPane.showMessageDialog(null, "Usuario actualizado", "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;

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
	
	public void listarTipoDocumento() {
		listaDoc = Midao.listarDocumento();
		System.out.println(listaDoc);
		for (int i = 0; i < listaDoc.size(); i++) {
			String item = listaDoc.get(i).getTipoDocumento();
			ventanamedico.JCBTipodocumentomedico.addItem(item);
		}
	}

}

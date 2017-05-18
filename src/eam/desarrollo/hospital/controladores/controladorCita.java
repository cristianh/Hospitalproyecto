package eam.desarrollo.hospital.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import eam.desarollo.hospital.vistas.VentanaCita;
import eam.desarrollo.hospital.DAO.DAOCita;
import eam.desarrollo.hospital.DAO.DAOConsultorio;
import eam.desarrollo.hospital.DAO.DAOEstadoCita;
import eam.desarrollo.hospital.DAO.DAOMedico;
import eam.desarrollo.hospital.DAO.DAOPaciente;
import eam.desarrollo.hospital.DAO.DAOTipoCita;
import eam.desarrollo.hospital.entidades.Cita;
import eam.desarrollo.hospital.entidades.Consultorio;
import eam.desarrollo.hospital.entidades.EstadoCita;
import eam.desarrollo.hospital.entidades.EstadoConsultorio;
import eam.desarrollo.hospital.entidades.Genero;
import eam.desarrollo.hospital.entidades.Medico;
import eam.desarrollo.hospital.entidades.Municipio;
import eam.desarrollo.hospital.entidades.Paciente;
import eam.desarrollo.hospital.entidades.TipoCita;
import eam.desarrollo.hospital.entidades.Tipodocumento;

public class controladorCita implements ActionListener{
	public VentanaCita ventanacita;
	public Cita nuevo_cita = null;
	public DAOCita Midao = new DAOCita();
	public DAOPaciente MidaoPaciente = new DAOPaciente();
	public DAOMedico MidaoMedico = new DAOMedico();
	public DAOTipoCita MidaoTipoCita = new DAOTipoCita();
	public DAOEstadoCita MidaoEstadoCita = new DAOEstadoCita();
	public DAOConsultorio MidaoConsultorio = new DAOConsultorio();
	public ArrayList<TipoCita> listartipoCita;
	public ArrayList<EstadoCita> listarEstadoCita;
	public ArrayList<Consultorio> listarConsultorio;
	
	
	
	/**
	 * 
	 * @param ventanacita
	 */
	public controladorCita(VentanaCita ventanacita) {
		this.ventanacita = ventanacita;
		listarTipoCita();
		listarEstadoCita();
		listarConsultorios();
	}
	
	private void listenerbotones() {
		// TODO Auto-generated method stub
		try {
			this.ventanacita.btnRegistrar.addActionListener(this);
			this.ventanacita.btnBuscar.addActionListener(this);
			this.ventanacita.btnEliminar.addActionListener(this);
			this.ventanacita.btnActualizar.addActionListener(this);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}




	@Override
	public void actionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub
		switch (evento.getActionCommand()) {
		case "REGISTRAR":
			if (verificarformulario() && verificarCombo()) {
				String idCita = ventanacita.JTFIdcita.getText();
				String tipocita = (String) ventanacita.JCBTipo.getSelectedItem();
				String IdPaciente = ventanacita.JTFPaciente.getText();
				String IdEstadoCita = (String) ventanacita.JCBEstado.getSelectedItem();
				String IdConsultorio = (String) ventanacita.JCBConsultorio.getSelectedItem();
				String IdMedico = (String) ventanacita.JTFIdMedico.getText();
				Date fechaCita = ventanacita.Fecha.getDate(); 
				
				try {
					Paciente paciente = MidaoPaciente.buscar(IdPaciente);
					Medico medico = MidaoMedico.buscar(IdMedico);
					TipoCita tipocitaob = MidaoTipoCita.buscar(tipocita);
					EstadoCita estadocita = MidaoEstadoCita.buscar(IdEstadoCita);
					Consultorio consultorio = MidaoConsultorio.buscar(IdConsultorio);
					nuevo_cita = new Cita(idCita,fechaCita,paciente,tipocitaob,estadocita,consultorio,medico);
					Midao.crear(nuevo_cita);
				} catch (Exception e) {
					// TODO: handle exception
				}
				Limpiarformulario();
			} 

			break;
		case "BUSCAR":
			
			break;
		case "ELIMINAR":
			

			break;
		case "ACTUALIZAR":
			

			break;

		}
	}
	
	public void CargarformularioCita(Cita cita) {
		try {
			this.ventanacita.JTFIdcita.setText(cita.getIdCita());
			this.ventanacita.JTFIdMedico.setText(cita.getMedico().getNombreMedico());
			this.ventanacita.JTFPaciente.setText(cita.getPaciente().getNombrePaciente());
			this.ventanacita.JCBConsultorio.setSelectedIndex(Integer.parseInt(cita.getConsultorio().getIdConsultario()));
			this.ventanacita.JCBTipo.setSelectedIndex(Integer.parseInt(cita.getTipoCita().getIdTipoCita()));
			this.ventanacita.JCBEstado.setSelectedIndex(Integer.parseInt(cita.getEstadoCita().getIdEstadoCita()));
			this.ventanacita.Fecha.setDate(cita.getFechaCita());
		} catch (Exception e) {
			System.out.println("Mensaje" + e.getLocalizedMessage());
		}
	}

	public void Limpiarformulario() {
		this.ventanacita.JTFIdcita.setText("");
		this.ventanacita.JTFIdMedico.setText("");
		this.ventanacita.JTFPaciente.setText("");
		this.ventanacita.JCBConsultorio.setSelectedIndex(0);
		this.ventanacita.JCBTipo.setSelectedIndex(0);
		this.ventanacita.JCBEstado.setSelectedIndex(0);
		((JTextField) this.ventanacita.Fecha.getDateEditor().getUiComponent()).setText("");
	}

	public boolean verificarformulario() {
		 if(this.ventanacita.JTFIdcita.getText().toString().length()<3){
			 JOptionPane.showMessageDialog(null, "El numero de documento es muy corto por favor verifiquelo", "Info",
						JOptionPane.INFORMATION_MESSAGE);
			 return false;
		 }
		 else if(this.ventanacita.JTFIdMedico.getText().toString().length()<2){
			 JOptionPane.showMessageDialog(null, "El numero de telefono es muy corto por favor verifiquelo", "Info",
						JOptionPane.INFORMATION_MESSAGE);
			 return false;
		 }else
		 {
			 return true; 
		 }
	}

	public boolean verificarCombo() {
		String selectedValue1 = this.ventanacita.JCBConsultorio.getSelectedItem().toString();
		String selectedValue2 = this.ventanacita.JCBTipo.getSelectedItem().toString();
		String selectedValue3 = this.ventanacita.JCBEstado.getSelectedItem().toString();

		try {

			if (selectedValue1 != "SELECCIONE" && selectedValue2 != "SELECCIONE" && selectedValue3 != "SELECCIONE") {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Mensaje" + e.getMessage());
		}

		return false;
	}
	
	public void listarTipoCita() {
		listartipoCita = MidaoTipoCita.listarTipocita();
		for (int i = 0; i < listartipoCita.size(); i++) {
			String item = listartipoCita.get(i).getDescripcionTipoCita();
			ventanacita.JCBTipo.addItem(item);
		}
	}
	
	public void listarEstadoCita() {
		listarEstadoCita = MidaoEstadoCita.listarEstadoCita();
		for (int i = 0; i < listarEstadoCita.size(); i++) {
			String item = listarEstadoCita.get(i).getDescripcionEstadoCita();
			ventanacita.JCBEstado.addItem(item);
		}
	}
	
	public void listarConsultorios() {
		listarConsultorio = MidaoConsultorio.listarConsultorioCita();
		for (int i = 0; i < listarConsultorio.size(); i++) {
			String item = listarConsultorio.get(i).getIdConsultario();
			ventanacita.JCBConsultorio.addItem(item);
		}
	}

}

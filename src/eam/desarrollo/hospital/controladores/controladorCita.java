package eam.desarrollo.hospital.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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

public class controladorCita implements ActionListener, MouseListener, ItemListener {
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
		listenerbotones();
		CargarTablaMedicosCita();
	}

	private void listenerbotones() {
		// TODO Auto-generated method stub
		try {
			this.ventanacita.btnRegistrar.addActionListener(this);
			this.ventanacita.btnBuscar.addActionListener(this);
			this.ventanacita.btnEliminar.addActionListener(this);
			this.ventanacita.btnActualizar.addActionListener(this);
			this.ventanacita.JCBTipo.addActionListener(this);
			this.ventanacita.btnBuscarPaciente.addActionListener(this);
		} catch (Exception e) {
			//System.out.println(e.getMessage());
		}
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub
		switch (evento.getActionCommand()) {
		case "Registrar":
			if (verificarformulario() && verificarCombo()) {
				try {
					String idCita = ventanacita.JTFIdcita.getText();
					String tipocita = (String) ventanacita.JCBTipo.getSelectedItem();
					String IdPaciente = ventanacita.JTFDocumentoPaciente.getText();
					String IdEstadoCita = (String) ventanacita.JCBEstado.getSelectedItem();
					String IdConsultorio = (String) ventanacita.JCBConsultorio.getSelectedItem();
					String IdMedico = (String) ventanacita.JTableMedicocita.getValueAt(
							ventanacita.JTableMedicocita.getSelectedRow(),
							ventanacita.JTableMedicocita.getSelectedColumn());
					Date fechaCita = ventanacita.Fecha.getDate();
					String HoraCita = ventanacita.JSPHora1.getValue().toString() + "-"
							+ ventanacita.JSPHora2.getValue().toString();
					//System.out.println("paciente nombre"+ paciente.getNombrePaciente());
					//System.out.println("Hora cita" + HoraCita);
					//System.out.println(idCita);
					//System.out.println("tipocita" +" " +tipocita);
					//System.out.println("IdPaciente"+ IdPaciente);
					//System.out.println("IdMedico"+ IdMedico);
					
					//Creamos los objetos
					//Paciente paciente = MidaoPaciente.buscar(IdPaciente);
					
					Medico medico = MidaoMedico.buscar(IdMedico);
					System.out.println(medico);
					/*TipoCita tipocitaob = MidaoTipoCita.buscar(tipocita);
					EstadoCita estadocita = MidaoEstadoCita.buscar(IdEstadoCita);
					Consultorio consultorio = MidaoConsultorio.buscar(IdConsultorio);
					nuevo_cita = new Cita(idCita, fechaCita, HoraCita, paciente, tipocitaob, estadocita, consultorio, medico);*/
					//Midao.crear(nuevo_cita);
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
		case "comboBoxChanged":
			//System.out.println(ventanacita.JCBTipo.getSelectedItem().toString());

			break;
		case "Buscar paciente":
			try {
				Paciente paciente = MidaoPaciente.buscar(ventanacita.JTFDocumentoPaciente.getText());
				ventanacita.JTFIdPaciente.setText(paciente.getIdPaciente());
				ventanacita.JTFNombre.setText(paciente.getNombrePaciente());
				ventanacita.JTFApellido.setText(paciente.getApellidoPaciente());
				// ventanacita.J.setText(paciente.getApellidoPaciente());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		}
	}

	public void CargarformularioCita(Cita cita) {
		try {
			this.ventanacita.JTFIdcita.setText(cita.getIdCita());
			// this.ventanacita.JTFIdMedico.setText(cita.getMedico().getNombreMedico());
			this.ventanacita.JTFIdPaciente.setText(cita.getPaciente().getNombrePaciente());
			this.ventanacita.JCBConsultorio
					.setSelectedIndex(Integer.parseInt(cita.getConsultorio().getIdConsultario()));
			this.ventanacita.JCBTipo.setSelectedIndex(Integer.parseInt(cita.getTipoCita().getIdTipoCita()));
			this.ventanacita.JCBEstado.setSelectedIndex(Integer.parseInt(cita.getEstadoCita().getIdEstadoCita()));
			this.ventanacita.Fecha.setDate(cita.getFechaCita());
		} catch (Exception e) {
			//System.out.println("Mensaje" + e.getLocalizedMessage());
		}
	}

	public void Limpiarformulario() {
		this.ventanacita.JTFIdcita.setText("");
		// this.ventanacita.JTFIdMedico.setText("");
		this.ventanacita.JCBConsultorio.setSelectedIndex(0);
		this.ventanacita.JCBTipo.setSelectedIndex(0);
		this.ventanacita.JCBEstado.setSelectedIndex(0);
		((JTextField) this.ventanacita.Fecha.getDateEditor().getUiComponent()).setText("");
	}

	public boolean verificarformulario() {
		/*if (this.ventanacita.JTFIdcita.getText().toString().length() < 3) {
			JOptionPane.showMessageDialog(null, "El numero de documento es muy corto por favor verifiquelo", "Info",
					JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else {
			
		}*/
		return true;
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
			//System.out.println("Mensaje" + e.getMessage());
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void itemStateChanged(ItemEvent event) {
		// TODO Auto-generated method stub
		//System.out.println(event.getStateChange());
		//System.out.println(ItemEvent.SELECTED);
		if (event.getStateChange() == ItemEvent.SELECTED) {
			Object item = event.getItem();
			// do something with object
		}

	}

	public void CargarTablaMedicosCita() {
		// TODO Auto-generated method stub
		DefaultTableModel TbmodelC = new DefaultTableModel();
		ventanacita.JTableMedicocita.setModel(TbmodelC);
		TbmodelC.setColumnIdentifiers(
				new Object[] { "Id medico","numero documento","nombre medico", "apellido medico", "telefono medico" });
		// ventanaconsultorio.JTBConsultorio.getColumnModel().getColumn(0).setCellRenderer(ventanaconsultorio.JTBConsultorio.getTableHeader().getDefaultRenderer());
		ResultSet consultoriotable = MidaoMedico.listarMedico();
		try {
			while (consultoriotable.next()) {
				try {
					TbmodelC.addRow(new Object[] { consultoriotable.getString("id_medico"),consultoriotable.getString("numero_documento_medico"),
							consultoriotable.getString("nombre_medico"), consultoriotable.getString("apellido_medico"),
							consultoriotable.getString("telefono_medico") });
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

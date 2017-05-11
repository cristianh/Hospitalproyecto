package eam.desarrollo.hospital.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import eam.desarollo.hospital.vistas.VentanaCita;
import eam.desarrollo.hospital.DAO.DAOCita;
import eam.desarrollo.hospital.DAO.DAOConsultorio;
import eam.desarrollo.hospital.entidades.Cita;

import eam.desarrollo.hospital.entidades.EstadoConsultorio;

public class controladorCita implements ActionListener{
	public VentanaCita ventanacita;
	public Cita nuevo_cita = null;
	public EstadoConsultorio estado_consultorio = null;
	public DAOCita Midao = new DAOCita();
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

/**
 * 
 */
package eam.desarrollo.hospital.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import eam.desarollo.hospital.vistas.VentanaAgenda;
import eam.desarollo.hospital.vistas.VentanaCita;
import eam.desarrollo.hospital.DAO.DAOCita;
import eam.desarrollo.hospital.DAO.DAOConsultorio;
import eam.desarrollo.hospital.DAO.DAOEstadoCita;
import eam.desarrollo.hospital.DAO.DAOMedico;
import eam.desarrollo.hospital.DAO.DAOPaciente;
import eam.desarrollo.hospital.DAO.DAOTipoCita;
import eam.desarrollo.hospital.entidades.Agenda;
import eam.desarrollo.hospital.entidades.Cita;
import eam.desarrollo.hospital.entidades.Consultorio;
import eam.desarrollo.hospital.entidades.EstadoCita;
import eam.desarrollo.hospital.entidades.Medico;
import eam.desarrollo.hospital.entidades.TipoCita;

/**
 * @author Casa1
 *
 */
public class controladorAgenda implements ActionListener, MouseListener, ItemListener {

	public VentanaAgenda ventanaagenda;
	public Agenda nueva_agenda = null;
	public DAOCita Midao = new DAOCita();
	public DAOPaciente MidaoPaciente = new DAOPaciente();
	public DAOMedico MidaoMedico = new DAOMedico();
	public DAOTipoCita MidaoTipoCita = new DAOTipoCita();
	public DAOEstadoCita MidaoEstadoCita = new DAOEstadoCita();
	public DAOConsultorio MidaoConsultorio = new DAOConsultorio();
	public ArrayList<TipoCita> listartipoCita;
	public ArrayList<EstadoCita> listarEstadoCita;
	public ArrayList<Consultorio> listarConsultorio;
	public Vector<Medico> listarMedicos;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

package eam.desarrollo.hospital.interfaces;

import eam.desarrollo.hospital.entidades.Medico;

public interface IntMedico {
	public abstract void crear(Medico medico) throws Exception;
	public abstract Medico buscar(String documentomedico) throws Exception;
	public abstract void eliminar(String documentomedico) throws Exception;
	public abstract void actualizar(Medico medico) throws Exception;
	public void listarMedico(Medico medico);
}
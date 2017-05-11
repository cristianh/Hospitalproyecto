package eam.desarrollo.hospital.interfaces;

import eam.desarrollo.hospital.entidades.Consultorio;

public interface IntConsultorio {
	public abstract void crear(Consultorio consultorio) throws Exception;
	public abstract Consultorio buscar(String identificacion) throws Exception;
	public abstract void eliminar(String id) throws Exception;
	public abstract void actualizar(Consultorio consultorio) throws Exception;
	public void listarConsultorio(Consultorio consultorio);
}

package eam.desarrollo.hospital.entidades;

import java.io.Serializable;

/**
 * Model class of habitacion.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class Habitacion implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** id_habitacion. */
	private String idHabitacion;

	/** descripcionHabitacion. */
	private String descripcionHabitacion;

	/** consultorio. */
	private Consultorio consultorio;



	

	public Habitacion(String idHabitacion, String descripcionHabitacion, Consultorio consultorio) {
		super();
		this.idHabitacion = idHabitacion;
		this.descripcionHabitacion = descripcionHabitacion;
		this.consultorio = consultorio;
	}

	/**
	 * Set the id_habitacion.
	 * 
	 * @param idHabitacion
	 *            id_habitacion
	 */
	public void setIdHabitacion(String idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	/**
	 * Get the id_habitacion.
	 * 
	 * @return id_habitacion
	 */
	public String getIdHabitacion() {
		return this.idHabitacion;
	}

	/**
	 * Set the cantidad_camas.
	 * 
	 * @param cantidadCamas
	 *            cantidad_camas
	 */
	
	/**
	 * Set the consultorio.
	 * 
	 * @param consultorio
	 *            consultorio
	 */
	public void setConsultorio(Consultorio consultorio) {
		this.consultorio = consultorio;
	}

	/**
	 * Get the consultorio.
	 * 
	 * @return consultorio
	 */
	public Consultorio getConsultorio() {
		return this.consultorio;
	}

	
	public String getDescripcionHabitacion() {
		return descripcionHabitacion;
	}

	public void setDescripcionHabitacion(String descripcionHabitacion) {
		this.descripcionHabitacion = descripcionHabitacion;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idHabitacion == null) ? 0 : idHabitacion.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Habitacion other = (Habitacion) obj;
		if (idHabitacion == null) {
			if (other.idHabitacion != null) {
				return false;
			}
		} else if (!idHabitacion.equals(other.idHabitacion)) {
			return false;
		}
		return true;
	}

}

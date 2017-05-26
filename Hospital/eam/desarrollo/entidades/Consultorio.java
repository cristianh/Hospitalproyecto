package eam.desarrollo.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Model class of consultorio.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class Consultorio implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** id_consultario. */
	private String idConsultario;

	/** descripcion_consultorio. */
	private String descripcionConsultorio;

	/** estado_consultorio. */
	private EstadoConsultorio estadoConsultorio;

	/** The set of cita. */
	private Set<Cita> citaSet;

	/** The set of habitacion. */
	private Set<Habitacion> habitacionSet;

	/**
	 * Constructor.
	 */
	public Consultorio() {
		this.citaSet = new HashSet<Cita>();
		this.habitacionSet = new HashSet<Habitacion>();
	}

	/**
	 * Set the id_consultario.
	 * 
	 * @param idConsultario
	 *            id_consultario
	 */
	public void setIdConsultario(String idConsultario) {
		this.idConsultario = idConsultario;
	}

	/**
	 * Get the id_consultario.
	 * 
	 * @return id_consultario
	 */
	public String getIdConsultario() {
		return this.idConsultario;
	}

	/**
	 * Set the descripcion_consultorio.
	 * 
	 * @param descripcionConsultorio
	 *            descripcion_consultorio
	 */
	public void setDescripcionConsultorio(String descripcionConsultorio) {
		this.descripcionConsultorio = descripcionConsultorio;
	}

	/**
	 * Get the descripcion_consultorio.
	 * 
	 * @return descripcion_consultorio
	 */
	public String getDescripcionConsultorio() {
		return this.descripcionConsultorio;
	}

	/**
	 * Set the estado_consultorio.
	 * 
	 * @param estadoConsultorio
	 *            estado_consultorio
	 */
	public void setEstadoConsultorio(EstadoConsultorio estadoConsultorio) {
		this.estadoConsultorio = estadoConsultorio;
	}

	/**
	 * Get the estado_consultorio.
	 * 
	 * @return estado_consultorio
	 */
	public EstadoConsultorio getEstadoConsultorio() {
		return this.estadoConsultorio;
	}

	/**
	 * Set the set of the cita.
	 * 
	 * @param citaSet
	 *            The set of cita
	 */
	public void setCitaSet(Set<Cita> citaSet) {
		this.citaSet = citaSet;
	}

	/**
	 * Add the cita.
	 * 
	 * @param cita
	 *            cita
	 */
	public void addCita(Cita cita) {
		this.citaSet.add(cita);
	}

	/**
	 * Get the set of the cita.
	 * 
	 * @return The set of cita
	 */
	public Set<Cita> getCitaSet() {
		return this.citaSet;
	}

	/**
	 * Set the set of the habitacion.
	 * 
	 * @param habitacionSet
	 *            The set of habitacion
	 */
	public void setHabitacionSet(Set<Habitacion> habitacionSet) {
		this.habitacionSet = habitacionSet;
	}

	/**
	 * Add the habitacion.
	 * 
	 * @param habitacion
	 *            habitacion
	 */
	public void addHabitacion(Habitacion habitacion) {
		this.habitacionSet.add(habitacion);
	}

	/**
	 * Get the set of the habitacion.
	 * 
	 * @return The set of habitacion
	 */
	public Set<Habitacion> getHabitacionSet() {
		return this.habitacionSet;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idConsultario == null) ? 0 : idConsultario.hashCode());
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
		Consultorio other = (Consultorio) obj;
		if (idConsultario == null) {
			if (other.idConsultario != null) {
				return false;
			}
		} else if (!idConsultario.equals(other.idConsultario)) {
			return false;
		}
		return true;
	}

}

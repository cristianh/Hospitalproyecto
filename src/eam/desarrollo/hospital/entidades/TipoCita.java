package eam.desarrollo.hospital.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Model class of tipo_cita.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class TipoCita implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** id_tipo_cita. */
	private String idTipoCita;

	/** descripcion_tipo_cita. */
	private String descripcionTipoCita;

	/** The set of cita. */
	private Set<Cita> citaSet;

	/**
	 * Constructor.
	 */
	public TipoCita() {
		this.citaSet = new HashSet<Cita>();
	}

	/**
	 * Set the id_tipo_cita.
	 * 
	 * @param idTipoCita
	 *            id_tipo_cita
	 */
	public void setIdTipoCita(String idTipoCita) {
		this.idTipoCita = idTipoCita;
	}

	/**
	 * Get the id_tipo_cita.
	 * 
	 * @return id_tipo_cita
	 */
	public String getIdTipoCita() {
		return this.idTipoCita;
	}

	/**
	 * Set the descripcion_tipo_cita.
	 * 
	 * @param descripcionTipoCita
	 *            descripcion_tipo_cita
	 */
	public void setDescripcionTipoCita(String descripcionTipoCita) {
		this.descripcionTipoCita = descripcionTipoCita;
	}

	/**
	 * Get the descripcion_tipo_cita.
	 * 
	 * @return descripcion_tipo_cita
	 */
	public String getDescripcionTipoCita() {
		return this.descripcionTipoCita;
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
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTipoCita == null) ? 0 : idTipoCita.hashCode());
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
		TipoCita other = (TipoCita) obj;
		if (idTipoCita == null) {
			if (other.idTipoCita != null) {
				return false;
			}
		} else if (!idTipoCita.equals(other.idTipoCita)) {
			return false;
		}
		return true;
	}

}

package eam.desarrollo.entidades;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 * Model class of entrada_paciente.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class EntradaPaciente implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** id_entrada_paciente. */
	private String idEntradaPaciente;

	/** fecha_entrada_paciente. */
	private Date fechaEntradaPaciente;

	/** hora_entrada_paciente. */
	private Time horaEntradaPaciente;

	/** paciente. */
	private Paciente paciente;

	/**
	 * Constructor.
	 */
	public EntradaPaciente() {
	}

	/**
	 * Set the id_entrada_paciente.
	 * 
	 * @param idEntradaPaciente
	 *            id_entrada_paciente
	 */
	public void setIdEntradaPaciente(String idEntradaPaciente) {
		this.idEntradaPaciente = idEntradaPaciente;
	}

	/**
	 * Get the id_entrada_paciente.
	 * 
	 * @return id_entrada_paciente
	 */
	public String getIdEntradaPaciente() {
		return this.idEntradaPaciente;
	}

	/**
	 * Set the fecha_entrada_paciente.
	 * 
	 * @param fechaEntradaPaciente
	 *            fecha_entrada_paciente
	 */
	public void setFechaEntradaPaciente(Date fechaEntradaPaciente) {
		this.fechaEntradaPaciente = fechaEntradaPaciente;
	}

	/**
	 * Get the fecha_entrada_paciente.
	 * 
	 * @return fecha_entrada_paciente
	 */
	public Date getFechaEntradaPaciente() {
		return this.fechaEntradaPaciente;
	}

	/**
	 * Set the hora_entrada_paciente.
	 * 
	 * @param horaEntradaPaciente
	 *            hora_entrada_paciente
	 */
	public void setHoraEntradaPaciente(Time horaEntradaPaciente) {
		this.horaEntradaPaciente = horaEntradaPaciente;
	}

	/**
	 * Get the hora_entrada_paciente.
	 * 
	 * @return hora_entrada_paciente
	 */
	public Time getHoraEntradaPaciente() {
		return this.horaEntradaPaciente;
	}

	/**
	 * Set the paciente.
	 * 
	 * @param paciente
	 *            paciente
	 */
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	/**
	 * Get the paciente.
	 * 
	 * @return paciente
	 */
	public Paciente getPaciente() {
		return this.paciente;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEntradaPaciente == null) ? 0 : idEntradaPaciente.hashCode());
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
		EntradaPaciente other = (EntradaPaciente) obj;
		if (idEntradaPaciente == null) {
			if (other.idEntradaPaciente != null) {
				return false;
			}
		} else if (!idEntradaPaciente.equals(other.idEntradaPaciente)) {
			return false;
		}
		return true;
	}

}


package pe.upc.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="citas")
public class Cita {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCita;


	
	@Column(name="codigo_Paciente", nullable=false)
	private Long idPaciente;
	
	@Column(name="fecha_Cita", nullable=false)
	private String fechaCita;
	
	@Column(name="hora_Cita", nullable=false)
	private String horaCita;
	
	@Column(name="codigo_Sala", nullable=false)
	private Long idSala;
	
	@Column(name="codigo_Servicio", nullable=false)
	private Long idServicio;
	
	@Column(name="codigo_Especialidad", nullable=false)
	private Long idEspecialidad;
	
	@Column(name="codigo_Medico", nullable=false)
	private Long idMedico;


	public Long getIdCita() {
		return idCita;
	}

	public void setIdCita(Long id) {
		this.idCita = id;
	}
	
	public Long getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Long id) {
		this.idPaciente = id;
	}

	public String getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(String fechaCita) {
		this.fechaCita = fechaCita;
	}
	
	public String getHoraCita() {
		return horaCita;
	}

	public void setHoraCita(String horaCita) {
		this.horaCita = horaCita;
	}

	public Long getSala() {
		return idSala;
	}

	public void setSala(Long idSala) {
		this.idSala = idSala;
	}

	public Long getServicio() {
		return idServicio;
	}

	public void setCategory(Long idServicio) {
		this.idServicio = idServicio;
	}

	public Long getEspecialidad() {
		return idEspecialidad;
	}

	public void setUnitPrice(Long idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public Long getMedico() {
		return idMedico;
	}

	public void setMedico(Long idMedico) {
		this.idMedico = idMedico;
	}

}

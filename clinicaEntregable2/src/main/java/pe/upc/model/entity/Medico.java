
package pe.upc.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medicos")
public class Medico {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idMedico;


	
	@Column(name="Nombre_Medico", nullable=false)
	private String nameMedico;
	
	@Column(name="Codigo_Universidad", nullable=false)
	private Long idUniversidad;
	
	@Column(name="Nombre_Especialidad", nullable=false)
	private Long idEspecialidad;
	
	@Column(name="Codigo_Horario", nullable=false)
	private Long idHorario;

	public Long getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(Long idMedico) {
		this.idMedico = idMedico;
	}

	public String getNameMedico() {
		return nameMedico;
	}

	public void setNameMedico(String nameMedico) {
		this.nameMedico = nameMedico;
	}

	public Long getIdUniversidad() {
		return idUniversidad;
	}

	public void setIdUniversidad(Long idUniversidad) {
		this.idUniversidad = idUniversidad;
	}

	public Long getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(Long idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public Long getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(Long idHorario) {
		this.idHorario = idHorario;
	}
	

}
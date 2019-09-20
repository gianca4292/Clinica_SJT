
package pe.upc.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="horarios")
public class Horario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idHorario;
	

	@Column(name="Hora_Inicio", nullable=false)
	private String horaInicio;
	
	@Column(name="Hora_Fin", nullable=false)
	private String horaFin;

	@Column(name="Dia_Semana", nullable=false)
	private String diaSemana;
	
	@Column(name="codigo_Servicio", nullable=false)
	private Long idServicio;
	
	@Column(name="Nombre_Servicio", nullable=false)
	private String nameServicio;
	
	
	public Long getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(Long idHorario) {
		this.idHorario = idHorario;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	
	public String getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public Long getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Long idServicio) {
		this.idServicio = idServicio;
	}

	public String getNombreServicio() {
		return nameServicio;
	}

	public void setNombreServicio(String nameServicio) {
		this.nameServicio = nameServicio;
	}
	

}

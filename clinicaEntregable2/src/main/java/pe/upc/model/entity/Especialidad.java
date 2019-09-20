
package pe.upc.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="especialidades")
public class Especialidad {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEspecialidad;
	
	
	
	@Column(name="unit_price", nullable=false)
	private String nameEspecialidad;
	
	
	public Long getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(Long idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public String getNameEspecialidad() {
		return nameEspecialidad;
	}

	public void setNameEspecialidad(String nameEspecialidad) {
		this.nameEspecialidad = nameEspecialidad;
	}	

}
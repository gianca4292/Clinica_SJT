
package pe.upc.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="universidades")
public class Universidad {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUniversidad;
		
	
	@Column(name="Nombre_Universidad", nullable=false)
	private String nameUniversidad;
	
	
	public Long getIdUniversidad() {
		return idUniversidad;
	}

	public void setIdUniversidad(Long idUniversidad) {
		this.idUniversidad = idUniversidad;
	}

	public String getNameUniversidad() {
		return nameUniversidad;
	}

	public void setNameUniversidad(String nameUniversidad) {
		this.nameUniversidad = nameUniversidad;
	}	

}
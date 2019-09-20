
package pe.upc.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="servicios")
public class Servicio {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idServicio;
		
	
	@Column(name="NombreServicio", nullable=false)
	private String nameServicio;
	
	

	public Long getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Long idServicio) {
		this.idServicio = idServicio;
	}

	public String getNameServicio() {
		return nameServicio;
	}

	public void setNameServicio(String nameServicio) {
		this.nameServicio = nameServicio;
	}
	
}

package pe.upc.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="consultorios")
public class Consultorio {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idConsultorio;
	
	
	
	@Column(name="nombre_Consultorio", nullable=false)
	private String nameConsultorio;
	
	
	public Long getIdConsultorio() {
		return idConsultorio;
	}

	public void setIdConsultorio(Long idConsultorio) {
		this.idConsultorio = idConsultorio;
	}

	public String getNameConsultorio() {
		return nameConsultorio;
	}

	public void setNameConsultorio(String nameConsultorio) {
		this.nameConsultorio = nameConsultorio;
	}	

}

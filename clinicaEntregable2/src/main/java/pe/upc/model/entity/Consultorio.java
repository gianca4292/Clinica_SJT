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
	private Integer idConsultorio;
	
	@Column(name="nombre_Consultorio", nullable=false, length = 50)
	private String nameConsultorio;
	
	
	
	public Integer getIdConsultorio() {
		return idConsultorio;
	}

	public void setIdConsultorio(Integer idConsultorio) {
		this.idConsultorio = idConsultorio;
	}

	public String getNameConsultorio() {
		return nameConsultorio;
	}

	public void setNameConsultorio(String nameConsultorio) {
		this.nameConsultorio = nameConsultorio;
	}	

}

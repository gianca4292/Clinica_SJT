
package pe.upc.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="laboratorios")
public class Laboratorio {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idLaboratorio;	
	
	
	@Column(name="nombre_Laboratorio", nullable=false)
	private String nameLaboratorio;
	
	

	public Long getIdLaboratorio() {
		return idLaboratorio;
	}

	public void setIdLaboratorio(Long idLaboratorio) {
		this.idLaboratorio = idLaboratorio;
	}

	public String getNameLaboratorio() {
		return nameLaboratorio;
	}

	public void setNameLaboratorio(String nameLaboratorio) {
		this.nameLaboratorio = nameLaboratorio;
	}

	

}
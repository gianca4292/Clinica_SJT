
package pe.upc.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="seguros")
public class Seguro {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSeguro;
	
	
	@Column(name="Nombre_Seguro", nullable=false)
	private String nameSeguro;
	
	@Column(name="Codigo_Compañia_Seguro", nullable=false)
	private Long IdCompañia;

	public Long getIdSeguro() {
		return idSeguro;
	}

	public void setIdSeguro(Long idSeguro) {
		this.idSeguro = idSeguro;
	}

	public String getNameSeguro() {
		return nameSeguro;
	}

	public void setNameSeguro(String nameSeguro) {
		this.nameSeguro = nameSeguro;
	}

	public Long getIdCompañia() {
		return IdCompañia;
	}

	public void setIdCompañia(Long IdCompañia) {
		this.IdCompañia = IdCompañia;
	}
	

}
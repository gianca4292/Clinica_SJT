
package pe.upc.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="compañias")
public class CompañiaSeguro {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCompañia;
	private String nameCompañia;
	
	
	@Column(name="nombre_Compañia", nullable=false)
	private String unitPrice;
	


	public Long getIdCompañia() {
		return idCompañia;
	}

	public void setIdCompañia(Long idCompañia) {
		this.idCompañia = idCompañia;
	}

	public String getNameCompañia() {
		return nameCompañia;
	}

	public void setNameCompañia(String nameCompañia) {
		this.nameCompañia = nameCompañia;
	}
	

}

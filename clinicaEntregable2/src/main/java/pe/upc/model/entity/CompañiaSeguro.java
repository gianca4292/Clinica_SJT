
package pe.upc.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="compa�ias")
public class Compa�iaSeguro {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCompa�ia;
	private String nameCompa�ia;
	
	
	@Column(name="nombre_Compa�ia", nullable=false)
	private String unitPrice;
	


	public Long getIdCompa�ia() {
		return idCompa�ia;
	}

	public void setIdCompa�ia(Long idCompa�ia) {
		this.idCompa�ia = idCompa�ia;
	}

	public String getNameCompa�ia() {
		return nameCompa�ia;
	}

	public void setNameCompa�ia(String nameCompa�ia) {
		this.nameCompa�ia = nameCompa�ia;
	}
	

}

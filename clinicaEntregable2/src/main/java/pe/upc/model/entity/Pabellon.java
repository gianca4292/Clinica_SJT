
package pe.upc.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pabellones")
public class Pabellon {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPabellon;
	
	
	@Column(name="Nombre_Pabellon", nullable=false)
	private String namePabellon;
	
	@Column(name="Numero_Piso", nullable=false)
	private int numPiso;

	public Long getIdPabellon() {
		return idPabellon;
	}

	public void setIdPabellon(Long idPabellon) {
		this.idPabellon = idPabellon;
	}

	public String getNamePabellon() {
		return namePabellon;
	}

	public void setNamePabellon(String namePabellon) {
		this.namePabellon = namePabellon;
	}

	public int getNumPiso() {
		return numPiso;
	}

	public void setNumPiso(int numPiso) {
		this.numPiso = numPiso;
	}
	

}

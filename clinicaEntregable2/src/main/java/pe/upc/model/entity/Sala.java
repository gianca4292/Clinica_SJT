
package pe.upc.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="salas")
public class Sala {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSala;

	
	
	@Column(name="Nombre_Sala", nullable=false)
	private String nameSala;
	
	@Column(name="Codigo_Pabellon", nullable=false)
	private Long IdPabellon;

	public Long getIdSala() {
		return idSala;
	}

	public void setIdSala(Long idSala) {
		this.idSala = idSala;
	}

	public String getNameSala() {
		return nameSala;
	}

	public void setNameSala(String nameSala) {
		this.nameSala = nameSala;
	}

	public Long getIdPabellon() {
		return IdPabellon;
	}

	public void setIdPabellon(Long IdPabellon) {
		this.IdPabellon = IdPabellon;
	}

	
}


package pe.upc.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="equipos")
public class Equipo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEquipo;
	
	
	
	@Column(name="unit_price", nullable=false)
	private String nameEquipo;
	
	@Column(name="units_in_stock", nullable=false)
	private String EsDescontinuado;

	public Long getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(Long idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getNameEquipo() {
		return nameEquipo;
	}

	public void setNameEquipo(String nameEquipo) {
		this.nameEquipo = nameEquipo;
	}

	public String getEsDescontinuado() {
		return EsDescontinuado;
	}

	public void setEsDescontinuado(String EsDescontinuado) {
		this.EsDescontinuado = EsDescontinuado;
	}

	

}

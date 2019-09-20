
package pe.upc.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comprobantes")
public class Comprobante {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idComprobante;

	
	@Column(name="fecha_impresion", nullable=false)
	private String fechaComprobante;
	
	@Column(name="hora_impresion", nullable=false)
	private String horaComprobante;
	
	@Column(name="cantidad_Monto", nullable=false)
	private int cantidadPrecio;
	
	@Column(name="codigo_cita", nullable=false)
	private Long codigoCita;

	public Long getIdComprobante() {
		return idComprobante;
	}

	public void setIdComprobante(Long idComprobante) {
		this.idComprobante = idComprobante;
	}

	public String getFechaComprobante() {
		return fechaComprobante;
	}

	public void setFechaComprobante(String fechaComprobante) {
		this.fechaComprobante = fechaComprobante;
	}

	public String getHoraComprobante() {
		return horaComprobante;
	}

	public void setHoraComprobante(String horaComprobante) {
		this.horaComprobante = horaComprobante;
	}

	public int getCantidadPrecio() {
		return cantidadPrecio;
	}

	public void setCantidadPrecioy(int cantidadPrecio) {
		this.cantidadPrecio = cantidadPrecio;
	}

	public double getCodigoCita() {
		return codigoCita;
	}

	public void setCodigoCita(Long codigoCita) {
		this.codigoCita = codigoCita;
	}
	

}

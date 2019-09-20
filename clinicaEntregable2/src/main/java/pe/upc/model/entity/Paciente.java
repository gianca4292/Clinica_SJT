
package pe.upc.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pacientes")
public class Paciente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPaciente;	
	
	
	@Column(name="Nombre_Paciente", nullable=false)
	private String namePaciente;
	
	@Column(name="Apellido_Paterno", nullable=false)
	private String apellidoPaternoPaciente;
	
	@Column(name="Apellido_Materno", nullable=false)
	private String apellidoMaternoPaciente;
	
	@Column(name="Sexo", nullable=false)
	private String sexoPaciente;
	
	@Column(name="Direccion", nullable=false)
	private String direccionPaciente;
	
	@Column(name="Codigo_Historia", nullable=false)
	private Long IdHistoria;
	
	@Column(name="DNI", nullable=false)
	private Long Dni;
	
	@Column(name="Codigo_Seguro", nullable=false)
	private Long IdSeguro;
	
	@Column(name="Fecha_Nacimiento", nullable=false)
	private String fechaNacimiento;

	
	
	public Long getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getNamePaciente() {
		return namePaciente;
	}

	public void setNamePaciente(String namePaciente) {
		this.namePaciente = namePaciente;
	}

	public String getApellidoPaterno() {
		return apellidoPaternoPaciente;
	}

	public void setApellidoPaterno(String apellidoPaternoPaciente) {
		this.apellidoPaternoPaciente = apellidoPaternoPaciente;
	}

	public String getSexoPaciente() {
		return sexoPaciente;
	}

	public void setApellidoMaterno(String sexoPaciente) {
		this.sexoPaciente = sexoPaciente;
	}

	public String getDireccionPaciente() {
		return direccionPaciente;
	}

	public void setUnitPrice(String direccionPaciente) {
		this.direccionPaciente = direccionPaciente;
	}

	public Long getIdHistoria() {
		return IdHistoria;
	}

	public void setIdHistoria(Long IdHistoria) {
		this.IdHistoria = IdHistoria;
	}
	
	public Long getDNI() {
		return Dni;
	}

	public void setDNI(Long Dni) {
		this.Dni = Dni;
	}
	
	public Long getIdSeguro() {
		return IdSeguro;
	}

	public void setIdSwguro(Long IdSeguro) {
		this.IdSeguro = IdSeguro;
	}
	
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}

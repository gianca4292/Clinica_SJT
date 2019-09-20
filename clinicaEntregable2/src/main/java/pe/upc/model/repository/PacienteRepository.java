package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Paciente;

@Named
public class PacienteRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public Long insert(Paciente paciente) throws Exception {
		em.persist(paciente);
		return paciente.getIdPaciente();
	}
	
	
	public Long update(Paciente paciente) throws Exception {
		em.merge(paciente);
		return paciente.getIdPaciente();
	}
	
	
	public void delete(Paciente paciente) throws Exception {
		em.remove(paciente);
	}
	
	
	public List<Paciente> findAll() throws Exception{
		List<Paciente> pacientes=new ArrayList<>();
		
		TypedQuery<Paciente> query=em.createQuery("FROM Paciente p"
				,Paciente.class);
		pacientes=query.getResultList();
		
		return pacientes;
	}
	
	
	public Optional<Paciente> findById(Long id) throws Exception{
		Paciente pacienteFound;
		
		TypedQuery<Paciente> query=em.createQuery("FROM Paciente p WHERE p.id=?1"
				,Paciente.class);
		query.setParameter(1, id);
		pacienteFound=query.getSingleResult();
		
		return Optional.of(pacienteFound);
	}
	
	
	public List<Paciente> findByName(String name) throws Exception{
		List<Paciente> pacientes=new ArrayList<>();
		
		TypedQuery<Paciente> query=em.createQuery("FROM Paciente p WHERE p.name LIKE ?1"
				,Paciente.class);
		query.setParameter(1, "%"+name+"%");
		pacientes=query.getResultList();
		
		return pacientes;
	}
	
	

}


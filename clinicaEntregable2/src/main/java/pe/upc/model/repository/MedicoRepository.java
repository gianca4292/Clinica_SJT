package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Medico;

@Named
public class MedicoRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public Long insert(Medico medico) throws Exception {
		em.persist(medico);
		return medico.getIdMedico();
	}
	
	
	public Long update(Medico medico) throws Exception {
		em.merge(medico);
		return medico.getIdMedico();
	}
	
	
	public void delete(Medico medico) throws Exception {
		em.remove(medico);
	}
	
	
	public List<Medico> findAll() throws Exception{
		List<Medico> medicos=new ArrayList<>();
		
		TypedQuery<Medico> query=em.createQuery("FROM Medico p"
				,Medico.class);
		medicos=query.getResultList();
		
		return medicos;
	}
	
	
	public Optional<Medico> findById(Long id) throws Exception{
		Medico medicoFound;
		
		TypedQuery<Medico> query=em.createQuery("FROM Medico p WHERE p.id=?1"
				,Medico.class);
		query.setParameter(1, id);
		medicoFound=query.getSingleResult();
		
		return Optional.of(medicoFound);
	}
	
	
	public List<Medico> findByName(String name) throws Exception{
		List<Medico> medicos=new ArrayList<>();
		
		TypedQuery<Medico> query=em.createQuery("FROM Medico p WHERE p.name LIKE ?1"
				,Medico.class);
		query.setParameter(1, "%"+name+"%");
		medicos=query.getResultList();
		
		return medicos;
	}
	
	

}

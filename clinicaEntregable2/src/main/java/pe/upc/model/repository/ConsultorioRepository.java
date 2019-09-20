package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Consultorio;

@Named
public class ConsultorioRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public Long insert(Consultorio consultorio) throws Exception {
		em.persist(consultorio);
		return consultorio.getIdConsultorio();
	}
	
	
	public Long update(Consultorio consultorio) throws Exception {
		em.merge(consultorio);
		return consultorio.getIdConsultorio();
	}
	
	
	public void delete(Consultorio consultorio) throws Exception {
		em.remove(consultorio);
	}
	
	
	public List<Consultorio> findAll() throws Exception{
		List<Consultorio> consultorios=new ArrayList<>();
		
		TypedQuery<Consultorio> query=em.createQuery("FROM Consultorio p"
				,Consultorio.class);
		consultorios=query.getResultList();
		
		return consultorios;
	}
	
	
	public Optional<Consultorio> findById(Long id) throws Exception{
		Consultorio consultorioFound;
		
		TypedQuery<Consultorio> query=em.createQuery("FROM Consultorio p WHERE p.id=?1"
				,Consultorio.class);
		query.setParameter(1, id);
		consultorioFound=query.getSingleResult();
		
		return Optional.of(consultorioFound);
	}
	
	
	public List<Consultorio> findByName(String name) throws Exception{
		List<Consultorio> consultorios=new ArrayList<>();
		
		TypedQuery<Consultorio> query=em.createQuery("FROM Consultorio p WHERE p.name LIKE ?1"
				,Consultorio.class);
		query.setParameter(1, "%"+name+"%");
		consultorios=query.getResultList();
		
		return consultorios;
	}
	
	

}

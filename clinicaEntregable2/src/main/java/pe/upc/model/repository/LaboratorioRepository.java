package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Laboratorio;

@Named
public class LaboratorioRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public Long insert(Laboratorio laboratorio) throws Exception {
		em.persist(laboratorio);
		return laboratorio.getIdLaboratorio();
	}
	
	
	public Long update(Laboratorio laboratorio) throws Exception {
		em.merge(laboratorio);
		return laboratorio.getIdLaboratorio();
	}
	
	
	public void delete(Laboratorio laboratorio) throws Exception {
		em.remove(laboratorio);
	}
	
	
	public List<Laboratorio> findAll() throws Exception{
		List<Laboratorio> laboratorios=new ArrayList<>();
		
		TypedQuery<Laboratorio> query=em.createQuery("FROM Laboratorio p"
				,Laboratorio.class);
		laboratorios=query.getResultList();
		
		return laboratorios;
	}
	
	
	public Optional<Laboratorio> findById(Long id) throws Exception{
		Laboratorio laboratorioFound;
		
		TypedQuery<Laboratorio> query=em.createQuery("FROM Laboratorio p WHERE p.id=?1"
				,Laboratorio.class);
		query.setParameter(1, id);
		laboratorioFound=query.getSingleResult();
		
		return Optional.of(laboratorioFound);
	}
	
	
	public List<Laboratorio> findByName(String name) throws Exception{
		List<Laboratorio> laboratorios=new ArrayList<>();
		
		TypedQuery<Laboratorio> query=em.createQuery("FROM Laboratorio p WHERE p.name LIKE ?1"
				,Laboratorio.class);
		query.setParameter(1, "%"+name+"%");
		laboratorios=query.getResultList();
		
		return laboratorios;
	}
	
	

}


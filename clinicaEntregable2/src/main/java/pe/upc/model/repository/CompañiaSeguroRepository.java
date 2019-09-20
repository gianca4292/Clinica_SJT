package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.CompañiaSeguro;

@Named
public class CompañiaSeguroRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public Long insert(CompañiaSeguro compañia) throws Exception {
		em.persist(compañia);
		return compañia.getIdCompañia();
	}
	
	
	public Long update(CompañiaSeguro compañia) throws Exception {
		em.merge(compañia);
		return compañia.getIdCompañia();
	}
	
	
	public void delete(CompañiaSeguro compañia) throws Exception {
		em.remove(compañia);
	}
	
	
	public List<CompañiaSeguro> findAll() throws Exception{
		List<CompañiaSeguro> compañias=new ArrayList<>();
		
		TypedQuery<CompañiaSeguro> query=em.createQuery("FROM CompañiaSeguro p"
				,CompañiaSeguro.class);
		compañias=query.getResultList();
		
		return compañias;
	}
	
	
	public Optional<CompañiaSeguro> findById(Long id) throws Exception{
		CompañiaSeguro compañiaFound;
		
		TypedQuery<CompañiaSeguro> query=em.createQuery("FROM CompañiaSeguro p WHERE p.id=?1"
				,CompañiaSeguro.class);
		query.setParameter(1, id);
		compañiaFound=query.getSingleResult();
		
		return Optional.of(compañiaFound);
	}
	
	
	public List<CompañiaSeguro> findByName(String name) throws Exception{
		List<CompañiaSeguro> compañias=new ArrayList<>();
		
		TypedQuery<CompañiaSeguro> query=em.createQuery("FROM CompañiaSeguro p WHERE p.name LIKE ?1"
				,CompañiaSeguro.class);
		query.setParameter(1, "%"+name+"%");
		compañias=query.getResultList();
		
		return compañias;
	}
	
	

}

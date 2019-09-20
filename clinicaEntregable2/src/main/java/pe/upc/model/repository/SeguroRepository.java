package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Seguro;

@Named
public class SeguroRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public Long insert(Seguro seguro) throws Exception {
		em.persist(seguro);
		return seguro.getIdSeguro();
	}
	
	
	public Long update(Seguro seguro) throws Exception {
		em.merge(seguro);
		return seguro.getIdSeguro();
	}
	
	
	public void delete(Seguro seguro) throws Exception {
		em.remove(seguro);
	}
	
	
	public List<Seguro> findAll() throws Exception{
		List<Seguro> seguros=new ArrayList<>();
		
		TypedQuery<Seguro> query=em.createQuery("FROM Seguro p"
				,Seguro.class);
		seguros=query.getResultList();
		
		return seguros;
	}
	
	
	public Optional<Seguro> findById(Long id) throws Exception{
		Seguro seguroFound;
		
		TypedQuery<Seguro> query=em.createQuery("FROM Seguro p WHERE p.id=?1"
				,Seguro.class);
		query.setParameter(1, id);
		seguroFound=query.getSingleResult();
		
		return Optional.of(seguroFound);
	}
	
	
	public List<Seguro> findByName(String name) throws Exception{
		List<Seguro> seguros=new ArrayList<>();
		
		TypedQuery<Seguro> query=em.createQuery("FROM Seguro p WHERE p.name LIKE ?1"
				,Seguro.class);
		query.setParameter(1, "%"+name+"%");
		seguros=query.getResultList();
		
		return seguros;
	}
	
	

}

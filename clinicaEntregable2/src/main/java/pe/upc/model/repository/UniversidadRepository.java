package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Universidad;

@Named
public class UniversidadRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public Long insert(Universidad universidad) throws Exception {
		em.persist(universidad);
		return universidad.getIdUniversidad();
	}
	
	
	public Long update(Universidad universidad) throws Exception {
		em.merge(universidad);
		return universidad.getIdUniversidad();
	}
	
	
	public void delete(Universidad universidad) throws Exception {
		em.remove(universidad);
	}
	
	
	public List<Universidad> findAll() throws Exception{
		List<Universidad> universidads=new ArrayList<>();
		
		TypedQuery<Universidad> query=em.createQuery("FROM Universidad p"
				,Universidad.class);
		universidads=query.getResultList();
		
		return universidads;
	}
	
	
	public Optional<Universidad> findById(Long id) throws Exception{
		Universidad universidadFound;
		
		TypedQuery<Universidad> query=em.createQuery("FROM Universidad p WHERE p.id=?1"
				,Universidad.class);
		query.setParameter(1, id);
		universidadFound=query.getSingleResult();
		
		return Optional.of(universidadFound);
	}
	
	
	public List<Universidad> findByName(String name) throws Exception{
		List<Universidad> universidads=new ArrayList<>();
		
		TypedQuery<Universidad> query=em.createQuery("FROM Universidad p WHERE p.name LIKE ?1"
				,Universidad.class);
		query.setParameter(1, "%"+name+"%");
		universidads=query.getResultList();
		
		return universidads;
	}
	
	

}


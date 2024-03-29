package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.CompaņiaSeguro;

@Named
public class CompaņiaSeguroRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public Long insert(CompaņiaSeguro compaņia) throws Exception {
		em.persist(compaņia);
		return compaņia.getIdCompaņia();
	}
	
	
	public Long update(CompaņiaSeguro compaņia) throws Exception {
		em.merge(compaņia);
		return compaņia.getIdCompaņia();
	}
	
	
	public void delete(CompaņiaSeguro compaņia) throws Exception {
		em.remove(compaņia);
	}
	
	
	public List<CompaņiaSeguro> findAll() throws Exception{
		List<CompaņiaSeguro> compaņias=new ArrayList<>();
		
		TypedQuery<CompaņiaSeguro> query=em.createQuery("FROM CompaņiaSeguro p"
				,CompaņiaSeguro.class);
		compaņias=query.getResultList();
		
		return compaņias;
	}
	
	
	public Optional<CompaņiaSeguro> findById(Long id) throws Exception{
		CompaņiaSeguro compaņiaFound;
		
		TypedQuery<CompaņiaSeguro> query=em.createQuery("FROM CompaņiaSeguro p WHERE p.id=?1"
				,CompaņiaSeguro.class);
		query.setParameter(1, id);
		compaņiaFound=query.getSingleResult();
		
		return Optional.of(compaņiaFound);
	}
	
	
	public List<CompaņiaSeguro> findByName(String name) throws Exception{
		List<CompaņiaSeguro> compaņias=new ArrayList<>();
		
		TypedQuery<CompaņiaSeguro> query=em.createQuery("FROM CompaņiaSeguro p WHERE p.name LIKE ?1"
				,CompaņiaSeguro.class);
		query.setParameter(1, "%"+name+"%");
		compaņias=query.getResultList();
		
		return compaņias;
	}
	
	

}

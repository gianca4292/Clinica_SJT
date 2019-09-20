package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Compa�iaSeguro;

@Named
public class Compa�iaSeguroRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public Long insert(Compa�iaSeguro compa�ia) throws Exception {
		em.persist(compa�ia);
		return compa�ia.getIdCompa�ia();
	}
	
	
	public Long update(Compa�iaSeguro compa�ia) throws Exception {
		em.merge(compa�ia);
		return compa�ia.getIdCompa�ia();
	}
	
	
	public void delete(Compa�iaSeguro compa�ia) throws Exception {
		em.remove(compa�ia);
	}
	
	
	public List<Compa�iaSeguro> findAll() throws Exception{
		List<Compa�iaSeguro> compa�ias=new ArrayList<>();
		
		TypedQuery<Compa�iaSeguro> query=em.createQuery("FROM Compa�iaSeguro p"
				,Compa�iaSeguro.class);
		compa�ias=query.getResultList();
		
		return compa�ias;
	}
	
	
	public Optional<Compa�iaSeguro> findById(Long id) throws Exception{
		Compa�iaSeguro compa�iaFound;
		
		TypedQuery<Compa�iaSeguro> query=em.createQuery("FROM Compa�iaSeguro p WHERE p.id=?1"
				,Compa�iaSeguro.class);
		query.setParameter(1, id);
		compa�iaFound=query.getSingleResult();
		
		return Optional.of(compa�iaFound);
	}
	
	
	public List<Compa�iaSeguro> findByName(String name) throws Exception{
		List<Compa�iaSeguro> compa�ias=new ArrayList<>();
		
		TypedQuery<Compa�iaSeguro> query=em.createQuery("FROM Compa�iaSeguro p WHERE p.name LIKE ?1"
				,Compa�iaSeguro.class);
		query.setParameter(1, "%"+name+"%");
		compa�ias=query.getResultList();
		
		return compa�ias;
	}
	
	

}

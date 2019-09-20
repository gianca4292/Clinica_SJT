package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Pabellon;

@Named
public class PabellonRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public Long insert(Pabellon pabellon) throws Exception {
		em.persist(pabellon);
		return pabellon.getIdPabellon();
	}
	
	
	public Long update(Pabellon pabellon) throws Exception {
		em.merge(pabellon);
		return pabellon.getIdPabellon();
	}
	
	
	public void delete(Pabellon pabellon) throws Exception {
		em.remove(pabellon);
	}
	
	
	public List<Pabellon> findAll() throws Exception{
		List<Pabellon> pabellons=new ArrayList<>();
		
		TypedQuery<Pabellon> query=em.createQuery("FROM Pabellon p"
				,Pabellon.class);
		pabellons=query.getResultList();
		
		return pabellons;
	}
	
	
	public Optional<Pabellon> findById(Long id) throws Exception{
		Pabellon pabellonFound;
		
		TypedQuery<Pabellon> query=em.createQuery("FROM Pabellon p WHERE p.id=?1"
				,Pabellon.class);
		query.setParameter(1, id);
		pabellonFound=query.getSingleResult();
		
		return Optional.of(pabellonFound);
	}
	
	
	public List<Pabellon> findByName(String name) throws Exception{
		List<Pabellon> pabellons=new ArrayList<>();
		
		TypedQuery<Pabellon> query=em.createQuery("FROM Pabellon p WHERE p.name LIKE ?1"
				,Pabellon.class);
		query.setParameter(1, "%"+name+"%");
		pabellons=query.getResultList();
		
		return pabellons;
	}
	
	

}


package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Comprobante;

@Named
public class ComprobanteRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public Long insert(Comprobante comprobante) throws Exception {
		em.persist(comprobante);
		return comprobante.getIdComprobante();
	}
	
	
	public Long update(Comprobante comprobante) throws Exception {
		em.merge(comprobante);
		return comprobante.getIdComprobante();
	}
	
	
	public void delete(Comprobante comprobante) throws Exception {
		em.remove(comprobante);
	}
	
	
	public List<Comprobante> findAll() throws Exception{
		List<Comprobante> comprobantes=new ArrayList<>();
		
		TypedQuery<Comprobante> query=em.createQuery("FROM Comprobante p"
				,Comprobante.class);
		comprobantes=query.getResultList();
		
		return comprobantes;
	}
	
	
	public Optional<Comprobante> findById(Long id) throws Exception{
		Comprobante comprobanteFound;
		
		TypedQuery<Comprobante> query=em.createQuery("FROM Comprobante p WHERE p.id=?1"
				,Comprobante.class);
		query.setParameter(1, id);
		comprobanteFound=query.getSingleResult();
		
		return Optional.of(comprobanteFound);
	}
	
	
	public List<Comprobante> findByName(String name) throws Exception{
		List<Comprobante> comprobantes=new ArrayList<>();
		
		TypedQuery<Comprobante> query=em.createQuery("FROM Comprobante p WHERE p.name LIKE ?1"
				,Comprobante.class);
		query.setParameter(1, "%"+name+"%");
		comprobantes=query.getResultList();
		
		return comprobantes;
	}
	
	

}

package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Servicio;

@Named
public class ServicioRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public Long insert(Servicio servicio) throws Exception {
		em.persist(servicio);
		return servicio.getIdServicio();
	}
	
	
	public Long update(Servicio servicio) throws Exception {
		em.merge(servicio);
		return servicio.getIdServicio();
	}
	
	
	public void delete(Servicio servicio) throws Exception {
		em.remove(servicio);
	}
	
	
	public List<Servicio> findAll() throws Exception{
		List<Servicio> servicios=new ArrayList<>();
		
		TypedQuery<Servicio> query=em.createQuery("FROM Servicio p"
				,Servicio.class);
		servicios=query.getResultList();
		
		return servicios;
	}
	
	
	public Optional<Servicio> findById(Long id) throws Exception{
		Servicio servicioFound;
		
		TypedQuery<Servicio> query=em.createQuery("FROM Servicio p WHERE p.id=?1"
				,Servicio.class);
		query.setParameter(1, id);
		servicioFound=query.getSingleResult();
		
		return Optional.of(servicioFound);
	}
	
	
	public List<Servicio> findByName(String name) throws Exception{
		List<Servicio> servicios=new ArrayList<>();
		
		TypedQuery<Servicio> query=em.createQuery("FROM Servicio p WHERE p.name LIKE ?1"
				,Servicio.class);
		query.setParameter(1, "%"+name+"%");
		servicios=query.getResultList();
		
		return servicios;
	}
	
	

}


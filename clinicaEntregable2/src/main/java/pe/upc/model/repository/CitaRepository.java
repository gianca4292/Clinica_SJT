package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Cita;

@Named
public class CitaRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public Long insert(Cita cita) throws Exception {
		em.persist(cita);
		return cita.getIdCita();
	}
		
	
	public Long update(Cita cita) throws Exception {
		em.merge(cita);
		return cita.getIdCita();
	}
	
	
	public void delete(Cita cita) throws Exception {
		em.remove(cita);
	}
	
	
	public List<Cita> findAll() throws Exception{
		List<Cita> citas=new ArrayList<>();
		
		TypedQuery<Cita> query=em.createQuery("FROM Cita p"
				,Cita.class);
		citas=query.getResultList();
		
		return citas;
	}
	
	
	public Optional<Cita> findById(Long id) throws Exception{
		Cita citaFound;
		
		TypedQuery<Cita> query=em.createQuery("FROM Cita p WHERE p.id=?1"
				,Cita.class);
		query.setParameter(1, id);
		citaFound=query.getSingleResult();
		
		return Optional.of(citaFound);
	}
	
	
	public List<Cita> findByName(String name) throws Exception{
		List<Cita> citas=new ArrayList<>();
		
		TypedQuery<Cita> query=em.createQuery("FROM Cita p WHERE p.name LIKE ?1"
				,Cita.class);
		query.setParameter(1, "%"+name+"%");
		citas=query.getResultList();
		
		return citas;
	}
	
	

}

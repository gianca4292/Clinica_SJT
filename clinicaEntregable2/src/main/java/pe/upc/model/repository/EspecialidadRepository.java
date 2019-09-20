package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Especialidad;

@Named
public class EspecialidadRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public Long insert(Especialidad especialidad) throws Exception {
		em.persist(especialidad);
		return especialidad.getIdEspecialidad();
	}
	
	
	public Long update(Especialidad especialidad) throws Exception {
		em.merge(especialidad);
		return especialidad.getIdEspecialidad();
	}
	
	
	public void delete(Especialidad especialidad) throws Exception {
		em.remove(especialidad);
	}
	
	
	public List<Especialidad> findAll() throws Exception{
		List<Especialidad> especialidades=new ArrayList<>();
		
		TypedQuery<Especialidad> query=em.createQuery("FROM Especialidad p"
				,Especialidad.class);
		especialidades=query.getResultList();
		
		return especialidades;
	}
	
	
	public Optional<Especialidad> findById(Long id) throws Exception{
		Especialidad especialidadFound;
		
		TypedQuery<Especialidad> query=em.createQuery("FROM Especialidad p WHERE p.id=?1"
				,Especialidad.class);
		query.setParameter(1, id);
		especialidadFound=query.getSingleResult();
		
		return Optional.of(especialidadFound);
	}
	
	
	public List<Especialidad> findByName(String name) throws Exception{
		List<Especialidad> especialidades=new ArrayList<>();
		
		TypedQuery<Especialidad> query=em.createQuery("FROM Especialidad p WHERE p.name LIKE ?1"
				,Especialidad.class);
		query.setParameter(1, "%"+name+"%");
		especialidades=query.getResultList();
		
		return especialidades;
	}
	
	

}


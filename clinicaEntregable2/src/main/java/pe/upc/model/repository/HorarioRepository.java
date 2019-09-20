package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Horario;

@Named
public class HorarioRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public Long insert(Horario horario) throws Exception {
		em.persist(horario);
		return horario.getIdHorario();
	}
	
	
	public Long update(Horario horario) throws Exception {
		em.merge(horario);
		return horario.getIdHorario();
	}
	
	
	public void delete(Horario horario) throws Exception {
		em.remove(horario);
	}
	
	
	public List<Horario> findAll() throws Exception{
		List<Horario> horarios=new ArrayList<>();
		
		TypedQuery<Horario> query=em.createQuery("FROM Horario p"
				,Horario.class);
		horarios=query.getResultList();
		
		return horarios;
	}
	
	
	public Optional<Horario> findById(Long id) throws Exception{
		Horario horarioFound;
		
		TypedQuery<Horario> query=em.createQuery("FROM Horario p WHERE p.id=?1"
				,Horario.class);
		query.setParameter(1, id);
		horarioFound=query.getSingleResult();
		
		return Optional.of(horarioFound);
	}
	
	
	public List<Horario> findByName(String name) throws Exception{
		List<Horario> horarios=new ArrayList<>();
		
		TypedQuery<Horario> query=em.createQuery("FROM Horario p WHERE p.name LIKE ?1"
				,Horario.class);
		query.setParameter(1, "%"+name+"%");
		horarios=query.getResultList();
		
		return horarios;
	}
	
	

}

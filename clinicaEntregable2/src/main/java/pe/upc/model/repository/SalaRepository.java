package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Sala;

@Named
public class SalaRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public Long insert(Sala sala) throws Exception {
		em.persist(sala);
		return sala.getIdSala();
	}
	
	
	public Long update(Sala sala) throws Exception {
		em.merge(sala);
		return sala.getIdSala();
	}
	
	
	public void delete(Sala sala) throws Exception {
		em.remove(sala);
	}
	
	
	public List<Sala> findAll() throws Exception{
		List<Sala> salas=new ArrayList<>();
		
		TypedQuery<Sala> query=em.createQuery("FROM Sala p"
				,Sala.class);
		salas=query.getResultList();
		
		return salas;
	}
	
	
	public Optional<Sala> findById(Long id) throws Exception{
		Sala salaFound;
		
		TypedQuery<Sala> query=em.createQuery("FROM Sala p WHERE p.id=?1"
				,Sala.class);
		query.setParameter(1, id);
		salaFound=query.getSingleResult();
		
		return Optional.of(salaFound);
	}
	
	
	public List<Sala> findByName(String name) throws Exception{
		List<Sala> salas=new ArrayList<>();
		
		TypedQuery<Sala> query=em.createQuery("FROM Sala p WHERE p.name LIKE ?1"
				,Sala.class);
		query.setParameter(1, "%"+name+"%");
		salas=query.getResultList();
		
		return salas;
	}
	
	

}


package pe.upc.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.upc.model.entity.Equipo;

@Named
public class EquipoRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public Long insert(Equipo equipo) throws Exception {
		em.persist(equipo);
		return equipo.getIdEquipo();
	}
	
	
	public Long update(Equipo equipo) throws Exception {
		em.merge(equipo);
		return equipo.getIdEquipo();
	}
	
	
	public void delete(Equipo equipo) throws Exception {
		em.remove(equipo);
	}
	
	
	public List<Equipo> findAll() throws Exception{
		List<Equipo> equipos=new ArrayList<>();
		
		TypedQuery<Equipo> query=em.createQuery("FROM Equipo p"
				,Equipo.class);
		equipos=query.getResultList();
		
		return equipos;
	}
	
	
	public Optional<Equipo> findById(Long id) throws Exception{
		Equipo equipoFound;
		
		TypedQuery<Equipo> query=em.createQuery("FROM Equipo p WHERE p.id=?1"
				,Equipo.class);
		query.setParameter(1, id);
		equipoFound=query.getSingleResult();
		
		return Optional.of(equipoFound);
	}
	
	
	public List<Equipo> findByName(String name) throws Exception{
		List<Equipo> equipos=new ArrayList<>();
		
		TypedQuery<Equipo> query=em.createQuery("FROM Equipo p WHERE p.name LIKE ?1"
				,Equipo.class);
		query.setParameter(1, "%"+name+"%");
		equipos=query.getResultList();
		
		return equipos;
	}
	
	

}


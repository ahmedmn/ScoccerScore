package cz.fi.muni.pa165.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.fi.muni.pa165.entity.Team;

/**
 * TeamDAOImpl implements TeamDAO to give some basic operations such as insert, update, delete and find 
 * data in Team table .
 * @author sokdina999@gamil.com
**/

@Repository("TeamDAOImpl")
public class TeamDAOImpl implements TeamDAO {
	
        @PersistenceContext
	private EntityManager entityManager;
    
	@Override
	@Transactional
	public void create(Team p) {
            entityManager.persist(p);
        }
        
        @Override
        @Transactional
	public Team update(Team t) {
		return entityManager.merge(t);
	}
        
        @Override
        @Transactional
	public void delete(Team t){// throws IllegalArgumentException {
		
		entityManager.remove(findById(t.getId()));
	}

	@Override
	public Team findById(int id) {
	    return entityManager.find(Team.class, id);
        }

	@Override
        public List<Team> findByAll() {
		return entityManager.createQuery("select t from Team t", Team.class)
				.getResultList();
	}
       
       @Override
	public List<Team> findByName(String name) {
		return entityManager.createQuery("SELECT t FROM Team t WHERE t.name like :name ",
				Team.class).setParameter("name", "%"+name+"%").getResultList();
	}

}

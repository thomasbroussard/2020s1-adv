package fr.epita.quiz.services.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;


/**
 * 
 * @author User
 *
 * @param <T>
 * @param <I>
 */
public abstract class GenericDAO<T,I> {
	
	@PersistenceContext
	private EntityManager em;

	
	@Transactional(value=TxType.REQUIRED)
	public final void create(T entity) {	
		em.persist(entity);
	}
	
	
//	public void update(T entity) {
//		Session session = sf.openSession();
//		Transaction tx = session.getTransaction();
//		tx.begin();
//		session.update(entity);
//		tx.commit();
//	}
//	public void delete(T entity) {
//		Session session = sf.openSession();
//		Transaction tx = session.getTransaction();
//		tx.begin();
//		session.delete(entity);
//		tx.commit();
//	}
	
	
	public abstract String getQuery();
	public abstract void setParameters(Map<String,Object> parameters, T criteria);
	
	public final List<T> search(T criteria){
		Query searchQuery = em.createQuery(getQuery());
		Map<String, Object> parameters = new LinkedHashMap<String, Object>();
		setParameters(parameters, criteria);
		for (Map.Entry<String,Object> entry : parameters.entrySet() ) {
			searchQuery.setParameter(entry.getKey(), entry.getValue());
		}
		return searchQuery.getResultList();
		
	}
	public final T getById(I id) {
		return em.find(getEntityClass(), id);
	}

	public abstract Class<T> getEntityClass();
	
}

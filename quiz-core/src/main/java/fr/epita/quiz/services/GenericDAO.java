package fr.epita.quiz.services;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;





public abstract class GenericDAO<T,I> {
	
	@Inject
	protected SessionFactory sf;

	public void create(T entity) {
		Session session = sf.openSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		session.save(entity);
		tx.commit();
	}
	public void update(T entity) {
		Session session = sf.openSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		session.update(entity);
		tx.commit();
	}
	public void delete(T entity) {
		Session session = sf.openSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		session.delete(entity);
		tx.commit();
	}
	
	public abstract List<T> search(T criteria);
	public abstract T getById(I id);

}

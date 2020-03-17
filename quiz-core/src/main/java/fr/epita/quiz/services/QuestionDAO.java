package fr.epita.quiz.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import fr.epita.quiz.datamodel.Question;

public class QuestionDAO extends GenericDAO<Question, Long>{
	

	
	public List<Question> search(Question question){
		Session session = sf.openSession();
		String titleParam = question.getTitle();
		
		Query<Question> searchQuery = session.createQuery("from Question where title = :pTitle", Question.class);
		searchQuery.setParameter("pTitle", titleParam);
		List<Question> resultList = searchQuery.list();
		return resultList;
		
	} 
	public Question getById(Long id){
		Session session = sf.openSession();
		return session.get(Question.class, id);
	}
	
	

}

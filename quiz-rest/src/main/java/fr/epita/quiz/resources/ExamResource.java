package fr.epita.quiz.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import fr.epita.quiz.services.business.ExamDataService;

@Path("/exam")
public class ExamResource {
	
	@Inject
	ExamDataService examDS;
	
	@POST
	@Path("/answer")
	public void addAnswerToQuestion() {
		System.out.println("testPost");
	}
	
	@GET
	@Path("/answer")
	public void getAnswers() {
		System.out.println("testGet");
	}
	
	

}

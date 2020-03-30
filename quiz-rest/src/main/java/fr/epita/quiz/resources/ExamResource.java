package fr.epita.quiz.resources;

import java.util.Arrays;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.epita.quiz.datamodel.Answer;
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
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getAnswers() {
		
		//beginning dummy implementation
		Answer answer = new Answer();
		answer.setContent("This is a sampleAnswer");
		
		
		return Response.ok(Arrays.asList(answer)).build();
	}
	
	

}

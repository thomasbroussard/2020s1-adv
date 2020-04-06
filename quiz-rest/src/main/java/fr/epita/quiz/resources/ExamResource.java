package fr.epita.quiz.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.RequestBody;

import fr.epita.quiz.datamodel.Answer;
import fr.epita.quiz.services.business.ExamDataService;
import fr.epita.quiz.services.dao.AnswerDAO;

@Path("/exam")
public class ExamResource {
	
	@Inject
	ExamDataService examDS;
	
	@Inject
	AnswerDAO dao;
	
	@POST
	@Path("/answer")
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response addAnswerToQuestion(@RequestBody AnswerDTO answerDTO) {
		
		
		//dummy code, to be replaced
		Answer answer = new Answer();
		answer.setContent(answerDTO.getContent());
		answer.setId(1l);
		System.out.println("got post with :" + answerDTO.getContent());
		//TODO call examDS on this answer
		try {
			return Response.created(new URI("/rest/exam/answer/" + answer.getId())).build();
		} catch (URISyntaxException e) {
			// TODO Handle things properly
			e.printStackTrace();
		}
		return Response.serverError().build();
	
	}
	
	@GET
	@Path("/answer/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getAnswer(@PathParam("id") long answerId) {
		//beginning dummy implementation
		Answer answer = new Answer();
		answer.setContent("This is a sampleAnswer with id " + answerId);
		answer.setId(answerId);
		return Response.ok(answer).build();
	}
	
	@GET
	@Path("/answer")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getAnswers() {
		
		//beginning dummy implementation
		Answer answer = new Answer();
		answer.setContent("This is a sampleAnswer");
		
		AnswerDTO answerDTO = new AnswerDTO(answer);
		
		return Response.ok(Arrays.asList(answerDTO)).build();
	}
	
	
	//@PUT
	
	//@DELETE
	
	@DELETE
	@Path("/answer")
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response removeAnswer(@RequestBody AnswerDTO answerDTO) {
		
		

		Answer answer = new Answer();
		answer.setContent(answerDTO.getContent());
		answer.setId(1l/*get the id from the dto*/);
		//dao.delete(answer);
		
		
		//TODO call examDS on this answer
		try {
			return Response.created(new URI("/rest/exam/answer/" + answer.getId())).build();
		} catch (URISyntaxException e) {
			// TODO Handle things properly
			e.printStackTrace();
		}
		return Response.serverError().build();
	
	}

}

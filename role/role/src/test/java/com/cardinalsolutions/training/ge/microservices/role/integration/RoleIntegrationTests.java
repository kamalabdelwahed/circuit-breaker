package com.cardinalsolutions.training.ge.microservices.role.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.cardinalsolutions.training.ge.microservices.role.domain.Actor;
import com.cardinalsolutions.training.ge.microservices.role.domain.Movie;
import com.cardinalsolutions.training.ge.microservices.role.service.IActorService;
import com.cardinalsolutions.training.ge.microservices.role.service.IMovieService;

@AutoConfigureMockMvc
@SpringBootTest({"eureka.client.enabled:false", "spring.cloud.config.enabled:false"})
@RunWith(SpringRunner.class)
public class RoleIntegrationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private IMovieService movieService;
	
	@MockBean
	private IActorService actorService;

	
	@Test
	public void testGetAllRoles() throws Exception{
		mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("role").exists())
			.andExpect(jsonPath("role[0].charName").value(is("Kamal")))
			.andExpect(jsonPath("role[1].charName").value(is("Megan")));	
	}
	
	@Test
	public void testGetRoleDetails() throws Exception {
		Movie movie = new Movie();
		movie.setId(5l);
		movie.setTitle("A mocked movie");
		movie.setSynopsis("Mocked");
		Actor actor = new Actor();
		actor.setId(8l);
		actor.setFirstName("Fakey");
		actor.setLastName("McFakeface");
		when(movieService.getMovieById(5l)).thenReturn(movie);
		when(actorService.getActorById(8l)).thenReturn(actor);
		
		mockMvc.perform(get("/1"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("id").value(is(1)))
			.andExpect(jsonPath("charName").value(is("Kamal")));
	}
	
	@Test
	public void testGetRoleDetailsThatDoesNotExist() throws Exception{
		mockMvc.perform(get("/155"))
				.andExpect(status().is(404));
		
	}
	
	@Test
	public void testGetRoleDetailsBadValue() throws Exception{
		mockMvc.perform(get("/pickle"))
				.andExpect(status().is(400));
	}



}

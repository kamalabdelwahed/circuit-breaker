package com.cardinalsolutions.training.ge.microservices.role.service;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.cardinalsolutions.training.ge.microservices.role.dao.IRoleRepo;
import com.cardinalsolutions.training.ge.microservices.role.domain.Actor;
import com.cardinalsolutions.training.ge.microservices.role.domain.Movie;
import com.cardinalsolutions.training.ge.microservices.role.domain.Role;
import com.cardinalsolutions.training.ge.microservices.role.domain.RoleDetails;
import com.cardinalsolutions.training.ge.microservices.role.domain.RoleNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class RoleServiceTest {
	
	@Mock 
	private IRoleRepo roleRepo;
	
	@Mock
	private IMovieService movieService;
	
	@Mock
	private IActorService actorService;
	
	@InjectMocks
	private IRoleServiceImpl roleService;
	
	@Test
	public void testRoleDetails(){
		when(roleRepo.findOne(2l)).thenReturn(new Role(1l, 1l, 1l, "Kamal", 10.00));
		Movie fakeMovie = new Movie();
		fakeMovie.setId(5l);
		fakeMovie.setSynopsis("this is a junit test");
		fakeMovie.setTitle("Kamal movie junit");
		when(movieService.getMovieById(5l)).thenReturn(fakeMovie);
		
		Actor fakeActor = new Actor();
		fakeActor.setId(1l);
		fakeActor.setFirstName("James");
		fakeActor.setLastName("Bond");
		fakeActor.setBirthDate(new Date());
		when(actorService.getActorById(5l)).thenReturn(fakeActor);	
		
		RoleDetails roleDetails = roleService.getRoleById(2l);
		
		assertThat(roleDetails).isNotNull();
		assertThat(fakeMovie.getTitle()).isEqualTo("Kamal movie junit");
		assertThat(fakeActor.getFirstName()).isEqualTo("James");
		
	}
	
	@Test(expected=RoleNotFoundException.class)
	public void testRoleNotFound(){
		when(roleRepo.findOne(anyLong())).thenReturn(null);
		roleService.getRoleById(10l);
	}
}

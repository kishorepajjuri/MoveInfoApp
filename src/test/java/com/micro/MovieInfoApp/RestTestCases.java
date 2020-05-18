package com.micro.MovieInfoApp;

import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.micro.MovieInfoApp.repo.MovieRepositry;
import com.micro.MovieInfoApp.service.MovieService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class RestTestCases {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private MovieRepositry movieRepositry;
	
	@MockBean
	private MovieService movieService;

	@Test
	public void testWhenPassMovieID() throws Exception {
		int movieId=3;
		when(movieRepositry.findAll()).thenReturn(Collections.emptyList());
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get("http://localhost:8072/movieCatlog/movieInfo?movieId=3").accept(MediaType.APPLICATION_JSON))
				.andReturn();
       System.out.println("REsponse::::"+result.getResponse());
		Mockito.verify(movieRepositry.findById(movieId));
	}
	
	@Test
	public void testMovieRAtings() throws Exception {
	
		when(movieRepositry.findAll()).thenReturn(Collections.emptyList());
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get("http://localhost:8074/movieRatings").accept(MediaType.APPLICATION_JSON))
				.andReturn();
       System.out.println("REsponse::::"+result.getResponse());
		Mockito.verify(movieRepositry.findAll());
	}

}

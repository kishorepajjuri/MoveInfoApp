package com.micro.MovieInfoApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.micro.MovieInfoApp.dto.MovieResponse;
import com.micro.MovieInfoApp.entity.MovieEntity;
import com.micro.MovieInfoApp.entity.MovieInfoEntity;
import com.micro.MovieInfoApp.service.MovieService;

@RestController
public class MovieController {
	
	@Autowired
	private  MovieService movieService;
	
	@RequestMapping(value="/movieInfo",method=RequestMethod.GET)
	public @ResponseBody MovieResponse getMovieInfo(@RequestParam(value="movieId") int movieId){
		System.out.println("JPAAAAAAAAAAAAA");
		MovieResponse response=movieService.getMovieInformation(movieId);
		return response;
		
	}
	
	@RequestMapping(value="/movieByName/{movieName}",method=RequestMethod.GET)
	public @ResponseBody MovieResponse getMovieDEtails(@PathVariable String movieName){
		System.out.println("getMovieDEtails");
		MovieResponse response=movieService.getMovieDetails(movieName);
		return response;
		
	}
	
	
	@PostMapping(value="/saveMovieDetails")
	public @ResponseBody MovieResponse saveMovieDetails(@RequestBody MovieInfoEntity movieEntity){
		System.out.println("saveMovieDetails"+movieEntity.getMovieRatings().getRating());
		MovieResponse response=movieService.saveMovieAndMovieRatings(movieEntity);
		return response;
		
	}
	
	@PostMapping(value="/saveMovieInfo")
	public @ResponseBody MovieResponse saveMovieInfo(@RequestBody MovieEntity movieEntity){
		MovieResponse response=movieService.saveMovieDetails(movieEntity);
		return response;
		
	}
	
	


}

package com.micro.MovieInfoApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.micro.MovieInfoApp.dto.MovieResponse;
import com.micro.MovieInfoApp.entity.MovieEntity;
import com.micro.MovieInfoApp.entity.MovieInfoEntity;
import com.micro.MovieInfoApp.repo.MovieInfoRepository;
import com.micro.MovieInfoApp.repo.MovieRepositry;

@Service("movieService")
@Transactional
public class MovieServiceImpl implements MovieService{
	@Autowired
	MovieRepositry movieRepositry;
	
	@Autowired
	private MovieInfoRepository movieInfoRepository;

	@Override
	public MovieResponse getMovieInformation(int movieId) {
		MovieResponse movieResponse=new MovieResponse();
		Optional<MovieEntity> movieById=null;
		movieById=movieRepositry.findById(movieId); 
		if(movieById!=null) {
			movieResponse.setStatus("success");
			movieResponse.setMovieByName(movieById);
		}
		else {
			movieResponse.setStatus("fail");
		}
		return movieResponse;
	}

	@Override
	public MovieResponse getMovieDetails(String name) {
		MovieResponse movieResponse=new MovieResponse();
		Optional<MovieEntity> movieNames=null;
		System.out.println("Movie NAme::::"+name);
		movieNames=movieRepositry.getByMovieName(name);
		if(movieNames!=null) {
			movieResponse.setStatus("success");
			movieResponse.setMovieByName(movieNames);
		}
		else {
			movieResponse.setStatus("fail");
		}
		return movieResponse;
	}

	@Override
	public MovieResponse saveMovieAndMovieRatings(MovieInfoEntity movieEntity) {
		MovieResponse movieResponse=new MovieResponse();
		System.out.println("MovieEntity ::::");
		MovieInfoEntity id=movieInfoRepository.save(movieEntity);
		if(id!=null) {
			movieResponse.setStatus("success");
			movieResponse.setStatus("savae Movie Details:::");
		}
		else {
			movieResponse.setStatus("fail");
		}
		return movieResponse;
	}

	@Override
	public MovieResponse saveMovieDetails(MovieEntity movieEntity) {
		MovieResponse movieResponse=new MovieResponse();
		System.out.println("MovieEntity ::::");
		MovieEntity id=movieRepositry.save(movieEntity);
		if(id!=null) {
			movieResponse.setStatus("success");
			movieResponse.setStatusCode(200);
			movieResponse.setStatus("savae Movie Details:::");
		}
		else {
			movieResponse.setStatusCode(201);
			movieResponse.setStatus("fail");
		}
		return movieResponse;
	}


	

}

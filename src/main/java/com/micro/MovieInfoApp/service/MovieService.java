package com.micro.MovieInfoApp.service;

import com.micro.MovieInfoApp.dto.MovieResponse;
import com.micro.MovieInfoApp.entity.MovieEntity;
import com.micro.MovieInfoApp.entity.MovieInfoEntity;

public interface MovieService {
	
MovieResponse getMovieInformation(int movieId);
MovieResponse saveMovieDetails(MovieEntity movieEntity);
MovieResponse saveMovieAndMovieRatings(MovieInfoEntity movieEntity);
MovieResponse getMovieDetails(String name);
}

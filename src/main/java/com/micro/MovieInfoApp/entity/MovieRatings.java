package com.micro.MovieInfoApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "movieRating")
@Entity(name = "movie")
public class MovieRatings {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "movie_id")
	private int movieId;

	@Column
	private String movieName;
	@Column
	private int rating;

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "movie_id", nullable = false)
	private MovieInfoEntity movieEntity;



	

	public MovieInfoEntity getMovieEntity() {
		return movieEntity;
	}

	public void setMovieEntity(MovieInfoEntity movieEntity) {
		this.movieEntity = movieEntity;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}

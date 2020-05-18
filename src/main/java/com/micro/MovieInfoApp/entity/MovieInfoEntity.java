
package com.micro.MovieInfoApp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "movieService")
@Table(name = "Movie_Info")
public class MovieInfoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "movie_id")
	private int movieId;

	@Column(name = "movie_name")
	private String movieName;

	@Column(name = "description")
	private String description;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "movieEntity")
	private MovieRatings movieRatings;

	public MovieRatings getMovieRatings() {
		return movieRatings;
	}

	public void setMovieRatings(MovieRatings movieRatings) {
		this.movieRatings = movieRatings;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

}

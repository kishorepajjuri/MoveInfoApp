package com.micro.MovieInfoApp.dto;

import java.util.List;
import java.util.Optional;

import com.micro.MovieInfoApp.entity.MovieEntity;

public class MovieResponse {
	private String status;
	private int statusCode;
	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	private List<MovieEntity> employeeList;
	private MovieEntity movieEntity;
	private Optional<MovieEntity> movieByName;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<MovieEntity> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<MovieEntity> employeeList) {
		this.employeeList = employeeList;
	}

	public MovieEntity getMovieEntity() {
		return movieEntity;
	}

	public void setMovieEntity(MovieEntity movieEntity) {
		this.movieEntity = movieEntity;
	}

	public Optional<MovieEntity> getMovieByName() {
		return movieByName;
	}

	public void setMovieByName(Optional<MovieEntity> movieByName) {
		this.movieByName = movieByName;
	}

}

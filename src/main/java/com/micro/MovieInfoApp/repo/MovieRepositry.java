package com.micro.MovieInfoApp.repo;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.micro.MovieInfoApp.entity.MovieEntity;
import com.micro.MovieInfoApp.entity.MovieInfoEntity;

@Repository
public interface MovieRepositry extends JpaRepository<MovieEntity, Integer>  {
	
	@Query("select ms from movieService ms where ms.movieName=?1 ")
	public Optional<MovieEntity> getByMovieName(String name);

	public MovieEntity save(MovieInfoEntity movieInfoEntity);

}

package com.micro.MovieInfoApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.micro.MovieInfoApp.entity.MovieInfoEntity;

@Repository
public interface MovieInfoRepository extends JpaRepository<MovieInfoEntity, Integer>  {
	
	public MovieInfoEntity save(MovieInfoEntity movieInfoEntity);


}

package com.luiz.workshopmongo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.luiz.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	@Query("{ 'title': { $regex: ?0, $options: '<option>' } }")
	List<Post> findByTitle(String text);

	List<Post> findByTitleContainingIgnoreCase(String text);
	
	@Query("{ $and: [ {date: {$gte: ?1} }, {date: {$lte: ?2} } , {$or: [ { 'title': { $regex: ?0, $options: '<option>' } }, { 'body': { $regex: ?0, $options: '<option>' } }, { 'comments.text': { $regex: ?0, $options: '<option>' } }] } ] }"  )
	List<Post> fullSearch(String text, Date data, Date maxDate);
}

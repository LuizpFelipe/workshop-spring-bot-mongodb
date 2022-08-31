package com.luiz.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.luiz.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {


}

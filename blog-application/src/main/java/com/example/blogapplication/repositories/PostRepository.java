package com.example.blogapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.blogapplication.models.Post;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long>{
}

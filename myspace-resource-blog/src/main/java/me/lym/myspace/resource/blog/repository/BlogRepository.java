package me.lym.myspace.resource.blog.repository;

import me.lym.myspace.resource.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {

//    @Modifying
//    int update(Blog blog);
}

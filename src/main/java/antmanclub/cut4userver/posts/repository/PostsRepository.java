package antmanclub.cut4userver.posts.repository;

import antmanclub.cut4userver.posts.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {

}

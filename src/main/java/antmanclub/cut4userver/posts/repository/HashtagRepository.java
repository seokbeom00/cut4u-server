package antmanclub.cut4userver.posts.repository;

import antmanclub.cut4userver.posts.domain.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HashtagRepository extends JpaRepository<Hashtag, Long> {
}

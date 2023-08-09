package antmanclub.cut4userver.posts.repository;

import antmanclub.cut4userver.posts.domain.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HashtagRepository extends JpaRepository<Hashtag, Long> {
    Optional<Hashtag> findByHashtag(String hashtagName);
}

package antmanclub.cut4userver.follow.repository;

import antmanclub.cut4userver.follow.domain.Follow;
import antmanclub.cut4userver.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    Optional<Follow> findByFolloweeAndFollower(User following, User follower);
}

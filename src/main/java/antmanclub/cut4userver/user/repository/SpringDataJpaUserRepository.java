package antmanclub.cut4userver.user.repository;

import antmanclub.cut4userver.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaUserRepository extends JpaRepository<User, Long>, UserRepository{

    @Override
    Optional<User> findByEmail(String email);
    @Override
    Optional<User> findByName(String name);



}

package antmanclub.cut4userver.config;

import antmanclub.cut4userver.user.repository.UserRepository;
import antmanclub.cut4userver.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private final UserRepository userRepository;

    @Autowired
    public SpringConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public UserServiceImpl userService() {
        return new UserServiceImpl(userRepository);
    }
}

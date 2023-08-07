package antmanclub.cut4userver.config;

import antmanclub.cut4userver.user.SemiToken.CurrentUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    public CurrentUser currentUser() {
        return new CurrentUser();
    }
}

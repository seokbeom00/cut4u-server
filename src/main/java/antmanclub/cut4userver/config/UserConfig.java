package antmanclub.cut4userver.config;

import antmanclub.cut4userver.user.SemiToken.CurrentUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class UserConfig {
    @Bean
    public CurrentUser currentUser() {
        return new CurrentUser();
    }
}

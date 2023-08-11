package antmanclub.cut4userver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Cut4uServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cut4uServerApplication.class, args);
	}
}

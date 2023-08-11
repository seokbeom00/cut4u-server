package antmanclub.cut4userver.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class LoginRequestDto {
    private String email;
    private String password;
}

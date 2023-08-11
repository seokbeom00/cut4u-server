package antmanclub.cut4userver.user.dto;

import lombok.Getter;

@Getter
public class JoinRequestDto {
    private String email;
    private String password;
    private String confirmPassword;
    private String name;
}

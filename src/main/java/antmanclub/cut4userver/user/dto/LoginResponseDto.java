package antmanclub.cut4userver.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class LoginResponseDto {
    private Boolean loginSuccess;

    @Builder
    public LoginResponseDto(Boolean success){
        this.loginSuccess = success;
    }
}

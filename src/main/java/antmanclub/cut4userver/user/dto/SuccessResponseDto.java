package antmanclub.cut4userver.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SuccessResponseDto {
    private Boolean loginSuccess;

    @Builder
    public SuccessResponseDto(Boolean success){
        this.loginSuccess = success;
    }
}

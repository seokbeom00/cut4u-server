package antmanclub.cut4userver.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SuccessResponseDto {
    private Boolean Success;

    @Builder
    public SuccessResponseDto(Boolean success){
        this.Success = success;
    }
}

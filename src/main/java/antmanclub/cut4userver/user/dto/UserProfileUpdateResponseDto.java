package antmanclub.cut4userver.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserProfileUpdateResponseDto {
    private String name;
    private String profileimg;

    @Builder
    public UserProfileUpdateResponseDto(String name, String profileimg){
        this.name = name;
        this.profileimg = profileimg;
    }
}

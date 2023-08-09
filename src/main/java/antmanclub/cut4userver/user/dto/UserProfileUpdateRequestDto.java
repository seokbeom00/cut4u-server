package antmanclub.cut4userver.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class UserProfileUpdateRequestDto {
    private String email;
    private String name;
    private String profileimg;

    @Builder
    public UserProfileUpdateRequestDto(String email, String name, String profileimg){
        this.email = email;
        this.name = name;
        this.profileimg = profileimg;
    }
}

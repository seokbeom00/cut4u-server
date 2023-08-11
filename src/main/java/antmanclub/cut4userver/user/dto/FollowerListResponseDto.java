package antmanclub.cut4userver.user.dto;

import antmanclub.cut4userver.user.domain.User;
import lombok.Getter;

@Getter
public class FollowerListResponseDto {
    private Long id;
    private String email;
    private String name;
    private String profileimg;

    public FollowerListResponseDto(User entity) {
        this.id = entity.getId();
        this.email = entity.getEmail();
        this.name = entity.getName();
        this.profileimg = entity.getProfileimg();
    }
}

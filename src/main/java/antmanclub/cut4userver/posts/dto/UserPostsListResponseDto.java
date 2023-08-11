package antmanclub.cut4userver.posts.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class UserPostsListResponseDto {
    private Long userId;
    private String userName;
    private String profileImg;
    List<UserPostsDto> userPostsDtoList;
}

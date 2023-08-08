package antmanclub.cut4userver.posts.dto;

import lombok.Getter;

@Getter
public class UserPostsListResponseDto {
    private String userId;
    private String userName;
    private Long followerCounts;
    private Long followingCounts;

}

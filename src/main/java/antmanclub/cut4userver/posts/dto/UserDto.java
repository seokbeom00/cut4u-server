package antmanclub.cut4userver.posts.dto;

import antmanclub.cut4userver.user.domain.User;
import lombok.Getter;

@Getter
public class UserDto {
    private String userName;
    private String userEmail;
    private int followingCount;
    private int followerCount;
    public UserDto(User user){
        this.userName = user.getName();
        this.userEmail = user.getEmail();
        this.followingCount = user.getFollowers().size();
        this.followerCount = user.getFollowing().size();
    }
}

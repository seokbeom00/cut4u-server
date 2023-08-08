package antmanclub.cut4userver.posts.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class PostsDto {
    private String userId;
    private String userName;
    private String profileImg;
    private String postsId;
    private String title;
    private String content;
    private String frameImg;
    private List<String> postHashtags;
}

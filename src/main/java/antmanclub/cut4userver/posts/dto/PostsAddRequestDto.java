package antmanclub.cut4userver.posts.dto;

import lombok.Getter;

@Getter
public class PostsAddRequestDto {
    private String userId;
    private String title;
    private String content;
    private String frameImg;
}

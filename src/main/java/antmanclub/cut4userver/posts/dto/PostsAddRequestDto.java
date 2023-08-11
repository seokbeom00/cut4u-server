package antmanclub.cut4userver.posts.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PostsAddRequestDto {
    private String title;
    private String content;
    private List<String> hashtags;
    private String frameImg;
}

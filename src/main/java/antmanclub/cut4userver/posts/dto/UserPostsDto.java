package antmanclub.cut4userver.posts.dto;

import antmanclub.cut4userver.posts.domain.Posts;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class UserPostsDto {
    private Long postsId;
    private String title;
    private String content;
    private String frameImg;
    private List<String> Hashtags;
    public UserPostsDto(Posts posts){
        this.postsId = posts.getId();
        this.title = posts.getTitle();
        this.content = posts.getContent();
        this.frameImg = posts.getFrameImg();
        this.Hashtags = posts.getPostsHashtags().stream()
                .map(postsHashtag -> postsHashtag.getHashtag().getHashtag())
                .collect(Collectors.toList());
    }
}

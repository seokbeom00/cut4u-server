package antmanclub.cut4userver.posts.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class PostsListResponseDto {
    private List<PostsDto> postsDtoList;
}

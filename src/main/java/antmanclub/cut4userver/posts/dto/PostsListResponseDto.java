package antmanclub.cut4userver.posts.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class PostsListResponseDto {
    public PostsListResponseDto(List<PostsDto> postsDtoList){
        this.postsDtoList = postsDtoList;
    }
    private List<PostsDto> postsDtoList;
}

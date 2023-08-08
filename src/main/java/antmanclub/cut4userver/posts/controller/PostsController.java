package antmanclub.cut4userver.posts.controller;

import antmanclub.cut4userver.posts.dto.PostsAddRequestDto;
import antmanclub.cut4userver.posts.dto.PostsListResponseDto;
import antmanclub.cut4userver.posts.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostsController {
    private final PostsService postsService;

    @PostMapping("add")
    public PostsListResponseDto add(PostsAddRequestDto postsAddRequestDto){
        return postsService.add(postsAddRequestDto);
    }
}

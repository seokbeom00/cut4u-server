package antmanclub.cut4userver.posts.controller;

import antmanclub.cut4userver.posts.dto.PostsAddRequestDto;
import antmanclub.cut4userver.posts.dto.PostsListResponseDto;
import antmanclub.cut4userver.posts.service.PostsService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostsController {
    private final PostsService postsService;

    @PostMapping("add")
    public PostsListResponseDto add(@RequestParam(value = "files") List<MultipartFile> files, @RequestParam(value = "title") String title,
                                    @RequestParam(value = "content") String content, @RequestParam(value = "hashTags") List<String> hashTags,
                                    @RequestParam(value = "frameImg") String frameImg){
        PostsAddRequestDto postsAddRequestDto = PostsAddRequestDto.builder()
                .title(title)
                .content(content)
                .hashtags(hashTags)
                .frameImg(frameImg)
                .build();
        return postsService.add(files, postsAddRequestDto);
    }
}

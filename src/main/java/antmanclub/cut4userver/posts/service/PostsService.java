package antmanclub.cut4userver.posts.service;

import antmanclub.cut4userver.posts.domain.Posts;
import antmanclub.cut4userver.posts.dto.PostsAddRequestDto;
import antmanclub.cut4userver.posts.dto.PostsListResponseDto;
import antmanclub.cut4userver.posts.repository.PostsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public PostsListResponseDto add(PostsAddRequestDto postsAddRequestDto) {
        Posts posts = new Posts();
        posts.setTitle(postsAddRequestDto.getTitle());
        posts.setContent(postsAddRequestDto.getContent());



        return null;
    }
}

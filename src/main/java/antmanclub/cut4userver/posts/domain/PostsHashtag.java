package antmanclub.cut4userver.posts.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class PostsHashtag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "POSTS_ID")
    private Posts post;

    @ManyToOne
    @JoinColumn(name = "HASHTAG_ID")
    private Hashtag hashtag;

    @Builder
    public PostsHashtag(Posts posts, Hashtag hashtag){
        this.post = posts;
        this.hashtag = hashtag;
    }
}

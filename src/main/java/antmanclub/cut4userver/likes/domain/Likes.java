package antmanclub.cut4userver.likes.domain;

import antmanclub.cut4userver.posts.domain.Posts;
import antmanclub.cut4userver.user.domain.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "POSTS_ID")
    private Posts post;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Builder
    public Likes(Posts posts, User user){
        this.post = posts;
        this.user = user;
    }
}

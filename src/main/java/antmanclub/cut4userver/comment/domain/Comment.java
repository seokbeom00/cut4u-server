package antmanclub.cut4userver.comment.domain;

import antmanclub.cut4userver.posts.domain.Posts;
import antmanclub.cut4userver.user.domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Comment parentComment;

    @OneToMany(mappedBy = "parentComment", cascade = CascadeType.ALL)
    private List<Comment> replyComments = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "POSTS_ID")
    private Posts post;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
}

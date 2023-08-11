package antmanclub.cut4userver.user.domain;


import antmanclub.cut4userver.comment.domain.Comment;
import antmanclub.cut4userver.follow.domain.Follow;
import antmanclub.cut4userver.likes.domain.Likes;
import antmanclub.cut4userver.posts.domain.Posts;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    private String email;

    private String password;

    private String name;

    private String profileimg;

    @OneToMany(mappedBy = "user")
    private List<Posts> postsList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Likes> likes = new ArrayList<>();

    @OneToMany(mappedBy = "follower")
    private List<Follow> following = new ArrayList<>();

    @OneToMany(mappedBy = "followee")
    private List<Follow> followers = new ArrayList<>();

    public void addFollowing(Follow follow){
        following.add(follow);
    }

    public void addFollower(Follow follow){
        followers.add(follow);
    }

    public void addPosts(Posts posts){ postsList.add(posts); }
}
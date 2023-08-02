package antmanclub.cut4userver.posts.domain;

import antmanclub.cut4userver.user.domain.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(length = 200, nullable = false)
    private String title;

    @Column(nullable = false)
    private String frameImg;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    private int likecount = 0;

    @OneToMany(mappedBy = "image")
    Image images;

    @Builder
    public Posts(String title, String content, String frameImg, Image images) {
        this.title = title;
        this.content = content;
        this.frameImg = frameImg;
        this.images = images;
    }

    public void addCount(){
        this.likecount += 1;
    }
    public void setUser(User user) {
        this.user = user;
    }
}

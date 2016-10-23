package guru.tour.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_posts database table.
 * 
 */
@Entity
@Table(name="user_posts")
@NamedQuery(name="UserPostEntity.findAll", query="SELECT u FROM UserPostEntity u")
public class UserPostEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String comment;

    //bi-directional many-to-one association to PostEntity
    @ManyToOne
    @JoinColumn(name="id_post")
    private PostEntity post;

    //bi-directional many-to-one association to UserEntity
    @ManyToOne
    @JoinColumn(name="id_user")
    private UserEntity user;

    public UserPostEntity() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public PostEntity getPost() {
        return this.post;
    }

    public void setPost(PostEntity post) {
        this.post = post;
    }

    public UserEntity getUser() {
        return this.user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

}
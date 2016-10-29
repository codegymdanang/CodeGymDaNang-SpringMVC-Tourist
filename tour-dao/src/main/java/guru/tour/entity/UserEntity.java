package guru.tour.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="UserEntity.findAll", query="SELECT u FROM UserEntity u")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id = UUID.randomUUID().toString();

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private String comment;

    private boolean credentialsNonExpired;

    private String diadiem;

    private boolean enabled;

    private String image;

    private String password;

    private String phone;

    private String username;

    //bi-directional many-to-one association to CommentEntity
    @OneToMany(mappedBy="user")
    private List<CommentEntity> comments;

    //bi-directional many-to-one association to UserAttemptEntity
//  @OneToMany(mappedBy="user")
//  private List<UserAttemptEntity> userAttempts;

    //bi-directional many-to-one association to UserPostEntity
    /*@OneToMany(mappedBy="user")
    private List<UserPostEntity> userPosts;*/

    //bi-directional many-to-one association to UserRoleEntity
    
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
        name="user_role"
        , joinColumns={
            @JoinColumn(name="user_id")
            }
        , inverseJoinColumns={
            @JoinColumn(name="role_id")
            }
        )
    private List<RoleEntity> roles;
    

    //bi-directional many-to-one association to UserScheduleEntity
    @OneToMany(mappedBy="user")
    private List<UserScheduleEntity> userschedules;

    public UserEntity() {
    }

    
    public UserEntity(String username, String password, String image, String phone) {
        this.username = username;
        this.password = password;
        this.image = image;
        this.phone = phone;
    }
    
  

    public UserEntity(boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired,
			boolean enabled, String image, String password, String phone, String username) {
		super();
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
		this.image = image;
		this.password = password;
		this.phone = phone;
		this.username = username;
	}


	public UserEntity(String username, String image, String phone, String diadiem,int a) {
        super();
        this.username = username;
        this.image = image;
        this.phone = phone;
        this.diadiem = diadiem;
    }

    
    public UserEntity(boolean enabled, String password, String username, List<RoleEntity> roles) {
        super();
        this.enabled = enabled;
        this.password = password;
        this.username = username;
        this.roles = roles;
    }
    public UserEntity(String id) {
		super();
		this.id = id;
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
    public String getDiadiem() {
        return this.diadiem;
    }

    public void setDiadiem(String diadiem) {
        this.diadiem = diadiem;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<CommentEntity> getComments() {
        return this.comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }

    public CommentEntity addComment(CommentEntity comment) {
        getComments().add(comment);
        comment.setUser(this);

        return comment;
    }

    public CommentEntity removeComment(CommentEntity comment) {
        getComments().remove(comment);
        comment.setUser(null);

        return comment;
    }

   /* public List<UserPostEntity> getUserPosts() {
        return this.userPosts;
    }

    public void setUserPosts(List<UserPostEntity> userPosts) {
        this.userPosts = userPosts;
    }*/

    public List<RoleEntity> getRoles() {
        return roles;
    }


    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }


    public List<UserScheduleEntity> getUserschedules() {
        return this.userschedules;
    }

    public void setUserschedules(List<UserScheduleEntity> userschedules) {
        this.userschedules = userschedules;
    }

    public UserScheduleEntity addUserschedule(UserScheduleEntity userschedule) {
        getUserschedules().add(userschedule);
        userschedule.setUser(this);

        return userschedule;
    }

    public UserScheduleEntity removeUserschedule(UserScheduleEntity userschedule) {
        getUserschedules().remove(userschedule);
        userschedule.setUser(null);

        return userschedule;
    }


    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }


    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }


    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }


    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }


    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }


    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }


    public boolean isEnabled() {
        return enabled;
    }


    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
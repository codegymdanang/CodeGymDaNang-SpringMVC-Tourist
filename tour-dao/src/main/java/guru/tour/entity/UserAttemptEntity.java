package guru.tour.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the user_attempts database table.
 * 
 */
@Entity
@Table(name="user_attempts")
@NamedQuery(name="UserAttemptEntity.findAll", query="SELECT u FROM UserAttemptEntity u")
public class UserAttemptEntity implements Serializable {
	private static final long serialVersionUID = 1L;


    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int attempts = 0;

	private Date lastModified;

	//bi-directional many-to-one association to UserEntity
	@Column(name="username")
	private String username;

	public UserAttemptEntity() {
	}

	/**
     * @param username2
     * @param attempts
     * @param lastModified
     */
    public UserAttemptEntity(String username, int attempts, Date lastModified) {
        this.username = username;
        this.attempts = attempts;
        this.lastModified = lastModified;
    }
    
    public UserAttemptEntity( String username, int attempts) {
		super();
		this.username = username;
		this.attempts = attempts;
	}

    public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAttempts() {
		return this.attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public Date getLastModified() {
		return this.lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

	

}
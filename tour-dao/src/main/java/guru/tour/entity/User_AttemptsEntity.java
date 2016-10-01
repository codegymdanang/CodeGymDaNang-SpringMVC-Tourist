package guru.tour.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_attempts")
public class User_AttemptsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name="username")
	String username;
	
	@Column(name="attempts")
	private int attempts;
	
	@Column(name="lastModified")
	private Date lastModified;

	
	public User_AttemptsEntity() {
		super();
	}

	public User_AttemptsEntity( String username, int attempts, Date lastModified) {
		super();
		this.username = username;
		this.attempts = attempts;
		this.lastModified = lastModified;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	
	
		
}

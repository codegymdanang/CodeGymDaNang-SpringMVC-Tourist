package guru.tour.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;


/**
 * The persistent class for the comment database table.
 * 
 */
@Entity
@Table(name="comment")
@NamedQuery(name="CommentEntity.findAll", query="SELECT c FROM CommentEntity c")
public class CommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id = UUID.randomUUID().toString();

	private String services;

	private String text;

	//bi-directional many-to-one association to TypeEntity
	@ManyToOne
	private TypeEntity type;

	//bi-directional many-to-one association to UserEntity
	@ManyToOne
	private UserEntity user;

	public CommentEntity() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getServices() {
		return this.services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public TypeEntity getType() {
		return this.type;
	}

	public void setType(TypeEntity type) {
		this.type = type;
	}

	public UserEntity getUser() {
		return this.user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

}
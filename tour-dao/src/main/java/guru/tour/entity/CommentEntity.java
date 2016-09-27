package guru.tour.entity;

import java.io.Serializable;
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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String services;

	private String text;

	@Column(name="user_id")
	private int userId;

	//bi-directional many-to-one association to TypeEntity
	@ManyToOne
	private TypeEntity type;

	public CommentEntity() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public TypeEntity getType() {
		return this.type;
	}

	public void setType(TypeEntity type) {
		this.type = type;
	}

}
package guru.tour.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the posts database table.
 * 
 */
@Entity
@Table(name="posts")
@NamedQuery(name="PostEntity.findAll", query="SELECT p FROM PostEntity p")
public class PostEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id = UUID.randomUUID().toString();
	
	@Column(name = "name")
	private String name;


	
	@ManyToOne
	@JoinColumn(name="id_titles")
	private Titles title;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PostEntity(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public PostEntity() {
		super();
	}

	public Titles getTitle() {
		return title;
	}

	public void setTitle(Titles title) {
		this.title = title;
	}
		
}
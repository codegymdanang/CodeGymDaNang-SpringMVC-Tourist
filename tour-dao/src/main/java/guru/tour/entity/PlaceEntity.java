package guru.tour.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="place")
public class PlaceEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	@Column(name = "images")
	private String images;
	
	@Column(name = "description")
	private String description;
	@Column(name = "local_id")
	private int localID;
	
	
	public PlaceEntity() {
		super();
	}
	
	public PlaceEntity(int id, String name, String images, String description, int localID) {
		super();
		this.id = id;
		this.name = name;
		this.images = images;
		this.description = description;
		this.localID = localID;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLocalID() {
		return localID;
	}

	public void setLocalID(int localID) {
		this.localID = localID;
	}
	
}

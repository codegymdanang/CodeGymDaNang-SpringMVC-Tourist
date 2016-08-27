package guru.tour.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hotnews")
public class HotNewsEntity {

	public HotNewsEntity() {
		super();
	}

	public HotNewsEntity(int id, String name) {
		this.hotnewsId = id;
		this.name = name;
	}

	public HotNewsEntity(String name, String description, String image) {
		this.name = name;
		this.description = description;
		this.image = image;
	}

	public HotNewsEntity(int id, String name, String description, String image) {
		this.hotnewsId = id;
		this.description = description;
		this.name = name;
		this.image = image;

	}

	@Id
	@GeneratedValue
	@Column(name = "hotnewsId")
	private int hotnewsId;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "image")
	private String image;

	public int getHotnewsId() {
		return hotnewsId;
	}

	public void setHotnewsId(int hotnewsId) {
		this.hotnewsId = hotnewsId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}

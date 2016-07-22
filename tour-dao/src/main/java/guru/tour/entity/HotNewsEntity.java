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

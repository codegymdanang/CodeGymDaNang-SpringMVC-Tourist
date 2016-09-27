package guru.tour.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hotnews database table.
 * 
 */
@Entity
@Table(name="hotnews")
@NamedQuery(name="HotNewEntity.findAll", query="SELECT h FROM HotNewEntity h")
public class HotNewEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String hotnewsId;

	private String description;

	private String image;

	private String name;

	

	public String getHotnewsId() {
		return this.hotnewsId;
	}

	public void setHotnewsId(String hotnewsId) {
		this.hotnewsId = hotnewsId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public HotNewEntity() {
		super();
	}

	public HotNewEntity(String hotnewsId, String name) {
		this.hotnewsId = hotnewsId;
		this.name = name;
	}

	public HotNewEntity(String name, String description, String image) {
		this.name = name;
		this.description = description;
		this.image = image;
	}

	public HotNewEntity(String hotnewsId, String name, String description, String image) {
		this.hotnewsId = hotnewsId;
		this.description = description;
		this.name = name;
		this.image = image;

	}

}
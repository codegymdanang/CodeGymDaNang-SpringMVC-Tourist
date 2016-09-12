package guru.tour.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hotnews database table.
 * 
 */
@Entity
@Table(name="hotnews")
@NamedQuery(name="HotnewEntity.findAll", query="SELECT h FROM HotnewEntity h")
public class HotnewEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int hotnewsId;

	private String description;

	private String image;

	private String name;

	public HotnewEntity() {
	}

	public int getHotnewsId() {
		return this.hotnewsId;
	}

	public void setHotnewsId(int hotnewsId) {
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

}
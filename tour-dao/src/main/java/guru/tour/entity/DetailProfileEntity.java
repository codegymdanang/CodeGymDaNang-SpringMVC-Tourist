package guru.tour.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;


/**
 * The persistent class for the detailprofile database table.
 * 
 */
@Entity
@Table(name="detailprofile")
@NamedQuery(name="DetailProfileEntity.findAll", query="SELECT d FROM DetailProfileEntity d")
public class DetailProfileEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id = UUID.randomUUID().toString();

	private String favorite;

	private String hobby;

	private String language;

	public DetailProfileEntity() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFavorite() {
		return this.favorite;
	}

	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}

	public String getHobby() {
		return this.hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
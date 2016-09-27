package guru.tour.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the host database table.
 * 
 */
@Entity
@Table(name="host")
@NamedQuery(name="HostEntity.findAll", query="SELECT h FROM HostEntity h")
public class HostEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id = UUID.randomUUID().toString();

	private String images;

	private String name;

	private int phone;

	//bi-directional many-to-one association to ProfileEntity
	@OneToMany(mappedBy="host")
	private List<ProfileEntity> profiles;

	public HostEntity() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImages() {
		return this.images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return this.phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public List<ProfileEntity> getProfiles() {
		return this.profiles;
	}

	public void setProfiles(List<ProfileEntity> profiles) {
		this.profiles = profiles;
	}

	public ProfileEntity addProfile(ProfileEntity profile) {
		getProfiles().add(profile);
		profile.setHost(this);

		return profile;
	}

	public ProfileEntity removeProfile(ProfileEntity profile) {
		getProfiles().remove(profile);
		profile.setHost(null);

		return profile;
	}

}
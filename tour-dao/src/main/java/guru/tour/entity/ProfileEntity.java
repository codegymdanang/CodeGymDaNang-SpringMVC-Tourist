package guru.tour.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;


/**
 * The persistent class for the profile database table.
 * 
 */
@Entity
@Table(name="profile")
@NamedQuery(name="ProfileEntity.findAll", query="SELECT p FROM ProfileEntity p")
public class ProfileEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id = UUID.randomUUID().toString();

	private String duration;

	private String price;

	private String summary;

	private String title;

	//bi-directional many-to-one association to HostEntity
	@ManyToOne
	@JoinColumn(name="id_host")
	private HostEntity host;

	public ProfileEntity() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDuration() {
		return this.duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public HostEntity getHost() {
		return this.host;
	}

	public void setHost(HostEntity host) {
		this.host = host;
	}

}
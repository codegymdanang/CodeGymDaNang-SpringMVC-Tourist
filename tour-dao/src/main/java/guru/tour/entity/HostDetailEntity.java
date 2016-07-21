package guru.tour.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "profile")
public class HostDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "title")
	private String title;
	@Column(name = "summary")
	private String summary;
	@Column(name = "price")
	private String price;
	@Column(name = "duration")
	private String duration;
	@Column(name = "id_host")
	private int hostId;

	// cascade = {CascadeType.ALL},
	@OneToOne()
	@JoinColumn(name = "id_host", insertable = false, updatable = false)
	private ServiceHostEntity serviceHostEntity;

	public HostDetailEntity() {

	}

	public HostDetailEntity(ServiceHostEntity serviceHostEntity) {
		this.serviceHostEntity = serviceHostEntity;
	}

	public ServiceHostEntity getServiceHostEntity() {
		return serviceHostEntity;
	}

	public void setServiceHostEntity(ServiceHostEntity serviceHostEntity) {
		this.serviceHostEntity = serviceHostEntity;
	}

	@PrimaryKeyJoinColumn
	public int getHostId() {
		hostId = serviceHostEntity.getId();
		return hostId;
	}

	public void setHostId(int hostId) {
		this.hostId = hostId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "HostDetailEntity [id=" + id + ", title=" + title + ", summary=" + summary + ", price=" + price
				+ ", duration=" + duration + ", hostId=" + hostId + ", serviceHostEntity=" + serviceHostEntity + "]";
	}
}

package guru.tour.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "event")
public class EventEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "startday")
	private Date startday;

	@Column(name = "endday")
	private Date endday;
	
	@Column(name = "local_id")
	private int local_id;
	
	@Column(name = "add_id")
	private int address_id;
	
	@ManyToOne
	@JoinColumn(name = "local_id", insertable=false, updatable=false)
	private LocationEntity event_location;
	
	@ManyToOne
	@JoinColumn(name = "add_id", insertable=false, updatable=false)
	private AddressEntity event_add;
	
	@Override
	public String toString() {
		return "EventEntity [id=" + id + ", name=" + name + ", description=" + description + ", startday=" + startday
				+ ", endday=" + endday + ", local_id=" + local_id + "]";
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartday() {
		return startday;
	}

	public void setStartday(Date startday) {
		this.startday = startday;
	}

	public Date getEndday() {
		return endday;
	}

	public void setEndday(Date endday) {
		this.endday = endday;
	}

	public int getLocal_id() {
		return local_id;
	}

	public void setLocal_id(int local_id) {
		this.local_id = local_id;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	
}

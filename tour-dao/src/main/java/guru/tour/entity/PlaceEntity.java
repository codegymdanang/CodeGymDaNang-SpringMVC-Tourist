package guru.tour.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;





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
	
/*	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="local_id",insertable=false, updatable=false)
	@JsonManagedReference
	private LocationEntity local;*/
	
	@ManyToOne
	@JoinColumn(name="local_id", insertable = false, updatable = false)
	private LocationEntity location;
	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "placeEntity",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<AddressEntity> listAddr;
	
	
	
	public List<AddressEntity> getListAddr() {
		return listAddr;
	}

	public void setListAddr(List<AddressEntity> listAddr) {
		this.listAddr = listAddr;
	}
	
	//bi-directional many-to-one association to UserSchedule
		@OneToMany(mappedBy="place",cascade=CascadeType.ALL, fetch=FetchType.EAGER)	
		private Set<UserSchedule> userSchedules = new HashSet<UserSchedule>();
		
		public Set<UserSchedule> getUserSchedules() {
			return userSchedules;
		}

		public void setUserSchedules(Set<UserSchedule> userSchedules) {
			this.userSchedules = userSchedules;
		}

		
			
	public LocationEntity getLocation() {
			return location;
		}

		public void setLocation(LocationEntity location) {
			this.location = location;
		}

	
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

package guru.tour.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="location")
public class LocationEntity {
	
	@Id
	@GeneratedValue( strategy=GenerationType.AUTO )
	@Column(name = "location_id")
	private int id;
	@Column(name = "location_name")
	private String name;
	
	  @OneToMany(targetEntity=HotelEntity.class ,cascade = CascadeType.ALL, orphanRemoval = true)
	  @LazyCollection(LazyCollectionOption.FALSE)
	  @JoinColumn(name = "location_id")
	private List<HotelEntity> ListHotel = new ArrayList<HotelEntity>();

	public LocationEntity(int id, String name, List<HotelEntity> listhotel) {
		super();
		this.id = id;
		this.name = name;
		this.ListHotel = listhotel;
	}

	public LocationEntity() {
		super();
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

	public List<HotelEntity> getListHotel() {
		return ListHotel;
	}

	public void setListHotel(List<HotelEntity> listHotel) {
		ListHotel = listHotel;
	}
	
}

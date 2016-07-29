package guru.tour.entity;


import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "location")
public class LocationEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "location_id")
	private int id;
	@Column(name = "location_name")
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "locationEntity")
	private List<FoodEntity> food = new ArrayList<FoodEntity>();
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "locationEntity",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<PlaceEntity> listPlace;
	
	public List<PlaceEntity> getListPlace() {
		return listPlace;
	}
	public void setListPlace(List<PlaceEntity> listPlace) {
		this.listPlace = listPlace;
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
	public List<FoodEntity> getFood() {
		return food;
	}
	public void setFood(List<FoodEntity> food) {
		this.food = food;
	}
}

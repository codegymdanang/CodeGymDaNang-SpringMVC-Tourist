package guru.tour.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "type")
public class TypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "typeEntity")
	@JsonIgnore
	private List<HotelEntity> food = new ArrayList<HotelEntity>();
	
	public TypeEntity() {
		// TODO Auto-generated constructor stub
	}

	public TypeEntity(int id, String name, List<HotelEntity> food) {
		super();
		this.id = id;
		this.name = name;
		this.food = food;
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

	public List<HotelEntity> getFood() {
		return food;
	}

	public void setFood(List<HotelEntity> food) {
		this.food = food;
	}
	
	
}

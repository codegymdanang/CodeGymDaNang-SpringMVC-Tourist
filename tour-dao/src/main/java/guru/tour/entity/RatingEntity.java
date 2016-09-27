package guru.tour.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rating database table.
 * 
 */
@Entity
@Table(name="rating")
@NamedQuery(name="RatingEntity.findAll", query="SELECT r FROM RatingEntity r")
public class RatingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int number;

	private String service;

	@Column(name="type_id")
	private int typeId;

	//bi-directional many-to-one association to UserEntity
	@ManyToOne
	private UserEntity user;

	public RatingEntity() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getService() {
		return this.service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public int getTypeId() {
		return this.typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public UserEntity getUser() {
		return this.user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

}
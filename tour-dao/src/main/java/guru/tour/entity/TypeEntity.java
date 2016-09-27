package guru.tour.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the type database table.
 * 
 */
@Entity
@Table(name="type")
@NamedQuery(name="TypeEntity.findAll", query="SELECT t FROM TypeEntity t")
public class TypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id = UUID.randomUUID().toString();

	private String name;

	//bi-directional many-to-one association to CommentEntity
	@OneToMany(mappedBy="type")
	private List<CommentEntity> comments;

	//bi-directional many-to-one association to HotelEntity
	@OneToMany(mappedBy="type")
	private List<HotelEntity> hotels;

	//bi-directional many-to-one association to VehicalEntity
	@OneToMany(mappedBy="type")
	private List<VehicalEntity> vehicals;

	public TypeEntity() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CommentEntity> getComments() {
		return this.comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}

	public CommentEntity addComment(CommentEntity comment) {
		getComments().add(comment);
		comment.setType(this);

		return comment;
	}

	public CommentEntity removeComment(CommentEntity comment) {
		getComments().remove(comment);
		comment.setType(null);

		return comment;
	}

	public List<HotelEntity> getHotels() {
		return this.hotels;
	}

	public void setHotels(List<HotelEntity> hotels) {
		this.hotels = hotels;
	}

	public HotelEntity addHotel(HotelEntity hotel) {
		getHotels().add(hotel);
		hotel.setType(this);

		return hotel;
	}

	public HotelEntity removeHotel(HotelEntity hotel) {
		getHotels().remove(hotel);
		hotel.setType(null);

		return hotel;
	}

	public List<VehicalEntity> getVehicals() {
		return this.vehicals;
	}

	public void setVehicals(List<VehicalEntity> vehicals) {
		this.vehicals = vehicals;
	}

	public VehicalEntity addVehical(VehicalEntity vehical) {
		getVehicals().add(vehical);
		vehical.setType(this);

		return vehical;
	}

	public VehicalEntity removeVehical(VehicalEntity vehical) {
		getVehicals().remove(vehical);
		vehical.setType(null);

		return vehical;
	}

}
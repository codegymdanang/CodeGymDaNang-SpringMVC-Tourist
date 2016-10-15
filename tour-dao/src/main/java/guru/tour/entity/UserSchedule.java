package guru.tour.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "userschedule")
public class UserSchedule implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	private String id = UUID.randomUUID().toString();

	@ManyToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private UserEntity userSchedule;

	@ManyToOne
	@JoinColumn(name = "place_id", insertable = true, updatable = false)
	private PlaceEntity place;

	@Version
	@Column(name = "versionNo")
	private int versionNo;

	@CreatedDate
	@Column(name = "createdDate")
	private Date createdDate;

	@LastModifiedDate
	@Column(name = "updatedDate")
	private Date updatedDate;

	@CreatedBy
	@Column(name = "createdBy")
	private String createdBy;

	@LastModifiedBy
	@Column(name = "updatedBy")
	private String updatedBy;

	@Column(name = "startDay")
	private Date startDay;

	@Column(name = "endDay")
	private Date endDay;

	@Column(name = "status")
	private int status;

	public UserSchedule() {
		super();
	}

	public UserSchedule(PlaceEntity placeEntity, int status) {
		super();
		this.place = placeEntity;
		this.status = status;
	}

	public PlaceEntity getPlace() {
		return place;
	}

	public void setPlace(PlaceEntity place) {
		this.place = place;
	}

	public UserEntity getUser() {
		return userSchedule;
	}

	public void setUser(UserEntity user) {
		this.userSchedule = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(int versionNo) {
		this.versionNo = versionNo;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getStartDay() {
		return startDay;
	}

	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}

	public Date getEndDay() {
		return endDay;
	}

	public void setEndDay(Date endDay) {
		this.endDay = endDay;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}

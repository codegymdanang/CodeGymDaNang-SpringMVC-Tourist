package guru.tour.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.UUID;


/**
 * The persistent class for the userschedule database table.
 * 
 */
@Entity
@Table(name="userschedule")
@NamedQuery(name="UserScheduleEntity.findAll", query="SELECT u FROM UserScheduleEntity u")
public class UserScheduleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id = UUID.randomUUID().toString();

	private String createdBy;

	@Temporal(TemporalType.DATE)
	private Date createdDate;

	@Temporal(TemporalType.DATE)
	private Date endDay;

	@Temporal(TemporalType.DATE)
	private Date startDay;

	private int status;

	private String updatedBy;

	@Temporal(TemporalType.DATE)
	private Date updatedDate;

	private int versionNo;

	//bi-directional many-to-one association to PlaceEntity
	@ManyToOne
	private PlaceEntity place;

	//bi-directional many-to-one association to UserEntity
	@ManyToOne
	private UserEntity user;

	public UserScheduleEntity() {
	}

	/**
     * @param placeEntity
     * @param status2
     */
    public UserScheduleEntity(PlaceEntity placeEntity, int status) {
       this.place = placeEntity;
       this.status = status;
    }

    public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getEndDay() {
		return this.endDay;
	}

	public void setEndDay(Date endDay) {
		this.endDay = endDay;
	}

	public Date getStartDay() {
		return this.startDay;
	}

	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public int getVersionNo() {
		return this.versionNo;
	}

	public void setVersionNo(int versionNo) {
		this.versionNo = versionNo;
	}

	public PlaceEntity getPlace() {
		return this.place;
	}

	public void setPlace(PlaceEntity place) {
		this.place = place;
	}

	public UserEntity getUser() {
		return this.user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

}
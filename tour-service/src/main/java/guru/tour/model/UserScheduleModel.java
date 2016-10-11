package guru.tour.model;

import java.util.Date;

public class UserScheduleModel {	
	private String place_id;
	private int status;
	private int versionNo;
	private Date createdDate;
	private Date startDay;
	private Date endDay;

	public UserScheduleModel() {
		super();
	}

	public UserScheduleModel(String place_id, int status) {
		super();
		this.place_id = place_id;
		this.status = status;
	}

	public int getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(int versionNo) {
		this.versionNo = versionNo;
	}

	public String getPlace_id() {
		return place_id;
	}

	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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

}

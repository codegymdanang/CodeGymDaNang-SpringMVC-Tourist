package guru.tour.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@SuppressWarnings("serial")
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractAuditableEntity implements Serializable{

    @Id
    private Integer id_audit;
    @LastModifiedDate
    private Date lastUpdated;
    @LastModifiedBy
    private String lastUpdateUser;
    @CreatedDate
    private Date created;
    @CreatedBy
    private String createUser;
        
    public Integer getId_audit() {
		return id_audit;
	}
	public void setId_audit(Integer id_audit) {
		this.id_audit = id_audit;
	}
	public Date getLastUpdated() {
        return lastUpdated;
    }
    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
    public String getLastUpdateUser() {
        return lastUpdateUser;
    }
    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
    public String getCreateUser() {
        return createUser;
    }
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
   
    
}


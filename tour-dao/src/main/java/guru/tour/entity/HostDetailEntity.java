package guru.tour.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "profile")
public class HostDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy=GenerationType.AUTO )
	private Integer id;

	@Column(name = "title")
	private String title;
	@Column(name = "price")
	private String price;
	
//	@OneToOne
//	private ServiceHostEntity serviceHostEntity;

	public HostDetailEntity() {

	}

	public HostDetailEntity(Integer id, String title, String price) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
	}

	@Override
	public String toString() {
		return "ServiceHostDetailEntity [id=" + id + ", name=" + title + ", phone=" + price + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	
	
}

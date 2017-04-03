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
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="titles")
public class Titles implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="title")
	private String title;

	
	@OneToMany(mappedBy = "title")
	private List<PostEntity> list=new ArrayList<PostEntity>();
	
	public Titles(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<PostEntity> getList() {
		return list;
	}

	public void setList(List<PostEntity> list) {
		this.list = list;
	}

	public Titles(int id, String title, List<PostEntity> list) {
		super();
		this.id = id;
		this.title = title;
		this.list = list;
	}

	
	
	
}

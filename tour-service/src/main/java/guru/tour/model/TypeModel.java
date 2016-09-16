package guru.tour.model;

public class TypeModel {
	String id ;
	String name;
	public TypeModel(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public TypeModel() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

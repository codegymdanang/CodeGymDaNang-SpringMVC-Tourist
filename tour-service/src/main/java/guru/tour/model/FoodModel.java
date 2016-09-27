package guru.tour.model;

public class FoodModel {
	private String id;
	private String description;
	private String images;
	private String name;
	private String phone;
	private double price;
	
	private LocationModel location;

	public FoodModel() {
		super();
	}
	
	public FoodModel(String id, String description, String images, String name, String phone, double price,
			LocationModel location) {
		super();
		this.id = id;
		this.description = description;
		this.images = images;
		this.name = name;
		this.phone = phone;
		this.price = price;
		this.location = location;
	}



	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImages() {
		return this.images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocationModel getLocation() {
		return this.location;
	}

	public void setLocation(LocationModel location) {
		this.location = location;
	}
}

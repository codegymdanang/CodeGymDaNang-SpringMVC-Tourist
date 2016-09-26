package guru.tour.model;




public class HotelModel {
	private String hotelId;

	private String description;

	private String hotelName;

	private String images;
	
	private int phone;
	
	private double price;

	//bi-directional many-to-one association to LocationModel
	private LocationModel location;

	//bi-directional many-to-one association to TypeModel
	private TypeModel type;

	public HotelModel() {
	}
	
	
	public HotelModel(String hotelId, String description, String hotelName, String images, int phone, double price,
			LocationModel location, TypeModel type) {
		super();
		this.hotelId = hotelId;
		this.description = description;
		this.hotelName = hotelName;
		this.images = images;
		this.phone = phone;
		this.price = price;
		this.location = location;
		this.type = type;
	}


	public String getHotelId() {
		return this.hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHotelName() {
		return this.hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getImages() {
		return this.images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public int getPhone() {
		return this.phone;
	}

	public void setPhone(int phone) {
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

	public TypeModel getType() {
		return this.type;
	}

	public void setType(TypeModel type) {
		this.type = type;
	}

}

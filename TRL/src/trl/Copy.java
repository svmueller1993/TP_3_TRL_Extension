package trl;

public class Copy {

	String id;
	String condition;
	double price;
	boolean rented;

	public Copy(String id, String condition, boolean rented, Textbook textbook) {//Copy is a copy of a Textbook so they need to be coupled 
		super();
		this.id = id;
		this.condition = condition;
		this.rented = rented;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}

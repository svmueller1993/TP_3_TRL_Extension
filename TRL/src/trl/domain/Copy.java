package trl.domain;

import java.util.ArrayList;

public class Copy {

	private String id;
	private String condition;
	private double price;
	private boolean rented;
	private String textbookId;
	private ArrayList<String> audit = new ArrayList<String>();
	

	public Copy(String id, String condition, double price, boolean rented, String textbookId) {
		super();
		this.id = id;
		this.condition = condition;
		this.price = price;
		this.rented = rented;
		this.textbookId = textbookId;
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

	public String getTextbookId() {
		return textbookId;
	}

	public void setTextbookId(String textbookId) {
		this.textbookId = textbookId;
	}
	
	public void setAudit(String patron, String returnedCondition, String dateReturned )
	{
		String information = patron + ", " + returnedCondition + ", " + dateReturned;
		audit.add(information);
	}
	
	public ArrayList<String> getAudit() //checkout history of copy
	{
		for(int i = 0; i < audit.size(); i++)
		{
			System.out.println(audit.get(i));
		}
		
		return audit; 
	}

	@Override
	public String toString() {
		return "Copy [id= " + id + ", condition= " + condition + ", price= " + price + ", rented= " + rented
				+ ", textbookId= " + textbookId + "]";
	}

}

package trl;

public class Hold {

	private String id;
	private String type;
	private String decription;
	private double fine;
	private boolean resolved;

	public Hold(String id, String type, String decription, double fine) {
		super();
		this.id = id;
		this.type = type;
		this.decription = decription;
		this.fine = fine;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public double getFine() {
		return fine;
	}

	public void setFine(double fine) {
		this.fine = fine;
	}

	public boolean isResolved() {
		return resolved;
	}

	public void setResolved(boolean resolved) {
		this.resolved = resolved;
	}

}

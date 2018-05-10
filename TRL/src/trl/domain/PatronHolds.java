package trl.domain;

public class PatronHolds {

	String id;
	String patronId;
	String holdId;

	public PatronHolds(String id, String patronId, String holdId) {
		super();
		this.id = id;
		this.patronId = patronId;
		this.holdId = holdId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPatronId() {
		return patronId;
	}

	public void setPatronId(String patronId) {
		this.patronId = patronId;
	}

	public String getHoldId() {
		return holdId;
	}

	public void setHoldId(String holdId) {
		this.holdId = holdId;
	}

}

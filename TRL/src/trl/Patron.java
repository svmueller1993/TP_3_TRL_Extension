package trl;

public class Patron {

	String patronId;
	String firstName;
	String lastName;
	String phone;
	boolean active;
	String accountType;
	String address;
	boolean overdueHold;

	public Patron(String patronId, String firstName, String lastName) {
		super();
		this.patronId = patronId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getPatronId() {
		return patronId;
	}

	public void setPatronId(String patronId) {
		this.patronId = patronId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isOverdueHold() {
		return overdueHold;
	}

	public void setOverdueHold(boolean overdueHold) {
		this.overdueHold = overdueHold;
	}

}

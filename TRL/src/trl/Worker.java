package trl;

public class Worker {
	private String workerId;
	private String firstName;
	String lastName;
	String password;

	public Worker(String workerId, String firstName, String lastName, String password) {
		super();
		this.workerId = workerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

	public String getWorkerId() {
		return workerId;
	}

	public void setWorkerId(String workerId) {
		this.workerId = workerId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

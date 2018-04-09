package trl;

import java.util.Date;

public class PatronCopies {

	String id;
	String patronId;
	String copyId;
	Date dueDate;
	Date checkOutDate;
	Date checkInDate;

	public PatronCopies(String id, String patronId, String copyId, Date dueDate, Date checkOutDate, Date checkInDate) {
		super();
		this.id = id;
		this.patronId = patronId;
		this.copyId = copyId;
		this.dueDate = dueDate;
		this.checkOutDate = checkOutDate;
		this.checkInDate = checkInDate;
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

	public String getCopyId() {
		return copyId;
	}

	public void setCopyId(String copyId) {
		this.copyId = copyId;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	@Override
	public String toString() {
		return "PatronCopies [id= " + id + ", patronId= " + patronId + ", copyId= " + copyId + ", dueDate= " + dueDate
				+ ", checkOutDate= " + checkOutDate + ", checkInDate= " + checkInDate + "]";
	}

}

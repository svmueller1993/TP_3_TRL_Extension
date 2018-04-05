package trl;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class CheckOutSession {
	
	List<Copy> copies = new ArrayList<Copy>();
	Patron currentPatron = null;
	String patronId;
	Date date = new Date();
	
	public CheckOutSession(Patron patron)
	{
		currentPatron = patron;
		patronId = currentPatron.getPatronId();
		
		
	}
	
	
	public void checkOutCopy(Copy copy)
	{
		String copyID = copy.getId();
		copy.setRented(true);
		
	}

}

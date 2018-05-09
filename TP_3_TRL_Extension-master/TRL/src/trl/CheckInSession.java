package trl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * UI helper class implements check in textbook copy UI logic.
 * 
 */
public class CheckInSession {
	List<Copy> copies = new ArrayList<Copy>();
	Patron patron = null;
	Date date = new Date();
	TPLController controller;
	private Scanner scanner = new Scanner(System.in);

	public CheckInSession(Patron patron, TPLController controller) 
	{
		this.patron = patron;
		this.controller = controller;
	}
	
	/**
	 * Starts check in process. Requests enter copy id and validates textbook copy.
	 */
	public void start() {
		
		do {
			System.out.println("Please enter the copy Id of the copy being checked in:");
			String copyId = scanner.nextLine();
			Copy copy = controller.validateCopy(copyId);
			if ( copy == null) 
			{
				System.out.println("Invalid copy Id.");
			} 
			
			else 
			{
				for (Copy c : copies) {
					if (c.getId().equals(copy.getId()))
					{
						System.out.println("Already entered copy Id.");
						copy = null;
						break;
					}
					
				}
				
				if (copy != null && !copy.isRented()) {
					System.out.println("Records show that this copy has not been rented");
					copy = null;
				}
				
				if (copy != null) {
					Textbook textbook = controller.getTextbook(copy.getTextbookId());
					System.out.println(textbook);
					copies.add(copy);
				}
			}
			System.out.println("Do you want to enter another copy Id?(y/n)");
			
		} while ("Y".equalsIgnoreCase(scanner.nextLine()));
	}

	/**
	 * Displays check-in copy list and completes checking in textbook copies.
	 */
	public void checkInCopies() {
		if (!copies.isEmpty()) {
			System.out.println("Check In Copies:");
			for (Copy copy : copies) {
				Textbook textbook = controller.getTextbook(copy.getTextbookId());
				System.out.println(textbook);
			}
			System.out.println("Do you want check in the above copies?(y/n)");
			if("Y".equalsIgnoreCase(scanner.nextLine())){
				controller.checkInCopies(patron, copies);
				System.out.println("\nCheck in completed.");
			}
		} else {
			System.out.println("No copies to check in.");
		}
	}
}

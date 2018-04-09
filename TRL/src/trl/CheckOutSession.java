package trl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;
/**
 * UI helper class implements check out textbook copy UI logic.
 * 
 */
public class CheckOutSession {

	List<Copy> copies = new ArrayList<Copy>();
	Patron patron = null;
	Date date = new Date();
	TPLController controller;
	private Scanner scanner = new Scanner(System.in);

	public CheckOutSession(Patron patron, TPLController controller) {
		this.patron = patron;
		this.controller = controller;
	}
	
	/**
	 * Starts check out process. Requests enter copy id and validates textbook copy.
	 */
	public void start() {
		do {
			System.out.println("Please, enter check out copy Id:");
			String copyId = scanner.nextLine();
			Copy copy = controller.validateCopy(copyId);
			if ( copy == null) {
				System.out.println("Invalid copy Id.");
			} else {
				for (Copy c : copies) {
					if (c.getId().equals(copy.getId())) {
						System.out.println("Already entered copy Id.");
						copy = null;
						break;
					}
					if (c.getTextbookId().equals(copy.getTextbookId())) {
						System.out.println("In this transaction, only one copy allowed for each textbook.");
						copy = null;
						break;
					}
				}
				
				if (copy != null && copy.isRented()) {
					System.out.println("Records show that this copy is already rented.");
					copy = null;
				}
				
				if (copy != null) {
					Textbook textbook = controller.getTextbook(copy.getTextbookId());
					System.out.println(textbook);
					copies.add(copy);
				}
			}
			System.out.println("Do you want enter another copy Id?(y/n)");
		} while ("Y".equalsIgnoreCase(scanner.nextLine()));
	}

	/**
	 * Displays checkout copy list and completes checkout textbook copies.
	 */
	public void checkOutCopies() {
		if (!copies.isEmpty()) {
			System.out.println("Check Out Copies:");
			for (Copy copy : copies) {
				Textbook textbook = controller.getTextbook(copy.getTextbookId());
				System.out.println(textbook);
			}
			System.out.println("Do you want check out above copies?(y/n)");
			if("Y".equalsIgnoreCase(scanner.nextLine())){
				controller.checkoutCopies(patron, copies);
				System.out.println("Check out completed.");
			}
		} else {
			System.out.println("No copies to check out.");
		}
	}

}

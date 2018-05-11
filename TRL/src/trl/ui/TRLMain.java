package trl.ui;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import trl.controller.TPLController;
import trl.domain.Copy;
import trl.domain.Manager;
import trl.domain.Patron;
import trl.domain.PatronCopies;
import trl.domain.Textbook;
import trl.domain.TitleManager;
import trl.domain.Worker;

public class TRLMain {

	private String title = "  _______        _   _                 _       _____            _        _    _      _ _                          \r\n"
			+ " |__   __|      | | | |               | |     |  __ \\          | |      | |  | |    (_) |                         \r\n"
			+ "    | | _____  _| |_| |__   ___   ___ | | __  | |__) |___ _ __ | |_ __ _| |  | |     _| |__  _ __ __ _ _ __ _   _ \r\n"
			+ "    | |/ _ \\ \\/ / __| '_ \\ / _ \\ / _ \\| |/ /  |  _  // _ \\ '_ \\| __/ _` | |  | |    | | '_ \\| '__/ _` | '__| | | |\r\n"
			+ "    | |  __/>  <| |_| |_) | (_) | (_) |   <   | | \\ \\  __/ | | | || (_| | |  | |____| | |_) | | | (_| | |  | |_| |\r\n"
			+ "    |_|\\___/_/\\_\\\\__|_.__/ \\___/ \\___/|_|\\_\\  |_|  \\_\\___|_| |_|\\__\\__,_|_|  |______|_|_.__/|_|  \\__,_|_|   \\__, |\r\n"
			+ "                                                                                                             __/ |\r\n"
			+ "                                                                                                            |___/ ";
	private Scanner scanner = new Scanner(System.in);
	private TPLController controller = new TPLController();
	private Worker worker;

	public void launch() {
		while (true) {
			if (worker == null) {
				int i = displayMenu(new String[] { "Login", "Exit", "Help" });
				switch (i) {
				case 1:
					login();
					break;
				case 2:
					System.exit(0);
					break;
				case 3:
					displayHelp();
					break;
				}
			} else if (worker instanceof TitleManager) {
				int i = displayMenu(new String[] { "Add Textbook", "Add Copies", "Show Textbook Details", "Remove Textbook and Copies", "Remove Copy", "Logout", "Help" });
				switch (i) {
				case 1:
					addTextbook();
					break;
				case 2:
					addCopy();
					break;
				case 3:
					showTextbookDetails();
					break;
				case 4:
					removeText();
					break;
				case 5: 
					removeCopy();
					break;
				case 6:
					logout();
					break;
				case 7:
					displayHelp();
					break;
				}
				//Worker needs to be able to check in and out texts too
			} else if (worker instanceof Manager || worker != null) {
				int i = displayMenu(new String[] { "Check Out a Textbook", "Check In a Textbook", "Show Patron Details",
						"Resolve Hold", "Logout", "Help" });
				switch (i) {
				case 1:
					startCheckOutSession();
					break;
				case 2:
					startCheckInSession();
					break;
				case 3:
					showPatronDetails();
					break;
				case 4:
					resolveHold();
					break;
				case 5:
					logout();
					break;
				case 6:
					displayHelp();
					break;
				}
			} 
		}
	}

	private void showTextbookDetails() {
		System.out.println("Enter Textbook ID or ISBN:");
		String textbookId = scanner.nextLine();
		if (textbookId == null || textbookId.isEmpty()) {
			System.out.println("Textbook ID or ISBN can not be empty.");
			return;
		}
		
		Textbook textbook = controller.getTextbook(textbookId);
		System.out.println("Textbook Details:" + textbook);
	}

	private void addCopy() {
		System.out.println("Enter Textbook ID:");
		String textbookId = scanner.nextLine();
		if (textbookId == null || textbookId.isEmpty()) {
			System.out.println("Textbook ID can not be empty.");
			return;
		}
		System.out.println("Enter Number of Copies:");
		int n = scanner.nextInt();
		if (n < 1) {
			System.out.println("Number of Copies can not less than 1.");
			return;
		}
		
		String[] copyIds = controller.addCopies(textbookId, n);
		System.out.println("Following Textbook Copy Ids added:" + Arrays.toString(copyIds));
	}

	private void addTextbook() {
		System.out.println("Enter Textbook Details:");
		System.out.print("ISBN:");
		String isbn = scanner.nextLine();
		System.out.print("Title:");
		String title = scanner.nextLine();
		System.out.print("Author:");
		String author = scanner.nextLine();
		
		if (isbn == null || isbn.isEmpty()) {
			System.out.println("Textbook ISBN can not be empty.");
			return;
		}
		
		if (title == null || title.isEmpty()) {
			System.out.println("Textbook Title can not be empty.");
			return;
		}
		
		if (author == null || author.isEmpty()) {
			System.out.println("Textbook Author can not be empty.");
			return;
		}
		
		try {
			Textbook textbook = controller.addTextbook(isbn, title, author);
			System.out.println("Added following textbook:" + textbook.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	private void showPatronDetails() {
		Patron patron = validatePatron();
		if (patron != null) {
			System.out.println("Patron Details:");
			System.out.println(patron);
			List<PatronCopies> pc = controller.getPatronCopies(patron.getPatronId());
			if (!pc.isEmpty()) {
				System.out.println("Patron Copies:");
				for (PatronCopies patronCopy : pc) {
					System.out.println(patronCopy);
					Copy copy = controller.validateCopy(patronCopy.getCopyId());
					System.out.println("\t" + copy);
					System.out.println("\t\t" + controller.getTextbook(copy.getTextbookId()));
				}
			}
		}
	}

	private void logout() {
		System.out.println("\nLogged out.\n");
		worker = null;
	}

	private void login() {
		System.out.print("\nEnter login name:");
		String login = scanner.nextLine();
		System.out.print("Enter password:");
		String password = scanner.nextLine();
		worker = controller.login(login, password);
		if (worker != null) {
			System.out.println("\nWelcome to Textbook Rental Library.\n");
		} else {
			System.out.println("Invalid login name or password.");
		}
	}

	private void displayHelp() {
		System.out.println("\nHELP");
		System.out.println("For demo use login \"worker\" and password \"worker\".");
		System.out.println("Press Enter to continue...");
		scanner.nextLine();
	}

	public void displayAppTitle() {
		System.out.println(title);
	}

	public int displayMenu(String[] arr) {
		int selection = 0;
		boolean displayErrorMsg = false;
		while (true) {
			if (displayErrorMsg) {
				System.out.println("\nInvalid selection, please select option again.");
			}
			System.out.println("\nMENU OPTIONS");
			System.out.println("--------------------------------------------");
			for (int j = 0; j < arr.length; j++) {
				System.out.println("\t" + (j + 1) + ". " + arr[j]);
			}
			System.out.println("--------------------------------------------");
			System.out.print("Select option:");
			try {
				selection = scanner.nextInt();
				scanner.nextLine();
			} catch (InputMismatchException e) {
				scanner.nextLine();
				selection = 0;
			}
			if (0 < selection && selection <= arr.length) {
				break;
			} else {
				displayErrorMsg = true;
			}
		}
		return selection;
	}

	
	public void startCheckInSession() 
	{
		Patron patron = validatePatron();
		CheckInSession checkIn = new CheckInSession(patron, controller);
		checkIn.start();
		if (patron != null) 
		{
			System.out.println(patron);
			
			if(controller.canPatronCheckInCopies(patron, checkIn.copies)) 
			{
				checkIn.checkInCopies();
			}

		}
	}
	
	public void startCheckOutSession() {
		Patron patron = validatePatron();
		if (patron != null) {
			System.out.println(patron);
			if (controller.canPatronCheckoutCopies(patron)) {
				CheckOutSession checkOut = new CheckOutSession(patron, controller);
				checkOut.start();
				checkOut.checkOutCopies();
			} else {
				System.out.println("You can not check out these copies. Please, return overdue copies.");
			}
		}
	}

	public Patron validatePatron() {
		System.out.println("Enter Patron Id:");
		String patronId = scanner.nextLine();
		Patron p = controller.validatePatron(patronId);
		if (p == null) {
			System.out.println("Invalid Patron Id.");
		}
		return p;
	}
	
	public void resolveHold()
	{
		System.out.println("Enter Patron Id:");
		String patronId = scanner.nextLine();
		Patron p = controller.validatePatron(patronId);
		if (p == null) {
			System.out.println("Invalid Patron Id.");
		}
		p.setOverdueHold(false);
		System.out.println("The system has been updated, the hold has been removed.");
	}
	
	public void removeText() 
	{
		System.out.println("Please enter Textbook ID");
		String textbookId = scanner.next();
		System.out.println("Are you sure you want to remove this textbook and its copy? y/n");
		String ans = scanner.next();
		if(ans == "y" && controller.getTextbook(textbookId) != null)
		{
		controller.removeTextbook(textbookId);
		System.out.println("This textbook and all its copies have been removed from inventory");
		}
		
		else
		{
			System.out.println("A textbook with this ID does not exist");
		}
		
	}
	
	public void removeCopy() 
	{
		System.out.println("Please enter Copy ID");
		String copyId = scanner.next();
		System.out.println("Are you sure you want to remove this copy? y/n");
		String ans = scanner.next();
		
		if (ans == "y" && controller.validateCopy(copyId) != null)
		{
			System.out.println("The copy has been removed from inventory");
		}
		
		else
		{
			System.out.println("A copy with this ID does not exist");
		}
		
	}

}

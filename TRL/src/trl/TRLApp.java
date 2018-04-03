package trl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TRLApp {

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

	public static void main(String[] args) {
		TRLApp app = new TRLApp();
		app.displayAppTitle();
		app.launch();
	}
	
	private void launch() {
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
			} else {
				int i = displayMenu(new String[] { "Logout", "Help" });
				switch (i) {
				case 1:
					logout();
					break;
				case 2:
					displayHelp();
					break;
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
			System.out.println("\nWelcome Textbook Rental Library.\n");
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
			System.out.println("\tMENU OPTIONS");
			System.out.println("--------------------------------------------");
			for (int j = 0; j < arr.length; j++) {
				System.out.println("\t" + (j + 1) + ". " + arr[j]);
			}
			System.out.println("--------------------------------------------");
			System.out.print("Select option:");
			try {
			selection = scanner.nextInt();
			scanner.nextLine();
			} catch(InputMismatchException e) {
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
	
}

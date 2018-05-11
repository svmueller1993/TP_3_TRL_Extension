package trl.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import trl.domain.Copy;
import trl.domain.Manager;
import trl.domain.Patron;
import trl.domain.PatronCopies;
import trl.domain.Textbook;
import trl.domain.TitleManager;
import trl.domain.Worker;
/**
 * This class contains business logic.
 *
 */
public class TPLController {
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	
	List<Worker> workers = new ArrayList<Worker>();
	List<Patron> patrons = new ArrayList<Patron>();
	List<Textbook> textbooks = new ArrayList<Textbook>();
	List<Copy> copies = new ArrayList<Copy>();
	List<PatronCopies> patronCopies = new ArrayList<PatronCopies>();

	Scanner sc = new Scanner(System.in);
	public TPLController() {
		loadSampleData();
	}

	/**
	 * Loads sample data.
	 */
	public void loadSampleData() {
		workers.add(new Worker("worker", "Alex", "Kevin", "worker"));
		workers.add(new Manager("manager", "Alex", "Kevin", "manager"));
		workers.add(new TitleManager("tmanager", "Alex", "Kevin", "tmanager"));
		// patrons
		patrons.add(new Patron("1234abs", "Ali", "Anderson", true));
		patrons.add(new Patron("1", "Joe", "Johnson", true));
		patrons.add(new Patron("2", "Alice", "Johnson", true));
		patrons.add(new Patron("3", "Zack", "Burt", true));
		patrons.add(new Patron("4", "Jay", "Juan", true));
		// Textbooks
		textbooks.add(new Textbook("1", "978-1943872077", "Java Programming", "Joel Murach"));
		textbooks.add(new Textbook("2", "978-0321193681",
				"UML Distilled: A Brief Guide to the Standard Object Modeling Language (3rd Edition)",
				"Martin Fowler"));
		textbooks.add(new Textbook("3", "978-1788473699",
				"Mastering Android Development with Kotlin: Deep dive into the world of Android to create robust applications with Kotlin",
				"Milos Vasic"));
		textbooks.add(new Textbook("4", "978-1787125360",
				"Android System Programming: Porting, customizing, and debugging Android HAL", "Roger Ye"));
		// Copies
		int id = 1;
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 6; j++) {
				copies.add(new Copy("" + id, "NEW", 2.00, false, "" + i));
				id++;
			}
		}
		// Patron copies
		try {
			patronCopies.add(new PatronCopies("1", "1", "1", sdf.parse("09/10/2018"), sdf.parse("01/10/2018"), null));
			validateCopy("1").setRented(true);
			patronCopies.add(new PatronCopies("2", "2", "2", sdf.parse("02/10/2018"), sdf.parse("01/10/2018"), null));
			validateCopy("2").setRented(true);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Validates login name and password.
	 * @param login login name
	 * @param password password
	 * @return returns Worker object if login succeeds, otherwise returns null
	 */
	public Worker login(String login, String password) {
		for (Worker worker : workers) {
			if (worker.getWorkerId().equalsIgnoreCase(login) && worker.getPassword().equals(password)) {
				return worker;
			}
		}
		return null;
	}

	/**
	 * Validates Patron information by given id.
	 * @param patronId given Patron Id
	 * @return returns Patron object if given Id is valid, otherwise null
	 */
	public Patron validatePatron(String patronId) {
		for (Patron p : patrons) {
			if (p.getPatronId().equals(patronId)) {
				return p;
			}
		}
		return null;
	}

	/**
	 * Check patron's overdue copies.
	 * @param patron Patron object
	 * @return returns true if no overdue copies, otherwise false
	 */
	public boolean canPatronCheckoutCopies(Patron patron) {
		List<PatronCopies> patronCopies = getPatronCopies(patron.getPatronId());
		Date now = new Date();
		for (PatronCopies pc : patronCopies) {
			if (pc.getDueDate().before(now)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @param patron
	 * @param copies
	 * @return boolean if this textbook as able to be checked in
	 */
	public boolean canPatronCheckInCopies(Patron patron, List<Copy> copies)
	{
		List<PatronCopies> l = getPatronCopies(patron.getPatronId());
		if (l.isEmpty())
		{
			System.out.println("Records show this patron does not have any copies checked out");
			return false;
		}
		
		return true;
	}

	
	/**
	 * Returns patrons all copies.
	 * @param patronId Patron Id
	 * @return return List of PatronCopies
	 */
	public List<PatronCopies> getPatronCopies(String patronId) {
		List<PatronCopies> pcopies = new ArrayList<PatronCopies>();
		for (PatronCopies pc : patronCopies) {
			if (pc.getPatronId().equals(patronId)) {
				pcopies.add(pc);
			}
		}
		return pcopies;
	}

	/**
	 * Validates copy information by given copy Id
	 * @param copyId given copy Id
	 * @return returns Copy object if Id is valid, otherwise null
	 */
	public Copy validateCopy(String copyId) {
		for (Copy copy : copies) {
			if (copy.getId().equals(copyId)) {
				return copy;
			}
		}
		return null;
	}

	/**
	 * Validates textbook information by given Id
	 * @param textbookId given textbook Id
	 * @return returns Textbook object if Id is valid, otherwise null
	 */
	public Textbook getTextbook(String textbookId) {
		for (Textbook t : textbooks) {
			if (t.getId().equals(textbookId)) {
				return t;
			}
			
			else if(t.getIsbn().equals(textbookId))
			{
				return t;
			}
		}
		return null;
	}

	/**
	 * Checks out given copies for given patron.
	 * @param patron checking out Patron object
	 * @param checkOutCopies List of textbook copy objects
	 */
	public void checkoutCopies(Patron patron, List<Copy> checkOutCopies) {
		Date checkOutDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 3);
		int i = 0;
		String prefix = patron.getPatronId() + "_" + cal.getTimeInMillis() + "_";
		for (Copy copy : checkOutCopies) {
			copy.setRented(true);
			patronCopies.add(new PatronCopies(prefix + i, patron.getPatronId(), copy.getId(), cal.getTime(), checkOutDate, null));
		}
	}
	
	/**
	 * Checks in given copies for given patron.
	 * @param patron checking in Patron object
	 * @param checkInCopies List of textbook copy objects
	 */
	public void checkInCopies(Patron patron, List<Copy> checkInCopies)
	{
		Date checkInDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 3);
		for(int i = 0; i< patronCopies.size(); i ++)
		{
			patronCopies.get(i).setCheckInDate(checkInDate);
		}
		for (Copy copy : checkInCopies) 
		{
			copy.setRented(false);
			
		}
	}

	public Textbook addTextbook(String isbn, String title, String author) throws Exception {
		for(Textbook b: textbooks) {
			if (b.getIsbn().equals(isbn)) {
				throw new Exception("This textbook already exist.");
			}
		}
		Textbook t = new Textbook("" + (textbooks.size() + 1), isbn, title, author);
		textbooks.add(t);
		return t;
	}

	public String[] addCopies(String textbookId, int n) {
		String[] ids = new String[n];
		int id = copies.size() + 1;
		for(int i = 0; i < n; i++) {
			ids[i] = "" + id;
			Copy copy = new Copy(""+id, "NEW", 0.0f, false, textbookId);
			copies.add(copy);
			id++;
		}
		return ids;
	}
	
	public void resolveOverdueHold(Patron patron)
	{
		patron.setOverdueHold(false);
	}
	
	//Making Tests First
	public ArrayList<Copy> findAllCopies(String textbookId)
	{
		ArrayList<Copy> copiesOfText = new ArrayList<Copy>();
		
		for(int i = 0; i < copies.size(); i++)
		{
			if (copies.get(i).getTextbookId().equals(textbookId)) 
					{
					copiesOfText.add(copies.get(i));
					}
		}
		
		return copiesOfText;
	}
	
	//Making Tests First
	public void removeTextbook(String textId) 
	{
		ArrayList <Copy> remove = this.findAllCopies(textId);
		copies.removeAll(remove);
		textbooks.remove(this.getTextbook(textId));
	}
	
	public void removeCopy(String copyId) //TDD
	{
		Copy c = this.validateCopy(copyId);
		copies.remove(c);
	}
}



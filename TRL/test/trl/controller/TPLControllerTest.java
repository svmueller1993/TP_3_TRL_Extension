package trl.controller;


import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import trl.domain.Copy;
import trl.domain.Patron;
import trl.domain.PatronCopies;
import trl.domain.Textbook;
import trl.domain.Worker;

class TPLControllerTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testTPLController() {
		TPLController c = new TPLController();
		assertNotNull(c);
	}

	@Test
	void testLoadSampleData() {
		TPLController c = new TPLController();
		c.loadSampleData();
		assertNotNull(c);
	}

	@Test
	void testLogin() {
		TPLController c = new TPLController();
		c.loadSampleData();
		assertTrue(c.login("worker", "worker") == c.workers.get(0));
		assertTrue(c.login("test","test") == null);
		
	}

	@Test
	void testValidatePatron() {
		TPLController c = new TPLController();
		c.loadSampleData();
		assertTrue(c.validatePatron("1") == c.patrons.get(1));
		assertTrue(c.validatePatron("test") == null);
	}

	@Test
	void testCanPatronCheckoutCopies() {
		TPLController c = new TPLController();
		c.loadSampleData();
		assertEquals(false, c.canPatronCheckoutCopies(c.patrons.get(2)));
		assertEquals(true, c.canPatronCheckoutCopies(c.patrons.get(1)));
	}

	@Test
	void testCanPatronCheckInCopies() {
		TPLController c = new TPLController();
		c.loadSampleData();
		Patron p = new Patron("20", "Test", "Testing", true);
		assertEquals(true, c.canPatronCheckInCopies(c.patrons.get(1), c.copies)); 
		assertEquals(false, c.canPatronCheckInCopies(p, c.copies));
	}

	@Test
	void testGetPatronCopies() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		TPLController c = new TPLController();
		c.loadSampleData();
		ArrayList<PatronCopies> pcopies = new ArrayList<PatronCopies>();
		pcopies.add(new PatronCopies("1", "1", "1", sdf.parse("09/10/2018"), sdf.parse("01/10/2018"), null));
		assertEquals(pcopies.get(0).toString(), c.patronCopies.get(0).toString());
	}

	@Test
	void testValidateCopy() {
		TPLController c = new TPLController();
		c.loadSampleData();
		assertNotNull(c.validateCopy("1"));
		assertTrue(c.validateCopy("80") == null);
	}

	@Test
	void testGetTextbook() {
		TPLController c = new TPLController();
		c.loadSampleData();
		assertNotNull(c.getTextbook("3"));
		assertTrue(c.getTextbook("Test") == null);
	}

	@Test
	void testCheckoutCopies() {
		TPLController c = new TPLController();
		c.loadSampleData();
		List<Copy> checkOutCopies = new ArrayList();
		checkOutCopies.add(new Copy("test", "NEW", 2.0f, false, "1"));
		Patron patron = c.validatePatron("4");
		c.checkoutCopies(patron , checkOutCopies);
		List<PatronCopies> l = c.getPatronCopies("4");
		assertEquals(1, l.size());
		PatronCopies pc = l.get(0);
		assertEquals("test", pc.getCopyId());
	}

	@Test
	void testCheckInCopies() {
		TPLController c = new TPLController();
		c.loadSampleData();
		List<Copy> checkOutCopies = new ArrayList();
		Copy copy = new Copy("test", "NEW", 2.0f, false, "1");
		checkOutCopies.add(copy);
		Patron patron = c.validatePatron("4");
		c.checkoutCopies(patron , checkOutCopies);
		List<PatronCopies> l = c.getPatronCopies("4");
		assertEquals(1, l.size());
		PatronCopies pc = l.get(0);
		assertEquals("test", pc.getCopyId());
		
		List<Copy> checkInCopies = new ArrayList();
		checkInCopies.add(copy);
		c.checkInCopies(patron, checkInCopies);
		l = c.getPatronCopies("4");
		assertEquals(1, l.size());
		assertEquals(false, copy.isRented());
		
	}

	@Test
	void testAddTextbook() throws Exception {
		TPLController c = new TPLController();
		c.loadSampleData();
		Textbook t = c.addTextbook("12345", "Test", "Testing");
		assertEquals(t, c.getTextbook("12345"));
		try {
		c.addTextbook("12345", "Test", "Testing");
		} catch(Exception e)
		{
			assert(e).getMessage() == ("This textbook already exist.");
		}
		
	}

	@Test
	void testAddCopies() throws Exception {
		TPLController c = new TPLController();
		c.loadSampleData();
		Textbook t = c.addTextbook("12345", "Test", "Testing");
		c.addCopies(t.getId(), 1);
		assertEquals("51", c.copies.get(c.copies.size()-1).getId());
		
	}

	@Test //Making Tests before making the code
	void testfindAllCopies() throws Exception
	{
		TPLController c = new TPLController();
		c.loadSampleData();
		Textbook t = c.addTextbook("12345", "Test", "Testing");
		c.addCopies(t.getId(), 2);
		ArrayList<Copy> copiesOfText = c.findAllCopies(t.getId());
		assertEquals(2, copiesOfText.size());
		assertEquals(true, c.copies.containsAll(copiesOfText));
		
	}
	
	
	
	@Test//Making Tests before making the code
	void testRemoveTextbook() throws Exception {
		TPLController c = new TPLController();
		c.loadSampleData();
		Textbook t = c.addTextbook("12345", "Test", "Testing");
		c.addCopies(t.getId(), 2);
		ArrayList<Copy> copiesOfText = c.findAllCopies(t.getId());
		assertEquals(true, c.textbooks.contains(t));
		assertEquals(true, c.copies.containsAll(copiesOfText));
		c.removeTextbook(t.getId());
		assertEquals(false, c.textbooks.contains(t));
		assertEquals("[]", c.findAllCopies(t.getId()).toString());
	}
	
	
	@Test
	void testremoveCopy() throws Exception {
		TPLController c = new TPLController();
		c.loadSampleData();
		Textbook t = c.addTextbook("12345", "Test", "Testing");
		c.addCopies(t.getId(), 1);
		ArrayList<Copy> copiesOfText = c.findAllCopies(t.getId());
		Copy copy = copiesOfText.get(0);
		assertEquals(true, c.copies.containsAll(copiesOfText));
		c.removeCopy(copy.getId());
		assertEquals(false, c.copies.contains(copy));
	}
}



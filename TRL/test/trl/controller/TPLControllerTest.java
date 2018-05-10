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
		
	}

	@Test
	void testValidatePatron() {
		TPLController c = new TPLController();
		c.loadSampleData();
		assertTrue(c.validatePatron("1") == c.patrons.get(1));
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
		
		assertEquals(false, c.canPatronCheckInCopies(c.patrons.get(1), c.copies)); 
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
	}

	@Test
	void testGetTextbook() {
		TPLController c = new TPLController();
		c.loadSampleData();
		assertNotNull(c.getTextbook("3"));
	}

	@Test//Part of UI
	void testCheckoutCopies() {
		
	}

	@Test//part of UI
	void testCheckInCopies() {
		
	}

	@Test
	void testAddTextbook() throws Exception {
		TPLController c = new TPLController();
		c.loadSampleData();
		Textbook t = c.addTextbook("12345", "Test", "Testing");
		assertEquals(t, c.getTextbook("12345"));
		
	}

	@Test
	void testAddCopies() throws Exception {
		TPLController c = new TPLController();
		c.loadSampleData();
		Textbook t = c.addTextbook("12345", "Test", "Testing");
		c.addCopies(t.getId(), 1);
		assertEquals("51", c.copies.get(c.copies.size()-1).getId());
		
	}

	@Test
	void testResolveOverdueHold() {
		Patron p = new Patron("1", "Test", "Testing", true);
		p.setOverdueHold(true);
		assertEquals(true, p.isOverdueHold());
		TPLController c = new TPLController();
		c.resolveOverdueHold(p);
		assertEquals(false, p.isOverdueHold());
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
		assertEquals(null, c.findAllCopies("12345"));

	}
	
}



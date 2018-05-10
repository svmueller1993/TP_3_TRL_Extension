package trl.domain;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PatronCopiesTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testPatronCopies() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		PatronCopies p = new PatronCopies("1", "2", "123", sdf.parse("05/07/2019"), sdf.parse("05/07/2018"), null);
		assertNotNull(p);
	}

	@Test
	void testGetId() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		PatronCopies p = new PatronCopies("1", "2", "123", sdf.parse("05/07/2019"), sdf.parse("05/07/2018"), null);
		assertTrue(p.getId() == "1");
	}

	@Test
	void testSetId() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		PatronCopies p = new PatronCopies("1", "2", "123", sdf.parse("05/07/2019"), sdf.parse("05/07/2018"), null);
		p.setId("20");
		assertTrue(p.getId() == "20");
	}

	@Test
	void testGetPatronId() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		PatronCopies p = new PatronCopies("1", "2", "123", sdf.parse("05/07/2019"), sdf.parse("05/07/2018"), null);
		assertTrue(p.getPatronId() == "2");
	}

	@Test
	void testSetPatronId()throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		PatronCopies p = new PatronCopies("1", "2", "123", sdf.parse("05/07/2019"), sdf.parse("05/07/2018"), null);
		p.setPatronId("1234");
		assertTrue(p.getPatronId() == "1234");
	}

	@Test
	void testGetCopyId() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		PatronCopies p = new PatronCopies("1", "2", "123", sdf.parse("05/07/2019"), sdf.parse("05/07/2018"), null);
		assertTrue(p.getCopyId() == "123");
	}

	@Test
	void testSetCopyId() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		PatronCopies p = new PatronCopies("1", "2", "123", sdf.parse("05/07/2019"), sdf.parse("05/07/2018"), null);
		p.setCopyId("1234");
		assertTrue(p.getCopyId() == "1234");
	}

	@Test
	void testGetDueDate() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		PatronCopies p = new PatronCopies("1", "2", "123", sdf.parse("05/07/2019"), sdf.parse("05/07/2018"), null);
		assertEquals("Tue May 07 00:00:00 CDT 2019", p.getDueDate().toString());
		
	}

	@Test
	void testSetDueDate() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		PatronCopies p = new PatronCopies("1", "2", "123", sdf.parse("05/07/2019"), sdf.parse("05/07/2018"), null);
		p.setDueDate(sdf.parse("08/01/2018"));
		assertEquals("Wed Aug 01 00:00:00 CDT 2018", p.getDueDate().toString());
	}

	@Test
	void testGetCheckOutDate() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		PatronCopies p = new PatronCopies("1", "2", "123", sdf.parse("05/07/2019"), sdf.parse("05/07/2018"), null);
		assertEquals("Mon May 07 00:00:00 CDT 2018", p.getCheckOutDate().toString());
	}

	@Test
	void testSetCheckOutDate() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		PatronCopies p = new PatronCopies("1", "2", "123", sdf.parse("05/07/2019"), sdf.parse("05/07/2018"), null);
		p.setCheckOutDate(sdf.parse("05/08/2018"));
		assertEquals("Tue May 08 00:00:00 CDT 2018", p.getCheckOutDate().toString());
	}

	@Test
	void testGetCheckInDate() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		PatronCopies p = new PatronCopies("1", "2", "123", sdf.parse("05/07/2019"), sdf.parse("05/07/2018"), null);
		assertTrue(p.getCheckInDate() == null);
	}

	@Test
	void testSetCheckInDate() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		PatronCopies p = new PatronCopies("1", "2", "123", sdf.parse("05/07/2019"), sdf.parse("05/07/2018"), null);
		p.setCheckInDate(sdf.parse("06/01/2018"));
		assertEquals("Fri Jun 01 00:00:00 CDT 2018", p.getCheckInDate().toString());
	}

	@Test
	void testToString() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		PatronCopies p = new PatronCopies("1", "2", "123", sdf.parse("05/07/2019"), sdf.parse("05/07/2018"), null);
		assertEquals("PatronCopies [id= " + p.id + ", patronId= " + p.patronId + ", copyId= " + p.copyId + ", dueDate= " + p.dueDate
		+ ", checkOutDate= " + p.checkOutDate + ", checkInDate= " + p.checkInDate + "]", p.toString());
	}

}

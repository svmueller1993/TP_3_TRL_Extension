package trl.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OverdueNoticeTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testOverdueNotice() {
		ArrayList<String> copies = new ArrayList<String>();
		copies.add("123");
		OverdueNotice o = new OverdueNotice("123", copies, false);
		assertNotNull(o);
	}

	@Test
	void testGetId() {
		ArrayList<String> copies = new ArrayList<String>();
		copies.add("123");
		OverdueNotice o = new OverdueNotice("123", copies, false);
		assertTrue(o.getId() == "123");
	}

	@Test
	void testSetId() {
		ArrayList<String> copies = new ArrayList<String>();
		copies.add("123");
		OverdueNotice o = new OverdueNotice("123", copies, false);
		o.setId("1234");
		assertTrue(o.getId() == "1234");
	}

	@Test
	void testGetCopyId() {
		ArrayList<String> copies = new ArrayList<String>();
		copies.add("123");
		OverdueNotice o = new OverdueNotice("123", copies, false);
		ArrayList<String> newCopies = new ArrayList<String>();
		o.setCopyId(newCopies);
		assertTrue(o.getCopyId() == newCopies);
	}

	@Test
	void testSetCopyId() {
		ArrayList<String> copies = new ArrayList<String>();
		copies.add("123");
		OverdueNotice o = new OverdueNotice("123", copies, false);
		ArrayList<String> newCopies = new ArrayList<String>();
		o.setCopyId(newCopies);
		assertTrue(o.getCopyId() == newCopies);
	}

	@Test
	void testIsResolved() {
		ArrayList<String> copies = new ArrayList<String>();
		copies.add("123");
		OverdueNotice o = new OverdueNotice("123", copies, false);
		assertTrue(o.isResolved() == false);
		
	}

	@Test
	void testSetResolved() {
		ArrayList<String> copies = new ArrayList<String>();
		copies.add("123");
		OverdueNotice o = new OverdueNotice("123", copies, false);
		o.setResolved(true);
		assertTrue(o.isResolved() == true);
	}

}

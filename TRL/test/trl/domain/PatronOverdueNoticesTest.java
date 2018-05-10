package trl.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PatronOverdueNoticesTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testPatronOverdueNotices() {
		PatronOverdueNotices p = new PatronOverdueNotices("1", "2", "3");
		assertNotNull(p);
	}

	@Test
	void testGetId() {
		PatronOverdueNotices p = new PatronOverdueNotices("1", "2", "3");
		assertTrue(p.getId() == "1");
	}

	@Test
	void testSetId() {
		PatronOverdueNotices p = new PatronOverdueNotices("1", "2", "3");
		p.setId("10");
		assertTrue(p.getId() == "10");
	}

	@Test
	void testGetPatronId() {
		PatronOverdueNotices p = new PatronOverdueNotices("1", "2", "3");
		assertTrue(p.getPatronId() == "2");
	}

	@Test
	void testSetPatronId() {
		PatronOverdueNotices p = new PatronOverdueNotices("1", "2", "3");
		p.setPatronId("20");
		assertTrue(p.getPatronId() == "20");
	}

	@Test
	void testGetOverdueNoticeId() {
		PatronOverdueNotices p = new PatronOverdueNotices("1", "2", "3");
		assertTrue(p.getOverdueNoticeId() == "3");
	}

	@Test
	void testSetOverdueNoticeId() {
		PatronOverdueNotices p = new PatronOverdueNotices("1", "2", "3");
		p.setOverdueNoticeId("30");
		assertTrue(p.getOverdueNoticeId() == "30");
	}

}

package trl.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TitleManagerTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testTitleManager() {
		TitleManager t = new TitleManager("1", "Test", "Testing", "Password");
		assertNotNull(t);
	}

}

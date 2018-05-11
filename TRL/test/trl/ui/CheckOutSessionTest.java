package trl.ui;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckOutSessionTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testCheckOutSession() {
		assertNotNull(new CheckOutSession(null, null));
	}

}

package trl.ui;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import trl.controller.TPLController;
import trl.domain.Patron;

class CheckInSessionTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testCheckInSession() {
		Patron patron = null;
		TPLController controller = new TPLController();
		assertNotNull(new CheckInSession(patron, controller));
	}

}

package trl.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagerTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testManager() {
		Manager t = new Manager("123", "Test", "Testing", "Password");
		assertNotNull(t);
				
	}

}

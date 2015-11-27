package fr.nantes.cta.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.nantes.cta.Airport;
import fr.nantes.cta.one.AirportImpl;

public class AirportImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAirportImpl() {
		Airport a = new AirportImpl("test");
		assertNotNull(a);
		
	}

	@Test
	public void testGetName() {
		Airport a = new AirportImpl("test");
		assertEquals("test", a.getName());
	}

}

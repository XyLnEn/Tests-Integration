package fr.nantes.cta.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.nantes.cta.Airplane;
import fr.nantes.cta.one.AirplaneImpl;

public class AirplaneImplTest {

	private double _poids;
	private int _capacite, _consomation, _capareservoir;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAirplaneImpl() {
		Airplane a = new AirplaneImpl(1000, 200, 10, 600);
		assertNotNull(a);
		Airplane b = new AirplaneImpl(-1000, -200, -500, -1);
		//passe aussi!
	}

	@Test
	public void testGetAutonomy() {
		Airplane a = new AirplaneImpl(1000, 200, 10, 600);
		assertEquals(6000, a.getAutonomy(), 0); 
	}

	@Test
	public void testGetLoading() {
		Airplane a = new AirplaneImpl(1000, 200, 10, 600);
		assertEquals(200, a.getLoading(), 0); 
	}

	@Test
	public void testWeight() {
		Airplane a = new AirplaneImpl(1000, 200, 10, 600);
		assertEquals(1000, a.weight(), 0); 
	}

}

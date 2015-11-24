package fr.nantes.cta.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.nantes.cta.Airway;
import fr.nantes.cta.CompassDirection;
import fr.nantes.cta.one.AirwayImpl;
import fr.nantes.cta.one.LatitudeImpl;
import fr.nantes.cta.one.LongitudeImpl;
import fr.nantes.cta.one.PositionImpl;
import fr.nantes.cta.one.TakenAirwayImpl;
import fr.nantes.cta.one.VORImpl;

public class TakenAirwayImplTest {
	
	private TakenAirwayImpl instance;
    private Airway air1, air2;
    private int alt1, alt2;
    private CompassDirection cd1, cd2;

	@Before
	public void setUp() throws Exception {
		VORImpl v = new VORImpl("test1", new PositionImpl(new LatitudeImpl(45, 10, 10, CompassDirection.NORTH), new LongitudeImpl(45, 10, 10, CompassDirection.EAST)));
		VORImpl o = new VORImpl("test2", new PositionImpl(new LatitudeImpl(40, 10, 10, CompassDirection.NORTH), new LongitudeImpl(40, 10, 10, CompassDirection.EAST)));
		VORImpl r = new VORImpl(null, new PositionImpl(new LatitudeImpl(40, 10, 10, CompassDirection.NORTH), new LongitudeImpl(40, 10, 10, CompassDirection.EAST)));
		
		air1 = new AirwayImpl(v,o);
		//air2 = new Air
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTakenAirwayImpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testDistance() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAirway() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAltitude() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSense() {
		fail("Not yet implemented");
	}

}

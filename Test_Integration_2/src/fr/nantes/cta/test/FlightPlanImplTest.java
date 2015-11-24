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

public class FlightPlanImplTest {

	private TakenAirwayImpl instance;
    private Airway air1,air2,air3,air4,air5,air6;
    private int alt1;
    private CompassDirection cd1;
	
	@Before
	public void setUp() throws Exception {
		VORImpl v = new VORImpl("test1", new PositionImpl(new LatitudeImpl(45, 10, 10, CompassDirection.NORTH), new LongitudeImpl(45, 10, 10, CompassDirection.EAST)));
		VORImpl o = new VORImpl("test2", new PositionImpl(new LatitudeImpl(40, 10, 10, CompassDirection.NORTH), new LongitudeImpl(40, 10, 10, CompassDirection.EAST)));
		VORImpl r = new VORImpl("test3", new PositionImpl(new LatitudeImpl(55, 10, 10, CompassDirection.NORTH), new LongitudeImpl(35, 10, 10, CompassDirection.EAST)));
		VORImpl i = new VORImpl("test4", new PositionImpl(new LatitudeImpl(30, 5, 6, CompassDirection.NORTH), new LongitudeImpl(30, 6, 5, CompassDirection.EAST)));
		
		air1 = new AirwayImpl(v,o);
		air2 = new AirwayImpl(o,r);
		air3 = new AirwayImpl(r,v);
		air4 = new AirwayImpl(r,i);
		air5 = new AirwayImpl(v,o);
		air6 = new AirwayImpl(v,v);
		cd1 = CompassDirection.NORTH;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFlightPlanImpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddAirway() {
		fail("Not yet implemented");
	}

	@Test
	public void testDistance() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPath() {
		fail("Not yet implemented");
	}

}

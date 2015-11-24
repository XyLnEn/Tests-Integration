package fr.nantes.cta.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.nantes.cta.CompassDirection;
import fr.nantes.cta.one.LatitudeImpl;
import fr.nantes.cta.one.LongitudeImpl;
import fr.nantes.cta.one.PositionImpl;
import fr.nantes.cta.one.VORImpl;
import fr.nantes.cta.one.AirwayImpl;

public class AirwayImplTest {

	private AirwayImpl a;
	private VORImpl v,o,r;
	
	
	@Before
	public void setUp() throws Exception {
		v = new VORImpl("test1", new PositionImpl(new LatitudeImpl(45, 10, 10, CompassDirection.NORTH), new LongitudeImpl(45, 10, 10, CompassDirection.EAST)));
		o = new VORImpl("test2", new PositionImpl(new LatitudeImpl(40, 10, 10, CompassDirection.NORTH), new LongitudeImpl(40, 10, 10, CompassDirection.EAST)));
//		r = new VORImpl(null, new PositionImpl(new LatitudeImpl(40, 10, 10, CompassDirection.NORTH), new LongitudeImpl(40, 10, 10, CompassDirection.EAST)));
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAirwayImpl() {
		a = new AirwayImpl(v, o);
		assertNotNull(a);
	}

	@Test
	public void testGetDistance() {
		a = new AirwayImpl(v, o);
		assert a.getDistance()>0;
		a = new AirwayImpl(v, v);
		assert a.getDistance() ==0;
		
	}

	@Test
	public void testDeparture() {
		a = new AirwayImpl(v, o);
		assertSame(v, a.departure());
	}

	@Test
	public void testArrival() {
		a = new AirwayImpl(v, o);
		assertSame(o, a.arrival());
	}

	@Test
	public void testGetVORDepart() {
		a = new AirwayImpl(v, o);
		assertEquals(v.getName(), a.GetVORDepart());
	}

	@Test
	public void testGetVORArrive() {
		a = new AirwayImpl(v, o);
		assertEquals(o.getName(), a.GetVORArrive());
	}

}

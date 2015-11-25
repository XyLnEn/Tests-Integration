package fr.nantes.cta.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.nantes.cta.Airway;
import fr.nantes.cta.CompassDirection;
import fr.nantes.cta.TakenAirway;
import fr.nantes.cta.one.AirwayImpl;
import fr.nantes.cta.one.FlightPlanImpl;
import fr.nantes.cta.one.LatitudeImpl;
import fr.nantes.cta.one.LongitudeImpl;
import fr.nantes.cta.one.PositionImpl;
import fr.nantes.cta.one.TakenAirwayImpl;
import fr.nantes.cta.one.VORImpl;

public class FlightPlanImplTest {

	private TakenAirwayImpl tair1,tair2,tair3,tair4,tair5,tair6;
    private Airway air1,air2,air3,air4,air5,air6;
    private CompassDirection cd1,cd2;
	
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
		air5 = new AirwayImpl(o,v);
		air6 = new AirwayImpl(v,v);
		cd1 = CompassDirection.NORTH;
		cd2 = CompassDirection.SOUTH;
		
		tair1 = new TakenAirwayImpl(air1, 1000, cd1);
		tair2 = new TakenAirwayImpl(air2, 1500, cd1);
		tair3 = new TakenAirwayImpl(air3, 1200, cd1);
		tair4 = new TakenAirwayImpl(air4, 3000, cd1);
		tair5 = new TakenAirwayImpl(air5, 1000, cd2);
		tair6 = new TakenAirwayImpl(air6, 0, cd1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFlightPlanImpl() {
		FlightPlanImpl f = new FlightPlanImpl();
		assertNotNull(f);
	}

	@Test
	public void testAddAirway() {
		FlightPlanImpl f = new FlightPlanImpl();
		f.addAirway(tair1);
		assertSame(tair1, f.getPath().get(0));
	}

	@Test
	public void testDistance() {
		FlightPlanImpl f = new FlightPlanImpl();
		f.addAirway(tair1);
		double dist1 = f.distance();
		assert dist1 >0;
		f.addAirway(tair5);
		assertEquals(dist1*2, f.distance(), 0);
		
		
	}

	@Test
	public void testGetPath() {
		FlightPlanImpl f = new FlightPlanImpl();
		f.addAirway(tair1);
		f.addAirway(tair2);
		f.addAirway(tair3);
		List<TakenAirway> list = new Vector<TakenAirway>();
		list.add(tair1);
		list.add(tair2);
		list.add(tair3);
		assertEquals(list, f.getPath());
	}

}

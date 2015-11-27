package fr.nantes.cta.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.nantes.cta.Airplane;
import fr.nantes.cta.Airport;
import fr.nantes.cta.Airway;
import fr.nantes.cta.CompassDirection;
import fr.nantes.cta.FlightPlan;
import fr.nantes.cta.TakenAirway;
import fr.nantes.cta.one.AirplaneImpl;
import fr.nantes.cta.one.AirportImpl;
import fr.nantes.cta.one.AirwayImpl;
import fr.nantes.cta.one.FlightPlanImpl;
import fr.nantes.cta.one.LatitudeImpl;
import fr.nantes.cta.one.LongitudeImpl;
import fr.nantes.cta.one.PositionImpl;
import fr.nantes.cta.one.TakenAirwayImpl;
import fr.nantes.cta.one.VORImpl;

public class CreateCivilFlightTest {

	
	private Airport _depart, _arrive;
	private Airplane _avion;
	private FlightPlan _flightplane;

	@Before
	public void setUp() throws Exception {
		VORImpl v = new VORImpl("test1", new PositionImpl(new LatitudeImpl(45, 10, 10, CompassDirection.NORTH), new LongitudeImpl(45, 10, 10, CompassDirection.EAST)));
		VORImpl o = new VORImpl("test2", new PositionImpl(new LatitudeImpl(40, 10, 10, CompassDirection.NORTH), new LongitudeImpl(40, 10, 10, CompassDirection.EAST)));
		Airway air1 = new AirwayImpl(v,o);
		CompassDirection cd1 = CompassDirection.NORTH;
		TakenAirway tair1 = new TakenAirwayImpl(air1, 1000, cd1);
		FlightPlanImpl f = new FlightPlanImpl();
		f.addAirway(tair1);
		
		Airplane _avion = new AirplaneImpl(1000, 200, 10, 600);
		
		Airport _depart = new AirportImpl("dep");
		Airport _arrive = new AirportImpl("arr");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFlightImpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAirplane() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetArrival() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDeparture() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFlightPlan() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCreateCivilFlight() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoadingWeight() {
		fail("Not yet implemented");
	}

	@Test
	public void testTotalWeight() {
		fail("Not yet implemented");
	}


}

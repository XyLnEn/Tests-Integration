package fr.nantes.cta.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.nantes.cta.Airplane;
import fr.nantes.cta.AirplaneOverload;
import fr.nantes.cta.Airport;
import fr.nantes.cta.Airway;
import fr.nantes.cta.CompassDirection;
import fr.nantes.cta.Flight;
import fr.nantes.cta.FlightPlan;
import fr.nantes.cta.IncompatibleAirway;
import fr.nantes.cta.TakenAirway;
import fr.nantes.cta.one.AirplaneImpl;
import fr.nantes.cta.one.AirportImpl;
import fr.nantes.cta.one.AirwayImpl;
import fr.nantes.cta.one.CreateCivilFlight;
import fr.nantes.cta.one.FlightPlanImpl;
import fr.nantes.cta.one.LatitudeImpl;
import fr.nantes.cta.one.LongitudeImpl;
import fr.nantes.cta.one.PositionImpl;
import fr.nantes.cta.one.TakenAirwayImpl;
import fr.nantes.cta.one.VORImpl;

public class CreateCivilFlightTest {

	
	private Airport _depart, _arrive;
	private Airplane _avion1,_avion2, _avion3;
	private FlightPlan _flightplan;
	int _nbpassenger;

	@Before
	public void setUp() throws Exception {
		VORImpl v = new VORImpl("test1", new PositionImpl(new LatitudeImpl(45, 10, 10, CompassDirection.NORTH), new LongitudeImpl(45, 10, 10, CompassDirection.EAST)));
		VORImpl o = new VORImpl("test2", new PositionImpl(new LatitudeImpl(40, 10, 10, CompassDirection.NORTH), new LongitudeImpl(40, 10, 10, CompassDirection.EAST)));
		Airway air1 = new AirwayImpl(v,o);
		CompassDirection cd1 = CompassDirection.NORTH;
		TakenAirway tair1 = new TakenAirwayImpl(air1, 1000, cd1);
		
		this._avion1 = new AirplaneImpl(3000000, 90000, 1000, 600000);
		this._avion2 = new AirplaneImpl(0, 200, 1000, 600000);
		this._avion3 = new AirplaneImpl(3000000, 90000, 1000, 0);
		
		
		this._depart = new AirportImpl("dep");
		this._arrive = new AirportImpl("arr");
		
		this._flightplan = new FlightPlanImpl();
		this._flightplan.addAirway(tair1);
		_nbpassenger = 300;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateCivilFlight() throws IncompatibleAirway, AirplaneOverload {
		Flight f = new CreateCivilFlight(_depart, _arrive, _avion1, _flightplan, _nbpassenger);
		assertNotNull(f);
	}
	
	
	@Test (expected = AirplaneOverload.class)
	public void testdetectAirplaneOverload() throws IncompatibleAirway, AirplaneOverload {
		Flight f = new CreateCivilFlight(_depart, _arrive, _avion2, _flightplan, _nbpassenger);
	}
	
	@Test (expected = IncompatibleAirway.class)
	public void testdetectIncompatibleAirway() throws IncompatibleAirway, AirplaneOverload {
		Flight f = new CreateCivilFlight(_depart, _arrive, _avion3, _flightplan, _nbpassenger);
	}

	
//	@Test
//	public void testFlightImpl() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testGetAirplane() throws IncompatibleAirway, AirplaneOverload {
		Flight f = new CreateCivilFlight(_depart, _arrive, _avion1, _flightplan, _nbpassenger);
		assertSame(_avion1, f.getAirplane());
	}

	@Test
	public void testGetArrival() throws IncompatibleAirway, AirplaneOverload {
		Flight f = new CreateCivilFlight(_depart, _arrive, _avion1, _flightplan, _nbpassenger);
		assertSame(_arrive, f.getArrival());
	}

	@Test
	public void testGetDeparture() throws IncompatibleAirway, AirplaneOverload {
		Flight f = new CreateCivilFlight(_depart, _arrive, _avion1, _flightplan, _nbpassenger);
		assertSame(_depart, f.getDeparture());
	}

	@Test
	public void testGetFlightPlan() throws IncompatibleAirway, AirplaneOverload {
		Flight f = new CreateCivilFlight(_depart, _arrive, _avion1, _flightplan, _nbpassenger);
		assertSame(_flightplan, f.getFlightPlan());
	}
	

	@Test
	public void testLoadingWeight() throws IncompatibleAirway, AirplaneOverload {
		Flight f = new CreateCivilFlight(_depart, _arrive, _avion1, _flightplan, _nbpassenger);
		assertEquals((_nbpassenger*(70+60)), f.loadingWeight(), 0);
	}

	@Test
	public void testTotalWeight() throws IncompatibleAirway, AirplaneOverload {
		Flight f = new CreateCivilFlight(_depart, _arrive, _avion1, _flightplan, _nbpassenger);
		assertEquals((_nbpassenger*(70+60))+_avion1.weight(), f.totalWeight(), 0);
	}


}

package fr.nantes.cta.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.nantes.cta.Airplane;
import fr.nantes.cta.AirplaneOverload;
import fr.nantes.cta.Airport;
import fr.nantes.cta.Airway;
import fr.nantes.cta.CTAFactory;
import fr.nantes.cta.CompassDirection;
import fr.nantes.cta.Coordinate;
import fr.nantes.cta.Flight;
import fr.nantes.cta.FlightPlan;
import fr.nantes.cta.IncompatibleAirway;
import fr.nantes.cta.Position;
import fr.nantes.cta.TakenAirway;
import fr.nantes.cta.VOR;
import fr.nantes.cta.one.AirplaneImpl;
import fr.nantes.cta.one.AirportImpl;
import fr.nantes.cta.one.AirwayImpl;
import fr.nantes.cta.one.CTAFactoryImpl;
import fr.nantes.cta.one.CreateCivilFlight;
import fr.nantes.cta.one.CreateMilitarFlight;
import fr.nantes.cta.one.FlightPlanImpl;
import fr.nantes.cta.one.LatitudeImpl;
import fr.nantes.cta.one.LongitudeImpl;
import fr.nantes.cta.one.PositionImpl;
import fr.nantes.cta.one.TakenAirwayImpl;
import fr.nantes.cta.one.VORImpl;

public class CTAFactoryImplTest {

	private CTAFactory CTAFact;
	
	@Before
	public void setUp() throws Exception {
		CTAFact = new CTAFactoryImpl();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testSetAirplanes() {
		//pas d'acces a l'atribut de CTAFactory, impossible de la tester!
		fail("impossible a tester en l'etat");
	}
	
	@Test
	public void testCreateLatitude() {
		Coordinate lattemp = new LatitudeImpl(10, 0, 0, CompassDirection.NORTH);
		Coordinate lat = CTAFact.createLatitude(10, 0, 0, CompassDirection.NORTH);
		assert lattemp == lat;
		Coordinate lattemp2 = new LatitudeImpl(11, 0, 0, CompassDirection.NORTH);
		assert lattemp2 != lat;
	}

	@Test
	public void testCreateLongitude() {
		Coordinate lontemp = new LongitudeImpl(10, 0, 0, CompassDirection.EAST);
		Coordinate lon = CTAFact.createLongitude(10, 0, 0, CompassDirection.EAST);
		assert lontemp == lon;
		Coordinate lontemp2 = new LongitudeImpl(11, 0, 0, CompassDirection.WEST);
		assert lontemp2 != lon;
	}
	
	@Test
	public void testCreatePosition() {
		LongitudeImpl lontemp = new LongitudeImpl(10, 0, 0, CompassDirection.EAST);
		LatitudeImpl lattemp = new LatitudeImpl(10, 0, 0, CompassDirection.NORTH);
		Position ptemp = new PositionImpl(lattemp, lontemp);
		assert CTAFact.createPosition(CTAFact.createLatitude(10, 0, 0, CompassDirection.NORTH), CTAFact.createLongitude(10, 0, 0, CompassDirection.EAST)) == ptemp;
		assert CTAFact.createPosition(CTAFact.createLatitude(11, 0, 0, CompassDirection.NORTH), CTAFact.createLongitude(10, 0, 0, CompassDirection.EAST)) != ptemp;
	}
	
	@Test
	public void testCreateVOR() {
		LongitudeImpl lontemp = new LongitudeImpl(10, 0, 0, CompassDirection.EAST);
		LatitudeImpl lattemp = new LatitudeImpl(10, 0, 0, CompassDirection.NORTH);
		Position ptemp = new PositionImpl(lattemp, lontemp);
		VOR v = new VORImpl("vor", ptemp);
		
		assert CTAFact.createVOR("vor", CTAFact.createPosition(CTAFact.createLatitude(10, 0, 0, CompassDirection.NORTH), CTAFact.createLongitude(10, 0, 0, CompassDirection.EAST))) == v;
		assert CTAFact.createVOR("var", CTAFact.createPosition(CTAFact.createLatitude(10, 0, 0, CompassDirection.NORTH), CTAFact.createLongitude(10, 0, 0, CompassDirection.EAST))) != v;	
	}

	@Test
	public void testCreateAirway() {
		LongitudeImpl lontemp1 = new LongitudeImpl(10, 0, 0, CompassDirection.EAST);
		LatitudeImpl lattemp1 = new LatitudeImpl(10, 0, 0, CompassDirection.NORTH);
		Position ptemp1 = new PositionImpl(lattemp1, lontemp1);
		VOR V = new VORImpl("vor1", ptemp1);
		
		LongitudeImpl lontemp2 = new LongitudeImpl(10, 0, 0, CompassDirection.EAST);
		LatitudeImpl lattemp2 = new LatitudeImpl(10, 0, 0, CompassDirection.NORTH);
		Position ptemp2 = new PositionImpl(lattemp2, lontemp2);
		VOR O = new VORImpl("vor2", ptemp2);
		

		VOR factV = CTAFact.createVOR("vor1", CTAFact.createPosition(CTAFact.createLatitude(10, 0, 0, CompassDirection.NORTH), CTAFact.createLongitude(10, 0, 0, CompassDirection.EAST)));
		VOR factO = CTAFact.createVOR("vor2", CTAFact.createPosition(CTAFact.createLatitude(10, 0, 0, CompassDirection.NORTH), CTAFact.createLongitude(10, 0, 0, CompassDirection.EAST)));
		VOR factR = CTAFact.createVOR("vordiff", CTAFact.createPosition(CTAFact.createLatitude(10, 0, 0, CompassDirection.NORTH), CTAFact.createLongitude(10, 0, 0, CompassDirection.EAST)));
		
		Airway air1 = new AirwayImpl(V, O);
		assert CTAFact.createAirway(factV, factO) == air1;
		assert CTAFact.createAirway(V, factR) != air1;
	}

	@Test
	public void testCreateTakenAirway() {
		LongitudeImpl lontemp1 = new LongitudeImpl(10, 0, 0, CompassDirection.EAST);
		LatitudeImpl lattemp1 = new LatitudeImpl(10, 0, 0, CompassDirection.NORTH);
		Position ptemp1 = new PositionImpl(lattemp1, lontemp1);
		VOR V = new VORImpl("vor1", ptemp1);
		
		LongitudeImpl lontemp2 = new LongitudeImpl(10, 0, 0, CompassDirection.EAST);
		LatitudeImpl lattemp2 = new LatitudeImpl(10, 0, 0, CompassDirection.NORTH);
		Position ptemp2 = new PositionImpl(lattemp2, lontemp2);
		VOR O = new VORImpl("vor2", ptemp2);
		
		Airway air1 = new AirwayImpl(V, O);
		TakenAirway tair1 = new TakenAirwayImpl(air1, 1000, CompassDirection.NORTH);
		
		VOR factR = CTAFact.createVOR("vordiff", CTAFact.createPosition(CTAFact.createLatitude(10, 0, 0, CompassDirection.NORTH), CTAFact.createLongitude(10, 0, 0, CompassDirection.EAST)));
		VOR factV = CTAFact.createVOR("vor1", CTAFact.createPosition(CTAFact.createLatitude(10, 0, 0, CompassDirection.NORTH), CTAFact.createLongitude(10, 0, 0, CompassDirection.EAST)));
		VOR factO = CTAFact.createVOR("vor2", CTAFact.createPosition(CTAFact.createLatitude(10, 0, 0, CompassDirection.NORTH), CTAFact.createLongitude(10, 0, 0, CompassDirection.EAST)));
		Airway factAir = CTAFact.createAirway(factV, factO);
		assert CTAFact.createTakenAirway(factAir, 1000, CompassDirection.NORTH) == tair1;
		assert CTAFact.createTakenAirway(factAir, 10, CompassDirection.NORTH) != tair1;
		
	}
	
	@Test
	public void testCreateAirplane() {
		Airplane airp1 = new AirplaneImpl(3500000, 1000000, 10, 100000);
		assert CTAFact.createAirplane(3500000, 1000000, 10, 100000) == airp1;
		assert CTAFact.createAirplane(3500000, 1000000, 20, 100000) != airp1;
	}
	
	@Test
	public void testCreateAirport() {
		Airport airport = new AirportImpl("trueairport");
		assert CTAFact.createAirport("trueairport") == airport;
		assert CTAFact.createAirport("fakeairport") != airport;
	}
	
	@Test
	public void testCreateFlightPlan() {
		FlightPlan Fplan = new FlightPlanImpl();
		FlightPlan factFplan = CTAFact.createFlightPlan();
		assert Fplan == factFplan;
		
		LongitudeImpl lontemp1 = new LongitudeImpl(10, 0, 0, CompassDirection.EAST);
		LatitudeImpl lattemp1 = new LatitudeImpl(10, 0, 0, CompassDirection.NORTH);
		Position ptemp1 = new PositionImpl(lattemp1, lontemp1);
		VOR V = new VORImpl("vor1", ptemp1);
		
		LongitudeImpl lontemp2 = new LongitudeImpl(10, 0, 0, CompassDirection.EAST);
		LatitudeImpl lattemp2 = new LatitudeImpl(10, 0, 0, CompassDirection.NORTH);
		Position ptemp2 = new PositionImpl(lattemp2, lontemp2);
		VOR O = new VORImpl("vor2", ptemp2);
		
		Airway air1 = new AirwayImpl(V, O);
		TakenAirway tair1 = new TakenAirwayImpl(air1, 1000, CompassDirection.NORTH);
		Fplan.addAirway(tair1);
		assert Fplan != factFplan;
	}
	
	@Test
	public void testCreateCivilFlight() {
		
		Airport airportst = new AirportImpl("startairport");
		Airport airportend = new AirportImpl("finishairport");
		Airplane airp1 = new AirplaneImpl(3500000, 1000000, 10, 100000);
		FlightPlan Fplan = new FlightPlanImpl();
		Flight CivFlight =null, FactCivFlight1 =null , FactCivFlight2 =null;
		try {
			CivFlight = new CreateCivilFlight(airportst, airportend, airp1, Fplan, 300);
			FactCivFlight1 = CTAFact.createCivilFlight(CTAFact.createAirport("startairport"), CTAFact.createAirport("finishairport"), CTAFact.createAirplane(3500000, 1000000, 10, 100000), CTAFact.createFlightPlan(), 300);
			FactCivFlight2 = CTAFact.createCivilFlight(CTAFact.createAirport("startairport"), CTAFact.createAirport("finishairport"), CTAFact.createAirplane(3500000, 1000000, 10, 100000), CTAFact.createFlightPlan(), 100);
		} catch (IncompatibleAirway e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AirplaneOverload e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assert CivFlight !=null;
		assert FactCivFlight1 !=null;
		assert FactCivFlight2 !=null;
		assert CivFlight == FactCivFlight1;
		assert CivFlight != FactCivFlight2;
	}



	@Test
	public void testCreateMilitarFlight() {
		Airport airportst = new AirportImpl("startairport");
		Airport airportend = new AirportImpl("finishairport");
		Airplane airp1 = new AirplaneImpl(3500000, 1000000, 10, 100000);
		FlightPlan Fplan = new FlightPlanImpl();
		Flight MilFlight =null, FactMilFlight1 =null , FactMilFlight2 =null;
		try {
			MilFlight = new CreateMilitarFlight(airportst, airportend, airp1, Fplan, 300);
			FactMilFlight1 = CTAFact.createMilitarFlight(CTAFact.createAirport("startairport"), CTAFact.createAirport("finishairport"), CTAFact.createAirplane(3500000, 1000000, 10, 100000), CTAFact.createFlightPlan(), 300);
			FactMilFlight2 = CTAFact.createMilitarFlight(CTAFact.createAirport("startairport"), CTAFact.createAirport("finishairport"), CTAFact.createAirplane(3500000, 1000000, 10, 100000), CTAFact.createFlightPlan(), 100);
		} catch (IncompatibleAirway e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AirplaneOverload e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assert MilFlight !=null;
		assert FactMilFlight1 !=null;
		assert FactMilFlight2 !=null;
		assert MilFlight == FactMilFlight1;
		assert MilFlight != FactMilFlight2;
	}


}

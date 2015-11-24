package fr.nantes.cta.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import fr.nantes.cta.CompassDirection;
import fr.nantes.cta.one.CoordinateImpl;
import fr.nantes.cta.one.LatitudeImpl;
import fr.nantes.cta.one.LongitudeImpl;
import fr.nantes.cta.one.PositionImpl;

@RunWith ( Parameterized.class ) public class PositionImplTest {

	
	private LatitudeImpl arg1;
	private LongitudeImpl arg2;
	

	/**
	 * @param arg1
	 * @param arg2
	 */
	public PositionImplTest(LatitudeImpl arg1, LongitudeImpl arg2) {
		super();
		this.arg1 = arg1;
		this.arg2 = arg2;
	}
	
	@Parameters public static Collection data () {
		Object[][] data = {
				{new LatitudeImpl(45, 10, 10, CompassDirection.NORTH), new LongitudeImpl(45, 10, 10, CompassDirection.EAST)},
				{new LatitudeImpl(45, 10, 10, CompassDirection.NORTH), null},
				{null, new LongitudeImpl(45, 10, 10, CompassDirection.EAST)},
				{null, null}
				
				
		};
		return Arrays.asList(data);
	}
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPositionImpl() {
		PositionImpl p = new PositionImpl(arg1, arg2);
		assertNotNull(p);
	}

	@Test
	public void testGetLatitude() {
		PositionImpl p = new PositionImpl(arg1, arg2);
		assertSame(arg1, p.getLatitude());
	}

	@Test
	public void testGetLongitude() {
		PositionImpl p = new PositionImpl(arg1, arg2);
		assertSame(arg2, p.getLongitude());
	}

	@Test //(expected = UnsupportedOperationException.class)
	public void testDistanceTo() {
		PositionImpl p = new PositionImpl(arg1, arg2);
		LatitudeImpl lat = new LatitudeImpl(40, 10, 10, CompassDirection.NORTH);
		LongitudeImpl lon = new LongitudeImpl(45, 10, 10, CompassDirection.EAST);
		PositionImpl q = new PositionImpl(lat, lon);
		assert p.distanceTo(q) >= 0;
		PositionImpl r = new PositionImpl(arg1, arg2);
		assert r.distanceTo(p) ==0;
	}

}

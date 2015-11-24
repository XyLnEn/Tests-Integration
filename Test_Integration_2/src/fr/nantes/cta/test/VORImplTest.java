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
import fr.nantes.cta.Position;
import fr.nantes.cta.one.LatitudeImpl;
import fr.nantes.cta.one.LongitudeImpl;
import fr.nantes.cta.one.PositionImpl;
import fr.nantes.cta.one.VORImpl;

@RunWith ( Parameterized.class ) public class VORImplTest {

	private String arg1;
	private Position arg2;
	
	
	/**
	 * @param arg1
	 * @param arg2
	 */
	public VORImplTest(String arg1, Position arg2) {
		this.arg1 = arg1;
		this.arg2 = arg2;
	}

	@Parameters public static Collection data () {
		Object[][] data = {
				{"test", new PositionImpl(new LatitudeImpl(45, 10, 10, CompassDirection.NORTH), new LongitudeImpl(45, 10, 10, CompassDirection.EAST))},
				{null,  new PositionImpl(new LatitudeImpl(45, 10, 10, CompassDirection.NORTH), new LongitudeImpl(45, 10, 10, CompassDirection.EAST))},
				{"test", null},
				{null,null}
				
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
	public void testVORImpl() {
		VORImpl v = new VORImpl("test", new PositionImpl(new LatitudeImpl(45, 10, 10, CompassDirection.NORTH), new LongitudeImpl(45, 10, 10, CompassDirection.EAST)));
		assertNotNull(v);
		VORImpl p = new VORImpl(null, null);
		assertNull(p);
	}

	@Test
	public void testDistanceTo() {
		VORImpl v = new VORImpl("test", new PositionImpl(new LatitudeImpl(45, 10, 10, CompassDirection.NORTH), new LongitudeImpl(45, 10, 10, CompassDirection.EAST)));
		VORImpl o = new VORImpl("marche", new PositionImpl(new LatitudeImpl(35, 10, 10, CompassDirection.NORTH), new LongitudeImpl(45, 10, 10, CompassDirection.EAST)));
		assert v.distanceTo(o) >=0;
		VORImpl r = new VORImpl("test", new PositionImpl(new LatitudeImpl(45, 10, 10, CompassDirection.NORTH), new LongitudeImpl(45, 10, 10, CompassDirection.EAST)));
		assert v.distanceTo(r) ==0;
		
	}

	@Test
	public void testGetName() {
		VORImpl v = new VORImpl("test", new PositionImpl(new LatitudeImpl(45, 10, 10, CompassDirection.NORTH), new LongitudeImpl(45, 10, 10, CompassDirection.EAST)));
		assertSame(v.getName(), "test");
	}

	@Test
	public void testGetPosition() {
		VORImpl v = new VORImpl("test", new PositionImpl(new LatitudeImpl(45, 10, 10, CompassDirection.NORTH), new LongitudeImpl(45, 10, 10, CompassDirection.EAST)));
		assertSame(v.getPosition(), new PositionImpl(new LatitudeImpl(45, 10, 10, CompassDirection.NORTH), new LongitudeImpl(45, 10, 10, CompassDirection.EAST)));
	}

}

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


@RunWith ( Parameterized.class ) public class TestCoordinateImpl {

	private int arg1;
	private int arg2;
	private int arg3;
	private CompassDirection arg4;
	private CoordinateImpl a;
	
	public TestCoordinateImpl( int arg1, int arg2, int arg3, CompassDirection arg4) {
		this.arg1 = arg1;
		this.arg2 = arg2;
		this.arg3 = arg3;
		this.arg4 = arg4;
	}
	
	@Parameters public static Collection data () {
		Object[][] data = {
				{-1,-1,-1,CompassDirection.NORTH} ,
				{-1,-1,1,CompassDirection.NORTH},
				{-1,-1,6000,CompassDirection.NORTH},
				{-1,1,-1,CompassDirection.NORTH},
				{-1,1,1,CompassDirection.NORTH},
				{-1,1,6000,CompassDirection.NORTH},
				{-1,6000,-1,CompassDirection.NORTH},
				{-1,6000,1,CompassDirection.NORTH},
				{-1,6000,6000,CompassDirection.NORTH},
				{1,-1,-1,CompassDirection.NORTH} ,
				{1,-1,1,CompassDirection.NORTH},
				{1,-1,6000,CompassDirection.NORTH},
				{1,1,-1,CompassDirection.NORTH},
				{1,1,1,CompassDirection.NORTH},
				{1,1,6000,CompassDirection.NORTH},
				{1,6000,-1,CompassDirection.NORTH},
				{1,6000,1,CompassDirection.NORTH},
				{1,6000,6000,CompassDirection.NORTH},
				{6000,-1,-1,CompassDirection.NORTH} ,
				{6000,-1,1,CompassDirection.NORTH},
				{6000,-1,6000,CompassDirection.NORTH},
				{6000,1,-1,CompassDirection.NORTH},
				{6000,1,1,CompassDirection.NORTH},
				{6000,1,6000,CompassDirection.NORTH},
				{6000,6000,-1,CompassDirection.NORTH},
				{6000,6000,1,CompassDirection.NORTH},
				{6000,6000,6000,CompassDirection.NORTH}
				
		};
		return Arrays.asList(data);
	}
	
	@Before
	public void setUp() throws Exception {
		//CoordinateImpl a = new CoordinateImpl(arg1, arg2, arg3, null);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test //(expected = UnsupportedOperationException.class)
	public void testCoordinateImpl() {
		CoordinateImpl a = new CoordinateImpl(arg1, arg2, arg3, arg4);
		assertNotNull(a);
	}

	@Test //(expected = UnsupportedOperationException.class)
	public void testDirection() {
		CoordinateImpl a = new CoordinateImpl(arg1, arg2, arg3, arg4);
		assert a.direction().equals(arg4);
	}

	@Test //(expected = UnsupportedOperationException.class)
	public void testCos() {
		CoordinateImpl a = new CoordinateImpl(arg1, arg2, arg3, arg4);
		assertTrue((a.Cos()>= -1) || (a.Cos()<= 1));
	}

	@Test //(expected = UnsupportedOperationException.class)
	public void testSin() {
		CoordinateImpl a = new CoordinateImpl(arg1, arg2, arg3, null);
		assertTrue((a.Sin()>= 0) || (a.Sin()<= 360));
	}

}

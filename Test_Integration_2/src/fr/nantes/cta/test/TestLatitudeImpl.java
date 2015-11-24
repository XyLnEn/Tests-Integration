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
import fr.nantes.cta.one.LatitudeImpl;

@RunWith ( Parameterized.class ) public class TestLatitudeImpl {

	private int arg1;
	private int arg2;
	private int arg3;
	private CompassDirection arg4;

	
	/**
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 * @param arg4
	 */
	public TestLatitudeImpl(int arg1, int arg2, int arg3, CompassDirection arg4) {
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
				{1,-1,-1,CompassDirection.NORTH},
				{1,-1,1,CompassDirection.NORTH},
				{1,-1,6000,CompassDirection.NORTH},
				{1,1,-1,CompassDirection.NORTH},
				{1,1,1,CompassDirection.NORTH},
				{1,1,6000,CompassDirection.NORTH},
				{1,6000,-1,CompassDirection.NORTH},
				{1,6000,1,CompassDirection.NORTH},
				{1,6000,6000,CompassDirection.NORTH},
				{6000,-1,-1,CompassDirection.NORTH},
				{6000,-1,1,CompassDirection.NORTH},
				{6000,-1,6000,CompassDirection.NORTH},
				{6000,1,-1,CompassDirection.NORTH},
				{6000,1,1,CompassDirection.NORTH},
				{6000,1,6000,CompassDirection.NORTH},
				{6000,6000,-1,CompassDirection.NORTH},
				{6000,6000,1,CompassDirection.NORTH},
				{6000,6000,6000,CompassDirection.NORTH},
				{-1,-1,-1,CompassDirection.EAST} ,
				{-1,-1,1,CompassDirection.EAST},
				{-1,-1,6000,CompassDirection.EAST},
				{-1,1,-1,CompassDirection.EAST},
				{-1,1,1,CompassDirection.EAST},
				{-1,1,6000,CompassDirection.EAST},
				{-1,6000,-1,CompassDirection.EAST},
				{-1,6000,1,CompassDirection.EAST},
				{-1,6000,6000,CompassDirection.EAST},
				{1,-1,-1,CompassDirection.EAST},
				{1,-1,1,CompassDirection.EAST},
				{1,-1,6000,CompassDirection.EAST},
				{1,1,-1,CompassDirection.EAST},
				{1,1,1,CompassDirection.EAST},
				{1,1,6000,CompassDirection.EAST},
				{1,6000,-1,CompassDirection.EAST},
				{1,6000,1,CompassDirection.EAST},
				{1,6000,6000,CompassDirection.EAST},
				{6000,-1,-1,CompassDirection.EAST},
				{6000,-1,1,CompassDirection.EAST},
				{6000,-1,6000,CompassDirection.EAST},
				{6000,1,-1,CompassDirection.EAST},
				{6000,1,1,CompassDirection.EAST},
				{6000,1,6000,CompassDirection.EAST},
				{6000,6000,-1,CompassDirection.EAST},
				{6000,6000,1,CompassDirection.EAST},
				{6000,6000,6000,CompassDirection.EAST}
				
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
	public void testLatitudeImpl() {
		LatitudeImpl lat = null;
		lat = new LatitudeImpl(arg1, arg2, arg3, arg4);
		assert((lat.degrees() >= 0) && (lat.degrees() <= 90));
		
	}

}

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

import fr.nantes.cta.one.AngleImpl;

@RunWith ( Parameterized.class ) public class TestAngleImpl {

	private int arg1;
	private int arg2;
	private int arg3;
	
	public TestAngleImpl( int arg1, int arg2, int arg3) {
		this.arg1 = arg1;
		this.arg2 = arg2;
		this.arg3 = arg3;
	}
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Parameters public static Collection data () {
		Object[][] data = {
				{-1,-1,-1} ,
				{-1,-1,0},
				{-1,-1,6000},
				{-1,0,-1},
				{-1,0,0},
				{-1,0,6000},
				{-1,6000,-1},
				{-1,6000,0},
				{-1,6000,6000},
				{0,-1,-1} ,
				{0,-1,0},
				{0,-1,6000},
				{0,0,-1},
				{0,0,0},
				{0,0,6000},
				{0,6000,-1},
				{0,6000,0},
				{0,6000,6000},
				{6000,-1,-1} ,
				{6000,-1,0},
				{6000,-1,6000},
				{6000,0,-1},
				{6000,0,0},
				{6000,0,6000},
				{6000,6000,-1},
				{6000,6000,0},
				{6000,6000,6000},
				
		};
		return Arrays.asList(data);
	}

	public void testConstr() {
		AngleImpl a = new AngleImpl(arg1, arg2, arg3);
		assertNotNull(a);
	}
	
	@Test
	public void testCos() {
		AngleImpl a = new AngleImpl(arg1, arg2, arg3);
		assertTrue((a.cos()>= -1) || (a.cos()<= 1));
	}

	@Test
	public void testDegrees() {
		AngleImpl a = new AngleImpl(arg1, arg2, arg3);
		assertTrue((a.degrees()>= 0) || (a.degrees()<= 360));
	}

	@Test
	public void testRadians() {
		AngleImpl a = new AngleImpl(arg1, arg2, arg3);
		assertTrue((a.radians()>= 0) || (a.cos()<= 360));
	}

	@Test
	public void testSin() {
		AngleImpl a = new AngleImpl(arg1, arg2, arg3);
		assertTrue((a.sin()>= 0) || (a.sin()<= 360));
	}

}

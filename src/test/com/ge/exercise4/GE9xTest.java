package com.ge.exercise4;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GE9xTest {
	GE9x testEngine;
	
	@Before
    public void setUp() {
        testEngine = new GE9x("0001");
    }
	
	@Test
    public void toStringTest() {
        assertEquals("GE9x SN: 0001", testEngine.toString());
    }
	
	@Test
    public void thrustToWeightRatioTest() {
        assertEquals(testEngine.takeoffThrust / testEngine.dryWeight, testEngine.thrustToWeightRatio(), 0.01);
    }
}

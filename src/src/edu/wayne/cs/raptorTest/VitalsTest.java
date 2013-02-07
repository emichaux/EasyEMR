package edu.wayne.cs.raptorTest;

import edu.wayne.cs.raptor.*;
import org.junit.Test;

public class VitalsTest {

	Vitals vitals = new Vitals();
	
	//no point in testing an empty constructor. 
	
	@Test
	public void testSetAndGetDiastolicBP() {
		int diastolicExpected = 80;
		int diastolicActual;
		vitals.setDiastolicBP(diastolicExpected);
		diastolicActual = vitals.getDiastolicBP();
		assert(diastolicExpected == diastolicActual);
	}

	@Test
	public void testSetAndSetSystolicBP() {
		int systolicExpected = 120;
		int systolicActual;
		vitals.setSystolicBP(systolicExpected);
		systolicActual = vitals.getSystolicBP();
		assert(systolicExpected == systolicActual);
	}

	@Test
	public void testSetAndGetHeartRate() {
		int expectedHeartRate = 65;
		int actualHeartRate;
		vitals.setHeartRate(expectedHeartRate);
		actualHeartRate = vitals.getHeartRate();
		assert(expectedHeartRate == actualHeartRate);
	}


	@Test
	public void testSetAndGetRespRate() {
		int expectedRespRate = 12;
		int actualRespRate;
		vitals.setRespRate(expectedRespRate);
		actualRespRate = vitals.getRespRate();
		assert(expectedRespRate == actualRespRate);
	}

	@Test
	public void testSetAndGetTemperatureC() {
		double expectedTemp = 98.6;
		double actualTemp;
		vitals.setTemperatureF(expectedTemp);
		actualTemp = vitals.getTemperatureF();
		assert(expectedTemp == actualTemp);
	}

	@Test
	public void testSetAndGetOximetry() {
		int expectedOximetry = 95;
		int actualOximetry;
		vitals.setOximetry(expectedOximetry);
		actualOximetry = vitals.getOximetry();
		assert(expectedOximetry == actualOximetry);
	}
}

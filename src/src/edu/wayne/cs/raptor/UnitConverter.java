package edu.wayne.cs.raptor;

public class UnitConverter {
	
	float heightUS;
	float heightM;
	
	float weightUS;
	float weightM;
	
	float bmi;
	
	float tempC;
	float tempF;
	
	int pressureMmHg;
	int pressurePSI;
	
	/**
	 * 
	 * @param heightcustomaryUS - int height in customaryUS units to be converted to metric units 
	 * @param customaryUSUnits - String "in" or "f" representing units of the heightcustomaryUS parameter
	 * @param metricUnitTarget - String name of the metric unit conversion target i.e. "mm", "cm", "m"
	 * @return - int height in specified target units
	 */
	public int getConvertHeightcustomaryUSToMetric(int heightcustomaryUS, String customaryUSUnits, String metricUnitTarget)
	{
		//usermanager.getcurrentuser.getpreferredheightentryunits()
		//otherwise assume feet.  TODO: resolve fractional feet issue
		
		heightUS = heightcustomaryUS;
		
		//convert height input to smallest unit
		if(customaryUSUnits == "f")
			heightUS = heightUS * 12;
		
		//do conversion
		heightM = (heightUS * 2.54f); //height now in cm
		
		//adjust to target units
		if(metricUnitTarget == "m")//target is meters
			heightM = heightM / 100;
		if(metricUnitTarget == "mm");
			heightM = heightM * 10;
		
		//TODO: inspect if we need a more consistent floor/ceiling evaluation, or eval if cast does an appropriate round
		return (int)heightM;
	}
	/**
	 * 
	 * @param heightMetric - int height in metric units to be converted to customaryUS units
	 * @param metricUnits - String units of measurement for parameter HeightMetric i.e. "mm", "cm", "m"
	 * @param customaryUSUnitTarget - String customaryUS conversion target units i.e. "in", "f"
	 * @return - int height in specified target units
	 */
	public int getConvertHeightMetricTocustomaryUS(int heightMetric, String metricUnits, String customaryUSUnitTarget)
	{	
		heightM = heightMetric;
	
		//covert height input to smallest unit
		if(metricUnits == "cm")
			heightM = heightM * 10;
		if(metricUnits == "m")
			heightM = heightM * 1000;
		
		//do conversion
		heightUS = heightM / 25.4f;
		
		//adjust to target units
		if(customaryUSUnitTarget == "f")
			heightUS = heightUS / 12;
		
		return (int)heightUS;
	}
	
	
	/**
	 * 
	 * @param weightcustomaryUS - int weight as measured in customaryUS units
	 * @param customaryUSUnits - String units of measure i.e. "lb", "oz"
	 * @param metricUnitTarget - String metric unit conversion target i.e. "g", "kg"
	 * @return - int converted Metric units of weight
	 */
	public int convertWeightcustomaryUSToMetric(int weightcustomaryUS, String customaryUSUnits, String metricUnitTarget)
	{	
		weightUS = weightcustomaryUS;
		
		//convert weight to larger unit (easier to do conversion, definition is lb-g)
		if(customaryUSUnits == "oz")
			weightUS = weightUS * 16f; //to lb
		
		//do the conversion
		weightM = weightUS * 453.59237f; //to g
		
		//adjust to target units
		if(metricUnitTarget == "kg")
			weightM = weightM * 1000;
		
		return (int)weightM;
	}
	/**
	 * 
	 * @param weightMetric - int weight as measured in metric units
	 * @param metricUnits - String metric unit of measure i.e. "g", "kg"
	 * @param customaryUSUnitTarget - String conversion target us units of measure ie "lb", "oz"
	 * @return - int weight in specified us units of measure
	 */
	public int convertWeightMetricTocustomaryUS(int weightMetric, String metricUnits, String customaryUSUnitTarget)
	{
		weightM = weightMetric;
		
		//convert to g for conversion
		if(metricUnits == "kg")
			weightM = weightM * 1000;
		
		//do the conversion
		weightUS = weightM / 453.59237f; //to lb
		
		if(customaryUSUnitTarget == "oz")
			weightUS = weightUS * 16;
		
		return (int)weightUS;
	}
	
	/**
	 * 
	 * @param measuredTemperature - int measured temperature
	 * @param targetUnits - String target units i.e. "c", "f"
	 * @return - int converted temperature in specified units
	 */
	public int convertTemperature(int measuredTemperature, String targetUnits)
	{
		if(targetUnits == "f")
		{
			
		}
		if(targetUnits == "c")
		{
			
		}
		
		//TODO: make sure returns watch for garbage-in condition.  
		if(targetUnits == "f")
			return (int)tempF;
		if(targetUnits =="c")
			return (int)tempC;
		
		return 0;
	}

	
	public int calculateBMI()
	{
		return calculateBMI((int)this.heightM, (int)this.weightM, "metric");
	}
	
	/**
	 * 
	 * @param measuredHeight - int height for BMI calculation (inches or meters)
	 * @param measuredWeight - int weight for BMI calculation (Kg or Lb)
	 * @param unitSystem - String "US" or "metric" defining the units for supplied measurements
	 * @return - int calculated BMI
	 */
	public int calculateBMI(int measuredHeight, int measuredWeight, String unitSystem)
	{
		//TODO: evaluate all these type conversions.  
		if(unitSystem == "US")
		{
			bmi = (float)( measuredWeight / (Math.pow(measuredHeight, 2)) ) * 703.06957964f;
		}
		if(unitSystem == "metric")
		{
			bmi = (float)( measuredWeight / Math.pow(measuredHeight, 2));
		}
		
		return (int)bmi;
	}
	
	public static boolean isNullOrBlank(String param) 
	{ 
	    return param == null || param.trim().length() == 0;
	}
}

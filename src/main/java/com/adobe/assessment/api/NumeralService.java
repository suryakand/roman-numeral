package com.adobe.assessment.api;

public interface NumeralService<S, T> {

	/**
	 * This method must be implemented by various number converter services 
	 * to support number conversion (e.g. hex to decimal, decimal to binary etc.)
	 * 
	 * @param e
	 */
	T convert(S e);
}

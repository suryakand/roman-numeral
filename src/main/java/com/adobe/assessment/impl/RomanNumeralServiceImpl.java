package com.adobe.assessment.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.adobe.assessment.api.NumeralService;

/**
 * 
 * @author Suryakand Shinde
 *
 * An implementation of {@link NumeralService} to convert decimal Integer numbers to Roman number
 */
@Component
@PropertySource("classpath:application.properties")
public class RomanNumeralServiceImpl implements NumeralService<Integer, String> {
	private Logger logger = LoggerFactory.getLogger(RomanNumeralServiceImpl.class);

	@Value("${numeral.mapping.decimal}")
	private List<Integer> numeralInteger;

	@Value("${numeral.mapping.roman}")
	private List<String> numeralRoman;


	@Override
	public String convert(Integer num) {
		return convertToRoman(num, "");
	}

	/**
	 * A recursive method to convert given Integer number to Roman representation.
	 * @param decimal the Integer number to be converted to Roman number
	 * @param roman the Roman number representation of current Integer (initially it is empty string)
	 * @return Roman representation of Integer number
	 */
	protected String convertToRoman(Integer decimal, String roman) {
		logger.debug("Converting Integer number: {} to roman number", decimal);

		if (decimal == 0) {
			return roman; //TODO: we can throw exception here or return nulla
		}

		for (int i = numeralInteger.size()-1; i >= 0; i--) {
			if (decimal >= numeralInteger.get(i)) {
				logger.debug("Current Integer number to be processed: {}", decimal);
				return convertToRoman(decimal - numeralInteger.get(i), roman + numeralRoman.get(i));
			}
		}

		return roman;
	}

}


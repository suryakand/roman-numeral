package com.adobe.assessment.impl.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.adobe.assessment.api.NumeralService;
import com.adobe.assessment.impl.RomanNumeralServiceImpl;

@SpringBootTest
@SpringBootConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("/test.properties")
public class RomanNumeralServiceTest {

	@Value("${numeral.mapping.decimal}") 
	List<Integer> numeralInteger;
	@Value("${numeral.mapping.roman}") 
	List<String> numeralRoman;

	@Test
	public void testConvertWithZeroInteger() {
		NumeralService<Integer, String> romanNumeralService = new  RomanNumeralServiceImpl(numeralInteger, numeralRoman);
		assertEquals(romanNumeralService.convert(0), "");
	}

	@Test
	public void testConvertWithNonZeroInteger() {
		NumeralService<Integer, String> romanNumeralService = new  RomanNumeralServiceImpl(numeralInteger, numeralRoman);
		assertEquals(romanNumeralService.convert(12), "XII");
	}
}

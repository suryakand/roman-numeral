package com.adobe.assessment.web.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.adobe.assessment.api.NumeralService;
import com.adobe.assessment.web.RomanNumeralController;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RomanNumeralController.class)
public class RomanNumeralControllerTest {

	@MockBean
	NumeralService<Integer, String> numeralService;

	@Autowired
	MockMvc mockMvc;

	@Test
	public void testRomanNumeralWithNonZeroInput() throws Exception {
		Mockito.when(numeralService.convert(12)).thenReturn("XII");

		mockMvc.perform(get("/romannumeral").queryParam("query", "12"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", Matchers.hasKey("input")))
		.andExpect(jsonPath("$", Matchers.hasKey("output")))
		.andExpect(jsonPath("$.input", Matchers.is(12)))
		.andExpect(jsonPath("$.output", Matchers.is("XII")));
	}

	@Test
	public void testRomanNumeralWithZeroInput() throws Exception {
		mockMvc.perform(get("/romannumeral").queryParam("query", "0"))
		.andExpect(status().isBadRequest());
	}
	
	@Test
	public void testRomanNumeralWithOutsideRangeInput() throws Exception {
		mockMvc.perform(get("/romannumeral").queryParam("query", "300"))
		.andExpect(status().isBadRequest());
	}
	
	@Test
	public void testRomanNumeraExtensionOnelWithNonZeroInput() throws Exception {
		Mockito.when(numeralService.convert(12)).thenReturn("XII");

		mockMvc.perform(get("/romannumeral-extension-one").queryParam("query", "12"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", Matchers.hasKey("input")))
		.andExpect(jsonPath("$", Matchers.hasKey("output")))
		.andExpect(jsonPath("$.input", Matchers.is(12)))
		.andExpect(jsonPath("$.output", Matchers.is("XII")));
	}
	
	@Test
	public void testRomanNumeraExtensionOnelWithZeroInput() throws Exception {
		mockMvc.perform(get("/romannumeral-extension-one").queryParam("query", "0"))
		.andExpect(status().isBadRequest());
	}
	
	@Test
	public void testRomanNumeraExtensionOnelWithOutsideRangeInput() throws Exception {
		mockMvc.perform(get("/romannumeral-extension-one").queryParam("query", "4000"))
		.andExpect(status().isBadRequest());
	}
}

package com.adobe.assessment.web.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.adobe.assessment.web.RomanNumeralController;


@SpringBootTest
@RunWith(SpringRunner.class)
public class RomanNumeralControllerIntegrationTest {

    MockMvc mockMvc;

    @Autowired
    RomanNumeralController romanNumeralController;

    @Before
    public void setup() throws Exception {
        this.mockMvc = standaloneSetup(this.romanNumeralController).build();
    }

    @Test
    public void testRomanNumeralWithNonZeroInput() throws Exception {
        mockMvc.perform(get("/romannumeral").queryParam("query", "12").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", Matchers.hasKey("input")))
		.andExpect(jsonPath("$", Matchers.hasKey("output")))
		.andExpect(jsonPath("$.input", Matchers.is(12)))
		.andExpect(jsonPath("$.output", Matchers.is("XII")));
    }



}
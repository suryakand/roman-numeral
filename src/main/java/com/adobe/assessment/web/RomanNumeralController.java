package com.adobe.assessment.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adobe.assessment.api.NumeralService;
import com.adobe.assessment.exception.InvalidIntegerException;
import com.adobe.assessment.impl.RomanNumeralServiceImpl;
import com.adobe.assessment.model.IntegerToRomanResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * 
 * REST API controller with multiple endpoints with different boundary conditions 
 * to return Roman numbers 
 * 
 * @author Suryakand Shinde
 *
 */
@RestController
@PropertySource("classpath:application.properties")
public class RomanNumeralController {
	private Logger logger = LoggerFactory.getLogger(RomanNumeralServiceImpl.class);

	@Autowired
	private NumeralService<Integer, String> numeralService;

	@Value("${limit.integer.range}")
	private Integer limitIntegerRange;
	
	@Value("${limit.integer.range.extension.one}")
	private Integer limitIntegerRangeExtensionOne;
	
	/**
	 * REST API endpoint that validate whether provided Integer input is in rage or not (i.e. 1-255) 
	 * and return a Roman representation of the provided Integer number.
	 * 
	 * @param romannumeral
	 * @return
	 */

	@Operation(summary = "REST API endpoint that validate whether provided Integer input is in rage or not (i.e. 1-255)"
			+ " and return a Roman representation of the provided Integer number.")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Returns a Roman Number", 
					content = { @Content(mediaType = "application/json", 
					schema = @Schema(implementation = IntegerToRomanResponse.class)) }),
			@ApiResponse(responseCode = "400", description = "Bad Request (Integer number out of range for this API)", 
			content = @Content)
	})

	@RequestMapping(value = "/romannumeral", method = RequestMethod.GET, produces = "application/json")
	public IntegerToRomanResponse getRomanNumber(@RequestParam Integer query) {
		if(limitIntegerRange != -1 && (query < 1 || query > limitIntegerRange)) {
			logger.error("{} is greater than valid range (1-255)", query);
			throw new InvalidIntegerException();
		} 

		return convertToRomanNumber(query);
	}

	/**
	 * An alternate REST API endpoint that does not validate whether the provided
	 * Integer input is in rage or not?
	 * 
	 * @param romannumeral
	 * @return
	 */
	
	@Operation(summary = "An alternate REST API endpoint that does not validate whether the provided"
			+ " Integer input is in rage or not?")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Return a Roman Number", 
					content = { @Content(mediaType = "application/json", 
					schema = @Schema(implementation = IntegerToRomanResponse.class)) })
			 })
	
	@RequestMapping(value = "/romannumeral-extension-one", method = RequestMethod.GET, produces = "application/json")
	public IntegerToRomanResponse getRomanNumberExtended(@RequestParam Integer query) {
		if(limitIntegerRangeExtensionOne != -1 && (query < 1 || query > limitIntegerRangeExtensionOne)) {
			logger.error("{} is greater than valid range (1-255)", query);
			throw new InvalidIntegerException();
		}		
		return convertToRomanNumber(query);
	}

	/**
	 * This method simply converts a given Integer to Roman number. 
	 * It is a reusable method that can be called from multiple controller methods.
	 *  
	 * @param romannumeral
	 * @return {@link IntegerToRomanResponse}
	 */
	protected IntegerToRomanResponse convertToRomanNumber(Integer romannumeral) {
		logger.debug("Request received to convert Integer value {} to Roman number", romannumeral);

		IntegerToRomanResponse resposne = new IntegerToRomanResponse();

		resposne.setInput(romannumeral);
		resposne.setOutput(numeralService.convert(romannumeral));

		return resposne;
	}
}


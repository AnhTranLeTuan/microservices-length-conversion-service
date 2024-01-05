package project.microservices.lengthconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LengthConversionServiceController {
	
	@Autowired
	LengthExchangeProxy lengthExchangeProxy; 
	
	@GetMapping("/length-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public LengthConversion calculateLengthConversion(@PathVariable String from, 
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		
		HashMap<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		ResponseEntity<LengthConversion> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/length-exchange/from/{from}/to/{to}",
				LengthConversion.class, uriVariables);
		LengthConversion lengthConversion = responseEntity.getBody();
		
				return new LengthConversion(lengthConversion.getId(), from, to, quantity,
						lengthConversion.getConversionMultiple(), 
						quantity.multiply(lengthConversion.getConversionMultiple()), 
						lengthConversion.getPort());
		
	}
	
	@GetMapping("/length-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public LengthConversion calculateLengthConversionFeign(@PathVariable String from, 
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		LengthConversion lengthConversion = lengthExchangeProxy.
				retrieveExchangeValue(from, to);
		return new LengthConversion(lengthConversion.getId(), from, to, quantity,
				lengthConversion.getConversionMultiple(), 
				quantity.multiply(lengthConversion.getConversionMultiple()), 
				lengthConversion.getPort());
		
	}

}

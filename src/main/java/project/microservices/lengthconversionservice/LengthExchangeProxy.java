package project.microservices.lengthconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//@FeignClient(name="length-exchange-service", url="http://localhost:8000")
@FeignClient(name="length-exchange-service")
public interface LengthExchangeProxy {
	
	@GetMapping("/length-exchange/from/{from}/to/{to}")
	public  LengthConversion retrieveExchangeValue(@PathVariable String from, 
			@PathVariable String to);
}

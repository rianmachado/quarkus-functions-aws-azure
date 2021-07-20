package rian.example.quarkusfunction;

import java.util.UUID;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

@Named("Greet")
public class FunctionEventLambda implements RequestHandler<PandemicRequestDTO, PandemicResponseDTO> {

	private static final Logger LOGGER = LoggerFactory.getLogger(FunctionEventLambda.class);

	@Override
	public PandemicResponseDTO handleRequest(PandemicRequestDTO input, Context context) {
		LOGGER.info("GreetDemo................................ " + input.toString());
		return PandemicResponseDTO.builder()
				.reportTitle("Report Greet Demo " + input.getCountry() + UUID.randomUUID().toString()).build();
	}
}

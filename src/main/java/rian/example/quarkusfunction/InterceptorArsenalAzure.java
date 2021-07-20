package rian.example.quarkusfunction;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@ArsenalAzJson
@Priority(10)
@Interceptor
public class InterceptorArsenalAzure {

	@AroundInvoke
	/*
	 * Interceptor APENAS PARA ILUSTRAR COMO PODEMOS TRATAR DADOS COM BASE EM TIPOS DE TRIGGER
	 */
	Object logInvocation(InvocationContext context) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		String json =  "{\"orderId\": \"6\",\"customerName\": \"customer-6\",\"customerId\": \"customer-6\",\"productName\": \"product-6\"}";
		JsonNode jsonNode = objectMapper.readTree(json);
		Object[] parameters = context.getParameters();
		((InvokeRequest)parameters[0]).Data.put("payload", jsonNode.toString());
		Object ret = context.proceed();
		return ret;
	}

}
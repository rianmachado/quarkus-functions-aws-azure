package rian.example.quarkusfunction;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.annotation.Cardinality;
import com.microsoft.azure.functions.annotation.CosmosDBOutput;
import com.microsoft.azure.functions.annotation.EventHubTrigger;
import com.microsoft.azure.functions.annotation.FunctionName;

/**
 * Functions to generate data to event hubs, consume data from event hubs and
 * store it in cosmosdb
 */
public class OrderProcessor {

	/*
	@Funq("storeOrders")
	@ArsenalAzJson
	public InvokeResponse storeOrders(InvokeRequest request) {
		System.out.println("Java  trigger handler..");
		InvokeResponse resp = new InvokeResponse(); // resp.Logs.add("Java: test log1 ");
		resp.Logs.add("Java: test log2 " + request.Metadata.toString());
		resp.Logs.add("Java: test log3 " + request.Data.toString());
		resp.ReturnValue = request.Data.get("payload");

		resp.Logs.add("Java: test log " + request.Data.get("payload"));
		return resp;
	}
	*/

	
	 @FunctionName("storeOrders")
	 @CosmosDBOutput(name = "databaseOutput", databaseName = "AppStore", collectionName = "orders", connectionStringSetting = "CosmosDBConnectionString")
	 public String storeOrders(  
		@EventHubTrigger(name = "orders", eventHubName = "", connection = "EventHubConnectionString", cardinality = Cardinality.ONE) OrderEvent
		orderEvent, final ExecutionContext context) {
	  
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "{\"orderId\": \"6\",\"customerName\": \"customer-6\",\"customerId\": \"customer-6\",\"productName\": \"product-6\"}";
	  
		JsonNode jsonNode = null;
	  
		try {
			  jsonNode = objectMapper.readTree(json);
		  
		} catch (JsonProcessingException e) {
			  e.printStackTrace();
		}
	  
	  return jsonNode.toString(); 
	  
	 }
	 

}

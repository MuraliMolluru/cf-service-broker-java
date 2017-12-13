package com.swisscom.servicebroker.rest;
 
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
 
@Path("/cf-broker")
public class SimpleServiceBroker {
	
	private String jsonResponse = "{\r\n" + 
			"   \"services\": [\r\n" + 
			"      {\r\n" + 
			"         \"name\": \"Space-Scoped-Service-java\",\r\n" + 
			"         \"id\": \"b7dd8790-4d3d-4cf0-8992-c55691adee1c\",\r\n" + 
			"         \"description\": \"space scoped service\",\r\n" + 
			"         \"bindable\": true,\r\n" + 
			"         \"tags\": [\r\n" + 
			"            \"Test\",\r\n" + 
			"            \"hello\"\r\n" + 
			"         ],\r\n" + 
			"         \"metadata\": {\r\n" + 
			"            \"displayName\": \"SpaceScoped\",\r\n" + 
			"            \"longDescription\": \"Testing\",\r\n" + 
			"            \"providerDisplayName\": \"Test\",\r\n" + 
			"            \"documentationUrl\": \"http://test.com/\",\r\n" + 
			"            \"supportUrl\": \"http://support.test.com/\"\r\n" + 
			"         },\r\n" + 
			"         \"plans\": [\r\n" + 
			"            {\r\n" + 
			"               \"name\": \"small\",\r\n" + 
			"               \"id\": \"2689eec7-8c42-4fb7-b51b-9f48fd41f79e\",\r\n" + 
			"               \"description\": \"small\",\r\n" + 
			"               \"metadata\": {\r\n" + 
			"                  \"displayName\": \"Small\",\r\n" + 
			"                  \"cost\": 0,\r\n" + 
			"                  \"bullets\": [\r\n" + 
			"                     {\r\n" + 
			"                        \"content\": \"test\"\r\n" + 
			"                     }\r\n" + 
			"                  ]\r\n" + 
			"               }\r\n" + 
			"            },\r\n" + 
			"            {\r\n" + 
			"               \"name\": \"medium\",\r\n" + 
			"               \"id\": \"34dfba58-337f-4dec-8731-1bb76d1c3cca\",\r\n" + 
			"               \"description\": \"medium\",\r\n" + 
			"               \"metadata\": {\r\n" + 
			"                  \"displayName\": \"Medium\",\r\n" + 
			"                  \"cost\": 0,\r\n" + 
			"                  \"bullets\": [\r\n" + 
			"                     {\r\n" + 
			"                        \"content\": \"test\"\r\n" + 
			"                     }\r\n" + 
			"                  ]\r\n" + 
			"               }\r\n" + 
			"            }\r\n" + 
			"         ]\r\n" + 
			"      }\r\n" + 
			"   ]\r\n" + 
			"}";
 
	@GET
	@Path("/v2")
	public Response getV2(){
		System.out.println("calling rest api...");
		return Response.status(200).entity("V2 calling").build();
	}
	
	@GET
	@Path("/v2/catalog")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCatelog() {
		System.out.println("Returning catalog");
		return Response.status(200).entity(jsonResponse).build();
	}
	
	
	@PUT
	@Path("/v2/service_instances/{instance_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createServiceInstance(@PathParam("instance_id") String instanceID) {
		System.out.println("creating service instance: "+instanceID);
		return Response.status(200).entity("{\"foobar\": \"hi\"}").build();
	}
	
	@DELETE
	@Path("/v2/service_instances/{instance_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteServiceInstance(@PathParam("instance_id") String instanceID) {
		System.out.println("deleting service instance: "+instanceID);
		return Response.status(200).entity("{\"foobar\": \"hi\"}").build();
	}
	
	@PUT
	@Path("/v2/service_instances/{instance_id}/service_bindings/{binding_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createServiceBinding(@PathParam("param") String bindingId) {
		System.out.println("binding service instance: "+bindingId);
		return Response.status(200).entity("{\r\n" + 
				"      \"credentials\": {\r\n" + 
				"        \"foo\": \"hi\"\r\n" + 
				"      }").build();
	}
	
	@DELETE
	@Path("/v2/service_instances/{instance_id}/service_bindings/{binding_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteServiceBinding(@PathParam("param") String bindingId) {
		System.out.println("unbinding service instance: "+bindingId);
		return Response.status(200).entity("{\r\n" + 
				"      \"credentials\": {\r\n" + 
				"        \"foo\": \"hi\"\r\n" + 
				"      }").build();
	}
	
	@GET
	@Path("/v2/cf-ext/{instance_id}/endpoint")
	@Produces(MediaType.APPLICATION_JSON)
	public Response endpoint(@PathParam("param") String instance_id) {
		System.out.println("calling endpoint for service instance: "+instance_id);
		return Response.status(200).entity("{\r\n" + 
				"      \"credentials\": {\r\n" + 
				"        \"foo\": \"hi\"\r\n" + 
				"      }").build();
	}	
}
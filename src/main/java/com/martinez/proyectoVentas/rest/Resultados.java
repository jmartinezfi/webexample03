package com.martinez.proyectoVentas.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;
@Path(value = "/resultados")
public class Resultados {

	@GET
	@Produces("text/plain")
	public String getClichedMessage() {
		// Return some cliched textual content
		return "Hello World";
	}

	@Path("{f}")
	@GET
	@Produces("application/json")
	public Response convertFtoCfromInput(@PathParam("f") float f) throws JSONException {

		JSONObject jsonObject = new JSONObject();
		float celsius;
		celsius = (f - 32) * 5 / 9;
		jsonObject.put("F Value", f);
		jsonObject.put("C Value", celsius);

		String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	}
	
	@Path("{f}/{s}")
	@GET
	@Produces("application/json")
	public Response insert(@PathParam("f") float f, @PathParam("s") String s) throws JSONException {

		JSONObject jsonObject = new JSONObject();
		float celsius;
		celsius = (f - 32) * 5 / 9;
		jsonObject.put("F Value", f);
		jsonObject.put("C Value", celsius);
		
		com.martinez.proyectoVentas.dao.FormularioDao dao = new com.martinez.proyectoVentas.dao.FormularioDaoImpl();
		Object resultado = dao.listado(null);
		//result += resultado;
		//result += "Listado Final.";
		jsonObject.put("resultado", resultado);
		String result = "@Produces(\"application/json\") Output: \n\nF to #"+s+": \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	}

}

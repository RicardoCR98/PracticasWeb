package serviciosRest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import dao.PersonaDAO;
import imp.ImplementacionDAO;
import modelo.Persona;

@Path("/personas")
public class PersonaRecurso {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Persona> getPersonas(){
		PersonaDAO personaModelo = new ImplementacionDAO();
		return personaModelo.getPersonas();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Persona getPersonaByPathParam(@PathParam("id") int id) {
		PersonaDAO personaModelo = new ImplementacionDAO();
		return personaModelo.getById(id);
	}
	@GET
	@Path("/query")
	@Produces(MediaType.APPLICATION_JSON)
	public Persona getPersonaByQueryParam(@QueryParam("id") int id) {
		PersonaDAO personaModelo = new ImplementacionDAO();
		return personaModelo.getById(id);
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public void guardarPersona (Persona p) {
		PersonaDAO personaModelo = new ImplementacionDAO();
		personaModelo.addPersona(p);
		
	}
	@PUT
	@Path("/update")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public void actualizarPersona(Persona p) {
		PersonaDAO personaModelo = new ImplementacionDAO();
		personaModelo.actualizar(p);
		
	}
	
	@DELETE
	@Path("/delete/{id}")
	public void eliminarPersona(@PathParam("id")int id) {
		PersonaDAO personaModelo = new ImplementacionDAO();
		personaModelo.eliminar(id);
	}
	

}
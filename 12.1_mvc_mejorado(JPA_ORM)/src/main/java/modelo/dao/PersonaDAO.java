package modelo.dao;

import java.util.List;

import modelo.entidades.Persona;

public interface PersonaDAO extends GenericDAO<Persona, Integer>{
	public Persona autorizar(String nombre, String clave);

	public List<Persona> getPersonas();
	
}

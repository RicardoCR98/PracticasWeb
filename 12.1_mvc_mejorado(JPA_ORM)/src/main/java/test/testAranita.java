package test;

import modelo.dao.DAOFactory;
import modelo.entidades.Persona;

public class testAranita {

	public static void main(String[] args) {

		Persona persona =  DAOFactory.getFactory().getPersonaDAO().autorizar("Carlos", "carlos456");

	}
 
}

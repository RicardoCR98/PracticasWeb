package modelo.dao;

import modelo.jpa.JPADAOFactory;

public abstract class DAOFactory {
	protected static DAOFactory factory = new JPADAOFactory(); //Inyeccion de dependencias
	
	public static DAOFactory getFactory() {
		return factory;
	}
	
	public abstract PersonaDAO getPersonaDAO();
	
	
}

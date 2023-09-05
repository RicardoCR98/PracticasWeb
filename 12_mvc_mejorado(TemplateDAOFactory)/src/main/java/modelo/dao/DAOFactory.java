package modelo.dao;

public class DAOFactory {
	
	private static DAOFactory factory;
	
	private DAOFactory() {
		
	}
	
	public static DAOFactory getFactory() {
		if(factory==null) {
			return new DAOFactory();
		}
		return factory;
	}
	
	public PersonaDAO getPersonaDAO() {
		return new PersonaDAO();
	}
}

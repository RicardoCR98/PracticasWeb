import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Persona;

class TestPersona {

	//Yo como usuario quiero autoizarme.... para....
	@Test
	void test() {
		//usuario y clave dada 
		String nombre = "Carlos";
		String password = "Carlos123";
		
		Persona p = new Persona();
		Persona personaAutorizar = p.autorizar(nombre, password);
		
		//Validacion
		assertTrue("Usuario autorizado",personaAutorizar != null);
		
	}

}

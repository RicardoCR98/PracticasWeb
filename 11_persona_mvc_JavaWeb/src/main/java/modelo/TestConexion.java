package modelo;

import java.sql.Connection;

public class TestConexion {
	
	public static void main(String [] args) {
		Connection cnn = BddConection.getConnection();
		
		if(cnn != null) {
			System.out.println("Tenemos conexion");
		}else {
			System.out.println("Fallo en la conexion");
		}
	}

}

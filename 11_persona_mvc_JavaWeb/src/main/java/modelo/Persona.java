package modelo;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	final String SQL_SELECT_ALL = "SELECT * FROM persona;";
	final String SQL_SELECT_BY_ID = "SELECT * FROM persona WHERE id = ?";
	final String SQL_INSERT = "INSERT INTO persona (nombre, password, esadmin) VALUES (?,?,?)";
	final String SQL_DELETE_BY_ID = "DELETE FROM persona WHERE id = ?";
	final String SQL_UPDATE = "UPDATE persona SET nombre = ? , password = ?, esadmin = ? WHERE id= ?";
	final String SQL_AUTORIZAR = "SELECT * FROM persona WHERE nombre = ? AND password = ?";

	private Integer id;
	private String nombre;
	private String password;
	private Boolean esadmin;

	// private static List<Persona> personas = null;

	public Persona() {
	}

	public Persona(Integer id, String nombre, String password, boolean esadmin) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.password = password;
		this.esadmin = esadmin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEsadmin() {
		return esadmin;
	}

	public void setEsadmin(Boolean esadmin) {
		this.esadmin = esadmin;
	}
	// REGLAS DEL NEGOCIO

	public Persona autorizar(String usuario, String password) {
		
		Persona personaAutorizada = null;
		/*
		List<Persona> listaPersonas =  this.getPersonas();
		
		for (Persona persona : listaPersonas) {
			if (persona.getNombre().equals(usuario) && 
					persona.getPassword().equals( password)) {
				
				personaAutorizada = persona;
				break;
			}
		}
		*/
		
		/*

		List<Persona> listPersonas = this.getPersonas();

		for (Persona persona : listPersonas) {
			if (persona.getId() == id) {
				p = persona;
				break;
			}
		}
		*/
		
		try {
			PreparedStatement pstm= BddConection.getConnection().prepareStatement(SQL_AUTORIZAR);
			pstm.setString(1, usuario);
			pstm.setString(2, password);
			
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				Persona persona = new Persona();
				persona.setId(rs.getInt("id"));
				persona.setNombre(rs.getString("nombre"));
				persona.setPassword(rs.getString("password"));
				persona.setEsadmin(rs.getBoolean("esadmin"));
				personaAutorizada = persona;
			}
			BddConection.cerrar(rs);
			BddConection.cerrar(pstm);
			BddConection.cerrar( );
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return personaAutorizada;
	}

	public List<Persona> getPersonas() {
		/*
		 * if (personas == null) { personas = new ArrayList<>();
		 * 
		 * personas.add(new Persona(1, "Carlos", "carlos123")); personas.add(new
		 * Persona(2, "Liz", "liz123")); personas.add(new Persona(3, "Maria",
		 * "maria123")); personas.add(new Persona(4, "Juan", "juan123")); }
		 * 
		 * return personas;
		 */

		// Conexion a BDD
		List<Persona> listaPersonas = new ArrayList<>();

		try {
			PreparedStatement pstm = BddConection.getConnection().prepareStatement(SQL_SELECT_ALL);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				Persona persona = new Persona();
				persona.setId(rs.getInt("id"));
				persona.setNombre(rs.getString("nombre"));
				persona.setPassword(rs.getString("password"));
				persona.setEsadmin(rs.getBoolean("esadmin"));

				listaPersonas.add(persona);
			}
			BddConection.cerrar(rs);
			BddConection.cerrar(pstm);
			BddConection.cerrar();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaPersonas;

	}

	public Persona getById(int id) {

		Persona p = null;

		/*
		 * 
		 * List<Persona> listPersonas = this.getPersonas();
		 * 
		 * for (Persona persona : listPersonas) { if (persona.getId() == id) { p =
		 * persona; break; } }
		 */

		try {
			PreparedStatement pstm = BddConection.getConnection().prepareStatement(SQL_SELECT_BY_ID);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				Persona persona = new Persona();
				persona.setId(rs.getInt("id"));
				persona.setNombre(rs.getString("nombre"));
				persona.setPassword(rs.getString("password"));
				persona.setEsadmin(rs.getBoolean("esadmin"));
				p = persona;
			}
			BddConection.cerrar(rs);
			BddConection.cerrar(pstm);
			BddConection.cerrar();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}

	public void create(Persona p) {
		/*
		 * this.getPersonas().add(p);
		 */

		try {
			PreparedStatement pstm = BddConection.getConnection().prepareStatement(SQL_INSERT);
			pstm.setString(1, p.getNombre());
			pstm.setString(2, p.getPassword());
			pstm.setBoolean(3, p.getEsadmin());

			pstm.executeUpdate();

			BddConection.cerrar(pstm);
			BddConection.cerrar();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void update(Persona p) {
		/*
		 * List<Persona> listaPersonas = this.getPersonas();
		 * 
		 * for (int i = 0; i < listaPersonas.size(); i++) { if
		 * (listaPersonas.get(i).getId() == p.getId()) {
		 * listaPersonas.get(i).setNombre(p.getNombre());
		 * listaPersonas.get(i).setPassword(p.getPassword()); break; } }
		 */

		try {
			PreparedStatement pstm = BddConection.getConnection().prepareStatement(SQL_UPDATE);
			pstm.setString(1, p.getNombre());
			pstm.setString(2, p.getPassword());
			pstm.setBoolean(3, p.getEsadmin());
			pstm.setInt(4, p.getId());

			pstm.executeUpdate();

			BddConection.cerrar(pstm);
			BddConection.cerrar();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		/*
		 * List<Persona> listaPersonas = this.getPersonas();
		 * 
		 * for (int i = 0; i < listaPersonas.size(); i++) { if
		 * (listaPersonas.get(i).getId() == id) { listaPersonas.remove(i); break; } }
		 */
		try {
			PreparedStatement pstm = BddConection.getConnection().prepareStatement(SQL_DELETE_BY_ID);
			pstm.setInt(1, id);

			pstm.executeUpdate();

			BddConection.cerrar(pstm);
			BddConection.cerrar();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
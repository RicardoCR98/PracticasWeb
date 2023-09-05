package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.bdd.BddConection;
import modelo.entidades.Persona;

public class PersonaDAO {
	final String SQL_SELECT_ALL = "SELECT * FROM persona;";
	final String SQL_SELECT_BY_ID = "SELECT * FROM persona WHERE id = ?";
	final String SQL_INSERT = "INSERT INTO persona (nombre, password, esadmin) VALUES (?,?,?)";
	final String SQL_DELETE_BY_ID = "DELETE FROM persona WHERE id = ?";
	final String SQL_UPDATE = "UPDATE persona SET nombre = ? , password = ?, esadmin = ? WHERE id= ?";
	final String SQL_AUTORIZAR = "SELECT * FROM persona WHERE nombre = ? AND password = ?";
	// REGLAS DEL NEGOCIO
	
	public PersonaDAO() {
		
	}

	public Persona autorizar(String usuario, String password) {

		Persona personaAutorizada = null;
		try {
			PreparedStatement pstm = BddConection.getConnection().prepareStatement(SQL_AUTORIZAR);
			pstm.setString(1, usuario);
			pstm.setString(2, password);

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				Persona persona = new Persona();
				persona.setId(rs.getInt("id"));
				persona.setNombre(rs.getString("nombre"));
				persona.setPassword(rs.getString("password"));
				persona.setEsadmin(rs.getBoolean("esadmin"));
				personaAutorizada = persona;
			}
			BddConection.cerrar(rs);
			BddConection.cerrar(pstm);
			BddConection.cerrar();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return personaAutorizada;
	}

	public List<Persona> getPersonas() {


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

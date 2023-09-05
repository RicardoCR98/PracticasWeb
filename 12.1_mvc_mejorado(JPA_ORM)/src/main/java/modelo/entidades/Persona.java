package modelo.entidades;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.bdd.BddConection;

public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;
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

}
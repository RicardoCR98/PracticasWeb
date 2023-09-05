package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="Persona")
@NamedQueries({
	@NamedQuery(name="autorizar", query="SELECT p FROM Persona p WHERE p.nombre= :nombre AND p.clave= :clave")
})
public class Persona implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nombre")
	private String nombre;
	@Column(name="clave")
	private String clave;
	
	public Persona() {
		
	}

	public Persona(Integer id, String nombre, String clave) {
		this.id = id;
		this.nombre = nombre;
		this.clave = clave;
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

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", clave=" + clave + "]";
	}
	
	
	
}

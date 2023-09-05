package modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cuenta")
public class CuentaBancaria implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="numero")
	private String numero;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="banco")
	private Banco banco;
	
	//al mapear de esta forma, desde cuenta bancaria puedo saber cual es el propetario
	//Pero desde persona yo no puedo saber las cuentas de esa persona
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name="propietario")
	private Persona proprietario;
	
	public CuentaBancaria() {
		
	}

	public CuentaBancaria(Integer id, String numero, Banco banco, Persona proprietario) {
		
		this.id = id;
		this.numero = numero;
		this.banco = banco;
		this.proprietario = proprietario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Persona getProprietario() {
		return proprietario;
	}

	public void setProprietario(Persona proprietario) {
		this.proprietario = proprietario;
	}

	@Override
	public String toString() {
		return "CuentaBancaria [id=" + id + ", numero=" + numero + ", banco=" + banco + ", proprietario=" + proprietario
				+ "]";
	}
	
	
}

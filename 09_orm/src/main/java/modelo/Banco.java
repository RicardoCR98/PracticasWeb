package modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Banco")
public class Banco implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nombre_banco")
	private String nombreBanco;
	
	//quiero que sea carga perezosa, osea cuando traiga yo banco no me traiga todas las cuentas
	//Si no solo cuando yo ponga banco.getCuentas. eso es una carga perezosa (fetchtype.lazy)
	//si ponga eager(carga automatica) , cuando yo recupere banco el me va a traer las cuentas de ese banco (muy pesado)
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "banco")
	private List<CuentaBancaria> cuentas;
	
	public Banco() {
		
	}

	public Banco(Integer id, String nombreBanco) {
		this.id = id;
		this.nombreBanco = nombreBanco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreBanco() {
		return nombreBanco;
	}

	public void setNombreBanco(String nombreBanco) {
		this.nombreBanco = nombreBanco;
	}

	public List<CuentaBancaria> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<CuentaBancaria> cuentas) {
		this.cuentas = cuentas;
	}

	@Override
	public String toString() {
		return "Banco [id=" + id + ", nombreBanco=" + nombreBanco + ", cuentas=" + cuentas + "]";
	}
	
	
	
}

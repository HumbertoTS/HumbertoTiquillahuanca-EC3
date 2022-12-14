package EC3HumbertoTiquillahuancaCitas.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	private String nombre;
	private Integer celular;
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "cliente_hospital", joinColumns = @JoinColumn(name = "id_cliente", nullable = false, unique = true, foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_cliente) references cliente(id_cliente)")), inverseJoinColumns = @JoinColumn(name = "id_hospital", nullable = false, unique = true, foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_hospital) references hospital(id_hospital)")))
	private List<Hospital> hospital = new ArrayList<>();
	
	/*
	 * @OneToMany(mappedBy = "cliente") private List<UsuarioCliente> usuariocliente
	 * =new ArrayList<>();
	 */
	
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCelular() {
		return celular;
	}
	public void setCelular(Integer celular) {
		this.celular = celular;
	}

}

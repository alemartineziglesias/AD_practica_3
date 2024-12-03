package practica;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clienteami")
public class Cliente 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCliente")
	private int idCliente;
	@Column(name = "nombreCliente")
	private String nombre;
	@Column(name = "apellidosCliente")
	private String apellidos;
	@Column(name = "emailCliente")
	private String email;
	@Column(name = "dniCliente")
	private String dni;
	@Column(name = "claveCliente")
	private String clave;
	
	public Cliente()
	{
		this.nombre = "";
		this.apellidos = "";
		this.email = "";
		this.dni = "";
		this.clave = "";
	}
	
	public Cliente(String nombre, String apellidos, String email, String dni, String clave)
	{
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.dni = dni;
		this.clave = clave;
	}
	
	public Cliente(int id, String nombre, String apellidos, String email, String dni, String clave)
	{
		this.idCliente = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.dni = dni;
		this.clave = clave;
	}
	
	public Cliente(int id)
	{
		this.idCliente = id;
	}

	public int getIdCliente()
	{
		return idCliente;
	}

	public void setIdCliente(int idCliente)
	{
		this.idCliente = idCliente;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public String getApellidos()
	{
		return apellidos;
	}

	public void setApellidos(String apellidos)
	{
		this.apellidos = apellidos;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getDni()
	{
		return dni;
	}

	public void setDni(String dni)
	{
		this.dni = dni;
	}

	public String getClave()
	{
		return clave;
	}

	public void setClave(String clave)
	{
		this.clave = clave;
	}
}

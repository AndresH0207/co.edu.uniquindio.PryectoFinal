package co.edu.uniquindio.proyectoFinal.model;

import java.io.Serializable;

public class Solicitud implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vendedor vendedorEnviado;
	private Vendedor vendedorResivido;
	private String nombre;
	private String apellido;

	public Solicitud(Vendedor vendedorEnviado, Vendedor vendedorResivido, String nombre, String apellido,
			boolean respuesta) {
		super();
		this.vendedorEnviado = vendedorEnviado;
		this.vendedorResivido = vendedorResivido;
		this.nombre = nombre;
		this.apellido = apellido;
		this.respuesta = respuesta;
	}

	private boolean respuesta;

	public Solicitud() {
		super();

	}

	public Vendedor getVendedorEnviado() {
		return vendedorEnviado;
	}

	public void setVendedorEnviado(Vendedor vendedorEnviado) {
		this.vendedorEnviado = vendedorEnviado;
	}

	public Vendedor getVendedorResivido() {
		return vendedorResivido;
	}

	public void setVendedorResivido(Vendedor vendedorResivido) {
		this.vendedorResivido = vendedorResivido;
	}

	public boolean isRespuesta() {
		return respuesta;
	}

	public void setRespuesta(boolean respuesta) {
		this.respuesta = respuesta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}

package co.edu.uniquindio.proyectoFinal.model;

import java.io.Serializable;

public class Comentarios {

	private Vendedor vendedorEnviado;
	private Producto productoComentado;
	private String nombre;
	private String apellido;
	private String comentario;

	public Comentarios() {

	}

	public Comentarios(Vendedor vendedorEnviado, Producto productoComentado, String nombre, String apellido,
			String comentario) {
		super();
		this.vendedorEnviado = vendedorEnviado;
		this.productoComentado = productoComentado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.comentario = comentario;
	}

	public Vendedor getVendedorEnviado() {
		return vendedorEnviado;
	}

	public void setVendedorEnviado(Vendedor vendedorEnviado) {
		this.vendedorEnviado = vendedorEnviado;
		this.nombre = vendedorEnviado.getNombre();
		this.apellido = vendedorEnviado.getApellidos();
	}

	public Producto getProductoComentado() {
		return productoComentado;
	}

	public void setProductoComentado(Producto productoComentado) {
		this.productoComentado = productoComentado;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}

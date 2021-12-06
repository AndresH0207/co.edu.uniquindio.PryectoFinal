package co.edu.uniquindio.proyectoFinal.model;


import java.io.Serializable;

public class MeGusta {

	/**
	 * 
	 */
	private Vendedor vendedorEnviado;
	private Producto productoComentado;
	private String nombre;
	private String apellido;
	private boolean meGusta;
	
	public MeGusta(Vendedor vendedorEnviado, Producto productoComentado) {
		super();
		this.vendedorEnviado = vendedorEnviado;
		this.productoComentado = productoComentado;
		this.nombre = vendedorEnviado.getNombre();
		this.apellido = vendedorEnviado.getApellidos();
		this.meGusta = true;
	}

	public MeGusta() {
		super();
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


	public boolean isMeGusta() {
		return meGusta;
	}

	public void setMeGusta(boolean meGusta) {
		this.meGusta = meGusta;
	}
	
}


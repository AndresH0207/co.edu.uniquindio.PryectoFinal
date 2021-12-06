package co.edu.uniquindio.proyectoFinal.model;

import java.util.ArrayList;


public class Producto {

	private String nombre;
	private String imagen;
	private String categoria;
	private double precio;
	private Estado estado;
	private ArrayList<MeGusta> listaMegusta = new ArrayList<>();
	private ArrayList<Comentarios> listaComentarios = new ArrayList<>();

	public Producto() {

	}

	public ArrayList<MeGusta> getListaMegusta() {
		return listaMegusta;
	}

	public void setListaMegusta(ArrayList<MeGusta> listaMegusta) {
		this.listaMegusta = listaMegusta;
	}

	public ArrayList<Comentarios> getListaComentarios() {
		return listaComentarios;
	}

	public void setListaComentarios(ArrayList<Comentarios> listaComentarios) {
		this.listaComentarios = listaComentarios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}

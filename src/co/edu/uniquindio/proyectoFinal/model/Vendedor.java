package co.edu.uniquindio.proyectoFinal.model;

import java.util.ArrayList;

public class Vendedor extends Usuario {

	private String nombre;
	private String apellidos;
	private String cedula;
	private String direccion;
	private String usuario;
	private String contrasenia;
	private ArrayList<Vendedor>listaVendedores=new ArrayList<>();
	private  ArrayList<Producto>listaProductoa=new ArrayList<>();
	private  ArrayList<Producto>Sugeridos=new ArrayList<>();
	private  ArrayList<Solicitud>ListaSolicitudes=new ArrayList<>();
	private  ArrayList<Solicitud>ListaSolicitudesEnivadas=new ArrayList<>();

	public Vendedor() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getContrasenia() {
		return contrasenia;
	}

	public void setCotrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	
	
	
}}

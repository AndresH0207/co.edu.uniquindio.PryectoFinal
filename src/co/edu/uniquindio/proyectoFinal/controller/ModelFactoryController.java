package co.edu.uniquindio.proyectoFinal.controller;

import java.util.ArrayList;

import co.edu.uniquindio.proyectoFinal.model.Estado;
import co.edu.uniquindio.proyectoFinal.model.Marketplace;
import co.edu.uniquindio.proyectoFinal.model.Producto;
import co.edu.uniquindio.proyectoFinal.model.TipoUsuario;
import co.edu.uniquindio.proyectoFinal.model.Usuario;
import co.edu.uniquindio.proyectoFinal.model.Vendedor;
import co.edu.uniquindio.proyectoFinal.persistencia.Persistencia;

public class ModelFactoryController {

	Marketplace marketplace = new Marketplace("001");
	Vendedor vendedor;
	
	Thread guardarTxt;
	Thread guardarXml;
	Thread guardarBinario;

// thread.currentThread; = captura el hilo que se esta ejecutando
	private static class SingletonHolder {
		private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
	}

	public static ModelFactoryController getInstance() {
		return SingletonHolder.eINSTANCE;
	}

	public ModelFactoryController() {
		inicializarDatos();
	}

	private void inicializarDatos() {
		
		
		try {
			//marketplace.setListaVendedores(getMarketplace());
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public Marketplace getMarketplace() {
		return marketplace;
	}

	public void setMarketplace(Marketplace marketplace) {
		this.marketplace = marketplace;
	}

	public ArrayList<Vendedor> getListaVendedores() {
		
		return this.marketplace.getListaVendedores();

	}

	public Vendedor crearVendedor(String nombre, String apellido, String cedula, String direccion, String usuario, String contrasenia) {

		Vendedor vendedor = null;

		try {
			vendedor = getMarketplace().crearVendedor(nombre, apellido, cedula, direccion, usuario, contrasenia);
			guardarRegistroLog("Vendedor Creado", 1, "Crear Vendedor");
			Persistencia.guardarContactos(getMarketplace());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

		return vendedor;
	}
	public void actualizarVendedor(String nombreActual, String apellidos, String cedula, String direccion, String usuario ,String contrasenia, String nombreNuevo) {
		marketplace.actualizarVendedor(nombreActual, apellidos, cedula, direccion, usuario, contrasenia, nombreNuevo);		
		guardarRegistroLog("Vendedor actulizado", 1, "Actualizar vendedor");
		Persistencia.guardarContactos(getMarketplace());
	}

	public void eliminarVendedor(String nombre) {
		marketplace.eliminarContacto(nombre);
		guardarRegistroLog("Vendedor eliminado", 1, "Eliminar vendedor");
		Persistencia.guardarContactos(getMarketplace());

	}

	public void guardarRegistroLog(String mensaje,int nivel,String accion) {
		Persistencia.guardarRegistroLog(mensaje,nivel,accion);
	}


	
	public Producto crearProducto(String nombre, String categoria, double precio, Estado estado) {
		
		Producto productos = null;

		try {
			
			productos = getMarketplace().crearProductos(nombre, categoria, precio, estado);
			guardarRegistroLog("Producto Creado", 1, "Crear Producto");
			Persistencia.guardarProductos(getMarketplace());
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

		return productos;
	}

	public Usuario ingresar(String usuario, String contrasenia, TipoUsuario tipoUsuario) {
		
		return  marketplace.ingresar(usuario, contrasenia, tipoUsuario);
	}

	public ArrayList<TipoUsuario> obtenerListaTiposUsuarios() {
		return marketplace.obtenerListaTiposUsuario();
	}

}

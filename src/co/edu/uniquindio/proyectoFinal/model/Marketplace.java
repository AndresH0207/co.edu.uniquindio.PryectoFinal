package co.edu.uniquindio.proyectoFinal.model;

import java.util.ArrayList;

import co.edu.uniquindio.proyectoFinal.persistencia.Persistencia;

public class Marketplace {

	String codigo;
	private ArrayList<Vendedor> listaVendedores;
	private ArrayList<Producto> listaProductos;
	private Administrador administrador;

	/**
	 * Constructor de la clase
	 * 
	 * @param codigo
	 */
	public Marketplace(String codigo) {
		this.codigo = codigo;
		listaVendedores = new ArrayList<Vendedor>();
		listaProductos = new ArrayList<Producto>();
		inicializarDatos();
	}

	/**
	 * Metodo que me permite obtener el codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Metodo que me permite asignar y/o actualizar el codigo de la clase
	 * 
	 * @param codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Metodo que me permite obtener los vendedores
	 * 
	 * @return listaVendedores
	 */
	public ArrayList<Vendedor> getListaVendedores() {
		return listaVendedores;
	}

	/**
	 * Metodo que me permite asignar y/o actualizar la lista de vendedores
	 * 
	 * @param listaVendedores
	 */
	public void setListaVendedores(ArrayList<Vendedor> listaVendedores) {
		this.listaVendedores = listaVendedores;
	}

	/**
	 * Metodo que me permite obtener los productos
	 * 
	 * @return listaProductos
	 */
	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}

	
	/**
	 * Metodo que me permite asignar y/o actualizar la lista de productos
	 * 
	 * @param listaProductos
	 */
	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	/**
	 * Método que permite inicializar los datos
	 */
	private void inicializarDatos() {
		administrador = (Administrador) Persistencia.cargarDatosXML(Persistencia.RUTA_ARCHIVO_ADMINISTRADOR_XML);
		listaVendedores.add((Vendedor)Persistencia.cargarDatosXML(Persistencia.RUTA_ARCHIVO_VENDEDOR_XML));
	}

	public Vendedor crearVendedor(String nombre, String apellido, String cedula, String direccion) {

		Vendedor vendedor = new Vendedor();
		vendedor.setNombre(nombre);
		vendedor.setApellidos(apellido);
		vendedor.setCedula(cedula);
		vendedor.setDireccion(direccion);
		getListaVendedores().add(vendedor);
		return vendedor;

	}

	public void actualizarVendedor(String nombreActual, String apellidoNuevo, String cedulaNueva, String direccionNueva,
			String nombreNuevo) {

		Vendedor vendedor = obtenerVendedor(nombreActual);

		if (vendedor != null) {
			vendedor.setNombre(nombreNuevo);
			vendedor.setApellidos(apellidoNuevo);
			vendedor.setCedula(cedulaNueva);
			vendedor.setDireccion(direccionNueva);

		}
	}

	public void eliminarContacto(String nombre) {

		Vendedor vendedor = obtenerVendedor(nombre);

		if (vendedor != null) {
			getListaVendedores().remove(vendedor);
		}
	}

	private Vendedor obtenerVendedor(String nombreActual) {
		for (Vendedor vendedor : listaVendedores) {
			if (vendedor.getNombre().equals(nombreActual)) {
				return vendedor;
			}
		}
		return null;
	}

	//

	public Vendedor validarLogin(String nombre, String cedula) {
		// TODO Auto-generated method stub
		for (Vendedor vendedor : listaVendedores) {
			if (cedula.equalsIgnoreCase(vendedor.getCedula()) && cedula.equalsIgnoreCase(vendedor.getCedula())) {
				return vendedor;
			}
		}
		return null;
	}

	public Producto crearProductos(String nombre, String categoria, double precio, Estado estado) {

		Producto productos = new Producto();

		productos.setNombre(nombre);
		productos.setCategoria(categoria);
		productos.setPrecio(precio);
		productos.setEstado(estado);

		getListaProductos().add(productos);

		return productos;
	}

	public Usuario ingresar(String Nomusuario, String contrasenia, TipoUsuario tipoUsuario) {
		Usuario usuario = null;
		Vendedor vendedor = null;

		switch (tipoUsuario) {
		case VENDEDOR:
			vendedor = listaVendedores.stream()
					.filter(x -> x.getUsuario().equals(Nomusuario) && x.getContrasena().equals(contrasenia)).findAny()
					.orElse(null);

			if (vendedor != null)
				usuario = vendedor;

			break;
		case ADMINISTRADOR:
			if (administrador.getUsuario().equals(Nomusuario) && administrador.getContrasena().equals(contrasenia))
				usuario = administrador;
			break;
		default:
			break;
		}
		return usuario;
	}

	public ArrayList<TipoUsuario> obtenerListaTiposUsuario() {
		ArrayList<TipoUsuario> lstTipoUsuarios = new ArrayList<TipoUsuario>();
		lstTipoUsuarios.add(TipoUsuario.ADMINISTRADOR);
		lstTipoUsuarios.add(TipoUsuario.VENDEDOR);
		return lstTipoUsuarios;
	}
}

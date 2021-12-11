package co.edu.uniquindio.proyectoFinal.persistencia;

import java.io.IOException;
import java.util.ArrayList;

import co.edu.uniquindio.proyectoFinal.model.Estado;
import co.edu.uniquindio.proyectoFinal.model.Marketplace;
import co.edu.uniquindio.proyectoFinal.model.Producto;
import co.edu.uniquindio.proyectoFinal.model.Vendedor;

public class Persistencia {

	public static final String RUTA_ARCHIVO_VENDEDOR = "src/co/edu/uniquindio/proyectoFinal/resources/ArchivoVendedores.txt";
	public static final String RUTA_ARCHIVO_PRODUCTOS = "src/co/edu/uniquindio/proyectoFinal/resources/ModelProductos.txt";
	public static final String RUTA_ARCHIVO_VENDEDORES = "src/co/edu/uniquindio/proyectoFinal/resources/ModelVendedores.txt";
	public static final String RUTA_ARCHIVO_LOG = "src/co/edu/uniquindio/proyectoFinal/resources/RegistroLog.txt";
	public static final String RUTA_ARCHIVO_ADMINISTRADOR_XML = "src/co/edu/uniquindio/proyectoFinal/resources/ModelAdministrador.xml";
	public static final String RUTA_ARCHIVO_VENDEDOR_XML = "src/co/edu/uniquindio/proyectoFinal/resources/ModelVendedor.xml";
	public static final String RUTA_MODEL_REDSOCIAL_XML = "src/co/edu/uniquindio/proyectoFinal/resources/ModelRed.xml";
	public static void guardarRegistroLog(String mensajeLog, int nivel, String accion) {
		ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);

	}

	public static void guardarVendedores(Marketplace marketplace) {

		String contenido = "";
		for (Vendedor vendedor : marketplace.getListaVendedores()) {
			contenido += vendedor.getNombre() + "#" + vendedor.getApellidos() + "#" + vendedor.getCedula() + "#"
					+ vendedor.getDireccion() + "#" + vendedor.getUsuario() + "#" + vendedor.getContrasena() + "\n";
		}
		try {
			ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_VENDEDORES, contenido, false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
	
	public static void cargarDatosArchivoVendedores(Marketplace marketplace) throws IOException {

		ArrayList<Vendedor> VendedoresCargados = cargarVendedores();

		if (VendedoresCargados.size() > 0) {
			marketplace.getListaVendedores().addAll(VendedoresCargados);
		}
	}

	public static ArrayList<Vendedor> cargarVendedores() throws IOException {

		ArrayList<Vendedor> listaVendedores = new ArrayList<Vendedor>();

		ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_VENDEDORES);

		String linea = "";

		for (int i = 0; i < contenido.size(); i++) {

			linea = contenido.get(i);

			Vendedor vendedor = new Vendedor();

			vendedor.setNombre	  (linea.split("#")[0]);
			vendedor.setApellidos (linea.split("#")[1]);
			vendedor.setCedula	  (linea.split("#")[2]);
			vendedor.setDireccion (linea.split("#")[3]);
			vendedor.setUsuario	  (linea.split("#")[4]);
			vendedor.setContrasena(linea.split("#")[5]);


			listaVendedores.add(vendedor);

		}
		return listaVendedores;
	}

	public static void cargarDatosArchivoProducto(Marketplace marketplace) throws IOException {

		ArrayList<Producto> productosCargados = cargarProductos();

		if (productosCargados.size() > 0) {
			marketplace.getListaProductos().addAll(productosCargados);
		}
	}

	public static ArrayList<Producto> cargarProductos() throws IOException {

		ArrayList<Producto> listaProductos = new ArrayList<Producto>();

		ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_PRODUCTOS);

		Estado e = null;
		String linea = "";

		for (int i = 0; i < contenido.size(); i++) {

			linea = contenido.get(i);

			Producto producto = new Producto();

			producto.setNombre(linea.split("#")[0]);
			producto.setCategoria(linea.split("#")[1]);
			producto.setEstado(Estado.valueOf(linea.split("#")[2]));
			producto.setPrecio(Double.parseDouble(linea.split("#")[3]));

			listaProductos.add(producto);

		}
		return listaProductos;
	}


	public static void guardarProductos(Marketplace marketplace) {

		String contenido = "";
		for (Producto producto : marketplace.getListaProductos()) {
			contenido += producto.getNombre() + "#" + producto.getCategoria() + "#" + producto.getEstado() + "#"
					+ producto.getPrecio() + "\n";
		}
		try {
			ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_PRODUCTOS, contenido, false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// SERIALIZACION y XML

	
	public static Marketplace cargarRecursoXML() {
		Object object = null;
		Marketplace marketplace = null;
		try {
			object = ArchivoUtil.cargarRecursoSerializadoXML(RUTA_MODEL_REDSOCIAL_XML);
			marketplace = (Marketplace) object;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return marketplace;
	}

	public static void guardarRecursoXML(Marketplace marketplace) {
		try {
			ArchivoUtil.salvarRecursoSerializadoXML(RUTA_MODEL_REDSOCIAL_XML, marketplace);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

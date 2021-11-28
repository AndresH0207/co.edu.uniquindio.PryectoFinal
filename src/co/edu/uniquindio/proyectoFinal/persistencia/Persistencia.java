package co.edu.uniquindio.proyectoFinal.persistencia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import co.edu.uniquindio.proyectoFinal.model.Marketplace;
import co.edu.uniquindio.proyectoFinal.model.Vendedor;

public class Persistencia {

	public static final String RUTA_ARCHIVO_VENDEDOR = "src/co/edu/uniquindio/proyectoFinal/resources/ArchivoVendedores.txt";
	public static final String RUTA_ARCHIVO_LOG = "src/co/edu/uniquindio/proyectoFinal/resources/RegistroLog.txt";
	public static final String RUTA_ARCHIVO_MODELO_ADMINISTRADOR_XML = "src/co/edu/uniquindio/proyectoFinal/resources/ModelAdministrador.xml";

	public static void cargarDatosArchivo(Marketplace marketplace) throws FileNotFoundException, IOException {
		ArrayList<Vendedor> vendedoresCargados = cargarVendedores();
		if (vendedoresCargados.size() > 0) {
			marketplace.getListaVendedores().addAll(vendedoresCargados);
		}
	}

	private static ArrayList<Vendedor> cargarVendedores() throws FileNotFoundException, IOException {
		ArrayList<Vendedor> listaVendedores = new ArrayList<Vendedor>();

		ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_VENDEDOR);

		String linea = "";

		for (int i = 0; i < contenido.size(); i++) {
			linea = contenido.get(i);
			Vendedor vendedor = new Vendedor();
			vendedor.setNombre(linea.split(",")[0]);
			vendedor.setApellidos(linea.split(",")[1]);
			vendedor.setCedula(linea.split(",")[2]);
			vendedor.setDireccion(linea.split(",")[3]);
			
			listaVendedores.add(vendedor);

		}
		return listaVendedores;
	}

	public static void guardarRegistroLog(String mensajeLog, int nivel, String accion) {
		ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);

	}

	public static void guardarContactos(Marketplace marketplace) {
		String contenido = "";
		for (Vendedor vendedor : marketplace.getListaVendedores()) {
			contenido += vendedor.getNombre() + "," + vendedor.getApellidos() + "," + vendedor.getCedula() +
			"," + vendedor.getDireccion() + "\n";
		}
		try {
			ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_VENDEDOR, contenido, false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void guardarProductos(Marketplace marketplace) {
		// TODO Auto-generated method stub
		
	}
	
	//SERIALIZACIÓN  y XML

		/**
		 * Método que permetie cargar datos desde un XML
		 * @param rutaArchivo
		 * @return
		 */
		public static Object cargarDatosXML(String rutaArchivo)
		{
			Object obj = null;

			try {
				obj = ArchivoUtil.cargarRecursoSerializadoXML(rutaArchivo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return obj;

		}

		/**
		 * Método que permite guardar los datos a un XML
		 * @param object
		 * @param rutaArchivo
		 */
		public static void guardarDatosXML(Object object, String rutaArchivo)
		{

			try
			{
				ArchivoUtil.salvarRecursoSerializadoXML(rutaArchivo, object);
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}

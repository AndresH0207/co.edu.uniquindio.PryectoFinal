package co.edu.uniquindio.proyectoFinal.persistencia;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ArchivoUtil {

	static String fechaSistema = "";

	public static void guardarArchivo(String ruta, String contenido, Boolean flagAnexarContenido) throws IOException {
		FileWriter fw = new FileWriter(ruta, flagAnexarContenido);
		BufferedWriter bfw = new BufferedWriter(fw);
		bfw.write(contenido);
		bfw.close();
		fw.close();

	}

	public static ArrayList<String> leerArchivo(String rutaArchivoContacto) throws IOException {
		ArrayList<String> contenido = new ArrayList<String>();
		FileReader fr = new FileReader(rutaArchivoContacto);
		BufferedReader bfr = new BufferedReader(fr);
		String linea = "";
		while ((linea = bfr.readLine()) != null) {
			contenido.add(linea);
		}
		bfr.close();
		fr.close();
		return contenido;
	}

	public static void guardarRegistroLog (String mensajeLog, int nivel, String accion, String rutaArchivo) {
		String log = " ";
		Logger LOGGER = Logger.getLogger(accion);
		FileHandler fileHandler = null;
		cargarFechaSistema();

		try {
			fileHandler = new FileHandler(rutaArchivo, true);
			fileHandler.setFormatter(new SimpleFormatter());
			LOGGER.addHandler(fileHandler);
			switch (nivel) {
			case 1:
				LOGGER.log(Level.INFO, accion + "," + mensajeLog + "," + fechaSistema);
				break;
			case 2:
				LOGGER.log(Level.WARNING, accion + "," + mensajeLog + "," + fechaSistema);
				break;
			case 3:
				LOGGER.log(Level.SEVERE, accion + "," + mensajeLog + "," + fechaSistema);
				break;

			default:
				break;
			}

		} catch (SecurityException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
		} finally {
			fileHandler.close();
		}
	}

	private static void cargarFechaSistema() {
		// TODO Auto-generated method stub

	}

	
	public static Object cargarRecursoSerializadoXML(String rutaArchivo) throws IOException
	{

		XMLDecoder decodificadorXML;
		Object objetoXML;

		decodificadorXML = new XMLDecoder(new FileInputStream(rutaArchivo));
		objetoXML = decodificadorXML.readObject();
		decodificadorXML.close();
		return objetoXML;

	}

	/**
	 * Métodp que permite salvar el recurso de XML
	 * @param rutaArchivo
	 * @param objeto
	 * @throws IOException
	 */
	public static void salvarRecursoSerializadoXML(String rutaArchivo, Object objeto) throws IOException
	{

		XMLEncoder codificadorXML;

		codificadorXML = new XMLEncoder(new FileOutputStream(rutaArchivo));
		codificadorXML.writeObject(objeto);
		codificadorXML.close();

	}
}

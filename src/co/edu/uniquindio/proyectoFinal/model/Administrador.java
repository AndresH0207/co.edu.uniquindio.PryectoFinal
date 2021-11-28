package co.edu.uniquindio.proyectoFinal.model;


public class Administrador extends Usuario
{
	private String nombre;
	private String documento;

	/**
	 * Constructor de la clase
	 */
	public Administrador(){}

	/**
	 * Método que permite obtener el nombre del administrador
	 * @return nombre
	 */
	public String getNombre()
	{
		return nombre;
	}

	/**
	 * Método que permite asignar y/o actualizar el nombre
	 * del administrador
	 * @param nombre
	 */
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	/**
	 * Método que permite obtener el documento del administrador
	 * @return documento
	 */
	public String getDocumento()
	{
		return documento;
	}

	/**
	 * Método que permite asignar y/o actualizar
	 * el documento del administrador
	 * @param documento
	 */
	public void setDocumento(String documento)
	{
		this.documento = documento;
	}

	

}

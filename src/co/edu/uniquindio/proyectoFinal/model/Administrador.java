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
	 * M�todo que permite obtener el nombre del administrador
	 * @return nombre
	 */
	public String getNombre()
	{
		return nombre;
	}

	/**
	 * M�todo que permite asignar y/o actualizar el nombre
	 * del administrador
	 * @param nombre
	 */
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	/**
	 * M�todo que permite obtener el documento del administrador
	 * @return documento
	 */
	public String getDocumento()
	{
		return documento;
	}

	/**
	 * M�todo que permite asignar y/o actualizar
	 * el documento del administrador
	 * @param documento
	 */
	public void setDocumento(String documento)
	{
		this.documento = documento;
	}

	

}

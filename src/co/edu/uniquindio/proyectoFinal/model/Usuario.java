package co.edu.uniquindio.proyectoFinal.model;

public class Usuario
{
	private String usuario;
	private String contrasena;
	private TipoUsuario tipoUsuario;

	/**
	 * Constructor de la clase usuario
	 */
	public Usuario()
	{

	}

	/**
	 * M�todo que permite obtener el usuario
	 * @return usuario
	 */
	public String getUsuario()
	{
		return usuario;
	}

	/**
	 * M�todo que permite asignar y/o actualizar
	 * el nombre de usuario
	 * @param usuario
	 */
	public void setUsuario(String usuario)
	{
		this.usuario = usuario;
	}

	/**
	 * M�todo que permite obtener la contrase�a del usuario
	 * @return contrasena
	 */
	public String getContrasena()
	{
		return contrasena;
	}

	/**
	 * M�todo que permite asignar y}/o actualizar la contrase�a
	 * del usuario
	 * @param contrasena
	 */
	public void setContrasena(String contrasena)
	{
		this.contrasena = contrasena;
	}

	/**
	 * M�todo que permite obtener el tipo de usuario
	 * @return tipoUsuario
	 */
	public TipoUsuario getTipoUsuario()
	{
		return tipoUsuario;
	}

	/**
	 * M�todo que permite asignar y/o actualizar
	 * el tipo de usuario
	 * @param tipoUsuario
	 */
	public void setTipoUsuario(TipoUsuario tipoUsuario)
	{
		this.tipoUsuario = tipoUsuario;
	}

	/**
	 * M�todo que permite imprimir el usuario ingresado
	 */
	@Override
	public String toString()
	{
		return "Usuario [usuario=" + usuario + ", contrasena=" + contrasena + ", tipoUsuario=" + tipoUsuario + "]";
	}
}
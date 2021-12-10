package co.edu.uniquindio.PryectoFinal.exepciones;

public class NoUsuarioException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public NoUsuarioException()
	{

	}

	public NoUsuarioException(String mensaje)
	{
		super(mensaje);
	}
}

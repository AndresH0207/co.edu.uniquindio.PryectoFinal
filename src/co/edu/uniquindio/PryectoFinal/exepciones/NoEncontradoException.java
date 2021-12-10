package co.edu.uniquindio.PryectoFinal.exepciones;

public class NoEncontradoException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public NoEncontradoException()
	{

	}

	public NoEncontradoException(String mensaje)
	{
		super(mensaje);
	}
}

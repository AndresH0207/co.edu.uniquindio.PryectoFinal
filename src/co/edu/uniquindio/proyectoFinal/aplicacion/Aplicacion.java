package co.edu.uniquindio.proyectoFinal.aplicacion;

import java.io.IOException;
import java.util.ArrayList;

import co.edu.uniquindio.proyectoFinal.controller.GestionGeneralController;
import co.edu.uniquindio.proyectoFinal.controller.GestionLoginController;
import co.edu.uniquindio.proyectoFinal.model.Marketplace;
import co.edu.uniquindio.proyectoFinal.model.TipoUsuario;
import co.edu.uniquindio.proyectoFinal.model.Usuario;
import co.edu.uniquindio.proyectoFinal.model.Vendedor;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Aplicacion  extends Application {
	
	public Stage primaryStage;
    private Marketplace marketplace =new Marketplace ("001"); //

    @Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		//mostrarVentanaLogin();
		mostrarVentanaPrincipal(TipoUsuario.ADMINISTRADOR,"MAYCOL");
	}
	
	public static void main(String[] args) {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		launch(args);
	}
	
	public void mostrarVentanaLogin()
	{
		try
		{
			FXMLLoader loader = new FXMLLoader();
			
			loader.setLocation(Aplicacion.class.getResource("/co/edu/uniquindio/proyectoFinal/views/GestionLoginView.fxml"));

			AnchorPane rootLayout = (AnchorPane) loader.load();

			GestionLoginController loginController = loader.getController();
			loginController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setResizable(false);
			primaryStage.setTitle(null);
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.show();

		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarVentanaPrincipal(TipoUsuario tipoUsuario, String nombreUsuario) {

		try {

			FXMLLoader loader = new FXMLLoader();
			
			loader.setLocation(Aplicacion.class.getResource("/co/edu/uniquindio/proyectoFinal/views/GestionGeneralView.fxml"));
			AnchorPane rootLayout = (AnchorPane)loader.load();

			GestionGeneralController gestionGeneralController = loader.getController();

			gestionGeneralController.setAplicacion(this, tipoUsuario, nombreUsuario );

			Scene scene = new Scene(rootLayout);
			scene.getStylesheets().add(Aplicacion.class.getResource("application.css").toExternalForm());
			primaryStage.setResizable(false);
			primaryStage.setTitle(null);
			primaryStage.setScene(scene);

			primaryStage.centerOnScreen();
			primaryStage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	/**
	 * Método que permite ingresar a la aplicación//////////
	 * @param usuario
	 * @param contrasena
	 * @param tipoUsuario
	 * @return ingreso
	 */
	public Usuario ingresar(String usuario, String contrasena, TipoUsuario tipoUsuario)
	{
		return marketplace.ingresar(usuario, contrasena, tipoUsuario);
	}

	/**
	 * Método que permite obtener la lista de tipos de usuario
	 * @return lstTiposUsuario
	 */
	public ArrayList<TipoUsuario> obtenerListaTiposUsuarios()
	{
		return marketplace.obtenerListaTiposUsuario();
	}

	/**
	 * Método que permite obtener la lista de estudiantes predeterminados
	 * @return lstEstudiantes
	 */
	public ArrayList<Vendedor> obtenerListaVendedorData()
	{
		return marketplace.getListaVendedores();
	}

	
	public int[] obtenerCantidadesActuales()
	{
		int[] cantidades = new int[0];
		
		return cantidades;
	}
	
}

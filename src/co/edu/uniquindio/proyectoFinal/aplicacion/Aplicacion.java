package co.edu.uniquindio.proyectoFinal.aplicacion;

import java.io.IOException;
import java.util.ArrayList;

import co.edu.uniquindio.proyectoFinal.controller.LoginController;
import co.edu.uniquindio.proyectoFinal.controller.ModelFactoryController;
import co.edu.uniquindio.proyectoFinal.controller.GestionVendedoresController;
import co.edu.uniquindio.proyectoFinal.model.TipoUsuario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Aplicacion  extends Application {
	public Stage primaryStage;
	private ModelFactoryController modelFactoryController = ModelFactoryController.getInstance();
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("PROYECTO FINAL");
		mostrarVentanaLogin();
	}
	
	public static void main(String[] args) {
		System.out.println("Ya pude");
		launch(args);
	}
	
	public void mostrarVentanaLogin()
	{
		try
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("/co/edu/uniquindio/proyectoFinal/views/LoginView.fxml"));
			AnchorPane rootLayout = (AnchorPane) loader.load();

			LoginController loginController = loader.getController();
			loginController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
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
			loader.setLocation(Aplicacion.class.getResource("/co/edu/uniquindio/proyectoFinal/views/AgregarVendedoresView.fxml"));

			AnchorPane rootLayout = loader.load();

			LoginController loginController = loader.getController();
			loginController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void mostrarVentanaAgregarProductos() {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("/co/edu/uniquindio/proyectoFinal/views/AgregarVendedoresView.fxml"));

			AnchorPane rootLayout = loader.load();

			GestionVendedoresController agregarProductoController = loader.getController();
			agregarProductoController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}

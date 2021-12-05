package co.edu.uniquindio.proyectoFinal.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.proyectoFinal.aplicacion.Aplicacion;
import co.edu.uniquindio.proyectoFinal.model.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class GestionGeneralController implements Initializable {
	Aplicacion aplicacion;

	 
 private GestionVendedoresController gestionVendedoresController;
 private GestionProductosController  gestionProductosController; 
	   


 @FXML
 private URL location;

 @FXML
 private Label nombreUsuario;

 @FXML
 private Button btnCerrarSesion;

 @FXML
 private VBox vboxmenu;

 @FXML
 private ImageView imagenUsuario;

 @FXML
 private Button btnVendedores;

 @FXML
 private Button btnProductos;

 @FXML
 private AnchorPane anchorPane;


 @FXML
 void action1(ActionEvent event) {
abrirVentana(NombreVentana.INICIO);
 }

 @FXML
 void action2(ActionEvent event) {
abrirVentana(NombreVentana.GESTION_ESTUDIANTES);
 }

	    @FXML
	    void btnCerrarSesionAction(ActionEvent event) {

	    }

	@FXML
	void CerrarSesionAction(ActionEvent event) {
		cerrarSesionAction();
	}

	private void cerrarSesionAction() {
		aplicacion.mostrarVentanaLogin();		
	}

	
	public void initialize(URL location, ResourceBundle resources)
	{

	}
	
	

   

	
	/**
	 * Método que permite mostrar la imagen asociada al tipo
	 * de usuario
	 * @param tipoUsuario
	 * @param nombreUsuario
	 */
	private void insertarImagenTipoUsuario(TipoUsuario tipoUsuario, String lnombreUsuario)
	{
		Image image = null;
		switch (tipoUsuario) {
		case ADMINISTRADOR:
			image = new Image(getClass().getResourceAsStream("../images/business.png"));
			break;
		case VENDEDOR:
			image = new Image(getClass().getResourceAsStream("../images/graduates.png"));
			break;
		
		default:
			break;
		}

		if(image != null)
		{
			imagenUsuario.setImage(image);
		}

		nombreUsuario.setText(lnombreUsuario);
	}
	
	
	///////////////////////////////////////////
	

	/**
	 * Método que permite abrir las vistas de los menus
	 */
    private void abrirVentana(NombreVentana nombreVentana)
    {
    	FXMLLoader loader = new FXMLLoader();
		AnchorPane vistaCargada = null;

		try
		{
	    	switch (nombreVentana) {
			case INICIO:
				loader.setLocation(getClass().getResource("../views/GestionVendedoresView.fxml"));
				vistaCargada = loader.load();
				anchorPane.getChildren().setAll(vistaCargada);
				this.gestionVendedoresController = loader.getController();
				this.gestionVendedoresController.setAplicacion(this.aplicacion);
				break;
			case GESTION_ESTUDIANTES:
				loader.setLocation(getClass().getResource("../view/GestionEstudiantesView.fxml"));
				vistaCargada = loader.load();
				anchorPane.getChildren().setAll(vistaCargada);
				this.gestionProductosController = loader.getController();
				this.gestionProductosController.setAplicacion(this.aplicacion);
				break;
			
			default:
				break;
	    	}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}
	
	
	
    private void habilitarDeshabilitarPermisos(TipoUsuario tipoUsuario)
	{
		switch (tipoUsuario)
		{
			case ADMINISTRADOR:
				
				
				break;
			case VENDEDOR:
			
				break;
			default:
				break;
		}
	}
    

	public void setAplicacion(Aplicacion aplicacion, TipoUsuario tipoUsuario, String nombreUsuario) {
		
		this.aplicacion = aplicacion;	
		habilitarDeshabilitarPermisos(tipoUsuario);
	insertarImagenTipoUsuario(tipoUsuario, nombreUsuario);
	}

	
	}



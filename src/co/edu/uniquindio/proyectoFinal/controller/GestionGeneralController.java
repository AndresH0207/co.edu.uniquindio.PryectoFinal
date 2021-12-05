package co.edu.uniquindio.proyectoFinal.controller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.proyectoFinal.aplicacion.Aplicacion;
import co.edu.uniquindio.proyectoFinal.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class GestionGeneralController {
	Aplicacion aplicacion;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnCerrarSesion;

	@FXML
	private ImageView imagenUsuario;

	@FXML
	private Label nombreUsuario;

	@FXML
	void CerrarSesionAction(ActionEvent event) {
		cerrarSesionAction();
	}

	private void cerrarSesionAction() {
		aplicacion.mostrarVentanaLogin();		
	}

	@FXML
	void initialize() {

	}

	public void setAplicacion(Aplicacion aplicacion, TipoUsuario tipoUsuario, String nombreUsuario) {
		
		this.aplicacion = aplicacion;	
	}

}

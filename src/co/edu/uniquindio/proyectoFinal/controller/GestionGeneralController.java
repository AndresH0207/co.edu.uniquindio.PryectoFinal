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
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GestionGeneralController {
	
	
	Aplicacion aplicacion;

	private GestionVendedoresController gestionVendedoresController;
	private GestionProductosController gestionProductosController;

	@FXML
	private AnchorPane anchorPane;

	@FXML
	private Button btnAddVendedor;

	@FXML
	private Button btnVideo;

	@FXML
	private Button btnAddProductos;

	@FXML
	private Button btnCantMsjs;

	@FXML
	private Button btnCantProductos;

	@FXML
	private Button btnCerrarSesion;

	@FXML
	private Button btnChats;

	@FXML
	private Button btnMisProductos;

	@FXML
	private Button btnProductosEnRed;

	@FXML
	private Button btnProductosporVen;



	@FXML
	private Button btnRed;

	@FXML
	private Button btnTopProductos;

	@FXML
	private ImageView imagenUsuario;

	@FXML
	private Label nombreUsuario;

	@FXML
	private VBox vboxmenu;

	@FXML
	void agregarVendedor(ActionEvent event) {
		abrirVentana(NombreVentana.GESTION_VENDEDOR);
	}

	@FXML
	void agregarProductos(ActionEvent event) {
		abrirVentana(NombreVentana.GESTION_PRODUCTOS);
	}

	@FXML
	void cantidadMensajes(ActionEvent event) {
		abrirVentana(NombreVentana.GESTION_MSJS);
	}

	@FXML
	void cantidadProductos(ActionEvent event) {
		abrirVentana(NombreVentana.CANTIDAD_PRODUCTOS);
	}

	@FXML
	void chat(ActionEvent event) {
		abrirVentana(NombreVentana.CHAT);
	}

	@FXML
	void misProductos(ActionEvent event) {
		abrirVentana(NombreVentana.MIS_PRODUCTOS);
	}

	@FXML
	void productosEnRed(ActionEvent event) {
		abrirVentana(NombreVentana.PRODUCTOS_RED);
	}

	@FXML
	void productosporVendedor(ActionEvent event) {
		abrirVentana(NombreVentana.PRODUCTOS_POR_VENDEDOR);
	}

	@FXML
	void redVendedores(ActionEvent event) {
		abrirVentana(NombreVentana.GESTION_RED);
	}

	@FXML
	void topProductos(ActionEvent event) {
		abrirVentana(NombreVentana.TOP_TEN);
	}

	@FXML
	void video(ActionEvent event) {

	}

	@FXML
	void CerrarSesionAction(ActionEvent event) {
		cerrarSesionAction();
	}

	private void cerrarSesionAction() {
		aplicacion.mostrarVentanaLogin();
	}

	public void initialize() {

	}

//	public void ocultarBotones(TipoUsuario tipoUsuario) {
//		if (tipoUsuario == TipoUsuario.ADMINISTRADOR) {
//			btnProductosEnRed.setVisible(false);
//			btnAddProductos.setVisible(false);
//			btnMisProductos.setVisible(false);
//			btnChats.setVisible(false);
//			btnVideo.setVisible(false);
//			btnRed.setVisible(true);
//			btnAddVendedor.setVisible(true);
//			btnCantMsjs.setVisible(true);
//			btnCantProductos.setVisible(true);
//			btnTopProductos.setVisible(true);
//			btnProductosporVen.setVisible(true);
//
//		} else if (tipoUsuario == TipoUsuario.VENDEDOR) {
//			btnRed.setVisible(false);
//			btnAddVendedor.setVisible(false);
//			btnCantMsjs.setVisible(false);
//			btnCantProductos.setVisible(false);
//			btnTopProductos.setVisible(false);
//			btnProductosporVen.setVisible(false);
//			btnProductosEnRed.setVisible(true);
//			btnAddProductos.setVisible(true);
//			btnMisProductos.setVisible(true);
//			btnChats.setVisible(true);
//			btnVideo.setVisible(true);
//		}
//
//	}

	/**
	 * Método que permite mostrar la imagen asociada al tipo de usuario
	 * 
	 * @param tipoUsuario
	 * @param nombreUsuario
	 */
	private void insertarImagenTipoUsuario(TipoUsuario tipoUsuario, String lnombreUsuario) {
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

		if (image != null) {
			imagenUsuario.setImage(image);
		}

		nombreUsuario.setText(lnombreUsuario);
	}

	///////////////////////////////////////////

	/**
	 * Método que permite abrir las vistas de los menus
	 */
	private void abrirVentana(NombreVentana nombreVentana) {
		FXMLLoader loader = new FXMLLoader();
		AnchorPane vistaCargada = null;

		try {
			switch (nombreVentana) {
			case GESTION_RED:
				loader.setLocation(getClass().getResource("../view/GestionEstudiantesView.fxml"));
				vistaCargada = loader.load();
				anchorPane.getChildren().setAll(vistaCargada);
				this.gestionProductosController = loader.getController();
				this.gestionProductosController.setAplicacion(this.aplicacion);
				break;
			case GESTION_VENDEDOR:
				loader.setLocation(getClass().getResource("../views/GestionVendedoresView.fxml"));
				vistaCargada = loader.load();
				anchorPane.getChildren().setAll(vistaCargada);
				this.gestionVendedoresController = loader.getController();
				this.gestionVendedoresController.setAplicacion(this.aplicacion);
				break;
			case GESTION_MSJS:
				loader.setLocation(getClass().getResource("../view/GestionEstudiantesView.fxml"));
				vistaCargada = loader.load();
				anchorPane.getChildren().setAll(vistaCargada);
				this.gestionProductosController = loader.getController();
				this.gestionProductosController.setAplicacion(this.aplicacion);
				break;
			case CANTIDAD_PRODUCTOS:
				loader.setLocation(getClass().getResource("../view/GestionEstudiantesView.fxml"));
				vistaCargada = loader.load();
				anchorPane.getChildren().setAll(vistaCargada);
				this.gestionProductosController = loader.getController();
				this.gestionProductosController.setAplicacion(this.aplicacion);
				break;
			case TOP_TEN:
				loader.setLocation(getClass().getResource("../view/GestionEstudiantesView.fxml"));
				vistaCargada = loader.load();
				anchorPane.getChildren().setAll(vistaCargada);
				this.gestionProductosController = loader.getController();
				this.gestionProductosController.setAplicacion(this.aplicacion);
				break;
			case PRODUCTOS_POR_VENDEDOR:
				loader.setLocation(getClass().getResource("../view/GestionEstudiantesView.fxml"));
				vistaCargada = loader.load();
				anchorPane.getChildren().setAll(vistaCargada);
				this.gestionProductosController = loader.getController();
				this.gestionProductosController.setAplicacion(this.aplicacion);
				break;
			case PRODUCTOS_RED:
				loader.setLocation(getClass().getResource("../view/GestionEstudiantesView.fxml"));
				vistaCargada = loader.load();
				anchorPane.getChildren().setAll(vistaCargada);
				this.gestionProductosController = loader.getController();
				this.gestionProductosController.setAplicacion(this.aplicacion);
				break;
			case GESTION_PRODUCTOS:
				loader.setLocation(getClass().getResource("../view/GestionEstudiantesView.fxml"));
				vistaCargada = loader.load();
				anchorPane.getChildren().setAll(vistaCargada);
				this.gestionProductosController = loader.getController();
				this.gestionProductosController.setAplicacion(this.aplicacion);
				break;
			case MIS_PRODUCTOS:
				loader.setLocation(getClass().getResource("../view/GestionEstudiantesView.fxml"));
				vistaCargada = loader.load();
				anchorPane.getChildren().setAll(vistaCargada);
				this.gestionProductosController = loader.getController();
				this.gestionProductosController.setAplicacion(this.aplicacion);
				break;
			case CHAT:
				loader.setLocation(getClass().getResource("../view/GestionEstudiantesView.fxml"));
				vistaCargada = loader.load();
				anchorPane.getChildren().setAll(vistaCargada);
				this.gestionProductosController = loader.getController();
				this.gestionProductosController.setAplicacion(this.aplicacion);
				break;

			default:
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void habilitarDeshabilitarPermisos(TipoUsuario tipoUsuario) {
		switch (tipoUsuario) {
		case ADMINISTRADOR:
			
			vboxmenu.getChildren().remove(btnProductosEnRed);
			vboxmenu.getChildren().remove(btnAddProductos);
			vboxmenu.getChildren().remove(btnMisProductos);
			vboxmenu.getChildren().remove(btnChats);
			vboxmenu.getChildren().remove(btnVideo);
			break;
		case VENDEDOR:

			vboxmenu.getChildren().remove(btnRed);
			vboxmenu.getChildren().remove(btnAddVendedor);
			vboxmenu.getChildren().remove(btnCantMsjs);
			vboxmenu.getChildren().remove(btnCantProductos);
			vboxmenu.getChildren().remove(btnTopProductos);
			vboxmenu.getChildren().remove(btnProductosporVen);
			break;
		default:
			break;
		}
	}

	public void setAplicacion(Aplicacion aplicacion, TipoUsuario tipoUsuario, String nombreUsuario) {

		this.aplicacion = aplicacion;
		habilitarDeshabilitarPermisos(tipoUsuario);
		insertarImagenTipoUsuario(tipoUsuario, nombreUsuario);
		//ocultarBotones(tipoUsuario);
	}

}

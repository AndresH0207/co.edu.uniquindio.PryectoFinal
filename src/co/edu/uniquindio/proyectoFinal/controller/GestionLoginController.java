package co.edu.uniquindio.proyectoFinal.controller;

import java.net.URL;
import java.util.ResourceBundle;
import co.edu.uniquindio.proyectoFinal.aplicacion.Aplicacion;
import co.edu.uniquindio.proyectoFinal.model.Administrador;
import co.edu.uniquindio.proyectoFinal.model.Marketplace;
import co.edu.uniquindio.proyectoFinal.model.TipoUsuario;
import co.edu.uniquindio.proyectoFinal.model.Usuario;
import co.edu.uniquindio.proyectoFinal.model.Vendedor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class GestionLoginController {

	private Aplicacion aplicacion;
	ModelFactoryController modelFactoryController = ModelFactoryController.getInstance();
	Marketplace marketplace = modelFactoryController.getMarketplace();
	ObservableList<TipoUsuario> lstTipoUsuariosData = FXCollections.observableArrayList();

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtUsuarioLogin;

	@FXML
	private PasswordField txtContraseniaLogin;

	@FXML
	private ComboBox<TipoUsuario> comboBoxTipoUsuario;

	@FXML
	private Button btnIngresar;

	@FXML
	void ingresarLogin(ActionEvent event) {

		ingresarLogin();
	}

	/**
	 * Método que pasa la clase principal para realizar la
	 * comunicación
	 * @param aplicacion
	 */
	public void setAplicacion(Aplicacion aplicacion)
	{
		this.aplicacion = aplicacion;

		comboBoxTipoUsuario.getItems().clear();
		comboBoxTipoUsuario.setItems(obtenerListaTipoUsuarios());
	}
	
	/**
	 * Método que permite obtener la lista de tipos de usuario
	 * @return
	 */
	private ObservableList<TipoUsuario> obtenerListaTipoUsuarios()
	{
		lstTipoUsuariosData.addAll(aplicacion.obtenerListaTiposUsuarios());
		return lstTipoUsuariosData;
	}

	private void ingresarLogin() {

		String usuario = txtUsuarioLogin.getText();
		String contrasenia = txtContraseniaLogin.getText();
		TipoUsuario tipoUsuario = comboBoxTipoUsuario.getValue();
		Usuario usuarioObtenido = null;

		usuarioObtenido = modelFactoryController.ingresar(usuario, contrasenia, tipoUsuario);
		if (usuarioObtenido != null) {
			String nombreUsuario = "";
			if (usuarioObtenido instanceof Vendedor) {
				Vendedor vendedor = (Vendedor) usuarioObtenido;
				nombreUsuario = vendedor.getNombre();
				
			} else {
				Administrador admin = (Administrador) usuarioObtenido;
				nombreUsuario = admin.getNombre();
			}

			aplicacion.mostrarVentanaPrincipal(tipoUsuario, nombreUsuario);
		} else {
			mostrarMensajeError();
		}
	}

	/**
	 * Método que permite mostrar el mensaje de error de inicio de sesión
	 */
	private void mostrarMensajeError() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Mensaje sistema");
		alert.setHeaderText("Error en inicio de sesión");
		alert.setContentText("Usuario, contraseña y/o tipo de usuario invalidos");
		alert.showAndWait();
	}

	}

package co.edu.uniquindio.proyectoFinal.controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import co.edu.uniquindio.proyectoFinal.aplicacion.Aplicacion;
import co.edu.uniquindio.proyectoFinal.model.Vendedor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class GestionVendedoresController implements javafx.fxml.Initializable{

	Aplicacion aplicacion;
	private Vendedor vendedorSelect;
	private ModelFactoryController modelFactoryController;
	ObservableList<Vendedor> listaVendedores = FXCollections.observableArrayList();

	@FXML
	private TableView<Vendedor> tableListaVendedores;

	@FXML
	private TableColumn<Vendedor, String> columCedulaVendedor;

	@FXML
	private TextField txtNombreVendedor;

	@FXML
	private TableColumn<Vendedor, String> columNombreVendedor;

	@FXML
	private Button btnActualizarVendedores;

	@FXML
	private TextField txtDireccionVendedor;
	
	@FXML
	private TextField txtContraseniaVendedor;
	
	@FXML
	private TextField txtUsuarioVendedor;

	@FXML
	private Button btnEliminarVendedores;

	@FXML
	private TextField txtCedulaVendedor;

	@FXML
	private Button btnAgregarVendedor;

	@FXML
	private TableColumn<Vendedor, String> columApellidosVendedor;

	@FXML
	private TextField txtApellidosVendedor;

	@FXML
	private TableColumn<Vendedor, String> columDireccionVendedor;
	
	

	@FXML
	void AgregarVendedor(ActionEvent event) {

		agregarVendedor();
	}

	@FXML
	void ActualizarVendedor(ActionEvent event) {

		actualizarVendedor();
	}

	@FXML
	void EliminarVendedor(ActionEvent event) {

		eliminarVendedor();
	}

	@FXML
	void fc0000(ActionEvent event) {

	}
	
	private void mostrarInfoVendedor(Vendedor vendedor) {

		if (vendedor != null){
			txtNombreVendedor.setText(vendedor.getNombre());
			txtApellidosVendedor.setText(vendedor.getApellidos());
			txtCedulaVendedor.setText(vendedor.getCedula());
			txtDireccionVendedor.setText(vendedor.getDireccion());
			txtUsuarioVendedor.setText(vendedor.getUsuario());
			txtContraseniaVendedor.setText(vendedor.getContrasenia());
		}else{
			JOptionPane.showMessageDialog(null, "Error");
		}
	}

	private void agregarVendedor() {
		
		String nombre = txtNombreVendedor.getText();
		String apellidos = txtApellidosVendedor.getText();
		String cedula = txtCedulaVendedor.getText();
		String direccion = txtDireccionVendedor.getText();
	    String usuario = txtUsuarioVendedor.getText();
		String contrasenia = txtContraseniaVendedor.getText();

		if (datosValidos(nombre, apellidos, cedula, direccion, usuario, contrasenia)) {

			Vendedor vendedorNuevo = null;
			vendedorNuevo = modelFactoryController.crearVendedor(nombre, apellidos, cedula, direccion, usuario , contrasenia);
			cargarListadoContactos();
			if (vendedorNuevo != null) {
				listaVendedores.add(vendedorNuevo);
				mostrarMensaje("Notificacion Cliente", "Cliente registrado", "El Cliente fue registrado con exito",
						AlertType.INFORMATION);
			} else {
				mostrarMensaje("Notificacion Cliente", "Cliente no registrado", "El Cliente no fue registrado",
						AlertType.INFORMATION);
			}

		}

	}

	private void actualizarVendedor() {

		String nombre = txtNombreVendedor.getText();
		String apellidos = txtApellidosVendedor.getText();
		String cedula = txtCedulaVendedor.getText();
		String direccion = txtDireccionVendedor.getText();
		String usuario = txtUsuarioVendedor.getText();
		String contrasenia = txtContraseniaVendedor.getText();
		
		if (vendedorSelect != null) {

			if (datosValidos(nombre, apellidos, cedula, direccion, usuario , contrasenia)) {
				modelFactoryController.actualizarVendedor(nombre, apellidos, cedula, direccion, usuario ,contrasenia ,vendedorSelect.getNombre());
				mostrarMensaje("Notificacion Cliente", "Producto Actualizado", "El Producto ha sido actualizado",
						AlertType.INFORMATION);
				tableListaVendedores.refresh();
			}

		} else {
			mostrarMensaje("Notificacion Cliente", "Producto no seleccionado",
					"Para eliminar un Producto debe seleccionar a uno", AlertType.WARNING);
		}
	}

	private void eliminarVendedor() {

		if (vendedorSelect != null) {

			if (mostrarMensajeConfirmacion("Esta seguro de eliminar a este Vendedor?")) {

				modelFactoryController.eliminarVendedor(vendedorSelect.getNombre());
				listaVendedores.remove(vendedorSelect);
				tableListaVendedores.getSelectionModel().clearSelection();
				vendedorSelect = null;
				mostrarMensaje("Notificacion Cliente", "Vendedor eliminado", "El Vendedor fue eliminado con exito",
						AlertType.INFORMATION);
				limpiarDatos();
			} else {
				mostrarMensaje("Notificacion Cliente", "Vendedor no eliminado", "El Vendedor  no fue eliminado",
						AlertType.INFORMATION);
			}

		} else {
			mostrarMensaje("Notificacion Cliente", "Vendedor no seleccionado",
					"Para eliminar un Vendedor debe seleccionar a uno", AlertType.WARNING);
		}
	}
	
	public void setAplicacion(Aplicacion aplicacion) {
		
		this.aplicacion = aplicacion;
		
	}

	private void cargarListadoContactos() {
		tableListaVendedores.getItems().clear();
		tableListaVendedores.setItems(obtenerVendedores());
		tableListaVendedores.refresh();
		
	}

	private ObservableList<Vendedor> obtenerVendedores() {
		listaVendedores.addAll(modelFactoryController.getListaVendedores());
		return listaVendedores;
	}
	
	private void limpiarDatos() {
		txtNombreVendedor.setText("");
		txtApellidosVendedor.setText("");		
		txtCedulaVendedor.setText("");		
		txtDireccionVendedor.setText("");	
		txtUsuarioVendedor.setText("");	
		txtContraseniaVendedor.setText("");		
		

	}

	private boolean mostrarMensajeConfirmacion(String mensaje) {
		Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
		alerta.setTitle("Confirmacion");
		alerta.setContentText(mensaje);
		Optional<ButtonType> action = alerta.showAndWait();
		if (action.get() == ButtonType.OK) {
			return true;
		}
		return false;
	}

	private void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {
		Alert alerta = new Alert(alertType);
		alerta.setTitle(titulo);
		alerta.setHeaderText(header);
		alerta.setContentText(contenido);
		alerta.showAndWait();		
	}

	private boolean datosValidos(String nombre, String apellidos, String cedula, String direccion, String usuario, String contrasenia) {
		String mensaje = "";

		if (nombre == null || nombre.equals("")) {
			mensaje += "El codigo es invalido";
		}
		if (apellidos == null || apellidos.equals("")) {
			mensaje += "El producto es invalido";
		}
		if (cedula == null || cedula.equals("")) {
			mensaje += "El producto es invalido";
		}
		if (direccion == null || direccion.equals("")) {
			mensaje += "El producto es invalido";
		}
		if (mensaje.equals("")) {
			return true;
		} else {
			mostrarMensaje("Notificacion Contactos", "Datos Invalidos", mensaje, AlertType.WARNING);
			return false;
		}		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		modelFactoryController = ModelFactoryController.getInstance();
		
		this.columNombreVendedor.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columApellidosVendedor.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
	
		this.columCedulaVendedor.setCellValueFactory(new PropertyValueFactory<>("cedula"));
		this.columDireccionVendedor.setCellValueFactory(new PropertyValueFactory<>("direccion"));
		
		
		tableListaVendedores.getSelectionModel().selectedItemProperty()
		.addListener((obs, oldSelection, newSelection) -> {

			vendedorSelect = newSelection;

			mostrarInfoVendedor(vendedorSelect);
		});
		
		cargarListadoContactos();
		
	}
	private void obtenerCantidadesActuales()
	{
		int[] cantidades = aplicacion.obtenerCantidadesActuales();
	}

		
}

package co.edu.uniquindio.proyectoFinal.controller;

import co.edu.uniquindio.proyectoFinal.model.Estado;
import co.edu.uniquindio.proyectoFinal.model.Productos;
import co.edu.uniquindio.proyectoFinal.model.Vendedor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class GestionProductosController {

	ObservableList<Productos> listaProductos = FXCollections.observableArrayList();
	ModelFactoryController modelFactoryController = ModelFactoryController.getInstance();

	@FXML
	private TextField txtNombreProducto;

	@FXML
	private TextField txtCategoriaProductos;

	@FXML
	private TextField txtPrecioProductos;

	@FXML
	private ComboBox<Estado> comboEstadoProducto;

	@FXML
	private Button btnAgregarProducto;

	@FXML
	private Button btnActualizarProducto;

	@FXML
	private Button btnEliminarProducto;

	@FXML
	private TableView<Productos> tableViewListaProductos;

	@FXML
	private TableColumn<Productos, String> columnNombreProducto;

	@FXML
	private TableColumn<Productos, String> columnCategoriaProducto;

	@FXML
	private TableColumn<Productos, String> columnPrecioProducto;

	@FXML
	private TableColumn<Productos, String> columnEstadoProducto;

	@FXML
	void ActualizarProductoAction(ActionEvent event) {

		actualizarProducto();
	}

	@FXML
	void AgregarProductoAction(ActionEvent event) {

		agregarProducto();
	}

	@FXML
	void EliminarProductoAction(ActionEvent event) {

		eliminarProducto();
	}

	private void agregarProducto() {

		String nombre;
		String categoria;
		double precio;
		Estado estado;

		nombre = txtNombreProducto.getText();
		categoria = txtCategoriaProductos.getText();
		precio = Double.parseDouble(txtPrecioProductos.getText());
		estado = (Estado) comboEstadoProducto.getValue();

		if (datosValidos(nombre, categoria, precio, estado)) {

			Productos productosNuevos = null;
			productosNuevos = modelFactoryController.crearProducto(nombre, categoria, precio, estado);
			cargarListadoProductos();

			if (productosNuevos != null) {
				listaProductos.add(productosNuevos);
				mostrarMensaje("Notificacion producto", "Producto registrado", "El Producto fue registrado con exito",
						AlertType.INFORMATION);
			} else {
				mostrarMensaje("Notificacion producto", "Producto no registrado", "El Producto no fue registrado",
						AlertType.INFORMATION);
			}

		}

	}

	private void actualizarProducto() {
		// TODO Auto-generated method stub

	}

	private void eliminarProducto() {
		// TODO Auto-generated method stub

	}

	private void cargarListadoProductos() {

		tableViewListaProductos.getItems().clear();
		tableViewListaProductos.setItems(obtenerVendedores());
		tableViewListaProductos.refresh();

	}

	private ObservableList<Productos> obtenerVendedores() {
		// TODO Auto-generated method stub
		return null;
	}

	private boolean datosValidos(String nombre, String categoria, Double precio, Estado estado) {
		String mensaje = "";

		if (nombre == null || nombre.equals("")) {
			mensaje += "El nombre es invalido";
		}
		if (categoria == null || categoria.equals("")) {
			mensaje += "La categoria es invalida es invalida";
		}
		if (precio == null || precio.equals("")) {
			mensaje += "El precio es invalido";
		}
		if (estado == null || estado.equals("")) {
			mensaje += "El estado es invalido";
		}
		if (mensaje.equals("")) {
			return true;
		} else {
			mostrarMensaje("Notificacion Productos", "Datos Invalidos", mensaje, AlertType.WARNING);
			return false;
		}
	}

	private void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {
		Alert alerta = new Alert(alertType);
		alerta.setTitle(titulo);
		alerta.setHeaderText(header);
		alerta.setContentText(contenido);
		alerta.showAndWait();
	}
}

package co.edu.uniquindio.proyectoFinal.controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import co.edu.uniquindio.PryectoFinal.exepciones.ActualizarException;
import co.edu.uniquindio.PryectoFinal.exepciones.AgregarException;
import co.edu.uniquindio.PryectoFinal.exepciones.EliminarException;
import co.edu.uniquindio.proyectoFinal.aplicacion.Aplicacion;
import co.edu.uniquindio.proyectoFinal.model.Estado;
import co.edu.uniquindio.proyectoFinal.model.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class GestionProductosController implements Initializable {

	private Aplicacion aplicacion;
	private Producto selectProducto;
	private ModelFactoryController modelFactoryController = ModelFactoryController.getInstance();
	ObservableList<Producto> listaProductos = FXCollections.observableArrayList();

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
	private TableView<Producto> tableViewListaProductos;

	@FXML
	private TableColumn<Producto, String> columnNombreProducto;

	@FXML
	private TableColumn<Producto, String> columnCategoriaProducto;

	@FXML
	private TableColumn<Producto, String> columnPrecioProducto;

	@FXML
	private TableColumn<Producto, String> columnEstadoProducto;

	@FXML
	void ActualizarProductoAction(ActionEvent event) throws ActualizarException {

		actualizarProducto();
	}

	@FXML
	void AgregarProductoAction(ActionEvent event) throws AgregarException {

		agregarProducto();
	}

	@FXML
	void EliminarProductoAction(ActionEvent event) throws EliminarException {

		eliminarProducto();
	}

	private void agregarProducto() throws AgregarException {

		System.out.println(listaProductos + "isis");

		String nombre;
		String categoria;
		double precio;
		Estado estado;

		nombre = txtNombreProducto.getText();
		categoria = txtCategoriaProductos.getText();
		precio = Double.parseDouble(txtPrecioProductos.getText());
		estado = (Estado) comboEstadoProducto.getValue();

		if (datosValidos(nombre, categoria, precio, estado)) {

			Producto productosNuevos = null;
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

	private void actualizarProducto() throws ActualizarException {

		String nombre = txtNombreProducto.getText();
		String categoria = txtCategoriaProductos.getText();
		Double precio = Double.parseDouble(txtPrecioProductos.getText());
		Estado estado = comboEstadoProducto.getValue();

		if (datosValidos(nombre, categoria, precio, estado)) {

			if (selectProducto != null) {

				modelFactoryController.actualizarProducto(nombre, categoria, precio, estado,
						selectProducto.getNombre());

				mostrarMensaje("Notificacion Cliente", "Cliente Actualizado", "El cliente ha sido actualizado",
						AlertType.INFORMATION);
				cargarListadoProductos();
				limpiarDatos();
			}
		}
	}

	private void limpiarDatos() {

		txtNombreProducto.setText("");
		txtCategoriaProductos.setText("");
		txtPrecioProductos.setText("");
		comboEstadoProducto.setValue(null);
	}

	private void eliminarProducto() throws EliminarException {

		if (selectProducto != null) {

			if (mostrarMensajeConfirmacion("Esta seguro quiere eliminar este Producto?")) {
				modelFactoryController.eliminarProducto(selectProducto.getNombre());
				cargarListadoProductos();

				mostrarMensaje("Notificacion producto", "producto eliminado", "El producto fue eliminado con exito",
						AlertType.INFORMATION);
				limpiarDatos();

			} else {
				mostrarMensaje("Notificacion producto", "producto no eliminado", "El producto  no fue eliminado",
						AlertType.INFORMATION);

			}

		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		ObservableList<Estado> listaEstado = FXCollections.observableArrayList(Estado.values());
		comboEstadoProducto.setItems(listaEstado);

		modelFactoryController = ModelFactoryController.getInstance();

		this.columnNombreProducto.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columnCategoriaProducto.setCellValueFactory(new PropertyValueFactory<>("categoria"));
		this.columnPrecioProducto.setCellValueFactory(new PropertyValueFactory<>("precio"));
		this.columnEstadoProducto.setCellValueFactory(new PropertyValueFactory<>("estado"));

		tableViewListaProductos.getSelectionModel().selectedItemProperty()
				.addListener((obs, oldSelection, newSelection) -> {

					selectProducto = newSelection;

					mostrarInfoProductos(selectProducto);
				});
	}

	private void mostrarInfoProductos(Producto producto) {

		if (producto != null) {

			txtNombreProducto.setText		(producto.getNombre());
			txtCategoriaProductos.setText	(producto.getCategoria());
			txtPrecioProductos.setText		(String.valueOf(producto.getPrecio()));
			comboEstadoProducto.setValue	(producto.getEstado());

		} else {
			JOptionPane.showMessageDialog(null, "Error");
		}

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

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
		cargarListadoProductos();
	}

	private void cargarListadoProductos() {

		tableViewListaProductos.getItems().clear();
		tableViewListaProductos.setItems(obtenerProductos());
//		tableViewListaProductos.refresh();

	}

	private ObservableList<Producto> obtenerProductos() {
		listaProductos.addAll(aplicacion.obtenerProductos());
		return listaProductos;
	}
}

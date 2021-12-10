package co.edu.uniquindio.proyectoFinal.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import co.edu.uniquindio.proyectoFinal.aplicacion.Aplicacion;
import co.edu.uniquindio.proyectoFinal.model.Producto;
import co.edu.uniquindio.proyectoFinal.model.Vendedor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class RedVendedoresController {

	private Vendedor vendedorSelect;
	private Aplicacion aplicacion;
	private ModelFactoryController modelFactoryController;
	ObservableList<Vendedor> listaVendedores = FXCollections.observableArrayList();

	@FXML
	private TableView<Vendedor> TableViewRed;

	@FXML
	private TableColumn<Vendedor, String> columnNombre;

	@FXML
	private TableColumn<Vendedor, String> columnApellido;

	@FXML
	private TableColumn<Vendedor, String> columnCedula;

	@FXML
	private TableColumn<Vendedor, String> ColumnDireccion;

	@FXML
	private TableColumn<Producto, String> ColumnProducto;

	@FXML
	void initialize() {

		modelFactoryController = ModelFactoryController.getInstance();

		this.columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columnApellido.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
		this.columnCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
		this.ColumnDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));

		TableViewRed.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

			vendedorSelect = newSelection;

			mostrarInfoVendedor(vendedorSelect);

		});
	}

	private void mostrarInfoVendedor(Vendedor vendedor) {
		
		if (vendedor != null) {
			
			vendedor.getNombre();
			vendedor.getApellidos();
			vendedor.getCedula();
			vendedor.getDireccion();
		} else {
			JOptionPane.showMessageDialog(null, "Error");
		}
	}

	private void cargarListadoContactos() {
		TableViewRed.getItems().clear();
		TableViewRed.setItems(obtenerVendedores());
		TableViewRed.refresh();

	}

	private ObservableList<Vendedor> obtenerVendedores() {
		listaVendedores.addAll(modelFactoryController.getListaVendedores());
		return listaVendedores;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
		cargarListadoContactos();
	}
}

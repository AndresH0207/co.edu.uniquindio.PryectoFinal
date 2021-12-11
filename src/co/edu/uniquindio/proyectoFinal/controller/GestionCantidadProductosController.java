package co.edu.uniquindio.proyectoFinal.controller;

import co.edu.uniquindio.proyectoFinal.aplicacion.Aplicacion;
import co.edu.uniquindio.proyectoFinal.model.Marketplace;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class GestionCantidadProductosController {
	ModelFactoryController modelFactoryController = ModelFactoryController.getInstance();

	private Aplicacion aplicacion;

	@FXML
	private Label lblCantidadProductos;

	@FXML
	private TableView<?> tableViewCantProductos;

	@FXML
	private TableColumn<?, ?> columnNombre;

	@FXML
	private TableColumn<?, ?> columnCategoria;

	@FXML
	private Button btnAcctualizar;

	@FXML
	void actualizarAction(ActionEvent event) {
		cantidadProductos();
	}

	
	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
		cantidadProductos();
	}

	private void cantidadProductos() {

		int cantidadProductos = modelFactoryController.obtenerCantidades();

		lblCantidadProductos.setText(cantidadProductos + "isisooo ");

	}
}

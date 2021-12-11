package co.edu.uniquindio.proyectoFinal.controller;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import co.edu.uniquindio.PryectoFinal.exepciones.NoEncontradoException;
import co.edu.uniquindio.proyectoFinal.aplicacion.Aplicacion;
import co.edu.uniquindio.proyectoFinal.model.Marketplace;
import co.edu.uniquindio.proyectoFinal.model.Producto;
import co.edu.uniquindio.proyectoFinal.persistencia.Persistencia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GestionBuscarProductosController {

	private Persistencia p = new Persistencia();
	private Aplicacion aplicacion;
//	ObservableList<Producto> listaProductos = FXCollections.observableArrayList();
	Marketplace Mk = new Marketplace();
//	ObservableList<Producto> listaProductos = FXCollections.observableArrayList();

	ArrayList<Producto> listaProductos = new ArrayList<>();

	@FXML
	private TextArea textAreaBuscar;

	@FXML
	private TextField txtBuscarProductos;

	@FXML
	private Button btnBuscar;

	@FXML
	private Button btnActualizarText;

	@FXML
	void actualizarAction(ActionEvent event) {

		textAreaBuscar.setText("");
	}

	@FXML
	void buscarAction(ActionEvent event) throws NoEncontradoException, IOException {

		listaProductos = p.cargarProductos();

		String nombre = txtBuscarProductos.getText();

		for (int i = 0; i < listaProductos.size(); i++) {

			if (listaProductos.get(i).getNombre().contains(nombre)) {

				textAreaBuscar.setText("Nombre del producto:" + listaProductos.get(i).getNombre() + " Estado:"
						+ listaProductos.get(i).getEstado());
			}
		}
	}
	
	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

}

package co.edu.uniquindio.proyectoFinal.controller;

import java.io.IOException;
import java.util.ArrayList;

import co.edu.uniquindio.proyectoFinal.aplicacion.Aplicacion;
import co.edu.uniquindio.proyectoFinal.model.Estado;
import co.edu.uniquindio.proyectoFinal.model.Producto;
import co.edu.uniquindio.proyectoFinal.persistencia.Persistencia;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class GestionBuscarProductosRedController {

	private Aplicacion aplicacion;
	private Persistencia p = new Persistencia();
	ArrayList<Producto> listaProductos = new ArrayList<>();

	@FXML
	private Button btnProductosVendidos;

	@FXML
	private TextArea textAreaEncontrarRed;

	@FXML
	private Button btnActualizarText;

	@FXML
	private Button btnProductosPublicados;

	@FXML
	private Button btnProductosCancelados;

	@FXML
	void actualizarTextAction(ActionEvent event) {

		textAreaEncontrarRed.setText("");
	}

	@FXML
	void canceladoAction(ActionEvent event) throws IOException {

		productosCancelados();
	}

	@FXML
	void publicadosAction(ActionEvent event) throws IOException {

		productosPublicados();
	}

	@FXML
	void vendidosAction(ActionEvent event) throws IOException {

		productosVendidos();
	}

	private void productosVendidos() throws IOException {

		listaProductos = p.cargarProductos();
		Estado estado = null;
		estado = estado.Vendido;

		for (int i = 0; i < listaProductos.size(); i++) {

			textAreaEncontrarRed.setText(
					"Nombre: " + listaProductos.get(i).getNombre() + " Estado: " + listaProductos.get(i).getEstado());
		}

	}

	private void productosPublicados() throws IOException {

		listaProductos = p.cargarProductos();
		Estado estado = null;
		estado = estado.Publicado;

		for (int i = 0; i < listaProductos.size(); i++) {

			textAreaEncontrarRed.setText(
					"Nombre: " + listaProductos.get(i).getNombre() + " Estado: " + listaProductos.get(i).getEstado());
		}
	}

	private void productosCancelados() throws IOException {

		listaProductos = p.cargarProductos();
		Estado estado = null;
		estado = estado.Cancelado;

		for (int i = 0; i < listaProductos.size(); i++) {

			textAreaEncontrarRed.setText(
					"Nombre: " + listaProductos.get(i).getNombre() + " Estado: " + listaProductos.get(i).getEstado());
		}
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}
}

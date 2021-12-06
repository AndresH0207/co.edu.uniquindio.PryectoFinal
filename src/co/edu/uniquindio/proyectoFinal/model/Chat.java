package co.edu.uniquindio.proyectoFinal.model;

import java.util.ArrayList;

public class Chat {
	private Vendedor vendedor1;
	private Vendedor vendedor2;
	ArrayList<String> chatPersonal;

	public Chat() {

	}

	public Chat(Vendedor vendedor1, Vendedor vendedor2, ArrayList<String> chatPersonal) {
		super();
		this.vendedor1 = vendedor1;
		this.vendedor2 = vendedor2;
		this.chatPersonal = chatPersonal;
	}

	public Vendedor getVendedor1() {
		return vendedor1;
	}

	public void setVendedor1(Vendedor vendedor1) {
		this.vendedor1 = vendedor1;
	}

	public Vendedor getVendedor2() {
		return vendedor2;
	}

	public void setVendedor2(Vendedor vendedor2) {
		this.vendedor2 = vendedor2;
	}

	public ArrayList<String> getChatPersonal() {
		return chatPersonal;
	}

	public void setChatPersonal(ArrayList<String> chatPersonal) {
		this.chatPersonal = chatPersonal;
	}
}

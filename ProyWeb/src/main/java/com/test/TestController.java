package com.test;

import java.util.LinkedList;

import com.ies.baroja.Controller;
import com.model.Jugadores;

public class TestController {

	public static void main(String[] args) {
		System.out.println("Inicio de TestController");
		LinkedList<Jugadores> listaJugadores = Controller.getJugadores();
		System.out.println("Total de jugadores="+listaJugadores.size());
		System.out.println("Total de jugadores="+listaJugadores.toString());
	}

}

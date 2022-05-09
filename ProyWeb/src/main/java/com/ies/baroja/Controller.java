package com.ies.baroja;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import com.model.Jugadores;
import com.mysql.jdbc.PreparedStatement;
import com.bbdd.ConexionBBDD;

public class Controller {
	private static String sConsultaJugadores = "SELECT Nombre, Procedencia,Altura,Peso,Posicion,Nombre_equipo FROM jugadores;";

	/**
	 * Devolver lista de jugadores
	 * 
	 * @return
	 */
	public static LinkedList<Jugadores> getJugadores() {
		// Objeto con la lista de jugadores
		LinkedList<Jugadores> listaJugadores = new LinkedList<Jugadores>();
		// Primero conectamos a la BBDD
		ConexionBBDD miConexion = new ConexionBBDD();
		try {
			miConexion.conectar();
			// Lanzamos la consulta
			ResultSet rsResultado = miConexion.ejecutarConsulta(sConsultaJugadores);
			if (rsResultado != null) {
				// Si hay resultado recuperamos los datos (como un FETCH de un CURSOR)
				while (rsResultado.next()) {
					// Creamos un objeto jugador por cada fila de la tabla (cada jugador)
					Jugadores jugador = new Jugadores(rsResultado.getString("Nombre"),
							rsResultado.getString("Procedencia"), rsResultado.getString("Altura"),
							String.valueOf(rsResultado.getInt("Peso")), rsResultado.getString("Posicion"),
							rsResultado.getString("Nombre_equipo"));
					// Lo insertamos en la lista
					listaJugadores.add(jugador);

				}

			} else {
				System.out.println("La consulta no devuelve resultados");
			}
			System.out.println("N�mero de jugadores=" + listaJugadores.size());
		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
			sqlex.printStackTrace();
		} finally {
			miConexion.desconectar();
		}
		return listaJugadores;
	}

	public static boolean insertarJugador(Jugadores jugador) {
		boolean bRes = true;
		// Primero conectamos a la BBDD
		ConexionBBDD miConexion = new ConexionBBDD();
		try {
			miConexion.conectar();
			int iRes = miConexion.insertar(jugador);
			System.out.println("Resultado controlador = " + iRes);
		} catch (SQLException sqlex) {
			bRes = false;
		} finally {
			miConexion.desconectar();
		}
		return bRes;
	}

	public static LinkedList<Jugadores> getJugador() {
		// Objeto con la lista de jugadores
		LinkedList<Jugadores> listaJugadores = new LinkedList<Jugadores>();
		// Primero conectamos a la BBDD
		ConexionBBDD miConexion = new ConexionBBDD();
		try {
			miConexion.conectar();
			// Lanzamos la consulta
			ResultSet rsResultado = miConexion.ejecutarConsulta(sConsultaJugadores);
			if (rsResultado != null) {
				// Si hay resultado recuperamos los datos (como un FETCH de un CURSOR)
				while (rsResultado.next()) {
					// Creamos un objeto jugador por cada fila de la tabla (cada jugador)
					Jugadores jugador = new Jugadores(rsResultado.getString("Nombre"),
							rsResultado.getString("Procedencia"), rsResultado.getString("Altura"),
							String.valueOf(rsResultado.getInt("Peso")), rsResultado.getString("Posicion"),
							rsResultado.getString("Nombre_equipo"));
					// Lo insertamos en la lista
					listaJugadores.add(jugador);

				}

			} else {
				System.out.println("La consulta no devuelve resultados");
			}
			System.out.println("N�mero de jugadores=" + listaJugadores.size());
		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
			sqlex.printStackTrace();
		} finally {
			miConexion.desconectar();
		}
		return listaJugadores;
	}

	
	
	
	public static Jugadores getJugador(String nombre) {
		// Objeto con la lista de jugadores
		Jugadores jugador = null;
		/** 1-conecar a la BBDD */
		ConexionBBDD miConexion = new ConexionBBDD();
		String sConsultaBuscaJugador = "SELECT Nombre, Procedencia, Altura,Peso,Posicion,Nombre_equipo FROM jugadores WHERE nombre = '"
				+ nombre + "';";
		try {
			miConexion.conectar();
			/** 2-lanzar consulta */
			ResultSet rsResultado = miConexion.ejecutarConsulta(sConsultaBuscaJugador);
			if (rsResultado != null) {
				// Si hay resultado recuperamos los datos (como un FETCH de un CURSOR)
				/** 3-recuperar los datos */
				while (rsResultado.next()) {
					// Creamos un objeto jugador por cada fila de la tabla (cada jugador)
					jugador = new Jugadores(rsResultado.getString("Nombre"), rsResultado.getString("Procedencia"),
							rsResultado.getString("Altura"), String.valueOf(rsResultado.getInt("Peso")),
							rsResultado.getString("Posicion"), rsResultado.getString("Nombre_equipo"));
				}
			} else {
				System.out.println("La consulta no devuelve resultados");
			}
		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
			sqlex.printStackTrace();
		/** 4-cerrar conexi�n */
		} finally {
			miConexion.desconectar();
		}
		return jugador;
	}
	

}
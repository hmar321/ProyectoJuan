package com.model;

public class Jugadores {

	private String nombre;
	private String procedencia;
	private String altura;
	private String peso;
	private String posicion;
	private String nombre_equipo;
	/**
	 * Constructor de la clase Jugador
	 * @param nombre
	 * @param procedencia
	 * @param altura
	 * @param peso
	 * @param posicion
	 * @param nombre_equipo
	 * @author Héctor
	 * @since April 2022
	 */
	public Jugadores(String nombre, String procedencia, String altura, String peso, String posicion,
			String nombre_equipo) {
		super();
		this.nombre = nombre;
		this.procedencia = procedencia;
		this.altura = altura;
		this.peso = peso;
		this.posicion = posicion;
		this.nombre_equipo = nombre_equipo;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the procedencia
	 */
	public String getProcedencia() {
		return procedencia;
	}
	/**
	 * @param procedencia the procedencia to set
	 */
	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}
	/**
	 * @return the altura
	 */
	public String getAltura() {
		return altura;
	}
	/**
	 * @param altura the altura to set
	 */
	public void setAltura(String altura) {
		this.altura = altura;
	}
	/**
	 * @return the peso
	 */
	public String getPeso() {
		return peso;
	}
	/**
	 * @param peso the peso to set
	 */
	public void setPeso(String peso) {
		this.peso = peso;
	}
	/**
	 * @return the posicion
	 */
	public String getPosicion() {
		return posicion;
	}
	/**
	 * @param posicion the posicion to set
	 */
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	/**
	 * @return the nombre_equipo
	 */
	public String getNombre_equipo() {
		return nombre_equipo;
	}
	/**
	 * @param nombre_equipo the nombre_equipo to set
	 */
	public void setNombre_equipo(String nombre_equipo) {
		this.nombre_equipo = nombre_equipo;
	}

	public String toString() {
		StringBuffer sbResultado = new StringBuffer();
		sbResultado.append(nombre);
		sbResultado.append(" ");
		sbResultado.append(procedencia);
		sbResultado.append(" ");
		sbResultado.append(altura);
		sbResultado.append(" ");
		sbResultado.append(peso);
		sbResultado.append(" ");
		sbResultado.append(posicion);
		sbResultado.append(" ");
		sbResultado.append(nombre_equipo);
		sbResultado.append("; \n");
		return sbResultado.toString();
	}
}

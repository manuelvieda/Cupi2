/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_estudiante
 * Autor: Equipo Cupi2 2016
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.estudiante.mundo;

/**
 * Clase que modela una actividad extracurricular.
 */
public class Actividad {

	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Constante que representa el tipo trabajo social.
	 */
	public final static int TRABAJO_SOCIAL = 1;

	/**
	 * Constante que representa el tipo deportivo.
	 */
	public static final int DEPORTIVO = 2;

	/**
	 * constante que representa el tipo académico.
	 */
	public static final int ACADEMICO = 3;

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Nombre de la actividad extracurricular.
	 */
	private String nombre;

	/**
	 * Tipo de la actividad estracurricular.
	 */
	private int tipo;

	/**
	 * Tiempo en horas dedicadas a la actividad extracurricular.
	 */
	private int horasDedicadas;

	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------

	/**
	 * Construye una nueva actividad extracurricular.
	 * @param pNombre Nombre de la actividad. nombre !="" && nombre != null.
	 * @param pTipo Tipo de actividad. pTipo == TRABAJO_SOCIAL || pTipo == DEPORTIVO || pTipo == ACADEMICO
	 * @param pHorasDedicadas Tiempo en horas dedicadas a la actividad. pHorasDedicadas > 0.
	 */
	public Actividad(String pNombre, int pTipo, int pHorasDedicadas) {
		nombre = pNombre;
		tipo = pTipo;
		horasDedicadas = pHorasDedicadas;
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Devuelve el nombre de la actividad extracurricular.
	 * @return Nombre de la actividad extracurricular.
	 */
	public String darNombre() {

		return nombre;
	}

	/**
	 * Devuelve el tipo de la actividad extracurricular.
	 * @return Tipo de la actividad extracurricular.
	 */
	public int darTipo() {

		return tipo;
	}

	/**
	 * Devuelve el tiempo en horas dedicadas a la actividad extracurricular.
	 * @return Tiempo en horas dedicadas a la actividad extracurricular.
	 */
	public int darHorasDedicadas() {

		return horasDedicadas;
	}

}
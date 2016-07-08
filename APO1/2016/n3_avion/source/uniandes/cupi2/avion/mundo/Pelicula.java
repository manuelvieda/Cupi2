/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: n3_avion
 * Autor: Manuel E. Vieda
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.avion.mundo;

/**
 *
 * @author Manuel E Vieda
 * @version 1.0
 * @since 1.0
 */
public class Pelicula {
	public static final String ACCION = "Accion";

	public static final String COMEDIA = "Comedia";

	public static final String DRAMA = "Drama";

	public static final String INFANTIL = "Infantil";

	public static final String ROMANCE = "Romance";

	private String nombre;
	private String genero;
	private int duracion;
	private String director;

	public Pelicula(String nombre, String genero, int duracion, String director){
		this.nombre = nombre;
		this.genero = genero;
		this.duracion = duracion;
		this.director = director;
	}

	public String darNombre() {

		return nombre;
	}

	public void setNombre(String nombre) {

		this.nombre = nombre;
	}

	public String darGenero() {

		return genero;
	}

	public void setGenero(String genero) {

		this.genero = genero;
	}

	public int darDuracion() {

		return duracion;
	}

	public void setDuracion(int duracion) {

		this.duracion = duracion;
	}

	public String darDirector() {

		return director;
	}

	public void setDirector(String director) {

		this.director = director;
	}
}

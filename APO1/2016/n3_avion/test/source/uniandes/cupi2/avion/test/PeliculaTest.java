/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: n3_avion
 * Autor: Equipo Cupi2 2016
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.avion.test;

import uniandes.cupi2.avion.mundo.Pelicula;
import junit.framework.TestCase;

public class PeliculaTest extends TestCase
{
	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Pelicula 1
     */
    private Pelicula pelicula;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Crea una película con los siguientes valores.
     *  Nombre : Pompeii
     *  Género: Acción
     *  Duración: 105 minutos
     *  Director: Paul Anderson
     */
    private void setupEscenario1()
    {
    	pelicula = new Pelicula("Pompeii", Pelicula.ACCION, 105, "Paul Anderson");
    }

    
    /**
     * Prueba 1: verifica que la pelicula se cree con los valores dados.
     */
    public void testCrearPelicula()
    {
    	setupEscenario1();
    	assertEquals("El nombre debería ser Pompeii.", "Pompeii", pelicula.darNombre());
    	assertEquals("El género debería ser Acción.", Pelicula.ACCION, pelicula.darGenero());
    	assertEquals("La duración debería ser 105.", 105, pelicula.darDuracion());
    	assertEquals("El director debería ser Paul Anderson.", "Paul Anderson", pelicula.darDirector());
    	assertNotNull("El to string no debería dar nulo", pelicula.toString());
    }
    

}

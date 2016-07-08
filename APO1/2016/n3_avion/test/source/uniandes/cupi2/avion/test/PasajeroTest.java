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

import java.util.ArrayList;

import uniandes.cupi2.avion.mundo.Pasajero;
import uniandes.cupi2.avion.mundo.Pelicula;
import junit.framework.TestCase;

/**
 * Esta es la clase usada para verificar que los métodos de la clase Pasajero estén correctamente implementados.
 */
public class PasajeroTest extends TestCase
{
	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Pasajero 1
     */
    private Pasajero pasajero;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    
    /**
     * Escenario 1: Crea un pasajero sin películas.
     */
    private void setupEscenario1()
    {
    	pasajero = new Pasajero(123456, "Radamel Falcao");
    }
    
    /**
     * Escenario 2: Crea un pasajero con películas.
     */
    private void setupEscenario2()
    {
    	pasajero = new Pasajero(123456, "Radamel Falcao");
    	pasajero.agregarPelicula("p1", Pelicula.ACCION, 111, "d1");
    	pasajero.agregarPelicula("p2", Pelicula.COMEDIA, 222, "d2");
    	pasajero.agregarPelicula("p3", Pelicula.DRAMA, 333, "d3");
    	pasajero.agregarPelicula("p4", Pelicula.ROMANCE, 444, "d4");
    	pasajero.agregarPelicula("p5", Pelicula.ACCION, 555, "d5");
    	pasajero.agregarPelicula("p6", Pelicula.COMEDIA, 111, "d6");
    }
    
    /**
     * Escenario 3: Crea un pasajero con películas.
     */
    private void setupEscenario3()
    {
    	pasajero = new Pasajero(123456, "Radamel Falcao");
    	pasajero.agregarPelicula("p1", Pelicula.ACCION, 111, "d1");
    	pasajero.agregarPelicula("p2", Pelicula.COMEDIA, 222, "d2");
    	pasajero.agregarPelicula("p3", Pelicula.DRAMA, 333, "d3");
    	pasajero.agregarPelicula("p4", Pelicula.ROMANCE, 444, "d4");
    	pasajero.agregarPelicula("p5", Pelicula.ACCION, 555, "d5");
    }
    
    /**
     * Prueba 1: Verifica que el pasajero sea creado correctamente, creando la lista de películas vacía.
     */
    public void testCrearPasajero()
    {
    	setupEscenario1();
    	assertEquals("El nombre debería ser Radamel Falcao.", "Radamel Falcao", pasajero.darNombre());
    	assertEquals("La cédula debería ser 123456.", 123456 , pasajero.darCedula());
    	assertNotNull("No debería ser nulo.", pasajero.darPeliculas());
    	assertEquals("La lista no debería tener nada.", 0, pasajero.darPeliculas().size());
    }
    
    /**
     * Prueba 2: Verifica que el pasajero  aumenta en 1 al agregar una película.
     */
    public void testAgregarPelicula()
    {
    	setupEscenario1();
    	assertEquals("La lista no debería tener nada.", 0, pasajero.darPeliculas().size());
    	pasajero.agregarPelicula("p1", Pelicula.ACCION, 111, "d1");
    	assertEquals("La lista debería ser tamaño 1.", 1, pasajero.darPeliculas().size());
    }
    
    /**
     * Prueba 3: Verifica que el método darDuracionTotalPeliculas está correctamente implementado.
     */
    public void testDarDuracionTotalPeliculas()
    {
    	setupEscenario1();
    	assertEquals("La duración debería ser 0 minutos.", 0, pasajero.darDuracionTotalPeliculas());
    	
    	setupEscenario2();
    	assertEquals("La duración debería ser 1776 minutos.", 1776, pasajero.darDuracionTotalPeliculas());
    }
    
    /**
     * Prueba 4: Verifica que el método darPeliculasGenero está correctamente implementado.
     */
    public void testDarPeliculasGenero()
    {
    	setupEscenario2();
    	ArrayList lista = pasajero.darPeliculasGenero(Pelicula.ACCION);
    	ArrayList lista2 = pasajero.darPeliculasGenero(Pelicula.COMEDIA);
    	ArrayList lista3 = pasajero.darPeliculasGenero(Pelicula.DRAMA);
    	ArrayList lista4 = pasajero.darPeliculasGenero(Pelicula.INFANTIL);
    	ArrayList lista5 = pasajero.darPeliculasGenero(Pelicula.ROMANCE);
    	
    	assertEquals("El tamaño de la lista debería ser 2.", 2, lista.size());
    	assertEquals("El tamaño de la lista debería ser 2.", 2, lista2.size());
    	assertEquals("El tamaño de la lista debería ser 1.", 1, lista3.size());
    	assertEquals("El tamaño de la lista debería ser 0.", 0, lista4.size());
    	assertEquals("El tamaño de la lista debería ser 1.", 1, lista5.size());
    }
    
    /**
     * Prueba 5: Verifica que el método tienePeliculasMismaDuracion esté correctamente implementado.
     */
    public void testTienePeliculasMismaDuracion()
    {
    	setupEscenario2();
    	assertTrue("Debería ser verdadero.", pasajero.tienePeliculasMismaDuracion());
    	
    	setupEscenario3();
    	assertFalse("Debería ser falso.", pasajero.tienePeliculasMismaDuracion());
    }
    
    
}

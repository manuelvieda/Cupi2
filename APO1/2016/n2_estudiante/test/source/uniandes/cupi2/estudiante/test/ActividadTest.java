/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * Universidad de los Andes (Bogotá - Colombia) 
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 2.1
 * 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_estudiante
 * Autor: Equipo Cupi2 2016
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.estudiante.test;


import uniandes.cupi2.estudiante.mundo.Actividad;
import junit.framework.TestCase;
/**
 * Clase que modela las pruebas para el Actividad extracurricular
 */
public class ActividadTest extends TestCase
{
	// -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Clase que modela una actividad
     */
    private Actividad actividad;
    
    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    
    /**
     * Escenario 1: Genera un escenario de prueba
     */
    public void setupEscenario1( )
    {
    	actividad = new Actividad("Actividad1", Actividad.DEPORTIVO, 123);
    }
    
    /**
     * Prueba 1: Verifica que el constructor de Actividad esté correctamente implementado.
     */
    public void testCrearActividad()
    {
    	setupEscenario1();
    	assertEquals("El nombre no corresponde.", "Actividad1", actividad.darNombre() );
    	assertEquals("El tipo no corresponde.", Actividad.DEPORTIVO, actividad.darTipo() );
    	assertEquals("Las horas dedicadas no corresponden.", 123, actividad.darHorasDedicadas() );
    }
    
    
}

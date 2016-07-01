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
import uniandes.cupi2.estudiante.mundo.Curso;
import uniandes.cupi2.estudiante.mundo.Estudiante;
import junit.framework.TestCase;

/**
 * Clase que modela las pruebas para el Estudiante
 */
public class EstudianteTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Clase que modela un estudiante
     */
    private Estudiante estudiante;

    /**
     * Clase que modela un curso
     */
    private Curso curso1;

    /**
     * Clase que modela un curso
     */
    private Curso curso2;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Método para la generación de un escenario de prueba
     */
    public void setupEscenario0( )
    {
        estudiante = new Estudiante( "nombre1", "apellido1", 1 );
        curso1 = new Curso( "codigo1", "nombre1", 1 );
    }

    /**
     * Método para la generación de un escenario de prueba
     */
    public void setupEscenario1( )
    {
        estudiante = new Estudiante( "nombre2", "apellido2", 2 );
        curso2 = new Curso( "codigo2", "nombre2", 2 );
    }
    
    /**
     * Crea un escenario para las pruebas con actividades extracurriculares.
     */
    public void setupEscenario2( )
    {
    	estudiante = new Estudiante("nombre", "apellido", 123);
    	Curso cursoNuevo = new Curso("c321", "curso1", 3);
    	estudiante.asignarCurso(cursoNuevo);
    	Curso cursoNuevo2 = new Curso("c4321", "curso2", 3);
    	estudiante.asignarCurso(cursoNuevo2);
    }

    /**
     * Método que prueba la asignación de un curso
     */
    public void testAsignarCurso( )
    {
        setupEscenario0( );
        estudiante.asignarCurso( curso1 );
        Curso aux = estudiante.buscarCurso( "codigo1" );
        assertEquals( "nombre1", aux.darNombreCurso( ) );
    }

    /**
     * Método que prueba la asignación de la nota de un curso
     */
    public void testCambiarNotaCurso( )
    {
        setupEscenario1( );
        estudiante.asignarCurso( curso2 );
        Curso c = estudiante.buscarCurso( "codigo2" );
        c.asignarNota( 4.0 );
        Curso aux = estudiante.buscarCurso( "codigo2" );
        assertTrue( 4.0 == aux.darNota( ) );
    }

    /**
     * Método que prueba el cálculo del promedio del estudiante
     */
    public void testCalcularPromedioEstudiante( )
    {
        setupEscenario0( );
        estudiante.asignarCurso( curso1 );
        Curso c = estudiante.buscarCurso( "codigo1" );
        c.asignarNota( 4.0 );
        double promedio = estudiante.calcularPromedioEstudiante( );
        double promedioAux = ( 4.0 * 2 ) / 2;
        assertTrue( Math.abs( promedio - promedioAux ) < 0.001 );
    }

    /**
     * Método que prueba si el estudiante tomo una amateria
     */
    public void testEstudianteTomoMateria( )
    {
        setupEscenario1( );
        estudiante.asignarCurso( curso2 );
        Curso c = estudiante.buscarCurso( "codigo2" );
        c.asignarNota( 4.0 );
        assertTrue( c.estaCalificado( ) );
    }

    /**
     * Método que prueba si el estudiante no está en Prueba
     */
    public void testEstudianteNoEstaEnPrueba( )
    {
        setupEscenario0( );
        estudiante.asignarCurso( curso1 );
        Curso c = estudiante.buscarCurso( "codigo1" );
        c.asignarNota( 4.0 );
        boolean esta = estudiante.estudianteEstaPrueba( );
        assertEquals( esta, false );
    }

    /**
     * Método que prueba si el estudiante está en Prueba
     */
    public void testEstudianteEstaEnPrueba( )
    {
        setupEscenario1( );
        estudiante.asignarCurso( curso2 );
        Curso c = estudiante.buscarCurso( "codigo2" );
        c.asignarNota( 2.0 );
        boolean esta = estudiante.estudianteEstaPrueba( );
        assertEquals( esta, true );
    }

    /**
     * Método que prueba un curso existe
     */
    public void testEstaCurso( )
    {
        setupEscenario0( );
        estudiante.asignarCurso( curso1 );
        Curso aux = estudiante.buscarCurso( "codigo1" );
        assertEquals( aux.darNombreCurso( ), "nombre1" );
    }

    /**
     * Método que prueba si un curso ya tiene nota
     */
    public void testCursoYaTieneNota( )
    {
        setupEscenario1( );
        estudiante.asignarCurso( curso2 );
        Curso c = estudiante.buscarCurso( "codigo2" );
        c.asignarNota( 4.5 );
        Curso aux = estudiante.buscarCurso( "codigo2" );
        assertTrue( aux.darNota( ) == 4.5 );
    }
    
    /**
     * Prueba que los agregarActividad estén correctamente implementados.
     */
    public void testAgregarActividad()
    {
    	setupEscenario2();
    	assertNull("Debería ser nula la actividad1.", estudiante.darActividad1());
    	assertNull("Debería ser nula la actividad2.", estudiante.darActividad2());
    	assertNull("Debería ser nula la actividad3.", estudiante.darActividad3());
    	
    	estudiante.agregarActividad("ac1", Actividad.TRABAJO_SOCIAL, 456);
    	assertNotNull("Deberia existir la actividad1.", estudiante.darActividad1());
    	assertNull("Debería ser nula la actividad2.", estudiante.darActividad2());
    	assertNull("Debería ser nula la actividad3.", estudiante.darActividad3());
    	
    	estudiante.agregarActividad("ac2", Actividad.ACADEMICO, 4);
    	assertNotNull("Deberia existir la actividad1.", estudiante.darActividad1());
    	assertNotNull("Deberia existir la actividad2.", estudiante.darActividad2());
    	assertNull("Debería ser nula la actividad3.", estudiante.darActividad3());
    	
    	estudiante.agregarActividad("ac3", Actividad.DEPORTIVO, 4);
    	assertNotNull("Deberia existir la actividad1.", estudiante.darActividad1());
    	assertNotNull("Deberia existir la actividad2.", estudiante.darActividad2());
    	assertNotNull("Deberia existir la actividad3.", estudiante.darActividad3());
    }
    
   /**
    * Prueba que eliminarActividad esté correctamente implementado.
    */
    public void testEliminarActividad()
    {
    	setupEscenario2();
    	estudiante.agregarActividad("ac1", Actividad.TRABAJO_SOCIAL, 456);
    	estudiante.agregarActividad("ac2", Actividad.ACADEMICO, 4);
    	
    	estudiante.eliminarActividad("ac1");
    	assertNull("Debería ser nula la actividad1.", estudiante.darActividad1());
    	assertNotNull("Deberia existir la actividad2.", estudiante.darActividad2());
    	
    	estudiante.eliminarActividad("ac3");
    	assertNotNull("Deberia existir la actividad2.", estudiante.darActividad2());
    	
    	estudiante.eliminarActividad("ac2");
    	assertNull("Debería ser nula la actividad2.", estudiante.darActividad2());
    }
    
    /**
     * Prueba que darTipoActividadMasTiempoDedicado esté correctamente implementado.
     */
    public void testDarTipoActividadMasTiempoDedicado()
    {
    	setupEscenario2();
    	estudiante.agregarActividad("ac1", Actividad.TRABAJO_SOCIAL, 456);
    	estudiante.agregarActividad("ac2", Actividad.ACADEMICO, 4);
    	estudiante.agregarActividad("ac3", Actividad.DEPORTIVO, 4);
    	
    	assertEquals("Debería ser Trabajo social", "Trabajo social", estudiante.darTipoActividadMasTiempoDedicado());
    	
    	estudiante.eliminarActividad("ac2");
    	estudiante.agregarActividad("ac2", Actividad.ACADEMICO, 500);
    	
    	assertEquals("Debería ser Académico", "Académico", estudiante.darTipoActividadMasTiempoDedicado() );
    	
    	estudiante.eliminarActividad("ac3");
    	estudiante.agregarActividad("ac3", Actividad.DEPORTIVO, 632);
    	
    	assertEquals("Debería ser Deportivo", "Deportivo", estudiante.darTipoActividadMasTiempoDedicado() );
    }
    
    /**
     * Prueba que contarActividadesMasDe100Horas esté correctamente implementado.
     */
    public void testContarActividadesMasDe100Horas()
    {
    	setupEscenario2();
    	assertEquals("Debería ser 0.", 0, estudiante.contarActividadesMasDe100Horas());
    	
    	estudiante.agregarActividad("ac1", Actividad.TRABAJO_SOCIAL, 456);
    	estudiante.agregarActividad("ac2", Actividad.ACADEMICO, 4);
    	estudiante.agregarActividad("ac3", Actividad.DEPORTIVO, 4);
    	assertEquals("Debería ser 1.", 1, estudiante.contarActividadesMasDe100Horas());
    	
    	estudiante.eliminarActividad("ac2");
    	estudiante.agregarActividad("ac2", Actividad.ACADEMICO, 500);
    	assertEquals("Debería ser 2.", 2, estudiante.contarActividadesMasDe100Horas());
    	
    	estudiante.eliminarActividad("ac3");
    	estudiante.agregarActividad("ac3", Actividad.DEPORTIVO, 632);
    	assertEquals("Debería ser 3.", 3, estudiante.contarActividadesMasDe100Horas());
    	
    }
    
    /**
     *  Prueba que cumpleRequisitosBeca esté correctamente implementado.
     */
    public void testCumpleRequisitosBeca()
    {
    	setupEscenario2();
    	estudiante.agregarActividad("ac1", Actividad.TRABAJO_SOCIAL, 456);
    	estudiante.agregarActividad("ac2", Actividad.ACADEMICO, 543);
    	estudiante.agregarActividad("ac3", Actividad.DEPORTIVO, 231);
    	estudiante.darCurso1().asignarNota(4.5);
    	
    	//No puede por nota
    	assertFalse("Por promedio bajo no puede pedir beca.", estudiante.cumpleRequisitosBeca());
    	
    	estudiante.darCurso2().asignarNota(5);
    	
    	//Si puede aplicar a beca
    	assertTrue("Debería poder aplicar a la beca.", estudiante.cumpleRequisitosBeca());
    	
    	// No puede por horas en trabajo social.
    	estudiante.eliminarActividad("ac1");
    	assertFalse("Por menos de 100 horas en trabajo social no puede pedir beca.", estudiante.cumpleRequisitosBeca());
    	estudiante.agregarActividad("ac1", Actividad.TRABAJO_SOCIAL, 56);
    	assertFalse("Por menos de 100 horas en trabajo social no puede pedir beca.", estudiante.cumpleRequisitosBeca());
    	
    	//Ahora si cumple horas en trabajo social.
    	estudiante.eliminarActividad("ac1");
    	estudiante.agregarActividad("ac1", Actividad.TRABAJO_SOCIAL, 156);
    	
    	// No puede por horas en académico.
    	estudiante.eliminarActividad("ac2");
    	assertFalse("Por menos de 100 horas en académico no puede pedir beca.", estudiante.cumpleRequisitosBeca());
    	estudiante.agregarActividad("ac2", Actividad.ACADEMICO, 43);
    	assertFalse("Por menos de 100 horas en académico no puede pedir beca.", estudiante.cumpleRequisitosBeca());
    	
    	//Ahora si cumple horas en académico.
    	estudiante.eliminarActividad("ac2");
    	estudiante.agregarActividad("ac2", Actividad.ACADEMICO, 543);
    	
    	// No puede por horas en deportivo.
    	estudiante.eliminarActividad("ac3");
    	assertFalse("Por menos de 100 horas en deportivo no puede pedir beca.", estudiante.cumpleRequisitosBeca());
    	estudiante.agregarActividad("ac3", Actividad.DEPORTIVO, 31);
    	assertFalse("Por menos de 100 horas en deportivo no puede pedir beca.", estudiante.cumpleRequisitosBeca());
    	
    	
    }
}
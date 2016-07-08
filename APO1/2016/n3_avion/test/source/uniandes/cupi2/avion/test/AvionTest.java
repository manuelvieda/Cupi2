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

import junit.framework.TestCase;
import uniandes.cupi2.avion.mundo.Avion;
import uniandes.cupi2.avion.mundo.Pasajero;
import uniandes.cupi2.avion.mundo.Pelicula;
import uniandes.cupi2.avion.mundo.Silla;

/**
 * Clase de prueba para el Avión
 */
public class AvionTest extends TestCase
{

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Avión
     */
    private Avion avion;
    /**
     * Pasajero 1
     */
    private Pasajero p1;
    /**
     * Pasajero 2
     */
    private Pasajero p2;
    /**
     * Pasajero 3
     */
    private Pasajero p3;
    /**
     * Pasajero 4
     */
    private Pasajero p4;
    /**
     * Nombre del pasajero 1
     */
    private String nombre1;
    /**
     * Cédula del pasajero 1
     */
    private int cedula1;
    /**
     * Nombre del pasajero 2
     */
    private String nombre2;
    /**
     * Cédula del pasajero 2
     */
    private int cedula2;

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Prepara los datos de prueba para probar el avión. <br>
     * <b>post: </b> Se crean dos pasajeros, uno de ellos se asigna a una silla ejecutiva y el otro una silla económica.
     */
    private void setupEscenario1( )
    {
        //Crea el avión
        avion = new Avion( );

        //Prepara los nombres y cédulas
        nombre1 = "Camilo Pérez";
        cedula1 = 12345;
        nombre2 = "Fernando Santander";
        cedula2 = 23456;

        //Crea los pasajeros
        p1 = new Pasajero( cedula1, nombre1 );
        p2 = new Pasajero( cedula2, nombre2 );
        p1.agregarPelicula("p1", Pelicula.ACCION, 111, "d1");
    	p1.agregarPelicula("p2", Pelicula.COMEDIA, 222, "d2");
    	p1.agregarPelicula("p3", Pelicula.DRAMA, 333, "d3");
    	p2.agregarPelicula("p4", Pelicula.ROMANCE, 444, "d4");
    	p2.agregarPelicula("p5", Pelicula.ACCION, 555, "d5");
    	p2.agregarPelicula("p6", Pelicula.COMEDIA, 111, "d6");

        //Asigna el primer pasajero en una silla ejecutiva de la ventana
        avion.asignarSilla( Silla.CLASE_EJECUTIVA, Silla.VENTANA, p1 );

        //Asigna al segundo pasajero en una silla económica del pasillo
        avion.asignarSilla( Silla.CLASE_ECONOMICA, Silla.PASILLO, p2 );

    }

    /**
     * Prepara los datos de prueba para probar el avión. <br>
     * <b>post: </b> Se crean dos pasajeros, uno de ellos se asigna a una silla ejecutiva y el otro una silla económica.
     */
    private void setupEscenario2( )
    {
        String nombre;
        int cedula;

        //Usa el escenario 1
        setupEscenario1( );

        //Crea los pasajeros
        nombre = "Clara Martínez";
        cedula = 34567;
        p3 = new Pasajero( cedula, nombre );
        nombre = "Sonia Osorio";
        cedula = 56789;
        p4 = new Pasajero( cedula, nombre );

    }

    /**
     * Verifica que la asignación de una silla ejecutiva haya sido correcta
     */
    public void testAsignarSilla1( )
    {
        Silla sillaP1;
        Pasajero p;

        //Configura los datos de prueba
        setupEscenario1( );

        sillaP1 = avion.buscarPasajero( p1 );

        //El pasajero 1 viaja en ejecutivo
        assertEquals( Silla.CLASE_EJECUTIVA, sillaP1.darClase( ) );

        //El pasajero 1 viaja en ventana
        assertEquals( Silla.VENTANA, sillaP1.darUbicacion( ) );

        //La primera silla ejecutiva en ventana es la número 1
        assertEquals( 1, sillaP1.darNumero( ) );

        //El pasajero debe ser el mismo
        p = sillaP1.darPasajero( );
        assertTrue( p1.igualA( p ) );

    }

    /**
     * Verifica que la asignación de una silla económica haya sido correcta
     */
    public void testAsignarSilla( )
    {
        Silla sillaP2;
        Pasajero p;

        //Configura los datos de prueba
        setupEscenario1( );

        sillaP2 = avion.buscarPasajero( p2 );

        //El pasajero 2 viaja en económica
        assertEquals( Silla.CLASE_ECONOMICA, sillaP2.darClase( ) );

        //El pasajero 2 viaja en pasillo
        assertEquals( Silla.PASILLO, sillaP2.darUbicacion( ) );

        //La primera silla económica en pasillo es la número 11
        assertEquals( 11, sillaP2.darNumero( ) );

        //El pasajero debe ser el mismo
        p = sillaP2.darPasajero( );
        assertTrue( p2.igualA( p ) );

    }

    /**
     * Verifica la búsqueda de un pasajero económico que existe
     */
    public void testBuscarPasajero1( )
    {
        Pasajero p;
        Silla s;

        //Configura los datos de prueba
        setupEscenario1( );

        s = avion.buscarPasajeroEconomico( p2 );
        if( s == null )
            fail( "El pasajero debería existir" );
        else
        {
            p = s.darPasajero( );
            assertEquals( cedula2, p.darCedula( ) );
            assertEquals( nombre2, p.darNombre( ) );
        }
    }

    /**
     * Verifica la búsqueda de un pasajero económico que no existe
     */
    public void testBuscarPasajero2( )
    {
        Silla s;

        //Configura los datos de prueba
        setupEscenario1( );

        s = avion.buscarPasajeroEconomico( p1 );
        if( s == null )
            assertTrue( true );
        else
        {
            fail( "El pasajero NO debería existir" );
        }
    }

    /**
     * Verifica la búsqueda de un pasajero ejecutivo que existe
     */
    public void testBuscarPasajero3( )
    {
        Pasajero p;
        Silla s;

        //Configura los datos de prueba
        setupEscenario1( );

        s = avion.buscarPasajeroEjecutivo( p1 );
        if( s == null )
            fail( "El pasajero debería existir" );
        else
        {
            p = s.darPasajero( );
            assertEquals( cedula1, p.darCedula( ) );
            assertEquals( nombre1, p.darNombre( ) );
        }
    }

    /**
     * Verifica la búsqueda de un pasajero ejecutivo que no existe
     */
    public void testBuscarPasajero4( )
    {
        Silla s;

        //Configura los datos de prueba
        setupEscenario1( );

        s = avion.buscarPasajeroEjecutivo( p2 );
        if( s == null )
            assertTrue( true );
        else
        {
            fail( "El pasajero NO debería existir" );
        }
    }

    /**
     * Busca la siguiente silla económica libre
     */
    public void testBuscarSillaEconomicaLibre1( )
    {
        Silla s;

        //Configura los datos de prueba
        setupEscenario1( );

        //La siguiente silla económica de pasillo libre es la 12
        s = avion.buscarSillaEconomicaLibre( Silla.PASILLO );
        assertEquals( 12, s.darNumero( ) );

        //La siguiente silla económica de ventana libre es la 9
        s = avion.buscarSillaEconomicaLibre( Silla.VENTANA );
        assertEquals( 9, s.darNumero( ) );

        //La siguiente silla económica de central libre es la 10
        s = avion.buscarSillaEconomicaLibre( Silla.PASILLO );
        assertEquals( 12, s.darNumero( ) );
    }

    /**
     * Busca la siguiente silla ejecutiva libre
     */
    public void testBuscarSillaEjecutivaLibre1( )
    {
        Silla s;

        //Configura los datos de prueba
        setupEscenario1( );

        //La siguiente silla ejecutiva de pasillo libre es la 2
        s = avion.buscarSillaEjecutivaLibre( Silla.PASILLO );
        assertEquals( 2, s.darNumero( ) );

        //La siguiente silla ejecutiva de ventana libre es la 4
        s = avion.buscarSillaEjecutivaLibre( Silla.VENTANA );
        assertEquals( 4, s.darNumero( ) );

    }

    /**
     * Prueba el porcentaje de ocupación
     */
    public void testCalcularPorcentajeOcupacion1( )
    {
        double porcentajeEsperado, porcentaje;

        //Configura los datos de prueba
        setupEscenario2( );

        //inicialmente el porcentaje de ocupación es igual a 2*100/50
        porcentajeEsperado = ( 2 * 100 ) / 50;
        porcentaje = avion.calcularPorcentajeOcupacion( );
        assertEquals( porcentajeEsperado, porcentaje, 0 );

        //Asigno otros dos pasajeros
        avion.asignarSilla( Silla.CLASE_ECONOMICA, Silla.CENTRAL, p3 );
        avion.asignarSilla( Silla.CLASE_EJECUTIVA, Silla.VENTANA, p4 );

        //Ahora el porcentaje es 4*100/50
        porcentajeEsperado = ( 4 * 100 ) / 50;
        porcentaje = avion.calcularPorcentajeOcupacion( );
        assertEquals( porcentajeEsperado, porcentaje, 0 );
    }

    /**
     * Cuenta las sillas económicas ocupadas
     */
    public void testContarSillasEconomicasOcupadas1( )
    {

        //Configura los datos de prueba
        setupEscenario2( );

        //Inicialmente las sillas económicas ocupadas son 1
        assertEquals( 1, avion.contarSillasEconomicasOcupadas( ) );

        //Asigno otros dos pasajeros
        avion.asignarSilla( Silla.CLASE_ECONOMICA, Silla.CENTRAL, p3 );
        avion.asignarSilla( Silla.CLASE_ECONOMICA, Silla.VENTANA, p4 );

        //Ahora el numero de sillas ocupadas es 3
        assertEquals( 3, avion.contarSillasEconomicasOcupadas( ) );
    }

    /**
     * Cuenta las sillas ejecutivas ocupadas
     */
    public void testContarSillasEjecutivasOcupadas1( )
    {

        Silla s;

        //Configura los datos de prueba
        setupEscenario2( );

        //Inicialmente las sillas económicas ocupadas son 1
        assertEquals( 1, avion.contarSillasEjecutivasOcupadas( ) );

        //Asigno otros dos pasajeros
        s = avion.asignarSilla( Silla.CLASE_EJECUTIVA, Silla.PASILLO, p3 );
        if( s == null )
            fail( "Debió asignar alguna silla 1" );

        s = avion.asignarSilla( Silla.CLASE_EJECUTIVA, Silla.VENTANA, p4 );
        if( s == null )
            fail( "Debió asignar alguna silla 2" );

        //Ahora el numero de sillas ocupadas es 3
        assertEquals( 3, avion.contarSillasEjecutivasOcupadas( ) );
    }

    /**
     * Verifica la desasignación de sillas
     */
    public void testDesasignarSilla1( )
    {
        Silla s;

        //Configura los datos de prueba
        setupEscenario1( );

        avion.desasignarSilla( p1 );

        //Ya el pasajero no debe estar en el avión
        s = avion.buscarPasajero( p1 );

        if( s == null )
            assertTrue( true );
        else
            fail( "El pasajero no debería estar" );
    }
    
    /**
     * Verifica que el método darDuracionTotalPeliculas está correctamente implementado.
     */
    public void testDarDuracionTotalPeliculas()
    {
    	setupEscenario1();
    	assertEquals("La duración debería ser 1776 minutos.", 1776, avion.darDuracionTotalPeliculas());
    }

}
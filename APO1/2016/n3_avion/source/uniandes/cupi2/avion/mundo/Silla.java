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
package uniandes.cupi2.avion.mundo;

/**
 * Silla del avión
 */
public class Silla
{
    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------
    /**
     * Clase silla ejecutiva
     */
    public final static int CLASE_EJECUTIVA = 1;
    /**
     * Clase silla económica
     */
    public final static int CLASE_ECONOMICA = 2;
    /**
     * Ubicación de la silla en la ventana
     */
    public final static int VENTANA = 1;
    /**
     * Ubicación de la silla en el centro
     */
    public final static int CENTRAL = 2;
    /**
     * Ubicación de la silla en el pasillo
     */
    public final static int PASILLO = 3;

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------
    /**
     * Numero de la silla
     */
    private int numero;
    /**
     * Clase de la silla
     */
    private int clase;
    /**
     * Ubicación de la silla
     */
    private int ubicacion;
    /**
     * Pasajero asignado a la silla
     */
    private Pasajero pasajero;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Crea la silla con su número identificador <br>
     * <b>post: </b> El objeto silla tiene sus datos básicos numero,clase y ubicación asignados. El pasajero no está asignado y tiene valor null
     * @param unNumero - número de silla - unNumero > 0
     * @param unaClase - clase de silla - unaClase pertenece {CLASE_EJECUTIVA,CLASE_ECONOMICA}
     * @param unaUbicacion - ubicación de la silla - unaUbicacion pertenece {VENTANA, CENTRAL, PASILLO}
     */
    public Silla( int unNumero, int unaClase, int unaUbicacion )
    {
        numero = unNumero;
        clase = unaClase;
        ubicacion = unaUbicacion;
        // Inicialmente no hay ningún pasajero en la silla
        pasajero = null;
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Asigna la silla al pasajero. <br>
     * <b>post: </b> pasajero = unPasajero
     * @param p - pasajero a asignar en la silla - p !=null
     */
    public void asignarAPasajero( Pasajero p )
    {
        pasajero = p;
    }

    /**
     * Desasigna la silla al pasajero. La silla queda nuevamente libre. <br>
     * <b>post: </b> pasajero == null
     */
    public void desasignarSilla( )
    {
        pasajero = null;
    }

    /**
     * Indica si la silla está asignada.
     * @return true si la silla esta asignada, false en caso contrario
     */
    public boolean sillaAsignada( )
    {
        if( null == pasajero )
            return false;
        else
            return true;
    }

    /**
     * Indica si la silla está asignada al pasajero dado.
     * @param p - pasajero a comparar con el de la silla
     * @return true si el pasajero ocupa la silla, false si la silla está vacía o no coincide el pasajero.
     */
    public boolean sillaAsignadaPasajero( Pasajero p )
    {
        if( null == pasajero )
            return false;
        else if( pasajero.igualA( p ) )
            return true;
        else
            return false;
    }

    /**
     * Retorna el numero de la silla
     * @return numero de silla
     */
    public int darNumero( )
    {
        return numero;
    }

    /**
     * Retorna la clase de la silla
     * @return clase
     */
    public int darClase( )
    {
        return clase;
    }

    /**
     * Retorna la ubicación de la silla
     * @return ubicación
     */
    public int darUbicacion( )
    {
        return ubicacion;
    }

    /**
     * Retorna el pasajero asignado a la silla
     * @return pasajero asignado a la silla - Si no hay pasajero retorna null.
     */
    public Pasajero darPasajero( )
    {
        return pasajero;
    }
}
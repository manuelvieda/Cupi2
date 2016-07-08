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
 * Avión de pasajeros
 */
public class Avion
{
    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------
    /**
     * Numero de sillas ejecutivas
     */
    public final static int SILLAS_EJECUTIVAS = 8;
    /**
     * Numero de sillas económicas
     */
    public final static int SILLAS_ECONOMICAS = 42;

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------
    /**
     * Sillas de la clase ejecutiva del avión
     */
    private Silla[] sillasEjecutivas;
    /**
     * Sillas de la clase económica del avión
     */
    private Silla[] sillasEconomicas;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Construye al avión
     */
    public Avion( )
    {
        int ubicacion;

        // Crea las sillas ejecutivas
        sillasEjecutivas = new Silla[SILLAS_EJECUTIVAS];

        // crea las sillas económicas
        sillasEconomicas = new Silla[SILLAS_ECONOMICAS];

        sillasEjecutivas[ 0 ] = new Silla( 1, Silla.CLASE_EJECUTIVA, Silla.VENTANA );
        sillasEjecutivas[ 1 ] = new Silla( 2, Silla.CLASE_EJECUTIVA, Silla.PASILLO );
        sillasEjecutivas[ 2 ] = new Silla( 3, Silla.CLASE_EJECUTIVA, Silla.PASILLO );
        sillasEjecutivas[ 3 ] = new Silla( 4, Silla.CLASE_EJECUTIVA, Silla.VENTANA );
        sillasEjecutivas[ 4 ] = new Silla( 5, Silla.CLASE_EJECUTIVA, Silla.VENTANA );
        sillasEjecutivas[ 5 ] = new Silla( 6, Silla.CLASE_EJECUTIVA, Silla.PASILLO );
        sillasEjecutivas[ 6 ] = new Silla( 7, Silla.CLASE_EJECUTIVA, Silla.PASILLO );
        sillasEjecutivas[ 7 ] = new Silla( 8, Silla.CLASE_EJECUTIVA, Silla.VENTANA );

        for( int numSilla = 1 + SILLAS_EJECUTIVAS, j = 1; j <= SILLAS_ECONOMICAS; numSilla++, j++ )
        {
            //Sillas ventana
            if( j % 6 == 1 || j % 6 == 0 )
                ubicacion = Silla.VENTANA;
            //Sillas centrales
            else if( j % 6 == 2 || j % 6 == 5 )
                ubicacion = Silla.CENTRAL;
            //Sillas pasillo
            else
                ubicacion = Silla.PASILLO;

            sillasEconomicas[ j - 1 ] = new Silla( numSilla, Silla.CLASE_ECONOMICA, ubicacion );
        }
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Asigna la silla a un pasajero, según sus preferencias de clase y ubicación <br>
     * <b>post: </b> Si existe una silla con la clase y la ubicación dada, el pasajero queda asignado en la primera de ellas según el orden numérico.
     * @param clase - clase elegida por el pasajero - clase pertenece {CLASE_EJECUTIVA,CLASE_ECONOMICA}
     * @param ubicacion - ubicación elegida por el pasajero - si clase = CLASE_ECONOMICA entonces ubicación pertenece {VENTANA, CENTRAL, PASILLO}, o si clase = CLASE_EJECUTIVA
     *        entonces ubicación pertenece {VENTANA, PASILLO}
     * @param pasajero - pasajero a asignar - pasajero != null y no tiene silla en el avión
     * @return silla asignada - Si no se asigna una silla retorna null
     */
    public Silla asignarSilla( int clase, int ubicacion, Pasajero pasajero )
    {
        //busca una silla libre
        Silla silla = null;
        if( clase == Silla.CLASE_EJECUTIVA )
        {
            silla = buscarSillaEjecutivaLibre( ubicacion );
        }
        else if( clase == Silla.CLASE_ECONOMICA )
        {
            silla = buscarSillaEconomicaLibre( ubicacion );
        }
        if( silla != null )
        {
            silla.asignarAPasajero( pasajero );
        }
        return silla;
    }

    /**
     * Busca la siguiente silla ejecutiva que este libre y tenga la ubicación indicada.
     * @param ubicacion - ubicación en donde buscar la silla - ubicación pertenece {VENTANA, PASILLO}
     * @return La silla libre encontrada. Si no encuentra retorna null.
     */
    public Silla buscarSillaEjecutivaLibre( int ubicacion )
    {
        boolean encontrado = false;
        Silla silla = null;
        for( int i = 0; i < SILLAS_EJECUTIVAS && !encontrado; i++ )
        {
            silla = sillasEjecutivas[ i ];
            if( ! ( silla.sillaAsignada( ) ) && silla.darUbicacion( ) == ubicacion )
            {
                encontrado = true;
            }
        }
        if( encontrado )
            return silla;
        else
            return null;
    }

    /**
     * Busca la siguiente silla económica que este libre y tenga la ubicación indicada.
     * @param ubicacion - ubicación en donde buscar la silla - ubicación pertenece {VENTANA, CENTRAL, PASILLO}
     * @return la silla encontrada libre. Si no encuentra retorna null
     */
    public Silla buscarSillaEconomicaLibre( int ubicacion )
    {
        boolean encontrado = false;
        Silla silla = null;
        for( int i = 0; i < SILLAS_ECONOMICAS && !encontrado; i++ )
        {
            silla = sillasEconomicas[ i ];
            if( ! ( silla.sillaAsignada( ) ) && silla.darUbicacion( ) == ubicacion )
            {
                encontrado = true;
            }
        }
        if( encontrado )
            return silla;
        else
            return null;
    }

    /**
     * Busca un pasajero en el avión
     * @param pasajero - pasajero a buscar - pasajero != null
     * @return silla en la que se encontró el pasajero. Si no lo encuentra retorna null
     */
    public Silla buscarPasajero( Pasajero pasajero )
    {
        //Busca el pasajero en ejecutiva
        Silla silla = buscarPasajeroEjecutivo( pasajero );
        //Si no estaba en ejecutiva
        if( null == silla )
            //Busca en económica
            silla = buscarPasajeroEconomico( pasajero );
        return silla;

    }

    /**
     * Busca un pasajero en las sillas ejecutivas
     * @param pasajero - pasajero a buscar - pasajero != null
     * @return silla en la que se encontró el pasajero. Si no lo encuentra retorna null
     */
    public Silla buscarPasajeroEjecutivo( Pasajero pasajero )
    {
        boolean encontrado = false;
        Silla silla = null;
        for( int i = 0; i < SILLAS_EJECUTIVAS && !encontrado; i++ )
        {
            silla = sillasEjecutivas[ i ];
            if( silla.sillaAsignada( ) && silla.darPasajero( ).igualA( pasajero ) )
            {
                encontrado = true;
            }
        }
        if( encontrado )
            return silla;
        else
            return null;
    }

    /**
     * Busca un pasajero en las sillas económicas
     * @param pasajero - pasajero a buscar - pasajero != null
     * @return silla en la que se encontró el pasajero. Si no lo encuentra retorna null
     */
    public Silla buscarPasajeroEconomico( Pasajero pasajero )
    {
        boolean encontrado = false;
        Silla silla = null;
        for( int i = 0; i < SILLAS_ECONOMICAS && !encontrado; i++ )
        {
            silla = sillasEconomicas[ i ];
            if( silla.sillaAsignada( ) && silla.darPasajero( ).igualA( pasajero ) )
            {
                encontrado = true;
            }
        }
        if( encontrado )
            return silla;
        else
            return null;
    }

    /**
     * Desasigna la silla de un pasajero <br>
     * <b>post: </b> Si se encuentra una silla con el pasajero, la silla quedara con su pasajero == null
     * @param pasajero - pasajero a retirar - pasajero != null
     * @return true si encontró el pasajero y desasignó la silla, false en caso contrario
     */
    public boolean desasignarSilla( Pasajero pasajero )
    {
        //Busca el pasajero en el avión
        Silla silla = buscarPasajero( pasajero );
        //Si lo encuentra desasigna
        if( silla != null )
        {
            silla.desasignarSilla( );
            return true;
        }
        else
            return false;
    }

    /**
     * Retorna el número de sillas ejecutivas ocupadas
     * @return numero de ejecutivas sillas ocupadas
     */
    public int contarSillasEjecutivasOcupadas( )
    {
        int contador = 0;
        for( int i = 0; i < SILLAS_EJECUTIVAS; i++ )
        {
            if( sillasEjecutivas[ i ].sillaAsignada( ) )
            {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Retorna el número de sillas económicas ocupadas
     * @return numero de sillas económicas ocupadas
     */
    public int contarSillasEconomicasOcupadas( )
    {
        int contador = 0;
        for( int i = 0; i < SILLAS_ECONOMICAS; i++ )
        {
            if( sillasEconomicas[ i ].sillaAsignada( ) )
            {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Calcula el porcentaje de ocupación del avión
     * @return porcentaje total de ocupación
     */
    public double calcularPorcentajeOcupacion( )
    {
        double porcentaje;
        int totalSillas = SILLAS_ECONOMICAS + SILLAS_EJECUTIVAS;
        int sillasOcupadas = contarSillasEconomicasOcupadas( ) + contarSillasEjecutivasOcupadas( );
        porcentaje = ( double )sillasOcupadas / totalSillas * 100;
        return porcentaje;
    }

    /**
     * Retorna las sillas ejecutivas del avión
     * @return sillas ejecutivas
     */
    public Silla[] obtenerSillasEjecutivas( )
    {
        return sillasEjecutivas;
    }

    /**
     * Retorna las sillas económicas del avión
     * @return sillas económicas
     */
    public Silla[] obtenerSillasEconomicas( )
    {
        return sillasEconomicas;
    }

    /**
     * Retorna la duración total de todas las peliculas de todos los pasajeros.
     * Tiene en cuenta tanto sillas económicas como sillas ejecutivas.
     * @return Duración total en minutos de todas las peliculas.
     */
    public int darDuracionTotalPeliculas()
    {

        int duracionPeliculas = 0;

        if(sillasEconomicas!=null){
            for (Silla silla : sillasEconomicas) {
                if(silla.darPasajero()!=null){
                    duracionPeliculas += silla.darPasajero().darDuracionTotalPeliculas();
                }
            }
        }

        if(sillasEjecutivas!=null){
            for (Silla silla : sillasEjecutivas) {
                if(silla.darPasajero()!=null){
                    duracionPeliculas += silla.darPasajero().darDuracionTotalPeliculas();
                }
            }
        }

        return  duracionPeliculas;
    }
    
    
    /**
     * Método 1 de extensión al ejemplo
     * @return respuesta
     */
    public String metodo1( )
    {
        return "respuesta 1";
    }

    /**
     * Método 2 de extensión al ejemplo
     * @return respuesta
     */
    public String metodo2( )
    {
        return "respuesta 2";
    }
}
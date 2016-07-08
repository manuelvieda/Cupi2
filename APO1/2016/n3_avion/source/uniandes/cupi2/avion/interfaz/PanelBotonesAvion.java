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
package uniandes.cupi2.avion.interfaz;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

/**
 * Panel de botones de interacción con el programa del avión
 */
public class PanelBotonesAvion extends JPanel implements ActionListener
{
    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------

    /**
     * Opción registrar
     */
    public final static String REGISTRAR = "REGISTRAR_PASAJERO";

    /**
     * Opción anular
     */
    public final static String ANULAR = "ANULAR_PASAJERO";

    /**
     * Opción buscar
     */
    public final static String BUSCAR = "BUSCAR_PASAJERO";

    /**
     * Opción porcentaje de ocupación
     */
    public final static String PORCENTAJE = "PORCENTAJE_OCUPACION";

    /**
     * Opción extensión 1
     */
    private final static String OPCION_1 = "OPCION_1";

    /**
     * Opción extensión 1
     */
    private final static String OPCION_2 = "OPCION_2";
    
    /**
     * Comando para agregar una película a un pasajero.
     */
    public final static String AGREGAR_PELICULA = "AGREGAR_PELICULA";
    
    /**
     * Comando para buscar las películas de un pasajero.
     */
    public final static String BUSCAR_PELICULAS = "BUSCAR_PELICULAS";
    
    /**
     * Comando para la duración total de las películas.
     */
    public final static String DURACION_TOTAL_PELICULAS = "DURACION_TOTAL_PELICULAS";
    
    /**
     * Comando para dar las películas de un género.
     */
    public final static String PELICULAS_GENERO = "PELICULAS_GENERO";
    
    /**
     * Comando para informar si un pasajero tiene dos o mas películas con la misma duración.
     */
    public final static String PELICULAS_MISMA_DURACION = "PELICULAS_MISMA_DURACION";

    //-----------------------------------------------------------------
    // Atributos de interfaz
    //-----------------------------------------------------------------

    /**
     * Botón Registro de nuevo pasajero
     */
    private JButton bRegistro;

    /**
     * Botón Anular
     */
    private JButton bAnular;

    /**
     * Botón de búsqueda
     */
    private JButton bBuscarPasajero;

    /**
     * Botón porcentaje de ocupación
     */
    private JButton bPorcOcupacion;

    /**
     * Botón de extensión 1
     */
    private JButton botonOpcion1;

    /**
     * Botón de extensión 2
     */
    private JButton botonOpcion2;

    /**
     * Botón de agregar películas.
     */
    private JButton bAgregarPelicula;
    
    /**
     * Botón para buscar películas.
     */
    private JButton bBuscarPeliculas;
    
    /**
     * Botón para la duración total de las películas.
     */
    private JButton bDuracionTotalPeliculas;
    
    /**
     * Botón para dar las películas de un género.
     */
    private JButton bPeliculasGenero;
    
    /**
     * Botón para detemrianr si hay dos películas con la misma duración.
     */
    private JButton bPeliculasMismaDuracion;
    
    /**
     * Interfaz principal
     */
    private InterfazAvion ventana;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Crea el panel de botones <br>
     * <b <post: </b> se crean y alistan los botones de la interfaz.
     * @param laVentana - ventana o frame padre - laVentana != null
     */
    public PanelBotonesAvion( InterfazAvion laVentana )
    {
        //guarda la referencia a la ventana padre
        ventana = laVentana;

        //Configura propiedades visuales
        setLayout( new GridLayout( 6, 3, 8, 2 ) );
        setBorder( new EmptyBorder( 5, 5, 5, 5 ) );

        //Linea avión
        add(new JLabel("Opciones del avión:"));
        add(new JLabel());
        add(new JLabel());
        
        //Botón registrar
        bRegistro = new JButton( "Registrar pasajero" );
        bRegistro.setActionCommand( REGISTRAR );
        bRegistro.addActionListener( this );
        bRegistro.setPreferredSize( new Dimension( 40, 10 ) );
        add( bRegistro );

        //Botón anular registro
        bAnular = new JButton( "Eliminar pasajero" );
        bAnular.setActionCommand( ANULAR );
        bAnular.addActionListener( this );
        add( bAnular );

        //Botón buscar pasajero
        bBuscarPasajero = new JButton( "Buscar pasajero" );
        bBuscarPasajero.setActionCommand( BUSCAR );
        bBuscarPasajero.addActionListener( this );
        add( bBuscarPasajero );

        //Botón porcentaje de ocupación
        bPorcOcupacion = new JButton( "Porcentaje ocupación" );
        bPorcOcupacion.setActionCommand( PORCENTAJE );
        bPorcOcupacion.addActionListener( this );
        add( bPorcOcupacion );

        //Botón duración total de películas
        bDuracionTotalPeliculas = new JButton("Duración total películas");
        bDuracionTotalPeliculas.setActionCommand(DURACION_TOTAL_PELICULAS);
        bDuracionTotalPeliculas.addActionListener(this);
        add(bDuracionTotalPeliculas);
        
        //vacío al final
        add(new JLabel());
        
        //línea pasajero
        add(new JLabel("Opciones del pasajero:"));
        add(new JLabel());
        add(new JLabel());
        
        //Botón agregar película
        bAgregarPelicula = new JButton("Agregar película");
        bAgregarPelicula.setActionCommand(AGREGAR_PELICULA);
        bAgregarPelicula.addActionListener(this);
        add(bAgregarPelicula);

        //Botón buscar películas
        bBuscarPeliculas = new JButton("Buscar películas");
        bBuscarPeliculas.setActionCommand(BUSCAR_PELICULAS);
        bBuscarPeliculas.addActionListener(this);
        add(bBuscarPeliculas);

        
        
        //Botón películas de género
        bPeliculasGenero = new JButton("Películas género");
        bPeliculasGenero.setActionCommand(PELICULAS_GENERO);
        bPeliculasGenero.addActionListener(this);
        add(bPeliculasGenero);
        
        //Botón películas misma duración
        bPeliculasMismaDuracion = new JButton("Películas misma duración");
        bPeliculasMismaDuracion.setActionCommand(PELICULAS_MISMA_DURACION);
        bPeliculasMismaDuracion.addActionListener(this);
        add(bPeliculasMismaDuracion);
        
        //Botones de opciones adicionales
        botonOpcion1 = new JButton( "Opción 1" );
        botonOpcion1.setActionCommand( OPCION_1 );
        botonOpcion1.addActionListener( this );
        add( botonOpcion1 );
        botonOpcion2 = new JButton( "Opción 2" );
        botonOpcion2.setActionCommand( OPCION_2 );
        botonOpcion2.addActionListener( this );
        add( botonOpcion2 );
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Acciones de respuesta a los eventos de la interfaz
     * @param evento - evento generado por un elemento de la interfaz
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( comando.equals( REGISTRAR ) )
        {
            ventana.registrarPasajero( );
        }
        else if( comando.equals( ANULAR ) )
        {
            ventana.anularPasajero( );
        }
        else if( comando.equals( BUSCAR ) )
        {
            ventana.buscarPasajero( );
        }
        else if( comando.equals( PORCENTAJE ) )
        {
            ventana.mostrarPorcentajeOcupacion( );
        }
        else if( comando.equals( OPCION_1 ) )
        {
            ventana.reqFuncOpcion1( );
        }
        else if( comando.equals( OPCION_2 ) )
        {
            ventana.reqFuncOpcion2( );
        }
        else if( comando.equals(AGREGAR_PELICULA))
        {
        	ventana.mostrarDialogoAgregarPelicula();
        }
        else if( comando.equals(BUSCAR_PELICULAS))
        {
        	ventana.buscarPeliculas();
        }
        else if( comando.equals(DURACION_TOTAL_PELICULAS))
        {
        	ventana.duracionTotalPeliculas();
        }
        else if(comando.equals(PELICULAS_GENERO))
        {
        	ventana.mostrarDialogoPeliculasGenero();
        }
        else if( comando.equals(PELICULAS_MISMA_DURACION))
        {
        	ventana.peliculasMismaDuracion();
        }
    }
}
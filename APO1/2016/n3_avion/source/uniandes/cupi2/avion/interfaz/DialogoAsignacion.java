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

import javax.swing.*;

import uniandes.cupi2.avion.mundo.*;

/**
 * Formulario para la asignación de sillas
 */
public class DialogoAsignacion extends JDialog
{

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Avión
     */
    private Avion avion;

    //-----------------------------------------------------------------
    // Atributos de interfaz
    //-----------------------------------------------------------------

    /**
     * Interfaz principal
     */
    private InterfazAvion ventana;

    /**
     * Panel con los botones
     */
    private PanelBotonesAsignacion panelBotones;

    /**
     * Panel con los datos
     */
    private PanelDatosAsignacion panelDatos;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Crea el formulario de asignación de pasajeros
     * @param laVentana - ventana o frame padre del diálogo - laVentana !=null
     * @param elAvion - avión sobre el que se hará la asignación - elAvion != null
     */
    public DialogoAsignacion( InterfazAvion laVentana, Avion elAvion )
    {

        //Guarda la referencia al avión
        avion = elAvion;

        //Guarda la referencia a la ventana padre
        ventana = laVentana;

        //Configuración de propiedades gráficas
        setLayout( new BorderLayout( ) );

        //Crea el panel de datos
        panelDatos = new PanelDatosAsignacion( );
        add( panelDatos, BorderLayout.CENTER );

        //Crea el panel de botones
        panelBotones = new PanelBotonesAsignacion( this );
        add( panelBotones, BorderLayout.SOUTH );

        setTitle( "Registro de pasajero" );
        pack( );
        //setResizable( false );
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );

    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Procesa el registro de un pasajero. Recoge los datos del pasajero y de la clase y ubicación en la que desea su silla y procesa su registro <b>post: </b> Si el pasajero
     * no está registrado y hay silla con las características solicitadas se asigna el pasajero a una silla del avión. Si el registro no se puede hacer correctamente, muestra
     * un mensaje.
     */
    public void registrar( )
    {
        int cedula, clase;
        char ubicacion;
        String nombre, sCedula;
        Pasajero pasajero;

        nombre = panelDatos.darNombre( );
        sCedula = panelDatos.darCedula( );

        if( sCedula == null || sCedula.equals( "" ) )
        {
            JOptionPane.showMessageDialog( this, "La cédula es requerida", "Registro", JOptionPane.ERROR_MESSAGE );
            return;
        }

        try
        {
            cedula = Integer.parseInt( sCedula );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, "La cédula es numérica", "Registro", JOptionPane.ERROR_MESSAGE );
            return;
        }

        if( nombre == null || nombre.equals( "" ) )
        {
            JOptionPane.showMessageDialog( this, "El nombre es requerido", "Registro", JOptionPane.ERROR_MESSAGE );
            return;
        }

        //Crea al pasajero
        pasajero = new Pasajero( cedula, nombre );

        //verifica que no este ya el pasajero registrado
        Silla silla = avion.buscarPasajero( pasajero );

        if( silla != null )
        {
            JOptionPane.showMessageDialog( this, "El pasajero ya tiene una silla asignada", "Registro", JOptionPane.ERROR_MESSAGE );
            return;
        }

        //Registra al pasajero
        clase = panelDatos.darClase( );
        ubicacion = panelDatos.darUbicacion( );
        silla = avion.asignarSilla( clase, ubicacion, pasajero );

        if( silla == null )
        {
            JOptionPane.showMessageDialog( this, "No hay sillas disponibles con dichas características", "Registro", JOptionPane.ERROR_MESSAGE );
            return;
        }
        ventana.actualizar( );
        dispose( );

    }

    /**
     * Cancela el proceso de registro
     */
    public void cancelar( )
    {
        ventana.actualizar( );
        dispose( );
    }
}
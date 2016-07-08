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
 * Panel con la información del pasajero
 */
public class PanelDatosPasajero extends JPanel
{
    //-----------------------------------------------------------------
    // Atributos de interfaz
    //-----------------------------------------------------------------

    /**
     * Texto que contiene la cédula
     */
    private JTextField txtCedula;

    /**
     * Texto que contiene el nombre
     */
    private JTextField txtNombre;

    /**
     * Texto que contiene la clase
     */
    private JTextField txtClase;

    /**
     * Texto que contiene la ubicación
     */
    private JTextField txtUbicacion;

    /**
     * Texto que contiene la silla
     */
    private JTextField txtSilla;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Crea el panel con los datos del pasajero
     * @param pasajero - pasajero cuya información se presentará
     * @param silla Silla donde se encuentra ubicado el pasajero
     */
    public PanelDatosPasajero( Pasajero pasajero, Silla silla )
    {
        setLayout( new GridLayout( 5, 1, 1, 1 ) );
        setBorder( BorderFactory.createTitledBorder( "Datos del pasajero" ) );

        //Cédula
        JPanel panelCedula = new JPanel( );
        panelCedula.setLayout( new FlowLayout( FlowLayout.RIGHT, 5, 0 ) );
        JLabel etiquetaCedula = new JLabel( "Cédula " );
        txtCedula = new JTextField( Integer.toString( pasajero.darCedula( ) ) );
        txtCedula.setColumns( 15 );
        txtCedula.setEditable( false );
        panelCedula.add( etiquetaCedula );
        panelCedula.add( txtCedula );
        add( panelCedula );

        //Nombre
        JPanel panelNombre = new JPanel( );
        panelNombre.setLayout( new FlowLayout( FlowLayout.RIGHT, 5, 0 ) );
        JLabel etiquetaNombre = new JLabel( "Nombre " );
        txtNombre = new JTextField( pasajero.darNombre( ) );
        txtNombre.setColumns( 15 );
        txtNombre.setEditable( false );
        panelNombre.add( etiquetaNombre );
        panelNombre.add( txtNombre );
        add( panelNombre );

        //Silla
        JPanel panelSilla = new JPanel( );
        panelSilla.setLayout( new FlowLayout( FlowLayout.RIGHT, 5, 0 ) );
        JLabel etiquetaSilla = new JLabel( "Silla " );
        txtSilla = new JTextField( Integer.toString( silla.darNumero( ) ) );
        txtSilla.setColumns( 15 );
        txtSilla.setEditable( false );
        panelSilla.add( etiquetaSilla );
        panelSilla.add( txtSilla );
        add( panelSilla );

        //Clase
        JPanel panelClase = new JPanel( );
        panelClase.setLayout( new FlowLayout( FlowLayout.RIGHT, 5, 0 ) );
        JLabel etiquetaClase = new JLabel( "Clase " );
        String sClase;
        if( silla.darClase( ) == Silla.CLASE_ECONOMICA )
        {
            sClase = "Económica";
        }
        else
        {
            sClase = "Ejecutiva";
        }
        txtClase = new JTextField( sClase );
        txtClase.setColumns( 15 );
        txtClase.setEditable( false );
        panelClase.add( etiquetaClase );
        panelClase.add( txtClase );
        add( panelClase );

        //Ubicación
        JPanel panelUbicacion = new JPanel( );
        panelUbicacion.setLayout( new FlowLayout( FlowLayout.RIGHT, 5, 0 ) );
        JLabel etiquetaUbicacion = new JLabel( "Ubicación " );
        String sUbicacion;
        if( silla.darUbicacion( ) == Silla.CENTRAL )
        {
            sUbicacion = "Centro";
        }
        else if( silla.darUbicacion( ) == Silla.PASILLO )
        {
            sUbicacion = "Pasillo";
        }
        else
        {
            sUbicacion = "Ventana";
        }
        txtUbicacion = new JTextField( sUbicacion );
        txtUbicacion.setColumns( 15 );
        txtUbicacion.setEditable( false );
        panelUbicacion.add( etiquetaUbicacion );
        panelUbicacion.add( txtUbicacion );
        add( panelUbicacion );
    }
}
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

/**
 * Panel de los botones de la ventana de información del pasajero
 */
public class PanelBotonesDatosPasajero extends JPanel implements ActionListener
{

    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------

    /**
     * Opción Aceptar
     */
    public final static String ACEPTAR = "ACEPTAR";

    //-----------------------------------------------------------------
    // Atributos de interfaz
    //-----------------------------------------------------------------

    /**
     * Ventana principal
     */
    private VentanaDatosPasajero ventana;

    /**
     * Botón aceptar
     */
    private JButton botonAceptar;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Crea el panel de botones de la ventana de datos del pasajero
     * @param laVentana - Ventana de la que hace parte el panel
     */
    public PanelBotonesDatosPasajero( VentanaDatosPasajero laVentana )
    {
        setLayout( new GridLayout( 1, 2, 10, 1 ) );
        ventana = laVentana;

        //Aceptar
        botonAceptar = new JButton( );
        botonAceptar.setText( "Aceptar" );
        botonAceptar.setActionCommand( ACEPTAR );
        botonAceptar.addActionListener( this );
        add( botonAceptar );
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

        if( comando.equals( ACEPTAR ) )
        {
            ventana.aceptar( );
        }
    }
}
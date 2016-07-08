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
 * Formulario para presentar los datos y el registro del pasajero
 */
public class VentanaDatosPasajero extends JFrame
{
    //-----------------------------------------------------------------
    // Atributos de Interfaz
    //-----------------------------------------------------------------

    /**
     * Panel con los botones
     */
    private PanelBotonesDatosPasajero panelBotones;

    /**
     * Panel de los datos del pasajero
     */
    private PanelDatosPasajero panelDatosPasajero;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Crea la ventana con los datos del pasajero
     * @param silla - silla en la que el pasajero está ubicado
     */
    public VentanaDatosPasajero( Silla silla )
    {
        Pasajero pasajero = silla.darPasajero( );
        setLayout( new BorderLayout( ) );

        //Crea el panel de datos del pasajero
        panelDatosPasajero = new PanelDatosPasajero( pasajero, silla );
        add( panelDatosPasajero, BorderLayout.NORTH );

        //Crea el panel de botones
        panelBotones = new PanelBotonesDatosPasajero( this );
        add( panelBotones, BorderLayout.SOUTH );

        setTitle( "Datos registro del pasajero" );
        pack( );
        setResizable( false );
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Cierra la ventana
     */
    public void aceptar( )
    {
        dispose( );
    }
}
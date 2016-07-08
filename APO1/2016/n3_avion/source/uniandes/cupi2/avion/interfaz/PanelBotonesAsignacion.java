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
 * Panel de botones para el diálogo de asignación
 */
public class PanelBotonesAsignacion extends JPanel implements ActionListener
{

    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------

    /**
     * Opción Aceptar
     */
    public final static String ACEPTAR = "ACEPTAR";

    /**
     * Opción Cancelar
     */
    public final static String CANCELAR = "CANCELAR";

    //-----------------------------------------------------------------
    // Atributos de interfaz
    //-----------------------------------------------------------------

    /**
     * Botón aceptar
     */
    private JButton botonAceptar;

    /**
     * Botón cancelar
     */
    private JButton botonCancelar;

    /**
     * Diálogo del que hace parte el panel
     */
    private DialogoAsignacion dialogo;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Crea el panel de botones para la asignación de cupo en el avión
     * @param elDialogo - diálogo al que pertenece el panel de botones - elDialogo != null
     */
    public PanelBotonesAsignacion( DialogoAsignacion elDialogo )
    {
        setLayout( new GridLayout( 1, 2, 8, 1 ) );
        dialogo = elDialogo;

        //Aceptar
        botonAceptar = new JButton( );
        botonAceptar.setText( "Aceptar" );
        botonAceptar.setActionCommand( ACEPTAR );
        botonAceptar.addActionListener( this );
        add( botonAceptar );

        //Cancelar
        botonCancelar = new JButton( );
        botonCancelar.setText( "Cancelar" );
        botonCancelar.setActionCommand( CANCELAR );
        botonCancelar.addActionListener( this );
        add( botonCancelar );
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
            dialogo.registrar( );
        }
        else if( comando.equals( CANCELAR ) )
        {
            dialogo.cancelar( );
        }
    }
}
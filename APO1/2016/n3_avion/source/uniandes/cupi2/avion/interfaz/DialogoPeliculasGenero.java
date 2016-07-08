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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.avion.mundo.Pelicula;

/**
 * Dialogo para seleccionar un género de película para la bpusqueda.
 */
public class DialogoPeliculasGenero extends JDialog implements ActionListener
{
	 // -----------------------------------------------
    // Atributos
    // -----------------------------------------------

    /**
     * Comando aceptar
     */
    private final static String ACEPTAR = "ACEPTAR";

    /**
     * Ventana principal de la aplicación
     */
    private InterfazAvion principal;

    /**
     * Etiqueta cédula pasajero.
     */
    private JLabel labelCedulaPasajero;

    /**
     * Etiqueta género pelicula.
     */
    private JLabel labelGenero;

    /**
     * Texto cédula pasajero.
     */
    private JTextField textoCedulaPasajero;
    
    /**
     * Combo género.
     */
    private JComboBox comboGenero;

    /**
     * Botón aceptar.
     */
    private JButton botonAceptar;

    // -----------------------------------------------
    // Métodos
    // -----------------------------------------------

    /**
     * Constructor del dialogo.
     * @param ventana Ventana principal de la aplicación.
     */
    public DialogoPeliculasGenero( InterfazAvion ventana)
    {

        super( ventana, true );

        principal = ventana;

        setLayout( new BorderLayout( 10, 10 ) );
        setSize(300, 170);
        
        JPanel panelCentral = new JPanel( );
        JPanel panelSur = new JPanel( );

        panelCentral.setBorder( new TitledBorder( "Información película" ) );

        panelCentral.setLayout( new GridLayout( 2, 2, 5, 5 ) );

        labelCedulaPasajero = new JLabel( "Cédula pasajero:" );
        panelCentral.add( labelCedulaPasajero );

        textoCedulaPasajero = new JTextField( );
        panelCentral.add( textoCedulaPasajero );

        labelGenero = new JLabel( "Género:" );
        panelCentral.add( labelGenero );

        comboGenero = new JComboBox();
        comboGenero.addItem(Pelicula.ACCION);
        comboGenero.addItem(Pelicula.COMEDIA);
        comboGenero.addItem(Pelicula.DRAMA);
        comboGenero.addItem(Pelicula.INFANTIL);
        comboGenero.addItem(Pelicula.ROMANCE);
        panelCentral.add( comboGenero );

        add( panelCentral, BorderLayout.CENTER );

        botonAceptar = new JButton( "Aceptar" );
        botonAceptar.setActionCommand( ACEPTAR );
        botonAceptar.addActionListener( this );

        panelSur.add( botonAceptar );

        add( panelSur, BorderLayout.SOUTH );

        
        setLocationRelativeTo( principal );

    }

    /**
     * Método para manejar acciones
     * @param e Acción generada
     */
    public void actionPerformed( ActionEvent e )
    {
        if( e.getActionCommand( ).equals( ACEPTAR ) )
        {
            

            try
            {
            	int cedula = Integer.parseInt(textoCedulaPasajero.getText());
                String genero = (String) comboGenero.getSelectedItem();
                principal.peliculasGenero(cedula, genero);


            }
            catch( Exception e2 )
            {
                JOptionPane.showMessageDialog( this, "Error en el formato de la duración y/o cédula." );
            }
            dispose( );

        }

    }
}

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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.avion.mundo.Pasajero;
import uniandes.cupi2.avion.mundo.Pelicula;

/**
 * Dialogo para agregar una película.
 */
public class DialogoAgregarPelicula extends JDialog implements ActionListener
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
     * Etiqueta nombre película.
     */
    private JLabel labelNombre;

    /**
     * Etiqueta género pelicula.
     */
    private JLabel labelGenero;

    /**
     * Etiqueta duración película.
     */
    private JLabel labelDuracion;

    /**
     * Etiqueta director película.
     */
    private JLabel labelDirector;

    /**
     * Texto cédula pasajero.
     */
    private JTextField textoCedulaPasajero;
    
    /**
     * Texto nombre película.
     */
    private JTextField textoNombre;

    /**
     * Combo género.
     */
    private JComboBox comboGenero;

    /**
     * Texto duración.
     */
    private JTextField textoDuración;

    /**
     * Texto director.
     */
    private JTextField textoDirector;

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
    public DialogoAgregarPelicula( InterfazAvion ventana)
    {

        super( ventana, true );

        principal = ventana;

        setLayout( new BorderLayout( 10, 10 ) );

        JPanel panelNorte = new JPanel();
        JPanel panelCentral = new JPanel( );
        JPanel panelSur = new JPanel( );

        panelNorte.setLayout(new GridLayout(1, 2));
        labelCedulaPasajero = new JLabel( "Cédula pasajero:" );
        panelNorte.add( labelCedulaPasajero );
        textoCedulaPasajero = new JTextField( );
        panelNorte.add( textoCedulaPasajero );
        add(panelNorte, BorderLayout.NORTH);
        
        panelCentral.setBorder( new TitledBorder( "Información película" ) );
        panelCentral.setLayout( new GridLayout( 4, 2, 5, 5 ) );

        labelNombre = new JLabel( "Nombre:" );
        panelCentral.add( labelNombre );

        textoNombre = new JTextField( );
        panelCentral.add( textoNombre );

        labelGenero = new JLabel( "Género:" );
        panelCentral.add( labelGenero );

        comboGenero = new JComboBox();
        comboGenero.addItem(Pelicula.ACCION);
        comboGenero.addItem(Pelicula.COMEDIA);
        comboGenero.addItem(Pelicula.DRAMA);
        comboGenero.addItem(Pelicula.INFANTIL);
        comboGenero.addItem(Pelicula.ROMANCE);
        panelCentral.add( comboGenero );

        labelDuracion = new JLabel( "Duración (mins):" );
        panelCentral.add( labelDuracion );

        textoDuración = new JTextField( );
        panelCentral.add( textoDuración );

        labelDirector = new JLabel( "Director:" );
        panelCentral.add( labelDirector );

        textoDirector = new JTextField( );
        panelCentral.add( textoDirector );

        add( panelCentral, BorderLayout.CENTER );

        botonAceptar = new JButton( "Aceptar" );
        botonAceptar.setActionCommand( ACEPTAR );
        botonAceptar.addActionListener( this );

        panelSur.add( botonAceptar );

        add( panelSur, BorderLayout.SOUTH );

        setSize( new Dimension( 230, 250 ) );
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
                int duracion = Integer.parseInt( textoDuración.getText());
                String nombre = textoNombre.getText();
                String genero = (String) comboGenero.getSelectedItem();
                String director = textoDirector.getText();

                if( !nombre.equals( "" )&&  !director.equals( "" ) )
                {
                    
                    if(duracion>0)
                    {
                    	principal.agregarPelicula(cedula, nombre, genero, duracion, director);
                    }
                    else
                    {
                    	JOptionPane.showMessageDialog(this, "La duración de la película debe ser mayor a cero.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    
                }
                else
                    JOptionPane.showMessageDialog( this, "Debe ingresar nombre de la película y director." );
            }
            catch( Exception e2 )
            {
                JOptionPane.showMessageDialog( this, "Error en el formato de la duración y/o cédula." );
            }
            dispose( );

        }

    }

}

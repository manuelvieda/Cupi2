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

import uniandes.cupi2.avion.mundo.*;

/**
 * Panel de los datos del registro de pasajero
 */
public class PanelDatosAsignacion extends JPanel implements ActionListener
{
    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------
    private final static String CLASE_EJECUTIVA = "Clase ejecutiva";
    private final static String CLASE_ECONOMICA = "Clase económica";
    private final static String UBICACION_VENTANA = "Ventana";
    private final static String UBICACION_PASILLO = "Pasillo";
    private final static String UBICACION_CENTRO = "Centro";

    //-----------------------------------------------------------------
    // Atributos de interfaz
    //-----------------------------------------------------------------

    /**
     * Combo de selección de la clase
     */
    private JComboBox cbClase;

    /**
     * Combo de selección de la ubicación
     */
    private JComboBox cbUbicacion;

    /**
     * Texto de ingreso de cédula
     */
    private JTextField txtCedula;

    /**
     * Texto de ingreso de cédula
     */
    private JTextField txtNombre;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Crea el panel de los datos requeridos para la asignación
     */
    public PanelDatosAsignacion( )
    {
        setLayout( new GridLayout( 4, 1, 1, 6 ) );
        setBorder( BorderFactory.createTitledBorder( "Datos del pasajero" ) );

        //Cédula
        JPanel panelCedula = new JPanel( );
        panelCedula.setLayout( new FlowLayout( FlowLayout.RIGHT, 5, 0 ) );
        JLabel etiquetaCedula = new JLabel( "Cédula " );
        txtCedula = new JTextField( );
        txtCedula.setColumns( 15 );
        panelCedula.add( etiquetaCedula );
        panelCedula.add( txtCedula );
        add( panelCedula );

        //Nombre
        JPanel panelNombre = new JPanel( );
        panelNombre.setLayout( new FlowLayout( FlowLayout.RIGHT, 5, 0 ) );
        JLabel etiquetaNombre = new JLabel( "Nombre " );
        txtNombre = new JTextField( );
        txtNombre.setColumns( 15 );
        panelNombre.add( etiquetaNombre );
        panelNombre.add( txtNombre );
        add( panelNombre );

        //Ubicación en el avión
        JPanel pUbicacion = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
        pUbicacion.setPreferredSize( new Dimension( 250, 30 ) );
        JLabel lUbicacion = new JLabel( "Ubicación " );
        cbUbicacion = new JComboBox( );
        cbUbicacion.setAlignmentX( Component.LEFT_ALIGNMENT );
        cbUbicacion.setPreferredSize( txtCedula.getPreferredSize( ) );
        cbUbicacion.addActionListener( this );
        pUbicacion.add( lUbicacion );
        pUbicacion.add( cbUbicacion );

        //Clase de silla
        JPanel pClase = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
        pClase.setPreferredSize( new Dimension( 250, 30 ) );
        JLabel lClase = new JLabel( "Clase " );
        cbClase = new JComboBox( );
        cbClase.setAlignmentX( Component.LEFT_ALIGNMENT );
        cbClase.addActionListener( this );
        cbClase.addItem( CLASE_ECONOMICA );
        cbClase.addItem( CLASE_EJECUTIVA );
        cbClase.setPreferredSize( txtCedula.getPreferredSize( ) );
        pClase.add( lClase );
        pClase.add( cbClase );

        add( pClase );
        add( pUbicacion );
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Retorna el contenido del campo nombre en el panel
     * @return valor del campo nombre
     */
    public String darNombre( )
    {
        return txtNombre.getText( );
    }

    /**
     * Retorna el contenido del campo cédula en el panel
     * @return valor del campo cédula
     */
    public String darCedula( )
    {
        return txtCedula.getText( );
    }

    /**
     * Retorna la clase de la silla elegida en el panel
     * @return clase de la silla - clase pertenece {CLASE_EJECUTIVA,CLASE_ECONOMICA}
     */
    public int darClase( )
    {
        String sClase = ( String )cbClase.getSelectedItem( );
        if( sClase.equals( CLASE_EJECUTIVA ) )
            return Silla.CLASE_EJECUTIVA;
        else
            return Silla.CLASE_ECONOMICA;
    }

    /**
     * Retorna la ubicación de la silla elegida en el panel
     * @return ubicación - Si clase = CLASE_EJECUTIVA entonces ubicación pertenece {VENTANA, PASILLO} ó Si clase = CLASE_ECONOMICA entonces ubicación pertenece {VENTANA,
     *         CENTRO, PASILLO}
     */
    public char darUbicacion( )
    {
        String sUbicacion = ( String )cbUbicacion.getSelectedItem( );
        if( sUbicacion.equals( UBICACION_VENTANA ) )
            return Silla.VENTANA;
        else if( sUbicacion.equals( UBICACION_PASILLO ) )
            return Silla.PASILLO;
        else
            return Silla.CENTRAL;
    }

    /**
     * Acciones de respuesta a los eventos en el combo de las clases
     * @param evento - evento generado por el combo
     */
    public void actionPerformed( ActionEvent evento )
    {
        if( evento.getSource( ) == cbClase )
        {
            String sClase = ( String )cbClase.getSelectedItem( );

            if( sClase.equals( CLASE_EJECUTIVA ) )
            {
                cbUbicacion.removeAllItems( );
                cbUbicacion.addItem( UBICACION_VENTANA );
                cbUbicacion.addItem( UBICACION_PASILLO );
            }
            else
            {
                cbUbicacion.removeAllItems( );
                cbUbicacion.addItem( UBICACION_VENTANA );
                cbUbicacion.addItem( UBICACION_CENTRO );
                cbUbicacion.addItem( UBICACION_PASILLO );
            }
            cbUbicacion.validate( );
        }
    }
}
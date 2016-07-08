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
 * Representación gráfica de una silla del avión
 */
public class SillaGrafica extends JPanel
{
    //-----------------------------------------------------------------
    // Atributos de Interfaz
    //-----------------------------------------------------------------
    /**
     * Imagen de la silla
     */
    private ImageIcon imagen;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Crea la representación gráfica de la silla <br>
     * <b>post: </b> la imagen de la silla distingue si está libre u ocupada
     * @param silla - silla a representar - silla != null
     */
    public SillaGrafica( Silla silla )
    {
        super( new BorderLayout( ) );
        JLabel lSilla = new JLabel( );
        if( silla.darClase( ) == Silla.CLASE_EJECUTIVA && silla.sillaAsignada( ) )
            imagen = new ImageIcon( "data/imagenes/silla-ejec-asig.gif" );
        else if( silla.darClase( ) == Silla.CLASE_EJECUTIVA && !silla.sillaAsignada( ) )
            imagen = new ImageIcon( "data/imagenes/silla-ejec-libre.gif" );
        else if( silla.darClase( ) == Silla.CLASE_ECONOMICA && silla.sillaAsignada( ) )
            imagen = new ImageIcon( "data/imagenes/silla-econ-asig.gif" );
        else if( silla.darClase( ) == Silla.CLASE_ECONOMICA && !silla.sillaAsignada( ) )
        {
            imagen = new ImageIcon( "data/imagenes/silla-econ-libre.gif" );
            lSilla.setForeground( Color.white );
        }
        setPreferredSize( new Dimension( imagen.getIconWidth( ), imagen.getIconHeight( ) ) );
        setOpaque( false );
        lSilla.setPreferredSize( new Dimension( imagen.getIconWidth( ), imagen.getIconHeight( ) ) );
        lSilla.setText( "" + silla.darNumero( ) );
        lSilla.setHorizontalAlignment( SwingConstants.CENTER );
        add( lSilla );
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------
    /**
     * Dibuja la imagen de la silla
     * @param grafica gráfica de la silla
     */
    public void paint( Graphics grafica )
    {
        grafica.drawImage( imagen.getImage( ), 0, 0, null, null );
        super.paint( grafica );
    }
}
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
import java.text.*;
import java.util.ArrayList;

import javax.swing.*;

import uniandes.cupi2.avion.mundo.*;

/**
 * Ventana principal del avión
 */
public class InterfazAvion extends JFrame
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
	 * Panel que contiene el avión
	 */
	private PanelAvion panelAvion;

	/**
	 * Panel de botones
	 */
	private PanelBotonesAvion panelBotones;

	/**
	 * Dialogo de nuevo pasajero
	 */
	private DialogoAsignacion dAsignacion;

	//-----------------------------------------------------------------
	// Constructores
	//-----------------------------------------------------------------

	/**
	 * Crea la interfaz del avión <br>
	 * <b>post: </b> Se crea el avión y se presenta en una gráfica su estado inicial.
	 */
	public InterfazAvion( )
	{
		//Crea al avión
		avion = new Avion( );

		//Configura la interfaz
		setLayout( new BorderLayout( ) );

		//Panel de botones
		panelBotones = new PanelBotonesAvion( this );
		add( panelBotones, BorderLayout.NORTH );

		//Panel del avión
		panelAvion = new PanelAvion( avion );
		add( panelAvion, BorderLayout.CENTER );

		String titulo = "El Avión";
		setTitle( titulo );
		pack( );
		setResizable( false );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

	//-----------------------------------------------------------------
	// Métodos
	//-----------------------------------------------------------------

	/**
	 * Procesa el registro un pasajero
	 */
	public void registrarPasajero( )
	{
		dAsignacion = new DialogoAsignacion( this, avion );
		dAsignacion.setLocation( calculaPosicionCentral( this, dAsignacion ) );
		dAsignacion.setModal( true );
		dAsignacion.setVisible( true );
		actualizar( );
	}

	/**
	 * Procesa la anulación del registro de un pasajero
	 */
	public void anularPasajero( )
	{
		//Pregunta el numero de cédula
		int cedula;
		String sCedula = JOptionPane.showInputDialog( this, "Ingrese el número de cédula" );
		try
		{
			cedula = Integer.parseInt( sCedula );
		}
		catch( NumberFormatException e )
		{
			JOptionPane.showMessageDialog( this, "Error en el número de cédula.", "Anulación", JOptionPane.ERROR_MESSAGE );
			return;
		}

		Pasajero pasajero = new Pasajero( cedula, "no importa" );
		if( !avion.desasignarSilla( pasajero ) )
		{
			JOptionPane.showMessageDialog( this, "El pasajero no tenía silla asignada", "Anulación", JOptionPane.ERROR_MESSAGE );
			return;
		}

		actualizar( );
	}

	/**
	 * Muestra el porcentaje de ocupación que tiene el avión
	 */
	public void mostrarPorcentajeOcupacion( )
	{
		double porcentaje;
		porcentaje = avion.calcularPorcentajeOcupacion( );
		DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
		df.applyPattern( "###.##" );
		JOptionPane.showMessageDialog( this, "El porcentaje de ocupación es " + df.format( porcentaje ) + "%", "Ocupación del avión", JOptionPane.INFORMATION_MESSAGE );
	}

	/**
	 * Procesa la búsqueda de un pasajero
	 */
	public void buscarPasajero( )
	{
		// Pregunta el numero de cédula
		int cedula;
		String sCedula = JOptionPane.showInputDialog( this, "Ingrese el número de cédula" );
		try
		{
			cedula = Integer.parseInt( sCedula );
		}
		catch( NumberFormatException e )
		{
			JOptionPane.showMessageDialog( this, "Error en el número de cédula.", "Anulación", JOptionPane.ERROR_MESSAGE );
			return;
		}
		Pasajero pasajero = new Pasajero( cedula, "no importa" );

		Silla silla = avion.buscarPasajero( pasajero );

		if( silla != null )
		{
			VentanaDatosPasajero vDatos = new VentanaDatosPasajero( silla );
			vDatos.setLocation( calculaPosicionCentral( this, vDatos ) );
			vDatos.setVisible( true );

		}
		else
		{
			JOptionPane.showMessageDialog( this, "El pasajero no se encuentra registrado", "Búsqueda registro", JOptionPane.INFORMATION_MESSAGE );
			return;
		}
	}

	/**
	 * Método 1 de extensión para el ejemplo
	 */
	public void reqFuncOpcion1( )
	{
		String respuesta = avion.metodo1( );
		JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
	}

	/**
	 * Método 2 de extensión para el ejemplo
	 */
	public void reqFuncOpcion2( )
	{
		String respuesta = avion.metodo2( );
		JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
	}

	/**
	 * Repinta la gráfica del avión
	 */
	public void actualizar( )
	{
		remove( panelAvion );

		//Panel del avión
		panelAvion = new PanelAvion( avion );
		add( panelAvion, BorderLayout.CENTER );
		validate( );
	}

	/**
	 * Calcula el punto central entre dos componentes
	 * @param componentePadre - Componente padre sobre el que se calcula el centro - componentePadre != null
	 * @param componenteHijo - Componente hijo que se centra sobre el padre - componenteHijo != null
	 * @return Punto central para ubicar al componente hijo
	 */
	private Point calculaPosicionCentral( Component componentePadre, Component componenteHijo )
	{

		//Centra la ventana y asegura que no sea mayor que la resolución actual
		Dimension tamanhoPantalla = Toolkit.getDefaultToolkit( ).getScreenSize( );
		int maxY = tamanhoPantalla.height;
		int minY = 0;

		//Tamaño de la resolución de la pantalla
		Dimension tamanhoPadre = componentePadre.getSize( );
		Point locacionPadre = componentePadre.getLocation( );
		Dimension tamanhoHijo = componenteHijo.getSize( );
		int x = ( tamanhoPadre.width - tamanhoHijo.width ) / 2 + locacionPadre.x;
		int y = ( tamanhoPadre.height - tamanhoHijo.height ) / 2 + locacionPadre.y;

		// Ajuste para abajo
		if( y + tamanhoHijo.height > maxY )
		{
			y = maxY - tamanhoHijo.height;
		}

		// Ajuste para arriba
		if( y < minY )
		{
			y = 0;
		}
		return new Point( x, y );
	}

	/**
	 * Método principal de ejecución
	 * @param args - argumentos de ejecución - no requiere.
	 */
	public static void main( String[] args )
	{
		InterfazAvion interfaz = new InterfazAvion( );
		interfaz.setVisible( true );
	}

	/**
	 * Agrega una película a un pasajero.
	 */
	public void agregarPelicula(int cedula, String nombre, String genero, int duracion, String director) 
	{
		Silla silla = avion.buscarPasajero(new Pasajero(cedula, "no importa"));
		if(silla!=null)
		{
			silla.darPasajero().agregarPelicula(nombre, genero, duracion, director);
			JOptionPane.showMessageDialog( this, "La película fue agregada exitosamente.", "Agregar película", JOptionPane.INFORMATION_MESSAGE );
		}
		else
		{
			JOptionPane.showMessageDialog( this, "No existe pasajero con la cédula dada", "Buscar películas", JOptionPane.INFORMATION_MESSAGE );
		}
	}

	/**
	 * Muestra el diálogo para agregar una película.
	 */
	public void mostrarDialogoAgregarPelicula()
	{
		DialogoAgregarPelicula dialogo = new DialogoAgregarPelicula(this);
		dialogo.setLocationRelativeTo(this);
		dialogo.setVisible(true);
	}

	/**
	 * Buscar las películas de un pasajero.
	 */
	public void buscarPeliculas() 
	{
		String cedula = JOptionPane.showInputDialog(this, "Ingrese la cédula del pasajero:","Cédula pasajero", JOptionPane.QUESTION_MESSAGE);
		try{
			int ced = Integer.parseInt(cedula);
			Silla silla = avion.buscarPasajero(new Pasajero(ced, "no importa"));
			if(silla!=null)
			{
				ArrayList lista=silla.darPasajero().darPeliculas();
				String rta="Las películas vistas por el pasajero son:\n";
				for (int i = 0; i < lista.size(); i++) 
				{
					Pelicula act= (Pelicula) lista.get(i);
					rta+=act.toString();
					rta+="\n";
				}
				if(lista.size()==0)
				{
					rta="El pasajero no tiene películas.";
				}
				JOptionPane.showMessageDialog(this, rta,"Películas pasajero", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog( this, "No existe pasajero con la cédula dada", "Buscar películas", JOptionPane.INFORMATION_MESSAGE );
			}
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this,"Debe ingresar un valor válido para la cédula.","Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Calcula la duración total de las películas de todos los pasajeros del avión.
	 */
	public void duracionTotalPeliculas() 
	{
		int cuanto = avion.darDuracionTotalPeliculas();
		String rta = "La duración total de las películas en el avión es: " + cuanto + " minutos.";
		JOptionPane.showMessageDialog(this, rta, "Duración total películas", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Muestra el diálogo que da todas las películas de un género para un pasajero determinado.
	 */
	public void mostrarDialogoPeliculasGenero() 
	{
		DialogoPeliculasGenero dialogo = new DialogoPeliculasGenero(this);
		dialogo.setLocationRelativeTo(this);
		dialogo.setVisible(true);
	}

	/**
	 * Muestra en un diálogo las películas que pertenecen a un determiando género y son de algún pasajero determinado por parámetro.
	 * @param cedula Cédula del pasajero.
	 * @param genero Género al cual pertenece la película.
	 */
	public void peliculasGenero(int cedula, String genero)
	{
		Silla silla = avion.buscarPasajero(new Pasajero(cedula, "no importa"));
		if(silla!=null)
		{
			ArrayList lista = silla.darPasajero().darPeliculasGenero(genero);
			String rta="Las películas vistas por el pasajero son:\n";
			for (int i = 0; i < lista.size(); i++) 
			{
				Pelicula act= (Pelicula) lista.get(i);
				rta+=act.toString();
				rta+="\n";
			}
			if(lista.size()==0)
			{
				rta="El pasajero no tiene películas.";
			}
			JOptionPane.showMessageDialog(this, rta,"Películas pasajero", JOptionPane.INFORMATION_MESSAGE);
			
		}
		else
		{
			JOptionPane.showMessageDialog(this,"No existe un pasajero con esa cédula.","Error", JOptionPane.ERROR_MESSAGE);
			
		}
	}

	/**
	 * Determina si un pasajero específico tiene dos películas con la misma duración.
	 */
	public void peliculasMismaDuracion() 
	{
		String cedula = JOptionPane.showInputDialog(this, "Ingrese la cédula del pasajero:","Cédula pasajero", JOptionPane.QUESTION_MESSAGE);
		try
		{
			int ced = Integer.parseInt(cedula);
			Silla silla = avion.buscarPasajero(new Pasajero(ced, "no importa"));
			if(silla!=null)
			{
				boolean tiene =silla.darPasajero().tienePeliculasMismaDuracion();
				
				String rta="";
				if(tiene == true)
				{
					rta= "El pasajero tiene películas con la misma duración.";
				}
				else
				{
					rta= "El pasajero no tiene películas con la misma duración.";
				}
				JOptionPane.showMessageDialog(this, rta, "Películas de misma duración", JOptionPane.INFORMATION_MESSAGE);

			}
			else
			{
				JOptionPane.showMessageDialog(this,"No existe un pasajero con esa cédula.","Error", JOptionPane.ERROR_MESSAGE);
				
			}
			
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this,"Debe ingresar un valor válido para la cédula.","Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
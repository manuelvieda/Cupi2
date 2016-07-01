/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_estudiante
 * Autor: Equipo Cupi2 2016
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.estudiante.interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Panel que tiene la extensión de los botones opción 1 y 2.
 */
public class PanelExtension extends JPanel implements ActionListener {
	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Comando para la opción 1.
	 */
	private static final String OPCION1 = "OPCION_1";

	/**
	 * Comando para la opción 2.
	 */
	private static final String OPCION2 = "OPCION_2";

	// -----------------------------------------------------------------
	// Atributos de Interfaz
	// -----------------------------------------------------------------

	/**
	 * Botón para el punto de extensión 1
	 */
	private JButton botonOpcion1;

	/**
	 * Botón para el punto de extensión 2
	 */
	private JButton botonOpcion2;

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Instancia del la clase principal de la interfaz
	 */
	private InterfazEstudiante principal;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Crea el Panel que tiene los botones de extensión.
	 * @param ventana Ventana principal de la aplicación. ventana!=null
	 */
	public PanelExtension(InterfazEstudiante ventana) {

		principal = ventana;
		// Inicialización de Botones
		setLayout(new GridLayout(1, 2));

		botonOpcion1 = new JButton("Opción 1");
		botonOpcion1.setActionCommand(OPCION1);
		botonOpcion1.addActionListener(this);
		botonOpcion2 = new JButton("Opción 2");
		botonOpcion2.setActionCommand(OPCION2);
		botonOpcion2.addActionListener(this);

		add(botonOpcion1);
		add(botonOpcion2);
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Listener que se encarga de capturar eventos ejecutados por el usuario. <br>
	 * @param e - Evento realizado por el usuario - e!=null <br>
	 */
	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();

		if (comando.equals(OPCION1)) {
			principal.reqFuncOpcion1();
		} else if (comando.equals(OPCION2)) {
			principal.reqFuncOpcion2();
		}

	}
}

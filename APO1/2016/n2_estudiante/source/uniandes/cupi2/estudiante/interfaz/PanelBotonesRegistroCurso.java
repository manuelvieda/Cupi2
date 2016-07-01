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
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 * Panel que crea el botón para el ingreso de un curso
 */
public class PanelBotonesRegistroCurso extends JPanel implements ActionListener {

	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	private static final String CANCELAR = "CANCELAR";

	private static final String ACEPTAR = "ACEPTAR";

	// -----------------------------------------------------------------
	// Atributos de Interfaz
	// -----------------------------------------------------------------

	/**
	 * Botón para cancelar
	 */
	private JButton botonCancelar;

	/**
	 * Botón para aceptar
	 */
	private JButton botonAceptar;

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Instancia del Diálogo al que pertenece
	 */
	private DialogoRegistroCurso padre;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Crea el Panel donde se crea el botón para ingresar el curso
	 * @param elPadre - instancia del diálogo contendor - elPadre!=null
	 */
	public PanelBotonesRegistroCurso(DialogoRegistroCurso elPadre) {

		padre = elPadre;

		botonAceptar = new JButton();
		botonCancelar = new JButton();

		inicializarBotones(botonAceptar, "Registrar", ACEPTAR, Color.BLACK, KeyEvent.VK_E);
		inicializarBotones(botonCancelar, "Cancelar", CANCELAR, Color.BLACK, KeyEvent.VK_R);

		setLayout(new GridLayout(1, 2, 1, 8));

		// Adiciona los botones
		add(botonAceptar);
		add(botonCancelar);

	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Define las propiedades para un botón. <br>
	 * @param boton - Botón al cual se le definen las propiedades - boton!=null
	 * @param etiqueta - Texto de presentación del botón - etiqueta!= null
	 * @param comando - Acción asociada al botón - comando!= null
	 * @param colorFondo - Color del texto de presentación - colorFondo!= null
	 * @param evento - keyevent para la acción del botón - evento!=null
	 */

	private void inicializarBotones(JButton boton, String etiqueta, String comando, Color colorFondo, int evento) {

		boton.setText(etiqueta);
		boton.setFocusable(false);
		boton.setActionCommand(comando);
		boton.addActionListener(this);
		boton.setForeground(colorFondo);
		boton.setMnemonic(evento);
		boton.setDefaultCapable(false);

	}

	/**
	 * Listener que se encarga de capturar eventos ejecutados por el usuario. <br>
	 * @param e - Evento realizado por el usuario - e!=null <br>
	 */

	public void actionPerformed(ActionEvent e) {

		String actionCommand = e.getActionCommand();

		if (ACEPTAR.equals(actionCommand)) {
			padre.registrar();

		}
		if (CANCELAR.equals(actionCommand)) {
			padre.cancelar();

		}

	}

}

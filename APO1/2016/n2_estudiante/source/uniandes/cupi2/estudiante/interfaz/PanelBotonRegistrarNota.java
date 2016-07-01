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
 * Panel que contiene el botón para la asignación de una nota
 */
public class PanelBotonRegistrarNota extends JPanel implements ActionListener {
	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	private static final String REGISTRAR = "REGISTRAR_NOTA";

	private static final String CANCELAR = "CANCELAR";

	// -----------------------------------------------------------------
	// Atributos de Interfaz
	// -----------------------------------------------------------------

	/**
	 * Botón para registrar la nota
	 */
	private JButton botonRegistrar;

	/**
	 * Botón para cancelar
	 */
	private JButton botonCancelar;

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Instancia del la clase Dialogo Contenedora
	 */
	private DialogoNotaCurso padre;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Crea el Panel donde se coloca el botón para asignar la nota
	 * @param elPadre - instancia del diálogo contenedor - elPadre!=null
	 */
	public PanelBotonRegistrarNota(DialogoNotaCurso elPadre) {

		padre = elPadre;

		botonRegistrar = new JButton();
		botonCancelar = new JButton();

		inicializarBotones(botonRegistrar, "Registrar Nota", REGISTRAR, Color.BLACK, KeyEvent.VK_A);
		inicializarBotones(botonCancelar, "Cancelar", CANCELAR, Color.BLACK, KeyEvent.VK_R);
		setLayout(new GridLayout(1, 2, 1, 8));

		// Adiciona los botones
		add(botonRegistrar);
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
	 * Respuesta a los eventos ejecutados por el usuario. <br>
	 * @param evento - Evento realizado por el usuario - evento!=null <br>
	 */

	public void actionPerformed(ActionEvent evento) {

		String actionCommand = evento.getActionCommand();

		if (REGISTRAR.equals(actionCommand))
			padre.asignarNotaCurso();
		else if (CANCELAR.equals(actionCommand))
			padre.cancelar();
	}

}

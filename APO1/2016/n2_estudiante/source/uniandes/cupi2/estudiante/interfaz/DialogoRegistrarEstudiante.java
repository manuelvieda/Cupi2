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
 *Dialogo para registrar el estudiante
 */
public class DialogoRegistrarEstudiante extends JDialog implements ActionListener {

	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Comando para aceptar.
	 */
	private static final String ACEPTAR = "ACEPTAR";

	/**
	 * Comando para la cancelar.
	 */
	private static final String CANCELAR = "CANCELAR";

	// -----------------------------------------------------------------
	// Atributos de Interfaz
	// -----------------------------------------------------------------

	/**
	 * Botón para el aceptar.
	 */
	private JButton botonAceptar;

	/**
	 * Botón para cancelar.
	 */

	private JButton botonCancelar;

	/**
	 * Panel para ingresar los datos
	 */
	private PanelRegistroEstudiante panelRegistro;

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
	 * Crea un nuevo dialogo.
	 * @param ventana Ventana principal de la aplicacion.
	 */
	public DialogoRegistrarEstudiante(InterfazEstudiante ventana) {

		principal = ventana;
		setLayout(new BorderLayout());
		setSize(250, 200);

		panelRegistro = new PanelRegistroEstudiante();
		add(panelRegistro, BorderLayout.CENTER);

		JPanel panelSur = new JPanel();
		panelSur.setLayout(new GridLayout(1, 2, 3, 3));
		botonAceptar = new JButton("Aceptar");
		botonAceptar.setActionCommand(ACEPTAR);
		botonAceptar.addActionListener(this);
		panelSur.add(botonAceptar);
		botonCancelar = new JButton("Cancelar");
		botonCancelar.setActionCommand(CANCELAR);
		botonCancelar.addActionListener(this);
		panelSur.add(botonCancelar);

		add(panelSur, BorderLayout.SOUTH);
	}

	// -----------------------------------------------------------------
	// M�todos
	// -----------------------------------------------------------------

	/**
	 * Listener que se encarga de capturar eventos ejecutados por el usuario. <br>
	 * @param e - Evento realizado por el usuario - e!=null <br>
	 */
	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();

		if (comando.equals(ACEPTAR)) {
			principal.registrarEstudiante(panelRegistro.darCodigo(), panelRegistro.darNombre(),
					panelRegistro.darApellido());
			dispose();
		} else if (comando.equals(CANCELAR)) {
			dispose();
		}

	}
}

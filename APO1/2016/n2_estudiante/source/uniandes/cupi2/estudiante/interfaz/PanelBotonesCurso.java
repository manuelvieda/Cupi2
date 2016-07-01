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
import javax.swing.border.TitledBorder;

/**
 * Panel que contiene los botones de interacción con el usuario
 */
public class PanelBotonesCurso extends JPanel implements ActionListener {
	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	private static final String PRUEBA = "PRUEBA";

	private static final String REGISTRARCURSO = "REGISTRAR_CURSO";

	private static final String REGISTRARNOTA = "REGISTRAR_NOTA";

	private static final String CURSO_PENSUM = "CURSO_PENSUM";

	private static final String VER = "VER_CURSOS";

	// -----------------------------------------------------------------
	// Atributos de Interfaz
	// -----------------------------------------------------------------

	/**
	 * Botón para calcular el promedio
	 */
	private JButton botonCalcular;

	/**
	 * Botón para registrar un curso
	 */
	private JButton botonIngresarCurso;

	/**
	 * Botón para registrar una nota
	 */
	private JButton botonIngresarNota;

	/**
	 * Botón para saber si un curso pertenece al pensum
	 */
	private JButton botonCursoVisto;

	/**
	 * Botón para ver la lista de cursos
	 */
	private JButton botonVerCursos;

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Instancia del la clase principal de la interfaz
	 */
	private InterfazEstudiante padre;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Crea el Panel donde se crearán todos los botones de la interfaz
	 * @param elPadre - instancia del panel contendor - elPadre!=null
	 */
	public PanelBotonesCurso(InterfazEstudiante elPadre) {

		padre = elPadre;
		// Inicialización de Botones
		botonCalcular = new JButton();

		botonIngresarCurso = new JButton();

		botonIngresarNota = new JButton();

		botonCursoVisto = new JButton();
		botonVerCursos = new JButton();

		inicializarBotones(botonCalcular, "Prueba académica?", PRUEBA, Color.BLACK, KeyEvent.VK_C);
		inicializarBotones(botonIngresarCurso, "Registrar curso", REGISTRARCURSO, Color.BLACK, KeyEvent.VK_N);
		inicializarBotones(botonIngresarNota, "Registrar nota", REGISTRARNOTA, Color.BLACK, KeyEvent.VK_O);
		inicializarBotones(botonCursoVisto, "Curso en pensum?", CURSO_PENSUM, Color.BLACK, KeyEvent.VK_Y);
		inicializarBotones(botonVerCursos, "Ver cursos", VER, Color.BLACK, KeyEvent.VK_V);
		setLayout(new GridLayout(6, 1));
		setBorder(new TitledBorder("Cursos"));

		add(botonCalcular);

		add(botonIngresarCurso);

		add(botonIngresarNota);
		add(botonCursoVisto);
		add(botonVerCursos);
		add(new JLabel());

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

		if (PRUEBA.equals(actionCommand))
			padre.estudianteEnPrueba();
		else if (REGISTRARCURSO.equals(actionCommand))
			padre.ingresarCurso();
		else if (REGISTRARNOTA.equals(actionCommand))
			padre.asignarNotaCurso();
		else if (CURSO_PENSUM.equals(actionCommand))
			padre.cursoEnPensum();
		else if (VER.equals(actionCommand))
			padre.verCursos();

	}

}

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
import javax.swing.*;

/**
 * Panel que asigna una nota al curso
 */
public class PanelRegistrarNota extends JPanel {

	// -----------------------------------------------------------------
	// Atributos de Interfaz
	// -----------------------------------------------------------------

	/**
	 * Etiqueta Nota
	 */
	private JLabel etiquetaNota;

	/**
	 * Etiqueta Código del Curso
	 */
	private JLabel etiquetaCodigoCurso;

	/**
	 * Campo para mostrar la nota
	 */
	private JTextField campoNota;

	/**
	 * Campo para mostrar el código del curso
	 */
	private JTextField campoCodigoCurso;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Crea el Panel donde se organizaran los objetos para asignar la nota a un curso
	 */
	public PanelRegistrarNota() {

		setBorder(javax.swing.BorderFactory
				.createTitledBorder(null, "Nota Curso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
		setLayout(new GridLayout(4, 2));
		// Campo donde ira la nota del curso
		campoNota = new JTextField();
		// Campo donde ira el codígo del curso
		campoCodigoCurso = new JTextField();

		// Campos de Ingreso de datos
		etiquetaCodigoCurso = new JLabel();
		etiquetaNota = new JLabel();

		etiquetaNota.setText("Nota");

		etiquetaCodigoCurso.setText("Código Curso");

		add(etiquetaCodigoCurso);
		add(campoCodigoCurso);
		add(etiquetaNota);
		add(campoNota);

		add(new JLabel(""));// label para generar orden en el Grid

	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Retorna el curso
	 * @return curso - curso != null
	 */
	public String darCurso() {

		return campoCodigoCurso.getText();
	}

	/**
	 * Retorna la nota
	 * @return nota - nota != null
	 */
	public String darNota() {

		return campoNota.getText();
	}

	/**
	 * Limpia el formulario
	 */
	public void limpiar() {

		campoNota.setText("");
		campoCodigoCurso.setText("");
	}
}

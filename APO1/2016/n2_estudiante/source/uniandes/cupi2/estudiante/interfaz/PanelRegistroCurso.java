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
 * Panel que administra el ingreso de un curso
 */
public class PanelRegistroCurso extends JPanel {

	// -----------------------------------------------------------------
	// Atributos de Interfaz
	// -----------------------------------------------------------------

	/**
	 * Etiqueta Nombre
	 */
	private JLabel etiquetaNombre;

	/**
	 * Etiqueta Créditos
	 */
	private JLabel etiquetaCreditos;

	/**
	 * Etiqueta Código del Curso
	 */
	private JLabel etiquetaCodigoCurso;

	/**
	 * Campo para el nombre
	 */
	private JTextField campoNombre;

	/**
	 * Campo para el número de créditos
	 */
	private JTextField campoCreditosCurso;

	/**
	 * Campo para el código del curso
	 */
	private JTextField campoCodigoCurso;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Crea el Panel donde se organizarán los objetos para ingresar un curso al estudiante
	 */
	public PanelRegistroCurso() {

		setBorder(javax.swing.BorderFactory
				.createTitledBorder(null, "Datos Curso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
		setLayout(new GridLayout(5, 0));
		// Campo donde ira el nombre del curso
		campoNombre = new JTextField();
		// Campo donde ira el codígo del curso
		campoCodigoCurso = new JTextField();
		// Campo donde iran los créditos del curso
		campoCreditosCurso = new JTextField();
		// Campos de Registro de datos
		etiquetaCodigoCurso = new JLabel();
		etiquetaNombre = new JLabel();
		etiquetaCreditos = new JLabel();

		etiquetaNombre.setText("Nombre");

		etiquetaCodigoCurso.setText("Código Curso");

		etiquetaCreditos.setText("Créditos");

		add(etiquetaNombre);
		add(campoNombre);
		add(etiquetaCodigoCurso);
		add(campoCodigoCurso);
		add(etiquetaCreditos);
		add(campoCreditosCurso);

		add(new JLabel(""));// label para generar orden el Grid
		add(new JLabel(""));// label para generar orden el Grid
		add(new JLabel(""));// label para generar orden el Grid
		add(new JLabel(""));// label para generar orden el Grid
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Retorna el código del curso
	 * @return código de curso
	 */
	public String darCodigo() {

		return campoCodigoCurso.getText();
	}

	/**
	 * Retorna el nombre del curso
	 * @return nombre de curso
	 */
	public String darNombre() {

		return campoNombre.getText();
	}

	/**
	 * Retorna los créditos del curso
	 * @return créditos
	 */
	public String darCreditos() {

		return campoCreditosCurso.getText();
	}

	/**
	 * Limpia el formulario
	 */
	public void limpiar() {

		campoNombre.setText("");
		campoCreditosCurso.setText("");
		campoCodigoCurso.setText("");
	}

}
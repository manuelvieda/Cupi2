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
 * Panel que administra los datos del estudiante
 */
public class PanelRegistroEstudiante extends JPanel {

	// -----------------------------------------------------------------
	// Atributos de Interfaz
	// -----------------------------------------------------------------

	/**
	 * Etiqueta Nombre
	 */
	private JLabel etiquetaNombre;

	/**
	 * Etiqueta Apellido
	 */
	private JLabel etiquetaApellido;

	/**
	 * Etiqueta Codigo
	 */
	private JLabel etiquetaCodigo;

	/**
	 * Campo para el Apellido
	 */
	private JTextField campoApellido;

	/**
	 * Campo para el Nombre
	 */
	private JTextField campoNombre;

	/**
	 * Campo para el Código
	 */
	private JTextField campoCodigo;

	/**
	 * Botón para registrar el estudiante
	 */
	private JButton botonIngresar;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Crea el Panel donde se organizarán los objetos para ingresar un estudiante
	 * @param ventanaPrincipal ventana principal de la interfaz - ventanaPrincipal != null
	 */
	public PanelRegistroEstudiante() {

		// Configura el color, borde y layout
		setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro de Estudiante",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				null, null));
		setLayout(new GridLayout(3, 2, 5, 5));

		// Datos básicos del estudiante
		campoNombre = new JTextField();
		campoApellido = new JTextField();
		campoCodigo = new JTextField();
		etiquetaNombre = new JLabel("Nombre");
		etiquetaApellido = new JLabel("Apellido");
		etiquetaCodigo = new JLabel("Código");

		add(etiquetaNombre);
		add(campoNombre);
		add(etiquetaApellido);
		add(campoApellido);
		add(etiquetaCodigo);
		add(campoCodigo);

	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Retorna el nombre del estudiante
	 * @return nombre del estudiante - nombre != null
	 */

	public String darNombre() {

		return campoNombre.getText();
	}

	/**
	 * Retorna el apellido del estudiante
	 * @return apellido del estudiante - apellido != null
	 */

	public String darApellido() {

		return campoApellido.getText();
	}

	/**
	 * Retorna el código del estudiante
	 * @return código del estudiante
	 */

	public String darCodigo() {

		return campoCodigo.getText();

	}

}

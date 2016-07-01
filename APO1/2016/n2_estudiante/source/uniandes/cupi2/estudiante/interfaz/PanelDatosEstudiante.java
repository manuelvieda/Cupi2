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
 * Panel usado para calcular el promedio
 */
public class PanelDatosEstudiante extends JPanel implements ActionListener {

	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Comando para la opción 1.
	 */
	private static final String REGISTRAR = "REGISTRAR";

	// -----------------------------------------------------------------
	// Atributos de Interfaz
	// -----------------------------------------------------------------

	/**
	 * Etiqueta Promedio
	 */
	private JLabel etiquetaPromedio;

	/**
	 * Campo donde se muestra el promedio
	 */
	private JTextField campoPromedio;

	/**
	 * Etiqueta código
	 */
	private JLabel etiquetaCodigo;

	/**
	 * Campo donde se muestra el código
	 */
	private JTextField campoCodigo;

	/**
	 * Etiqueta Nombre
	 */
	private JLabel etiquetaNombre;

	/**
	 * Campo donde se muestra el nombre
	 */
	private JTextField campoNombre;

	/**
	 * Etiqueta Apellido
	 */
	private JLabel etiquetaApellido;

	/**
	 * Campo donde se muestra el apellido
	 */
	private JTextField campoApellido;

	/**
	 * Boton para registrar un nuevo estudiante.
	 */
	private JButton btnRegistrar;

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
	 * Crea el Panel donde se organizarán los objetos para calcular el promedio de un estudiante.
	 * @param ventana Ventana principal de la aplicación. ventana!=null
	 */
	public PanelDatosEstudiante(InterfazEstudiante ventana) {

		principal = ventana;
		setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información del Estudiante",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				null, null));
		setLayout(new GridLayout(5, 2, 4, 4));
		// Campo donde ira el codígo del estudiante
		campoCodigo = new JTextField();
		campoCodigo.setEditable(false);
		// Campo donde ira el promedio del estudiante
		campoPromedio = new JTextField();
		campoPromedio.setEditable(false);
		// Campo donde ira el apellido del estudiante
		campoApellido = new JTextField();
		campoApellido.setEditable(false);
		// Campo donde ira el nombre del estudiante
		campoNombre = new JTextField();
		campoNombre.setEditable(false);
		// Campos de Ingreso de datos
		etiquetaPromedio = new JLabel();
		etiquetaCodigo = new JLabel();
		etiquetaNombre = new JLabel();
		etiquetaApellido = new JLabel();

		etiquetaPromedio.setText("Promedio");
		etiquetaCodigo.setText("Código");
		etiquetaNombre.setText("Nombre");
		etiquetaApellido.setText("Apellido");

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setActionCommand(REGISTRAR);

		add(etiquetaCodigo);
		add(campoCodigo);
		add(etiquetaNombre);
		add(campoNombre);
		add(etiquetaApellido);
		add(campoApellido);
		add(etiquetaPromedio);
		add(campoPromedio);
		add(new JLabel());
		add(btnRegistrar);

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

		if (comando.equals(REGISTRAR)) {
			principal.mostrarDialogoRegistrarEstudiante();
		}

	}

	/**
	 * Cambia el valor del campo promedio
	 * @param valor - Valor que tomara el campo Promedio - valor!=null <br>
	 */

	public void asignarPromedio(String valor) {

		campoPromedio.setText(valor);
	}

	/**
	 * Cambia el valor del campo Código
	 * @param valor - Valor que tomará el campo Código - valor!=null <br>
	 */

	public void asignarCodigo(String valor) {

		campoCodigo.setText(valor);
	}

	/**
	 * Cambia el valor del campo Nombre
	 * @param valor - Valor que tomará el campo Nombre - valor!=null <br>
	 */

	public void asignarNombre(String valor) {

		campoNombre.setText(valor);
	}

	/**
	 * Cambia el valor del campo Apellido
	 * @param valor - Valor que tomará el campo Apellido - valor!=null <br>
	 */

	public void asignarApellido(String valor) {

		campoApellido.setText(valor);
	}

}

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
import javax.swing.border.TitledBorder;

/**
 * Panel de la extensión, contiene los botones relacionados con los requerimientos de las actividades extracurriculares. 
 */
public class PanelBotonesActividades extends JPanel implements ActionListener {
	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Comando para agregar actividad.
	 */
	private static final String AGREGAR_ACTIVIDAD = "AGREGAR_ACTIVIDAD";

	/**
	 * Comando para eliminar actividad.
	 */
	private static final String ELIMINAR_ACTIVIDAD = "ELIMINAR_ACTIVIDAD";

	/**
	 * Comando para mostrar actividades.
	 */
	private static final String MOSTRAR_ACTIVIDADES = "MOSTRAR_ACTIVIDADES";

	/**
	 * Comado para mostrar el tipo de actividad con mas tiempo.
	 */
	private static final String TIPO_MAS_TIEMPO = "TIPO_MAS_TIEMPO";

	/**
	 * Comando para mostrar las actividades con mas de 100 horas.
	 */
	private static final String MAS_DE_100 = "MAS_DE_100";

	/**
	 * Comando para mostrar si el estudiante cumple los requisitos de la beca.
	 */
	private static final String CUMPLE_BECA = "CUMPLE_BECA";

	// -----------------------------------------------------------------
	// Atributos de Interfaz
	// -----------------------------------------------------------------

	/**
	 * Botón para el agregar actividad.
	 */
	private JButton btnAgregar;

	/**
	 * Botón para eliminar actividad.
	 */
	private JButton btnEliminar;

	/**
	 * Botón para mostrar actividades.
	 */
	private JButton btnMostrar;

	/**
	 * Botón para mostrar el tipo de actividad con mas tiempo.
	 */
	private JButton btnTipoMasTiempo;

	/**
	 * Botón para mostrar las actividades con mas de 100 horas.
	 */
	private JButton btnActividadesMasDe100;

	/**
	 * Botón para mostrar si el estudiante cumple los requisitos de la beca.
	 */
	private JButton btnBeca;

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
	 * Constructor del panel con los botones.
	 * @param ventana Ventana principal de la aplicación
	 */
	public PanelBotonesActividades(InterfazEstudiante ventana) {

		principal = ventana;
		setBorder(new TitledBorder("Actividades extracurriculares"));
		setLayout(new GridLayout(6, 1));

		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setActionCommand(AGREGAR_ACTIVIDAD);
		add(btnAgregar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setActionCommand(ELIMINAR_ACTIVIDAD);
		add(btnEliminar);

		btnMostrar = new JButton("Mostrar actividades");
		btnMostrar.addActionListener(this);
		btnMostrar.setActionCommand(MOSTRAR_ACTIVIDADES);
		add(btnMostrar);

		btnTipoMasTiempo = new JButton("Tipo más tiempo");
		btnTipoMasTiempo.addActionListener(this);
		btnTipoMasTiempo.setActionCommand(TIPO_MAS_TIEMPO);
		add(btnTipoMasTiempo);

		btnActividadesMasDe100 = new JButton("Más de 100 horas");
		btnActividadesMasDe100.addActionListener(this);
		btnActividadesMasDe100.setActionCommand(MAS_DE_100);
		add(btnActividadesMasDe100);

		btnBeca = new JButton("Beca");
		btnBeca.addActionListener(this);
		btnBeca.setActionCommand(CUMPLE_BECA);
		add(btnBeca);
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

		if (comando.equals(AGREGAR_ACTIVIDAD)) {
			principal.mostrarDialogoAgregarActividad();
		} else if (comando.equals(ELIMINAR_ACTIVIDAD)) {
			principal.eliminarActividad();
		} else if (comando.equals(MOSTRAR_ACTIVIDADES)) {
			principal.mostrarActividades();
		} else if (comando.equals(TIPO_MAS_TIEMPO)) {
			principal.mostrarTipoMasTiempo();
		} else if (comando.equals(MAS_DE_100)) {
			principal.mostrarActividadesMasDe100Horas();
		} else if (comando.equals(CUMPLE_BECA)) {
			principal.mostrarCumpleRequisitosBeca();
		}

	}
}

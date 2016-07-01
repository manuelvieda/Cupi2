/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_estudiante
 * Autor: Equipo Cupi2 2016
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.estudiante.interfaz;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Dialogo para mostrar los cursos vistos
 */
public class DialogoCursos extends JDialog {

	// -----------------------------------------------------------------
	// Atributos de Interfaz
	// -----------------------------------------------------------------

	/**
	 * Es el panel usado para contener la lista
	 */
	private JScrollPane scrollDesplazamiento;

	/**
	 * La lista donde se muestran los cursos
	 */
	private JList listaCursos;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Diálogo donde se muestran los cursos ingresados
	 */
	public DialogoCursos() {

		setBackground(Color.white);
		setTitle("Cursos");
		scrollDesplazamiento = new JScrollPane();

		// Lista donde se almacenaran los cursos
		listaCursos = new JList();
		listaCursos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

		// Scroll que desplegara la lista de Cursos
		scrollDesplazamiento.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollDesplazamiento.setViewportView(listaCursos);
		add(scrollDesplazamiento);
	}

	// -----------------------------------------------------------------
	// M�todos
	// -----------------------------------------------------------------

	/**
	 * Modifica la lista de cursos mostrada
	 * @param cursos La lista con los cursos que se van a mostrar en la lista
	 */
	public void cambiarListaCursos(ArrayList cursos) {

		listaCursos.setListData(cursos.toArray());
	}

}

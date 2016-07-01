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
import javax.swing.*;

import uniandes.cupi2.estudiante.mundo.Curso;

/**
 * Dialogo para el ingreso de una nota
 */
public class DialogoNotaCurso extends JDialog {
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Instancia de la clase principal
	 */
	private InterfazEstudiante padre;

	/**
	 * Curso calificado
	 */
	private Curso curso;

	// -----------------------------------------------------------------
	// Atributos de Interfaz
	// -----------------------------------------------------------------

	/**
	 * Es el panel donde se registra la nota
	 */
	private PanelRegistrarNota panelRegistrarNota;

	/**
	 * Es el panel para controlar el dialogo
	 */
	private PanelBotonRegistrarNota panelBotonRegistrarNota;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Crea el Di�logo donde se organizar�n los paneles de ingreso de una nota
	 * @param elPadre - instancia del panel contendor - elPadre!=null
	 */
	public DialogoNotaCurso(InterfazEstudiante elPadre) {
		// Guarda la referencia al padre
		padre = elPadre;
		curso = null;

		// Configuraci�n del di�logo
		setTitle("Registro Nota");
		setBackground(Color.white);
		setLayout(new BorderLayout());

		// Paneles del di�logo
		panelRegistrarNota = new PanelRegistrarNota();
		panelBotonRegistrarNota = new PanelBotonRegistrarNota(this);
		add(panelRegistrarNota, BorderLayout.NORTH);
		add(panelBotonRegistrarNota, BorderLayout.CENTER);
		setSize(300, 165);

	}

	// -----------------------------------------------------------------
	// M�todos
	// -----------------------------------------------------------------

	/**
	 * Limpia el formulario
	 */
	public void limpiar() {

		panelRegistrarNota.limpiar();
	}

	/**
	 * Cancela el registro
	 */
	public void cancelar() {

		dispose();
	}

	/**
	 * Retorna un curso calificado
	 * @return curso con calificaci�n
	 */
	public Curso darCurso() {

		return curso;
	}

	/**
	 * M�todo que agrega una nota a un curso
	 */
	public void asignarNotaCurso() {

		String nota = panelRegistrarNota.darNota();
		String codigo = panelRegistrarNota.darCurso();
		Curso c;

		curso = null;

		if (nota.equals("") || codigo.equals("")) {
			JOptionPane.showMessageDialog(this, "Debe llenar todos los campos", "Registro nota",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		c = padre.darEstudiante().buscarCurso(codigo);
		if (c == null) {
			JOptionPane.showMessageDialog(this, "El curso no se encuentra registrado", "Registro nota",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (c.estaCalificado()) {
			JOptionPane.showMessageDialog(this, "El curso ya tiene una nota asignada", "Registro nota",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		try {
			double notaCurso = Double.parseDouble(nota);

			if (notaCurso < 1.5 || notaCurso > 5.0) {
				JOptionPane.showMessageDialog(this, "La nota debe estar entre 1.5 y 5.0", "Registro nota",
						JOptionPane.ERROR_MESSAGE);
				return;
			} else {
				curso = new Curso(codigo, "", 0);
				curso.asignarNota(notaCurso);
				dispose();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "El valor de la nota debe ser un n�mero decimal", "Registro nota",
					JOptionPane.ERROR_MESSAGE);
		}

	}

}

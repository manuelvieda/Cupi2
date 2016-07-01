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

import uniandes.cupi2.estudiante.mundo.Curso;

/**
 * Diálogo para el ingreso de un Curso
 */
public class DialogoRegistroCurso extends JDialog {
	// -----------------------------------------------------------------
	// Atributos de la Interfaz
	// -----------------------------------------------------------------

	/**
	 * Formulario del regitro
	 */
	private PanelRegistroCurso panelRegistroCurso;

	/**
	 * Botones del registro
	 */
	private PanelBotonesRegistroCurso panelBotonesRegistroCurso;

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Curso a registar
	 */
	private Curso curso;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Crea el Di�logo donde se organizar�n los paneles de ingreso de curso
	 */
	public DialogoRegistroCurso() {

		setTitle("Registro Curso");
		setBackground(Color.white);
		setLayout(new BorderLayout());
		panelRegistroCurso = new PanelRegistroCurso();
		panelBotonesRegistroCurso = new PanelBotonesRegistroCurso(this);
		add(panelRegistroCurso, BorderLayout.CENTER);
		add(panelBotonesRegistroCurso, BorderLayout.SOUTH);
		setSize(250, 250);
		curso = null;

	}

	// -----------------------------------------------------------------
	// M�todos
	// -----------------------------------------------------------------

	/**
	 * Retorna el curso a registrar
	 * @return Curso a registrar
	 */
	public Curso darCurso() {

		return curso;
	}

	/**
	 * Limpia el formulario
	 */
	public void limpiar() {

		panelRegistroCurso.limpiar();
	}

	/**
	 * Acci�n de registrar el curso
	 */
	public void registrar() {

		String nombreCurso = panelRegistroCurso.darNombre();
		String codigoCurso = panelRegistroCurso.darCodigo();
		String creditosCurso = panelRegistroCurso.darCreditos();
		curso = null;
		int creditos;

		if (nombreCurso.equals("") || codigoCurso.equals("") || creditosCurso.equals("")) {
			JOptionPane.showMessageDialog(this, "Debe llenar todos los campos", "Registro curso",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		try {
			creditos = Integer.parseInt(creditosCurso);
			if (creditos < 0) {
				JOptionPane.showMessageDialog(this, "Los cr�ditos deben ser mayor o igual a cero (0)", "Registro curso",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Si tiene los datos arma un curso para retornar
			curso = new Curso(codigoCurso, nombreCurso, creditos);
			dispose();
		} catch (Exception e) {

			JOptionPane.showMessageDialog(this, "El valor de los cr�ditos debe ser num�rico", "Registro curso",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Cancela el registro
	 */
	public void cancelar() {

		curso = null;
		dispose();
	}
}

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
 * Dialogo para agregar una actividad extracurricular.
 */
public class DialogoAgregarActividad extends JDialog implements ActionListener {
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
	// Atributos de la Interfaz
	// -----------------------------------------------------------------

	/**
	 * Etiqueta nombre de la actividad.
	 */
	private JLabel lblNombre;

	/**
	 * Campo de texto nombre de la actividad.
	 */
	private JTextField txtNombre;

	/**
	 * Etiqueta tipo de la actividad.
	 */
	private JLabel lblTipo;

	/**
	 * Combo de tipos de actividad
	 */
	private JComboBox comboTipo;

	/**
	 * Etiqueta horas dedicadas de la actividad.
	 */
	private JLabel lblHorasDedicadas;

	/**
	 * Campo de texto  horas dedicadas de la actividad.
	 */
	private JTextField txtHorasDedicadas;

	/**
	 * Botón para el aceptar.
	 */
	private JButton botonAceptar;

	/**
	 * Botón para cancelar.
	 */

	private JButton botonCancelar;

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Ventana principal de la aplicación.
	 */
	private InterfazEstudiante principal;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Construye el diálogo para agregar una actividad.
	 * @param ventana Venta principal de la aplicación.
	 */
	public DialogoAgregarActividad(InterfazEstudiante ventana) {

		principal = ventana;
		setLayout(new BorderLayout());
		setTitle("Agregar actividad");
		setSize(250, 150);

		JPanel panelCentro = new JPanel();
		panelCentro.setLayout(new GridLayout(3, 2, 3, 3));
		lblNombre = new JLabel("Nombre");
		panelCentro.add(lblNombre);
		txtNombre = new JTextField();
		panelCentro.add(txtNombre);
		lblTipo = new JLabel("Tipo");
		panelCentro.add(lblTipo);
		comboTipo = new JComboBox();
		comboTipo.addItem("Trabajo social");
		comboTipo.addItem("Deportivo");
		comboTipo.addItem("Académico");
		panelCentro.add(comboTipo);
		lblHorasDedicadas = new JLabel("Horas dedicadas");
		panelCentro.add(lblHorasDedicadas);
		txtHorasDedicadas = new JTextField();
		panelCentro.add(txtHorasDedicadas);
		add(panelCentro);

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
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Listener que se encarga de capturar eventos ejecutados por el usuario. <br>
	 * @param e - Evento realizado por el usuario - e!=null <br>
	 */
	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();

		if (comando.equals(ACEPTAR)) {
			String nombre = txtNombre.getText();
			String horasStr = txtHorasDedicadas.getText();
			String tipo = (String) comboTipo.getSelectedItem();
			if (nombre.equals("")) {
				JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío.");
			} else if (horasStr.equals("")) {
				JOptionPane.showMessageDialog(this, "Las horas dedicadas no pueden estar vacías.");
			} else {
				try {
					int horas = Integer.parseInt(horasStr);
					principal.agregarActividad(nombre, tipo, horas);
					dispose();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(this, "Las  horas dedicas deben ser un número.");
				}

			}

		} else if (comando.equals(CANCELAR)) {
			dispose();
		}

	}

}

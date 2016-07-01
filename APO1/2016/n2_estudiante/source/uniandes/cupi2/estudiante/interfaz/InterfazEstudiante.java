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
import java.util.ArrayList;
import javax.swing.*;

import uniandes.cupi2.estudiante.mundo.Actividad;
import uniandes.cupi2.estudiante.mundo.Curso;
import uniandes.cupi2.estudiante.mundo.Estudiante;

/**
 * Ventana principal de la interfaz del Estudiante
 */
public class InterfazEstudiante extends JFrame {

	// -----------------------------------------------------------------
	// Atributos de Interfaz
	// -----------------------------------------------------------------

	/**
	 * Es el panel donde se muestran los datos del estudiante
	 */
	private PanelDatosEstudiante panelDatos;

	/**
	 * El panel donde se ven los botones para controlar la aplicación
	 */
	private PanelBotonesCurso panelBotonesCurso;

	/**
	 * El panel donde se ven los botones para controlar la extensión de actividades extracurriculares
	 */
	private PanelBotonesActividades panelBotonesActividades;

	/**
	 * El diálogo usado para mostrar los cursos
	 */
	private DialogoCursos dialogoCursos;

	/**
	 * El diálogo usado para mostrar las actividades.
	 */
	private DialogoCursos dialogoActividades;

	/**
	 * El diálogo usado para registrar un nuevo curso
	 */
	private DialogoRegistroCurso dialogoRegistroCurso;

	/**
	 * El diálogo usado para registrar la nota de un curso
	 */
	private DialogoNotaCurso dialogoNotaCurso;

	/**
	 * Panel con la imagen del banner.
	 */
	private PanelImagen panelImagen;

	/**
	 * Panel con los botones de extensión.
	 */
	private PanelExtension panelExtension;

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Atributo que representa un estudiante
	 */
	private Estudiante estudiante;

	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------

	/**
	 * Método que inicializa todos los páneles
	 */
	public InterfazEstudiante() {
		// Configura layout y dialogos
		setLayout(new BorderLayout());

		dialogoRegistroCurso = new DialogoRegistroCurso();
		dialogoRegistroCurso.setModal(true);
		dialogoCursos = new DialogoCursos();
		dialogoCursos.setModal(true);
		dialogoActividades = new DialogoCursos();
		dialogoActividades.setModal(true);
		dialogoActividades.setTitle("Actividades");
		dialogoNotaCurso = new DialogoNotaCurso(this);
		dialogoNotaCurso.setModal(true);

		// Panel norte (imagen)
		panelImagen = new PanelImagen();
		add(panelImagen, BorderLayout.NORTH);

		// Panel centro (datos estudiante y requerimientos)
		JPanel panelCentro = new JPanel();
		panelCentro.setLayout(new GridLayout(2, 1));
		JPanel panelSuperiorCentro = new JPanel();
		panelSuperiorCentro.setLayout(new GridLayout(1, 2));
		JLabel imagenEstudiante = new JLabel();
		ImageIcon icono = new ImageIcon("./data/logo.png");
		imagenEstudiante.setIcon(icono);
		panelSuperiorCentro.add(imagenEstudiante);
		panelDatos = new PanelDatosEstudiante(this);
		panelSuperiorCentro.add(panelDatos);
		panelCentro.add(panelSuperiorCentro);

		JPanel panelInferiorCentro = new JPanel();
		panelInferiorCentro.setLayout(new GridLayout(1, 2));
		panelBotonesCurso = new PanelBotonesCurso(this);
		panelInferiorCentro.add(panelBotonesCurso);
		panelBotonesActividades = new PanelBotonesActividades(this);
		panelInferiorCentro.add(panelBotonesActividades);
		panelCentro.add(panelInferiorCentro);
		add(panelCentro, BorderLayout.CENTER);

		// Panel sur (botones de punto de extensión)
		panelExtension = new PanelExtension(this);
		add(panelExtension, BorderLayout.SOUTH);

		// Asigna título, ajusta el tamaño y no lo deja modificar
		setTitle("Estudiante");
		setSize(400, 550);
		setResizable(false);
		setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Registrar al estudiante
	 * @param codigo Codigo del estudiante
	 * @param nombre Nombre del estudiante
	 * @param apellido Apellido del estudiante
	 */
	public void registrarEstudiante(String codigo, String nombre, String apellido) {

		try {
			if (nombre.equals("") || codigo.equals("") || apellido.equals("")) {
				JOptionPane.showMessageDialog(this, "Debe llenar todos los campos", "Registro estudiante",
						JOptionPane.ERROR_MESSAGE);
			} else {
				estudiante = new Estudiante(nombre, apellido, Integer.parseInt(codigo));
				panelDatos.asignarNombre(estudiante.darNombre());
				panelDatos.asignarApellido(estudiante.darApellido());
				panelDatos.asignarCodigo("" + estudiante.darCodigo());
				panelDatos.asignarPromedio(" ");
				JOptionPane.showMessageDialog(this, "Estudiante registrado", "Registro estudiante",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "El valor del código debe ser numérico", "Registro estudiante",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Método que agrega un curso al estudiante
	 */
	public void ingresarCurso() {

		Curso curso;

		// Valida que haya un estudiante a quien registrarle el curso
		if (estudiante == null) {
			JOptionPane.showMessageDialog(this, "Debe ingresar un estudiante primero", "Registro curso",
					JOptionPane.ERROR_MESSAGE);
		}
		// Valida que el estudiante no tenga sus cursos llenos
		else if (estudiante.tieneCursosCompletos()) {
			JOptionPane.showMessageDialog(this, "Los cursos del estudiante están llenos", "Registro curso",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			// Presenta el diálogo de registro
			dialogoRegistroCurso.limpiar();
			dialogoRegistroCurso.setLocation(calculaPosicionCentral(this, dialogoRegistroCurso));
			dialogoRegistroCurso.setVisible(true);

			// Toma el curso dado
			curso = dialogoRegistroCurso.darCurso();

			// Si es nulo no hay ingreso
			if (curso == null) {
				return;
			}

			// Si el curso ya está incluido
			if (estudiante.pensumIncluyeCurso(curso.darCodigoCurso())) {
				JOptionPane.showMessageDialog(this,
						"Un curso de código " + curso.darCodigoCurso() + " ya ha sido asignado", "Registro curso",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			estudiante.asignarCurso(curso);
		}

	}

	/**
	 * Asigna la nota de un curso
	 */
	public void asignarNotaCurso() {

		if (estudiante == null) {
			JOptionPane.showMessageDialog(this, "Debe ingresar un estudiante primero", "Registro nota",
					JOptionPane.ERROR_MESSAGE);
		} else {
			// Presenta el diálogo
			dialogoRegistroCurso.limpiar();
			dialogoNotaCurso.limpiar();
			dialogoNotaCurso.setLocation(calculaPosicionCentral(this, dialogoNotaCurso));
			dialogoNotaCurso.setVisible(true);

			// Toma los datos de la nota del curso
			Curso c = dialogoNotaCurso.darCurso();

			// Si los datos son válidos, se realiza el registro de la nota
			if (c != null) {
				Curso curso = estudiante.buscarCurso(c.darCodigoCurso());
				curso.asignarNota(c.darNota());

				double promedio = estudiante.calcularPromedioEstudiante();
				panelDatos.asignarPromedio(String.valueOf(promedio));
			}
		}
	}

	/**
	 * Indica si el estudiante está en prueba o no
	 */
	public void estudianteEnPrueba() {

		double promedio = 0.0;
		boolean estaPrueba = false;

		if (estudiante == null) {
			JOptionPane.showMessageDialog(this, "Debe ingresar un estudiante primero", "Cálculo promedio",
					JOptionPane.ERROR_MESSAGE);
		} else {

			promedio = estudiante.calcularPromedioEstudiante();
			estaPrueba = estudiante.estudianteEstaPrueba();

			if (promedio == 0.0) {
				JOptionPane.showMessageDialog(this, "Debe registrar al menos la nota de un curso", "Cálculo promedio",
						JOptionPane.INFORMATION_MESSAGE);

			} else {
				if (estaPrueba) {
					JOptionPane.showMessageDialog(this, "El estudiante se encuentra en prueba, promedio < 3.25", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(this, "El estudiante no se encuentra en prueba, promedio >= 3.25",
							"Info", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}

	}

	/**
	 * Método que dice si un curso ya fue visto por un estudiante o no
	 */
	public void cursoEnPensum() {

		if (estudiante == null) {
			JOptionPane.showMessageDialog(this, "Debe ingresar un estudiante primero", "Pensum Estudiante",
					JOptionPane.ERROR_MESSAGE);
		} else {
			// Presenta el diálogo
			String codigo = JOptionPane
					.showInputDialog(this, "Código de curso", "Pensum EStudiante", JOptionPane.QUESTION_MESSAGE);

			if (codigo != null && estudiante.pensumIncluyeCurso(codigo)) {
				JOptionPane.showMessageDialog(this, "El curso " + codigo + " está incluido en el pensum",
						"Pensum Estudiante", JOptionPane.INFORMATION_MESSAGE);
			} else if (codigo != null) {
				JOptionPane.showMessageDialog(this, "El curso " + codigo + " no está incluido en el pensum",
						"Pensum Estudiante", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	/**
	 * Método usado para ver los cursos ingresados
	 */
	public void verCursos() {

		ArrayList cursos = new ArrayList();
		Curso curso = null;
		if (estudiante != null) {
			curso = estudiante.darCurso1();
			if (curso != null) {
				cursos.add(curso.darDescripcion());
			}
			curso = estudiante.darCurso2();
			if (curso != null) {
				cursos.add(curso.darDescripcion());
			}
			curso = estudiante.darCurso3();
			if (curso != null) {
				cursos.add(curso.darDescripcion());
			}
			curso = estudiante.darCurso4();
			if (curso != null) {
				cursos.add(curso.darDescripcion());
			}
			curso = estudiante.darCurso5();
			if (curso != null) {
				cursos.add(curso.darDescripcion());
			}
			dialogoCursos.setSize(450, 200);
			dialogoCursos.cambiarListaCursos(cursos);
			dialogoCursos.setLocation(calculaPosicionCentral(this, dialogoCursos));
			dialogoCursos.setVisible(true);
		} else {
			JOptionPane
					.showMessageDialog(this, "Debe ingresar un estudiante primero", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Calcula el punto que indica la posición centrada del frame
	 * @param componentePadre - Ventana Padre del componente - !=null
	 * @param componenteHijo - Ventana Hija del componente - !=null
	 * @return punto - Localizacion en coordinadas x,y del nuevo componente - !=null
	 */
	private Point calculaPosicionCentral(Component componentePadre, Component componenteHijo) {

		Dimension tamanoPantalla, tamanoPadre, tamanoHijo;
		Point localizacionPadre;

		// Centra la ventana y verifica que no sea mayor que la resolución
		// actual
		tamanoPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int max_y = tamanoPantalla.height;
		int min_y = 0;

		// Tamaño de la resolucion de la pantalla
		tamanoPadre = componentePadre.getSize();
		localizacionPadre = componentePadre.getLocation();
		tamanoHijo = componenteHijo.getSize();
		int x = (tamanoPadre.width - tamanoHijo.width) / 2 + localizacionPadre.x;
		int y = (tamanoPadre.height - tamanoHijo.height) / 2 + localizacionPadre.y;

		// Ajuste para abajo
		if (y + tamanoHijo.height > max_y) {
			y = max_y - tamanoHijo.height;
		}

		// Ajuste para arriba
		if (y < min_y) {
			y = 0;
		}
		return new Point(x, y);
	}

	/**
	 * Método que retorna una instancia del estudiante
	 * @return estudiante - Una instancia de estudiante - estudiante != null
	 */
	public Estudiante darEstudiante() {

		return estudiante;

	}

	/**
	 * Muestra el diálogo para registrar un nuevo estudiante.
	 */
	public void mostrarDialogoRegistrarEstudiante() {

		DialogoRegistrarEstudiante dialogo = new DialogoRegistrarEstudiante(this);
		dialogo.setLocationRelativeTo(this);
		dialogo.setVisible(true);
	}

	/**
	 * Muestra el diálogo para agregar una actividad extracurricular.
	 */
	public void mostrarDialogoAgregarActividad() {

		if (estudiante == null) {
			JOptionPane.showMessageDialog(this, "Debe ingresar un estudiante primero", "Agregar actividad.",
					JOptionPane.ERROR_MESSAGE);
		} else {
			DialogoAgregarActividad dialogo = new DialogoAgregarActividad(this);
			dialogo.setLocationRelativeTo(this);
			dialogo.setVisible(true);
		}

	}

	/**
	 * Agrega una actividad extracurricular con los valores recibidos por parámetro.
	 * @param nombre Nombre de la actividad.
	 * @param tipoStr Tipo de actividad.
	 * @param horas tiempo en horas de dedicación.
	 */
	public void agregarActividad(String nombre, String tipoStr, int horas) {

		int tipo = 1;
		if (tipoStr.equals("Deportivo")) {
			tipo = 2;
		} else if (tipoStr.equals("Académico")) {
			tipo = 3;
		}
		if (horas > 0) {
			boolean agrego = estudiante.agregarActividad(nombre, tipo, horas);
			if (agrego == true) {
				JOptionPane.showMessageDialog(this, "Se agregó la actividad al estudiante correctamente.",
						"Agregar actividad", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane
						.showMessageDialog(this, "No se pudo agregar la actividad al estudiante.", "Agregar actividad",
								JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Las horas deben ser un número positivo.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * Elimina una actividad extracurricular.
	 */
	public void eliminarActividad() {

		if (estudiante == null) {
			JOptionPane.showMessageDialog(this, "Debe ingresar un estudiante primero.", "Eliminar actividad.",
					JOptionPane.ERROR_MESSAGE);
		} else {
			String nombreActividad = JOptionPane.showInputDialog(this, "Nombre de la actividad a eliminar");
			boolean elimino = estudiante.eliminarActividad(nombreActividad);
			if (elimino == true) {
				JOptionPane.showMessageDialog(this, "Se eliminó la actividad al estudiante correctamente.",
						"Eliminar actividad", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this,
						"No se pudo eliminar la actividad del estudiante, no tiene una actividad con ese nombre.",
						"Eliminar actividad", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Muestra las actividades extracurriculares del estudiante.
	 */
	public void mostrarActividades() {

		if (estudiante == null) {
			JOptionPane.showMessageDialog(this, "Debe ingresar un estudiante primero.", "Mostrar actividades.",
					JOptionPane.ERROR_MESSAGE);
		} else {
			ArrayList actividades = new ArrayList();
			Actividad ac1 = estudiante.darActividad1();
			Actividad ac2 = estudiante.darActividad2();
			Actividad ac3 = estudiante.darActividad3();
			if (ac1 != null) {
				String tipo = "Trabajo social";
				if (ac1.darTipo() == Actividad.DEPORTIVO) {
					tipo = "Deportivo";
				} else if (ac1.darTipo() == Actividad.ACADEMICO) {
					tipo = "Académico";
				}
				String texto =
						"Nombre: " + ac1.darNombre() + ", Tipo: " + tipo + ", Dedicación: " + ac1.darHorasDedicadas() +
								" horas.";
				actividades.add(texto);
			}
			if (ac2 != null) {
				String tipo = "Trabajo social";
				if (ac2.darTipo() == Actividad.DEPORTIVO) {
					tipo = "Deportivo";
				} else if (ac2.darTipo() == Actividad.ACADEMICO) {
					tipo = "Académico";
				}
				String texto =
						"Nombre: " + ac2.darNombre() + ", Tipo: " + tipo + ", Dedicación: " + ac2.darHorasDedicadas() +
								" horas.";
				actividades.add(texto);
			}
			if (ac3 != null) {
				String tipo = "Trabajo social";
				if (ac3.darTipo() == Actividad.DEPORTIVO) {
					tipo = "Deportivo";
				} else if (ac3.darTipo() == Actividad.ACADEMICO) {
					tipo = "Académico";
				}
				String texto =
						"Nombre: " + ac3.darNombre() + ", Tipo: " + tipo + ", Dedicación: " + ac3.darHorasDedicadas() +
								" horas.";
				actividades.add(texto);
			}
			dialogoActividades.setSize(450, 200);
			dialogoActividades.cambiarListaCursos(actividades);
			dialogoActividades.setLocation(calculaPosicionCentral(this, dialogoActividades));
			dialogoActividades.setVisible(true);

		}
	}

	/**
	 * Muestra la actividad a la que el estudiante le ha dedicado mas tiempo.
	 */
	public void mostrarTipoMasTiempo() {

		if (estudiante == null) {
			JOptionPane.showMessageDialog(this, "Debe ingresar un estudiante primero.",
					"Tipo de actividad con más tiempo dedicado.", JOptionPane.ERROR_MESSAGE);
		} else {
			String rta = estudiante.darTipoActividadMasTiempoDedicado();
			JOptionPane.showMessageDialog(this, "El tipo de actividad con mas tiempo dedicado es: " + rta,
					"Tipo con mas tiempo", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * Muestra las actividades del estudiante que tienen mas de 100 horas dedicadas.
	 */
	public void mostrarActividadesMasDe100Horas() {

		if (estudiante == null) {
			JOptionPane.showMessageDialog(this, "Debe ingresar un estudiante primero.",
					"Actividades con más de 100 horas.", JOptionPane.ERROR_MESSAGE);
		} else {
			int rta = estudiante.contarActividadesMasDe100Horas();
			JOptionPane.showMessageDialog(this, "El total de actividades con mas de 100 horas dedicadas es: " + rta,
					"Actividades con mas de 100 horas", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * Muestra si el estudiante cumple con los requisitos para postularse a una beca.
	 */
	public void mostrarCumpleRequisitosBeca() {

		if (estudiante == null) {
			JOptionPane.showMessageDialog(this, "Debe ingresar un estudiante primero.", "Requisitos beca",
					JOptionPane.ERROR_MESSAGE);
		} else {
			boolean rta = estudiante.cumpleRequisitosBeca();
			if (rta == true) {
				JOptionPane.showMessageDialog(this,
						"El estudiante si cumple con los requisitos para postularse para una beca de liderazgo integral. ",
						"Requisitos beca", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this,
						"El estudiante no cumple con los requisitos para postularse para una beca de liderazgo integral. ",
						"Requisitos beca", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	// -----------------------------------------------------------------
	// Puntos de Extensión
	// -----------------------------------------------------------------

	/**
	 * Opción 1 de extensión
	 */
	public void reqFuncOpcion1() {

		if (estudiante != null) {
			String respuesta = estudiante.metodo1();
			JOptionPane.showMessageDialog(this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane
					.showMessageDialog(this, "Debe ingresar un estudiante primero", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Opción 2 de extensión
	 */
	public void reqFuncOpcion2() {

		if (estudiante != null) {
			String respuesta = estudiante.metodo2();
			JOptionPane.showMessageDialog(this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane
					.showMessageDialog(this, "Debe ingresar un estudiante primero", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	// -----------------------------------------------------------------
	// Main
	// -----------------------------------------------------------------

	/**
	 * Método principal de ejecución
	 * @param args - Argumentos de entrada en la ejecución. No deben ser usados.
	 */
	public static void main(String[] args) {

		InterfazEstudiante i = new InterfazEstudiante();
		i.setVisible(true);
	}
}
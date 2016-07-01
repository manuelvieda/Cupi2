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
package uniandes.cupi2.estudiante.mundo;

/**
 * Clase que modela un estudiante
 */
public class Estudiante {
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Código del estudiante
	 */
	private int codigo;

	/**
	 * Nombre del estudiante
	 */
	private String nombre;

	/**
	 * Apellido del estudiante
	 */
	private String apellido;

	/**
	 * Curso del estudiante
	 */
	private Curso curso1;

	/**
	 * Curso del estudiante
	 */
	private Curso curso2;

	/**
	 * Curso del estudiante
	 */
	private Curso curso3;

	/**
	 * Curso del estudiante
	 */
	private Curso curso4;

	/**
	 * Curso del estudiante
	 */
	private Curso curso5;

	/**
	 * Actividad extracurricular 1.
	 */
	private Actividad actividad1;

	/**
	 * Actividad extracurricular 2.
	 */
	private Actividad actividad2;

	/**
	 * Actividad extracurricular 3.
	 */
	private Actividad actividad3;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Constructor de un estudiante
	 *
	 * @param elNombre - nombre del estudiante - elNombre != null
	 * @param elApellido - apellido del estudiante - elApellido != null
	 * @param elCodigo - código del estudiante - elCodigo > -1
	 */
	public Estudiante(String elNombre, String elApellido, int elCodigo) {

		nombre = elNombre;
		apellido = elApellido;
		codigo = elCodigo;
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Método que asigna un curso a un estudiante. <br>
	 * <b>post: </b> El estudiante tiene un nuevo curso, si es el quinto ingreso, ya el estudiante no puede manejar más. <br>
	 *
	 * @param curso a asignar
	 * @return true si puedo asignar el curso y false en caso contrario
	 */
	public boolean asignarCurso(Curso curso) {

		if (curso1 == null) {
			curso1 = curso;

		} else if (curso2 == null) {
			curso2 = curso;

		} else if (curso3 == null) {
			curso3 = curso;

		} else if (curso4 == null) {
			curso4 = curso;

		} else if (curso5 == null) {
			curso5 = curso;

		} else {
			return false;
		}
		return true;
	}

	/**
	 * Metódo que calcula el promedio del estudiante. <br>
	 * <b>post: </b> Retornó el promedio ponderado del estudiante. <br>
	 *
	 * @return promedio - promedio de los cursos vistos por el estudiante - promedio >= 0.0
	 */
	public double calcularPromedioEstudiante() {

		double totalCurso1 = 0.0;
		double totalCurso2 = 0.0;
		double totalCurso3 = 0.0;
		double totalCurso4 = 0.0;
		double totalCurso5 = 0.0;
		double totalCreditos = 0.0;

		double promedio = 0.0;

		if (curso1 != null) {
			if (curso1.darNota() != 0.0) {
				totalCurso1 = curso1.darNota() * curso1.darCreditos();
				totalCreditos = totalCreditos + curso1.darCreditos();
			}

		}
		if (curso2 != null) {
			if (curso2.darNota() != 0.0) {
				totalCurso2 = curso2.darNota() * curso2.darCreditos();
				totalCreditos = totalCreditos + curso2.darCreditos();
			}
		}
		if (curso3 != null) {
			if (curso3.darNota() != 0.0) {
				totalCurso3 = curso3.darNota() * curso3.darCreditos();
				totalCreditos = totalCreditos + curso3.darCreditos();
			}
		}
		if (curso4 != null) {
			if (curso4.darNota() != 0.0) {
				totalCurso4 = curso4.darNota() * curso4.darCreditos();
				totalCreditos = totalCreditos + curso4.darCreditos();
			}
		}
		if (curso5 != null) {
			if (curso5.darNota() != 0.0) {
				totalCurso5 = curso5.darNota() * curso5.darCreditos();
				totalCreditos = totalCreditos + curso5.darCreditos();
			}
		}
		// Se asegura que no se generarán problemas por el denominador en cero
		if (totalCreditos > 0.0) {
			promedio = (totalCurso1 + totalCurso2 + totalCurso3 + totalCurso4 + totalCurso5) / totalCreditos;
		}

		return promedio;
	}

	/**
	 * Método que indica si el pensum del estudiante incluye el curso <br>
	 * <b>post: </b> Retorno true si el estudiante vió el curso, false de lo contrario. <br>
	 *
	 * @param codigoCurso - código del curso del cual se desea saber si el estudiante ya lo vió - nombreCurso != null
	 * @return true si ya se vió curso ( nota != 0.0 ), false de lo contrario
	 */
	public boolean pensumIncluyeCurso(String codigoCurso) {

		Curso aux = buscarCurso(codigoCurso);
		if (aux != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Indica si el estudiante se encuentra en prueba académica. <br>
	 *
	 * @return true si se encuentra en prueba, false de lo contrario
	 */
	public boolean estudianteEstaPrueba() {

		double promedio = calcularPromedioEstudiante();
		if (promedio < 3.25) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Indica si el estudiante tiene todos los cursos asignados. <br>
	 * <b>post: </b> Retorno true si los 5 cursos se encuentran copados, false de lo contrario. <br>
	 *
	 * @return cursosLlenos - Retorna true si los cursos estan copados, false de lo contrario
	 */
	public boolean tieneCursosCompletos() {

		if (curso1 == null || curso2 == null || curso3 == null || curso4 == null || curso5 == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Método usado para buscar un curso. <br>
	 * <b>post: </b> Retorno true si el curso esta registrado los cursos del estudiante, false de lo contrario. <br>
	 *
	 * @param codigoCurso - código del curso a buscar - codigoCurso != null
	 * @return Curso si el curso está, null de lo contrario
	 */
	public Curso buscarCurso(String codigoCurso) {

		if (curso1 != null && curso1.darCodigoCurso().equals(codigoCurso)) {
			return curso1;

		} else if (curso2 != null && curso2.darCodigoCurso().equals(codigoCurso)) {
			return curso2;

		} else if (curso3 != null && curso3.darCodigoCurso().equals(codigoCurso)) {
			return curso3;

		} else if (curso4 != null && curso4.darCodigoCurso().equals(codigoCurso)) {
			return curso4;

		} else if (curso5 != null && curso5.darCodigoCurso().equals(codigoCurso)) {
			return curso5;

		} else {
			return null;
		}
	}

	/**
	 * Método que retorna el código del estudiante
	 *
	 * @return codigo del estudiante
	 */
	public int darCodigo() {

		return codigo;
	}

	/**
	 * Método que retorna el nombre del estudiante
	 *
	 * @return nombre del estudiante - nombre != null
	 */
	public String darNombre() {

		return nombre;
	}

	/**
	 * Método que retorna el apellido del estudiante
	 *
	 * @return apellido del estudiante - apellido != null
	 */
	public String darApellido() {

		return apellido;
	}

	/**
	 * Método que retorna el Curso 1 del estudiante
	 *
	 * @return curso 1
	 */
	public Curso darCurso1() {

		return curso1;
	}

	/**
	 * Método que retorna el Curso 2 del estudiante
	 *
	 * @return curso 2
	 */
	public Curso darCurso2() {

		return curso2;
	}

	/**
	 * Método que retorna el Curso 3 del estudiante
	 *
	 * @return curso 3
	 */
	public Curso darCurso3() {

		return curso3;
	}

	/**
	 * Método que retorna el Curso 4 del estudiante
	 *
	 * @return curso 4
	 */
	public Curso darCurso4() {

		return curso4;
	}

	/**
	 * Método que retorna el Curso 5 del estudiante
	 *
	 * @return curso 5
	 */
	public Curso darCurso5() {

		return curso5;
	}

	// -----------------------------------------------------------------
	// Extensión
	// -----------------------------------------------------------------

	/**
	 * Devuelve la actividad extracurricular 1.
	 *
	 * @return Actividad extracurricular 1.
	 */
	public Actividad darActividad1() {

		return actividad1;
	}

	/**
	 * Devuelve la actividad extracurricular 2.
	 *
	 * @return Actividad extracurricular 2.
	 */
	public Actividad darActividad2() {

		return actividad2;
	}

	/**
	 * Devuelve la actividad extracurricular 3.
	 *
	 * @return Actividad extracurricular 3.
	 */
	public Actividad darActividad3() {

		return actividad3;
	}

	/**
	 * Agrega una actividad dados su nombre, tipo de actividad y hroas dedicadas
	 *
	 * @param nombreAct Nombre de la actividad a agregar.
	 * @param tipo Tipo de la actividad a agregar.
	 * @param horasDedicadas Horas dedicadas de la actividad a agregar.
	 * @return True si logra agregar la actividad, false de lo contrario.
	 */
	public boolean agregarActividad(String nombreAct, int tipo, int horasDedicadas) {

		if (actividad1 == null) {
			actividad1 = new Actividad(nombreAct, tipo, horasDedicadas);

		} else if (actividad2 == null) {
			actividad2 = new Actividad(nombreAct, tipo, horasDedicadas);

		} else if (actividad3 == null) {
			actividad3 = new Actividad(nombreAct, tipo, horasDedicadas);

		} else {
			return false;
		}

		return true;

	}

	/**
	 * Elimina una actividad extracurricular dado el nombre.
	 *
	 * @param nombreAct Nombre de la actividad. nombre!="" && nombre!=null.
	 * @return True si logra eliminar una actividad con el nombre pasado por parámetro, false de lo contrario.
	 */
	public boolean eliminarActividad(String nombreAct) {

		if (actividad1 != null && actividad1.darNombre().equals(nombreAct)) {
			actividad1 = null;

		} else if (actividad2 != null && actividad2.darNombre().equals(nombreAct)) {
			actividad2 = null;

		} else if (actividad3 != null && actividad3.darNombre().equals(nombreAct)) {
			actividad3 = null;

		} else {
			return false;
		}

		return true;
	}

	/**
	 * Devuelve un texto con el tipo de actividad extracurricular con mayor tiempo dedicado.
	 *
	 * @return Tipo de actividad con mas horas dedicadas.
	 * Esto puede ser "Académico", "Deportivo" ó "Trabajo social".
	 */
	public String darTipoActividadMasTiempoDedicado() {

		int academico = darHorasDedicadasActividades(Actividad.ACADEMICO);
		int deportivo = darHorasDedicadasActividades(Actividad.DEPORTIVO);
		int trabajoSocial = darHorasDedicadasActividades(Actividad.TRABAJO_SOCIAL);

		if (academico >= deportivo && academico >= trabajoSocial) {
			return "Académico";
		} else if (deportivo >= trabajoSocial) {
			return "Deportivo";
		} else {
			return "Trabajo social";
		}
	}

	/**
	 * Calcula la cantidad de actividades que tienen una cantidad de horas dedicadas mayor a 100.
	 *
	 * @return Cantidad de actividades que tiene mas de 100 horas dedicadas.
	 */
	public int contarActividadesMasDe100Horas() {

		int contador = 0;

		if (actividad1 != null && actividad1.darHorasDedicadas() > 100) {
			contador++;
		}

		if (actividad2 != null && actividad2.darHorasDedicadas() > 100) {
			contador++;
		}

		if (actividad3 != null && actividad3.darHorasDedicadas() > 100) {
			contador++;
		}

		return contador;
	}

	/**
	 * Determina si un estudiante cumple con los requisitos para postularse para una beca de liderazgo integral.
	 * Los requisitos son:
	 * a.	Tener un promedio superior o igual a 4,7.
	 * b.	Haber dedicado más de 100 horas a actividades extracurriculares de tipo trabajo social.
	 * c.	Haber dedicado más de 100 horas a actividades extracurriculares de tipo deportivo.
	 * d.	Haber dedicado más de 100 horas a actividades extracurriculares de tipo académico
	 *
	 * @return True si cumple todos los requisitos, false de lo contrario.
	 */
	public boolean cumpleRequisitosBeca() {

		return calcularPromedioEstudiante() >= 4.7 &&
				darHorasDedicadasActividades(Actividad.ACADEMICO) > 100 &&
				darHorasDedicadasActividades(Actividad.DEPORTIVO) > 100 &&
				darHorasDedicadasActividades(Actividad.TRABAJO_SOCIAL) > 100;
	}

	/**
	 * Método de extensión
	 *
	 * @return Respuesta de extensión
	 */
	public String metodo1() {

		return "respuesta 1";
	}

	/**
	 * Método de extensión
	 *
	 * @return Respuesta de extensión
	 */
	public String metodo2() {

		return "respuesta 2";
	}

	public int darHorasDedicadasActividades(int tipoActividad) {

		int horas = 0;

		if (actividad1 != null && actividad1.darTipo() == tipoActividad) {
			horas += actividad1.darHorasDedicadas();
		}

		if (actividad2 != null && actividad2.darTipo() == tipoActividad) {
			horas += actividad2.darHorasDedicadas();
		}

		if (actividad3 != null && actividad3.darTipo() == tipoActividad) {
			horas += actividad3.darHorasDedicadas();
		}

		return horas;
	}

}
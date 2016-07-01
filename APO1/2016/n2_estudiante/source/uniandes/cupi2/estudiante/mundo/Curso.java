/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * Universidad de los Andes (Bogotá - Colombia) 
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 2.1
 * 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_estudiante
 * Autor: Equipo Cupi2 2016
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.estudiante.mundo;

/**
 * Clase que modela un curso
 */
public class Curso
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Código del curso
     */
    private String codigoCurso;

    /**
     * Nombre del curso
     */
    private String nombreCurso;

    /**
     * Créditos del curso
     */
    private int creditos;

    /**
     * Nota del curso
     */
    private double nota;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------
    /**
     * Constructor de un curso
     * @param codCurso - código del curso - codCurso - != null
     * @param nomCurso - nombre del curso - nomCurso - != null
     * @param numeroCreditos - número de créditos del curso - >= -1
     */
    public Curso( String codCurso, String nomCurso, int numeroCreditos )
    {
        nota = 0.0;
        creditos = numeroCreditos;
        nombreCurso = nomCurso;
        codigoCurso = codCurso;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Retorna el número de créditos de la materia
     * @return creditos - Retorna el número de créditos - creditos >= 0
     */
    public int darCreditos( )
    {
        return creditos;
    }

    /**
     * Asigna el número de créditos del curso
     * @param nuevosCreditos - nuevo valor para los créditos - nuevosCreditos >0
     */
    public void asignarCreditos( int nuevosCreditos )
    {
        creditos = nuevosCreditos;
    }

    /**
     * Retorna la nota del curso
     * @return nota - retorna la nota del curso - nota >=0.0
     */
    public double darNota( )
    {
        return nota;
    }

    /**
     * Asigna la nota del curso. <br>
     * <b>post: </b> Se asigna la nueva nota del curso. La nota del curso no puede ser inferior a 1.5
     * @param nuevaNota - nota del curso - nuevaNota >= 1.5
     */
    public void asignarNota( double nuevaNota )
    {
        nota = nuevaNota;
    }

    /**
     * Método que retorna el nombre del curso
     * @return nombreCurso - nombre del curso - nombreCurso != null
     */
    public String darNombreCurso( )
    {
        return nombreCurso;
    }

    /**
     * Método que retorna el código del curso
     * @return codigoCurso - código del curso - codigoCurso != null
     */
    public String darCodigoCurso( )
    {
        return codigoCurso;
    }

    /**
     * Entrega la información del curso
     * @return Descripción del curso
     */
    public String darDescripcion( )
    {
        return "Nombre: " + nombreCurso + "     Código: " + codigoCurso + "     Créditos:" + creditos;

    }

    /**
     * Indica si el curso ya ha sido calificado. <br>
     * <b>post: </b> Retorno true si el curso ya tiene una nota asignada. <br>
     * @return true si el curso ya tiene nota, false de lo contrario
     */
    public boolean estaCalificado( )
    {
        if( nota == 0.0 )
            return false;
        else
            return true;
    }
}
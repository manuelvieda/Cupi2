#!/bin/sh
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Universidad de los Andes (Bogotá - Colombia)
# Departamento de Ingeniería de Sistemas y Computación
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
# Ejercicio: n2_estudiante
# Autor: Equipo Cupi2 2014
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

stty -echo

# ---------------------------------------------------------
# Ejecución de las pruebas
# ---------------------------------------------------------

cd ../..
	
java -ea -classpath ./lib/estudiante.jar:./test/lib/estudianteTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.estudiante.test.EstudianteTest
java -ea -classpath ./lib/estudiante.jar:./test/lib/estudianteTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.estudiante.test.ActividadTest
cd bin/mac

stty echo

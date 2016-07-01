@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogotá - Colombia)
REM Departamento de Ingeniería de Sistemas y Computación
REM Licenciado bajo el esquema Academic Free License version 2.1
REM
REM Proyecto Cupi2
REM Ejercicio: n2_estudiante
REM Autor: Equipo Cupi2 2014
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM/

REM ---------------------------------------------------------
REM Ejecucion de las pruebas
REM ---------------------------------------------------------

cd ../..
java -classpath ./lib/estudiante.jar;./test/lib/estudianteTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.estudiante.test.EstudianteTest
java -classpath ./lib/estudiante.jar;./test/lib/estudianteTest.jar;./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.estudiante.test.ActividadTest

cd bin


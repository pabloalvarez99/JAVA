@echo off
REM Java Compile & Run Script for Windows
REM Usage: compilar.bat [folder] [exercise_number]
REM Example: compilar.bat 01_Fundamentos 1

setlocal enabledelayedexpansion

if "%~1"=="" (
    echo.
    echo Java Compile Script
    echo ===================
    echo.
    echo Usage: compilar.bat [folder] [exercise_number]
    echo.
    echo Available folders:
    echo   01_Fundamentos     ^(Exercises 1-9^)
    echo   02_POO_Basico      ^(Exercises 10-15^)
    echo   03_Colecciones     ^(Exercises 16-20^)
    echo   04_Avanzado        ^(Exercises 21-36^)
    echo.
    echo Examples:
    echo   compilar.bat 01_Fundamentos 1
    echo   compilar.bat 02_POO_Basico 10
    echo   compilar.bat 03_Colecciones 16
    echo.
    exit /b 0
)

set FOLDER=%~1
set NUM=%~2

if "%NUM%"=="" (
    echo Error: Please provide exercise number
    exit /b 1
)

set FILE=%FOLDER%\Ejercicio%NUM%.java

if not exist "%FILE%" (
    echo Error: File not found: %FILE%
    exit /b 1
)

echo.
echo Compiling %FILE%...
javac "%FILE%"

if errorlevel 1 (
    echo.
    echo Compilation FAILED
    exit /b 1
)

echo Compilation successful!
echo.
echo Running Ejercicio%NUM%...
echo ----------------------------------------

cd %FOLDER%
java Ejercicio%NUM%
cd ..

echo ----------------------------------------
echo Done.

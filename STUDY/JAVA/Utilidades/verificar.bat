@echo off
REM Exercise Validator - Checks if all exercises compile
REM Usage: verificar.bat [folder] or verificar.bat all

setlocal enabledelayedexpansion

echo.
echo ========================================
echo   Java Exercise Validator
echo ========================================
echo.

set ERRORS=0
set TOTAL=0
set SUCCESS=0

if "%~1"=="all" goto :all
if "%~1"=="" goto :usage
goto :single

:usage
echo Usage:
echo   verificar.bat all           - Check all exercises
echo   verificar.bat 01_Fundamentos - Check specific folder
echo.
echo Folders:
echo   01_Fundamentos, 02_POO_Basico, 03_Colecciones, 04_Avanzado
goto :end

:single
set FOLDER=%~1
if not exist "%FOLDER%" (
    echo Error: Folder not found: %FOLDER%
    goto :end
)
echo Checking %FOLDER%...
echo.
for %%f in (%FOLDER%\Ejercicio*.java) do (
    set /a TOTAL+=1
    echo Compiling: %%~nxf
    javac "%%f" 2>nul
    if errorlevel 1 (
        echo   [FAIL] %%~nxf
        set /a ERRORS+=1
    ) else (
        echo   [OK]   %%~nxf
        set /a SUCCESS+=1
        del "%%~dpnf.class" 2>nul
    )
)
goto :summary

:all
for %%d in (01_Fundamentos 02_POO_Basico 03_Colecciones 04_Avanzado) do (
    if exist "%%d" (
        echo.
        echo === %%d ===
        for %%f in (%%d\Ejercicio*.java) do (
            set /a TOTAL+=1
            javac "%%f" 2>nul
            if errorlevel 1 (
                echo   [FAIL] %%~nxf
                set /a ERRORS+=1
            ) else (
                echo   [OK]   %%~nxf
                set /a SUCCESS+=1
                del "%%~dpnf.class" 2>nul
            )
        )
    )
)
goto :summary

:summary
echo.
echo ========================================
echo   Results
echo ========================================
echo   Total:   %TOTAL%
echo   Success: %SUCCESS%
echo   Failed:  %ERRORS%
echo ========================================

if %ERRORS% GTR 0 (
    echo.
    echo Some exercises have errors. Check and fix them.
    exit /b 1
) else (
    echo.
    echo All exercises compile successfully!
    exit /b 0
)

:end

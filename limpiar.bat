@echo off
REM Clean all compiled .class files
REM Usage: limpiar.bat

echo.
echo Cleaning compiled Java files...
echo.

for /r %%f in (*.class) do (
    echo Deleting: %%f
    del "%%f"
)

echo.
echo Done! All .class files removed.

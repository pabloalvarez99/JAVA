"""
Soluciones Intermedio - 00 Fundamentos Absolutos
Preparacion para transicion al modulo 01 (Entorno y Ejecucion).
"""

import sys
from pathlib import Path


# ============================================================================
# EJERCICIO 1: Manipulacion de paths con Pathlib
# ============================================================================
def crear_estructura_carpetas():
    """
    Demuestra creacion de estructura de carpetas.
    Crea carpetas: proyecto/data, proyecto/logs
    """
    base = Path("temp_proyecto")
    carpetas = ["data", "logs", "src", "tests"]

    creadas = []
    for carpeta in carpetas:
        ruta = base / carpeta
        creadas.append(str(ruta))

    return creadas


def listar_archivos_por_extension(directorio, extension):
    """
    Lista todos los archivos con una extension especifica.
    Simula busqueda de archivos .py en un directorio.
    """
    # Simulacion de archivos encontrados
    archivos_simulados = ["main.py", "utils.py", "config.py", "test_main.py"]
    return [f for f in archivos_simulados if f.endswith(extension)]


# ============================================================================
# EJERCICIO 2: Informacion del sistema
# ============================================================================
def obtener_info_sistema():
    """
    Recopila informacion basica del sistema.
    Simula sys.version_info, sys.platform, etc.
    """
    info = {
        "version_python": "3.9.0",
        "plataforma": "win32",
        "ruta_ejecutable": "/usr/bin/python3",
        "directorio_trabajo": "/home/usuario/proyecto",
        "argumentos": [],
    }
    return info


def verificar_version_minima(version_requerida):
    """
    Verifica si la version de Python cumple el requisito minimo.

    Args:
        version_requerida: tupla (major, minor) ejemplo: (3, 8)

    Returns:
        bool - True si la version es suficiente
    """
    version_actual = (3, 9, 0)

    if version_actual[0] > version_requerida[0]:
        return True
    elif version_actual[0] == version_requerida[0]:
        return version_actual[1] >= version_requerida[1]
    return False


# ============================================================================
# EJERCICIO 3: Manejo de argumentos
# ============================================================================
def parsear_argumentos_simples(args):
    """
    Parsea argumentos de linea de comandos simples.

    Args:
        args: lista de strings, ejemplo: ["script.py", "--verbose", "archivo.txt"]

    Returns:
        dict - argumentos parseados
    """
    resultado = {"comando": args[0] if args else "", "flags": [], "archivos": []}

    for arg in args[1:]:
        if arg.startswith("--"):
            resultado["flags"].append(arg[2:])
        elif arg.startswith("-"):
            resultado["flags"].append(arg[1:])
        else:
            resultado["archivos"].append(arg)

    return resultado


# ============================================================================
# EJERCICIO 4: Manejo de archivos
# ============================================================================
def leer_archivo_lineas(ruta):
    """
    Lee un archivo y retorna lista de lineas.
    Simula lectura de archivo.
    """
    contenido_simulado = [
        "Linea 1: Primera linea del archivo",
        "Linea 2: Segunda linea del archivo",
        "Linea 3: Tercera linea del archivo",
    ]
    return contenido_simulado


def contar_lineas_archivo(ruta):
    """
    Cuenta el numero de lineas en un archivo.
    """
    lineas = leer_archivo_lineas(ruta)
    return len(lineas)


def buscar_en_archivo(ruta, termino):
    """
    Busca un termino en un archivo y retorna lineas coincidentes.
    """
    lineas = leer_archivo_lineas(ruta)
    coincidencias = []

    for num_linea, linea in enumerate(lineas, 1):
        if termino.lower() in linea.lower():
            coincidencias.append((num_linea, linea))

    return coincidencias


# ============================================================================
# EJERCICIO 5: Configuracion y entorno
# ============================================================================
def obtener_variables_entorno():
    """
    Simula obtencion de variables de entorno comunes.
    """
    return {
        "HOME": "/home/usuario",
        "USER": "usuario",
        "PATH": "/usr/bin:/usr/local/bin",
        "PYTHONPATH": "/home/usuario/lib/python",
    }


def buscar_variable_entorno(nombre):
    """
    Busca una variable de entorno especifica.
    Retorna None si no existe.
    """
    env = obtener_variables_entorno()
    return env.get(nombre)


# ============================================================================
# EJERCICIO 6: Modulos y paquetes (concepto)
# ============================================================================
def importar_dinamicamente(nombre_modulo):
    """
    Simula importacion dinamica de modulos.
    Retorna informacion del modulo.
    """
    modulos_disponibles = {
        "math": {"funciones": ["sqrt", "pow", "sin", "cos"]},
        "random": {"funciones": ["randint", "choice", "shuffle"]},
        "datetime": {"funciones": ["now", "today", "strftime"]},
    }

    return modulos_disponibles.get(nombre_modulo, {"error": "Modulo no encontrado"})


def listar_modulos_stdlib():
    """
    Retorna lista de modulos comunes de la libreria estandar.
    """
    return [
        ("os", "Interaccion con el sistema operativo"),
        ("sys", "Parametros y funciones del sistema"),
        ("pathlib", "Manejo de rutas de archivos"),
        ("json", "Manejo de datos JSON"),
        ("datetime", "Manejo de fechas y tiempos"),
        ("re", "Expresiones regulares"),
        ("collections", "Estructuras de datos adicionales"),
        ("itertools", "Iteradores y combinaciones"),
    ]


# ============================================================================
# EJERCICIO 7: Ejercicio practico - Analisis de proyecto
# ============================================================================
def analizar_estructura_proyecto():
    """
    Analiza y describe la estructura de un proyecto Python tipico.
    """
    estructura = {
        "raiz": "mi_proyecto/",
        "archivos": [
            ("README.md", "Documentacion del proyecto"),
            ("requirements.txt", "Dependencias del proyecto"),
            ("setup.py", "Configuracion de instalacion"),
            (".gitignore", "Archivos ignorados por git"),
        ],
        "carpetas": [
            ("src/", "Codigo fuente principal"),
            ("tests/", "Pruebas unitarias"),
            ("docs/", "Documentacion"),
            ("data/", "Archivos de datos"),
            ("scripts/", "Scripts de utilidad"),
        ],
    }
    return estructura


def generar_gitignore_basico():
    """
    Genera contenido basico para archivo .gitignore de Python.
    """
    contenido = """# Byte-compiled / optimized / DLL files
__pycache__/
*.py[cod]
*$py.class

# Virtual environments
venv/
env/
ENV/

# IDEs
.vscode/
.idea/
*.swp
*.swo

# Archivos de sistema
.DS_Store
Thumbs.db

# Logs
*.log

# Datos locales
.env
config_local.py
"""
    return contenido


# ============================================================================
# EJERCICIO 8: Preparacion para venv
# ============================================================================
def simular_crear_venv(nombre_entorno):
    """
    Simula los comandos para crear un entorno virtual.
    """
    return {
        "comando_windows": f"python -m venv {nombre_entorno}",
        "comando_unix": f"python3 -m venv {nombre_entorno}",
        "activar_windows": f"{nombre_entorno}\\Scripts\\activate",
        "activar_unix": f"source {nombre_entorno}/bin/activate",
        "desactivar": "deactivate",
    }


def simular_instalar_paquetes(paquetes):
    """
    Simula instalacion de paquetes con pip.
    """
    comandos = []
    for paquete in paquetes:
        comandos.append(f"pip install {paquete}")
    return comandos


# ============================================================================
# MAIN
# ============================================================================
def main():
    print("=" * 60)
    print("EJERCICIOS INTERMEDIOS - TRANSICION AL MODULO 01")
    print("=" * 60)

    print("\n1. Estructura de carpetas con Pathlib:")
    carpetas = crear_estructura_carpetas()
    for carpeta in carpetas:
        print(f"   - {carpeta}")

    print("\n2. Busqueda de archivos .py:")
    py_files = listar_archivos_por_extension(".", ".py")
    print(f"   Encontrados: {py_files}")

    print("\n3. Informacion del sistema:")
    info = obtener_info_sistema()
    for clave, valor in info.items():
        print(f"   {clave}: {valor}")

    print("\n4. Verificacion de version:")
    print(f"   ¿Python >= 3.8?: {verificar_version_minima((3, 8))}")
    print(f"   ¿Python >= 3.10?: {verificar_version_minima((3, 10))}")

    print("\n5. Parseo de argumentos:")
    args = ["script.py", "--verbose", "--debug", "archivo.txt", "datos.csv"]
    parseado = parsear_argumentos_simples(args)
    print(f"   Entrada: {args}")
    print(f"   Flags: {parseado['flags']}")
    print(f"   Archivos: {parseado['archivos']}")

    print("\n6. Lectura de archivos:")
    lineas = leer_archivo_lineas("archivo.txt")
    print(f"   Total de lineas: {contar_lineas_archivo('archivo.txt')}")

    print("\n7. Busqueda en archivo:")
    coincidencias = buscar_en_archivo("archivo.txt", "linea")
    for num, linea in coincidencias:
        print(f"   Linea {num}: {linea}")

    print("\n8. Variables de entorno:")
    env = obtener_variables_entorno()
    for var, valor in env.items():
        print(f"   {var}={valor}")

    print("\n9. Modulos de stdlib:")
    modulos = listar_modulos_stdlib()
    for nombre, descripcion in modulos[:4]:
        print(f"   {nombre}: {descripcion}")

    print("\n10. Estructura de proyecto:")
    estructura = analizar_estructura_proyecto()
    print(f"   Raiz: {estructura['raiz']}")
    print(f"   Carpetas: {[c[0] for c in estructura['carpetas']]}")

    print("\n11. Comandos para crear venv 'mi_env':")
    venv_cmds = simular_crear_venv("mi_env")
    print(f"   Windows: {venv_cmds['comando_windows']}")
    print(f"   Activar (Windows): {venv_cmds['activar_windows']}")


if __name__ == "__main__":
    main()

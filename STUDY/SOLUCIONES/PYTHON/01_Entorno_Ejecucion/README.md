# Módulo 01 - Entorno y Ejecución

## Descripción

Este módulo cubre la configuración del entorno de desarrollo Python y las diferentes formas de ejecutar código Python. Es fundamental para establecer bases sólidas en el ecosistema Python.

## Objetivos de Aprendizaje

Al completar este módulo serás capaz de:
- Configurar un entorno de desarrollo Python completo
- Utilizar diferentes métodos para ejecutar código Python
- Trabajar con entornos virtuales
- Usar herramientas de desarrollo esenciales
- Comprender la estructura de proyectos Python
- Gestionar paquetes y dependencias
- Depurar código Python básico

## Estructura de Archivos

```
01_Entorno_Ejecucion/
├── ejercicios_solucion.py          # Ejercicios principales de entorno
├── ejercicios_basico_solucion.py   # Configuración básica
├── ejercicios_intermedio_solucion.py  # Herramientas de desarrollo
├── ejercicios_avanzado_solucion.py    # Optimización y profiling
├── ejercicios_extra_solucion.py    # Práctica adicional
├── integracion_solucion.py         # Proyecto: Gestor de Entornos
└── README.md                       # Este archivo
```

## Contenido Detallado

### ejercicios_solucion.py

Ejercicios fundamentales del entorno:
- Verificación de instalación de Python
- Ejecución desde línea de comandos
- Uso del REPL interactivo
- Variables de entorno
- Módulos de la librería estándar
- Estructura de directorios
- Configuración básica de editor

### ejercicios_basico_solucion.py

Configuración y conceptos básicos:
- Instalación de Python en diferentes sistemas
- Configuración de PATH
- Primer programa Python
- Comentarios y documentación
- Tipos de datos básicos
- Operadores fundamentales
- Entrada/salida básica

### ejercicios_intermedio_solucion.py

Herramientas y técnicas intermedias:
- Entornos virtuales (venv, virtualenv)
- Gestión de paquetes con pip
- Configuración de VS Code para Python
- Depuración básica
- Testing simple con assert
- Formato de código (black, autopep8)
- Linters (pylint, flake8)

### ejercicios_avanzado_solucion.py

Técnicas avanzadas de entorno:
- Optimización de código
- Profiling básico
- Gestión avanzada de paquetes
- Configuración de Docker para Python
- Integración continua básica
- Herramientas de análisis estático
- Benchmarking

### ejercicios_extra_solucion.py

Práctica adicional y especialización:
- Scripts de automatización
- Integración con sistemas operativos
- Herramientas de productividad
- Configuración de IDEs alternativos
- Plugins y extensiones útiles
- Flujo de trabajo profesional

### integracion_solucion.py

**Proyecto Final: Gestor de Entornos Python**

Una aplicación completa que incluye:
- Creación y gestión de entornos virtuales
- Instalación automática de dependencias
- Configuración de proyectos
- Validación de entornos
- Reporte de estado
- Interfaz de línea de comandos

## Cómo Usar Este Módulo

### 1. Orden Recomendado

```
1. Configura tu entorno siguiendo ejercicios_solucion.py
2. Practica con los ejercicios básicos
3. Explora las herramientas intermedias
4. Avanza a técnicas avanzadas
5. Completa la práctica extra
6. Desarrolla el proyecto integrador
```

### 2. Método de Estudio

- **Practica cada comando**: No solo leas, ejecuta todo
- **Experimenta**: Modifica parámetros y observa resultados
- **Toma notas**: Documenta tu configuración específica
- **Crea proyectos**: Aplica lo aprendido en proyectos reales

### 3. Tiempo Estimado

- **Configuración básica**: 1-2 días
- **Ejercicios principales**: 2-3 días
- **Herramientas intermedias**: 3-4 días
- **Técnicas avanzadas**: 2-3 días
- **Práctica extra**: 2-3 días (opcional)
- **Proyecto integrador**: 3-4 días

**Total estimado**: 2-3 semanas para completar el módulo

## Requisitos Previos

- Acceso a una computadora con Windows/macOS/Linux
- Permisos de administrador (para instalación)
- Conexión a internet para descargas

## Software Necesario

- Python 3.8+ (recomendado 3.9+)
- Editor de código (VS Code recomendado)
- Terminal/consola del sistema
- Git (opcional pero recomendado)

## Cómo Ejecutar

```bash
# Navegar al directorio
cd STUDY/SOLUCIONES/PYTHON/01_Entorno_Ejecucion

# Ejecutar ejercicios principales
python ejercicios_solucion.py

# Ejecutar diferentes niveles
python ejercicios_basico_solucion.py
python ejercicios_intermedio_solucion.py
python ejercicios_avanzado_solucion.py
python ejercicios_extra_solucion.py

# Ejecutar proyecto integrador
python integracion_solucion.py
```

## Configuración Inicial

### 1. Verificar instalación

```bash
python --version
pip --version
```

### 2. Crear entorno virtual (recomendado)

```bash
python -m venv entorno_modulo01
# Windows
entorno_modulo01\Scripts\activate
# macOS/Linux
source entorno_modulo01/bin/activate
```

### 3. Instalar dependencias (si existen)

```bash
pip install -r requirements.txt  # si existe el archivo
```

## Conceptos Clave

### Entornos Virtuales
- Aíslan dependencias por proyecto
- Evitan conflictos entre versiones
- Facilitan la reproducción de ambientes

### Gestión de Paquetes
- `pip` es el gestor oficial
- `requirements.txt` para dependencias
- Entornos virtuales para aislamiento

### Flujo de Trabajo Profesional
- Code → Test → Format → Commit
- Uso de linters y formatters
- Integración continua

## Errores Comunes y Soluciones

### 1. Python no encontrado en PATH
- **Solución**: Reinstalar Python marcando "Add to PATH"
- **Alternativa**: Usar ruta completa al ejecutable

### 2. Permisos denegados
- **Windows**: Ejecutar como administrador
- **macOS/Linux**: Usar `sudo` o configurar permisos

### 3. Conflicto de versiones
- **Solución**: Usar entornos virtuales
- **Verificación**: `python -V` y `pip -V`

## Proximos Pasos

Al completar este módulo, estarás listo para:
- Módulo 02: Tipos y Colecciones
- Módulo 03: Control de Flujo
- Módulo 04: Funciones
- Desarrollo de proyectos Python reales

## Recursos Adicionales

- **Documentación oficial**: https://docs.python.org/es/3/
- **Python Packaging**: https://packaging.python.org/
- **VS Code Python**: https://code.visualstudio.com/docs/languages/python
- **Real Python**: https://realpython.com/

## Nota del Instructor

> Este módulo es la base de todo el aprendizaje Python. Una buena configuración del entorno ahorra incontables horas de frustración. Tómate el tiempo necesario para entender cada concepto antes de avanzar.

---

**Versión**: 1.0  
**Última actualización**: Febrero 2026  
**Autor**: Proyecto de Estudio Multi-lenguaje
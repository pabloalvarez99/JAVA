# 06 - Modulos y CLI

Definicion:
Un modulo es un archivo .py, un paquete es una carpeta con `__init__.py`.
`argparse` permite crear CLIs simples y robustas.

Ejemplos:
```python
import argparse

parser = argparse.ArgumentParser()
parser.add_argument("--archivo", required=True)
args = parser.parse_args()
print(args.archivo)
```

Archivos:
- README.md
- ejercicios.py
- ejercicios_extra.py
- ejercicios_basico.py
- ejercicios_intermedio.py
- ejercicios_avanzado.py

Ejercicios:
- Ver `ejercicios.py`, `ejercicios_extra.py`, `ejercicios_basico.py`, `ejercicios_intermedio.py`, `ejercicios_avanzado.py`.








# 09 - HTTP y APIs

Definicion:
HTTP permite consumir servicios externos. `requests` simplifica GET/POST y
manejo de errores.

Ejemplos:
```python
import requests

resp = requests.get("https://httpbin.org/json", timeout=10)
resp.raise_for_status()
print(resp.json().keys())
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








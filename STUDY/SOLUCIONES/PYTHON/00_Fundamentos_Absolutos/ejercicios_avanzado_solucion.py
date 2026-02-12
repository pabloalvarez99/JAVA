"""
Soluciones Avanzado - 00 Fundamentos Absolutos
Nivel avanzado que sirve como puente al modulo 01.
Incluye conceptos mas complejos y buenas practicas.
"""

import json
from datetime import datetime, timedelta
from typing import List, Dict, Any, Optional, Tuple
from functools import reduce


# ============================================================================
# EJERCICIO 1: Funciones de orden superior
# ============================================================================
def aplicar_a_todos(funcion, lista):
    """
    Aplica una funcion a todos los elementos de una lista.
    Similar a map() pero implementado manualmente.
    """
    return [funcion(x) for x in lista]


def filtrar_por_criterio(funcion, lista):
    """
    Filtra elementos que cumplan una condicion.
    Similar a filter() pero implementado manualmente.
    """
    return [x for x in lista if funcion(x)]


def reducir_lista(funcion, lista, valor_inicial):
    """
    Reduce una lista a un solo valor aplicando una funcion acumulativa.
    Similar a reduce() de functools.
    """
    resultado = valor_inicial
    for elemento in lista:
        resultado = funcion(resultado, elemento)
    return resultado


# ============================================================================
# EJERCICIO 2: Comprensiones anidadas
# ============================================================================
def generar_tabla_multiplicar(tamanio=10):
    """
    Genera una tabla de multiplicar completa.
    Retorna matriz n x n.
    """
    return [[i * j for j in range(1, tamanio + 1)] for i in range(1, tamanio + 1)]


def encontrar_pares_suma(objetivo, lista):
    """
    Encuentra todos los pares de numeros que suman el objetivo.
    """
    return [
        (lista[i], lista[j])
        for i in range(len(lista))
        for j in range(i + 1, len(lista))
        if lista[i] + lista[j] == objetivo
    ]


# ============================================================================
# EJERCICIO 3: Manejo de datos complejos
# ============================================================================
def analizar_ventas(datos_ventas: List[Dict[str, Any]]) -> Dict[str, Any]:
    """
    Analiza datos de ventas y retorna estadisticas.

    Args:
        datos_ventas: Lista de diccionarios con 'producto', 'cantidad', 'precio', 'fecha'

    Returns:
        Diccionario con estadisticas calculadas
    """
    if not datos_ventas:
        return {"error": "No hay datos"}

    # Calcular total por venta
    for venta in datos_ventas:
        venta["total"] = venta["cantidad"] * venta["precio"]

    # Estadisticas
    totales = [v["total"] for v in datos_ventas]
    total_general = sum(totales)
    promedio = total_general / len(datos_ventas)
    maximo = max(totales)
    minimo = min(totales)

    # Ventas por producto
    por_producto = {}
    for venta in datos_ventas:
        producto = venta["producto"]
        if producto not in por_producto:
            por_producto[producto] = {"cantidad": 0, "total": 0}
        por_producto[producto]["cantidad"] += venta["cantidad"]
        por_producto[producto]["total"] += venta["total"]

    # Producto mas vendido
    producto_top = max(por_producto.items(), key=lambda x: x[1]["cantidad"])

    return {
        "total_ventas": total_general,
        "promedio_venta": round(promedio, 2),
        "venta_maxima": maximo,
        "venta_minima": minimo,
        "total_transacciones": len(datos_ventas),
        "por_producto": por_producto,
        "producto_mas_vendido": producto_top[0],
        "unidades_top": producto_top[1]["cantidad"],
    }


# ============================================================================
# EJERCICIO 4: Decoradores simples
# ============================================================================
def medir_tiempo(funcion):
    """
    Decorador que mide el tiempo de ejecucion de una funcion.
    Version simplificada para principiantes.
    """

    def wrapper(*args, **kwargs):
        inicio = datetime.now()
        resultado = funcion(*args, **kwargs)
        fin = datetime.now()
        duracion = (fin - inicio).total_seconds()
        print(f"Funcion '{funcion.__name__}' tardo {duracion:.6f} segundos")
        return resultado

    return wrapper


def contar_llamadas(funcion):
    """
    Decorador que cuenta cuantas veces se llama una funcion.
    """

    def wrapper(*args, **kwargs):
        wrapper.llamadas += 1
        print(f"Llamada #{wrapper.llamadas} a '{funcion.__name__}'")
        return funcion(*args, **kwargs)

    wrapper.llamadas = 0
    return wrapper


@medir_tiempo
def calcular_fibonacci_lento(n):
    """Calcula Fibonacci de forma recursiva (lento)."""
    if n <= 1:
        return n
    return calcular_fibonacci_lento(n - 1) + calcular_fibonacci_lento(n - 2)


@contar_llamadas
def saludar_usuario(nombre):
    """Funcion de ejemplo para contar llamadas."""
    return f"Hola, {nombre}!"


# ============================================================================
# EJERCICIO 5: Generadores
# ============================================================================
def generador_fibonacci(n):
    """
    Generador que produce numeros Fibonacci hasta n.
    """
    a, b = 0, 1
    count = 0
    while count < n:
        yield a
        a, b = b, a + b
        count += 1


def generador_pares(inicio, fin):
    """
    Generador de numeros pares en un rango.
    """
    for num in range(inicio, fin + 1):
        if num % 2 == 0:
            yield num


def generador_lineas_archivo(nombre_archivo):
    """
    Generador que lee un archivo linea por linea.
    Simulado con datos en memoria.
    """
    lineas_simuladas = [
        "Primera linea del archivo",
        "Segunda linea con datos",
        "Tercera linea de ejemplo",
        "Cuarta linea final",
    ]
    for linea in lineas_simuladas:
        yield linea.strip()


# ============================================================================
# EJERCICIO 6: Recursividad
# ============================================================================
def factorial_recursivo(n):
    """
    Calcula factorial usando recursion.
    """
    if n < 0:
        raise ValueError("El factorial no esta definido para negativos")
    if n == 0 or n == 1:
        return 1
    return n * factorial_recursivo(n - 1)


def potencia_recursiva(base, exponente):
    """
    Calcula base^exponente usando recursion.
    """
    if exponente == 0:
        return 1
    if exponente < 0:
        return 1 / potencia_recursiva(base, -exponente)
    return base * potencia_recursiva(base, exponente - 1)


def suma_digitos_recursiva(n):
    """
    Suma los digitos de un numero usando recursion.
    """
    if n == 0:
        return 0
    return (n % 10) + suma_digitos_recursiva(n // 10)


# ============================================================================
# EJERCICIO 7: Manejo de JSON
# ============================================================================
def crear_json_simple(datos):
    """
    Convierte datos de Python a string JSON formateado.
    """
    return json.dumps(datos, indent=2, ensure_ascii=False)


def parsear_json(cadena_json):
    """
    Convierte string JSON a datos de Python.
    """
    try:
        return json.loads(cadena_json)
    except json.JSONDecodeError as e:
        return {"error": f"JSON invalido: {str(e)}"}


def validar_esquema_simple(datos, esquema):
    """
    Valida que los datos cumplan con un esquema simple.

    Args:
        datos: diccionario a validar
        esquema: diccionario con {campo: tipo}

    Returns:
        (bool, list): (es_valido, lista_errores)
    """
    errores = []

    for campo, tipo_esperado in esquema.items():
        if campo not in datos:
            errores.append(f"Campo obligatorio faltante: {campo}")
        elif not isinstance(datos[campo], tipo_esperado):
            errores.append(
                f"Campo '{campo}' debe ser {tipo_esperado.__name__}, "
                f"se encontro {type(datos[campo]).__name__}"
            )

    return len(errores) == 0, errores


# ============================================================================
# EJERCICIO 8: Simulacion de clases con diccionarios
# ============================================================================
def crear_cuenta_bancaria(titular, saldo_inicial=0):
    """
    Crea una 'cuenta bancaria' usando diccionarios y closures.
    Preparacion para el concepto de clases.
    """
    cuenta = {
        "titular": titular,
        "saldo": saldo_inicial,
        "historial": [],
        "activa": True,
    }

    def depositar(monto):
        if monto <= 0:
            return False, "El monto debe ser positivo"
        cuenta["saldo"] += monto
        cuenta["historial"].append(
            {"tipo": "deposito", "monto": monto, "fecha": datetime.now().isoformat()}
        )
        return True, f"Deposito exitoso. Saldo: {cuenta['saldo']}"

    def retirar(monto):
        if monto <= 0:
            return False, "El monto debe ser positivo"
        if monto > cuenta["saldo"]:
            return False, "Saldo insuficiente"
        cuenta["saldo"] -= monto
        cuenta["historial"].append(
            {"tipo": "retiro", "monto": monto, "fecha": datetime.now().isoformat()}
        )
        return True, f"Retiro exitoso. Saldo: {cuenta['saldo']}"

    def obtener_saldo():
        return cuenta["saldo"]

    def obtener_estado():
        return {
            "titular": cuenta["titular"],
            "saldo": cuenta["saldo"],
            "transacciones": len(cuenta["historial"]),
            "activa": cuenta["activa"],
        }

    # Retornar metodos como diccionario
    return {
        "depositar": depositar,
        "retirar": retirar,
        "saldo": obtener_saldo,
        "estado": obtener_estado,
    }


# ============================================================================
# EJERCICIO 9: Algoritmos de busqueda y ordenamiento
# ============================================================================
def busqueda_binaria(lista_ordenada, objetivo):
    """
    Busqueda binaria en una lista ordenada.
    Retorna el indice o -1 si no se encuentra.
    """
    izquierda = 0
    derecha = len(lista_ordenada) - 1

    while izquierda <= derecha:
        medio = (izquierda + derecha) // 2
        if lista_ordenada[medio] == objetivo:
            return medio
        elif lista_ordenada[medio] < objetivo:
            izquierda = medio + 1
        else:
            derecha = medio - 1

    return -1


def ordenamiento_burbuja(lista):
    """
    Ordenamiento de burbuja (educativo, no eficiente).
    """
    lista = lista.copy()
    n = len(lista)

    for i in range(n):
        for j in range(0, n - i - 1):
            if lista[j] > lista[j + 1]:
                lista[j], lista[j + 1] = lista[j + 1], lista[j]

    return lista


def ordenamiento_por_seleccion(lista):
    """
    Ordenamiento por seleccion.
    """
    lista = lista.copy()
    n = len(lista)

    for i in range(n):
        min_idx = i
        for j in range(i + 1, n):
            if lista[j] < lista[min_idx]:
                min_idx = j
        lista[i], lista[min_idx] = lista[min_idx], lista[i]

    return lista


# ============================================================================
# EJERCICIO 10: Manejo de fechas y tiempo
# ============================================================================
def calcular_edad(fecha_nacimiento: str) -> int:
    """
    Calcula la edad a partir de una fecha de nacimiento.
    Formato: "YYYY-MM-DD"
    """
    try:
        nacimiento = datetime.strptime(fecha_nacimiento, "%Y-%m-%d")
        hoy = datetime.now()
        edad = hoy.year - nacimiento.year

        # Ajustar si aun no cumple anios este anio
        if (hoy.month, hoy.day) < (nacimiento.month, nacimiento.day):
            edad -= 1

        return edad
    except ValueError:
        return -1


def dias_entre_fechas(fecha1: str, fecha2: str) -> int:
    """
    Calcula los dias entre dos fechas.
    """
    try:
        f1 = datetime.strptime(fecha1, "%Y-%m-%d")
        f2 = datetime.strptime(fecha2, "%Y-%m-%d")
        return abs((f2 - f1).days)
    except ValueError:
        return -1


def generar_calendario_mes(anio: int, mes: int) -> List[List[Optional[int]]]:
    """
    Genera una matriz representando un calendario mensual.
    """
    # Primer dia del mes
    primer_dia = datetime(anio, mes, 1)

    # Ultimo dia del mes (aproximado)
    if mes == 12:
        ultimo_dia = datetime(anio + 1, 1, 1) - timedelta(days=1)
    else:
        ultimo_dia = datetime(anio, mes + 1, 1) - timedelta(days=1)

    total_dias = ultimo_dia.day
    dia_semana_inicio = primer_dia.weekday()  # 0 = Lunes

    calendario = []
    semana = [None] * 7
    dia_actual = 1

    # Llenar primera semana
    for i in range(dia_semana_inicio, 7):
        semana[i] = dia_actual
        dia_actual += 1
    calendario.append(semana)

    # Llenar semanas restantes
    while dia_actual <= total_dias:
        semana = []
        for i in range(7):
            if dia_actual <= total_dias:
                semana.append(dia_actual)
                dia_actual += 1
            else:
                semana.append(None)
        calendario.append(semana)

    return calendario


# ============================================================================
# MAIN
# ============================================================================
def main():
    print("=" * 60)
    print("EJERCICIOS AVANZADOS - PUENTE AL MODULO 01")
    print("=" * 60)

    print("\n1. Funciones de orden superior:")
    numeros = [1, 2, 3, 4, 5]
    cuadrados = aplicar_a_todos(lambda x: x**2, numeros)
    print(f"   Cuadrados de {numeros}: {cuadrados}")

    pares = filtrar_por_criterio(lambda x: x % 2 == 0, numeros)
    print(f"   Pares: {pares}")

    suma_total = reducir_lista(lambda x, y: x + y, numeros, 0)
    print(f"   Suma total: {suma_total}")

    print("\n2. Comprensiones anidadas:")
    tabla = generar_tabla_multiplicar(5)
    print("   Tabla 5x5:")
    for fila in tabla:
        print(f"   {fila}")

    print("\n3. Analisis de ventas:")
    ventas_ejemplo = [
        {"producto": "Laptop", "cantidad": 2, "precio": 800, "fecha": "2024-01-15"},
        {"producto": "Mouse", "cantidad": 5, "precio": 25, "fecha": "2024-01-15"},
        {"producto": "Laptop", "cantidad": 1, "precio": 800, "fecha": "2024-01-16"},
        {"producto": "Teclado", "cantidad": 3, "precio": 60, "fecha": "2024-01-16"},
    ]
    stats = analizar_ventas(ventas_ejemplo)
    print(f"   Total ventas: ${stats['total_ventas']}")
    print(f"   Producto top: {stats['producto_mas_vendido']}")
    print(f"   Transacciones: {stats['total_transacciones']}")

    print("\n4. Decoradores:")
    print("   Probando contador de llamadas:")
    for nombre in ["Ana", "Carlos", "Maria"]:
        print(f"   {saludar_usuario(nombre)}")

    print("\n5. Generadores:")
    print("   Primeros 10 Fibonacci:")
    fibs = list(generador_fibonacci(10))
    print(f"   {fibs}")

    print("\n6. Recursividad:")
    print(f"   Factorial de 5: {factorial_recursivo(5)}")
    print(f"   2^10: {potencia_recursiva(2, 10)}")
    print(f"   Suma digitos de 12345: {suma_digitos_recursiva(12345)}")

    print("\n7. JSON:")
    datos = {"nombre": "Python", "version": 3.9, "activo": True}
    json_str = crear_json_simple(datos)
    print("   JSON generado:")
    print(json_str)

    print("\n8. Cuenta bancaria (simulacion de clase):")
    cuenta = crear_cuenta_bancaria("Juan Perez", 1000)
    exito, msg = cuenta["depositar"](500)
    print(f"   {msg}")
    exito, msg = cuenta["retirar"](200)
    print(f"   {msg}")
    estado = cuenta["estado"]()
    print(f"   Estado: {estado}")

    print("\n9. Busqueda y ordenamiento:")
    lista = [64, 34, 25, 12, 22, 11, 90]
    print(f"   Lista original: {lista}")
    ordenada = ordenamiento_burbuja(lista)
    print(f"   Ordenada: {ordenada}")
    idx = busqueda_binaria(ordenada, 25)
    print(f"   Posicion de 25: {idx}")

    print("\n10. Fechas:")
    edad = calcular_edad("1990-05-15")
    print(f"   Edad de alguien nacido en 1990-05-15: {edad} anios")
    dias = dias_entre_fechas("2024-01-01", "2024-12-31")
    print(f"   Dias entre 2024-01-01 y 2024-12-31: {dias}")


if __name__ == "__main__":
    main()

"""
Soluciones Extra - 00 Fundamentos Absolutos
Ejercicios adicionales para practica intensiva.
"""

import random
from datetime import datetime


# ============================================================================
# SECCION 1: Calculos y matematicas
# ============================================================================
def calcular_imc(peso, altura):
    """
    Calcula el Indice de Masa Corporal (IMC).
    Formula: peso / (altura^2)

    Returns:
        tuple: (valor_imc, categoria)
    """
    imc = peso / (altura**2)

    if imc < 18.5:
        categoria = "Bajo peso"
    elif imc < 25:
        categoria = "Peso normal"
    elif imc < 30:
        categoria = "Sobrepeso"
    else:
        categoria = "Obesidad"

    return (round(imc, 2), categoria)


def calcular_interes_compuesto(capital, tasa, tiempo, capitalizacion=12):
    """
    Calcula el monto final con interes compuesto.

    Args:
        capital: monto inicial
        tasa: tasa de interes anual (decimal, ej: 0.05 para 5%)
        tiempo: tiempo en anios
        capitalizacion: numero de capitalizaciones por anio
    """
    monto = capital * (1 + tasa / capitalizacion) ** (capitalizacion * tiempo)
    return round(monto, 2)


def es_numero_perfecto(n):
    """
    Un numero perfecto es igual a la suma de sus divisores propios.
    Ejemplo: 6 = 1 + 2 + 3
    """
    if n < 2:
        return False

    suma_divisores = 1
    for i in range(2, int(n**0.5) + 1):
        if n % i == 0:
            suma_divisores += i
            if i != n // i:
                suma_divisores += n // i

    return suma_divisores == n


def serie_fibonacci(n):
    """
    Genera los primeros n numeros de la serie Fibonacci.
    Ejemplo: 0, 1, 1, 2, 3, 5, 8, 13...
    """
    if n <= 0:
        return []
    elif n == 1:
        return [0]

    fib = [0, 1]
    while len(fib) < n:
        fib.append(fib[-1] + fib[-2])

    return fib


# ============================================================================
# SECCION 2: Juegos y logica
# ============================================================================
def adivina_el_numero():
    """
    Juego: adivina un numero entre 1 y 100.
    Simulacion de partida.
    """
    numero_secreto = random.randint(1, 100)
    intentos = [50, 25, 37, 43, 40, 42]  # Simulacion de intentos

    for intento in intentos:
        if intento == numero_secreto:
            return ("ganado", intentos)
        elif intento < numero_secreto:
            continue
        else:
            continue

    return ("perdido", intentos)


def juego_piedra_papel_tijeras(eleccion_jugador):
    """
    Juego de piedra, papel o tijeras.
    """
    opciones = ["piedra", "papel", "tijeras"]
    eleccion_computadora = random.choice(opciones)

    if eleccion_jugador == eleccion_computadora:
        resultado = "empate"
    elif (
        (eleccion_jugador == "piedra" and eleccion_computadora == "tijeras")
        or (eleccion_jugador == "papel" and eleccion_computadora == "piedra")
        or (eleccion_jugador == "tijeras" and eleccion_computadora == "papel")
    ):
        resultado = "ganaste"
    else:
        resultado = "perdiste"

    return {
        "jugador": eleccion_jugador,
        "computadora": eleccion_computadora,
        "resultado": resultado,
    }


# ============================================================================
# SECCION 3: Fechas y tiempo
# ============================================================================
def dias_hasta_fecha(fecha_objetivo):
    """
    Calcula los dias faltantes hasta una fecha especifica.
    """
    hoy = datetime.now()
    diferencia = fecha_objetivo - hoy
    return diferencia.days


def formato_fecha_larga(fecha):
    """
    Convierte una fecha a formato largo en espanol.
    Ejemplo: "12 de febrero de 2026"
    """
    meses = [
        "enero",
        "febrero",
        "marzo",
        "abril",
        "mayo",
        "junio",
        "julio",
        "agosto",
        "septiembre",
        "octubre",
        "noviembre",
        "diciembre",
    ]

    return f"{fecha.day} de {meses[fecha.month - 1]} de {fecha.year}"


def es_fin_de_semana(fecha):
    """
    Determina si una fecha cae en fin de semana.
    5 = Sabado, 6 = Domingo
    """
    return fecha.weekday() >= 5


# ============================================================================
# SECCION 4: Listas y diccionarios avanzados
# ============================================================================
def ordenar_diccionario_por_valor(diccionario, reverse=False):
    """
    Ordena un diccionario por sus valores.

    Returns:
        list: lista de tuplas (clave, valor) ordenadas
    """
    return sorted(diccionario.items(), key=lambda x: x[1], reverse=reverse)


def agrupar_por_longitud(lista_strings):
    """
    Agrupa strings por su longitud.

    Returns:
        dict: {longitud: [strings]}
    """
    grupos = {}
    for string in lista_strings:
        longitud = len(string)
        if longitud not in grupos:
            grupos[longitud] = []
        grupos[longitud].append(string)
    return grupos


def encontrar_duplicados(lista):
    """
    Encuentra todos los elementos duplicados en una lista.

    Returns:
        list: elementos que aparecen mas de una vez
    """
    vistos = set()
    duplicados = set()

    for elemento in lista:
        if elemento in vistos:
            duplicados.add(elemento)
        else:
            vistos.add(elemento)

    return list(duplicados)


def matriz_transpuesta(matriz):
    """
    Calcula la transpuesta de una matriz.
    """
    filas = len(matriz)
    columnas = len(matriz[0])

    transpuesta = []
    for j in range(columnas):
        nueva_fila = []
        for i in range(filas):
            nueva_fila.append(matriz[i][j])
        transpuesta.append(nueva_fila)

    return transpuesta


# ============================================================================
# SECCION 5: Analisis de texto
# ============================================================================
def analisis_texto_completo(texto):
    """
    Realiza un analisis completo de un texto.

    Returns:
        dict: estadisticas del texto
    """
    palabras = texto.split()
    caracteres_con_espacios = len(texto)
    caracteres_sin_espacios = len(texto.replace(" ", ""))

    # Contar oraciones (aproximado por puntos)
    oraciones = len([c for c in texto if c in ".!?"])

    # Longitud promedio de palabras
    longitudes = [len(p) for p in palabras]
    promedio_longitud = sum(longitudes) / len(longitudes) if longitudes else 0

    return {
        "total_palabras": len(palabras),
        "total_caracteres_con_espacios": caracteres_con_espacios,
        "total_caracteres_sin_espacios": caracteres_sin_espacios,
        "total_oraciones": oraciones,
        "promedio_longitud_palabra": round(promedio_longitud, 2),
        "palabra_mas_larga": max(palabras, key=len) if palabras else "",
    }


def censurar_palabras(texto, palabras_prohibidas):
    """
    Reemplaza palabras prohibidas con asteriscos.
    """
    resultado = texto
    for palabra in palabras_prohibidas:
        censura = "*" * len(palabra)
        resultado = resultado.replace(palabra, censura)
    return resultado


# ============================================================================
# MAIN
# ============================================================================
def main():
    print("=" * 60)
    print("EJERCICIOS EXTRA - PRACTICA INTENSIVA")
    print("=" * 60)

    print("\n1. Calculo de IMC:")
    peso = 70
    altura = 1.75
    imc, categoria = calcular_imc(peso, altura)
    print(f"   Peso: {peso}kg, Altura: {altura}m")
    print(f"   IMC: {imc} - {categoria}")

    print("\n2. Interes compuesto:")
    capital = 1000
    tasa = 0.05
    tiempo = 10
    monto = calcular_interes_compuesto(capital, tasa, tiempo)
    print(f"   Capital: ${capital}, Tasa: {tasa * 100}%, Tiempo: {tiempo} anios")
    print(f"   Monto final: ${monto}")
    print(f"   Ganancia: ${monto - capital}")

    print("\n3. Numeros perfectos:")
    perfectos = [n for n in range(1, 1000) if es_numero_perfecto(n)]
    print(f"   Numeros perfectos hasta 1000: {perfectos}")

    print("\n4. Serie Fibonacci (10 terminos):")
    fib = serie_fibonacci(10)
    print(f"   {fib}")

    print("\n5. Piedra, Papel o Tijeras:")
    resultado = juego_piedra_papel_tijeras("piedra")
    print(f"   Tu: {resultado['jugador']}")
    print(f"   PC: {resultado['computadora']}")
    print(f"   Resultado: {resultado['resultado']}")

    print("\n6. Fecha actual en formato largo:")
    hoy = datetime.now()
    print(f"   {formato_fecha_larga(hoy)}")

    print("\n7. Ordenar diccionario:")
    puntajes = {"Ana": 85, "Carlos": 92, "Maria": 78, "Luis": 95}
    ordenado = ordenar_diccionario_por_valor(diccionario=puntajes, reverse=True)
    print(f"   Puntajes ordenados: {ordenado}")

    print("\n8. Agrupar por longitud:")
    palabras = ["sol", "luna", "estrella", "mar", "rio", "montania"]
    agrupado = agrupar_por_longitud(palabras)
    for longitud, lista in sorted(agrupado.items()):
        print(f"   Longitud {longitud}: {lista}")

    print("\n9. Matriz y su transpuesta:")
    matriz = [[1, 2, 3], [4, 5, 6]]
    transpuesta = matriz_transpuesta(matriz)
    print(f"   Original: {matriz}")
    print(f"   Transpuesta: {transpuesta}")

    print("\n10. Analisis de texto:")
    texto = "Python es un lenguaje de programacion muy poderoso. Es facil de aprender."
    analisis = analisis_texto_completo(texto)
    for metrica, valor in analisis.items():
        print(f"   {metrica}: {valor}")


if __name__ == "__main__":
    main()

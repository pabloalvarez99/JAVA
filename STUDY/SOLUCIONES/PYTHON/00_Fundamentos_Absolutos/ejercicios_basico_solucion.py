"""
Soluciones Basicas - 00 Fundamentos Absolutos
Ejercicios de consolidacion de conceptos basicos.
"""


# ============================================================================
# EJERCICIO 1: Variables y operaciones
# ============================================================================
def calcular_area_rectangulo(base, altura):
    """
    Calcula el area de un rectangulo.

    Args:
        base: float - base del rectangulo
        altura: float - altura del rectangulo

    Returns:
        float - area del rectangulo
    """
    return base * altura


def calcular_perimetro_rectangulo(base, altura):
    """
    Calcula el perimetro de un rectangulo.
    """
    return 2 * (base + altura)


# ============================================================================
# EJERCICIO 2: Conversiones
# ============================================================================
def celsius_a_fahrenheit(celsius):
    """
    Convierte grados Celsius a Fahrenheit.
    Formula: F = (C * 9/5) + 32
    """
    return (celsius * 9 / 5) + 32


def fahrenheit_a_celsius(fahrenheit):
    """
    Convierte grados Fahrenheit a Celsius.
    Formula: C = (F - 32) * 5/9
    """
    return (fahrenheit - 32) * 5 / 9


# ============================================================================
# EJERCICIO 3: Condicionales
# ============================================================================
def clasificar_numero(numero):
    """
    Clasifica un numero como positivo, negativo o cero.
    Y ademas dice si es par o impar.

    Returns:
        str - clasificacion completa
    """
    signo = ""
    if numero > 0:
        signo = "positivo"
    elif numero < 0:
        signo = "negativo"
    else:
        signo = "cero"

    paridad = "par" if numero % 2 == 0 else "impar"

    return f"El numero {numero} es {signo} y {paridad}"


def es_bisiesto(anio):
    """
    Determina si un anio es bisiesto.
    Un anio es bisiesto si:
    - Es divisible por 4, pero no por 100, o
    - Es divisible por 400
    """
    return (anio % 4 == 0 and anio % 100 != 0) or (anio % 400 == 0)


# ============================================================================
# EJERCICIO 4: Bucles
# ============================================================================
def suma_naturales(n):
    """
    Calcula la suma de los primeros n numeros naturales.
    Ejemplo: suma_naturales(5) = 1 + 2 + 3 + 4 + 5 = 15
    """
    total = 0
    for i in range(1, n + 1):
        total += i
    return total


def factorial(n):
    """
    Calcula el factorial de n (n!).
    Ejemplo: factorial(5) = 5 * 4 * 3 * 2 * 1 = 120
    """
    if n < 0:
        return None
    if n == 0 or n == 1:
        return 1

    resultado = 1
    for i in range(2, n + 1):
        resultado *= i
    return resultado


def numeros_primos_hasta(n):
    """
    Retorna una lista de numeros primos hasta n (inclusive).
    """
    if n < 2:
        return []

    primos = []
    for numero in range(2, n + 1):
        es_primo = True
        for divisor in range(2, int(numero**0.5) + 1):
            if numero % divisor == 0:
                es_primo = False
                break
        if es_primo:
            primos.append(numero)

    return primos


# ============================================================================
# EJERCICIO 5: Listas
# ============================================================================
def encontrar_maximo(lista):
    """
    Encuentra el valor maximo en una lista.
    No usar funcion max() de Python.
    """
    if not lista:
        return None

    maximo = lista[0]
    for numero in lista[1:]:
        if numero > maximo:
            maximo = numero
    return maximo


def encontrar_minimo(lista):
    """
    Encuentra el valor minimo en una lista.
    """
    if not lista:
        return None

    minimo = lista[0]
    for numero in lista[1:]:
        if numero < minimo:
            minimo = numero
    return minimo


def calcular_promedio(lista):
    """
    Calcula el promedio de los numeros en una lista.
    """
    if not lista:
        return 0
    return sum(lista) / len(lista)


def invertir_lista(lista):
    """
    Invierte el orden de los elementos de una lista.
    No usar reverse() ni slicing [::-1].
    """
    invertida = []
    for i in range(len(lista) - 1, -1, -1):
        invertida.append(lista[i])
    return invertida


def eliminar_duplicados(lista):
    """
    Elimina elementos duplicados manteniendo el orden.
    """
    resultado = []
    for elemento in lista:
        if elemento not in resultado:
            resultado.append(elemento)
    return resultado


# ============================================================================
# EJERCICIO 6: Strings
# ============================================================================
def contar_vocales(texto):
    """
    Cuenta el numero de vocales en un texto.
    """
    vocales = "aeiouAEIOU"
    contador = 0
    for caracter in texto:
        if caracter in vocales:
            contador += 1
    return contador


def es_palindromo(texto):
    """
    Determina si un texto es palindromo (se lee igual al reves).
    Ignora espacios y mayusculas/minusculas.
    """
    texto_limpio = texto.replace(" ", "").lower()
    return texto_limpio == texto_limpio[::-1]


def contar_palabras(texto):
    """
    Cuenta el numero de palabras en un texto.
    """
    palabras = texto.split()
    return len(palabras)


# ============================================================================
# EJERCICIO 7: Diccionarios
# ============================================================================
def frecuencia_caracteres(texto):
    """
    Cuenta la frecuencia de cada caracter en un texto.

    Returns:
        dict - diccionario con caracter:frecuencia
    """
    frecuencia = {}
    for caracter in texto:
        if caracter in frecuencia:
            frecuencia[caracter] += 1
        else:
            frecuencia[caracter] = 1
    return frecuencia


def palabra_mas_frecuente(texto):
    """
    Encuentra la palabra mas frecuente en un texto.
    """
    palabras = texto.lower().split()
    frecuencia = {}

    for palabra in palabras:
        palabra = palabra.strip(".,!?;:")
        frecuencia[palabra] = frecuencia.get(palabra, 0) + 1

    if not frecuencia:
        return None

    return max(frecuencia, key=frecuencia.get)


# ============================================================================
# EJERCICIO 8: Funciones avanzadas
# ============================================================================
def validar_edad(edad):
    """
    Valida que la edad sea un numero entero positivo.
    Retorna True si es valida, False en caso contrario.
    """
    try:
        edad_int = int(edad)
        return edad_int > 0
    except (ValueError, TypeError):
        return False


def validar_email(email):
    """
    Valida formato basico de email.
    Debe contener @ y al menos un punto despues del @.
    """
    if "@" not in email:
        return False

    partes = email.split("@")
    if len(partes) != 2:
        return False

    dominio = partes[1]
    return "." in dominio


# ============================================================================
# MAIN - Demostracion de ejercicios
# ============================================================================
def main():
    print("=" * 60)
    print("EJERCICIOS BASICOS - FUNDAMENTOS ABSOLUTOS")
    print("=" * 60)

    print("\n1. Areas y perimetros:")
    print(f"   Area rectangulo 5x3: {calcular_area_rectangulo(5, 3)}")
    print(f"   Perimetro rectangulo 5x3: {calcular_perimetro_rectangulo(5, 3)}")

    print("\n2. Conversion de temperaturas:")
    print(f"   0°C a Fahrenheit: {celsius_a_fahrenheit(0)}")
    print(f"   32°F a Celsius: {fahrenheit_a_celsius(32)}")
    print(f"   100°C a Fahrenheit: {celsius_a_fahrenheit(100)}")

    print("\n3. Clasificacion de numeros:")
    print(f"   {clasificar_numero(7)}")
    print(f"   {clasificar_numero(-4)}")
    print(f"   {clasificar_numero(0)}")

    print("\n4. Anio bisiesto:")
    print(f"   ¿2024 es bisiesto? {es_bisiesto(2024)}")
    print(f"   ¿2023 es bisiesto? {es_bisiesto(2023)}")

    print("\n5. Suma de naturales y factorial:")
    print(f"   Suma 1-10: {suma_naturales(10)}")
    print(f"   Factorial de 5: {factorial(5)}")

    print("\n6. Numeros primos hasta 20:")
    print(f"   {numeros_primos_hasta(20)}")

    print("\n7. Operaciones con listas:")
    numeros = [23, 56, 12, 89, 34, 5]
    print(f"   Lista: {numeros}")
    print(f"   Maximo: {encontrar_maximo(numeros)}")
    print(f"   Minimo: {encontrar_minimo(numeros)}")
    print(f"   Promedio: {calcular_promedio(numeros):.2f}")
    print(f"   Invertida: {invertir_lista(numeros)}")

    print("\n8. Eliminacion de duplicados:")
    con_duplicados = [1, 2, 2, 3, 3, 3, 4, 5, 5]
    print(f"   Original: {con_duplicados}")
    print(f"   Sin duplicados: {eliminar_duplicados(con_duplicados)}")

    print("\n9. Manipulacion de strings:")
    texto = "Hola Mundo"
    print(f"   Texto: '{texto}'")
    print(f"   Vocales: {contar_vocales(texto)}")
    print(
        f"   ¿Es palindromo 'Anita lava la tina'?: {es_palindromo('Anita lava la tina')}"
    )
    print(f"   Palabras en '{texto}': {contar_palabras(texto)}")

    print("\n10. Diccionarios:")
    texto_freq = "hola mundo hola python"
    print(f"   Frecuencia en '{texto_freq}': {frecuencia_caracteres(texto_freq)}")
    print(f"   Palabra mas frecuente: '{palabra_mas_frecuente(texto_freq)}'")

    print("\n11. Validaciones:")
    print(f"   ¿Edad '25' valida?: {validar_edad('25')}")
    print(f"   ¿Edad '-5' valida?: {validar_edad('-5')}")
    print(f"   ¿Email 'test@example.com' valido?: {validar_email('test@example.com')}")
    print(f"   ¿Email 'invalido' valido?: {validar_email('invalido')}")


if __name__ == "__main__":
    main()

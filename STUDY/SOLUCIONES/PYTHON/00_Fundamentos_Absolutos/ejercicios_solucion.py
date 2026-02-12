"""
Soluciones - 00 Fundamentos Absolutos
Ejercicios introductorios para quien nunca ha programado.
"""


# ============================================================================
# EJERCICIO 1: Tu primer programa
# ============================================================================
def ejercicio_1():
    """
    Imprime "Hola Mundo" en pantalla.
    """
    print("Hola Mundo")


# ============================================================================
# EJERCICIO 2: Variables y tipos basicos
# ============================================================================
def ejercicio_2():
    """
    Crea variables de diferentes tipos e imprimelas.
    """
    nombre = "Ana"
    edad = 25
    altura = 1.68
    es_estudiante = True

    print("Nombre:", nombre)
    print("Edad:", edad)
    print("Altura:", altura)
    print("Es estudiante:", es_estudiante)


# ============================================================================
# EJERCICIO 3: Operaciones matematicas basicas
# ============================================================================
def ejercicio_3():
    """
    Realiza operaciones matematicas simples.
    """
    a = 10
    b = 3

    print("Suma:", a + b)
    print("Resta:", a - b)
    print("Multiplicacion:", a * b)
    print("Division:", a / b)
    print("Division entera:", a // b)
    print("Resto (modulo):", a % b)
    print("Potencia:", a**b)


# ============================================================================
# EJERCICIO 4: Input del usuario
# ============================================================================
def ejercicio_4():
    """
    Pide el nombre al usuario y saludalo.
    Simulado para ejecucion automatica.
    """
    # Simulando input - en practica real usar: nombre = input("¿Como te llamas? ")
    nombre = "Estudiante"
    print(f"(Simulando input...)")
    print("Hola, " + nombre + "! Bienvenido a Python.")


# ============================================================================
# EJERCICIO 5: Conversion de tipos
# ============================================================================
def ejercicio_5():
    """
    Convierte string a numero y realiza operaciones.
    """
    numero_str = "42"
    numero = int(numero_str)

    print("Numero original (string):", numero_str)
    print("Numero convertido (int):", numero)
    print("El doble es:", numero * 2)

    decimal_str = "3.14"
    decimal = float(decimal_str)
    print("Decimal:", decimal)


# ============================================================================
# EJERCICIO 6: Formato de strings
# ============================================================================
def ejercicio_6():
    """
    Usa diferentes formas de formatear strings.
    """
    nombre = "Carlos"
    edad = 30

    print("Me llamo " + nombre + " y tengo " + str(edad) + " anos.")
    print(f"Me llamo {nombre} y tengo {edad} anos.")
    print("Me llamo {} y tengo {} anos.".format(nombre, edad))


# ============================================================================
# EJERCICIO 7: Condicionales simples (if/else)
# ============================================================================
def ejercicio_7():
    """
    Determina si un numero es positivo, negativo o cero.
    """
    numero = 15

    if numero > 0:
        print(f"{numero} es positivo")
    elif numero < 0:
        print(f"{numero} es negativo")
    else:
        print(f"{numero} es cero")


# ============================================================================
# EJERCICIO 8: Operadores logicos
# ============================================================================
def ejercicio_8():
    """
    Combina condiciones con and, or, not.
    """
    edad = 25
    tiene_licencia = True

    if edad >= 18 and tiene_licencia:
        print("Puede conducir")

    es_estudiante = False
    if edad < 25 or es_estudiante:
        print("Tiene descuento juvenil")

    if not es_estudiante:
        print("No es estudiante")


# ============================================================================
# EJERCICIO 9: Bucles for basicos
# ============================================================================
def ejercicio_9():
    """
    Recorre rangos con bucles for.
    """
    print("Del 0 al 4:")
    for i in range(5):
        print(i)

    print("\nDel 1 al 5:")
    for i in range(1, 6):
        print(i)

    print("\nPares del 0 al 10:")
    for i in range(0, 11, 2):
        print(i)


# ============================================================================
# EJERCICIO 10: Listas basicas
# ============================================================================
def ejercicio_10():
    """
    Crea y manipula listas simples.
    """
    frutas = ["manzana", "banana", "cereza"]

    print("Lista completa:", frutas)
    print("Primera fruta:", frutas[0])
    print("Ultima fruta:", frutas[-1])
    print("Total de frutas:", len(frutas))

    frutas.append("naranja")
    print("Despues de agregar:", frutas)


# ============================================================================
# EJERCICIO 11: Recorrer listas
# ============================================================================
def ejercicio_11():
    """
    Recorre una lista con for.
    """
    colores = ["rojo", "verde", "azul", "amarillo"]

    print("Colores:")
    for color in colores:
        print(f"- {color}")

    print("\nCon indice:")
    for i, color in enumerate(colores):
        print(f"{i}: {color}")


# ============================================================================
# EJERCICIO 12: While loop
# ============================================================================
def ejercicio_12():
    """
    Usa while para contar.
    """
    contador = 0

    print("Contando hasta 5:")
    while contador <= 5:
        print(contador)
        contador += 1

    print("Termine!")


# ============================================================================
# EJERCICIO 13: Bucles anidados
# ============================================================================
def ejercicio_13():
    """
    Tabla de multiplicar simple.
    """
    print("Tabla del 3:")
    for i in range(1, 11):
        resultado = 3 * i
        print(f"3 x {i} = {resultado}")


# ============================================================================
# EJERCICIO 14: Diccionarios basicos
# ============================================================================
def ejercicio_14():
    """
    Crea y usa diccionarios simples.
    """
    persona = {"nombre": "Maria", "edad": 28, "ciudad": "Madrid"}

    print("Nombre:", persona["nombre"])
    print("Edad:", persona["edad"])

    persona["profesion"] = "Ingeniera"
    print("Profesion:", persona["profesion"])

    print("\nDatos completos:")
    for clave, valor in persona.items():
        print(f"{clave}: {valor}")


# ============================================================================
# EJERCICIO 15: Metodos de strings
# ============================================================================
def ejercicio_15():
    """
    Manipula strings con metodos utiles.
    """
    texto = "  Python es Genial  "

    print("Original:", repr(texto))
    print("Mayusculas:", texto.upper())
    print("Minusculas:", texto.lower())
    print("Sin espacios:", texto.strip())
    print("Reemplazar:", texto.replace("Genial", "Increible"))
    print("¿Empieza con 'Python'?:", texto.strip().startswith("Python"))


# ============================================================================
# EJERCICIO 16: Funciones simples
# ============================================================================
def saludar(nombre):
    """Retorna un saludo personalizado."""
    return f"Hola, {nombre}!"


def sumar(a, b):
    """Retorna la suma de dos numeros."""
    return a + b


def es_par(numero):
    """Retorna True si el numero es par."""
    return numero % 2 == 0


def ejercicio_16():
    """
    Usa funciones simples.
    """
    print(saludar("Ana"))
    print("5 + 3 =", sumar(5, 3))
    print("¿4 es par?", es_par(4))
    print("¿7 es par?", es_par(7))


# ============================================================================
# EJERCICIO 17: List comprehension basica
# ============================================================================
def ejercicio_17():
    """
    Crea listas de forma concisa.
    """
    cuadrados = [x**2 for x in range(1, 6)]
    print("Cuadrados:", cuadrados)

    pares = [x for x in range(1, 11) if x % 2 == 0]
    print("Pares:", pares)

    palabras = ["hola", "mundo", "python"]
    mayusculas = [p.upper() for p in palabras]
    print("En mayusculas:", mayusculas)


# ============================================================================
# EJERCICIO 18: Manejo basico de errores
# ============================================================================
def ejercicio_18():
    """
    Captura errores simples con try/except.
    """
    try:
        resultado = 10 / 0
        print(resultado)
    except ZeroDivisionError:
        print("Error: No se puede dividir por cero")

    try:
        numero = int("abc")
        print(numero)
    except ValueError:
        print("Error: No se puede convertir 'abc' a numero")

    print("El programa continua...")


# ============================================================================
# EJERCICIO 19: Tuplas y conjuntos
# ============================================================================
def ejercicio_19():
    """
    Usa tuplas (inmutables) y conjuntos (unicos).
    """
    coordenadas = (10, 20)
    print("Coordenadas:", coordenadas)
    print("X:", coordenadas[0])

    numeros = {1, 2, 2, 3, 3, 3, 4}
    print("Conjunto (sin duplicados):", numeros)

    a = {1, 2, 3}
    b = {2, 3, 4}
    print("Interseccion:", a & b)
    print("Union:", a | b)


# ============================================================================
# EJERCICIO 20: Ejercicio integrador simple
# ============================================================================
def ejercicio_20():
    """
    Calculadora simple que suma dos numeros.
    """
    print("=== Calculadora Simple ===")

    num1_str = "15"
    num2_str = "25"

    try:
        num1 = float(num1_str)
        num2 = float(num2_str)

        suma = num1 + num2
        resta = num1 - num2
        multiplicacion = num1 * num2
        division = num1 / num2 if num2 != 0 else "Error: division por cero"

        print(f"Numero 1: {num1}")
        print(f"Numero 2: {num2}")
        print(f"Suma: {suma}")
        print(f"Resta: {resta}")
        print(f"Multiplicacion: {multiplicacion}")
        print(f"Division: {division}")

    except ValueError:
        print("Error: Por favor ingresa numeros validos")


# ============================================================================
# FUNCION MAIN PARA EJECUTAR TODOS LOS EJERCICIOS
# ============================================================================
def main():
    """Ejecuta todos los ejercicios."""
    ejercicios = [
        ("Ejercicio 1: Tu primer programa", ejercicio_1),
        ("Ejercicio 2: Variables y tipos", ejercicio_2),
        ("Ejercicio 3: Operaciones matematicas", ejercicio_3),
        ("Ejercicio 4: Input del usuario", ejercicio_4),
        ("Ejercicio 5: Conversion de tipos", ejercicio_5),
        ("Ejercicio 6: Formato de strings", ejercicio_6),
        ("Ejercicio 7: Condicionales simples", ejercicio_7),
        ("Ejercicio 8: Operadores logicos", ejercicio_8),
        ("Ejercicio 9: Bucles for", ejercicio_9),
        ("Ejercicio 10: Listas basicas", ejercicio_10),
        ("Ejercicio 11: Recorrer listas", ejercicio_11),
        ("Ejercicio 12: While loop", ejercicio_12),
        ("Ejercicio 13: Tabla de multiplicar", ejercicio_13),
        ("Ejercicio 14: Diccionarios", ejercicio_14),
        ("Ejercicio 15: Metodos de strings", ejercicio_15),
        ("Ejercicio 16: Funciones simples", ejercicio_16),
        ("Ejercicio 17: List comprehension", ejercicio_17),
        ("Ejercicio 18: Manejo de errores", ejercicio_18),
        ("Ejercicio 19: Tuplas y conjuntos", ejercicio_19),
        ("Ejercicio 20: Calculadora", ejercicio_20),
    ]

    for titulo, funcion in ejercicios:
        print("\n" + "=" * 60)
        print(f"  {titulo}")
        print("=" * 60)
        funcion()
        print("\n")


if __name__ == "__main__":
    main()

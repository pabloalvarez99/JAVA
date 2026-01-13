# Ejercicio 2: Suma de Dígitos Recursiva

**Dificultad:** ⭐⭐⭐⭐
**Tiempo estimado:** 40 minutos
**Conceptos:** Recursión con números, división entera, módulo

---

## Contexto

Dado un número entero positivo, calcula la suma de todos sus dígitos usando recursión.

Ejemplos:
- 1234 → 1 + 2 + 3 + 4 = 10
- 987 → 9 + 8 + 7 = 24
- 5 → 5

---

## Requisitos

### Método principal:
```java
public static int sumaDigitos(int numero)
```

**Funcionalidad**:
- Retorna la suma de todos los dígitos del número
- Debe usar recursión (no loops)
- Funciona con números positivos

**Estrategia**:
- Caso base: Si el número tiene 1 solo dígito (numero < 10), retornar ese número
- Caso recursivo: Sumar el último dígito + sumaDigitos del resto

---

## Ejemplo de Ejecución

```
Ingrese un número: 1234
Suma de dígitos: 10

Ingrese un número: 987
Suma de dígitos: 24

Ingrese un número: 5
Suma de dígitos: 5

Ingrese un número: 99999
Suma de dígitos: 45
```

---

## Debe entregar:

- [ ] Método `sumaDigitos(int numero)` recursivo
- [ ] Main() que lee número desde teclado
- [ ] Validación de número positivo
- [ ] Prueba con varios casos

---

## Pistas:

<details>
<summary>Pista 1: Operaciones clave</summary>

Para trabajar con dígitos:
- **Último dígito**: `numero % 10`
- **Resto de dígitos**: `numero / 10`

Ejemplo con 1234:
- Último dígito: 1234 % 10 = 4
- Resto: 1234 / 10 = 123
</details>

<details>
<summary>Pista 2: Estructura recursiva</summary>

```java
public static int sumaDigitos(int numero) {
    // Caso base: un solo dígito
    if (numero < 10) {
        return numero;
    }

    // Caso recursivo: último dígito + suma del resto
    int ultimoDigito = numero % 10;
    int resto = numero / 10;

    return ultimoDigito + sumaDigitos(resto);
}
```
</details>

<details>
<summary>Pista 3: Traza de ejecución para 1234</summary>

```
sumaDigitos(1234)
  = 4 + sumaDigitos(123)

sumaDigitos(123)
  = 3 + sumaDigitos(12)

sumaDigitos(12)
  = 2 + sumaDigitos(1)

sumaDigitos(1)
  = 1 (caso base)

Desenrollando:
sumaDigitos(12) = 2 + 1 = 3
sumaDigitos(123) = 3 + 3 = 6
sumaDigitos(1234) = 4 + 6 = 10
```
</details>

---

## Checklist de dominio:

- [ ] Entiendo cómo extraer el último dígito con % 10
- [ ] Entiendo cómo eliminar el último dígito con / 10
- [ ] Puedo identificar el caso base (numero < 10)
- [ ] Puedo trazar la recursión en papel
- [ ] Probé con números de 1, 2, 3, 4 y 5 dígitos

---

## Desafíos adicionales:

1. **Contar dígitos**: `public static int contarDigitos(int numero)`
2. **Producto de dígitos**: `public static int productoDigitos(int numero)`
3. **Dígito máximo**: `public static int digitoMaximo(int numero)`
4. **Invertir número**: `public static int invertir(int numero)`

---

**Siguiente ejercicio**: `Ej03_Palindromo_Recursivo.md`

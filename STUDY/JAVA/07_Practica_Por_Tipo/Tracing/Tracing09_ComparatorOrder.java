/**
 * EJERCICIO TRACING #9: ComparatorOrder
 * Dificultad: ⭐⭐⭐
 *
 * INSTRUCCIONES:
 * 1. Lee el codigo sin ejecutarlo
 * 2. Escribe tu prediccion abajo
 * 3. Ejecuta y compara
 *
 * CONCEPTOS: Comparator, ordenamiento multiple, thenComparing
 *
 * ============================================
 * ESCRIBE TU PREDICCION AQUI:
 * ============================================
 * Ordenados por edad:
 * 1. _______________
 * 2. _______________
 * 3. _______________
 * 4. _______________
 *
 * Ordenados por nombre, luego edad:
 * 1. _______________
 * 2. _______________
 * 3. _______________
 * 4. _______________
 * ============================================
 */

import java.util.*;

public class Tracing09_ComparatorOrder {
    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Ana", 25));
        personas.add(new Persona("Carlos", 30));
        personas.add(new Persona("Ana", 20));
        personas.add(new Persona("Bob", 25));

        System.out.println("=== Ordenados por edad ===");
        personas.sort(Comparator.comparingInt(p -> p.edad));
        personas.forEach(System.out::println);

        System.out.println("\n=== Ordenados por nombre, luego edad ===");
        personas.sort(
            Comparator.comparing((Persona p) -> p.nombre)
                      .thenComparingInt(p -> p.edad)
        );
        personas.forEach(System.out::println);
    }
}

class Persona {
    String nombre;
    int edad;

    Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + ")";
    }
}

/*
 * ============================================
 * RESPUESTA CORRECTA (NO MIRAR ANTES):
 * ============================================
 *
 * === Ordenados por edad ===
 * Ana (20)
 * Ana (25)
 * Bob (25)
 * Carlos (30)
 *
 * === Ordenados por nombre, luego edad ===
 * Ana (20)
 * Ana (25)
 * Bob (25)
 * Carlos (30)
 *
 * ============================================
 * EXPLICACION:
 * ============================================
 *
 * ORDENAMIENTO POR EDAD:
 * - 20 < 25 < 25 < 30
 * - Ana(25) y Bob(25) tienen la misma edad
 * - El orden entre ellos depende del orden original
 *
 * ORDENAMIENTO POR NOMBRE, LUEGO EDAD:
 * - Primero ordena alfabeticamente: Ana, Ana, Bob, Carlos
 * - Las dos "Ana" empatan en nombre
 * - thenComparingInt desempata por edad: Ana(20) antes de Ana(25)
 *
 * CONCEPTO CLAVE: thenComparing
 * - Solo se usa cuando el comparador anterior da empate (0)
 * - Puedes encadenar multiples: .thenComparing().thenComparing()...
 *
 * PREGUNTA: Como ordenarias de mayor a menor edad?
 * - Comparator.comparingInt(p -> p.edad).reversed()
 * - O: Comparator.comparingInt(p -> -p.edad)
 */

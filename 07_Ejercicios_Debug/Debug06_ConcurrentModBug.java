/**
 * EJERCICIO DEBUG #6: ConcurrentModBug
 * Dificultad: ⭐⭐⭐⭐
 *
 * DESCRIPCIÓN:
 * El código intenta eliminar números pares de una lista,
 * pero lanza ConcurrentModificationException.
 *
 * PISTA: No puedes modificar una colección mientras la iteras con for-each.
 *
 * SALIDA ESPERADA:
 * Original: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * Sin pares: [1, 3, 5, 7, 9]
 *
 * SALIDA ACTUAL:
 * Original: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * Exception: ConcurrentModificationException
 */

import java.util.ArrayList;
import java.util.List;

public class Debug06_ConcurrentModBug {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numeros.add(i);
        }

        System.out.println("Original: " + numeros);

        // BUG: Modificar lista mientras se itera con for-each
        for (Integer num : numeros) {
            if (num % 2 == 0) {
                numeros.remove(num);  // ¡BOOM! ConcurrentModificationException
            }
        }

        System.out.println("Sin pares: " + numeros);
    }
}

/*
 * ============================================
 * SOLUCIONES POSIBLES:
 * ============================================
 *
 * 1. Usar Iterator con remove():
 *    Iterator<Integer> it = numeros.iterator();
 *    while (it.hasNext()) {
 *        if (it.next() % 2 == 0) it.remove();
 *    }
 *
 * 2. Usar removeIf() (Java 8+):
 *    numeros.removeIf(n -> n % 2 == 0);
 *
 * 3. Crear nueva lista (inmutabilidad):
 *    List<Integer> impares = numeros.stream()
 *        .filter(n -> n % 2 != 0)
 *        .collect(Collectors.toList());
 *
 * ============================================
 * DESPUÉS DE RESOLVER, REFLEXIONA:
 * ============================================
 *
 * 1. ¿Por qué el for-each no permite modificar?
 *
 * 2. ¿Cuál solución prefieres y por qué?
 *
 * 3. ¿Qué pasa si usas un for tradicional con índice?
 *
 * SOLUCIÓN: Ver soluciones/Debug06_Solucion.java
 */

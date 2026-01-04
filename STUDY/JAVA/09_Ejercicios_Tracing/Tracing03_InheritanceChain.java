/**
 * EJERCICIO TRACING #3: InheritanceChain
 * Dificultad: ⭐⭐⭐
 *
 * INSTRUCCIONES:
 * 1. Lee el codigo sin ejecutarlo
 * 2. Escribe tu prediccion abajo
 * 3. Ejecuta y compara
 *
 * CONCEPTOS: Herencia, constructores, super, this
 *
 * ============================================
 * ESCRIBE TU PREDICCION AQUI:
 * ============================================
 * Linea 1: _______________
 * Linea 2: _______________
 * Linea 3: _______________
 * Linea 4: _______________
 * Linea 5: _______________
 * Linea 6: _______________
 * ============================================
 */

public class Tracing03_InheritanceChain {
    public static void main(String[] args) {
        System.out.println("=== Creando Nieto ===");
        Nieto n = new Nieto();
    }
}

class Abuelo {
    Abuelo() {
        System.out.println("Constructor Abuelo");
    }

    Abuelo(String msg) {
        System.out.println("Abuelo dice: " + msg);
    }
}

class Padre extends Abuelo {
    Padre() {
        super("Hola desde Padre");
        System.out.println("Constructor Padre");
    }
}

class Nieto extends Padre {
    Nieto() {
        System.out.println("Constructor Nieto");
    }
}

/*
 * ============================================
 * RESPUESTA CORRECTA (NO MIRAR ANTES):
 * ============================================
 *
 * Linea 1: === Creando Nieto ===
 * Linea 2: Abuelo dice: Hola desde Padre
 * Linea 3: Constructor Padre
 * Linea 4: Constructor Nieto
 *
 * ============================================
 * EXPLICACION:
 * ============================================
 *
 * Orden de ejecucion de constructores:
 * 1. new Nieto() llama al constructor de Nieto
 * 2. Primera linea implicita: super() -> constructor Padre
 * 3. Padre tiene super("Hola desde Padre") -> Abuelo(String)
 * 4. Abuelo imprime su mensaje
 * 5. Vuelve a Padre, imprime "Constructor Padre"
 * 6. Vuelve a Nieto, imprime "Constructor Nieto"
 *
 * CONCEPTO CLAVE: Cadena de constructores
 * - Siempre se ejecuta de arriba hacia abajo (ancestro a hijo)
 * - Si no hay super() explicito, Java agrega super() sin args
 *
 * PREGUNTA: Que pasaria si Padre() no tuviera super()?
 * - Llamaria a Abuelo() sin args -> "Constructor Abuelo"
 */

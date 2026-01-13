/**
 * EJERCICIO TRACING #4: PolymorphismPuzzle
 * Dificultad: ⭐⭐⭐
 *
 * INSTRUCCIONES:
 * 1. Lee el codigo sin ejecutarlo
 * 2. Escribe tu prediccion abajo
 * 3. Ejecuta y compara
 *
 * CONCEPTOS: Polimorfismo, tipo de compilacion vs ejecucion, override
 *
 * ============================================
 * ESCRIBE TU PREDICCION AQUI:
 * ============================================
 * Linea 1: _______________
 * Linea 2: _______________
 * Linea 3: _______________
 * Linea 4: _______________
 * Linea 5: _______________
 * ============================================
 */

public class Tracing04_PolymorphismPuzzle {
    public static void main(String[] args) {
        Animal a1 = new Animal();
        Animal a2 = new Perro();
        Animal a3 = new Gato();

        a1.hacerSonido();
        a2.hacerSonido();
        a3.hacerSonido();

        System.out.println("---");

        // Que metodo se llama aqui?
        a2.dormir();
        ((Perro) a2).buscarPelota();
    }
}

class Animal {
    void hacerSonido() {
        System.out.println("...");
    }

    void dormir() {
        System.out.println("Zzz...");
    }
}

class Perro extends Animal {
    @Override
    void hacerSonido() {
        System.out.println("Guau!");
    }

    void buscarPelota() {
        System.out.println("Buscando pelota...");
    }
}

class Gato extends Animal {
    @Override
    void hacerSonido() {
        System.out.println("Miau!");
    }
}

/*
 * ============================================
 * RESPUESTA CORRECTA (NO MIRAR ANTES):
 * ============================================
 *
 * Linea 1: ...
 * Linea 2: Guau!
 * Linea 3: Miau!
 * Linea 4: ---
 * Linea 5: Zzz...
 * Linea 6: Buscando pelota...
 *
 * ============================================
 * EXPLICACION:
 * ============================================
 *
 * - a1.hacerSonido(): a1 ES Animal, ejecuta Animal.hacerSonido()
 * - a2.hacerSonido(): a2 es tipo Animal pero ES Perro -> Perro.hacerSonido()
 * - a3.hacerSonido(): a3 es tipo Animal pero ES Gato -> Gato.hacerSonido()
 *
 * - a2.dormir(): Perro no override dormir(), usa Animal.dormir()
 * - ((Perro) a2).buscarPelota(): Cast necesario para acceder a metodo de Perro
 *
 * CONCEPTO CLAVE: Binding dinamico
 * - El tipo de compilacion determina QUE metodos puedes llamar
 * - El tipo de ejecucion determina QUE implementacion se usa
 *
 * PREGUNTA: Que pasa con a3.buscarPelota() sin cast?
 * - Error de compilacion: Animal no tiene buscarPelota()
 */

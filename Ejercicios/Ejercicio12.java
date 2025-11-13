/*
 * ========================================
 * EJERCICIO 12: Múltiples Objetos Interactuando (Aula con Estudiantes)
 * DIFICULTAD: ⭐⭐⭐⭐ (Medio-Alto)
 * ========================================
 *
 * OBJETIVO:
 * Aprender a trabajar con múltiples objetos que interactúan entre sí
 * y practicar el manejo de colecciones de objetos (arrays de objetos)
 *
 * CONCEPTO CLAVE:
 * En el mundo real, los objetos no existen aislados - interactúan entre sí.
 * Por ejemplo, un Aula contiene múltiples Estudiantes. Esta es una relación
 * de "contención" - un objeto contiene una colección de otros objetos.
 *
 * INSTRUCCIONES:
 * 1. REUTILIZA la clase "Estudiante" del ejercicio anterior (copia el código)
 *    - Ya tiene: nombre, nota1, nota2, nota3
 *    - Ya tiene: getters, setters, calcularPromedio(), aprobo()
 *
 * 2. Crea una clase "Aula" con:
 *    - Atributo privado: nombre (String) - ej: "Programación Java 101"
 *    - Atributo privado: estudiantes (Estudiante[]) - array de máximo 30 estudiantes
 *    - Atributo privado: cantidadEstudiantes (int) - cuántos hay actualmente
 *    - Constructor que reciba el nombre del aula (inicializa array vacío)
 *    - Método "agregarEstudiante(Estudiante est)" - agrega un estudiante al aula
 *    - Método "mostrarEstudiantes()" - muestra todos los estudiantes y sus promedios
 *    - Método "calcularPromedioAula()" - calcula el promedio general del aula
 *    - Método "contarAprobados()" - retorna cuántos estudiantes aprobaron
 *
 * 3. En el main:
 *    - Crea un aula
 *    - Crea 4 estudiantes con diferentes notas
 *    - Agrégalos al aula
 *    - Muestra todos los estudiantes
 *    - Muestra estadísticas del aula
 *
 * SALIDA ESPERADA:
 * ====== Aula: Programación Java 101 ======
 *
 * Estudiante: Juan Pérez
 *   Promedio: 5.33 - Aprobó: true
 *
 * Estudiante: María González
 *   Promedio: 6.20 - Aprobó: true
 *
 * Estudiante: Pedro López
 *   Promedio: 3.50 - Aprobó: false
 *
 * Estudiante: Ana Martínez
 *   Promedio: 5.80 - Aprobó: true
 *
 * ====== Estadísticas del Aula ======
 * Promedio General: 5.21
 * Estudiantes Aprobados: 3 de 4
 * Porcentaje de Aprobación: 75.00%
 *
 * CONCEPTOS NUEVOS:
 * - Arrays de objetos (no primitivos)
 * - Objetos que contienen otros objetos
 * - Relaciones entre clases (composición)
 * - Cálculos agregados sobre colecciones
 */

// TODO: Copia la clase Estudiante del ejercicio anterior
class Estudiante {
    // Atributos privados
    private String nombre;
    private double nota1;
    private double nota2;
    private double nota3;

    // Constructor
    public Estudiante(String nombre) {
        this.nombre = nombre;
        this.nota1 = 0.0;
        this.nota2 = 0.0;
        this.nota3 = 0.0;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public double getNota3() {
        return nota3;
    }

    // Setters con validación
    public void setNota1(double nota) {
        if (nota >= 1.0 && nota <= 7.0) {
            this.nota1 = nota;
        }
    }

    public void setNota2(double nota) {
        if (nota >= 1.0 && nota <= 7.0) {
            this.nota2 = nota;
        }
    }

    public void setNota3(double nota) {
        if (nota >= 1.0 && nota <= 7.0) {
            this.nota3 = nota;
        }
    }

    // Método calcularPromedio
    public double calcularPromedio() {
        return (nota1 + nota2 + nota3) / 3.0;
    }

    // Método aprobo
    public boolean aprobo() {
        return calcularPromedio() >= 4.0;
    }
}

// TODO: Crea la clase Aula
class Aula {
    // TODO: Atributos privados
    private String nombre;
    private Estudiante[] estudiantes = new Estudiante[30];
    private int cantidadEstudiantes = 0;
    // TODO: Constructor
    public Aula(String nombre) {
        this.nombre = nombre;
        Estudiante[] estudiantes;
        int cantidadEstudiantes;
    }
    public double getCantidadEstudiantes() {
        return cantidadEstudiantes;
    }
    // TODO: Método agregarEstudiante
    public void agregarEstudiante(Estudiante e) {
        estudiantes[cantidadEstudiantes] = e;
        cantidadEstudiantes++;
    }

    // TODO: Método mostrarEstudiantes
    public static void mostrarEstudiantes(Aula aula) {
        System.out.println("====== Aula: " + aula.nombre + " ======");
        for (int i = 0; i < aula.cantidadEstudiantes; i++) {
            System.out.println("\nEstudiante: " + aula.estudiantes[i].getNombre());
            System.out.println("  Promedio: " + String.format("%.2f ",aula.estudiantes[i].calcularPromedio()) + "-Aprobó: " + aula.estudiantes[i].aprobo());
        }

    }

    // TODO: Método calcularPromedioAula
    public double calcularPromedioAula(Aula aula) {
        double sumaPromedioAula = 0;
        for (int i = 0; i < cantidadEstudiantes; i++) {
            sumaPromedioAula += aula.estudiantes[i].calcularPromedio();
        }
        return sumaPromedioAula / cantidadEstudiantes;
    }

    // TODO: Método contarAprobados
    public double contarAprobados(Aula aula) {
        double aprobados = 0;
        for (int i = 0; i < aula.cantidadEstudiantes; i++) {
            if (aula.estudiantes[i].calcularPromedio() >= 4.0) {
                aprobados += 1;
            }
        }
        return aprobados;
    }
}

public class Ejercicio12 {
    public static void main(String[] args) {
        // TODO: Crea un aula
        Aula deepLearning = new Aula("Deep Learning");

        // TODO: Crea 4 estudiantes con diferentes notas
        Estudiante est1 = new Estudiante("Juan Pérez");
        est1.setNota1(5.5); est1.setNota2(6.0); est1.setNota3(4.5);
        Estudiante est2 = new Estudiante("Juana Pérez");
        est2.setNota1(4.3); est2.setNota2(2.9); est2.setNota3(4.5);
        Estudiante est3 = new Estudiante("Juanito Pérez");
        est3.setNota1(2.3); est3.setNota2(3.8); est3.setNota3(4.5);
        Estudiante est4 = new Estudiante("Juanitee Pérez");
        est4.setNota1(5.2); est4.setNota2(4.7); est4.setNota3(4.5);
        
        // TODO: Agrega los estudiantes al aula
        deepLearning.agregarEstudiante(est1);
        deepLearning.agregarEstudiante(est2);
        deepLearning.agregarEstudiante(est3);
        deepLearning.agregarEstudiante(est3);

        // TODO: Muestra todos los estudiantes
        Aula.mostrarEstudiantes(deepLearning);
        
        // TODO: Muestra estadísticas
        System.out.println("\n====== Estadísticas del Aula ======");
        System.out.println("Promedio General: " + String.format("%.2f",deepLearning.calcularPromedioAula(deepLearning)));
        System.out.println("Estudiantes Aprobados: " + String.format("%.0f",deepLearning.contarAprobados(deepLearning)) + " de " + String.format("%.0f",deepLearning.getCantidadEstudiantes()));
        System.out.println("Porcentaje de aprobacion: " + String.format("%.2f",(deepLearning.contarAprobados(deepLearning) / deepLearning.getCantidadEstudiantes()) * 100) + "%");
    }
}

/*
 * ========================================
 * REFLEXIÓN Y PROFUNDIZACIÓN
 * ========================================
 *
 * ¿POR QUÉ ES IMPORTANTE ESTE EJERCICIO?
 *
 * 1. COMPOSICIÓN DE OBJETOS:
 *    En aplicaciones reales, los objetos raramente existen aislados.
 *    Un sistema escolar tiene: Aulas → Estudiantes → Notas
 *    Un sistema de e-commerce tiene: Carrito → Productos → Precios
 *    Esta es la esencia de la programación orientada a objetos.
 *
 * 2. ARRAYS DE OBJETOS:
 *    Hasta ahora trabajaste con arrays de primitivos (int[], double[]).
 *    Ahora trabajas con arrays de OBJETOS (Estudiante[]).
 *    Cada posición del array contiene una REFERENCIA a un objeto Estudiante.
 *
 * 3. GESTIÓN DE COLECCIONES:
 *    El atributo "cantidadEstudiantes" es crucial - rastrea cuántos
 *    estudiantes reales hay en el array. Sin esto, no sabrías dónde
 *    termina la colección (el array podría tener posiciones vacías/null).
 *
 * 4. OPERACIONES AGREGADAS:
 *    calcularPromedioAula() es una operación "agregada" - toma todos
 *    los objetos de la colección y calcula algo sobre el conjunto.
 *    Esto es común en aplicaciones reales (promedios, sumas, conteos).
 *
 * CASOS DE USO EN EL MUNDO REAL:
 *
 * 1. E-COMMERCE:
 *    class CarritoCompras {
 *        private Producto[] productos;
 *        private int cantidad;
 *
 *        public double calcularTotal() { ... }
 *        public void agregarProducto(Producto p) { ... }
 *    }
 *
 * 2. RED SOCIAL:
 *    class Usuario {
 *        private Publicacion[] publicaciones;
 *        private int cantidadPublicaciones;
 *
 *        public void agregarPublicacion(Publicacion p) { ... }
 *        public int contarLikes() { ... }
 *    }
 *
 * 3. SISTEMA BANCARIO:
 *    class CuentaBancaria {
 *        private Transaccion[] transacciones;
 *        private int cantidadTransacciones;
 *
 *        public double calcularSaldoTotal() { ... }
 *    }
 *
 * MEJORA FUTURA:
 * Más adelante aprenderás sobre ArrayList, que hace esto automáticamente
 * sin necesidad de manejar manualmente el tamaño y capacidad del array.
 */

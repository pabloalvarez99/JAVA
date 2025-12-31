/**
 * EJERCICIO DEBUG #10: LogicErrorMystery
 * Dificultad: ⭐⭐⭐
 *
 * DESCRIPCIÓN:
 * El sistema de descuentos no funciona correctamente.
 * Algunos clientes no reciben el descuento que deberían.
 *
 * PISTA: Revisa cuidadosamente las condiciones lógicas.
 *
 * REGLAS DE NEGOCIO:
 * - VIP con compra > $100: 20% descuento
 * - VIP con compra <= $100: 10% descuento
 * - Regular con compra > $100: 5% descuento
 * - Regular con compra <= $100: 0% descuento
 *
 * CASO DE PRUEBA:
 * Cliente VIP, compra $150 -> debería ser 20% descuento
 *
 * SALIDA ESPERADA:
 * Cliente: Ana (VIP), Compra: $150.0, Descuento: 20%, Total: $120.0
 *
 * SALIDA ACTUAL:
 * Cliente: Ana (VIP), Compra: $150.0, Descuento: 10%, Total: $135.0
 */

public class Debug10_LogicErrorMystery {
    public static void main(String[] args) {
        calcularTotal("Ana", true, 150.0);   // VIP, $150
        calcularTotal("Bob", false, 200.0);  // Regular, $200
        calcularTotal("Carlos", true, 50.0); // VIP, $50
    }

    public static void calcularTotal(String nombre, boolean esVIP, double compra) {
        double descuento = 0;

        // BUG: Error en la lógica de condiciones
        if (esVIP) {
            descuento = 10;  // Siempre 10% para VIP (incorrecto)
        }
        if (compra > 100) {  // Este if es independiente, no else-if
            descuento = 5;   // Sobrescribe el 10% de VIP
        }
        if (esVIP && compra > 100) {
            descuento = 20;  // Nunca se alcanza en el orden correcto
        }

        // BUG ADICIONAL: El orden de las condiciones importa
        // Las condiciones se evalúan en orden y se sobrescriben

        double total = compra * (1 - descuento / 100);
        String tipo = esVIP ? "VIP" : "Regular";

        System.out.printf("Cliente: %s (%s), Compra: $%.1f, Descuento: %.0f%%, Total: $%.1f%n",
            nombre, tipo, compra, descuento, total);
    }
}

/*
 * ============================================
 * ANÁLISIS DEL BUG:
 * ============================================
 *
 * Para Ana (VIP, $150):
 * 1. if (esVIP) -> descuento = 10 ✓
 * 2. if (compra > 100) -> descuento = 5 (¡sobrescribe!)
 * 3. if (esVIP && compra > 100) -> descuento = 20 (¡sobrescribe de nuevo!)
 *
 * El resultado final es 20%, pero el código original tenía
 * los ifs en orden incorrecto o independientes.
 *
 * ============================================
 * SOLUCIÓN CORRECTA:
 * ============================================
 *
 * Usar if-else-if para condiciones mutuamente excluyentes:
 *
 * if (esVIP && compra > 100) {
 *     descuento = 20;
 * } else if (esVIP) {
 *     descuento = 10;
 * } else if (compra > 100) {
 *     descuento = 5;
 * } else {
 *     descuento = 0;
 * }
 *
 * SOLUCIÓN: Ver soluciones/Debug10_Solucion.java
 */

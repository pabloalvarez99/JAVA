/**
 * EJERCICIO STRING #7: CamelCaseConverter
 * Dificultad: ⭐⭐
 *
 * PROBLEMA:
 * Convertir entre diferentes convenciones de nombres:
 * - camelCase: primeraPalabraMinuscula
 * - PascalCase: TodasLasPalabrasCapitalizadas
 * - snake_case: palabras_separadas_por_guion_bajo
 * - kebab-case: palabras-separadas-por-guiones
 *
 * EJEMPLOS:
 * snake_case -> camelCase:
 *   "hello_world"      -> "helloWorld"
 *   "get_user_by_id"   -> "getUserById"
 *
 * camelCase -> snake_case:
 *   "helloWorld"       -> "hello_world"
 *   "getUserById"      -> "get_user_by_id"
 *
 * PISTAS:
 * 1. Para snake_case a camelCase: split por "_" y capitalizar
 * 2. Para camelCase a snake_case: detectar mayusculas
 * 3. Character.isUpperCase(), Character.toLowerCase()
 */

public class String07_CamelCaseConverter {
    public static void main(String[] args) {
        // snake_case -> camelCase
        System.out.println("=== Snake to Camel ===");
        System.out.println(snakeToCamel("hello_world"));     // "helloWorld"
        System.out.println(snakeToCamel("get_user_by_id"));  // "getUserById"
        System.out.println(snakeToCamel("simple"));          // "simple"

        // camelCase -> snake_case
        System.out.println("\n=== Camel to Snake ===");
        System.out.println(camelToSnake("helloWorld"));      // "hello_world"
        System.out.println(camelToSnake("getUserById"));     // "get_user_by_id"
        System.out.println(camelToSnake("HTMLParser"));      // "html_parser"

        // Bonus: snake_case -> PascalCase
        System.out.println("\n=== Snake to Pascal ===");
        System.out.println(snakeToPascal("hello_world"));    // "HelloWorld"
    }

    public static String snakeToCamel(String snake) {
        // TODO: Implementar
        // 1. Split por "_"
        // 2. Primera palabra en minuscula
        // 3. Resto: capitalizar primera letra

        return ""; // Placeholder
    }

    public static String camelToSnake(String camel) {
        // TODO: Implementar
        // 1. Recorrer caracter por caracter
        // 2. Si es mayuscula: agregar "_" + minuscula
        // 3. Si es minuscula: agregar directamente

        return ""; // Placeholder
    }

    public static String snakeToPascal(String snake) {
        // TODO: Implementar (bonus)
        // Similar a snakeToCamel pero primera tambien capitalizada

        return ""; // Placeholder
    }
}

/*
 * ============================================
 * SOLUCION (NO MIRAR ANTES DE INTENTAR):
 * ============================================
 *
 * public static String snakeToCamel(String snake) {
 *     if (snake == null || snake.isEmpty()) return snake;
 *
 *     String[] partes = snake.toLowerCase().split("_");
 *     StringBuilder sb = new StringBuilder(partes[0]);
 *
 *     for (int i = 1; i < partes.length; i++) {
 *         if (!partes[i].isEmpty()) {
 *             sb.append(Character.toUpperCase(partes[i].charAt(0)));
 *             sb.append(partes[i].substring(1));
 *         }
 *     }
 *
 *     return sb.toString();
 * }
 *
 * public static String camelToSnake(String camel) {
 *     if (camel == null || camel.isEmpty()) return camel;
 *
 *     StringBuilder sb = new StringBuilder();
 *
 *     for (int i = 0; i < camel.length(); i++) {
 *         char c = camel.charAt(i);
 *
 *         if (Character.isUpperCase(c)) {
 *             // No agregar "_" al inicio
 *             if (sb.length() > 0) {
 *                 sb.append("_");
 *             }
 *             sb.append(Character.toLowerCase(c));
 *         } else {
 *             sb.append(c);
 *         }
 *     }
 *
 *     return sb.toString();
 * }
 *
 * public static String snakeToPascal(String snake) {
 *     if (snake == null || snake.isEmpty()) return snake;
 *
 *     String[] partes = snake.toLowerCase().split("_");
 *     StringBuilder sb = new StringBuilder();
 *
 *     for (String parte : partes) {
 *         if (!parte.isEmpty()) {
 *             sb.append(Character.toUpperCase(parte.charAt(0)));
 *             sb.append(parte.substring(1));
 *         }
 *     }
 *
 *     return sb.toString();
 * }
 *
 * COMPLEJIDAD:
 * - Tiempo: O(n)
 * - Espacio: O(n)
 */

package Ay4;

import java.util.Scanner;

/**
 * Clase Main - Programa principal con menú de opciones
 */
public class Main {
    private static UCN ucn = new UCN();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Cargar datos de prueba
        cargarDatosPrueba();
        
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            procesarOpcion(opcion);
        } while (opcion != 0);
        
        System.out.println("¡Hasta luego!");
        scanner.close();
    }
    
    /**
     * Muestra el menú principal
     */
    private static void mostrarMenu() {
        System.out.println("\n========================================");
        System.out.println("       SISTEMA DE GESTIÓN UCN");
        System.out.println("========================================");
        System.out.println("1. Agregar una persona");
        System.out.println("2. Agregar una unidad");
        System.out.println("3. Asociar persona a unidad");
        System.out.println("----------------------------------------");
        System.out.println("       REPORTABILIDAD");
        System.out.println("----------------------------------------");
        System.out.println("4. Roles por fecha");
        System.out.println("5. Cantidad de personas por unidad");
        System.out.println("6. Historia de roles de una persona");
        System.out.println("7. Historial de roles de una unidad");
        System.out.println("8. Estadísticas generales");
        System.out.println("----------------------------------------");
        System.out.println("9. Listar personas");
        System.out.println("10. Listar unidades");
        System.out.println("0. Salir");
        System.out.println("========================================");
    }
    
    /**
     * Procesa la opción seleccionada
     */
    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                agregarPersona();
                break;
            case 2:
                agregarUnidad();
                break;
            case 3:
                asociarPersonaUnidad();
                break;
            case 4:
                rolesPorFecha();
                break;
            case 5:
                cantidadPersonasPorUnidad();
                break;
            case 6:
                historiaRolesPersona();
                break;
            case 7:
                historialRolesUnidad();
                break;
            case 8:
                ucn.reporteEstadisticasGenerales();
                break;
            case 9:
                listarPersonas();
                break;
            case 10:
                listarUnidades();
                break;
            case 0:
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
    
    // ==================== OPCIONES DEL MENÚ ====================
    
    /**
     * Opción 1: Agregar una persona
     */
    private static void agregarPersona() {
        System.out.println("\n--- AGREGAR PERSONA ---");
        String rut = leerTexto("Ingrese RUT: ");
        String nombre = leerTexto("Ingrese nombre: ");
        
        Persona persona = new Persona(rut, nombre);
        ucn.agregarPersona(persona);
        
        System.out.println("Persona agregada exitosamente.");
    }
    
    /**
     * Opción 2: Agregar una unidad
     */
    private static void agregarUnidad() {
        System.out.println("\n--- AGREGAR UNIDAD ---");
        String nombre = leerTexto("Ingrese nombre de la unidad: ");
        
        Unidad unidad = new Unidad(nombre);
        ucn.agregarUnidad(unidad);
        
        System.out.println("Unidad agregada exitosamente.");
    }
    
    /**
     * Opción 3: Asociar persona a unidad
     */
    private static void asociarPersonaUnidad() {
        System.out.println("\n--- ASOCIAR PERSONA A UNIDAD ---");
        
        // Buscar persona
        String rut = leerTexto("Ingrese RUT de la persona: ");
        Persona persona = ucn.buscarPersonaPorRut(rut);
        
        if (persona == null) {
            System.out.println("No se encontró persona con ese RUT.");
            return;
        }
        
        // Buscar unidad
        String nombreUnidad = leerTexto("Ingrese nombre de la unidad: ");
        Unidad unidad = ucn.buscarUnidadPorNombre(nombreUnidad);
        
        if (unidad == null) {
            System.out.println("No se encontró unidad con ese nombre.");
            return;
        }
        
        // Leer rol
        String rol = leerTexto("Ingrese el rol (funcionario/profesor/estudiante): ");
        
        // Leer fechas
        System.out.println("Fecha de inicio:");
        Fecha fechaInicio = leerFecha();
        
        System.out.println("Fecha de término:");
        Fecha fechaTermino = leerFecha();
        
        // Crear asociación
        ucn.asociarPersonaUnidad(persona, unidad, rol, fechaInicio, fechaTermino);
        
        System.out.println("Asociación creada exitosamente.");
    }
    
    /**
     * Opción 4: Roles por fecha
     */
    private static void rolesPorFecha() {
        System.out.println("\n--- ROLES POR FECHA ---");
        System.out.println("Ingrese la fecha a consultar:");
        Fecha fecha = leerFecha();
        
        ucn.reporteRolesPorFecha(fecha);
    }
    
    /**
     * Opción 5: Cantidad de personas por unidad
     */
    private static void cantidadPersonasPorUnidad() {
        System.out.println("\n--- CANTIDAD DE PERSONAS POR UNIDAD ---");
        System.out.println("Ingrese la fecha a consultar:");
        Fecha fecha = leerFecha();
        
        ucn.reporteCantidadPersonasPorUnidad(fecha);
    }
    
    /**
     * Opción 6: Historia de roles de una persona
     */
    private static void historiaRolesPersona() {
        System.out.println("\n--- HISTORIA DE ROLES ---");
        String rut = leerTexto("Ingrese RUT de la persona: ");
        
        ucn.reporteHistoriaRolesPersona(rut);
    }
    
    /**
     * Opción 7: Historial de roles de una unidad
     */
    private static void historialRolesUnidad() {
        System.out.println("\n--- HISTORIAL DE ROLES DE UNIDAD ---");
        String nombre = leerTexto("Ingrese nombre de la unidad: ");
        
        ucn.reporteHistorialRolesUnidad(nombre);
    }
    
    /**
     * Opción 9: Listar personas
     */
    private static void listarPersonas() {
        System.out.println("\n=== PERSONAS REGISTRADAS ===");
        for (Persona p : ucn.getPersonas()) {
            System.out.println("- " + p);
        }
    }
    
    /**
     * Opción 10: Listar unidades
     */
    private static void listarUnidades() {
        System.out.println("\n=== UNIDADES REGISTRADAS ===");
        for (Unidad u : ucn.getUnidades()) {
            System.out.println("- " + u);
        }
    }
    
    // ==================== MÉTODOS AUXILIARES DE LECTURA ====================
    
    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
    
    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print("Ingrese un número válido: ");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        return valor;
    }
    
    private static Fecha leerFecha() {
        int anio = leerEntero("  Año: ");
        int mes = leerEntero("  Mes: ");
        int dia = leerEntero("  Día: ");
        return new Fecha(anio, mes, dia);
    }
    
    // ==================== DATOS DE PRUEBA ====================
    
    /**
     * Carga datos de prueba para facilitar las pruebas
     */
    private static void cargarDatosPrueba() {
        // Crear personas
        Persona p1 = new Persona("12345678-9", "Juan Pérez");
        Persona p2 = new Persona("98765432-1", "María González");
        Persona p3 = new Persona("11111111-1", "Carlos López");
        Persona p4 = new Persona("22222222-2", "Ana Martínez");
        
        ucn.agregarPersona(p1);
        ucn.agregarPersona(p2);
        ucn.agregarPersona(p3);
        ucn.agregarPersona(p4);
        
        // Crear unidades
        Unidad u1 = new Unidad("Escuela de Ingeniería");
        Unidad u2 = new Unidad("Servicio de Obras");
        Unidad u3 = new Unidad("Ingeniería Civil Informática");
        Unidad u4 = new Unidad("Departamento de Matemáticas");
        
        ucn.agregarUnidad(u1);
        ucn.agregarUnidad(u2);
        ucn.agregarUnidad(u3);
        ucn.agregarUnidad(u4);
        
        // Crear contratos (asociaciones)
        // Juan: profesor en Escuela de Ingeniería desde 2020
        ucn.asociarPersonaUnidad(p1, u1, "profesor", 
            new Fecha(2020, 3, 1), new Fecha(2027, 12, 31));
        
        // Juan: también funcionario en Servicio de Obras (rol simultáneo)
        ucn.asociarPersonaUnidad(p1, u2, "funcionario", 
            new Fecha(2022, 1, 1), new Fecha(2025, 12, 31));
        
        // María: estudiante en Ing. Civil Informática
        ucn.asociarPersonaUnidad(p2, u3, "estudiante", 
            new Fecha(2021, 3, 1), new Fecha(2026, 12, 31));
        
        // Carlos: profesor en Depto. Matemáticas (más antiguo)
        ucn.asociarPersonaUnidad(p3, u4, "profesor", 
            new Fecha(2015, 3, 1), new Fecha(2030, 12, 31));
        
        // Carlos: también da clases en Escuela de Ingeniería
        ucn.asociarPersonaUnidad(p3, u1, "profesor", 
            new Fecha(2018, 3, 1), new Fecha(2028, 12, 31));
        
        // Carlos: fue funcionario antes
        ucn.asociarPersonaUnidad(p3, u2, "funcionario", 
            new Fecha(2010, 1, 1), new Fecha(2014, 12, 31));
        
        // Ana: estudiante en Ing. Civil Informática
        ucn.asociarPersonaUnidad(p4, u3, "estudiante", 
            new Fecha(2023, 3, 1), new Fecha(2028, 12, 31));
        
        System.out.println("Datos de prueba cargados exitosamente.");
    }
}

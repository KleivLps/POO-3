package SistemaGestionAvanzada;

import SistemaGestionAvanzada.BuscarEmpeladoPorNombre;
import SistemaGestionAvanzada.IncreamentarSalario;
import SistemaGestionAvanzada.OrdenarEmpleados;
import SistemaGestionAvanzada.FiltrarEmpleados;
import SistemaGestionAvanzada.Empleados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaGestion {

    private static List<Empleados> empleados = new ArrayList<>();
    private static List<Empleados> empleadosOriginales = new ArrayList<>();

    public static void main(String[] args) {
        // Agregar algunos empleados iniciales
        inicializarEmpleados();

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    mostrarTodosEmpleados();
                    break;
                case 2:
                    crearEmpleado(scanner);
                    break;
                case 3:
                    filtrarEmpleados(scanner);
                    break;
                case 4:
                    ordenarEmpleados(scanner);
                    break;
                case 5:
                    incrementarSalario(scanner);
                    break;
                case 6:
                    limpiarFiltros();
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        } while (opcion != 7);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("Sistema de Gestión de Empleados");
        System.out.println("1. Mostrar todos los empleados");
        System.out.println("2. Crear empleado");
        System.out.println("3. Filtrar empleados");
        System.out.println("4. Ordenar empleados");
        System.out.println("5. Incrementar salario");
        System.out.println("6. Limpiar filtros");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void inicializarEmpleados() {
        empleados.add(new Empleados("Juan Pérez", 30, 50000.0, "Ventas"));
        empleados.add(new Empleados("Ana Gómez", 25, 55000.0, "Marketing"));
        empleados.add(new Empleados("Luis Fernández", 40, 60000.0, "Recursos Humanos"));
        // Guardar una copia del arreglo original para restaurar los filtros
        empleadosOriginales.addAll(empleados);
    }

    private static void mostrarTodosEmpleados() {
        MostrarEmpleados.mostrarTodosEmpleados(empleados.toArray(new Empleados[0]));
    }

    private static void crearEmpleado(Scanner scanner) {
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();

        // Verificar si ya existe un empleado con el mismo nombre
        for (Empleados e : empleados) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Error: Ya existe un empleado con el nombre " + nombre);
                return;
            }
        }

        System.out.print("Ingrese la edad del empleado: ");
        int edad = scanner.nextInt();
        System.out.print("Ingrese el salario del empleado: ");
        double salario = scanner.nextDouble();
        scanner.nextLine();  // Consumir el salto de línea
        System.out.print("Ingrese el departamento del empleado: ");
        String departamento = scanner.nextLine();

        Empleados nuevoEmpleado = new Empleados(nombre, edad, salario, departamento);
        empleados.add(nuevoEmpleado);
        empleadosOriginales.add(nuevoEmpleado);  // Agregar a la lista original para futuros filtros
        System.out.println("Empleado creado exitosamente.");
    }

    private static void filtrarEmpleados(Scanner scanner) {
        System.out.println("Seleccione el atributo para filtrar (nombre, edad, salario, departamento): ");
        String atributo = scanner.nextLine();
        System.out.print("Ingrese el valor para filtrar: ");
        String valor = scanner.nextLine();

        Empleados[] resultado = null;
        switch (atributo) {
            case "nombre":
            case "departamento":
                resultado = FiltrarEmpleados.filtrarEmpleados(empleados.toArray(new Empleados[0]), atributo, valor);
                break;
            case "edad":
            case "salario":
                System.out.print("Ingrese el valor numérico para filtrar: ");
                double numValor = scanner.nextDouble();
                scanner.nextLine();  // Consumir el salto de línea
                resultado = FiltrarEmpleados.filtrarEmpleados(empleados.toArray(new Empleados[0]), atributo, numValor);
                break;
            default:
                System.out.println("Atributo no válido.");
                return;
        }

        empleados = List.of(resultado);  // Actualizar la lista de empleados con el resultado filtrado
        mostrarTodosEmpleados();
    }

    private static void ordenarEmpleados(Scanner scanner) {
        System.out.println("Seleccione el atributo para ordenar (nombre, edad, salario, departamento): ");
        String atributo = scanner.nextLine();

        Empleados[] resultado = OrdenarEmpleados.ordenarEmpleados(empleados.toArray(new Empleados[0]), atributo);
        empleados = List.of(resultado);  // Actualizar la lista de empleados con el resultado ordenado
        mostrarTodosEmpleados();
    }

    private static void incrementarSalario(Scanner scanner) {
        System.out.print("Ingrese el nombre del empleado para incrementar el salario: ");
        String nombre = scanner.nextLine();
        Empleados empleado = BuscarEmpeladoPorNombre.buscarPorNombre(empleados.toArray(new Empleados[0]), nombre);

        if (empleado == null) {
            System.out.println("Empleado no encontrado.");
            return;
        }

        System.out.print("Ingrese el porcentaje de aumento: ");
        double porcentaje = scanner.nextDouble();
        scanner.nextLine();  // Consumir el salto de línea

        IncreamentarSalario.incrementarSalario(empleado, porcentaje);
        System.out.println("Salario incrementado exitosamente.");
    }

    private static void limpiarFiltros() {
        empleados = new ArrayList<>(empleadosOriginales);  // Restaurar el arreglo original
        System.out.println("Filtros limpiados. Lista de empleados restaurada.");
        mostrarTodosEmpleados();
    }
}

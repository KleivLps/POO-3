package SistemaGestionAvanzada;

import SistemaGestionAvanzada.Empleados;

public class MostrarEmpleados {
        public static void mostrarTodosEmpleados(Empleados[] empleados) {
            System.out.printf("%-5s %-20s %-5s %-10s %-15s%n", "Fila", "Nombre", "Edad", "Salario", "Departamento");
            for (int i = 0; i < empleados.length; i++) {
                Empleados e = empleados[i];
                System.out.printf("%-5d %-20s %-5d %-10.2f %-15s%n", i + 1, e.getNombre(), e.getEdad(), e.getSalario(), e.getDepartamento());
            }
            }

}
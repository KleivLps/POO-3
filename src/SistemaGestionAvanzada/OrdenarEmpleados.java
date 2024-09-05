package SistemaGestionAvanzada;

import SistemaGestionAvanzada.Empleados;

public class OrdenarEmpleados {

    public static Empleados[] ordenarEmpleados(Empleados[] empleados, String atributo) {
        for (int i = 0; i < empleados.length - 1; i++) {
            for (int j = 0; j < empleados.length - i - 1; j++) {
                if (compararEmpleados(empleados[j], empleados[j + 1], atributo) > 0) {
                    Empleados temp = empleados[j];
                    empleados[j] = empleados[j + 1];
                    empleados[j + 1] = temp;
                }
            }
        }
        return empleados;
    }

    private static int compararEmpleados(Empleados e1, Empleados e2, String atributo) {
        switch (atributo) {
            case "nombre":
                return e1.getNombre().compareToIgnoreCase(e2.getNombre());
            case "edad":
                return Integer.compare(e1.getEdad(), e2.getEdad());
            case "salario":
                return Double.compare(e1.getSalario(), e2.getSalario());
            case "departamento":
                return e1.getDepartamento().compareToIgnoreCase(e2.getDepartamento());
            default:
                return 0;
        }
    }
}




package SistemaGestionAvanzada;

import SistemaGestionAvanzada.Empleados;

public class IncreamentarSalario {

    public static Empleados incrementarSalario(Empleados empleado, double porcentaje) {
        double salarioActual = empleado.getSalario();
        double incremento = salarioActual * (porcentaje / 100);
        empleado.setSalario(salarioActual + incremento);
        return empleado;
    }
}



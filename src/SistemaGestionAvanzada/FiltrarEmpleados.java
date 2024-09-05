package SistemaGestionAvanzada;

import SistemaGestionAvanzada.Empleados;
import java.util.ArrayList;
import java.util.List;

public class FiltrarEmpleados {

    public static Empleados[] filtrarEmpleados(Empleados[] empleados, String criterio, Object valor) {
        List<Empleados> resultado = new ArrayList<>();
        for (Empleados e : empleados) {
            switch (criterio) {
                case "nombre":
                    if (e.getNombre().equalsIgnoreCase((String) valor)) {
                        resultado.add(e);
                    }
                    break;
                case "departamento":
                    if (e.getDepartamento().equalsIgnoreCase((String) valor)) {
                        resultado.add(e);
                    }
                    break;
                case "edad":
                    int edad = (int) valor;
                    if (e.getEdad() == edad) {
                        resultado.add(e);
                    }
                    break;
                case "salario":
                    double salario = (double) valor;
                    if (e.getSalario() == salario) {
                        resultado.add(e);
                    }
                    break;
            }
        }
        return resultado.toArray(new Empleados[0]);
    }
}


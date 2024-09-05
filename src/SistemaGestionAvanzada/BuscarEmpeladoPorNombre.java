package SistemaGestionAvanzada;
import SistemaGestionAvanzada.Empleados;

public class BuscarEmpeladoPorNombre {

    public static Empleados buscarPorNombre(Empleados[] empleados, String nombre) {
        for (Empleados e : empleados) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return e;
            }
        }
        return null; // Devuelve null si no se encuentra ningún empleado con el nombre proporcionado
    }
}



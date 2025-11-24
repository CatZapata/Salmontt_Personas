package app;

import model.*;
import service.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("\u001B[34m========================================");
        System.out.println("         SISTEMA SALMONTT");
        System.out.println("========================================\u001B[0m\n");

        String archivo = "empleados.txt";
        GestorEmpleados gestor = new GestorEmpleados();

        // Cargar empleados desde el archivo
        System.out.println("--- Cargando base de datos ---");
        gestor.cargarDesdeArchivo(archivo);

        // Mostrar todos los empleados actuales
        System.out.println("=== LISTA DE EMPLEADOS CARGADOS ===");
        gestor.mostrarEmpleados();

        // Lista de empleados nuevos o actualizaciones
        ArrayList<Empleado> cambios = new ArrayList<>();

        // Actualizar y agregar nuevos empleados
         // ** La menera correcta de usar este apartado es con el RUT, si usas un RUT ya existente entonces se actualizara, si usas uno diferente, se creara un nuevo trabajador
         // Puedes hacerlo de dos en dos
        cambios.add(new Empleado(
                "20.384.892-1",             // RUT del empleado a actualizar IMPORTANTE POR QUE USA EL RUT PARA VERIFICAR EL EMPLEADO
                "Nat", "Fox",
                LocalDate.of(2004, 9, 13),
                new Direccion("Av. Siempre viva","341","Puerto Montt","Los Lagos","Chile","7654321"),
                "natfox@salmontt.cl",
                "+56 9 1111 2222",
                "59000",
                "Asistente de contabilidad",
                "Contabilidad",
                1500000,
                LocalDate.of(2024,10,11)
        ));

        cambios.add(new Empleado(
                "20.349.848-8",             // Para nuevo empleado recuerda usar un RUT diferente
                "Juan", "Perez",
                LocalDate.of(1994, 3, 23),
                new Direccion("Calle nueva vida","939","Puerto Montt","Los Lagos","Chile","7654321"),
                "JuanPerez@salmontt.cl",
                "+56 9 9342 8458",
                "12000",
                "Practicante",
                "Marketing",
                500000,
                LocalDate.of(2025,4,23)
        ));

        // Aplicar cambios: actualizar si existe, agregar si no
        for (Empleado emp : cambios) {
            if (gestor.existeEmpleado(emp.getRut())) {
                gestor.actualizarEmpleado(emp.getRut(), emp);
                System.out.println("\u001B[31mEMPLEADO ACTUALIZADO: " + emp.getRut() + "\u001B[0m\n"); // rojo
            } else {
                gestor.agregarEmpleado(emp);
                System.out.println("\u001B[33mEMPLEADO AGREGADO: " + emp.getRut() + "\u001B[0m\n"); // amarillo
            }
        }

        // Guardar todos los cambios en el archivo
        gestor.guardarEnArchivo(archivo);

        // Mostrar lista final de empleados
        System.out.println("\u001B[36m========================================");
        System.out.println("         LISTA FINAL DE EMPLEADOS");
        System.out.println("========================================\u001B[0m\n");
        gestor.mostrarEmpleados();
    }
}

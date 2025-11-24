package app;

import model.*;
import service.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        System.out.println("\u001B[34m========================================");
        System.out.println("         SISTEMA SALMONTT");
        System.out.println("========================================\u001B[0m\n");

        // Crear gestor que maneja la colección de empleados
        GestorEmpleados gestor = new GestorEmpleados();

        Direccion dir1 = new Direccion("Av. Los Alerces","123", "Puerto Montt", "Los Lagos", "Chile", "1234567");
        Empleado e1 = new Empleado("20.384.892-1","Nat", "Fox",LocalDate.of(2004, 9, 13), dir1, "NatFox@salmontt.cl",
                "+56 9 6545 4568", "59000", "Asistente de contabilidad", "Contabilidad", 1200000, LocalDate.of(2024, 10, 11));
        Direccion dir2 = new Direccion("Av Manuel montt","456", "Puerto Montt", "Los Lagos", "Chile", "1234567");
        Empleado e2 = new Empleado("20.236.254-1","Nathaniel", "Trafalgar",LocalDate.of(2001, 3, 30), dir2, "Nathanieltrafalgar@salmontt.cl",
                "+56 9 1753 5674", "69000", "Diseno de Marketing", "Marketing", 1800000, LocalDate.of(2023, 6, 11));
        Direccion dir3 = new Direccion("Av. Los Alerces","123", "Puerto Montt", "Los Lagos", "Chile", "1234567");
        Empleado e3 = new Empleado("20.452.467-1","Hige", "Tucanazo",LocalDate.of(1992, 8, 9), dir3, "higetucanazo@salmontt.cl",
                "+56 9 4532 5678", "66600", "Director de RRHH", "RRHH", 1500000, LocalDate.of(2022, 4, 24));

        // Para agregar empleados al gestor
        gestor.agregarEmpleado(e1);
        gestor.agregarEmpleado(e2);
        gestor.agregarEmpleado(e3);

        // Guardar empleados en el archivo txt
        gestor.guardarEnArchivo("empleados.txt");

        // Mostras los empleados agregados
        System.out.println("=== EMPLEADOS CREADOS EN MEMORIA ===");
        gestor.mostrarEmpleados();

        // cargar los empleados desde el archivo .txt (empleados.txt)
        gestor.cargarDesdeArchivo("empleados.txt");
        System.out.printf("\u001B[33m===================================================\u001B[0m\n");
        System.out.printf("\u001B[33mDatos repetidos en el archivo,\nSaltar esta parte.\u001B[0m\n");
        System.out.printf("\u001B[33m===================================================\u001B[0m\n\n");

        System.out.println("=== EMPLEADOS DESDE ARCHIVO ===");
        gestor.mostrarEmpleados();

    }
}

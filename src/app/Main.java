package app;

import model.Direccion;
import model.Empleado;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Direccion dir1 = new Direccion("Av. Los Alerces","123", "Puerto Montt", "Los Lagos", "Chile", "1234567");
        Empleado e1 = new Empleado("20.384.892-1","Nat", "Fox",LocalDate.of(2004, 9, 13), dir1, "NatFox@salmontt.cl",
                "+56 9 6545 4568", "59000", "Asistente de contabilidad", "Contabilidad", 1200000, LocalDate.of(2024, 10, 11));
        Direccion dir2 = new Direccion("Av Manuel montt","456", "Puerto Montt", "Los Lagos", "Chile", "1234567");
        Empleado e2 = new Empleado("20.236.254-1","Nathaniel", "Trafalgar",LocalDate.of(2001, 3, 30), dir2, "Nathanieltrafalgar@salmontt.cl",
                "+56 9 1753 5674", "69000", "Diseno de Marketing", "Marketing", 1800000, LocalDate.of(2023, 6, 11));
        Direccion dir3 = new Direccion("Av. Los Alerces","123", "Puerto Montt", "Los Lagos", "Chile", "1234567");
        Empleado e3 = new Empleado("20.452.467-1","Hige", "Tucanazo",LocalDate.of(1992, 8, 9), dir3, "higetucanazo@salmontt.cl",
                "+56 9 4532 5678", "66600", "Director de RRHH", "RRHH", 1500000, LocalDate.of(2022, 4, 24));
        System.out.println("=== INSTANCIAS CREADAS ===\n");

        System.out.println(">> EMPLEADO 1 <<");
        System.out.println(e1);
        System.out.println("---------------------------");

        System.out.println(">> EMPLEADO 2 <<");
        System.out.println(e2);
        System.out.println("---------------------------");

        System.out.println(">> EMPLEADO 3 <<");
        System.out.println(e3);
        System.out.println("===========================");

    }
}

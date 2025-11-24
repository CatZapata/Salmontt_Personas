package service;

import model.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class GestorEmpleados {
    private ArrayList<Empleado> empleados = new ArrayList<>();  // Array para almacenar a los empleados

    // Metodo para agregar manualmente un empleado
    public void agregarEmpleado(Empleado e) {
        empleados.add(e);
    }

    // Ahora para leer el txt
    public void cargarDesdeArchivo(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 6) {
                    Empleado e = new Empleado(  // Datos de empleado standard para antes de la creacion
                            "N/A", datos[1], datos[2],
                            LocalDate.of(1990, 1, 1),
                            new Direccion("Desconocida", "0", "Puerto Montt", "Los Lagos", "Chile", "0000000"),
                            datos[1].toLowerCase() + "@salmontt.cl",
                            "+569 00000000",
                            datos[0], datos[3], "Departamento Desconocido",
                            Double.parseDouble(datos[4]),
                            LocalDate.parse(datos[5])
                    );
                    empleados.add(e);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: formato incorrecto de sueldo.");
        }
    }

    public void mostrarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados para mostrar.");
            return;
        }

        for (Empleado e : empleados) {
            System.out.println("----------------------------------------");
            System.out.println(e);
            System.out.println("----------------------------------------\n");
        }
    }


    // Guarda todos los empleados actuales en el archivo .txt
    public void guardarEnArchivo(String rutaArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {

            // Arreglando para que se vea mucho mas legible en el txt
                //Cabecera
            bw.write(String.format("%-8s %-15s %-15s %-30s %-12s %-15s%n",
                    "ID", "Nombre", "Apellido", "Cargo", "Sueldo", "Ingreso"));
            bw.write("---------------------------------------------------------------------------------------------\n");

              // Filas de empleados
            for (Empleado e : empleados) {
                bw.write(String.format("%-8s %-15s %-15s %-30s %-12.0f %-15s%n",
                        e.getIdEmpleado(),
                        e.getNombre(),
                        e.getApellido(),
                        e.getCargo(),
                        e.getSueldo(),
                        e.getFechaIngreso()));
            }

            System.out.println("Empleados guardados correctamente en: " + rutaArchivo);

        } catch (IOException e) {
            System.out.println("Error al guardar empleados: " + e.getMessage());
        }
    }
}


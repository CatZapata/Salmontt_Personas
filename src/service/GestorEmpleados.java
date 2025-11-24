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
        for (Empleado e : empleados) {
            System.out.println(e);
            System.out.println("---------------------------");
        }
    }

    // Guarda todos los empleados actuales en el archivo .txt
    public void guardarEnArchivo(String rutaArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {  // sin true para que reemplace lo anterior
            for (Empleado e : empleados) {
                bw.write(e.getIdEmpleado() + ";" +
                        e.getNombre() + ";" +
                        e.getApellido() + ";" +
                        e.getCargo() + ";" +
                        e.getSueldo() + ";" +
                        e.getFechaIngreso() + "\n");
            }
            System.out.println("Empleados guardados correctamente en " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar empleados: " + e.getMessage());
        }
    }
}


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

    // Edicion y lectura del archivo Txt para creacion de empleados
    public void cargarDesdeArchivo(String rutaArchivo) {
        empleados.clear();  // Limpiar empleados actuales para reflejar solo los del archivo
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea = br.readLine();
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 16) {
                    Direccion dir = new Direccion(
                            datos[3],  // Calle
                            datos[4],  // Número
                            datos[5],  // Ciudad
                            datos[6],  // Región
                            datos[7],  // País
                            datos[8]   // Código postal
                    );

                    Empleado e = new Empleado(
                            datos[0],   // RUT
                            datos[1],   // Nombre
                            datos[2],   // Apellido
                            LocalDate.of(1990, 1, 1), // Fecha nacimiento por defecto
                            dir,        // Dirección
                            datos[13],  // Email
                            datos[14],  // Teléfono
                            datos[15],  // ID empleado
                            datos[9],   // Cargo
                            datos[10],  // Departamento
                            Double.parseDouble(datos[11]), // Sueldo
                            LocalDate.parse(datos[12])     // Fecha ingreso
                    );
                    empleados.add(e);
                }
            }
            System.out.println("Empleados cargados correctamente desde: " + rutaArchivo);
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
            // Para que reescriba en el txt
            bw.write("RUT;Nombre;Apellido;Calle;Numero;Ciudad;Region;Pais;CP;Cargo;Departamento;Sueldo;FechaIngreso;Email;Telefono;ID\n");
            for (Empleado e : empleados) {
                bw.write(String.join(";",
                        e.getRut(),           // 0 RUT
                        e.getNombre(),               // 1 Nombre
                        e.getApellido(),             // 2 Apellido
                        e.getDireccion().getCalle(), // 3 Calle
                        e.getDireccion().getNumero(),// 4 Número
                        e.getDireccion().getCiudad(),// 5 Ciudad
                        e.getDireccion().getRegion(),// 6 Región
                        e.getDireccion().getPais(),  // 7 País
                        e.getDireccion().getCodigoPostal(), // 8 Codigo Postal
                        e.getCargo(),                // 9 Cargo
                        e.getDepartamento(),         // 10 Departamento
                        String.valueOf((int) e.getSueldo()), // 11 Sueldo
                        e.getFechaIngreso().toString(),     // 12 Fecha Ingreso
                        e.getEmail(),                // 13 Email
                        e.getTelefono(),             // 14 Telefono
                        e.getIdEmpleado()            // 15 ID empleado
                ));
                bw.newLine();
            }

            System.out.println("Empleados guardados correctamente en: " + rutaArchivo + "\n");

        } catch (IOException ex) {
            System.out.println("Error al guardar empleados: " + ex.getMessage());
        }
    }

    // Metodo auxiliar para verificar existencia (usado en Main)
    public boolean existeEmpleado(String rut) {
        for (Empleado e : empleados) {
            if (e.getRut().equalsIgnoreCase(rut)) {
                return true;
            }
        }
        return false;
    }

    // Actualiza un empleado existente por RUT
    public boolean actualizarEmpleado(String rut, Empleado nuevoEmpleado) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getRut().equalsIgnoreCase(rut)) {
                empleados.set(i, nuevoEmpleado);
                return true; // actualizado correctamente
            }
        }
        return false; // no se encontró
    }
}


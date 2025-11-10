package model;

import java.time.LocalDate;

public class Empleado extends Persona {
    // Atributos encapsulados y privados
    private String idEmpleado;
    private String cargo;
    private String departamento;
    private double sueldo;
    private LocalDate fechaIngreso;
// Constructor
    public Empleado(String rut, String nombre, String apellido, LocalDate fechaNacimiento, Direccion direccion, String email, String telefono,
                    String idEmpleado, String cargo, String departamento, double sueldo, LocalDate fechaIngreso) {
        super(rut, nombre, apellido, fechaNacimiento, direccion, email, telefono); //super usado para llamar al constructor de la clase Persona
        this.idEmpleado = idEmpleado;
        this.cargo = cargo;
        this.departamento = departamento;
        this.sueldo = sueldo;
        this.fechaIngreso = fechaIngreso;
    }
    // Getters y Setters
    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    // nuevamente Override para que en consola se vea mas legible lo que se imprime
    @Override
    public String toString() {
        return "Empleado { ID: " + idEmpleado + ", Cargo: " + cargo + ", Departamento: " + departamento + ", Sueldo: " + sueldo + ", FechaIngreso: " + (fechaIngreso != null ? fechaIngreso.toString() : "N/A") + " } - " + super.toString();
    }
}


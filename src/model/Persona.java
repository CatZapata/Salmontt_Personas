package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Persona {
    // Atributos encapsulados y privados
    private String rut;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private Direccion direccion;
    private String email;
    private String telefono;

    //Contructor
    public Persona(String rut, String nombre, String apellido, LocalDate fechaNacimiento, Direccion direccion, String email, String telefono) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
    }

    // Getters y Setters
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombreCompleto() {
        return (nombre != null ? nombre : "") + " " + (apellido != null ? apellido : "");
    }

    // override para legibilidad
    @Override
    public String toString() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Persona { " +
                "RUT: " + (rut != null ? rut : "N/A") +
                ", Nombre: " + (getNombreCompleto().trim().isEmpty() ? "N/A" : getNombreCompleto()) +
                ", Nac: " + (fechaNacimiento != null ? fechaNacimiento.format(f) : "N/A") +
                ", Direccion: " + (direccion != null ? direccion.toString() : "N/A") +
                ", Email: " + (email != null ? email : "N/A") +
                ", Tel: " + (telefono != null ? telefono : "N/A") +
                " }";
    }
}
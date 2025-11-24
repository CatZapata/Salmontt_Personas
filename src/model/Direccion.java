package model;

public class Direccion {
    // Atributos encapsulados y privados
    private String calle;
    private String numero;
    private String ciudad;
    private String region;
    private String pais;
    private String codigoPostal;
// Constructor
    public Direccion(String calle, String numero, String ciudad, String region, String pais, String codigoPostal) {
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
        this.region = region;
        this.pais = pais;
        this.codigoPostal = codigoPostal;
    }
    // Getters y Setters
    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    // Override para que en consola se vea mas legible lo que se imprime
    @Override
    public String toString() {
        return (calle != null ? calle : "N/A") + " " + // Se anade null por si los espacios quedan vacios
                (numero != null ? numero : "N/A") + ", " +
                (ciudad != null ? ciudad : "N/A") + ", " +
                (region != null ? region : "N/A") + ", " +
                (pais != null ? pais : "N/A") + " (CP: " +
                (codigoPostal != null ? codigoPostal : "N/A") + ")";
    }
}

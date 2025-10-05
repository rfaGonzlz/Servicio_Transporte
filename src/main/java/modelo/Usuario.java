package modelo;

public abstract class Usuario {

    private  String nombre, cedula, telefono;

    public Usuario() {
    }

    public Usuario(String telefono, String cedula, String nombre) {
        this.telefono = telefono;
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "NOMBRE: " + nombre + " | CEDULA: " + cedula + " | TELEFONO: " +  telefono  ;
    }
}

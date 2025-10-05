package modelo;

public class Cliente extends Usuario {

     private String correo;

    public Cliente() {
    }

    public Cliente(String telefono, String cedula, String nombre, String correo) {
        super(telefono, cedula, nombre);
        this.correo = correo;
    }


    public String getCorreo() {
        return correo;
    }

    @Override
    public String toString() {
        return "CORREO: " + correo ;
    }
}
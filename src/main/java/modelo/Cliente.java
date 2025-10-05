package modelo;


// La clase Cliente hereda de la clase Usuario
public class Cliente extends Usuario {

    // Atributo propio de la clase
     private String correo;


    // Constructor vacío
    public Cliente() {
    }

    // Constructor con parámetros
    public Cliente(String telefono, String cedula, String nombre, String correo) {
        super(telefono, cedula, nombre);
        this.correo = correo;
    }

    // Método getter
    public String getCorreo() {
        return correo;
    }

}


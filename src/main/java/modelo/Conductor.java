package modelo;

// La clase Conductor hereda de la clase Usuario
public class Conductor extends Usuario {


    // Atributos propios de la clase
    private String licencia;

    private boolean estado;

    // Atributos propios del conductor
    public Conductor() {
    }

    // Constructor con parámetros
    public Conductor(String telefono, String cedula, String nombre, String licencia, boolean estado) {
        super(telefono, cedula, nombre);
        this.licencia = licencia;
        this.estado = estado;
    }

    // Métodos getters
    public String getLicencia() {
        return licencia;
    }

    public boolean isEstado() {
        return estado;
    }

    // Método que devuelve la información completa del conductor como texto
    @Override
    public String toString() {
        return "NOMBRE: " + getNombre() + " | CEDULA: " + getCedula() +
                " | TELEFONO: " + getTelefono() +
                " | LICENCIA: " + licencia +
                " | ESTADO: " +  estado;
    }

}

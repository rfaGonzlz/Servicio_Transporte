package modelo;

public class Conductor extends Usuario {

    private String licencia;

    private boolean estado;

    public Conductor() {
    }

    public Conductor(String telefono, String cedula, String nombre, String licencia, boolean estado) {
        super(telefono, cedula, nombre);
        this.licencia = licencia;
        this.estado = estado;
    }

    public String getLicencia() {
        return licencia;
    }

    public boolean isEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "LICENCIA: " + licencia + " | ESTADO: " + estado;
    }

}

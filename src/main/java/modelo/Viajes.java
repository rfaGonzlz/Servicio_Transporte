package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import excepciones.AsientosInsuficientes;

public class Viajes {

    private Vehiculo vehiculo;
    private Conductor conductor;
    private String origen;
    private String destino;
    private LocalDateTime fechaSalida;
    private List<Cliente> clientes;

    public Viajes(Vehiculo vehiculo, String origen, String destino, LocalDateTime fechaSalida, Conductor conductor) {
        this.vehiculo = vehiculo;
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.conductor = conductor;
        this.clientes = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) throws AsientosInsuficientes, IllegalArgumentException {
        for (Cliente cli : clientes) {
            if (cli.getCedula().equals(cliente.getCedula())) {
                throw new IllegalArgumentException("Ya existe un cliente con cedula: " + cliente.getCedula());
            }
            if (cli.getAsiento() == cliente.getAsiento()) {
                throw new IllegalArgumentException("El asiento " + cliente.getAsiento() + " ya está ocupado.");
            }
        }
        if (clientes.size() < vehiculo.getCapacidad()) {
            clientes.add(cliente);
        } else {
            throw new AsientosInsuficientes("No hay asientos disponibles.");
        }
    }

    public void eliminarClientePorCedula(String cedula) {
        clientes.removeIf(cliente -> cliente.getCedula().equals(cedula));
    }

    // Cambia el tipo de retorno a double para evitar el error de tipos
    public double calcularIngresos() {
        return clientes.size() * vehiculo.calcularTarifa();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }
}
package modelo;

import java.util.ArrayList;
import java.util.List;

public class Viajes {

    private String id;
    private String origen;
    private String destino;
    private Vehiculo vehiculo; // Relación de composición con Vehiculo
    private Conductor conductor; // Relación de composición con Conductor
    private List<Cliente> clientes; // Relación de agregación con Cliente
    private double tarifaBase;

    public Viajes(String id, String origen, String destino, Vehiculo vehiculo, Conductor conductor, double tarifaBase) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.vehiculo = vehiculo;
        this.conductor = conductor;
        this.clientes = new ArrayList<>();
        this.tarifaBase = tarifaBase;
    }

    // Métodos para agregar y eliminar clientes
    public boolean agregarCliente(Cliente cliente) {
        if (clientes.size() < vehiculo.getCapacidad()) {
            clientes.add(cliente);
            return true;
        } else {
            return false;
        }
    }

    public double calcularCostoPorCliente(){
        int ocupados = Math.max(1, clientes.size()); // Evitar división por cero
        return tarifaBase / ocupados;
    }

    // Getters

    public String getId() {return id;}
    public List<Cliente> getClientes() {return clientes; }
    public Vehiculo getVehiculo() {return vehiculo; }
    public Conductor getConductor() {return conductor; }

    @Override
    public String toString() {
        return String.format("Viaje ID: %s, Origen: %s, Destino: %s, Vehículo: [%s], Conductor: [%s], Clientes: %d, Tarifa Base: %.2f",
                id, origen, destino, vehiculo, conductor, clientes.size(), tarifaBase);
    }
}

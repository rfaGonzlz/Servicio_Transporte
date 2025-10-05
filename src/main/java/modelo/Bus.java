package modelo;


//implementacion concreta de Vehiculo para buses.

public class Bus extends Vehiculo {
    // Constructor que define capacidad y tarifa por defecto para bus
    public Bus() {
        this.capacidad = 40;     // numero tipico de asientos en el ejemplo
        this.tarifaBase = 50000; // tarifa por pasajero
    }

    // Retorna la tarifa base del bus
    @Override
    public double calcularTarifa() {
        return tarifaBase;
    }
}
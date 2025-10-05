package modelo;


 //implementacion concreta de Vehiculo para minivan.

public class Minivan extends Vehiculo {
    // constructor que define capacidad y tarifa para minivan
    public Minivan() {
        this.capacidad = 10;     // capacidad menor
        this.tarifaBase = 20000; // tarifa menor
    }

    // Retorna la tarifa base de la minivan
    @Override
    public double calcularTarifa() {
        return tarifaBase;
    }
}
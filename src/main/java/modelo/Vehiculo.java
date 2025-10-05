package modelo;


 //Clase abstracta Vehiculo.
//Define atributos generales de cualquier vehículo (capacidad y tarifa base).

public abstract class Vehiculo {
    protected int capacidad;     // cantidad de asientos disponibles
    protected double tarifaBase; // tarifa por pasajero

    // Metodo abstracto que debe implementar cada subclase
    // retorna la tarifa por pasajero según el tipo de vehículo
    public abstract double calcularTarifa();

    // Getter para la capacidad
    public int getCapacidad() {
        return capacidad;
    }

}


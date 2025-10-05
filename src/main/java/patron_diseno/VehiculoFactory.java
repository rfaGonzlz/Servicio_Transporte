package patron_diseno;

import modelo.*;
public class VehiculoFactory {
    public static Vehiculo crearVehiculo(int tipo) {
        switch (tipo) {
            case 1: return new Bus();
            case 2: return new Minivan();
            default: throw new IllegalArgumentException("Tipo de vehículo no válido");
        }
    }
}


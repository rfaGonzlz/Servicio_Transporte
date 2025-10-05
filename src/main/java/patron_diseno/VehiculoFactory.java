package patron_diseno;

//Factory simple para crear instancias de Vehiculo segun un código (1 = Bus, 2 = Minivan).

import modelo.*;
public class VehiculoFactory {
    // Crea y retorna un Vehiculo según el tipo indicado
    public static Vehiculo crearVehiculo(int tipo) {
        switch (tipo) {
            case 1: return new Bus();// si 1 devuelve Bus
            case 2: return new Minivan();// si 2 devuelve Minivan
            default: // si el tipo no es válido, lanzamos IllegalArgumentException

                throw new IllegalArgumentException("este tipo de vehículo no valido");
        }
    }
}


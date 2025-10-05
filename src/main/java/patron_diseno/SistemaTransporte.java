package patron_diseno;

import java.util.ArrayList;
import java.util.List;
import modelo.Viajes;

//Singleton que administra la colección de viajes del sistema.

public class SistemaTransporte {
    private static SistemaTransporte instancia; // instancia única
    private List<Viajes> viajes = new ArrayList<>(); // almacenamiento en memoria

    // Constructor privado para forzar patrón Singleton
    private SistemaTransporte() {}

    // Devuelve la instancia única,  si es necesario
    public static SistemaTransporte getInstancia() {
        if (instancia == null) {
            instancia = new SistemaTransporte();
        }
        return instancia;
    }
    // Agrega un viaje a la lista
    public void agregarViaje(Viajes v) {
        viajes.add(v);
    }
    // Retorna la lista de viajes
    public List<Viajes> getViajes() {
        return viajes;
    }
}

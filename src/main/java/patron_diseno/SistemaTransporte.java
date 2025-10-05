package patron_diseno;

import java.util.ArrayList;
import java.util.List;
import modelo.Viajes;

public class SistemaTransporte {
    private static SistemaTransporte instancia;
    private List<Viajes> viajes = new ArrayList<>();

    private SistemaTransporte() {}

    public static SistemaTransporte getInstancia() {
        if (instancia == null) {
            instancia = new SistemaTransporte();
        }
        return instancia;
    }

    public void agregarViaje(Viajes v) {
        viajes.add(v);
    }

    public List<Viajes> getViajes() {
        return viajes;
    }
}

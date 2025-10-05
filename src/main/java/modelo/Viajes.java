// Paquete donde se encuentra la clase
package modelo;

// Importación de clases necesarias
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import excepciones.AsientosInsufiientes; // Corrige el nombre de la excepción

// Clase Viajes que representa un viaje en el sistema de transporte
public class Viajes {

    private Vehiculo vehiculo; // Vehículo asociado al viaje
    private Conductor conductor; // Conductor asociado al viaje
    private String origen; //Ciudad de origen del viaje
    private String destino; // Ciudad de destino del viaje
    private LocalDateTime fechaSalida; // Fecha y hora de salida del viaje
    private List<Cliente> clientes; // Lista de clientes que participan en el viaje


    // Constructor de la clase Viajes
    public Viajes(Vehiculo vehiculo, String origen, String destino, LocalDateTime fechaSalida, Conductor conductor) {
        this.vehiculo = vehiculo;
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.conductor = conductor;
        this.clientes = new ArrayList<>(); // Inicializa la lista de clientes como una lista vacía
    }

    // Metodo para agregar un cliente al viaje
    public void agregarCliente(Cliente cliente) throws AsientosInsufiientes, IllegalArgumentException {
        for (Cliente cli : clientes) {
            // Verificar si la cedula ya existe
            if (cli.getCedula().equals(cliente.getCedula())) {
                throw new IllegalArgumentException("Ya existe un cliente con cedula: " + cliente.getCedula());
            }
            // Verificar si el asiento ya está ocupado
            if (cli.getAsiento() == cliente.getAsiento()) {
                throw new IllegalArgumentException("El asiento " + cliente.getAsiento() + " ya está ocupado.");
            }
            // Verificar si hay asientos disponibles
            if (clientes.size() < vehiculo.getCapacidad()) {
                clientes.add(cliente);
            } else {
                throw new AsientosInsufiientes("No hay asientos disponibles.");
            }
        }
    }

    // Metodo para eliminar un cliente del viaje por su cedula
    public void eliminarClientePorCedula(String cedula) {
        clientes.removeIf(cliente -> cliente.getCedula().equals(cedula));
    }

    // Metodo para calcular los ingresos totales del viaje
    public int calcularIngresos() {
        return clientes.size() * (int) vehiculo.calcularTarifa();
    }

    // Getters para la lista de clientes.
public List<Cliente> getClientes() {
    return clientes;}
}
// Getters para el vehiculo.
public Vehiculo getVehiculo() {;
    return vehiculo;
}

// Getters para el origen.
public String getOrigen() {
    return origen;
}

// Getters para el destino.
public String getDestino() {
    return destino;
}

// Getters para la fecha de salida.
public LocalDateTime getFechaSalida() {
    return fechaSalida;
}

// Gettsers para el conductor.
public Conductor getConductor() {
    return conductor;
}

// Setters para el conductor.
public void SetConductor(Conductor conductor) {
    this.conductor = conductor;
}
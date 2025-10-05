// Paquete donde se encuentra la clase
package modelo;

// Importaciones necesarias para fechas y colecciones
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
// Importación de la excepción personalizada
import excepciones.AsientosInsuficientes;

// Clase que representa un viaje en el sistema
public class Viajes {

    // Vehículo asignado al viaje
    private Vehiculo vehiculo;
    // Conductor asignado al viaje
    private Conductor conductor;
    // Ciudad de origen
    private String origen;
    // Ciudad de destino
    private String destino;
    // Fecha y hora de salida
    private LocalDateTime fechaSalida;
    // Lista de clientes en el viaje
    private List<Cliente> clientes;

    // Constructor de la clase Viajes
    public Viajes(Vehiculo vehiculo, String origen, String destino, LocalDateTime fechaSalida, Conductor conductor) {
        this.vehiculo = vehiculo;
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.conductor = conductor;
        this.clientes = new ArrayList<>(); // Inicializa la lista de clientes
    }

    // Método para agregar un cliente al viaje
    public void agregarCliente(Cliente cliente) throws AsientosInsuficientes, IllegalArgumentException {
        for (Cliente cli : clientes) {
            // Verifica si la cédula ya está registrada
            if (cli.getCedula().equals(cliente.getCedula())) {
                throw new IllegalArgumentException("Ya existe un cliente con cedula: " + cliente.getCedula());
            }
            // Verifica si el asiento ya está ocupado
            if (cli.getAsiento() == cliente.getAsiento()) {
                throw new IllegalArgumentException("El asiento " + cliente.getAsiento() + " ya está ocupado.");
            }
        }
        // Verifica si hay asientos disponibles
        if (clientes.size() < vehiculo.getCapacidad()) {
            clientes.add(cliente); // Agrega el cliente a la lista
        } else {
            throw new AsientosInsuficientes("No hay asientos disponibles.");
        }
    }

    // Método para eliminar un cliente por su cédula
    public void eliminarClientePorCedula(String cedula) {
        clientes.removeIf(cliente -> cliente.getCedula().equals(cedula));
    }

    // Método para calcular los ingresos totales del viaje
    public double calcularIngresos() {
        // Multiplica la cantidad de clientes por la tarifa del vehículo
        return clientes.size() * vehiculo.calcularTarifa();
    }

    // Getter para la lista de clientes
    public List<Cliente> getClientes() {
        return clientes;
    }

    // Getter para el vehículo
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    // Getter para el origen
    public String getOrigen() {
        return origen;
    }

    // Getter para el destino
    public String getDestino() {
        return destino;
    }

    // Getter para la fecha de salida
    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    // Getter para el conductor
    public Conductor getConductor() {
        return conductor;
    }

    // Setter para el conductor
    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }
}
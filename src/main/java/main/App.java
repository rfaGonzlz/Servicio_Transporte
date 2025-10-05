package main;
import javax.swing.*;
import modelo.*;
import patron_diseno.*;

public class App {
    public static void main(String[] args) {
        SistemaTransporte sistema = SistemaTransporte.getInstancia();

        int opcion = 0;

        do {
            try {
                String input = JOptionPane.showInputDialog(
                        "Menu Sistema de Transporte\n" +
                                "1. Crear Viaje\n" +
                                "2. Agregar cliente al viaje\n" +
                                "3. Salir\n" +
                                "Ingrese una opción (1-3):");

                if (input == null) {
                    break; // Salir si el usuario cancela
                }

                opcion = Integer.parseInt(input.trim());

                switch (opcion) {
                    case 1:
                        // Crear viaje
                        String id = JOptionPane.showInputDialog("Ingrese ID del viaje:");
                        String origen = JOptionPane.showInputDialog("Ingrese origen:");
                        String destino = JOptionPane.showInputDialog("Ingrese destino:");
                        String vehiculoTipoStr = JOptionPane.showInputDialog("Ingrese tipo de vehículo (1=Bus, 2=Minivan):");
                        int vehiculoTipo = Integer.parseInt(vehiculoTipoStr.trim());
                        Vehiculo vehiculo = VehiculoFactory.crearVehiculo(vehiculoTipo);

                        String conductorNombre = JOptionPane.showInputDialog("Ingrese nombre del conductor:");
                        String conductorLicencia = JOptionPane.showInputDialog("Ingrese licencia del conductor:");
                        Conductor conductor = new Conductor(conductorNombre, conductorLicencia);

                        String tarifaBaseStr = JOptionPane.showInputDialog("Ingrese tarifa base:");
                        double tarifaBase = Double.parseDouble(tarifaBaseStr.trim());

                        Viajes viaje = new Viajes(id, origen, destino, vehiculo, conductor, tarifaBase);
                        sistema.agregarViaje(viaje);
                        JOptionPane.showMessageDialog(null, "Viaje creado exitosamente:\n" + viaje);
                        break;

                    case 2:
                        // Agregar cliente al viaje
                        String viajeId = JOptionPane.showInputDialog("Ingrese ID del viaje para agregar cliente:");
                        Viajes viajeSeleccionado = null;
                        for (Viajes v : sistema.getViajes()) {
                            if (v.getId().equals(viajeId)) {
                                viajeSeleccionado = v;
                                break;
                            }
                        }
                        if (viajeSeleccionado == null) {
                            JOptionPane.showMessageDialog(null, "Viaje no encontrado.");
                            break;
                        }

                        String clienteNombre = JOptionPane.showInputDialog("Ingrese nombre del cliente:");
                        String clienteContacto = JOptionPane.showInputDialog("Ingrese contacto del cliente:");
                        Cliente cliente = new Cliente(clienteNombre, clienteContacto);

                        if (viajeSeleccionado.agregarCliente(cliente)) {
                            double costoPorCliente = viajeSeleccionado.calcularCostoPorCliente();
                            JOptionPane.showMessageDialog(null, "Cliente agregado exitosamente.\nCosto por cliente: " + costoPorCliente);
                        } else {
                            JOptionPane.showMessageDialog(null, "No se pudo agregar el cliente. Capacidad máxima alcanzada.");
                        }
                        break;

                    case 3:
                        // Salir
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida.");
                        break;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        } while (opcion != 3);
    }
}

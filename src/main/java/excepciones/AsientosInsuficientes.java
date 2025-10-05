package excepciones;



//Excepcion cuando no hay asientos disponibles en un viaje.

public class AsientosInsuficientes extends Exception {


     //Crea la excepcion con un mensaje.
     //mensaje texto descriptivo del error

    public AsientosInsuficientes(String mensaje) {
        super(mensaje);
    }
}

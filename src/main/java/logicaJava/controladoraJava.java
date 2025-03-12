package logicaJava;

import java.util.List;
import persistenciaDB.controladoraPersistenciaJava;


public class controladoraJava {
    controladoraPersistenciaJava controlPersistence = new controladoraPersistenciaJava();
    
    
    //Esta es nuestra controladora con los 3 métodos necesarios
    
    //Crear una reserva, el cual recibe un parámetro de tipo clase, y lo envia a la controladora de persistencia
    public void crearReserva(claseReservasJava reserva){
        controlPersistence.crearReserva(reserva);
    }
    //Traer reservas, el cual retorna el valor que haya retornado el método de traer reservas de la controladora de persistencia
    public List<claseReservasJava> traerReservas(){
        return controlPersistence.traerReservas();
    }
    //Eliminar una reserva, el cual recibe un parámetro de tipo entero, y lo envia a la controladora de persistencia para hacer la eliminación de la data base
    public void eliminarReserva(int id){
        controlPersistence.eliminarReserva(id);
    }
}

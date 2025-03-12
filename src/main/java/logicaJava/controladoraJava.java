package logicaJava;

import persistenciaDB.controladoraPersistenciaJava;


public class controladoraJava {
    controladoraPersistenciaJava controlPersistence = new controladoraPersistenciaJava();
    public void crearReserva(claseReservasJava reserva){
        controlPersistence.crearReserva(reserva);
    }
}

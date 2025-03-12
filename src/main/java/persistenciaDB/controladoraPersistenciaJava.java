package persistenciaDB;

import logicaJava.claseReservasJava;


public class controladoraPersistenciaJava {
    claseReservasJavaJpaController claseReservasJPA = new claseReservasJavaJpaController();
    
    public void crearReserva(claseReservasJava reserva){
        claseReservasJPA.create(reserva);
    }
}

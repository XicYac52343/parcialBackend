package persistenciaDB;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logicaJava.claseReservasJava;
import persistenciaDB.exceptions.NonexistentEntityException;


public class controladoraPersistenciaJava {
    claseReservasJavaJpaController claseReservasJPA = new claseReservasJavaJpaController();
    
    //Esta es nuestra controladora con los 3 métodos necesarios
    
    //Crear una reserva, el cual recibe un parámetro de tipo clase desde la controladora, y lo envia al JPA controller para crear el nuevo registro con el dato del parámetro
    public void crearReserva(claseReservasJava reserva){
        claseReservasJPA.create(reserva);
    }
    
    //Traer reservas, el cual retorna el valor que haya retornado el método de findClaseReservas... del JPA controller
    public List<claseReservasJava> traerReservas(){
        return claseReservasJPA.findclaseReservasJavaEntities();
    }
    
    //Eliminar una reserva, el cual recibe un parámetro de tipo entero, y lo envia al JPA controller para hacer la eliminación de la data base
    public void eliminarReserva(int id){
        
        //Es importante tener el try catch, porque no funcionará debido a que se puede generar una excepción de que no se encontró el registro o entidad buscado
        try{
            claseReservasJPA.destroy(id);
        }catch(NonexistentEntityException ex){
            Logger.getLogger(controladoraPersistenciaJava.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
